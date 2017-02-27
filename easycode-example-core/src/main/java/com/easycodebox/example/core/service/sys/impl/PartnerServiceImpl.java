package com.easycodebox.example.core.service.sys.impl;

import com.easycodebox.common.enums.entity.OpenClose;
import com.easycodebox.common.enums.entity.YesNo;
import com.easycodebox.common.idconverter.UserIdConverter;
import com.easycodebox.common.idgenerator.IdGenerators;
import com.easycodebox.common.lang.dto.DataPage;
import com.easycodebox.common.validate.Assert;
import com.easycodebox.example.core.service.sys.PartnerService;
import com.easycodebox.example.core.util.CodeMsgExt;
import com.easycodebox.example.core.util.Constants;
import com.easycodebox.example.model.entity.sys.Partner;
import com.easycodebox.example.model.enums.IdGeneratorEnum;
import com.easycodebox.example.model.util.R;
import com.easycodebox.jdbc.support.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author WangXiaoJin
 *
 */
@Service
public class PartnerServiceImpl extends AbstractServiceImpl<Partner> implements PartnerService {

	@Autowired
	private UserIdConverter userIdConverter;
	
	@Override
	public List<Partner> list() {
		return super.list(sql()
				.eq(R.Partner.deleted, YesNo.NO)
				.desc(R.Partner.sort)
				.desc(R.Partner.createTime)
				);
	}

	@Override
	@Cacheable(Constants.CN.PARTNER)
	public Partner load(String id) {
		Partner data = super.get(sql()
				.eqAst(R.Partner.id, id)
				.eq(R.Partner.deleted, YesNo.NO)
				);
		if (data != null) {
			data.setCreatorName(userIdConverter.idToRealOrNickname(data.getCreator()));
			data.setModifierName(userIdConverter.idToRealOrNickname(data.getModifier()));
		}
		return data;
	}

	@Override
	@Transactional
	public Partner add(Partner partner) {
		
		Assert.isFalse(this.existName(partner.getName(), partner.getId()),
				CodeMsgExt.FAIL.msg("合作商名{0}已被占用", partner.getName()));
		
		partner.setPartnerKey((String) IdGenerators.nextVal(IdGeneratorEnum.KEY));
		if(partner.getStatus() == null)
			partner.setStatus(OpenClose.OPEN);
		if(partner.getSort() == null)
			partner.setSort(0);
		partner.setDeleted(YesNo.NO);
		super.save(partner);
		return partner;
	}
	
	@Override
	@Transactional
	@CacheEvict(cacheNames=Constants.CN.PARTNER, key="#partner.id")
	public int update(Partner partner) {
		Assert.isFalse(this.existName(partner.getName(), partner.getId()),
				CodeMsgExt.FAIL.msg("合作商名{0}已被占用", partner.getName()));
		
		if(partner.getStatus() != null) {
			log.info("The update method can not update status property.");
		}
		
		return super.update(sql()
				.upd(R.Partner.name, partner.getName())
				.upd(R.Partner.website, partner.getWebsite())
				.upd(R.Partner.sort, partner.getSort())
				.upd(R.Partner.contract, partner.getContract())
				.upd(R.Partner.remark, partner.getRemark())
				.eqAst(R.Partner.id, partner.getId()));
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames=Constants.CN.PARTNER, keyGenerator= Constants.MULTI_KEY_GENERATOR)
	public int remove(String[] ids) {
		return super.delete(ids);
	}
	
	@Override
	@Transactional
	@CacheEvict(cacheNames=Constants.CN.PARTNER, keyGenerator=Constants.MULTI_KEY_GENERATOR)
	public int removePhy(String[] ids) {
		return super.deletePhy(ids);
	}

	@Override
	public DataPage<Partner> page(String name, String partnerKey, 
			String website, OpenClose status, int pageNo, int pageSize) {
		return super.page(sql()
				.likeTrim(R.Partner.name, name)
				.likeTrim(R.Partner.partnerKey, partnerKey)
				.likeTrim(R.Partner.website, website)
				.eq(R.Partner.status, status)
				.eq(R.Partner.deleted, YesNo.NO)
				.desc(R.Partner.sort)
				.desc(R.Partner.createTime)
				.limit(pageNo, pageSize));
	}
	
	@Override
	public boolean existName(String name, String excludeId) {
		return this.exist(sql()
				.eqAst(R.Partner.name, name)
				.eq(R.Partner.deleted, YesNo.NO)
				.ne(R.Partner.id, excludeId)
				);
	}
	
	@Override
	@Transactional
	@CacheEvict(cacheNames=Constants.CN.PARTNER, keyGenerator=Constants.MULTI_KEY_GENERATOR)
	public int openClose(String[] ids, OpenClose status) {
		return super.updateStatus(ids, status);
	}
	
}

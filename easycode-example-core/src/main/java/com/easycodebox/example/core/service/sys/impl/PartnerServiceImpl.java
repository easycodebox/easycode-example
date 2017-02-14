package com.easycodebox.example.core.service.sys.impl;

import com.easycodebox.common.enums.entity.OpenClose;
import com.easycodebox.common.enums.entity.YesNo;
import com.easycodebox.common.generator.Generators;
import com.easycodebox.common.lang.dto.DataPage;
import com.easycodebox.common.validate.Assert;
import com.easycodebox.example.core.idconverter.UserIdConverter;
import com.easycodebox.example.core.service.sys.PartnerService;
import com.easycodebox.example.core.util.CodeMsgExt;
import com.easycodebox.example.model.entity.sys.Partner;
import com.easycodebox.example.model.util.R;
import com.easycodebox.example.model.enums.GeneratorEnum;
import com.easycodebox.jdbc.support.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WangXiaoJin
 *
 */
@Service("partnerService")
public class PartnerServiceImpl extends AbstractServiceImpl<Partner> implements PartnerService {

	@Resource
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
		
		partner.setPartnerKey((String)Generators.getGeneratorNextVal(GeneratorEnum.KEY));
		if(partner.getStatus() == null)
			partner.setStatus(OpenClose.OPEN);
		if(partner.getSort() == null)
			partner.setSort(0);
		partner.setDeleted(YesNo.NO);
		super.save(partner);
		return partner;
	}
	
	@Override
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
	public int remove(String[] ids) {
		return super.delete(ids);
	}
	
	@Override
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
	public int openClose(String[] ids, OpenClose status) {
		return super.updateStatus(ids, status);
	}
	
}

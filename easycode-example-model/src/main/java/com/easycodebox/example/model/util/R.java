package com.easycodebox.example.model.util;

import static com.easycodebox.jdbc.Property.instance;

import com.easycodebox.jdbc.Property;
import com.easycodebox.jdbc.entity.Entity;

/**
 * <b>直接运行{@link com.easycodebox.jdbc.res.GenerateBeanRes}类会自动生成R文件的。</b>
 * <p>如果是Entity类，会生成private static final Class<? extends Entity> entity = com.easycodebox.core.pojo.xxx.xxx.class
 * 和Property属性【public static final Property id = instance("id", entity)】
 * <p>如果只是普通的BO对象，则：public static final String id = "id";
 * @author WangXiaoJin
 *
 */
public class R {

	public static class Generator {
	
		private static final Class<? extends Entity> entity = com.easycodebox.example.model.entity.sys.Generator.class;
		public static final Property 
			generatorType = instance("generatorType", entity),
			initialVal = instance("initialVal", entity),
			currentVal = instance("currentVal", entity),
			maxVal = instance("maxVal", entity),
			fetchSize = instance("fetchSize", entity),
			increment = instance("increment", entity),
			isCycle = instance("isCycle", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity),
			creatorName = instance("creatorName", entity),
			modifierName = instance("modifierName", entity);
	
	}
	
	public static class Partner {
	
		private static final Class<? extends Entity> entity = com.easycodebox.example.model.entity.sys.Partner.class;
		public static final Property 
			id = instance("id", entity),
			name = instance("name", entity),
			partnerKey = instance("partnerKey", entity),
			website = instance("website", entity),
			status = instance("status", entity),
			deleted = instance("deleted", entity),
			sort = instance("sort", entity),
			contract = instance("contract", entity),
			remark = instance("remark", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity),
			creatorName = instance("creatorName", entity),
			modifierName = instance("modifierName", entity);
	
	}
	
	public static class UserExt {
	
		private static final Class<? extends Entity> entity = com.easycodebox.example.model.entity.sys.UserExt.class;
		public static final Property 
			id = instance("id", entity),
			level = instance("level", entity),
			balance = instance("balance", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity),
			creatorName = instance("creatorName", entity),
			modifierName = instance("modifierName", entity);
	
	}
	
	
}

package com.easycodebox.example.model.util.mybatis;

import com.easycodebox.common.enums.DetailEnum;
import com.easycodebox.common.enums.entity.YesNo;
import com.easycodebox.common.generator.AbstractGenerator;
import com.easycodebox.common.generator.GeneratorType;
import com.easycodebox.common.generator.impl.AlphaNumericGenerator;
import com.easycodebox.common.generator.impl.UUIDGenerator;

/**
 * @author WangXiaoJin
 * 
 */
public enum GeneratorEnum implements DetailEnum<String>, GeneratorType {
	
	UUID("UUID", "UUID", new UUIDGenerator()) {
		@SuppressWarnings("rawtypes")
		public AbstractGenerator getGenerator() {
			return new UUIDGenerator();
		}
	},
	
	/********************* 业务逻辑 **********************************/
	IMG_NAME("img_name", "图片名", new AlphaNumericGenerator()),
	KEY("key", "密钥", new AlphaNumericGenerator(49, 500, "a15db6f", "a15db6f", null, YesNo.NO)),
	
	/********************* 表ID字段 **********************************/
	PARTNER_ID("partner_id", "合作商表ID字段", new AlphaNumericGenerator(59, 500, "a15b6", "a15b6", null, YesNo.NO)),
	
	;
	
	private String value;
	private String desc;
	@SuppressWarnings("rawtypes")
	private AbstractGenerator rawGenerator;
	@SuppressWarnings("rawtypes")
	private volatile AbstractGenerator generator;
   
	@SuppressWarnings("rawtypes")
	GeneratorEnum(String value, String desc, AbstractGenerator rawGenerator) {
        this.value = value;
        this.desc = desc;
        this.rawGenerator = rawGenerator;
    }

	@Override
	public String getDesc() {
		return desc;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public AbstractGenerator getRawGenerator() {
		return rawGenerator;
	}

	@Override
	public String getClassName() {
		return this.name();
	}

	@Override
	@SuppressWarnings("rawtypes")
	public AbstractGenerator getGenerator() {
		return generator;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void setGenerator(AbstractGenerator generator) {
		this.generator = generator;
	}
	
}

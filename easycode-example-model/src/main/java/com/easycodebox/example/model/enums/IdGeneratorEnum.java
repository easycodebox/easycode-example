package com.easycodebox.example.model.enums;

import com.easycodebox.common.enums.DetailEnum;
import com.easycodebox.common.enums.entity.YesNo;
import com.easycodebox.common.idgenerator.AbstractIdGenerator;
import com.easycodebox.common.idgenerator.IdGeneratorType;
import com.easycodebox.common.idgenerator.impl.AlphaNumericIdGenerator;
import com.easycodebox.common.idgenerator.impl.UuidGenerator;

/**
 * @author WangXiaoJin
 * 
 */
public enum IdGeneratorEnum implements DetailEnum<String>, IdGeneratorType {
	
	UUID("UUID", "UUID", new UuidGenerator()) {
		@SuppressWarnings("rawtypes")
		public AbstractIdGenerator getIdGenerator() {
			return new UuidGenerator();
		}
	},
	
	/********************* 业务逻辑 **********************************/
	IMG_NAME("img_name", "图片名", new AlphaNumericIdGenerator()),
	KEY("key", "密钥", new AlphaNumericIdGenerator(49, 500, "a15db6f", "a15db6f", null, YesNo.NO)),
	
	/********************* 表ID字段 **********************************/
	PARTNER_ID("partner_id", "合作商表ID字段", new AlphaNumericIdGenerator(59, 500, "a15b6", "a15b6", null, YesNo.NO)),
	
	;
	
	private String value;
	private String desc;
	@SuppressWarnings("rawtypes")
	private AbstractIdGenerator rawIdGenerator;
	@SuppressWarnings("rawtypes")
	private volatile AbstractIdGenerator idGenerator;
   
	@SuppressWarnings("rawtypes")
	IdGeneratorEnum(String value, String desc, AbstractIdGenerator rawIdGenerator) {
        this.value = value;
        this.desc = desc;
        this.rawIdGenerator = rawIdGenerator;
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
	public String getPersistentKey() {
		return getValue();
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public AbstractIdGenerator getRawIdGenerator() {
		return rawIdGenerator;
	}

	@Override
	public String getClassName() {
		return this.name();
	}

	@Override
	@SuppressWarnings("rawtypes")
	public AbstractIdGenerator getIdGenerator() {
		return idGenerator;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void setIdGenerator(AbstractIdGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}
	
}

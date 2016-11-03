package com.easycodebox.example.model.enums;

import com.easycodebox.common.enums.DetailEnum;

/**
 * @author WangXiaoJin
 * 
 */
public enum ModuleType implements DetailEnum<Integer> {
	
	SYS(1, "系统"),
	;
	
	private Integer value;
	private String desc;
   
    private ModuleType(Integer value, String desc) {

        this.value = value;
        this.desc = desc;
    }

	@Override
	public String getDesc() {
		return desc;
	}

	@Override
	public Integer getValue() {
		return value;
	}
	
	@Override
	public String getClassName() {
		return this.name();
	}

}

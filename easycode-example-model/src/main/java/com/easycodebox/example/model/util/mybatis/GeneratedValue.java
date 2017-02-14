package com.easycodebox.example.model.util.mybatis;

import com.easycodebox.example.model.enums.GeneratorEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author WangXiaoJin
 * 
 */
@Retention(RetentionPolicy.RUNTIME)  
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface GeneratedValue {

	GeneratorEnum value();
	
}

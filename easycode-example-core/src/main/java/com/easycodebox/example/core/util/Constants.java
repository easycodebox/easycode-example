package com.easycodebox.example.core.util;

/**
 * @author WangXiaoJin
 * 
 */
public class Constants {
	
	/**
	 * 集成测试KEY
	 */
	public static final String INTEGRATION_TEST_KEY = "integrationTest";
	
	/**
	 * 混合存储缓存的KeyGenerator bean name
	 */
	public static final String METHOD_ARGS_KEY_GENERATOR = "methodArgsKeyGenerator";
	
	/**
	 * 批量删除缓存的KeyGenerator bean name
	 */
	public static final String MULTI_KEY_GENERATOR = "multiKeyGenerator";
	
	/**
	 * CacheName的缩写
	 */
	public static final class CN {

		public static final String PREFIX = "example:";
		
		/**
		 * key:partnerId value:partner
		 */
		public static final String PARTNER = PREFIX + "partner";
		
	}
	
}

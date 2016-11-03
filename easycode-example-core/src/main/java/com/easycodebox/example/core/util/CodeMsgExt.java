package com.easycodebox.example.core.util;

import java.io.File;

import com.easycodebox.common.error.CodeMsg;
import com.easycodebox.common.file.PropertiesPool;
import com.easycodebox.common.lang.Symbol;

/**
 * @author WangXiaoJin
 *
 */
public class CodeMsgExt extends CodeMsg {
	
	private static final long serialVersionUID = -1063652479110560177L;
	
	public static CodeMsg PARAM_ERR 	= new CodeMsgExt("1002", "{0}参数错误");
	public static CodeMsg PARAM_BLANK 	= new CodeMsgExt("1003", "{0}参数不能为空");
	
	public static CodeMsg EXISTS 		= new CodeMsgExt("2001", "{0}已存在");
	
	
	
	private static final String FILE_PATH = "/code-msg.properties";
	
	static {
		PropertiesPool.loadPropertiesFile(FILE_PATH);
	}
	
	protected CodeMsgExt(String code, String msg) {
		super(code, msg);
	}
	
	public static void main(String[] args) throws Exception {
		
		/************* 生成properties文件 ************************/
		File file = new File("src/main/resources" + (FILE_PATH.startsWith(Symbol.SLASH) ? "" : Symbol.SLASH) + FILE_PATH);
		CodeMsgUtils.storePropertiesFile(CodeMsgExt.class, file);
		/************* 生成properties文件 ************************/
		
		CodeMsg code = CodeMsgExt.NONE;
		System.out.println(code.getMsg());
		CodeMsg xx = code.msg("XXXXXXXXXXx");
		System.out.println(code.getMsg());
		System.out.println(xx.getMsg());
		System.out.println(CodeMsgExt.NONE.getMsg());
	}

}

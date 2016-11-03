package com.easycodebox.example.core;

import org.junit.Test;

import com.easycodebox.jdbc.res.GenerateBeanRes;

public class SysTest {
	
	@Test
	public void testGenerateRes() {
		GenerateBeanRes gen = new GenerateBeanRes();
		gen.setBasePackages(new String[] {
				"com/easycodebox/example/model/entity",
				"com/easycodebox/example/model/bo"
		});
		gen.setOutputFile("src/main/java/com/easycodebox/example/model/util/R.java");
		gen.generate();
	}
	
}

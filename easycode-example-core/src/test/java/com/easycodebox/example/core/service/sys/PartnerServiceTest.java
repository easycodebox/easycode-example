package com.easycodebox.example.core.service.sys;

import org.junit.Test;

import com.easycodebox.example.core.service.sys.PartnerService;
import com.easycodebox.example.core.util.test.BaseTest;

public class PartnerServiceTest extends BaseTest<PartnerService> {
	
	@Test
    public void testRmove() {
    	try {
    		log.info(bean.remove(new String[] {"11111111"}));
		} catch (Exception e) {
			log.error("run error!!!", e);
		}
    }
    
}

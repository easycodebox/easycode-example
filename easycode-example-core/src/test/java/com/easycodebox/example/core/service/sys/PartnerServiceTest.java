package com.easycodebox.example.core.service.sys;

import com.easycodebox.example.core.AbstractTest;
import com.easycodebox.example.model.entity.sys.Partner;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author WangXiaoJin
 */
public class PartnerServiceTest extends AbstractTest {
	
	@Autowired
	private PartnerService partnerService;
	
	@Test
	public void testLoad() {
		Partner data = partnerService.load("a15b6");
		assertNotNull("获取合作商失败", data);
	}
	
}

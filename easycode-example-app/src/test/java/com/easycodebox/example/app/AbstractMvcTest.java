package com.easycodebox.example.app;

import com.easycodebox.example.TestApplication;
import com.easycodebox.example.core.AbstractTest;
import com.easycodebox.example.core.config.CoreTestConfig;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author WangXiaoJin
 */
@SpringBootTest(
		classes = {TestApplication.class, CoreTestConfig.class},
		properties = {
				"spring.config.name=application,core-application"
		}
)
public abstract class AbstractMvcTest extends AbstractTest {
	
	@Autowired
	protected WebApplicationContext wac;
	
	protected MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
}

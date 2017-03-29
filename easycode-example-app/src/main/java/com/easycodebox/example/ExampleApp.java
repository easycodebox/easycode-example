package com.easycodebox.example;

import com.easycodebox.example.core.config.PropertyConfig;
import com.easycodebox.login.config.ShiroConfig;
import com.easycodebox.login.config.WsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.Map;

/**
 * @author WangXiaoJin
 */
@Import({ShiroConfig.class, WsClientConfig.class})
@SpringBootApplication
public class ExampleApp {
	
	public static void main(String[] args) throws Exception {
		/* ----------------- 测试配置 BEGIN ------------------- */
		//args = new String[] {
				//"--logging.level.root=DEBUG",
				//"--debug"
		//};
		/* ----------------- 测试配置 END ------------------- */
		Map<String, Object> props = PropertyConfig.defaultProperties();
		props.put("spring.config.name", "application,core-application");
		SpringApplication application = new SpringApplication(ExampleApp.class);
		application.setDefaultProperties(props);
		application.run(args);
	}
	
}

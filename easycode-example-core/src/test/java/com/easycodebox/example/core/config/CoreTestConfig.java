package com.easycodebox.example.core.config;

import com.easycodebox.auth.model.entity.user.User;
import com.easycodebox.auth.model.idconverter.AbstractUserIdConverter;
import com.easycodebox.common.enums.entity.OpenClose;
import com.easycodebox.common.enums.entity.YesNo;
import com.easycodebox.example.core.util.Constants;
import com.easycodebox.jdbc.support.JdbcHandler;
import com.easycodebox.login.ws.UserWsService;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * @author WangXiaoJin
 */
@Configuration
@Profile(Constants.INTEGRATION_TEST_KEY)
public class CoreTestConfig {
	
	/**
	 * 当easycode-jdbc-mybatis支持HSQL时再开启此功能，
	 * 同时开启{@link CoreConfig#dataSource()}的@Profile功能
	 */
	//@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
				.addScript("classpath:easycode-example-schema.sql")
				.addScript("classpath:easycode-example-data.sql")
				.build();
	}
	
	/**
	 * {@link CoreConfig#userIdConverter(UserWsService)}需要UserWsService实例，
	 * 此实例通过接口调用easycode-auth服务，在没有开启easycode-auth服务时，只能重写此Bean
	 * @param jdbcHandler
	 * @return
	 */
	@Bean
	public AbstractUserIdConverter userIdConverter(final JdbcHandler jdbcHandler) {
		AbstractUserIdConverter converter = new AbstractUserIdConverter() {
			@Override
			public User getUserById(Object id) {
				User user = new User();
				user.setId(jdbcHandler.getSysUserId().toString());
				user.setUsername(jdbcHandler.getSysUsername());
				user.setNickname(jdbcHandler.getSysUsername());
				user.setRealname(jdbcHandler.getSysUsername());
				user.setStatus(OpenClose.OPEN);
				user.setDeleted(YesNo.NO);
				user.setIsSuperAdmin(YesNo.YES);
				return user;
			}
		};
		converter.setJdbcHandler(jdbcHandler);
		return converter;
	}
	
}

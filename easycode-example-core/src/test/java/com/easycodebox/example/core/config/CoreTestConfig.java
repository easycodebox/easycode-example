package com.easycodebox.example.core.config;

import com.easycodebox.auth.model.bo.user.AuthzInfoBo;
import com.easycodebox.auth.model.entity.user.User;
import com.easycodebox.common.enums.entity.OpenClose;
import com.easycodebox.common.enums.entity.YesNo;
import com.easycodebox.common.error.ErrorContext;
import com.easycodebox.common.lang.dto.DataPage;
import com.easycodebox.example.core.util.Constants;
import com.easycodebox.jdbc.support.DefaultJdbcHandler;
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
	 * UserWsService实例通过接口调用easycode-auth服务，在没有开启easycode-auth服务时，只能简单实现此Bean
	 * @return
	 */
	@Bean
	public UserWsService userWsService() {
		return new UserWsService() {
			
			@Override
			public User load(String id) throws ErrorContext {
				DefaultJdbcHandler jdbcHandler = new DefaultJdbcHandler();
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
			
			@Override
			public DataPage<User> page(Integer groupId, String userNo, String username, String nickname, String realname, OpenClose status, String email, String mobile, String[] ids, Integer pageNo, Integer pageSize) throws ErrorContext {
				return null;
			}
			
			@Override
			public int updatePwd(String id, String oldPwd, String newPwd) throws ErrorContext {
				return 0;
			}
			
			@Override
			public int updateStatus(String[] ids, OpenClose status) throws ErrorContext {
				return 0;
			}
			
			@Override
			public int update(User user) throws ErrorContext {
				return 0;
			}
			
			@Override
			public int updateNickname(String id, String nickname) {
				return 0;
			}
			
			@Override
			public int updatePortrait(String id, String portrait) throws ErrorContext {
				return 0;
			}
			
			@Override
			public int updateBaseInfo(String id, String nickname, String realname, String email, String mobile) throws ErrorContext {
				return 0;
			}
			
			@Override
			public boolean existUsername(String username, String excludeId) throws ErrorContext {
				return false;
			}
			
			@Override
			public boolean existNickname(String nickname, String excludeId) throws ErrorContext {
				return false;
			}
			
			@Override
			public String add(User user, String roleName) throws ErrorContext {
				return null;
			}
			
			@Override
			public int remove(String[] ids) throws ErrorContext {
				return 0;
			}
			
			@Override
			public AuthzInfoBo authzInfo(String userId, String projectNo, boolean validProjectAuth) throws ErrorContext {
				return null;
			}
		};
	}
	
}

package com.easycodebox.example.app.config;

import com.easycodebox.login.shiro.realm.DefaultJdbcRealm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author WangXiaoJin
 */
@Configuration
public class ShiroCustomConfig {
	
	/**
	 * 下面为身份的二次校验。使用场景：登录某个子系统时，必须在此子系统中激活
	 */
	@Bean
	public DefaultJdbcRealm defaultJdbcRealm(DataSource dataSource) {
		DefaultJdbcRealm realm = new DefaultJdbcRealm();
		realm.setName("jdbc");
		realm.setDataSource(dataSource);
		realm.setAuthenticationQuery("SELECT * FROM user_ext WHERE id = ?");
		realm.setAuthFailMsg("此账号在easycode-example-app项目中没有激活");
		return realm;
	}
	
}

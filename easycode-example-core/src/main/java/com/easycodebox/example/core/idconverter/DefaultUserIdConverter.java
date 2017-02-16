package com.easycodebox.example.core.idconverter;

import com.easycodebox.auth.model.entity.user.User;
import com.easycodebox.auth.model.idconverter.AbstractUserIdConverter;
import com.easycodebox.login.ws.UserWsService;

/**
 * 用户ID转换器
 * @author WangXiaoJin
 *
 */
public class DefaultUserIdConverter extends AbstractUserIdConverter {

	private UserWsService userWsService;
	
	public DefaultUserIdConverter(UserWsService userWsService) {
		this.userWsService = userWsService;
	}
	
	@Override
	public User getUserById(Object id) {
		/****************************************
		 * 注：此处应改成先去缓存中查找，缓存中没有再调用接口 	*
		 ****************************************/
		return userWsService == null ? null : userWsService.load(id.toString());
	}
	
}

package com.easycodebox.example.app.controller.user;

import com.easycodebox.common.error.CodeMsg;
import com.easycodebox.common.security.SecurityUtils;
import com.easycodebox.common.web.BaseController;
import com.easycodebox.login.ws.UserWsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author WangXiaoJin
 *
 */
@Controller
public class UserController extends BaseController {
	
	@Autowired
	private UserWsService userWsService;

	/**
	 * 跳转修改密码页面
	 */
	public void updatePwd() throws Exception {
		
	}
	
	/**
	 * 执行修改密码
	 */
	@ResponseBody
	public CodeMsg updatingPwd(String oldPwd, String pwd) throws Exception {
		int num = userWsService.updatePwd(SecurityUtils.getUserId(), oldPwd, pwd);
		return isTrue(num > 0);
	}
	
}

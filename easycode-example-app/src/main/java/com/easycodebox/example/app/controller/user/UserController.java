package com.easycodebox.example.app.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easycodebox.common.error.CodeMsg;
import com.easycodebox.common.security.SecurityUtils;
import com.easycodebox.common.web.BaseController;
import com.easycodebox.login.ws.UserWsService;

/**
 * @author WangXiaoJin
 *
 */
@Controller
public class UserController extends BaseController {
	
	@Resource
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

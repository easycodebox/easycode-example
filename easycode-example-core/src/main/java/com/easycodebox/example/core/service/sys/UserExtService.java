package com.easycodebox.example.core.service.sys;

import com.easycodebox.example.model.entity.sys.UserExt;

/**
 * @author WangXiaoJin
 *
 */
public interface UserExtService {

	/**
	 * 用户扩展信息详情
	 * @param id
	 * @return
	 */
	UserExt load(String id);
	
	/**
	 * 新增用户扩展信息
	 * @param userExt
	 * @return	应该实现返回数据能获取到主键
	 */
	UserExt add(UserExt userExt);
	
}

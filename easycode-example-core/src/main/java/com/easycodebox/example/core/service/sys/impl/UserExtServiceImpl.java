package com.easycodebox.example.core.service.sys.impl;

import org.springframework.stereotype.Service;

import com.easycodebox.example.core.service.sys.UserExtService;
import com.easycodebox.example.model.entity.sys.UserExt;
import com.easycodebox.jdbc.support.AbstractServiceImpl;

/**
 * @author WangXiaoJin
 *
 */
@Service
public class UserExtServiceImpl extends AbstractServiceImpl<UserExt> implements UserExtService {

	@Override
	public UserExt load(String id) {
		return super.get(id);
	}

	@Override
	public UserExt add(UserExt userExt) {
		super.save(userExt);
		return userExt;
	}
	
}

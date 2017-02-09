package com.easycodebox.example.model.entity.sys;

import com.easycodebox.jdbc.entity.AbstractOperateEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 用户扩展信息 - 基于权限系统u_user表的扩展信息
 * @author WangXiaoJin
 *
 */
@Entity
@Table(name="user_ext")
public class UserExt extends AbstractOperateEntity {

	/**
	 * 主键
	 */
	@Id
	private String id;
	
	/**
	 * 等级
	 */
	private Integer level;
	
	/**
	 * 余额
	 */
	private BigDecimal balance;
	
	public UserExt(){
	
	}

	public UserExt(String id){
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
}


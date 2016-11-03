package com.easycodebox.example.model.entity.sys;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.easycodebox.jdbc.entity.AbstractOperateEntity;

/**
 * 用户扩展信息 - 基于权限系统u_user表的扩展信息
 * @author WangXiaoJin
 *
 */
@Entity
@Table(name="user_ext")
public class UserExt extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
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


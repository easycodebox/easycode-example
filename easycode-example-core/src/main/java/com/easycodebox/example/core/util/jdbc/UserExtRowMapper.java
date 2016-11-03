package com.easycodebox.example.core.util.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.easycodebox.example.model.entity.sys.UserExt;
import com.easycodebox.example.model.util.R;
import com.easycodebox.jdbc.Table;
import com.easycodebox.jdbc.config.Configuration;

public class UserExtRowMapper implements RowMapper<UserExt> {

	@Override
	public UserExt mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserExt user = new UserExt();
		Table table = Configuration.getTable(UserExt.class);
		
		user.setId(rs.getString(table.getColumn(R.UserExt.id.getPropertyName()).getSqlName()));
		user.setLevel(rs.getInt(table.getColumn(R.UserExt.level.getPropertyName()).getSqlName()));
		user.setBalance(rs.getBigDecimal(table.getColumn(R.UserExt.balance.getPropertyName()).getSqlName()));
		user.setCreator(rs.getString(table.getColumn(R.UserExt.creator.getPropertyName()).getSqlName()));
		user.setCreateTime(rs.getTimestamp(table.getColumn(R.UserExt.createTime.getPropertyName()).getSqlName()));
		user.setModifier(rs.getString(table.getColumn(R.UserExt.modifier.getPropertyName()).getSqlName()));
		user.setModifyTime(rs.getTimestamp(table.getColumn(R.UserExt.modifyTime.getPropertyName()).getSqlName()));
		
		return user;
	}

}

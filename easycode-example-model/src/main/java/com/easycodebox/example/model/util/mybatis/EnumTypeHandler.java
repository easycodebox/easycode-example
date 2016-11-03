package com.easycodebox.example.model.util.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import com.easycodebox.common.enums.DetailEnum;
import com.easycodebox.common.enums.DetailEnums;
import com.easycodebox.common.enums.entity.DataType;
import com.easycodebox.common.enums.entity.Gender;
import com.easycodebox.common.enums.entity.LogLevel;
import com.easycodebox.common.enums.entity.OpenClose;
import com.easycodebox.common.enums.entity.PhoneType;
import com.easycodebox.common.enums.entity.RequestMethod;
import com.easycodebox.common.enums.entity.YesNo;
import com.easycodebox.common.enums.entity.status.Status;
import com.easycodebox.common.enums.entity.status.UserStatus;
import com.easycodebox.example.model.enums.ModuleType;

/**
 * @author WangXiaoJin
 *
 */
@MappedTypes({
	/***** CORE包   *****/
	LogLevel.class,
	ModuleType.class,
	/***** COMMON包   *****/
	Gender.class,
	OpenClose.class,
	PhoneType.class,
	YesNo.class,
	DataType.class,
	RequestMethod.class,
	/***** 状态  分割线 *****/
	Status.class,
	UserStatus.class,
	/***** utils *****/
	GeneratorEnum.class
})
public class EnumTypeHandler<T extends Enum<T> & DetailEnum<V>, V> extends BaseTypeHandler<T>{
	
	private Class<T> classType;
	
	public EnumTypeHandler(Class<T> clazz) {
		this.classType = clazz;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			T parameter, JdbcType jdbcType) throws SQLException {
		ps.setObject(i, parameter.getValue());
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return DetailEnums.parse(classType, (V)rs.getObject(columnName));
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return (T)rs.getObject(columnIndex);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getNullableResult(CallableStatement cs,
			int columnIndex) throws SQLException {
		return (T)cs.getObject(columnIndex);
	}

}

package net.sf.jdbcwrappers;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

public class CallableStatementWrapper extends AbstractWrapper implements CallableStatement {
	private WrapperFactory wrapperFactory;
	private PreparedStatementWrapper preparedStatementWrapper;
	private CallableStatement parent;
	
	final void init(WrapperFactory wrapperFactory, ConnectionWrapper connectionWrapper, CallableStatement parent, String sql) throws SQLException {
		this.wrapperFactory = wrapperFactory;
		preparedStatementWrapper = wrapperFactory.wrapPreparedStatement(connectionWrapper, parent, sql);
		this.parent = parent;
		init();
	}
	
	/**
	 * Get the SQL statement used to construct the {@link PreparedStatement} object. 
	 * 
	 * @return the SQL statement
	 */
	protected final String getSql() {
		return preparedStatementWrapper.getSql();
	}
	
	public void addBatch() throws SQLException {
		preparedStatementWrapper.addBatch();
	}

	public void addBatch(String sql) throws SQLException {
		preparedStatementWrapper.addBatch(sql);
	}

	public void cancel() throws SQLException {
		preparedStatementWrapper.cancel();
	}

	public void clearBatch() throws SQLException {
		preparedStatementWrapper.clearBatch();
	}

	public void clearParameters() throws SQLException {
		preparedStatementWrapper.clearParameters();
	}

	public void clearWarnings() throws SQLException {
		preparedStatementWrapper.clearWarnings();
	}

	public void close() throws SQLException {
		preparedStatementWrapper.close();
	}

	public boolean execute() throws SQLException {
		return preparedStatementWrapper.execute();
	}

	public boolean execute(String sql, int autoGeneratedKeys)
			throws SQLException {
		return preparedStatementWrapper.execute(sql, autoGeneratedKeys);
	}

	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		return preparedStatementWrapper.execute(sql, columnIndexes);
	}

	public boolean execute(String sql, String[] columnNames)
			throws SQLException {
		return preparedStatementWrapper.execute(sql, columnNames);
	}

	public boolean execute(String sql) throws SQLException {
		return preparedStatementWrapper.execute(sql);
	}

	public int[] executeBatch() throws SQLException {
		return preparedStatementWrapper.executeBatch();
	}

	public ResultSet executeQuery() throws SQLException {
		return preparedStatementWrapper.executeQuery();
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		return preparedStatementWrapper.executeQuery(sql);
	}

	public int executeUpdate() throws SQLException {
		return preparedStatementWrapper.executeUpdate();
	}

	public int executeUpdate(String sql, int autoGeneratedKeys)
			throws SQLException {
		return preparedStatementWrapper.executeUpdate(sql, autoGeneratedKeys);
	}

	public int executeUpdate(String sql, int[] columnIndexes)
			throws SQLException {
		return preparedStatementWrapper.executeUpdate(sql, columnIndexes);
	}

	public int executeUpdate(String sql, String[] columnNames)
			throws SQLException {
		return preparedStatementWrapper.executeUpdate(sql, columnNames);
	}

	public int executeUpdate(String sql) throws SQLException {
		return preparedStatementWrapper.executeUpdate(sql);
	}

	public Connection getConnection() throws SQLException {
		return preparedStatementWrapper.getConnection();
	}

	public int getFetchDirection() throws SQLException {
		return preparedStatementWrapper.getFetchDirection();
	}

	public int getFetchSize() throws SQLException {
		return preparedStatementWrapper.getFetchSize();
	}

	public ResultSet getGeneratedKeys() throws SQLException {
		return preparedStatementWrapper.getGeneratedKeys();
	}

	public int getMaxFieldSize() throws SQLException {
		return preparedStatementWrapper.getMaxFieldSize();
	}

	public int getMaxRows() throws SQLException {
		return preparedStatementWrapper.getMaxRows();
	}

	public ResultSetMetaData getMetaData() throws SQLException {
		return preparedStatementWrapper.getMetaData();
	}

	public boolean getMoreResults() throws SQLException {
		return preparedStatementWrapper.getMoreResults();
	}

	public boolean getMoreResults(int current) throws SQLException {
		return preparedStatementWrapper.getMoreResults(current);
	}

	public ParameterMetaData getParameterMetaData() throws SQLException {
		return preparedStatementWrapper.getParameterMetaData();
	}

	public int getQueryTimeout() throws SQLException {
		return preparedStatementWrapper.getQueryTimeout();
	}

	public ResultSet getResultSet() throws SQLException {
		return preparedStatementWrapper.getResultSet();
	}

	public int getResultSetConcurrency() throws SQLException {
		return preparedStatementWrapper.getResultSetConcurrency();
	}

	public int getResultSetHoldability() throws SQLException {
		return preparedStatementWrapper.getResultSetHoldability();
	}

	public int getResultSetType() throws SQLException {
		return preparedStatementWrapper.getResultSetType();
	}

	public int getUpdateCount() throws SQLException {
		return preparedStatementWrapper.getUpdateCount();
	}

	public SQLWarning getWarnings() throws SQLException {
		return preparedStatementWrapper.getWarnings();
	}

	public void setArray(int i, Array x) throws SQLException {
		preparedStatementWrapper.setArray(i, x);
	}

	public void setAsciiStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		preparedStatementWrapper.setAsciiStream(parameterIndex, x, length);
	}

	public void setBigDecimal(int parameterIndex, BigDecimal x)
			throws SQLException {
		preparedStatementWrapper.setBigDecimal(parameterIndex, x);
	}

	public void setBinaryStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		preparedStatementWrapper.setBinaryStream(parameterIndex, x, length);
	}

	public void setBlob(int i, Blob x) throws SQLException {
		preparedStatementWrapper.setBlob(i, x);
	}

	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		preparedStatementWrapper.setBoolean(parameterIndex, x);
	}

	public void setByte(int parameterIndex, byte x) throws SQLException {
		preparedStatementWrapper.setByte(parameterIndex, x);
	}

	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
		preparedStatementWrapper.setBytes(parameterIndex, x);
	}

	public void setCharacterStream(int parameterIndex, Reader reader, int length)
			throws SQLException {
		preparedStatementWrapper.setCharacterStream(parameterIndex, reader,
				length);
	}

	public void setClob(int i, Clob x) throws SQLException {
		preparedStatementWrapper.setClob(i, x);
	}

	public void setCursorName(String name) throws SQLException {
		preparedStatementWrapper.setCursorName(name);
	}

	public void setDate(int parameterIndex, Date x, Calendar cal)
			throws SQLException {
		preparedStatementWrapper.setDate(parameterIndex, x, cal);
	}

	public void setDate(int parameterIndex, Date x) throws SQLException {
		preparedStatementWrapper.setDate(parameterIndex, x);
	}

	public void setDouble(int parameterIndex, double x) throws SQLException {
		preparedStatementWrapper.setDouble(parameterIndex, x);
	}

	public void setEscapeProcessing(boolean enable) throws SQLException {
		preparedStatementWrapper.setEscapeProcessing(enable);
	}

	public void setFetchDirection(int direction) throws SQLException {
		preparedStatementWrapper.setFetchDirection(direction);
	}

	public void setFetchSize(int rows) throws SQLException {
		preparedStatementWrapper.setFetchSize(rows);
	}

	public void setFloat(int parameterIndex, float x) throws SQLException {
		preparedStatementWrapper.setFloat(parameterIndex, x);
	}

	public void setInt(int parameterIndex, int x) throws SQLException {
		preparedStatementWrapper.setInt(parameterIndex, x);
	}

	public void setLong(int parameterIndex, long x) throws SQLException {
		preparedStatementWrapper.setLong(parameterIndex, x);
	}

	public void setMaxFieldSize(int max) throws SQLException {
		preparedStatementWrapper.setMaxFieldSize(max);
	}

	public void setMaxRows(int max) throws SQLException {
		preparedStatementWrapper.setMaxRows(max);
	}

	public void setNull(int paramIndex, int sqlType, String typeName)
			throws SQLException {
		preparedStatementWrapper.setNull(paramIndex, sqlType, typeName);
	}

	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		preparedStatementWrapper.setNull(parameterIndex, sqlType);
	}

	public void setObject(int parameterIndex, Object x, int targetSqlType,
			int scale) throws SQLException {
		preparedStatementWrapper.setObject(parameterIndex, x, targetSqlType,
				scale);
	}

	public void setObject(int parameterIndex, Object x, int targetSqlType)
			throws SQLException {
		preparedStatementWrapper.setObject(parameterIndex, x, targetSqlType);
	}

	public void setObject(int parameterIndex, Object x) throws SQLException {
		preparedStatementWrapper.setObject(parameterIndex, x);
	}

	public void setQueryTimeout(int seconds) throws SQLException {
		preparedStatementWrapper.setQueryTimeout(seconds);
	}

	public void setRef(int i, Ref x) throws SQLException {
		preparedStatementWrapper.setRef(i, x);
	}

	public void setShort(int parameterIndex, short x) throws SQLException {
		preparedStatementWrapper.setShort(parameterIndex, x);
	}

	public void setString(int parameterIndex, String x) throws SQLException {
		preparedStatementWrapper.setString(parameterIndex, x);
	}

	public void setTime(int parameterIndex, Time x, Calendar cal)
			throws SQLException {
		preparedStatementWrapper.setTime(parameterIndex, x, cal);
	}

	public void setTime(int parameterIndex, Time x) throws SQLException {
		preparedStatementWrapper.setTime(parameterIndex, x);
	}

	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal)
			throws SQLException {
		preparedStatementWrapper.setTimestamp(parameterIndex, x, cal);
	}

	public void setTimestamp(int parameterIndex, Timestamp x)
			throws SQLException {
		preparedStatementWrapper.setTimestamp(parameterIndex, x);
	}

	public void setUnicodeStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		preparedStatementWrapper.setUnicodeStream(parameterIndex, x, length);
	}

	public void setURL(int parameterIndex, URL x) throws SQLException {
		preparedStatementWrapper.setURL(parameterIndex, x);
	}

	public Array getArray(int i) throws SQLException {
		return parent.getArray(i);
	}

	public Array getArray(String parameterName) throws SQLException {
		return parent.getArray(parameterName);
	}

	public BigDecimal getBigDecimal(int parameterIndex, int scale)
			throws SQLException {
		return parent.getBigDecimal(parameterIndex, scale);
	}

	public BigDecimal getBigDecimal(int parameterIndex) throws SQLException {
		return parent.getBigDecimal(parameterIndex);
	}

	public BigDecimal getBigDecimal(String parameterName) throws SQLException {
		return parent.getBigDecimal(parameterName);
	}

	public Blob getBlob(int i) throws SQLException {
		return parent.getBlob(i);
	}

	public Blob getBlob(String parameterName) throws SQLException {
		return parent.getBlob(parameterName);
	}

	public boolean getBoolean(int parameterIndex) throws SQLException {
		return parent.getBoolean(parameterIndex);
	}

	public boolean getBoolean(String parameterName) throws SQLException {
		return parent.getBoolean(parameterName);
	}

	public byte getByte(int parameterIndex) throws SQLException {
		return parent.getByte(parameterIndex);
	}

	public byte getByte(String parameterName) throws SQLException {
		return parent.getByte(parameterName);
	}

	public byte[] getBytes(int parameterIndex) throws SQLException {
		return parent.getBytes(parameterIndex);
	}

	public byte[] getBytes(String parameterName) throws SQLException {
		return parent.getBytes(parameterName);
	}

	public Clob getClob(int i) throws SQLException {
		return parent.getClob(i);
	}

	public Clob getClob(String parameterName) throws SQLException {
		return parent.getClob(parameterName);
	}

	public Date getDate(int parameterIndex, Calendar cal) throws SQLException {
		return parent.getDate(parameterIndex, cal);
	}

	public Date getDate(int parameterIndex) throws SQLException {
		return parent.getDate(parameterIndex);
	}

	public Date getDate(String parameterName, Calendar cal) throws SQLException {
		return parent.getDate(parameterName, cal);
	}

	public Date getDate(String parameterName) throws SQLException {
		return parent.getDate(parameterName);
	}

	public double getDouble(int parameterIndex) throws SQLException {
		return parent.getDouble(parameterIndex);
	}

	public double getDouble(String parameterName) throws SQLException {
		return parent.getDouble(parameterName);
	}

	public float getFloat(int parameterIndex) throws SQLException {
		return parent.getFloat(parameterIndex);
	}

	public float getFloat(String parameterName) throws SQLException {
		return parent.getFloat(parameterName);
	}

	public int getInt(int parameterIndex) throws SQLException {
		return parent.getInt(parameterIndex);
	}

	public int getInt(String parameterName) throws SQLException {
		return parent.getInt(parameterName);
	}

	public long getLong(int parameterIndex) throws SQLException {
		return parent.getLong(parameterIndex);
	}

	public long getLong(String parameterName) throws SQLException {
		return parent.getLong(parameterName);
	}

	public Object getObject(int i, Map<String, Class<?>> map)
			throws SQLException {
		return parent.getObject(i, map);
	}

	public Object getObject(int parameterIndex) throws SQLException {
		return parent.getObject(parameterIndex);
	}

	public Object getObject(String parameterName, Map<String, Class<?>> map)
			throws SQLException {
		return parent.getObject(parameterName, map);
	}

	public Object getObject(String parameterName) throws SQLException {
		return parent.getObject(parameterName);
	}

	public Ref getRef(int i) throws SQLException {
		return parent.getRef(i);
	}

	public Ref getRef(String parameterName) throws SQLException {
		return parent.getRef(parameterName);
	}

	public short getShort(int parameterIndex) throws SQLException {
		return parent.getShort(parameterIndex);
	}

	public short getShort(String parameterName) throws SQLException {
		return parent.getShort(parameterName);
	}

	public String getString(int parameterIndex) throws SQLException {
		return parent.getString(parameterIndex);
	}

	public String getString(String parameterName) throws SQLException {
		return parent.getString(parameterName);
	}

	public Time getTime(int parameterIndex, Calendar cal) throws SQLException {
		return parent.getTime(parameterIndex, cal);
	}

	public Time getTime(int parameterIndex) throws SQLException {
		return parent.getTime(parameterIndex);
	}

	public Time getTime(String parameterName, Calendar cal) throws SQLException {
		return parent.getTime(parameterName, cal);
	}

	public Time getTime(String parameterName) throws SQLException {
		return parent.getTime(parameterName);
	}

	public Timestamp getTimestamp(int parameterIndex, Calendar cal)
			throws SQLException {
		return parent.getTimestamp(parameterIndex, cal);
	}

	public Timestamp getTimestamp(int parameterIndex) throws SQLException {
		return parent.getTimestamp(parameterIndex);
	}

	public Timestamp getTimestamp(String parameterName, Calendar cal)
			throws SQLException {
		return parent.getTimestamp(parameterName, cal);
	}

	public Timestamp getTimestamp(String parameterName) throws SQLException {
		return parent.getTimestamp(parameterName);
	}

	public URL getURL(int parameterIndex) throws SQLException {
		return parent.getURL(parameterIndex);
	}

	public URL getURL(String parameterName) throws SQLException {
		return parent.getURL(parameterName);
	}

	public void registerOutParameter(int parameterIndex, int sqlType, int scale)
			throws SQLException {
		parent.registerOutParameter(parameterIndex, sqlType, scale);
	}

	public void registerOutParameter(int paramIndex, int sqlType,
			String typeName) throws SQLException {
		parent.registerOutParameter(paramIndex, sqlType, typeName);
	}

	public void registerOutParameter(int parameterIndex, int sqlType)
			throws SQLException {
		parent.registerOutParameter(parameterIndex, sqlType);
	}

	public void registerOutParameter(String parameterName, int sqlType,
			int scale) throws SQLException {
		parent.registerOutParameter(parameterName, sqlType, scale);
	}

	public void registerOutParameter(String parameterName, int sqlType,
			String typeName) throws SQLException {
		parent.registerOutParameter(parameterName, sqlType, typeName);
	}

	public void registerOutParameter(String parameterName, int sqlType)
			throws SQLException {
		parent.registerOutParameter(parameterName, sqlType);
	}

	public void setAsciiStream(String parameterName, InputStream x, int length)
			throws SQLException {
		parent.setAsciiStream(parameterName, x, length);
	}

	public void setBigDecimal(String parameterName, BigDecimal x)
			throws SQLException {
		parent.setBigDecimal(parameterName, x);
	}

	public void setBinaryStream(String parameterName, InputStream x, int length)
			throws SQLException {
		parent.setBinaryStream(parameterName, x, length);
	}

	public void setBoolean(String parameterName, boolean x) throws SQLException {
		parent.setBoolean(parameterName, x);
	}

	public void setByte(String parameterName, byte x) throws SQLException {
		parent.setByte(parameterName, x);
	}

	public void setBytes(String parameterName, byte[] x) throws SQLException {
		parent.setBytes(parameterName, x);
	}

	public void setCharacterStream(String parameterName, Reader reader,
			int length) throws SQLException {
		parent.setCharacterStream(parameterName, reader, length);
	}

	public void setDate(String parameterName, Date x, Calendar cal)
			throws SQLException {
		parent.setDate(parameterName, x, cal);
	}

	public void setDate(String parameterName, Date x) throws SQLException {
		parent.setDate(parameterName, x);
	}

	public void setDouble(String parameterName, double x) throws SQLException {
		parent.setDouble(parameterName, x);
	}

	public void setFloat(String parameterName, float x) throws SQLException {
		parent.setFloat(parameterName, x);
	}

	public void setInt(String parameterName, int x) throws SQLException {
		parent.setInt(parameterName, x);
	}

	public void setLong(String parameterName, long x) throws SQLException {
		parent.setLong(parameterName, x);
	}

	public void setNull(String parameterName, int sqlType, String typeName)
			throws SQLException {
		parent.setNull(parameterName, sqlType, typeName);
	}

	public void setNull(String parameterName, int sqlType) throws SQLException {
		parent.setNull(parameterName, sqlType);
	}

	public void setObject(String parameterName, Object x, int targetSqlType,
			int scale) throws SQLException {
		parent.setObject(parameterName, x, targetSqlType, scale);
	}

	public void setObject(String parameterName, Object x, int targetSqlType)
			throws SQLException {
		parent.setObject(parameterName, x, targetSqlType);
	}

	public void setObject(String parameterName, Object x) throws SQLException {
		parent.setObject(parameterName, x);
	}

	public void setShort(String parameterName, short x) throws SQLException {
		parent.setShort(parameterName, x);
	}

	public void setString(String parameterName, String x) throws SQLException {
		parent.setString(parameterName, x);
	}

	public void setTime(String parameterName, Time x, Calendar cal)
			throws SQLException {
		parent.setTime(parameterName, x, cal);
	}

	public void setTime(String parameterName, Time x) throws SQLException {
		parent.setTime(parameterName, x);
	}

	public void setTimestamp(String parameterName, Timestamp x, Calendar cal)
			throws SQLException {
		parent.setTimestamp(parameterName, x, cal);
	}

	public void setTimestamp(String parameterName, Timestamp x)
			throws SQLException {
		parent.setTimestamp(parameterName, x);
	}

	public void setURL(String parameterName, URL val) throws SQLException {
		parent.setURL(parameterName, val);
	}

	public boolean wasNull() throws SQLException {
		return parent.wasNull();
	}
	
}

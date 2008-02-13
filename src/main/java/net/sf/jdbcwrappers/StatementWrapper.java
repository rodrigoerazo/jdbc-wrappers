/**
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package net.sf.jdbcwrappers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

/**
 * Base class for {@link Statement} wrappers.
 * Except for {@link #getConnection()}, all methods delegate to the target {@link Statement} object.
 * {@link ResultSet} objects are wrapped using the {@link WrapperFactory} object.
 * 
 * @author Andreas Veithen
 * @version $Id$
 */
public class StatementWrapper extends AbstractWrapper implements Statement {
	private WrapperFactory wrapperFactory;
	private ConnectionWrapper connectionWrapper;
	private Statement parent;
	
	final void init(WrapperFactory wrapperFactory, ConnectionWrapper connectionWrapper, Statement parent) throws SQLException {
		this.wrapperFactory = wrapperFactory;
		this.connectionWrapper = connectionWrapper;
		this.parent = parent;
		init();
	}
	
	/**
	 * Delegate method for {@link Statement#addBatch(String)}.
	 */
	public void addBatch(String sql) throws SQLException {
		parent.addBatch(sql);
	}
	
	/**
	 * Delegate method for {@link Statement#cancel()}.
	 */
	public void cancel() throws SQLException {
		parent.cancel();
	}
	
	/**
	 * Delegate method for {@link Statement#clearBatch()}.
	 */
	public void clearBatch() throws SQLException {
		parent.clearBatch();
	}
	
	/**
	 * Delegate method for {@link Statement#clearWarnings()}.
	 */
	public void clearWarnings() throws SQLException {
		parent.clearWarnings();
	}
	
	/**
	 * Delegate method for {@link Statement#close()}.
	 */
	public void close() throws SQLException {
		parent.close();
	}
	
	/**
	 * Delegate method for {@link Statement#execute(String, int)}.
	 */
	public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
		return parent.execute(sql, autoGeneratedKeys);
	}
	
	/**
	 * Delegate method for {@link Statement#execute(String, int[])}.
	 */
	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		return parent.execute(sql, columnIndexes);
	}
	
	/**
	 * Delegate method for {@link Statement#execute(String, String[])}.
	 */
	public boolean execute(String sql, String[] columnNames) throws SQLException {
		return parent.execute(sql, columnNames);
	}
	
	/**
	 * Delegate method for {@link Statement#execute(String)}.
	 */
	public boolean execute(String sql) throws SQLException {
		return parent.execute(sql);
	}
	
	/**
	 * Delegate method for {@link Statement#executeBatch()}.
	 */
	public int[] executeBatch() throws SQLException {
		return parent.executeBatch();
	}
	
	/**
	 * Delegate method for {@link Statement#executeQuery(String)}.
	 * This method wraps the {@link ResultSet} object using
	 * {@link WrapperFactory#wrapResultSet(ResultSetType, ResultSet)} with
	 * {@link ResultSetType#QUERY}.
	 */
	public ResultSet executeQuery(String sql) throws SQLException {
		return wrapperFactory.wrapResultSet(ResultSetType.QUERY, this, parent.executeQuery(sql));
	}
	
	/**
	 * Delegate method for {@link Statement#executeUpdate(String, int)}.
	 */
	public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
		return parent.executeUpdate(sql, autoGeneratedKeys);
	}
	
	/**
	 * Delegate method for {@link Statement#execute(String, int[])}.
	 */
	public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
		return parent.executeUpdate(sql, columnIndexes);
	}
	
	/**
	 * Delegate method for {@link Statement#execute(String, String[])}.
	 */
	public int executeUpdate(String sql, String[] columnNames) throws SQLException {
		return parent.executeUpdate(sql, columnNames);
	}
	
	/**
	 * Delegate method for {@link Statement#executeUpdate(String)}.
	 */
	public int executeUpdate(String sql) throws SQLException {
		return parent.executeUpdate(sql);
	}
	
	/**
	 * Delegate method for {@link Statement#getConnection()}.
	 * This method returns the {@link ConnectionWrapper} object that
	 * created this wrapper. For consistency reasons, it can't be
	 * overridden.
	 */
	public final Connection getConnection() throws SQLException {
		return connectionWrapper;
	}
	
	/**
	 * Delegate method for {@link Statement#getFetchDirection()}.
	 */
	public int getFetchDirection() throws SQLException {
		return parent.getFetchDirection();
	}
	
	/**
	 * Delegate method for {@link Statement#getFetchSize()}.
	 */
	public int getFetchSize() throws SQLException {
		return parent.getFetchSize();
	}
	
	/**
	 * Delegate method for {@link Statement#getGeneratedKeys()}.
	 * This method wraps the {@link ResultSet} object using
	 * {@link WrapperFactory#wrapResultSet(ResultSetType, ResultSet)} with
	 * {@link ResultSetType#KEYS}.
	 */
	public ResultSet getGeneratedKeys() throws SQLException {
		return wrapperFactory.wrapResultSet(ResultSetType.KEYS, this, parent.getGeneratedKeys());
	}
	
	/**
	 * Delegate method for {@link Statement#getMaxFieldSize()}.
	 */
	public int getMaxFieldSize() throws SQLException {
		return parent.getMaxFieldSize();
	}
	
	/**
	 * Delegate method for {@link Statement#getMaxRows()}.
	 */
	public int getMaxRows() throws SQLException {
		return parent.getMaxRows();
	}
	
	/**
	 * Delegate method for {@link Statement#getMoreResults()}.
	 */
	public boolean getMoreResults() throws SQLException {
		return parent.getMoreResults();
	}
	
	/**
	 * Delegate method for {@link Statement#getMoreResults(int)}.
	 */
	public boolean getMoreResults(int current) throws SQLException {
		return parent.getMoreResults(current);
	}
	
	/**
	 * Delegate method for {@link Statement#getQueryTimeout()}.
	 */
	public int getQueryTimeout() throws SQLException {
		return parent.getQueryTimeout();
	}
	
	/**
	 * Delegate method for {@link Statement#getResultSet()}.
	 * This method wraps the {@link ResultSet} object using
	 * {@link WrapperFactory#wrapResultSet(ResultSetType, ResultSet)} with
	 * {@link ResultSetType#QUERY}.
	 */
	public ResultSet getResultSet() throws SQLException {
		return wrapperFactory.wrapResultSet(ResultSetType.QUERY, this, parent.getResultSet());
	}
	
	/**
	 * Delegate method for {@link Statement#getResultSetConcurrency()}.
	 */
	public int getResultSetConcurrency() throws SQLException {
		return parent.getResultSetConcurrency();
	}
	
	/**
	 * Delegate method for {@link Statement#getResultSetHoldability()}.
	 */
	public int getResultSetHoldability() throws SQLException {
		return parent.getResultSetHoldability();
	}
	
	/**
	 * Delegate method for {@link Statement#getResultSetType()}.
	 */
	public int getResultSetType() throws SQLException {
		return parent.getResultSetType();
	}
	
	/**
	 * Delegate method for {@link Statement#getUpdateCount()}.
	 */
	public int getUpdateCount() throws SQLException {
		return parent.getUpdateCount();
	}
	
	/**
	 * Delegate method for {@link Statement#getWarnings()}.
	 */
	public SQLWarning getWarnings() throws SQLException {
		return parent.getWarnings();
	}
	
	/**
	 * Delegate method for {@link Statement#setCursorName(String)}.
	 */
	public void setCursorName(String name) throws SQLException {
		parent.setCursorName(name);
	}
	
	/**
	 * Delegate method for {@link Statement#setEscapeProcessing(boolean)}.
	 */
	public void setEscapeProcessing(boolean enable) throws SQLException {
		parent.setEscapeProcessing(enable);
	}
	
	/**
	 * Delegate method for {@link Statement#setFetchDirection(int)}.
	 */
	public void setFetchDirection(int direction) throws SQLException {
		parent.setFetchDirection(direction);
	}
	
	/**
	 * Delegate method for {@link Statement#setFetchSize(int)}.
	 */
	public void setFetchSize(int rows) throws SQLException {
		parent.setFetchSize(rows);
	}
	
	/**
	 * Delegate method for {@link Statement#setMaxFieldSize(int)}.
	 */
	public void setMaxFieldSize(int max) throws SQLException {
		parent.setMaxFieldSize(max);
	}
	
	/**
	 * Delegate method for {@link Statement#setMaxRows(int)}.
	 */
	public void setMaxRows(int max) throws SQLException {
		parent.setMaxRows(max);
	}
	
	/**
	 * Delegate method for {@link Statement#setQueryTimeout(int)}.
	 */
	public void setQueryTimeout(int seconds) throws SQLException {
		parent.setQueryTimeout(seconds);
	}
}

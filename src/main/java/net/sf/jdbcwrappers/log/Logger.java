/*
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
package net.sf.jdbcwrappers.log;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.jdbcwrappers.HasConnection;

public class Logger {
    private final static Log log = LogFactory.getLog("JDBC");
    
    public void log(HasConnection source, String method, String sql, boolean prettyPrint) {
        try {
            LoggingConnectionWrapper connectionWrapper = (LoggingConnectionWrapper)source.getConnection();
            StringBuilder buffer = new StringBuilder();
            if (connectionWrapper.isTrackTransactions()) {
                buffer.append("TX ");
                buffer.append(connectionWrapper.getTransactionId());
                buffer.append(", ");
            }
            buffer.append(method);
            buffer.append(": ");
            if (prettyPrint) {
                prettyPrint(sql, buffer);
            } else {
                buffer.append(sql);
            }
            log.info(buffer.toString());
        }
        catch (SQLException ex) {
            log.error("Unexpected exception", ex);
        }
    }
    
    private void prettyPrint(String sql, StringBuilder buffer) {
        // TODO: need something more sophisticated here
        buffer.append(sql.replaceAll("\\s+", " "));
    }
    
    public void log(String message) {
        log.info(message);
    }
}

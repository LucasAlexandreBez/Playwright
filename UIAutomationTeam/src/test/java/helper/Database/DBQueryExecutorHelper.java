package helper.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

import engine.HikariDBManager;

/**
 * Helper class responsible for executing SQL queries using a database
 * connection
 * managed by {@link HikariDBManager}.
 *
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class DBQueryExecutorHelper {

    /**
     * Executes a SQL query and maps the first row of the result set into a custom
     * object.
     *
     * @param dbInfo database connection configuration
     * @param query  SQL query to execute
     * @param mapper function responsible for mapping a {@link ResultSet} row into a
     *               return object
     * @param params optional parameters used in the prepared statement
     * @param <T>    return type defined by the mapper
     * @return mapped object from the first row of the query result, or {@code null}
     *         if no rows are found
     *         (For Select querys will be returned null)
     *         <h3>Example usage</h3>
     * 
     *         <pre>{@code
     * String empNumber = DBQueryExecutorHelper.executeQuery(
     *     dbInfo,
     *     "SELECT emp_number FROM hs_hr_employee WHERE employee_id = ?",
     *     rs -> rs.getString("emp_number"),
     *     employeeId
     * );
     * }</pre>
     *         <p>
     *         Example returning a custom object:
     *         </p>
     * 
     *         <pre>{@code
     * Employee employee = DBQueryExecutorHelper.executeQuery(
     *     dbInfo,
     *     "SELECT employee_id, emp_firstname, emp_lastname FROM hs_hr_employee WHERE employee_id = ?",
     *     rs -> {
     *         Employee emp = new Employee();
     *         emp.setEmployeeId(rs.getString("employee_id"));
     *         emp.setFirstName(rs.getString("emp_firstname"));
     *         emp.setLastName(rs.getString("emp_lastname"));
     *         return emp;
     *     },
     *     employeeId, 
     *     other params...
     * );
     * }</pre>
     *
     * @throws IllegalStateException if the query execution fails
     */
    public static <T> T executeQuery(DBConnInfo dbInfo, String query, Function<ResultSet, T> mapper, Object... params) {
        try (
            Connection dbConnect = HikariDBManager.ConnectToDatabase(
                dbInfo.getDbType(),
                dbInfo.getServer(),
                dbInfo.getPort(),
                dbInfo.getDatabase(),
                dbInfo.getUsername(),
                dbInfo.getPassword()
            );
            PreparedStatement statement = dbConnect.prepareStatement(query)
        ) {
            if (params != null) {
                for (int i = 0; i < params.length; i++) statement.setObject(i + 1, params[i]);
            }
            System.out.println(statement.toString());
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) return mapper.apply(result);
                return null;
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to execute the query", e);
        }
    }
}

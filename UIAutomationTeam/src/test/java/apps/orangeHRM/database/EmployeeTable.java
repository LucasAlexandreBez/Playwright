package apps.orangeHRM.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import apps.orangeHRM.database.Model.HSHREmployee;
import config.PropertiesConfigLoader;
import engine.DatabaseType;
import engine.HikariDBManager;
import io.qameta.allure.Step;

public class EmployeeTable {

    String server = PropertiesConfigLoader.getPropertyValue("db.mysql.orangehrm.server");
    String port = PropertiesConfigLoader.getPropertyValue("db.mysql.orangehrm.port");
    String database = PropertiesConfigLoader.getPropertyValue("db.mysql.orangehrm.database");
    String username = PropertiesConfigLoader.getPropertyValue("db.mysql.orangehrm.username");
    String password = PropertiesConfigLoader.getPropertyValue("db.mysql.orangehrm.password");

    @Step("Get employee data by employee id {id}")
    public HSHREmployee getEmployeeDataByEmployeeId(String id) {
        String query = "SELECT employee_id, emp_firstname, emp_middle_name, emp_lastname FROM orangehrm.hs_hr_employee WHERE employee_id = ?";
        try (
            Connection dbConnect = HikariDBManager.ConnectToDatabase(DatabaseType.MYSQL, server, port, database, username, password);
            PreparedStatement statement = dbConnect.prepareStatement(query)
        ) {
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return new HSHREmployee(
                    result.getString("employee_id"),
                    result.getString("emp_lastname"),
                    result.getString("emp_middle_name"),
                    result.getString("emp_firstname")
                );
            }
            throw new IllegalStateException("Employee not found with id: " + id);
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to get employee details by id: " + id, e);
        }
    }
}

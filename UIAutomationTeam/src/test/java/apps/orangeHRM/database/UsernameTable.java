package apps.orangeHRM.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.PropertiesConfigLoader;
import engine.DatabaseType;
import engine.HikariDBManager;
import io.qameta.allure.Step;

public class UsernameTable {

    String server = PropertiesConfigLoader.getPropertyValue("db.mysql.orangehrm.server");
    String port = PropertiesConfigLoader.getPropertyValue("db.mysql.orangehrm.port");
    String database = PropertiesConfigLoader.getPropertyValue("db.mysql.orangehrm.database");
    String username = PropertiesConfigLoader.getPropertyValue("db.mysql.orangehrm.username");
    String password = PropertiesConfigLoader.getPropertyValue("db.mysql.orangehrm.password");

    @Step("Get employee login data by username {username}")
    public String getEmployeeLoginByEmployeeUsername(String user_name) {
        String query = "SELECT user_name FROM orangehrm.ohrm_user WHERE user_name = ?";
        try (
            Connection dbConnect = HikariDBManager.ConnectToDatabase(DatabaseType.MYSQL, server, port, database, username,password);
            PreparedStatement statement = dbConnect.prepareStatement(query)
        ) {
            statement.setString(1, user_name);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return result.getString("user_name");
            }
            throw new IllegalStateException("Employee not found with id: " + user_name);
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to get employee details by id: " + user_name, e);
        }
    }
}

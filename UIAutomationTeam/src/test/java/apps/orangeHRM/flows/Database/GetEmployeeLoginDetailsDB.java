package apps.orangeHRM.flows.Database;

import java.sql.SQLException;

import apps.orangeHRM.OrangeHRMDBInfo;
import helper.Database.DBQueryExecutorHelper;
import io.qameta.allure.Step;

public class GetEmployeeLoginDetailsDB {
    
    @Step("Get Employee Username Details By emp_number from database")
    public String getusernameByEmpNumber(String empNumber) {
        String query = """
            SELECT user_name FROM orangehrm.ohrm_user WHERE emp_number = ?;
        """;
        return DBQueryExecutorHelper.executeQuery(
            OrangeHRMDBInfo.getOrangeHRMDBConnInfo(), 
            query, 
            rs -> {
                try {
                    return rs.getString("user_name");
                } catch (SQLException e) {
                    throw new IllegalStateException("Failed to map the values...", e);
                }
            },
            empNumber
        );
    }

    @Step("Check if Employee login status is disabled by emp_number from database")
    public boolean isLoginUserDisabled(String empNumber) {
        String query = """
            SELECT status FROM orangehrm.ohrm_user WHERE emp_number = ?;
        """;
        return DBQueryExecutorHelper.executeQuery(
            OrangeHRMDBInfo.getOrangeHRMDBConnInfo(), 
            query, 
            rs -> {
                try {
                    return rs.getString("status").equals("0");
                } catch (SQLException e) {
                    throw new IllegalStateException("Failed to map the values...", e);
                }
            },
            empNumber
        );
    }
}

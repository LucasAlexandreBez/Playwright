package apps.orangeHRM.flows.Database;

import apps.orangeHRM.OrangeHRMDBInfo;
import apps.orangeHRM.models.database.OHRMUser;
import helper.Database.DBQueryExecutorHelper;
import io.qameta.allure.Step;

public class CreateNewUsernameDB {
    
    @Step("Create a new employee with login details and set Status as Enabled in database")
    public void createNewEmployeeUsername(OHRMUser username) {
        String addEmployeeQuery = "INSERT INTO orangehrm.ohrm_user\r\n" + 
                        "(user_role_id, emp_number, user_name, user_password, deleted, status)\r\n" + 
                        "VALUES(1, ?, ?, '$2y$12$tZ/EPxbtfHAO1IjdIwJgkuAzk9zjUqTBF.7zGaHBRBuF.7Z1yTKqK', 0, 1);";
        DBQueryExecutorHelper.executeQuery(
            OrangeHRMDBInfo.getOrangeHRMDBConnInfo(), 
            addEmployeeQuery, 
            null,
            username.getEmp_number(),
            username.getUser_name()
        );
    }
}

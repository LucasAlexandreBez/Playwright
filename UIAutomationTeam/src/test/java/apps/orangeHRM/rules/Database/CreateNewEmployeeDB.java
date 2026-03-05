package apps.orangeHRM.rules.Database;

import apps.orangeHRM.OrangeHRMDBInfo;
import apps.orangeHRM.models.database.HSHREmployee;
import helper.Database.DBQueryExecutorHelper;
import io.qameta.allure.Step;

public class CreateNewEmployeeDB {

    @Step("Create a new employee with login details and set Status as Enabled in database")
    public void createNewEmployee(HSHREmployee employee) {
        String addEmployeeQuery = "INSERT INTO orangehrm.hs_hr_employee(employee_id, emp_lastname, emp_firstname, emp_middle_name) VALUES(?, ?, ?, ?);";
        DBQueryExecutorHelper.executeQuery(
            OrangeHRMDBInfo.getOrangeHRMDBConnInfo(), 
            addEmployeeQuery, 
            null,
            employee.getEmployee_id(),
            employee.getEmp_lastname(),
            employee.getEmp_firstname(),
            employee.getEmp_middle_name()
        );
    }

}

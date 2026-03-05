package apps.orangeHRM.rules.Database;

import java.sql.SQLException;

import apps.orangeHRM.OrangeHRMDBInfo;
import apps.orangeHRM.models.database.HSHREmployee;
import helper.Database.DBQueryExecutorHelper;
import io.qameta.allure.Step;

public class GetEmployeeDetailsDB {
    
    @Step("Get employee_id,emp_lastname,emp_firstname,emp_middle_name Details By employee_id from database")
    public HSHREmployee getEmployeeDataByEmployeeId(String empNumber) {
        String query = """
            SELECT 
                emp_number,
                employee_id, 
                emp_lastname,
                emp_firstname,
                emp_middle_name
            FROM orangehrm.hs_hr_employee WHERE employee_id = ?;
        """;
        return DBQueryExecutorHelper.executeQuery(
            OrangeHRMDBInfo.getOrangeHRMDBConnInfo(), 
            query,
            rs -> {
                try {
                    HSHREmployee employee = new HSHREmployee();
                    employee.setEmp_number(rs.getString("emp_number"));
                    employee.setEmployee_id(rs.getString("employee_id"));
                    employee.setEmp_firstname(rs.getString("emp_firstname"));
                    employee.setEmp_lastname(rs.getString("emp_lastname"));
                    employee.setEmp_middle_name(rs.getString("emp_middle_name"));
                    return employee;
                } catch (SQLException e) {
                    throw new IllegalStateException("Failed to map the values...", e);
                }
            },
            empNumber
        );
    }

}

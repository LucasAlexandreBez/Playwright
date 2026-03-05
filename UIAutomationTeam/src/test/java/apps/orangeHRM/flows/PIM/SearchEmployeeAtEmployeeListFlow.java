package apps.orangeHRM.flows.PIM;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.microsoft.playwright.Page;

import apps.orangeHRM.flows.models.Employee;
import apps.orangeHRM.page.PIM.EmployeeListPage;
import io.qameta.allure.Step;

public class SearchEmployeeAtEmployeeListFlow {
    EmployeeListPage employeeList = new EmployeeListPage();
    @Step("Search employee at Employee List page")
    public void searchEmployeeById(Page page, Employee employee) {
        employeeList.searchEmployeeById(page, employee.getEmployeeId());
        assertTrue(
            employeeList.isTableRecordPresentingCorrectEmployeeId(page, employee.getEmployeeId()), 
            "Employee should be found in search results using Employee ID"
        );
        assertTrue(
            employeeList.isTableRecordPresentingCorrectEmployeeFirstAndMiddleName(page, employee.getFirstName() + " " + employee.getMiddleName()), 
            "Employee should be found in search results using First and Middle Name"
        );
        assertTrue(
            employeeList.isTableRecordPresentingCorrectEmployeeLastName(page, employee.getLastName()), 
            "Employee should be found in search results using Last Name"
        );
    }
}

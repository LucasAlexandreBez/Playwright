package apps.orangeHRM.flows.PIM;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.microsoft.playwright.Page;

import apps.orangeHRM.flows.models.Employee;
import apps.orangeHRM.page.PIM.AddEmployeePage;
import io.qameta.allure.Step;

public class CreateNewEmployeeFlow {
    
    AddEmployeePage addEmployeePage = new AddEmployeePage();
    
    @Step("Create a new employee with login details and enabled status")
    public void createNewEmployeeWithLoginDetailsEnabled(Page page, Employee employee) {
        assertTrue(!addEmployeePage.getEmployeeId(page).isBlank());
        if (employee.getProfileImagePath() != null) {
            addEmployeePage.setEmployeeProfileImage(page, employee.getProfileImagePath());
        }
        addEmployeePage.setEmployeeFirstName(page, employee.getFirstName());  
        if (employee.getMiddleName() != null) {
            addEmployeePage.setEmployeeMiddleName(page, employee.getMiddleName());
        }
        addEmployeePage.setEmployeeLastName(page, employee.getLastName());
        addEmployeePage.setEmployeeIdName(page, employee.getEmployeeId());

        addEmployeePage.swithcONCreateLoginDetails(page);
        addEmployeePage.setEmployeeUsername(page, employee.getUsername());
		addEmployeePage.setEmployeePassword(page, employee.getPassword());
		addEmployeePage.confirmEmployeePassword(page, employee.getPassword());
        addEmployeePage.setEmployeeLoginStatusToEnabled(page);

		addEmployeePage.clickOnSaveButton(page);
    }

    @Step("Create a new employee with login details and disabled status")
    public void createNewEmployeeWithLoginDetailsDisabled(Page page, Employee employee) {
        assertTrue(!addEmployeePage.getEmployeeId(page).isBlank());
        if (employee.getProfileImagePath() != null) {
            addEmployeePage.setEmployeeProfileImage(page, employee.getProfileImagePath());
        }
        addEmployeePage.setEmployeeFirstName(page, employee.getFirstName());  
        if (employee.getMiddleName() != null) {
            addEmployeePage.setEmployeeMiddleName(page, employee.getMiddleName());
        }
        addEmployeePage.setEmployeeLastName(page, employee.getLastName());
        addEmployeePage.swithcONCreateLoginDetails(page);
        addEmployeePage.setEmployeeUsername(page, employee.getUsername());
		addEmployeePage.setEmployeePassword(page, employee.getPassword());
		addEmployeePage.confirmEmployeePassword(page, employee.getPassword());
        addEmployeePage.setEmployeeLoginStatusToDisabled(page);
		addEmployeePage.clickOnSaveButton(page);
    }

    @Step("Create a new employee without login details")
    public void createNewEmployee(Page page, Employee employee) {
        assertTrue(!addEmployeePage.getEmployeeId(page).isBlank());
        if (employee.getProfileImagePath() != null) {
            addEmployeePage.setEmployeeProfileImage(page, employee.getProfileImagePath());
        }
        addEmployeePage.setEmployeeFirstName(page, employee.getFirstName());  
        if (employee.getMiddleName() != null) {
            addEmployeePage.setEmployeeMiddleName(page, employee.getMiddleName());
        }
        addEmployeePage.setEmployeeLastName(page, employee.getLastName());
        addEmployeePage.switchOFFCreateLoginDetails(page);
		addEmployeePage.clickOnSaveButton(page);
    }
}

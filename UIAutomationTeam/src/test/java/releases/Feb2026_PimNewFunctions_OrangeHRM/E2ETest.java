package releases.Feb2026_PimNewFunctions_OrangeHRM;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

import com.microsoft.playwright.TimeoutError;

import apps.orangeHRM.OrangeHRMTestBase;
import apps.orangeHRM.database.EmployeeTable;
import apps.orangeHRM.database.UsernameTable;
import apps.orangeHRM.database.Model.HSHREmployee;
import apps.orangeHRM.flows.LoginUserFlow;
import apps.orangeHRM.flows.PIM.CreateNewEmployeeFlow;
import apps.orangeHRM.flows.PIM.SearchEmployeeAtEmployeeListFlow;
import apps.orangeHRM.flows.models.Employee;
import apps.orangeHRM.page.LoggedUserOptions;
import apps.orangeHRM.page.MenuNavigation;
import apps.orangeHRM.page.PIM.EmployeeListPage;
import apps.orangeHRM.page.PIM.PimNavigation;
import config.PropertiesConfigLoader;
import helper.EmployeeFactory;
import io.qameta.allure.*;

@Epic("PIM functions - 2026")
@Feature("E2E flows")
public class E2ETest extends OrangeHRMTestBase {

    MenuNavigation menuNavigation = new MenuNavigation();
    PimNavigation pimNavigation = new PimNavigation();
    EmployeeListPage employeeList = new EmployeeListPage();

    CreateNewEmployeeFlow createNewEmployeeFlow = new CreateNewEmployeeFlow();
    SearchEmployeeAtEmployeeListFlow searchEmployeeAtEmployeeList = new SearchEmployeeAtEmployeeListFlow();
    LoggedUserOptions loggedUserOptions = new LoggedUserOptions();
    LoginUserFlow loginUserFlow = new LoginUserFlow();
    
    UsernameTable ohrmUserTable = new UsernameTable();
    EmployeeTable ohrmEmployeeTable = new EmployeeTable();

    String username = PropertiesConfigLoader.getPropertyValue("app.orangehrm.username");
    String password = PropertiesConfigLoader.getPropertyValue("app.orangehrm.pwd");

    @BeforeEach
    public void setupTest() {
        super.setupTest();
        loginUserFlow.loginUserSuccessfully(page, username, password);
    }

    @Story("Employee")
    @Owner("Lucas Alexandre")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("E2E")
    @Tag("Release_Feb2026")
    @DisplayName("Verify if after creating a employee with login details and set Status as Enabled, then system allow user to login")
    @Description("1. Login to OrangeHRM as Admin\n"
            + "2. Go to PIM page\n"
            + "3. Click on Add Employee button\n"
            + "4. Fill in the employee details and enable login details with status enabled\n"
            + "5. Save the employee\n"
            + "6. Logout from Admin account\n"
            + "7. Login with the newly created employee credentials\n"
            + "8. Verify that the employee can login successfully")
    @Test
    public void createNewEmployeeAndLoginDetailsEnabled() {
        Employee employee = EmployeeFactory.createRandomEmployee();
        employee.setProfileImagePath("src/test/resources/UploadFiles/img/qa.png");

        menuNavigation.accessPIMPage(page);
        employeeList.clickOnAdd(page);
        
        createNewEmployeeFlow.createNewEmployeeWithLoginDetailsEnabled(page, employee);
        pimNavigation.accessEmployeeListPage(page);
        searchEmployeeAtEmployeeList.searchEmployeeById(page, employee);

        loggedUserOptions.logout(page);
        loginUserFlow.loginUserSuccessfully(page, employee.getUsername(), employee.getPassword());

        Allure.step("Verify that non Admin user can't access Admin page", () -> {
            TimeoutError error = assertThrows(TimeoutError.class, () -> {
            menuNavigation.accessAdminPage(page);
            });
            assertTrue(error.getMessage().contains("Timeout"));
        });
        Allure.step("Verify that non Admin user can't access PIM page", () -> {
            TimeoutError error = assertThrows(TimeoutError.class, () -> {
            menuNavigation.accessPIMPage(page);
            });
            assertTrue(error.getMessage().contains("Timeout"));
        });

        String usernameResult = ohrmUserTable.getEmployeeLoginByEmployeeUsername(employee.getUsername());
        assertEquals(
            employee.getUsername(),
            usernameResult, 
        "Employee username in database should match the one provided during employee creation"
        );

        HSHREmployee employeeResult = ohrmEmployeeTable.getEmployeeDataByEmployeeId(employee.getEmployeeId());
        assertEquals(
            employee.getEmployeeId(),
            employeeResult.getEmployee_id(), 
        "Employee Id in database should match the one provided during employee creation"
        );
        assertEquals(
            employee.getFirstName(),
            employeeResult.getEmp_firstname(), 
        "Employee first name in database should match the one provided during employee creation"
        );
        assertEquals(
            employee.getMiddleName(),
            employeeResult.getEmp_middle_name(), 
        "Employee middle name in database should match the one provided during employee creation"
        );
        assertEquals(
            employee.getLastName(),
            employeeResult.getEmp_lastname(), 
        "Employee last name in database should match the one provided during employee creation"
        );
    }

}

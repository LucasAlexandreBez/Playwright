package releases.Feb2026_PimNewFunctions_OrangeHRM;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

import com.microsoft.playwright.TimeoutError;

import apps.orangeHRM.OrangeHRMTestBase;
import apps.orangeHRM.models.Employee;
import apps.orangeHRM.models.database.HSHREmployee;
import apps.orangeHRM.page.LoggedUserOptions;
import apps.orangeHRM.page.MenuNavigation;
import apps.orangeHRM.page.PIM.EmployeeListPage;
import apps.orangeHRM.page.PIM.PimNavigation;
import apps.orangeHRM.rules.LoginUserFlow;
import apps.orangeHRM.rules.Database.GetEmployeeDetailsDB;
import apps.orangeHRM.rules.Database.GetEmployeeLoginDetailsDB;
import apps.orangeHRM.rules.PIM.CreateNewEmployeeFlow;
import apps.orangeHRM.rules.PIM.SearchEmployeeAtEmployeeListFlow;
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

    GetEmployeeDetailsDB HSHREmployeeTable = new GetEmployeeDetailsDB();
    GetEmployeeLoginDetailsDB ohrmUserTable = new GetEmployeeLoginDetailsDB();

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
    @DisplayName("TC01_Verify if after creating a employee with login details and set Status as Enabled, then system allow user to login")
    @Description("1. Login to OrangeHRM as Admin\n"
            + "2. Go to PIM page\n"
            + "3. Click on Add Employee button\n"
            + "4. Fill in the employee details and enable login details with status enabled\n"
            + "5. Save the employee\n"
            + "6. Logout from Admin account\n"
            + "7. Login with the newly created employee credentials\n"
            + "8. Verify that the employee can login successfully")
    @Test
    public void createNewEmployee_WithLoginDetails_StatusEnabled() {
        Employee employee = EmployeeFactory.createRandomEmployee();

        // E2E
        employee.setProfileImagePath("src/test/resources/UploadFiles/img/qa.png");
        menuNavigation.accessPIMPage(page);
        employeeList.clickOnAdd(page);
        createNewEmployeeFlow.createNewEmployeeWithLoginDetails_StatusEnabled(page, employee);
        pimNavigation.accessEmployeeListPage(page);
        searchEmployeeAtEmployeeList.searchEmployeeById(page, employee);
        loggedUserOptions.logout(page);
        loginUserFlow.loginUserSuccessfully(page, employee.getUsername(), employee.getPassword());
        Allure.step("Verify that non Admin user can't access Admin/PIM page", () -> {
            TimeoutError errorAdmin = assertThrows(TimeoutError.class, () -> {
                menuNavigation.accessAdminPage(page);
            });
            assertTrue(errorAdmin.getMessage().contains("Timeout"));
            
            TimeoutError errorPIM = assertThrows(TimeoutError.class, () -> {
                menuNavigation.accessPIMPage(page);
            });
            assertTrue(errorPIM.getMessage().contains("Timeout"));
        });

        // DB
        HSHREmployee employeeQueryResult = HSHREmployeeTable.getEmployeeDataByEmployeeId(employee.getEmployeeId());
        System.out.println("Employee data retrieved from database: " + employeeQueryResult);
        assertEquals(
            employee.getEmployeeId(),
            employeeQueryResult.getEmployee_id(), 
        "Employee Id in database should match the one provided during employee creation"
        );
        assertEquals(
            employee.getFirstName(),
            employeeQueryResult.getEmp_firstname(), 
        "Employee first name in database should match the one provided during employee creation"
        );
        assertEquals(
            employee.getMiddleName(),
            employeeQueryResult.getEmp_middle_name(), 
        "Employee middle name in database should match the one provided during employee creation"
        );
        assertEquals(
            employee.getLastName(),
            employeeQueryResult.getEmp_lastname(), 
        "Employee last name in database should match the one provided during employee creation"
        );

        String usernameResult = ohrmUserTable.getusernameByEmpNumber(employeeQueryResult.getEmp_number());
        System.out.println("Username in database: " + usernameResult);
        assertEquals(
            employee.getUsername(),
            usernameResult, 
        "Employee username in database should match the one provided during employee creation"
        );
    }

    @Story("Employee")
    @Owner("Lucas Alexandre")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("E2E")
    @Tag("Release_Feb2026")
    @DisplayName("TC02_Verify if after creating a employee with login details and set Status as Disabled, then system shouldn't allow user to login")
    @Description("1. Login to OrangeHRM as Admin\n"
            + "2. Go to PIM page\n"
            + "3. Click on Add Employee button\n"
            + "4. Fill in the employee details and enable login details with status disabled\n"
            + "5. Save the employee\n"
            + "6. Logout from Admin account\n"
            + "7. Login with the newly created employee credentials\n"
            + "8. Verify that the employee can't login on system")
    @Test
    public void createNewEmployee_WithLoginDetails_StatusDisabled() {
        Employee employee = EmployeeFactory.createRandomEmployee();

        // E2E
        menuNavigation.accessPIMPage(page);
        employeeList.clickOnAdd(page);
        createNewEmployeeFlow.createNewEmployeeWithLoginDetails_StatusDisabled(page, employee);
        pimNavigation.accessEmployeeListPage(page);
        searchEmployeeAtEmployeeList.searchEmployeeById(page, employee);
        loggedUserOptions.logout(page);
        loginUserFlow.loginUserSuccessfully(page, employee.getUsername(), employee.getPassword());
        loginUserFlow.verifyIfSystemPresentWarningMessagForDisabledUser(page, employee.getUsername(), employee.getPassword());
    
        //DB
        HSHREmployee employeeQueryResult = HSHREmployeeTable.getEmployeeDataByEmployeeId(employee.getEmployeeId());
        System.out.println("Employee query result: " + employeeQueryResult);
        assertEquals(
            employee.getEmployeeId(),
            employeeQueryResult.getEmployee_id(), 
        "Employee Id in database should match the one provided during employee creation"
        );
        assertEquals(
            employee.getFirstName(),
            employeeQueryResult.getEmp_firstname(), 
        "Employee first name in database should match the one provided during employee creation"
        );
        assertEquals(
            employee.getMiddleName(),
            employeeQueryResult.getEmp_middle_name(), 
        "Employee middle name in database should match the one provided during employee creation"
        );
        assertEquals(
            employee.getLastName(),
            employeeQueryResult.getEmp_lastname(), 
        "Employee last name in database should match the one provided during employee creation"
        );

        boolean isDisabled = ohrmUserTable.isLoginUserDisabled(employeeQueryResult.getEmp_number());
        System.out.println("Username in database: " + isDisabled);
        assertTrue(
            isDisabled, 
        "Employee username in database should match the one provided during employee creation"
        );
    }
}

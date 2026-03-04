package releases.Feb2026_PimNewFunctions_OrangeHRM;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

import apps.orangeHRM.OrangeHRMTestBase;
import apps.orangeHRM.page.MenuNavigation;
import apps.orangeHRM.page.PIM.AddEmployeePage;
import apps.orangeHRM.page.PIM.EmployeeList;
import io.qameta.allure.*;

@Epic("PIM functions - 2026")
@Feature("E2E flows")
public class E2ETest extends OrangeHRMTestBase{

    MenuNavigation menuNavigation = new MenuNavigation();
    EmployeeList employeeList = new EmployeeList();
    AddEmployeePage addEmployeePage = new AddEmployeePage();

    // TC01_Verify if after creating a employee with login details and set Status as Enabled, 
    // then system allow user to login
    @Story("Employee")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.CRITICAL)
	@Tag("E2E")
	@Tag("Release_Feb2026")
	@DisplayName("Verify if after creating a employee with login details and set Status as Enabled, then system allow user to login")
	@Description(useJavaDoc = true)
	@Test
    public void createNewEmployeeAndLoginDetailsEnabled(){
        menuNavigation.accessPIMPage(page);
        employeeList.clickOnAdd(page);
        assertTrue(addEmployeePage.verifySystemAlreadyFillTheEmpoyeeIDAutomatically(page));
        addEmployeePage.createNewEmployee(
            page, 
            true, 
            true, 
            null, 
            null, 
            null, 
            null, 
            null, 
            null
        );
    } 


}

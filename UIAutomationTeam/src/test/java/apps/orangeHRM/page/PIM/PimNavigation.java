package apps.orangeHRM.page.PIM;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import io.qameta.allure.Step;

public class PimNavigation {

    @Step("Click on Configuration menu button")
	public void clickOnConfigurationMenuButton(Page page) {
		page.getByText("Configuration").click();
	}

    @Step("Access the Optional Fields page")
	public void accessOptionalFieldsPage(Page page) {
        clickOnConfigurationMenuButton(page);
		page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Optional Fields")).click();
	}

    @Step("Access the Custom Fields page")
	public void accessCustomFieldsPage(Page page) {
        clickOnConfigurationMenuButton(page);
		page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Custom Fields")).click();
	}

    @Step("Access the Data Import page")
	public void accessDataImportPage(Page page) {
        clickOnConfigurationMenuButton(page);
		page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Data Import")).click();
	}

    @Step("Access the Reporting Methods page")
	public void accessReportingMethodsPage(Page page) {
        clickOnConfigurationMenuButton(page);
		page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Reporting Methods")).click();
	}
    
    @Step("Access the Termination Reasons page")
	public void accessTerminationReasonsPage(Page page) {
        clickOnConfigurationMenuButton(page);
		page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Termination Reasons")).click();
	}

    @Step("Access the Employee List page")
	public void accessEmployeeListPage(Page page) {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Employee List")).click();
	}

    @Step("Access the Add Employee page")
	public void accessAddEmployeePage(Page page) {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add Employee")).click();
	}

    @Step("Access the Reports page")
	public void accessReportsPage(Page page) {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Reports")).click();
	}
}

package apps.orangeHRM.page.PIM;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import io.qameta.allure.Step;

public class EmployeeListPage {
    
    @Step("Click on Add button")
	public void clickOnAdd(Page page) {
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add ")).click();
	}

	@Step("Search employee by ID: {employeeId}")
	public void searchEmployeeById(Page page, String employeeId) {
	    page.locator(".oxd-input-group:has(label:text-is('Employee Id')) input").fill(employeeId);
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search")).click();
	}

	@Step("Verify if the employee with ID: {employeeId} is present in the search results")
	public boolean isTableRecordPresentingCorrectEmployeeId(Page page, String employeeId) {
	    return page.getByText(employeeId) != null;
	}

	@Step("Verify if the employee with First(& Middle) Name: {firstAndMiddleName} is present in the search results")
	public boolean isTableRecordPresentingCorrectEmployeeFirstAndMiddleName(Page page, String firstAndMiddleName) {
	    return page.getByText(firstAndMiddleName) != null;
	}

	@Step("Verify if the employee with First(& Middle) Name: {lastName} is present in the search results")
	public boolean isTableRecordPresentingCorrectEmployeeLastName(Page page, String lastName) {
	    return page.getByText(lastName) != null;
	}
}

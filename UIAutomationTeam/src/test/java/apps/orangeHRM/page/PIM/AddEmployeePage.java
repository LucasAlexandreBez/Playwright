package apps.orangeHRM.page.PIM;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import io.qameta.allure.Step;

public class AddEmployeePage {

	@Step("Set the employee first name with value {firstname}")
	public void setEmployeeFirstName(Page page, String firstName) {
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).click();
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill(firstName);
	}
	
	@Step("Set the employee first name with value {middleName}")
	public void setEmployeeMiddleName(Page page, String middleName) {
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Middle Name")).click();
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Middle Name")).fill(middleName);
	}
	
	@Step("Set the employee first name with value {lastName}")
	public void setEmployeeLastName(Page page, String lastName) {
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).click();
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).fill(lastName);
	}
	
	@Step("Set the employee id with value {id}")
	public void setEmployeeIdName(Page page, String id) {
	    page.getByRole(AriaRole.TEXTBOX).nth(4).click();
	    page.getByRole(AriaRole.TEXTBOX).nth(4).fill(id);
	}
	
	@Step("Switch on the Create Login Details")
	public void swithcONCreateLoginDetails(Page page) {
		boolean isChecked = page.locator(".oxd-switch-input").isChecked();
		if (!isChecked) {
			page.locator(".oxd-switch-input").click();
		}
	}
	
	@Step("Switch off the Create Login Details")
	public void switchOFFCreateLoginDetails(Page page) {
		boolean isChecked = page.locator(".oxd-switch-input").isChecked();
		if (isChecked) {
			page.locator(".oxd-switch-input").click();
		}
	}
}

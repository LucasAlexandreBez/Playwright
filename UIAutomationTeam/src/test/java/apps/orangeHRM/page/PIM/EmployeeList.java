package apps.orangeHRM.page.PIM;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import io.qameta.allure.Step;

public class EmployeeList {
    
    @Step("Click on '+ Add' button")
	public void clickOnAdd(Page page) {
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("+ Add")).click();
	}
}

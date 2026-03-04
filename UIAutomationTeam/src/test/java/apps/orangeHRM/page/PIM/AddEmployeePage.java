package apps.orangeHRM.page.PIM;

import java.nio.file.Paths;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import io.qameta.allure.Step;

public class AddEmployeePage {

	@Step("Set the employee profile picture")
	public void setEmployeeProfileImage(Page page, String filePath) {
		FileChooser fileChooser = page.waitForFileChooser(() -> {
			page.locator("form").getByRole(AriaRole.IMG, new Locator.GetByRoleOptions().setName("profile picture")).click(); 
		});
		fileChooser.setFiles(Paths.get(filePath));
	}

	@Step("Set the employee first name with value {firstname}")
	public void setEmployeeFirstName(Page page, String firstName) {
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).click();
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill(firstName);
	}
	
	@Step("Set the employee middle name with value {middleName}")
	public void setEmployeeMiddleName(Page page, String middleName) {
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Middle Name")).click();
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Middle Name")).fill(middleName);
	}
	
	@Step("Set the employee last name with value {lastName}")
	public void setEmployeeLastName(Page page, String lastName) {
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).click();
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).fill(lastName);
	}
	
	@Step("Set the employee id with value {id}")
	public void setEmployeeIdName(Page page, String id) {
		page.getByLabel("Employee Id").fill(id);
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

	@Step("Set the employee username with value {username}")
	public void setEmployeeUsername(Page page, String username) {
		page.getByLabel("Username").fill(username);
	}

	@Step("Set the employee password")
	public void setEmployeePassword(Page page, String password) {
		page.getByLabel("Password").fill(password);
	}

	@Step("Re-type the employee password")
	public void confirmEmployeePassword(Page page, String password) {
		page.getByLabel("Confirm Password").fill(password);
	}

	@Step("Set the employee login status to enabled")
	public void setEmployeeLoginStatusToEnabled(Page page) {
		page.getByText("Enabled").check();
	}

	@Step("Set the employee login status to enabled")
	public void setEmployeeLoginStatusToDisabled(Page page) {
		page.getByText("Disabled").check();
	}

	@Step("Click on save button")
	public void clickOnSaveButton(Page page) {
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
	}

	@Step("Click on cancel button")
	public void clickOnCancelButton(Page page) {
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel")).click();
	}

	@Step("Verify Employee ID is automatically fullfilled by system")
	public boolean verifySystemAlreadyFillTheEmpoyeeIDAutomatically(Page page){
		return !page.getByLabel("Employee Id").getAttribute("value").isBlank();
	}

	@Step("Fill the new employee register form and submit successfully")
	public void createNewEmployee(
		Page page, 
		boolean withEmployeeLoginDetails, 
		boolean isEmployeeLoginEnabled,
		String profileImagePath,
		String firstName,
		String middleName,
		String lastName,
		String username,
		String password
	){
		setEmployeeProfileImage(page, profileImagePath);
		setEmployeeFirstName(page, firstName);
		setEmployeeMiddleName(page, middleName);
		setEmployeeLastName(page, lastName);

		swithcONCreateLoginDetails(page);
		setEmployeeUsername(page, username);
		setEmployeePassword(page, password);
		confirmEmployeePassword(page, password);
		if (!isEmployeeLoginEnabled) {setEmployeeLoginStatusToDisabled(page);} 
		else { setEmployeeLoginStatusToEnabled(page);}
		clickOnSaveButton(page);
	}

}

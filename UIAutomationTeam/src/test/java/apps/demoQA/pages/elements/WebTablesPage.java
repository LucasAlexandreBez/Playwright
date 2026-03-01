package apps.demoQA.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import apps.demoQA.models.elements.WebTablesRegister;
import io.qameta.allure.Step;

public class WebTablesPage {

	@Step("Open the Registration Form to add a new register")
	public void openRegistrationForm(Page page) {
		page.locator("#addNewRecordButton").click();
	}
	
	@Step("Fill the First Name Input with value {firstName}")
	public void fillFirstNameInput(Page page, String firstName) {
		page.locator("#firstName").fill(firstName);
	}
	
	@Step("Fill the Last Name Input with value {lastName}")
	public void fillLastNameInput(Page page, String lastName) {
		page.locator("#lastName").fill(lastName);
	}
	
	@Step("Fill the Email Input with value {email}")
	public void fillEmailInput(Page page, String email) {
		page.locator("#userEmail").fill(email);
	}
	
	@Step("Fill the Age Input with value {age}")
	public void fillAgeInput(Page page, String age) {
		page.locator("#age").fill(age);
	}
	
	@Step("Fill the Salary Input with value {salary}")
	public void fillSalaryInput(Page page, String salary) {
		page.locator("#salary").fill(salary);
	}
	
	@Step("Fill the Department Input with value {department}")
	public void fillDepartmentInput(Page page, String department) {
		page.locator("#department").fill(department);
	}
	
	@Step("Click on submit button at Registration Form")
	public void clickOnSubmitAtRegistrationForm(Page page) {
		page.locator("#submit").click();;
	}
	
	@Step("Register a new entry in Registration Form with success")
	public void fillRegistrationForm(Page page, WebTablesRegister register) {
		openRegistrationForm(page);
		fillFirstNameInput(page, register.getFirstName());
		fillLastNameInput(page, register.getLastName());
		fillEmailInput(page, register.getEmail());
		fillAgeInput(page, register.getAge());
		fillSalaryInput(page, register.getSalary());
		fillDepartmentInput(page, register.getDepartment());
		clickOnSubmitAtRegistrationForm(page);
	}
	
	@Step("Search a register with value {searchWithValue}")
	public void searchRegisterUsingTheSearchInput(Page page, String searchWithValue) {
		page.locator("#searchBox").fill(searchWithValue);
	}
	
	@Step("Get the matching register row from Web Table")
	public Locator getRowByValue(Page page, WebTablesRegister register) {
		Locator rows = page.locator(".rt-tbody .rt-tr").filter(new Locator.FilterOptions().setHasNot(page.locator(".-padRow")));
		for (int i = 0; i < rows.count(); i++) {
	        Locator row = rows.nth(i);
	        String rowText = row.innerText();
	        if (rowText.contains(register.getFirstName()) && rowText.contains(register.getLastName()) &&
	        	rowText.contains(register.getEmail()) && rowText.contains(register.getAge()) &&
	        	rowText.contains(register.getSalary()) && rowText.contains(register.getDepartment())
	        ) {
	        	return row;
			}
	    }
	    return null;
	}
	
	@Step("Click on 'Edit' button that matching register row from Web Table")
	public void clickEditOnRow(Page page, WebTablesRegister register) {
	    Locator row = getRowByValue(page, register);
	    if (row == null) {
	        throw new AssertionError(
	            "Row not found for register: " + register
	        );
	    }
	    row.locator("[id^='edit-record']").click();
	}

	@Step("Click on 'Remove' button that matching register row from Web Table")
	public void clickDeleteOnRow(Page page, WebTablesRegister register) {
	    Locator row = getRowByValue(page, register);
	    if (row == null) {
	        throw new AssertionError(
	            "Row not found for register: " + register
	        );
	    }
	    row.locator("[id^='delete-record']").click();
	}

}

package apps.demoQA.pages.elements;


import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import io.qameta.allure.Step;

public class TextBoxPage{

	@Step("Write {name} on Full Name input")
	public void WriteOnFullNameInput(Page page, String name) {
		page.locator("#userName").fill(name);
	}
	
	@Step("Write {email} on Email input")
	public void writeOnEmailInput(Page page, String email) {
		page.locator("#userEmail").fill(email);
	}
	
	@Step("Write {currentAddress} on Current Address input")
	public void writeOnCurrentAddressInput(Page page, String currentAddress) {
		page.locator("#currentAddress").fill(currentAddress);
	}
	
	@Step("Write {permantAddress} on Permanent Address input")
	public void writeOnPermanentAddressInput(Page page, String permantAddress) {
		page.locator("#permanentAddress").fill(permantAddress);
	}
	
	@Step("Fill the Text Box Form and submit")
	public void fillAllInputsInTheFormInput(Page page, String name, String email, String currentAddress, String permantAddress) {
		WriteOnFullNameInput(page, name);
		writeOnEmailInput(page, email);
		writeOnCurrentAddressInput(page, currentAddress);
		writeOnPermanentAddressInput(page, permantAddress);
		page.locator("#submit").click();
	}
	
	@Step("Verify output value from Text Box Form")
	public List<String> getOutputValues(Page page) {
		page.locator("#output").scrollIntoViewIfNeeded();
	    Locator outpuValueList = page.locator("#output").locator("p");
	    return outpuValueList.allInnerTexts();
	}
}

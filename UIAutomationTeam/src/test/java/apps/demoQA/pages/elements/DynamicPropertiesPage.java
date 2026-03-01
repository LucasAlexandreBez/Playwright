package apps.demoQA.pages.elements;

import com.microsoft.playwright.Page;

import com.microsoft.playwright.Locator;

import io.qameta.allure.Step;

public class DynamicPropertiesPage {

	@Step("Get Id from the paragraph 'This text has random Id'")
	public String getRandomIdFromParagraph(Page page) {
		return page.getByText("This text has random Id").getAttribute("id");
	}
	
	@Step("Get button 'Will enable 5 seconds' button")
	public Locator getButtonWillEnable5Seconds(Page page) {
		return page.locator("#enableAfter");
	}
	
	@Step("Get button 'Visible after 5 seconds' button")
	public Locator getButtonVisibleAfter5Seconds(Page page) {
		return page.locator("#visibleAfter");
	}

	@Step("Get button 'Color change' button")
	public Locator getButtonColorChange(Page page) {
		return page.locator("#colorChange");
	}
}

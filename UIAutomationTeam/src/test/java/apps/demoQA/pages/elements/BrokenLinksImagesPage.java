package apps.demoQA.pages.elements;

import com.microsoft.playwright.Page;

import io.qameta.allure.Step;

public class BrokenLinksImagesPage {

	@Step("Verify if valid image is visible")
	public boolean verifyBrokenImage(Page page) {
		page.locator("img").nth(2).scrollIntoViewIfNeeded();
		return page.locator("img").nth(2).isVisible();
	}
}

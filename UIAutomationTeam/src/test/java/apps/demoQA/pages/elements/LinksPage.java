package apps.demoQA.pages.elements;

import com.microsoft.playwright.Page;

import io.qameta.allure.Step;

public class LinksPage {
	
	@Step("Click on Home link")
    public Page clickOnHomeLinkAndGetNewTab(Page page) {
	    return page.waitForPopup(() -> {
	        page.locator("#simpleLink").click();
	    });
    }
	
	@Step("Click on Dynamic Home link")
    public Page clickOnDynamicHomeLinkAndGetNewTab(Page page) {
	    return page.waitForPopup(() -> {
	    	page.locator("#dynamicLink").click();
	    });
    }

	@Step("Click on Created link")
    public void clickOnCreatedLink(Page page) {
        page.locator("#created").click();
    }

    @Step("Click on No Content link")
    public void clickOnNoContentLink(Page page) {
        page.locator("#no-content").click();
    }

    @Step("Click on Moved link")
    public void clickOnMovedLink(Page page) {
        page.locator("#moved").click();
    }

    @Step("Click on Bad Request link")
    public void clickOnBadRequestLink(Page page) {
        page.locator("#bad-request").click();
    }

    @Step("Click on Unauthorized link")
    public void clickOnUnauthorizedLink(Page page) {
        page.locator("#unauthorized").click();
    }

    @Step("Click on Forbidden link")
    public void clickOnForbiddenLink(Page page) {
        page.locator("#forbidden").click();
    }

    @Step("Click on Not Found URL link")
    public void clickOnNotFoundLink(Page page) {
        page.locator("#invalid-url").click();
    }

    @Step("Get link response message")
    public String getResponseMessage(Page page) {
        return page.locator("#linkResponse").innerText();
    }
}

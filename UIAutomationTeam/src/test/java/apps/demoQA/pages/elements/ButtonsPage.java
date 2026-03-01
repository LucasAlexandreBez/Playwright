package apps.demoQA.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;

import io.qameta.allure.Step;

public class ButtonsPage {

	@Step("Execute a double click on button")
	public void doubleClickOnButton(Page page) {
		page.locator("#doubleClickBtn").dblclick();
	}
	
	@Step("Execute a righ click on button")
	public void rightClickOnButton(Page page) {
		page.locator("#rightClickBtn").click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
	}
	
	@Step("Execute a dynamic click on button")
	public void dynamicClickOnButton(Page page) {
	    page.getByText("Click Me", new Page.GetByTextOptions().setExact(true)).click();
	}
	
    @Step("Get double click message")
    public String getDoubleClickMessage(Page page) {
        return page.locator("#doubleClickMessage").textContent();
    }

    @Step("Get right click message")
    public String getRightClickMessage(Page page) {
        return page.locator("#rightClickMessage").textContent();
    }

    @Step("Get dynamic click message")
    public String getDynamicClickMessage(Page page) {
        return page.locator("#dynamicClickMessage").textContent();
    }
}

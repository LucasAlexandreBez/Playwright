package apps.orangeHRM.page;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import io.qameta.allure.Step;

public class LoginPage {

    @Step("Fill Username input with {username}")
    public void fillUsernameInput(Page page, String username) {
        page.getByPlaceholder("Username").fill(username);
    }
    
    @Step("Fill Password input")
    public void fillPasswordInput(Page page, String password) {
        page.getByPlaceholder("Password").fill(password);
    }
    
    @Step("Click on Login button")
    public void clickLoginInput(Page page) {
    	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
    
    @Step("Click on 'Forgot your password?' link")
    public void clickForgotYourPasswordLink(Page page) {
    	page.getByText("Forgot your password?").click();
    }

    @Step("Get 'Account disabled' message value")
    public String getAccountDisabledMessage(Page page) {
        return page.locator(".oxd-alert-content:has(p:has-text('Account disabled'))").innerText();
    }

    @Step("Is 'Account disabled' warning visible on page")
    public boolean isAccountDisabledWarningVisible(Page page) {
        return page.locator(".oxd-alert-content:has(p:has-text('Account disabled'))").isVisible();
    }
}

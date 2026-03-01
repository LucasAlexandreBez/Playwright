package apps.orangeHRM.page;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import io.qameta.allure.Step;

public class LoginPage {

    @Step("Fill Username input with {username}")
    public void fillUsernameInput(Page page, String username) {
        page.getByLabel("Username").fill(username);
    }
    
    @Step("Fill Password input")
    public void fillPasswordInput(Page page, String password) {
        page.getByLabel("Password").fill(password);
    }
    
    @Step("Click on Login button")
    public void clickLoginInput(Page page) {
    	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
    
    @Step("Click on 'Forgot your password?' link")
    public void clickForgotYourPasswordLink(Page page) {
    	page.getByText("Forgot your password?").click();
    }
    
    @Step("Fill the Login form and access OrangeHRM Dashboard")
    public void fillTheLoginFormAccessOrangeHRM(Page page, String username, String password) {
        fillUsernameInput(page, username);
        fillPasswordInput(page, password);
        clickLoginInput(page);
    }
}

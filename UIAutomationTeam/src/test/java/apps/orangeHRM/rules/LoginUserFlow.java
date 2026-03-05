package apps.orangeHRM.rules;

import com.microsoft.playwright.Page;

import static org.junit.jupiter.api.Assertions.*;

import apps.orangeHRM.page.LoginPage;
import io.qameta.allure.Step;

public class LoginUserFlow {

    LoginPage loginPage = new LoginPage();

    @Step("Fill the Login form and access OrangeHRM Dashboard")
    public void loginUserSuccessfully(Page page, String username, String password) {
        System.out.println("Attempting to login with enabled user: " + username + " and password: " + password);
        loginPage.fillUsernameInput(page, username);
        loginPage.fillPasswordInput(page, password);
        loginPage.clickLoginInput(page);
    }

    @Step("Verify if 'Account Disabled' warning is displayed when trying to login with a disabled user")
    public void verifyIfSystemPresentWarningMessagForDisabledUser(Page page, String username, String password) {
        System.out.println("Attempting to login with disabled user: " + username + " and password: " + password);
        loginPage.fillUsernameInput(page, username);
        loginPage.fillPasswordInput(page, password);
        loginPage.clickLoginInput(page);
        assertEquals("Account disabled",loginPage.getAccountDisabledMessage(page), "Expected 'Account disabled' message to be displayed, but it was not.");
        assertTrue(loginPage.isAccountDisabledWarningVisible(page), "Expected 'Account disabled' message to be visible, but it was not.");
    }
}

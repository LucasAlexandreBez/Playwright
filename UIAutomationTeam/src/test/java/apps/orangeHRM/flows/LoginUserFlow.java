package apps.orangeHRM.flows;

import com.microsoft.playwright.Page;

import static org.junit.jupiter.api.Assertions.*;

import apps.orangeHRM.page.LoginPage;
import io.qameta.allure.Step;

public class LoginUserFlow {

    LoginPage loginPage = new LoginPage();

    @Step("Fill the Login form and access OrangeHRM Dashboard")
    public void loginUserSuccessfully(Page page, String username, String password) {
        loginPage.fillUsernameInput(page, username);
        loginPage.fillPasswordInput(page, password);
        loginPage.clickLoginInput(page);
    }
}

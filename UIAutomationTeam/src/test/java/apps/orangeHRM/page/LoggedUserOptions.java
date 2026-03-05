package apps.orangeHRM.page;

import com.microsoft.playwright.Page;

import io.qameta.allure.Step;

public class LoggedUserOptions {

    @Step("Access logged user options menu")
    public void accessLoggedUserOptions(Page page) {
        page.locator(".oxd-userdropdown-tab").click();
    }
    
    @Step("Logout from the system")
    public void logout(Page page) {
        accessLoggedUserOptions(page);
        page.locator("a.oxd-userdropdown-link:has-text('Logout')").click();
    }
}

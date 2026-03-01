package apps.demoQA.pages;

import java.util.regex.Pattern;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import io.qameta.allure.Step;

public class DemoQaMenuPage {

    // =============================== HELPERS ===============================

    public void clickMenuItem(Page page, String text) {
        page.getByText(text, new Page.GetByTextOptions().setExact(true)).click();
    }

    public boolean isExpanded(Locator locator) {
        return locator.getAttribute("class").contains("show");
    }

    // =============================== ELEMENTS ===============================

    @Step("Access Elements menu")
    public void accessElementsMenu(Page page) {
        page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions().setName("Elements")
        ).click();

        Locator list = page.locator(".element-list").first();
        if (!isExpanded(list)) {
            page.locator(".header-wrapper").first().click();
        }
    }

    @Step("Access Text Box page")
    public void accessTextBoxPage(Page page) {
        accessElementsMenu(page);
        clickMenuItem(page, "Text Box");
    }

    @Step("Access Check Box page")
    public void accessCheckBoxPage(Page page) {
        accessElementsMenu(page);
        clickMenuItem(page, "Check Box");
    }

    @Step("Access Radio Button page")
    public void accessRadioButtonPage(Page page) {
        accessElementsMenu(page);
        clickMenuItem(page, "Radio Button");
    }

    @Step("Access Web Tables page")
    public void accessWebTablesPage(Page page) {
        accessElementsMenu(page);
        clickMenuItem(page, "Web Tables");
    }

    @Step("Access Buttons page")
    public void accessButtonsPage(Page page) {
        accessElementsMenu(page);
        clickMenuItem(page, "Buttons");
    }

    @Step("Access Links page")
    public void accessLinksPage(Page page) {
        accessElementsMenu(page);
        clickMenuItem(page, "Links");
    }

    @Step("Access Broken Links Images page")
    public void accessBrokenLinksImagesPage(Page page) {
        accessElementsMenu(page);
        clickMenuItem(page, "Broken Links - Images");
    }

    @Step("Access Upload And Download page")
    public void accessUploadAndDownloadPage(Page page) {
        accessElementsMenu(page);
        clickMenuItem(page, "Upload and Download");
    }

    @Step("Access Dynamic Properties page")
    public void accessDynamicPropertiesPage(Page page) {
        accessElementsMenu(page);
        clickMenuItem(page, "Dynamic Properties");
    }

    // =============================== FORMS ===============================

    @Step("Access Forms menu")
    public void accessFormsMenu(Page page) {
        page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions().setName("Forms")
        ).click();

        Locator list = page.locator("div")
                .filter(new Locator.FilterOptions()
                        .setHasText(Pattern.compile("^Practice Form$")));

        if (!isExpanded(list)) {
            page.getByText("Forms").click();
        }
    }

    @Step("Access Practice Form page")
    public void accessPracticeFormPage(Page page) {
        accessFormsMenu(page);
        clickMenuItem(page, "Practice Form");
    }

    // ======================= ALERTS, FRAME & WINDOW =======================

    @Step("Access Alerts, Frame & Windows menu")
    public void accessAlertsFramesAndWindowsMenu(Page page) {
        page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions().setName("Alerts, Frame & Windows")
        ).click();

        Locator list = page.locator("div")
                .filter(new Locator.FilterOptions()
                        .setHasText(Pattern.compile(
                                "^Browser WindowsAlertsFramesNested FramesModal Dialogs$")));

        if (!isExpanded(list)) {
            page.getByText("Alerts, Frame & Windows").click();
        }
    }

    @Step("Access Browser Windows page")
    public void accessBrowserWindowsPage(Page page) {
        accessAlertsFramesAndWindowsMenu(page);
        clickMenuItem(page, "Browser Windows");
    }

    @Step("Access Alerts page")
    public void accessAlertsPage(Page page) {
        accessAlertsFramesAndWindowsMenu(page);
        clickMenuItem(page, "Alerts");
    }

    @Step("Access Frames page")
    public void accessFramesPage(Page page) {
        accessAlertsFramesAndWindowsMenu(page);
        clickMenuItem(page, "Frames");
    }

    @Step("Access Nested Frames page")
    public void accessNestedFramesPage(Page page) {
        accessAlertsFramesAndWindowsMenu(page);
        clickMenuItem(page, "Nested Frames");
    }

    @Step("Access Modal Dialogs page")
    public void accessModalDialogPage(Page page) {
        accessAlertsFramesAndWindowsMenu(page);
        clickMenuItem(page, "Modal Dialogs");
    }

    // =============================== WIDGETS ===============================

    @Step("Access Widgets menu")
    public void accessWidgetsMenu(Page page) {
        page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions().setName("Widgets")
        ).click();

        Locator list = page.locator("div")
                .filter(new Locator.FilterOptions()
                        .setHasText(Pattern.compile(
                                "^AccordianAuto CompleteDate PickerSliderProgress BarTabsTool TipsMenuSelect Menu$")));

        if (!isExpanded(list)) {
            page.getByText("Widgets").click();
        }
    }

    @Step("Access Accordian page")
    public void accessAccordianPage(Page page) {
        accessWidgetsMenu(page);
        clickMenuItem(page, "Accordian");
    }

    @Step("Access Auto Complete page")
    public void accessAutoCompletePage(Page page) {
        accessWidgetsMenu(page);
        clickMenuItem(page, "Auto Complete");
    }

    @Step("Access Date Picker page")
    public void accessDatePickerPage(Page page) {
        accessWidgetsMenu(page);
        clickMenuItem(page, "Date Picker");
    }

    @Step("Access Slider page")
    public void accessSliderPage(Page page) {
        accessWidgetsMenu(page);
        clickMenuItem(page, "Slider");
    }

    @Step("Access Progress Bar page")
    public void accessProgressBarPage(Page page) {
        accessWidgetsMenu(page);
        clickMenuItem(page, "Progress Bar");
    }

    @Step("Access Tabs page")
    public void accessTabsPage(Page page) {
        accessWidgetsMenu(page);
        clickMenuItem(page, "Tabs");
    }

    @Step("Access Tool Tips page")
    public void accessToolTipsPage(Page page) {
        accessWidgetsMenu(page);
        clickMenuItem(page, "Tool Tips");
    }

    @Step("Access Menu page")
    public void accessMenuPage(Page page) {
        accessWidgetsMenu(page);
        clickMenuItem(page, "Menu");
    }

    @Step("Access Select Menu page")
    public void accessSelectedPage(Page page) {
        accessWidgetsMenu(page);
        clickMenuItem(page, "Select Menu");
    }

    // =============================== BOOK STORE ===============================

    @Step("Access Book Store Application menu")
    public void accessBookStoreApplicationMenu(Page page) {
        page.getByRole(
                AriaRole.HEADING,
                new Page.GetByRoleOptions().setName("Book Store Application")
        ).click();

        Locator list = page.locator("div")
                .filter(new Locator.FilterOptions()
                        .setHasText(Pattern.compile("^LoginBook StoreProfileBook Store API$")));

        if (!isExpanded(list)) {
            page.getByText("Book Store Application").click();
        }
    }

    @Step("Access Login page")
    public void accessLoginPage(Page page) {
        accessBookStoreApplicationMenu(page);
        clickMenuItem(page, "Login");
    }

    @Step("Access Book Store page")
    public void accessBookStorePage(Page page) {
        accessBookStoreApplicationMenu(page);
        clickMenuItem(page, "Book Store");
    }

    @Step("Access Profile page")
    public void accessProfilePage(Page page) {
        accessBookStoreApplicationMenu(page);
        clickMenuItem(page, "Profile");
    }
}

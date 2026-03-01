package releases.Feb2026_Regression_DemoQA;

import io.qameta.allure.*;

import java.util.List;
import java.util.regex.Pattern;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.LocatorAssertions.IsEnabledOptions;
import com.microsoft.playwright.assertions.LocatorAssertions.IsVisibleOptions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import apps.demoQA.DemoQATestBase;
import apps.demoQA.enums.CheckboxPageTreeItems;
import apps.demoQA.enums.RadioButtonPageOption;
import apps.demoQA.models.elements.WebTablesRegister;
import apps.demoQA.pages.DemoQaMenuPage;
import apps.demoQA.pages.elements.BrokenLinksImagesPage;
import apps.demoQA.pages.elements.ButtonsPage;
import apps.demoQA.pages.elements.CheckBoxPage;
import apps.demoQA.pages.elements.DynamicPropertiesPage;
import apps.demoQA.pages.elements.LinksPage;
import apps.demoQA.pages.elements.RadioButtonPage;
import apps.demoQA.pages.elements.TextBoxPage;
import apps.demoQA.pages.elements.UploadAndDownloadPage;
import apps.demoQA.pages.elements.WebTablesPage;

@Epic("Regression - 2026")
@Feature("Element flows")
public class ElementsPageRegressionTest extends DemoQATestBase {

	DemoQaMenuPage menuPage = new DemoQaMenuPage();
	BrokenLinksImagesPage brokenLinksImagesPage = new BrokenLinksImagesPage();
	ButtonsPage buttonsPage = new ButtonsPage();
	DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage();
	WebTablesPage webTablesPage = new WebTablesPage();
	CheckBoxPage checkBoxPage = new CheckBoxPage();
	LinksPage linksPage = new LinksPage();
	RadioButtonPage radioButtonPage = new RadioButtonPage();
	TextBoxPage textBoxPage = new TextBoxPage();
	UploadAndDownloadPage uploadAndDownloadPage = new UploadAndDownloadPage();

	WebTablesRegister originalRegister = new WebTablesRegister(
			"Cierra", 
			"Vega", 
			"39", 
			"cierra@example.com", 
			"10000",
			"Insurance"
	);

	/**
	 * Given a user access Broken Links - Images Page <br>
	 * When user goes to image areas <br>
	 * Then system should present on screen a visible image
	 */
	@Story("Upload And Download flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify if user access Broken Links - Images Page then system present on screen a visible image")
	@Description(useJavaDoc = true)
	@Test
	public void verifyNotBrokenImage() {
		menuPage.accessBrokenLinksImagesPage(page);
		Allure.step("Check valid image", () -> {
			assertTrue(brokenLinksImagesPage.verifyBrokenImage(page));
		});
	}

	/**
	 * Given a user access Buttons Page <br>
	 * When user give a Double Click on 'Double Click Me' button <br>
	 * Then system present a text message 'You have done a double click'
	 */
	@Story("Buttons flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify if user gives a double click on 'Double Click Me' button then a text should present on screen")
	@Description(useJavaDoc = true)
	@Test
	public void doubleClickOnDoubleClickMeButton() {
		menuPage.accessButtonsPage(page);
		buttonsPage.doubleClickOnButton(page);
		Allure.step("Verify if text is correctly present on screen", () -> {
			assertTrue(buttonsPage.getDoubleClickMessage(page).contains("You have done a double click"),
					"Expected value to be 'You have done a double click'");
		});
	}

	/**
	 * Given a user access Buttons Page <br>
	 * When user give a Right Click on 'Right Click Me' button <br>
	 * Then system present a text message 'You have done a right click'
	 */
	@Story("Buttons flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify if user gives a right click on 'Right Click Me' button then a text should present on screen")
	@Description(useJavaDoc = true)
	@Test
	public void rightClickOnRightClickMeButton() {
		menuPage.accessButtonsPage(page);
		buttonsPage.rightClickOnButton(page);
		Allure.step("Verify if text is correctly present on screen", () -> {
			assertTrue(buttonsPage.getRightClickMessage(page).contains("You have done a right click"),
					"Expected value to be 'You have done a right click'");
		});
	}

	/**
	 * Given a user access Buttons Page <br>
	 * When user give a Click on 'Click Me' button <br>
	 * Then system present a text message 'You have done a dynamic click'
	 */
	@Story("Buttons flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify if user gives a dynamic click on 'Click Me' button then a text should present on screen")
	@Description(useJavaDoc = true)
	@Test
	public void dynamicClickOnClickMeButton() {
		menuPage.accessButtonsPage(page);
		buttonsPage.dynamicClickOnButton(page);
		Allure.step("Verify if text is correctly present on screen", () -> {
			assertTrue(buttonsPage.getDynamicClickMessage(page).contains("You have done a dynamic click"),
					"Expected value to be 'You have done a dynamic click'");
		});
	}

	/**
	 * Given a user access Dynamic Properties Page <br>
	 * And system present on screen a text with value 'This text has random Id' <br>
	 * When system give a id for the text paragraph 'This text has random Id' <br>
	 * And user reload then page <br>
	 * Then system will present on screen a text with value 'This text has random
	 * Id' <br>
	 * And system give a new id for the text paragraph 'This text has random Id'
	 */
	@Story("Dynamic Properties flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify system will present on screen a text with value 'This text has random Id'")
	@Description(useJavaDoc = true)
	@Test
	public void verifyTheRandomIdText() {
		String firstId;
		String secondId;
		menuPage.accessDynamicPropertiesPage(page);
		firstId = dynamicPropertiesPage.getRandomIdFromParagraph(page);
		page.reload();
		secondId = dynamicPropertiesPage.getRandomIdFromParagraph(page);
		Allure.step("Verify that system changed the id of the pararaph dynamically", () -> {
			assertFalse(firstId.contentEquals(secondId));
		});
	}

	/**
	 * Given a user access Dynamic Properties Page <br>
	 * When is passed 5 seconds <br>
	 * Then 'Will enabled 5 seconds' button should be enabled
	 */
	@Story("Dynamic Properties flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify when 5 seconds is passed 'Will enabled 5 seconds' button should be enabled")
	@Description(useJavaDoc = true)
	@Test
	public void verifyAfter5SecondsButtonShouldBeEnabled() {
		menuPage.accessDynamicPropertiesPage(page);
		Locator button = dynamicPropertiesPage.getButtonWillEnable5Seconds(page);
		Allure.step("Verify that after 5 seconds 'Will enabled 5 seconds' button will be enabled", () -> {
			assertThat(button).isDisabled();
			page.waitForTimeout(7_000);
			assertThat(button).isEnabled(new IsEnabledOptions().setTimeout(7000));
		});
	}

	/**
	 * Given a user access Dynamic Properties Page <br>
	 * When is passed 5 seconds <br>
	 * Then 'Visible after 5 seconds' button should be visible
	 */
	@Story("Dynamic Properties flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify when 5 seconds is passed 'Visible after 5 seconds' button should be enabled")
	@Description(useJavaDoc = true)
	@Test
	public void verifyAfter5SecondsButtonShouldBeVisible() {
		menuPage.accessDynamicPropertiesPage(page);
		Locator button = dynamicPropertiesPage.getButtonVisibleAfter5Seconds(page);
		Allure.step("Verify that after 5 seconds 'Visible after 5 seconds' button will be enabled", () -> {
			assertThat(button).isHidden();
			assertThat(button).isVisible(new IsVisibleOptions().setTimeout(7000));
		});
	}

	/**
	 * Given a user access Dynamic Properties Page <br>
	 * When is passed 5 seconds <br>
	 * Then 'Color change' button should be with red text
	 */
	@Story("Dynamic Properties flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify when 5 seconds is passed 'Color change' button should be with red text")
	@Description(useJavaDoc = true)
	@Test
	public void veriyColorChangeAtColorChangeButton() {
		menuPage.accessDynamicPropertiesPage(page);
		Allure.step("Verify button changed to red text after 5 seconds", () -> {
			Locator button = dynamicPropertiesPage.getButtonColorChange(page);
			assertThat(button).not().hasClass(Pattern.compile(".*text-danger.*"));
			assertThat(button).hasClass(Pattern.compile(".*text-danger.*"),
					new LocatorAssertions.HasClassOptions().setTimeout(7000));
		});
	}

	/**
	 * Given a user access the Web Tables page <br>
	 * And user click on Add button <br>
	 * And system present a modal with First Name, Last Name, Email, Age, Salary and
	 * Department inputs <br>
	 * When user fulfill all the inputs with valid data <br>
	 * And click on Submit <br>
	 * Then system present the new register on the web table with the values
	 * provided by the user
	 */
	@Story("Web Tables flow")
	@DisplayName("Add a new register on web table with success")
	@Severity(SeverityLevel.NORMAL)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@Owner("Lucas Alexandre")
	@Description(useJavaDoc = true)
	@Test
	public void createNewRegisterOnWebTableWithSuccess() {
		WebTablesRegister register = new WebTablesRegister("Test", "Automation 1", "20", "test@test.com", "1000", "QA");
		menuPage.accessWebTablesPage(page);
		webTablesPage.fillRegistrationForm(page, register);
		Allure.step("Verify if new register is added correctly", () -> {
			assertNotNull(webTablesPage.getRowByValue(page, register),
					"Expected new register to be present in the web table");
		});
	}

	/**
	 * Given a user access the Web Tables page <br>
	 * And user search a register providing a valid value to Search input <br>
	 * And system present on the web table the registers based on value provided by
	 * user <br>
	 * And user click on Edit button at desired register <br>
	 * When system present a modal with First Name, Last Name, Email, Age, Salary
	 * and Department inputs fulfilled with the last saved value <br>
	 * And user update the desired value at First Name, Last Name, Email, Age,
	 * Salary and Department of the inputs <br>
	 * And user click on submit button <br>
	 * Then system present the updated register on the web table with the values
	 * provided by the user
	 */
	@Story("Web Tables flow")
	@DisplayName("Update a register on web table with success")
	@Severity(SeverityLevel.NORMAL)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@Owner("Lucas Alexandre")
	@Description(useJavaDoc = true)
	@Test
	public void updateRegisterOnWebTableWithSuccess() {
		WebTablesRegister updatedRegister = new WebTablesRegister("Alden", "Vega", "20", "cierra@example.com", "10000",
				"Insurance");
		menuPage.accessWebTablesPage(page);

		webTablesPage.clickEditOnRow(page, originalRegister);
		webTablesPage.fillAgeInput(page, updatedRegister.getAge());
		webTablesPage.fillFirstNameInput(page, updatedRegister.getFirstName());
		webTablesPage.clickOnSubmitAtRegistrationForm(page);

		webTablesPage.searchRegisterUsingTheSearchInput(page, updatedRegister.getFirstName());
		Allure.step("Verify if register is correctly updated on Web Table", () -> {
			assertNotNull(webTablesPage.getRowByValue(page, updatedRegister),
					"Expected updated register to be present in the web table");
		});
	}

	/**
	 * Given a user access the Web Tables page <br>
	 * And user search a register providing a valid value to Search input <br>
	 * And system present on the web table the registers based on value provided by
	 * user <br>
	 * When user click on Remove button at desired register <br>
	 * Then system remove register on the web table
	 */
	@Story("Web Tables flow")
	@DisplayName("Add a new register on web table with success")
	@Severity(SeverityLevel.NORMAL)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@Owner("Lucas Alexandre")
	@Description(useJavaDoc = true)
	@Test
	public void removeRegisterOnWebTableWithSuccess() {
		menuPage.accessWebTablesPage(page);
		webTablesPage.clickDeleteOnRow(page, originalRegister);
		webTablesPage.searchRegisterUsingTheSearchInput(page, originalRegister.getFirstName());
		Allure.step("Verify if register is correctly updated on Web Table", () -> {
			assertNull(webTablesPage.getRowByValue(page, originalRegister),
					"Didn't expected deleted register to be present in the web table");
		});
	}
	
	/**
	 * Given a user access the Checkbox page <br>
	 * When user Check the Home Folder option <br>
	 * Then result area should present all folders and files text values
	 */
	@Story("Check Box flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.NORMAL)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify If user check Root Home folder then all Subfolders and fIles will be checked automatically")
	@Description(useJavaDoc = true)
	@Test
	public void checkHomeFolderSuccessfully() {
		menuPage.accessCheckBoxPage(page);
		checkBoxPage.expandAllFolders(page);
		checkBoxPage.checkByLabel(page, CheckboxPageTreeItems.HOME);
		List<String> results = checkBoxPage.getSelectedFoldersAndFiles(page);
		assertAll("results", () -> {
			for (CheckboxPageTreeItems item : CheckboxPageTreeItems.values()) {
				assertTrue(checkBoxPage.isCheckBoxChecked(page, item));
				assertTrue(results.contains(item.getLabel()));
			}
		});
	}

	/**
	 * Given a user access the Checkbox page <br>
	 * When user Check the Desktop Folder option <br>
	 * Then result area should present only Desktop, Notes and Commands text values
	 */
	@Story("Check Box flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.NORMAL)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify If User Check Desktop Folder Then All Subfolders And FIles Will Be Checked Automatically")
	@Description(useJavaDoc = true)
	@Test
	public void checkDesktopFolderSuccessfully() {
		menuPage.accessCheckBoxPage(page);
		checkBoxPage.expandAllFolders(page);
		checkBoxPage.checkByLabel(page, CheckboxPageTreeItems.DESKTOP);
		List<String> results = checkBoxPage.getSelectedFoldersAndFiles(page);
		assertAll("results", () -> {
			for (CheckboxPageTreeItems item : CheckboxPageTreeItems.values()) {
				if (item.equals(CheckboxPageTreeItems.DESKTOP) || item.equals(CheckboxPageTreeItems.NOTES)
						|| item.equals(CheckboxPageTreeItems.COMMANDS)) {
					assertTrue(checkBoxPage.isCheckBoxChecked(page, item));
					assertTrue(results.contains(item.getLabel()));
				} else {
					assertFalse(checkBoxPage.isCheckBoxChecked(page, item));
					assertFalse(results.contains(item.getLabel()));
				}
			}
		});
	}

	@Story("Check Box flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.NORMAL)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify If user check Documents folder and uncheck Office folder then only subfolders and files inside Documens will be checked automatically")
	@Description("Given a user access the Checkbox page \r\n"
			+ "When user Check the Documents Folder option \r\n"
			+ "And user uncheck Office Folder option \r\n"
			+ "Then result area should present only Workspace, React, Angular and Veu text values"
	)
	@Test
	public void checkDocumentsAndUncheckOfficeFolderWithSuccess() {
		menuPage.accessCheckBoxPage(page);
		checkBoxPage.expandAllFolders(page);
		checkBoxPage.checkByLabel(page, CheckboxPageTreeItems.DOCUMENTS);
		checkBoxPage.uncheckByLabel(page, CheckboxPageTreeItems.OFFICE);
		List<String> results = checkBoxPage.getSelectedFoldersAndFiles(page);
		assertAll("results", () -> {
			for (CheckboxPageTreeItems item : CheckboxPageTreeItems.values()) {
				if (item.equals(CheckboxPageTreeItems.WORKSPACE) || item.equals(CheckboxPageTreeItems.REACT)
						|| item.equals(CheckboxPageTreeItems.ANGULAR) || item.equals(CheckboxPageTreeItems.VEU)) {
					assertTrue(checkBoxPage.isCheckBoxChecked(page, item));
					assertTrue(results.contains(item.getLabel()));
				} else {
					assertTrue(checkBoxPage.isCheckBoxChecked(page, item));
					assertFalse(results.contains(item.getLabel()));
				}
			}
		});
	}

	/**
	 * Given a user access the Checkbox page <br>
	 * When user Check the Word File.doc option <br>
	 * Then result area should present only Word File.doc text values
	 */
	@Story("Check Box flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.NORMAL)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify If user Check Word File.doc then only the Word File.doc would be checked")
	@Description(useJavaDoc = true)
	@Test
	public void checkWordFileDocWithSuccess() {
		menuPage.accessCheckBoxPage(page);
		checkBoxPage.expandAllFolders(page);
		checkBoxPage.checkByLabel(page, CheckboxPageTreeItems.WORD);
		List<String> results = checkBoxPage.getSelectedFoldersAndFiles(page);
		assertAll("results", () -> {
			for (CheckboxPageTreeItems item : CheckboxPageTreeItems.values()) {
				if (item.equals(CheckboxPageTreeItems.WORD)) {
					assertTrue(checkBoxPage.isCheckBoxChecked(page, item));
					assertTrue(results.contains(item.getLabel()));
				} else {
					assertFalse(checkBoxPage.isCheckBoxChecked(page, item));
					assertFalse(results.contains(item.getLabel()));
				}
			}
		});
	}
	
	/**
	 * Given a user access Links Page
	 * <br>
	 * When user click on Home link
	 * <br>
	 * Then system open a new tab redirecting to the home page
	 */
	@Story("Links flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify if user click on Home link then a new tab should open to home page")
	@Description(useJavaDoc = true)
	@Test
	public void clickOnHomeLinkSuccessfully() {
		menuPage.accessLinksPage(page);
		Page newTab = linksPage.clickOnHomeLinkAndGetNewTab(page);
		newTab.bringToFront();
		Allure.step("Verify if url is correct", () -> {
			assertTrue(newTab.url().contains("https://demoqa.com"));
		});
		newTab.close();
	}
	
	/**
	 * Given a user access Links Page
	 * <br>
	 * When user click on Dynamic Home link
	 * <br>
	 * Then system open a new tab redirecting to the home page
	 */
	@Story("Links flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify if user click on Dynamic Home link then a new tab should open to home page")
	@Description(useJavaDoc = true)
	@Test
	public void clickOnDynamicLinkSuccessfully() {
		menuPage.accessLinksPage(page);
		Page newTab = linksPage.clickOnDynamicHomeLinkAndGetNewTab(page);
		newTab.bringToFront();
		Allure.step("Verify if url is correct", () -> {
			assertTrue(newTab.url().contains("https://demoqa.com"));
		});
		newTab.close();
	}
	
	/**
	 * Given a user access Links Page
	 * <br>
	 * When user click on Created link
	 * <br>
	 * Then system present on screen the text "Link has responded with staus 201 and status text Created"
	 */
	@Story("Links flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify if user click on Created link then system should present a text value on screen")
	@Description(useJavaDoc = true)
	@Test
	public void clickOnCreatedLinkSuccessfully() {
		menuPage.accessLinksPage(page);
		linksPage.clickOnCreatedLink(page);
		Allure.step("Verify if text is correctly present on screen", () -> {			
		});
		assertTrue(linksPage.getResponseMessage(page).contains("Link has responded with staus 201 and status text Created"));
	}
	
	/**
	 * Given a user access Links Page
	 * <br>
	 * When user click on No Content link
	 * <br>
	 * Then system present on screen the text "Link has responded with staus 204 and status text No Content"
	 */
	@Story("Links flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify if user click on No Content link then system should present a text value on screen")
	@Description(useJavaDoc = true)
	@Test
	public void clickOnNoContentLinkSuccessfully() {
		menuPage.accessLinksPage(page);
		linksPage.clickOnNoContentLink(page);
		Allure.step("Verify if text is correctly present on screen", () -> {			
			assertTrue(linksPage.getResponseMessage(page).contains("Link has responded with staus 204 and status text No Content"));
		});
	}
	
	/**
	 * Given a user access Links Page
	 * <br>
	 * When user click on Moved link
	 * <br>
	 * Then system present on screen the text "Link has responded with staus 301 and status text Moved Permanently"
	 */
	@Story("Links flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify if user click on Moved link then system should present a text value on screen")
	@Description(useJavaDoc = true)
	@Test
	public void clickOnMovedLinkSuccessfully() {
		menuPage.accessLinksPage(page);
		linksPage.clickOnMovedLink(page);
		Allure.step("Verify if text is correctly present on screen", () -> {			
			assertTrue(linksPage.getResponseMessage(page).contains("Link has responded with staus 301 and status text Moved Permanently"));
		});
	}
	
	/**
	 * Given a user access Links Page
	 * <br>
	 * When user click on Bad Request link
	 * <br>
	 * Then system present on screen the text "Link has responded with staus 400 and status text Bad Request"
	 */
	@Story("Links flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify if user click on Bad Request link then system should present a text value on screen")
	@Description(useJavaDoc = true)
	@Test
	public void clickOnBadRequestLinkSuccessfully() {
		menuPage.accessLinksPage(page);
		linksPage.clickOnBadRequestLink(page);
		Allure.step("Verify if text is correctly present on screen", () -> {			
			assertTrue(linksPage.getResponseMessage(page).contains("Link has responded with staus 400 and status text Bad Request"));
		});
	}
	
	/**
	 * Given a user access Links Page
	 * <br>
	 * When user click on Unauthorized link
	 * <br>
	 * Then system present on screen the text "Link has responded with staus 401 and status text Unauthorized"
	 */
	@Story("Links flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify if user click on Unauthorized link then system should present a text value on screen")
	@Description(useJavaDoc = true)
	@Test
	public void clickOnUnauthorizedLinkSuccessfully() {
		menuPage.accessLinksPage(page);
		linksPage.clickOnUnauthorizedLink(page);
		Allure.step("Verify if text is correctly present on screen", () -> {			
			assertTrue(linksPage.getResponseMessage(page).contains("Link has responded with staus 401 and status text Unauthorized"));
		});
	}
	
	/**
	 * Given a user access Links Page
	 * <br>
	 * When user click on Not Found link
	 * <br>
	 * Then system present on screen the text "Link has responded with staus 404 and status text Not Found"
	 */
	@Story("Links flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify if user click on Not Found link then system should present a text value on screen")
	@Description(useJavaDoc = true)
	@Test
	public void clickOnNotFoundLinkSuccessfully() {
		menuPage.accessLinksPage(page);
		linksPage.clickOnNotFoundLink(page);
		Allure.step("Verify if text is correctly present on screen", () -> {			
			assertTrue(linksPage.getResponseMessage(page).contains("Link has responded with staus 404 and status text Not Found"));
		});
	}
	
	/**
	 * Given a user access Radio Button Page
	 * <br>
	 * And select 'Yes' radio Button
	 * <br>
	 * When user select the 'Impressive' Radio Button
	 * <br>
	 * Then 'Yes' radio button will be deselected
	 * <br>
	 * And 'You have selected' area will present only the value 'Impressive'
	 */
	@Story("Radio Button flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.NORMAL)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify user can select only 1 of the radio buttons option")
	@Description(useJavaDoc = true)
	@Test
	public void selectOneOfTheRadioButtonSuccessfully() {
		menuPage.accessRadioButtonPage(page);
		radioButtonPage.selectRadioButtonOption(page, RadioButtonPageOption.YES);
		Allure.step("Verify that Yes radio button option is the only one select, and the 'You have selected' area present the correct value",
				() -> {
					for (RadioButtonPageOption item : RadioButtonPageOption.values()) {
						if (item.equals(RadioButtonPageOption.YES)) {
							assertTrue(radioButtonPage.getValueOnYouHaveSelectedArea(page).contains(item.getLabel()));
							assertTrue(radioButtonPage.isRadioButtonChecked(page, item));
						} else {
							assertFalse(radioButtonPage.getValueOnYouHaveSelectedArea(page).contains(item.getLabel()));
							assertFalse(radioButtonPage.isRadioButtonChecked(page, item));
						}
					}
				}
		);
		
		radioButtonPage.selectRadioButtonOption(page, RadioButtonPageOption.IMPRESSIVE);
		Allure.step("Verify that Impressive radio button option is the only one select, and the 'You have selected' area present the correct value",
				() -> {
					for (RadioButtonPageOption item : RadioButtonPageOption.values()) {
						if (item.equals(RadioButtonPageOption.IMPRESSIVE)) {
							assertTrue(radioButtonPage.getValueOnYouHaveSelectedArea(page).contains(item.getLabel()));
							assertTrue(radioButtonPage.isRadioButtonChecked(page, item));
						} else {
							assertFalse(radioButtonPage.getValueOnYouHaveSelectedArea(page).contains(item.getLabel()));
							assertFalse(radioButtonPage.isRadioButtonChecked(page, item));
						}
					}
				}
		);
	}

	/**
	 * Given a user access Radio Button Page
	 * <br>
	 * When user try to check 'No' Radio Button
	 * <br>
	 * Then user will not be able as 'No' radio button will be disabled
	 */
	@Story("Radio Button flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.NORMAL)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify user can't select disabled radio button option")
	@Description(useJavaDoc = true)
	@Test
	public void verifyDisabledRadioButtonCannotBeSelected() {
		menuPage.accessRadioButtonPage(page);
		assertTrue(radioButtonPage.isRadioButtonDisabled(page, RadioButtonPageOption.NO));
	}
	
	/**
	 * Given a user access TextBox page
	 * <br>
	 * And user fulfill the input full name with valid name
	 * <br>
	 * And user fulfill the input email with valid email
	 * <br>
	 * And user fulfill the input current address with valid address
	 * <br>
	 * And user fulfill the input permanent address with valid address
	 * <br>
	 * When user click on submit button
	 * <br>
	 * Then system submit form with values provided by the user on the inputs full name, email, current address and permanent address successfully
	 * <br>
	 * And system present below the form the values provided by the user on the inputs full name, email, current address and permanent address 
	 */
	@Story("Text Box flow")
	@DisplayName("Fullfill the text box form and submit with success")
	@Severity(SeverityLevel.NORMAL)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@Owner("Lucas Alexandre")
	@Description(useJavaDoc = true)
	@ParameterizedTest(name = "Submit TextBox form - {index}")
	@CsvSource({
	    "Test 1, Test1@email.com, Test Current Adress 1, Test Permanent Adress 1",
	    "Test 2, Test2@email.com, Test Current Adress 2, Test Permanent Adress 2",
	    "Test 3, Test3@email.com, Test Current Adress 3, Test Permanent Adress 3"
	})
	public void fillTheTextBoxFormAndSubmitWithSuccess(String fullname, String email, String currentAddress, String permanentAddress) {
		menuPage.accessTextBoxPage(page);
		textBoxPage.fillAllInputsInTheFormInput(page, fullname, email, currentAddress, permanentAddress);
		List<String> outputValues = textBoxPage.getOutputValues(page);
		Allure.step("Validate output values", () -> {
			assertAll("data", 
					() -> assertTrue(outputValues.get(0).contains(fullname)),
					() -> assertTrue(outputValues.get(1).contains(email)),
					() -> assertTrue(outputValues.get(2).contains(currentAddress)),
					() -> assertTrue(outputValues.get(3).contains(permanentAddress)));
		});
	}
	
	/**
	 * Given a user access Uploads and Download Page 
	 * <br>
	 * When user click on Download button 
	 * <br>
	 * Then system download a sample.jpeg file
	 */
	@Story("Upload And Download flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify if user click on Download button then system download a sample.jpeg file")
	@Description(useJavaDoc = true)
	@Test
	public void clickOnDonwloadButtonSuccessfully() {
		menuPage.accessUploadAndDownloadPage(page);
		Download download = page.waitForDownload(() -> {
			uploadAndDownloadPage.clickOnDownloadButton(page);
		});
		Allure.step("Verify the download file name", () -> {
			assertEquals("sampleFile.jpeg", download.suggestedFilename());
		});
	}

	/**
	 * Given a user access Uploads and Download Page 
	 * <br>
	 * When user click on select file button 
	 * <br>
	 * And system present a pop up to select files from user desktop 
	 * <br>
	 * And user select a file with success 
	 * <br>
	 * And user click on Open at Pop Up 
	 * <br>
	 * Then system upload the selected file from user to server
	 */
	@Story("Upload And Download flow")
	@Owner("Lucas Alexandre")
	@Severity(SeverityLevel.MINOR)
	@Tag("Regression")
	@Tag("Release_Feb2026")
	@DisplayName("Verify if user click on Select file button then system allow user to upload a file from the user desktop")
	@Description(useJavaDoc = true)
	@Test
	public void clickOnSelectFileButtonSuccessfully() {
		menuPage.accessUploadAndDownloadPage(page);
		uploadAndDownloadPage.uploadFileToSystem(page, "C:/Users/Lucas/Desktop/Repositorys/QA-Automation-Projects/Playwright/UIAutomationTeam/src/test/resources/UploadFiles/UploadTest.txt");
		assertTrue(page.locator("#uploadedFilePath").innerText().contains("UploadTest.txt"));
	}
	
}

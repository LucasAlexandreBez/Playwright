package apps.orangeHRM;

import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;

import config.GlobalTestRunConfig;
import config.PropertiesConfigLoader;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.HarMode;
import com.microsoft.playwright.options.WaitUntilState;

import apps.orangeHRM.page.LoginPage;
import engine.PlaywrightThreadManager;
import engine.TestBaseManager;
import engine.devices.DesktopContext;

/**
 * Base test class for OrangeHRM application tests.
 *
 * <p>
 * This class is responsible for configuring and initializing the Playwright
 * {@link com.microsoft.playwright.BrowserContext} and {@link com.microsoft.playwright.Page}
 * used by DemoQA tests.
 * </p>
 *
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class OrangeHRMTestBase extends TestBaseManager{

	protected BrowserContext context;
    protected Page page;
    
    LoginPage loginPage = new LoginPage();
    private String username = PropertiesConfigLoader.getPropertyValue("app.orangehrm.username");
    private String password = PropertiesConfigLoader.getPropertyValue("app.orangehrm.pwd");
   
    @BeforeEach
    public void setupTest() {
    	NewContextOptions options = DesktopContext.Desktop_1440x900();
        if (GlobalTestRunConfig.VIDEO_CAPTURE) {
        	options
        	.setRecordVideoDir(Paths.get("target/videos"))
        	.setRecordVideoSize(1000, 800);
        }
        if (GlobalTestRunConfig.HAR_CAPTURE) {
        	options
        	.setRecordHarPath(Paths.get("target/har/demoqa-" + LocalDateTime.now().toString() + ".har"))
        	.setRecordHarMode(HarMode.FULL);
        }
    	
        Browser browser = PlaywrightThreadManager.getBrowserThreadIntance();
        context = browser.newContext(options);
        page = context.newPage();
        page.navigate(
        		PropertiesConfigLoader.getPropertyValue("app.orangehrm.url"),
        	    new Page.NavigateOptions()
        	        .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
        	);
        loginPage.fillTheLoginFormAccessOrangeHRM(page, username, password);
    }
}

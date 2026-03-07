package apps.demoQA;

import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.HarMode;
import com.microsoft.playwright.options.WaitUntilState;

import config.GlobalTestRunConfig;
import engine.PlaywrightThreadManager;
import engine.TestBaseManager;
import engine.devices.DesktopContext;
import helper.PropertiesConfigLoader;

/**
 * Base test class for DemoQA application tests.
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
public class DemoQATestBase extends TestBaseManager {
    @BeforeEach
    public void setupTest(TestInfo testInfo) {
    	NewContextOptions options = DesktopContext.Desktop_1440x900();
        if (GlobalTestRunConfig.VIDEO_CAPTURE) {
        	options
        	.setRecordVideoDir(Paths.get("target/videos"))
        	.setRecordVideoSize(1000, 800);
        }
        if (GlobalTestRunConfig.HAR_CAPTURE_ON_FAILURE) {
            String testName = testInfo.getDisplayName().replaceAll("[^a-zA-Z0-9]", "_");
            options.setRecordHarPath(Paths.get("target/hars/" + testName + ".har"))
                .setRecordHarMode(HarMode.FULL);
        }
        Browser browser = PlaywrightThreadManager.getBrowserThreadIntance();
        context = browser.newContext(options);
        page = context.newPage();
        page.navigate(
        	    PropertiesConfigLoader.getPropertyValue("app.demoqa.url"),
        	    new Page.NavigateOptions()
        	        .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
        	);
    }
}

package config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;

import com.microsoft.playwright.Playwright;

/**
 * Centralizes Playwright browser configuration and execution mode.
 * 
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class BrowserRunConfig {

    private BrowserRunConfig() {}

    /**
     * Creates a {@link Browser} for the current execution mode.
     *
     * @param playwright the thread-local Playwright instance
     * @return configured browser instance
     */
    public static Browser getBrowserConfiguration(Playwright playwright) {
    	String executionType = PropertiesConfigLoader.getPropertyValue("execution.type").toUpperCase();
        switch (executionType) {
            case "LOCAL":
                return generateConfigForLocalExecution(playwright);
            case "CLOUD":
                return generateConfigForCloudExecution(playwright, PropertiesConfigLoader.getPropertyValue("cloud.endpoint"));
            default:
                throw new IllegalStateException("Unexpected execution type: " + executionType);
        }
    }

    /* ===================== LOCAL ===================== */
    private static Browser generateConfigForLocalExecution(Playwright playwright) {
        LaunchOptions options = new LaunchOptions()
                .setHeadless(GlobalTestRunConfig.HEADLESS)
                .setTimeout(GlobalTestRunConfig.TIMEOUT)
                .setSlowMo(GlobalTestRunConfig.SLOWMOTION);

        switch (GlobalTestRunConfig.SELECTED_BROWSER) {
            case CHROMIUM:
                return playwright.chromium().launch(options.setChromiumSandbox(GlobalTestRunConfig.CHROMIUM_SANDBOX));
            case CHROME:
                options.setChannel("chrome");
                return playwright.chromium().launch(options.setChromiumSandbox(GlobalTestRunConfig.CHROMIUM_SANDBOX));
            case CHROME_BETA:
                options.setChannel("chrome-beta");
                return playwright.chromium().launch(options);
            case CHROME_DEV:
                options.setChannel("chrome-dev");
                return playwright.chromium().launch(options);
            case CHROME_CANARY:
                options.setChannel("chrome-canary");
                return playwright.chromium().launch(options);
            case EDGE:
                options.setChannel("msedge");
                return playwright.chromium().launch(options);
            case EDGE_BETA:
                options.setChannel("msedge-beta");
                return playwright.chromium().launch(options);
            case EDGE_DEV:
                options.setChannel("msedge-dev");
                return playwright.chromium().launch(options);
            case EDGE_CANARY:
                options.setChannel("msedge-canary");
                return playwright.chromium().launch(options);
            case FIREFOX:
                return playwright.firefox().launch(options);
            case WEBKIT:
                return playwright.webkit().launch(options);
            default:
                return playwright.chromium().launch(options);
        }
    }

    /* ===================== REMOTE (CLOUD) ===================== */
    private static Browser generateConfigForCloudExecution(
            Playwright playwright,
            String endpoint
    ) {
        try {

            BrowserType browserType;
            BrowserType.ConnectOptions connectOptions = new BrowserType.ConnectOptions();

            switch (GlobalTestRunConfig.SELECTED_BROWSER) {
                case FIREFOX:
                    browserType = playwright.firefox();
                    break;
                case WEBKIT:
                    browserType = playwright.webkit();
                    break;
                case EDGE:
                    browserType = playwright.chromium();
                    break;
                case CHROME:
                    browserType = playwright.chromium();
                    break;
                default:
                    browserType = playwright.chromium();
                    break;
            }
            return browserType.connect(endpoint, connectOptions);
        } catch (Exception e) {
            throw new IllegalStateException(
                    "Failed to connect to remote Playwright endpoint: " + endpoint,
                    e
            );
        }
    }
    
}

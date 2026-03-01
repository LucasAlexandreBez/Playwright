package engine;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;

import config.BrowserRunConfig;

/**
 * Provides thread-local management of {@link Playwright} and {@link Browser} instances.
 *
 * <p>
 * Each test thread receives its own isolated Playwright and Browser instance,
 * ensuring thread-safety when running tests in parallel.
 * </p>
 *
 * <p>
 * Instances are lazily created on first access and stored in {@link ThreadLocal} storage.
 * They can be explicitly disposed using {@link #killCurrentThread()}, which closes
 * both the Browser and the underlying Playwright instance for the calling thread.
 * </p>
 *
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class PlaywrightThreadManager {

    private static final ThreadLocal<Playwright> PLAYWRIGHT_THREAD = ThreadLocal.withInitial(Playwright::create);
    private static final ThreadLocal<Browser> BROWSER_THREAD =  ThreadLocal.withInitial(() -> BrowserRunConfig.getBrowserConfiguration(PLAYWRIGHT_THREAD.get()));

    private PlaywrightThreadManager() {}

    public static Browser getBrowserThreadIntance() {
        return BROWSER_THREAD.get();
    }
    
    public static Playwright getPlaywrightThreadInstance() {
        return PLAYWRIGHT_THREAD.get();
    }

    public static void cleanPlaywrightAndBrowserThreadInstances() {
        Browser browser = BROWSER_THREAD.get();
        if (browser != null) {
            browser.close();
            BROWSER_THREAD.remove();
        }

        Playwright playwright = PLAYWRIGHT_THREAD.get();
        if (playwright != null) {
            playwright.close();
            PLAYWRIGHT_THREAD.remove();
        }
    }
}

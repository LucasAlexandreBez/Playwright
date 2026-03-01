package engine;

import java.nio.file.Path;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

import config.GlobalTestRunConfig;

/**
 * Base class responsible for managing the lifecycle of Playwright resources
 * used during test execution.
 * 
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class TestBaseManager {

	public BrowserContext context;
	public Page page;

	private Path videoPath;
	private byte[] screenshot;

	/**
	 * Registers a per-test {@link TestStatusWatcher} that consumes test artifacts
	 * (video and screenshot) lazily via {@link Supplier}.
	 *
	 * <p>
	 * This design ensures safe parallel execution by avoiding shared state and
	 * accessing artifacts only after they have been fully generated in
	 * {@code @AfterEach}.
	 * </p>
	 */
	@RegisterExtension
	TestStatusWatcher watcher = new TestStatusWatcher(() -> videoPath, () -> screenshot);

	@AfterEach
	public void cleanPageAndContext() {
		if (page != null) {
			if (page.video() != null) videoPath = page.video().path();
			if (GlobalTestRunConfig.SCREENSHOT_CAPTURE) screenshot = page.screenshot();
			page.close();
		}
		if (context != null) context.close();
	}

	@AfterAll
	public static void cleanPlaywrightThreads() {
		PlaywrightThreadManager.cleanPlaywrightAndBrowserThreadInstances();
	}

}

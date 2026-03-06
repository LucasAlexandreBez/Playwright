package engine;

import java.nio.file.Path;
import java.util.function.Supplier;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.RegisterExtension;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.Video;

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

	private Path videoPathResult;
	private Path harPathResult;
	private byte[] screenshotResult;

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
	TestStatusWatcher watcher = new TestStatusWatcher(() -> videoPathResult, () -> harPathResult, () -> screenshotResult);

	@AfterEach
	public void cleanPageAndContext(TestInfo testInfo) {
		String testName = testInfo.getDisplayName().replaceAll("[^a-zA-Z0-9-_]", "_");
		if (page != null) {
			Video video = page.video();
			if (GlobalTestRunConfig.SCREENSHOT_CAPTURE) {
				screenshotResult = page.screenshot();
			}
			page.close();
			if (video != null) {
				
				Path videoPath = Path.of("target/videos/" + testName + ".webm");
				try {
					videoPathResult = video.path();
				} catch (PlaywrightException e) {
					video.saveAs(videoPath);
					videoPathResult = videoPath;
				}
			}
		}
		if (context != null) context.close();
		if (GlobalTestRunConfig.HAR_CAPTURE) {
			harPathResult = Path.of("target/hars/" + testName + ".har");
		}
	}

	@AfterAll
	public static void cleanPlaywrightThreads() {
		PlaywrightThreadManager.cleanPlaywrightAndBrowserThreadInstances();
	}

}

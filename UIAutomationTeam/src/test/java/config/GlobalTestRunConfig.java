package config;

/**
 * Common configurations for all test executions
 * 
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class GlobalTestRunConfig {
    // Browser settings
	public static final boolean HEADLESS = true;
    public static final double SLOWMOTION = 200;
    public static final double TIMEOUT = 30_000;
    public static final SupportedBrowserTypes SELECTED_BROWSER = SupportedBrowserTypes.EDGE;
    public static final boolean CHROMIUM_SANDBOX = false;

    // Capture settings
    public static final boolean VIDEO_CAPTURE = true;
    public static final boolean SCREENSHOT_CAPTURE = true;
    public static final boolean HAR_CAPTURE_ON_FAILURE = true;
}

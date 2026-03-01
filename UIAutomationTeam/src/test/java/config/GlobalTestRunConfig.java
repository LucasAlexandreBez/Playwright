package config;

/**
 * Common configurations for all test executions
 * 
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class GlobalTestRunConfig {
	public static final boolean HEADLESS = true;
    public static final double SLOWMOTION = 100;
    public static final double TIMEOUT = 60_000;
    public static final SupportedBrowserTypes SELECTED_BROWSER = SupportedBrowserTypes.FIREFOX;
    public static final boolean CHROMIUM_SANDBOX = false;
    
    public static final boolean VIDEO_CAPTURE = true;
    public static final boolean SCREENSHOT_CAPTURE = true;
    public static final boolean HAR_CAPTURE = false;
}

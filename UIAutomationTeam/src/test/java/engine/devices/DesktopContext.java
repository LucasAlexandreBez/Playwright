package engine.devices;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured for common desktop screen resolutions.
 *
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class DesktopContext {

	private DesktopContext() {}

	public static Browser.NewContextOptions Desktop_1920x1080() {
		Browser.NewContextOptions o = new Browser.NewContextOptions();
		o.setViewportSize(1920, 1080);
		o.setDeviceScaleFactor(1);
		o.setIsMobile(false);
		o.setHasTouch(false);
		return o;
	}

	public static Browser.NewContextOptions Desktop_1536x864() {
		Browser.NewContextOptions o = new Browser.NewContextOptions();
		o.setViewportSize(1536, 864);
		o.setDeviceScaleFactor(1);
		o.setIsMobile(false);
		o.setHasTouch(false);
		return o;
	}
	
	public static Browser.NewContextOptions Desktop_1440x900() {
		Browser.NewContextOptions o = new Browser.NewContextOptions();
		o.setViewportSize(1440, 900);
		o.setDeviceScaleFactor(1);
		o.setIsMobile(false);
		o.setHasTouch(false);
		return o;
	}

	public static Browser.NewContextOptions Desktop_1366x768() {
		Browser.NewContextOptions o = new Browser.NewContextOptions();
		o.setViewportSize(1366, 768);
		o.setDeviceScaleFactor(1);
		o.setIsMobile(false);
		o.setHasTouch(false);
		return o;
	}

	public static Browser.NewContextOptions Desktop_1280x720() {
		Browser.NewContextOptions o = new Browser.NewContextOptions();
		o.setViewportSize(1280, 720);
		o.setDeviceScaleFactor(1);
		o.setIsMobile(false);
		o.setHasTouch(false);
		return o;
	}

	public static Browser.NewContextOptions Desktop_3840x2160() {
		Browser.NewContextOptions o = new Browser.NewContextOptions();
		o.setViewportSize(3840, 2160);
		o.setDeviceScaleFactor(1);
		o.setIsMobile(false);
		o.setHasTouch(false);
		return o;
	}

	public static Browser.NewContextOptions Desktop_800x600() {
		Browser.NewContextOptions o = new Browser.NewContextOptions();
		o.setViewportSize(800, 600);
		o.setDeviceScaleFactor(1);
		o.setIsMobile(false);
		o.setHasTouch(false);
		return o;
	}

}

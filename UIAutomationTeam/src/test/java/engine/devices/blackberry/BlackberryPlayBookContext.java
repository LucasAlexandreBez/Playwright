package engine.devices.blackberry;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured to emulate the Blackberry PlayBook device.
 * <p>
 * Two orientations are supported:
 * <ul>
 *   <li>Portrait</li>
 *   <li>Landscape</li>
 * </ul>
 * </p>
 *
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class BlackberryPlayBookContext {

	private BlackberryPlayBookContext() {}
	
    public static Browser.NewContextOptions Blackberry_PlayBook() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (PlayBook; U; RIM Tablet OS 2.1.0; en-US) AppleWebKit/536.2+ (KHTML like Gecko) Version/26.0 Safari/536.2+");
        o.setViewportSize(600, 1024);
        o.setDeviceScaleFactor(1);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }

    public static Browser.NewContextOptions Blackberry_PlayBook_landscape() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (PlayBook; U; RIM Tablet OS 2.1.0; en-US) AppleWebKit/536.2+ (KHTML like Gecko) Version/26.0 Safari/536.2+");
        o.setViewportSize(1024, 600);
        o.setDeviceScaleFactor(1);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }
}

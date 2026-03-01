package engine.devices.apple;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured to emulate the iPhone 8 Plus device.
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
public class iPhone8PlusContext {

	private iPhone8PlusContext() {}

    /** Playwright preset for: iPhone 8 Plus */
    public static Browser.NewContextOptions iPhone_8_Plus() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/26.0 Mobile/15A372 Safari/604.1");
        o.setViewportSize(414, 736);
        o.setDeviceScaleFactor(3);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }

    /** Playwright preset for: iPhone 8 Plus landscape */
    public static Browser.NewContextOptions iPhone_8_Plus_landscape() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/26.0 Mobile/15A372 Safari/604.1");
        o.setViewportSize(736, 414);
        o.setDeviceScaleFactor(3);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }
}

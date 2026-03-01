package engine.devices.samsung;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured to emulate the Galaxy Tab S9 device.
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
public class GalaxyTabS9Context {

	private GalaxyTabS9Context() {}

    public static Browser.NewContextOptions Galaxy_Tab_S9() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Linux; Android 14; SM-X710) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.7559.20 Safari/537.36");
        o.setViewportSize(640, 1024);
        o.setDeviceScaleFactor(2.5);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }

    public static Browser.NewContextOptions Galaxy_Tab_S9_landscape() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Linux; Android 14; SM-X710) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.7559.20 Safari/537.36");
        o.setViewportSize(1024, 640);
        o.setDeviceScaleFactor(2.5);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }
}

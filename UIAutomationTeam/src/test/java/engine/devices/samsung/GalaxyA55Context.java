package engine.devices.samsung;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured to emulate the Galaxy A55 device.
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
public class GalaxyA55Context {

	private GalaxyA55Context() {}

    public static Browser.NewContextOptions Galaxy_A55() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Linux; Android 14; SM-A556B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.7559.20 Mobile Safari/537.36");
        o.setViewportSize(480, 1040);
        o.setDeviceScaleFactor(2.25);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }

    /** Playwright preset for: Galaxy A55 landscape */
    public static Browser.NewContextOptions Galaxy_A55_landscape() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Linux; Android 14; SM-A556B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.7559.20 Mobile Safari/537.36");
        o.setViewportSize(1040, 480);
        o.setDeviceScaleFactor(2.25);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }
}

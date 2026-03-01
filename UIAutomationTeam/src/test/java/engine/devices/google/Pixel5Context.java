package engine.devices.google;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured to emulate the Pixel 5 device.
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
public class Pixel5Context {

	private Pixel5Context() {}

    public static Browser.NewContextOptions Pixel_5() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Linux; Android 11; Pixel 5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.7559.20 Mobile Safari/537.36");
        o.setViewportSize(393, 727);
        o.setDeviceScaleFactor(2.75);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }

    public static Browser.NewContextOptions Pixel_5_landscape() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Linux; Android 11; Pixel 5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.7559.20 Mobile Safari/537.36");
        o.setViewportSize(802, 293);
        o.setDeviceScaleFactor(2.75);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }
}

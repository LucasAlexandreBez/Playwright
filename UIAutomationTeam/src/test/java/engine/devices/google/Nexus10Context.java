package engine.devices.google;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured to emulate the Nexus 10 device.
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
public class Nexus10Context {

	private Nexus10Context() {}

    public static Browser.NewContextOptions Nexus_10() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Linux; Android 6.0.1; Nexus 10 Build/MOB31T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.7559.20 Safari/537.36");
        o.setViewportSize(800, 1280);
        o.setDeviceScaleFactor(2);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }

    public static Browser.NewContextOptions Nexus_10_landscape() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Linux; Android 6.0.1; Nexus 10 Build/MOB31T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.7559.20 Safari/537.36");
        o.setViewportSize(1280, 800);
        o.setDeviceScaleFactor(2);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }
}

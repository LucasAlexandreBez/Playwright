package engine.devices.samsung;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured to emulate the Galaxy S9 device.
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
public class GalaxyS9PlusContext {

	private GalaxyS9PlusContext() {}

    public static Browser.NewContextOptions Galaxy_S9Plus() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Linux; Android 8.0.0; SM-G965U Build/R16NW) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.7559.20 Mobile Safari/537.36");
        o.setViewportSize(320, 658);
        o.setDeviceScaleFactor(4.5);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }

    /** Playwright preset for: Galaxy S9+ landscape */
    public static Browser.NewContextOptions Galaxy_S9Plus_landscape() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Linux; Android 8.0.0; SM-G965U Build/R16NW) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.7559.20 Mobile Safari/537.36");
        o.setViewportSize(658, 320);
        o.setDeviceScaleFactor(4.5);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }
}

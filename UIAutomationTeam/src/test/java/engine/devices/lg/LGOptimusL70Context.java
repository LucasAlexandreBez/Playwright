package engine.devices.lg;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured to emulate the LG Optimus L70 device.
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
public class LGOptimusL70Context {

	private LGOptimusL70Context() {}

    public static Browser.NewContextOptions LG_Optimus_L70() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; LGMS323 Build/KOT49I.MS32310c) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/144.0.7559.20 Mobile Safari/537.36");
        o.setViewportSize(384, 640);
        o.setDeviceScaleFactor(1.25);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }

    public static Browser.NewContextOptions LG_Optimus_L70_landscape() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; LGMS323 Build/KOT49I.MS32310c) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/144.0.7559.20 Mobile Safari/537.36");
        o.setViewportSize(640, 384);
        o.setDeviceScaleFactor(1.25);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }
}

package engine.devices.apple;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured to emulate the iPad Generation 11 device.
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
public class iPadGen11Context {

	private iPadGen11Context() {}

    public static Browser.NewContextOptions iPad_gen_11() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (iPad; CPU OS 18_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/26.0 Mobile/19E241 Safari/604.1");
        o.setViewportSize(656, 944);
        o.setDeviceScaleFactor(2.5);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }

    public static Browser.NewContextOptions iPad_gen_11_landscape() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (iPad; CPU OS 18_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/26.0 Mobile/19E241 Safari/604.1");
        o.setViewportSize(944, 656);
        o.setDeviceScaleFactor(2.5);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }
}

package engine.devices.samsung;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured to emulate the Galaxy Note II device.
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
public class GalaxyNoteIIContext {
	
	private GalaxyNoteIIContext() {}

    public static Browser.NewContextOptions Galaxy_Note_II() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Linux; U; Android 4.1; en-us; GT-N7100 Build/JRO03C) AppleWebKit/534.30 (KHTML, like Gecko) Version/26.0 Mobile Safari/534.30");
        o.setViewportSize(360, 640);
        o.setDeviceScaleFactor(2);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }

    public static Browser.NewContextOptions Galaxy_Note_II_landscape() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Linux; U; Android 4.1; en-us; GT-N7100 Build/JRO03C) AppleWebKit/534.30 (KHTML, like Gecko) Version/26.0 Mobile Safari/534.30");
        o.setViewportSize(640, 360);
        o.setDeviceScaleFactor(2);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }
}

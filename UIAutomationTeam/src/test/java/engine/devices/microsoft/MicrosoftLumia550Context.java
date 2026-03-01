package engine.devices.microsoft;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured to emulate the Microsoft Lumia 550 device.
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
public class MicrosoftLumia550Context {

	private MicrosoftLumia550Context() {}
	
    public static Browser.NewContextOptions Microsoft_Lumia_550() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Windows Phone 10.0; Android 4.2.1; Microsoft; Lumia 550) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.7559.20 Mobile Safari/537.36 Edge/14.14263");
        o.setViewportSize(360, 640);
        o.setDeviceScaleFactor(2);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }

    public static Browser.NewContextOptions Microsoft_Lumia_550_landscape() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Windows Phone 10.0; Android 4.2.1; Microsoft; Lumia 550) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.7559.20 Mobile Safari/537.36 Edge/14.14263");
        o.setViewportSize(640, 360);
        o.setDeviceScaleFactor(2);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }

}

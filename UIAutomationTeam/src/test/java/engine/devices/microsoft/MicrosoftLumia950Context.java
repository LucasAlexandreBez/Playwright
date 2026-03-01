package engine.devices.microsoft;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured to emulate the Microsoft Lumia 950 device.
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
public class MicrosoftLumia950Context {

	private MicrosoftLumia950Context() {}

    public static Browser.NewContextOptions Microsoft_Lumia_950() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Windows Phone 10.0; Android 4.2.1; Microsoft; Lumia 950) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.7559.20 Mobile Safari/537.36 Edge/14.14263");
        o.setViewportSize(360, 640);
        o.setDeviceScaleFactor(4);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }

    public static Browser.NewContextOptions Microsoft_Lumia_950_landscape() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (Windows Phone 10.0; Android 4.2.1; Microsoft; Lumia 950) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.7559.20 Mobile Safari/537.36 Edge/14.14263");
        o.setViewportSize(640, 360);
        o.setDeviceScaleFactor(4);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }
}

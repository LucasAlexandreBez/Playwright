package engine.devices.nokia;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured to emulate the Nokia Lumia 520 device.
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
public class NokiaLumia520Context {

	private NokiaLumia520Context() {}

    public static Browser.NewContextOptions Nokia_Lumia_520() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0; Trident/6.0; IEMobile/10.0; ARM; Touch; NOKIA; Lumia 520)");
        o.setViewportSize(320, 533);
        o.setDeviceScaleFactor(1.5);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }
    
    public static Browser.NewContextOptions Nokia_Lumia_520_landscape() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0; Trident/6.0; IEMobile/10.0; ARM; Touch; NOKIA; Lumia 520)");
        o.setViewportSize(533, 320);
        o.setDeviceScaleFactor(1.5);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }
}

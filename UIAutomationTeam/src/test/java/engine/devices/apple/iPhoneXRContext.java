package engine.devices.apple;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured to emulate the iPhone XR device.
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
public class iPhoneXRContext {

	private iPhoneXRContext() {}

    public static Browser.NewContextOptions iPhone_XR() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/26.0 Mobile/15E148 Safari/604.1");
        o.setViewportSize(414, 896);
        o.setDeviceScaleFactor(3);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }

    public static Browser.NewContextOptions iPhone_XR_landscape() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/26.0 Mobile/15E148 Safari/604.1");
        o.setViewportSize(896, 414);
        o.setDeviceScaleFactor(3);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }
}

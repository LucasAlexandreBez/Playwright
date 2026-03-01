package engine.devices.apple;

import com.microsoft.playwright.Browser;

/**
 * Factory class responsible for providing {@link Browser.NewContextOptions}
 * preconfigured to emulate the iPhone SE 3rd Generation device.
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
public class iPhoneSE3rdGenContext {

	private iPhoneSE3rdGenContext() {}

    public static Browser.NewContextOptions iPhone_SE_3rd_gen_() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 18_5 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Version/26.0 Mobile/19E241 Safari/602.1");
        o.setViewportSize(375, 667);
        o.setDeviceScaleFactor(2);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }

    public static Browser.NewContextOptions iPhone_SE_3rd_gen_landscape() {
        Browser.NewContextOptions o = new Browser.NewContextOptions();
        o.setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 18_5 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Version/26.0 Mobile/19E241 Safari/602.1");
        o.setViewportSize(667, 375);
        o.setDeviceScaleFactor(2);
        o.setIsMobile(true);
        o.setHasTouch(true);
        return o;
    }
}

package releases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Route;

public class CodeGen {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
					.setHeadless(false)
					.setChannel("msedge")
			);
			BrowserContext context = browser.newContext();
			context.route("**/*", Route::resume);
			Page page = context.newPage();
			page.navigate("http://localhost:9000/web/index.php/auth/login");
			page.pause();
		}
	}
}

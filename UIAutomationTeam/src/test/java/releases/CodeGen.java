package releases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Route;

public class CodeGen {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			BrowserType firefox = playwright.firefox();
			Browser browser = firefox.launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext(new NewContextOptions().setViewportSize(1440, 900));
			context.route("**/*", Route::resume);
			Page page = context.newPage();
			page.navigate("http://localhost:8080/web/index.php/auth/login");
			page.pause();
		}
	}
}

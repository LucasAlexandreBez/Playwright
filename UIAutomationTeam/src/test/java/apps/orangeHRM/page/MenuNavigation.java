package apps.orangeHRM.page;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import io.qameta.allure.Step;

public class MenuNavigation {

	@Step("Access the Admin page")
	public void accessAdminPage(Page page) {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Admin")).click();
	}
	
	@Step("Access the PIM page")
	public void accessPIMPage(Page page) {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("PIM")).click();
	}
	
	@Step("Access the Leave page")
	public void accessLeavePage(Page page) {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Leave")).click();
	}
	
	@Step("Access the Time page")
	public void accessTimePage(Page page) {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time")).click();
	}
	
	@Step("Access the Recruitment page")
	public void accessRecruitmentPage(Page page) {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Recruitment")).click();
	}
	
	@Step("Access the My Info page")
	public void accessMyInfoPage(Page page) {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My Info")).click();
	}
	
	@Step("Access the Performance page")
	public void accessPerformancePage(Page page) {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Performance")).click();
	}
	
	@Step("Access the Dashboard page")
	public void accessDashboardPage(Page page) {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click();
	}
	
	@Step("Access the Directory page")
	public void accessDirectoryPage(Page page) {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Directory")).click();
	}
	
	@Step("Access the Maintenance page")
	public void accessMaintenancePage(Page page) {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Maintenance")).click();
	}
	
	@Step("Access the Claim page")
	public void accessClaimPage(Page page) {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Claim")).click();
	}
	
	@Step("Access the Buzz page")
	public void accessBuzzPage(Page page) {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Buzz")).click();
	}
}

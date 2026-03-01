package apps.demoQA.pages.elements;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import apps.demoQA.enums.CheckboxPageTreeItems;
import io.qameta.allure.Step;

public class CheckBoxPage {

	@Step("Expand all folder list")
	public void expandAllFolders(Page page) {
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Expand all")).click();
	}

	@Step("Collapse all folder list")
	public void collapseAllFolders(Page page) {
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Collapse all")).click();
	}
	
	@Step("Check the {item.label} checkbox")
	public void checkByLabel(Page page, CheckboxPageTreeItems item) {
		Locator label = page.locator("label[for='"+item.getId()+"']");
		label.scrollIntoViewIfNeeded();
		String svg = label.locator("span.rct-checkbox svg").getAttribute("class");
		if (svg.contains("rct-icon-uncheck")) {			
			page.locator("label[for='"+item.getId()+"']").click();
		}
	}

	@Step("Uncheck the {item.label} checkbox")
	public void uncheckByLabel(Page page, CheckboxPageTreeItems item) {
		Locator label = page.locator("label[for='"+item.getId()+"']");
		label.scrollIntoViewIfNeeded();
		String svg = label.locator("span.rct-checkbox svg").getAttribute("class");
		if (svg.contains("rct-icon-check")) {			
			page.locator("label[for='"+item.getId()+"']").click();
		}
	}
	
	@Step("Verify if {item.label} is checked")
	public boolean isCheckBoxChecked(Page page, CheckboxPageTreeItems item) {
		Locator label = page.locator("label[for='"+item.getId()+"']");
		label.scrollIntoViewIfNeeded();
		String svg = label.locator("span.rct-checkbox svg").getAttribute("class");
		if (svg.contains("rct-icon-check")) {			
			return true;
		}
		return false;
	}
	
	@Step("Get the list of selected folders and files")
	public List<String> getSelectedFoldersAndFiles(Page page) {
		page.locator("#result").scrollIntoViewIfNeeded();
		Locator outpuValueList = page.locator("#result").locator("span");
		return outpuValueList.allInnerTexts();
	}

}

package apps.demoQA.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import apps.demoQA.enums.RadioButtonPageOption;
import io.qameta.allure.Step;

public class RadioButtonPage {

	@Step("Select the {option.label} Radio Button option")
	public void selectRadioButtonOption(Page page, RadioButtonPageOption option) {
		switch (option) {
			case YES: {
				if (!page.locator("#"+RadioButtonPageOption.YES.getId()).isDisabled()) {					
					page.locator("label[for='"+RadioButtonPageOption.YES.getId()+"']").check();
				}
				break;
			}
			case IMPRESSIVE: {
				if (!page.locator("#"+RadioButtonPageOption.IMPRESSIVE.getId()).isDisabled()) {					
					page.locator("label[for='"+RadioButtonPageOption.IMPRESSIVE.getId()+"']").check();
				}
				break;
			}
			case NO: {
				if (!page.locator("#"+RadioButtonPageOption.NO.getId()).isDisabled()) {					
					page.locator("label[for='"+RadioButtonPageOption.NO.getId()+"']").check();
				}
				break;
			}
			default: {
				System.err.println("Not able to find the correct selector for given option: " + option);
				break;
			}
		}
	}
	
	@Step("Verify if {option} radio button is checked")
	public boolean isRadioButtonChecked(Page page, RadioButtonPageOption option) {
	    return page.locator("#"+option.id).isChecked();
	}
	
	@Step("Verify if {option} radio button is disabled")
	public boolean isRadioButtonDisabled(Page page, RadioButtonPageOption option) {
	    return page.locator("#"+option.getId()).isDisabled();
	}
	
	@Step("Get the value from the You have selected area")
	public String getValueOnYouHaveSelectedArea(Page page) {
		Locator textArea = page.locator(".text-success");
		textArea.scrollIntoViewIfNeeded();
		return textArea.innerText();
	}

}

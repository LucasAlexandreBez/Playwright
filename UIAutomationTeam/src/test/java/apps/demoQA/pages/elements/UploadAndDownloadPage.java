package apps.demoQA.pages.elements;

import java.nio.file.Paths;

import com.microsoft.playwright.Page;

import io.qameta.allure.Step;

public class UploadAndDownloadPage {

	@Step("Click on Download Button")
	public void clickOnDownloadButton(Page page) {
		page.locator("#downloadButton").click();
	}
	
	@Step("Upload file: {filePath}")
	public void uploadFileToSystem(Page page, String filePath) {
	    if (filePath.isBlank()) {
	        throw new IllegalArgumentException("File path must not be null");
	    }
	    page.locator("#uploadFile").setInputFiles(Paths.get(filePath));
	}
}

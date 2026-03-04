package releases;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({
	"Feb2026_PimNewFunctions_OrangeHRM",
	"Feb2026_Regression_DemoQA"
})
@IncludeTags({
	"Release_Feb2026",
	"E2E",
	"API"
})
@ExcludeTags({"Regression"})
public class ReleasesTestSuite {
}

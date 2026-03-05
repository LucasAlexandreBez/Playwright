package releases.Feb2026_Regression_DemoQA;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	ElementsPageRegressionTest.class
})
@IncludeTags({
    "E2E",
    "API"
})
@ExcludeTags({
	"Regression"
})
public class DemoQARegressionTestSuite {

}

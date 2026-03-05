package releases.Feb2026_PimNewFunctions_OrangeHRM;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({
    E2ETest.class
})
@IncludeTags({
    "E2E",
    "API"
})
@ExcludeTags({
	"Regression"
})
public class PimNewFunctionsTestSuite {

}

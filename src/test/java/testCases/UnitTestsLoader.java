package testCases;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
// also runs tests from sub-packages:
@SelectPackages("testCases")
public class UnitTestsLoader {
}

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestlinkIntegration {
	
	public static final String TESTLINK_KEY = "2c507a54677f8c5fc32918cd624c7c86";
	public static final String TESTLINK_URL = "http://localhost/testlink-1.9.16/lib/api/xmlrpc/v1/xmlrpc.php";
	public static final String TEST_PROJECT_NAME = "SeleniumAutomation";
	public static final String TEST_PLAN_NAME = "AutomationTestPlan";
	public static final String TEST_CASE_NAME = "Login Mob2b";
	public static final String BUILD_NAME = "Sprint1Build";
	
	
	public static void updateResults(String testCaseName, String exception, String results) throws TestLinkAPIException {
		TestLinkAPIClient testlink = new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
		testlink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName, BUILD_NAME, exception, results);
	}

}

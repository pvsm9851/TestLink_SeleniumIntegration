import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testlink.api.java.client.TestLinkAPIResults;


public class LoginMob2b {
	
	public static WebDriver driver;
	public static String url = "http://mob2b-backend.cloudapp.net/User/LogOn?ReturnUrl=%2f";
	
	@Before
	public void openBrowser() throws MalformedURLException{
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void ValidLogin() throws Exception{
		try {
			driver.get(url);
			driver.findElement(By.id("Email")).sendKeys("eric.saboia@splice.com.br");
			TestlinkIntegration.updateResults("Login Mob2b", null, TestLinkAPIResults.TEST_PASSED);//("Login Mob2b", null, ExecutionStatus.PASSED);
		}catch(Exception e) {
			TestlinkIntegration.updateResults("Login Mob2b", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}

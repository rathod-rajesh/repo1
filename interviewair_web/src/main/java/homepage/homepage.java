package homepage;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/*
 * 1. check candidate login working
 * 2. check company login working
 * 3. check college login working
 */

public class homepage {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "../webdriver_64x/geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://test.interviewair.com";
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test (priority=1)
	public void testCandidateLogin() throws Exception {
		driver.get(baseUrl+"/pages/candidate/#/canSignIn");
		Thread.sleep(5000);
		driver.findElement(By.id("email_input")).clear();
		driver.findElement(By.id("email_input")).sendKeys("user1@mailzi.ru");
		driver.findElement(By.id("pwd_input")).clear();
		driver.findElement(By.id("pwd_input")).sendKeys("987654321");
		driver.findElement(By.id("signIn_btn")).click();
		Thread.sleep(5000*2);
		driver.findElement(By.id("settings_btn")).click();
		driver.findElement(By.cssSelector("#logout_div > div.settings")).click();
		Thread.sleep(5000);
		System.out.println("Done 1");
	}
	
	@Test (priority=2)
	public void testCompanyLogin() throws Exception {
		driver.get(baseUrl + "/pages/user/#/company/signIn");
		Thread.sleep(5000);
		driver.findElement(By.id("email_input")).clear();
		driver.findElement(By.id("email_input")).sendKeys("user1@mailzi.ru");
		driver.findElement(By.id("pwd_input")).clear();
		driver.findElement(By.id("pwd_input")).sendKeys("987654321");
		driver.findElement(By.id("pls-wait_btn")).click();
		Thread.sleep(5000*2);
		driver.findElement(By.xpath("//div[@id='show_card']/button")).click();
		driver.findElement(By.id("logout_tab")).click();
		Thread.sleep(5000);
		System.out.println("Done 2");
	}
	
	@Test (priority=3)
	public void testCollegeLogin() throws Exception {
		driver.get(baseUrl + "/pages/user/#/college/signIn");
		Thread.sleep(5000);
		driver.findElement(By.id("email_input")).clear();
		driver.findElement(By.id("email_input")).sendKeys("user1@mailzi.ru");
		driver.findElement(By.id("pwd_input")).clear();
		driver.findElement(By.id("pwd_input")).sendKeys("987654321");
		driver.findElement(By.id("pls-wait_btn")).click();
		Thread.sleep(5000*2);
		driver.findElement(By.xpath("//div[@id='profile_container']/div/button")).click();
		driver.findElement(By.id("logout_tab")).click();
		Thread.sleep(5000);
		System.out.println("Done 3");
	}


	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}



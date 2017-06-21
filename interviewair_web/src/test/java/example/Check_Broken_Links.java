package example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//working fine
public class Check_Broken_Links {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "../webdriver_64x/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://test.interviewair.com/");
		List<WebElement> ele = driver.findElements(By.tagName("a"));
		System.out.println("total links : " + ele.size());
		for (int i = 0; i < ele.size(); i++) {

			int statusCode = 0;
			try {
				statusCode = getResponseCode(ele.get(i).getAttribute("href"));
				//System.out.println("URL"+ele.get(i).getAttribute("href")+ " Status Code: " + statusCode);
				if (statusCode !=200) {
					System.out.println(">INVALIDLINK :->  "
							+ ele.get(i).getAttribute("href")+"\t Status Code :- "+ statusCode);
				}
			}catch (Exception e) {
				System.out.println("Empty URL"+e.toString());
			}
		}
		//		driver.close();
	}

	public static int getResponseCode(String urlString) throws IOException {
		URL u = new URL(urlString);
		HttpURLConnection h = (HttpURLConnection) u.openConnection();
		h.setRequestMethod("GET");
		h.connect();
		return h.getResponseCode();
	}
}
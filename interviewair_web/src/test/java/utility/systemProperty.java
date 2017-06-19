package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class systemProperty {

	
	public void setdriver(WebDriver driver) {
		String nameOS = "os.name";  
		String versionOS = "os.version";  
		String architectureOS = "os.arch";
		String OSBit = System.getProperty(architectureOS);

		String sub = OSBit.substring(Math.max(OSBit.length() - 2, 0));

//		System.out.println("\nThe information about OS");
//		System.out.println("\nName of the OS: " + System.getProperty(nameOS));
//		System.out.println("Version of the OS: " + System.getProperty(versionOS));
//		System.out.println("Architecture of THe OS: " + System.getProperty(architectureOS));
//		System.out.println("Architecture of THe OS >>>>>>: " + OSBit);
//		System.out.println("substring >>>>>>: " + sub);

		if(sub.equals("64")){
			System.out.println("64 Bit Operating system");
			System.out.println("launching firefox browser"); 
			System.setProperty("webdriver.firefox.marionette", "../webdriver_64x/geckodriver.exe");

			

		}else {
			System.out.println("32 Bit Operating system");
			System.out.println("launching firefox browser"); 
			System.setProperty("webdriver.gecko.driver", "../webdriver_32x/geckodriver.exe");
		}
	}

}

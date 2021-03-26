package utilities;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class OS_BrowserFactory {
		
  public WebDriver OsBrowser(String browser) throws Exception {
	
	WebDriver driver = null;
	String projectpath = System.getProperty("user.dir");
	String os = System.getProperty("os.name").toLowerCase();
	if(os.contains("mac")) {	
		if(browser.equalsIgnoreCase("chrome")) {
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("use-fake-device-for-media-stream");
	     options.addArguments("use-fake-ui-for-media-stream");
	     HashMap<String, Object> prefs = new HashMap<String, Object>();
	     prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
	     prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
	     prefs.put("profile.default_content_setting_values.geolocation", 1);
	     prefs.put("profile.default_content_setting_values.notifications", 1);
	     options.setExperimentalOption("prefs", prefs);
		System.setProperty("webdriver.chrome.driver",projectpath+"/src/main/java/resources/webDrivers/chromedriver");
		driver = new ChromeDriver(options);
		}else if(browser.equalsIgnoreCase("edge")) {
		System.out.println("inside edge setting");
		System.setProperty("webdriver.edge.driver",projectpath+"/src/main/java/resources/webDrivers/msedgedriver");
		driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
		System.out.println("inside firefox setting");
		System.setProperty("webdriver.gecko.driver",projectpath+"/src/main/java/resources/webDrivers/geckodriver");
		driver = new FirefoxDriver();
		}
		return driver;
		
	}else {
		if(browser.equalsIgnoreCase("chrome")) {
			System.out.println("inside chrome setting");
			ChromeOptions options = new ChromeOptions();
			 options.addArguments("use-fake-device-for-media-stream");
		     options.addArguments("use-fake-ui-for-media-stream");
		     HashMap<String, Object> prefs = new HashMap<String, Object>();
		     prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
		     prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
		     prefs.put("profile.default_content_setting_values.geolocation", 1);
		     prefs.put("profile.default_content_setting_values.notifications", 1);
		     options.setExperimentalOption("prefs", prefs);
			System.setProperty("webdriver.chrome.driver",projectpath+"\\src\\main\\java\\resources\\webDrivers\\Windows\\chromedriver.exe");
			driver = new ChromeDriver(options);
			}else if(browser.equalsIgnoreCase("edge")) {
			System.out.println("inside edge setting");
			System.setProperty("webdriver.edge.driver",projectpath+"\\src\\main\\java\\resources\\webDrivers\\Windows\\msedgedriver.exe");
			driver = new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
			System.out.println("inside firefox setting");
			System.setProperty("webdriver.gecko.driver",projectpath+"\\src\\main\\java\\resources\\webDrivers\\Windows\\geckodriver.exe");
			driver = new FirefoxDriver();
			}
			
		
	       }
	return driver;
     }

}

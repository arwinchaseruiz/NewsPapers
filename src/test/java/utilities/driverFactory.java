package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class driverFactory {
public static WebDriver driver;
static Properties properties;
 static FileInputStream io;

	
	public static WebDriver initializeWebDriver(String browser) throws IOException
	{
		properties = new Properties();
		
		//Change the path to where the global properties included in this project is located
		io = new FileInputStream("C:\\Users\\EJ\\Desktop\\Eclipse\\Practice\\src\\test\\java\\utilities\\global.properties");
		properties.load(io);
		
		if(browser.equalsIgnoreCase(properties.getProperty("ChromeBrowser")))
		{
			System.setProperty(properties.getProperty("ChromeSystemProperties"),properties.getProperty("ChromeDriverPath"));
		//	ChromeOptions chromeSettings = new ChromeOptions();
		//	chromeSettings.addArguments("--disable-notifications","--window-position=2000,0");
			driver = new ChromeDriver(/*chromeSettings*/);
			
		}
		else if(browser.equalsIgnoreCase(properties.getProperty("FFBrowser")))
		{
			System.setProperty(properties.getProperty("FFSystemProperties"),properties.getProperty("FFDriverPath"));
		//	FirefoxOptions ffSettings = new FirefoxOptions();
		//	ffSettings.addArguments("--disable-notifications","--window-position=2000,0");
			driver = new FirefoxDriver(/*ffSettings*/);
		}
		
		return driver;
	}
}

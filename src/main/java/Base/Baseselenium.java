package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class Baseselenium {
	
//	public static Properties prop ;
	
public static WebDriver driver;

//	public static void readdatafromconfig() throws IOException {
//		
//		File configfile = new File("C:\\Users\\a6253\\eclipse-workspace\\Cucumberpractice\\config.properties");
//
//		FileInputStream  fis = new FileInputStream(configfile);
//		
//		prop = new Properties();
//		  prop.load(fis);
//		
//	}
	
	public static String getdata(String value) throws Throwable {
		
		File configfile = new File("C:\\Users\\a6253\\eclipse-workspace\\Cucumberpractice\\config.properties");

		FileInputStream  fis = new FileInputStream(configfile);
		
		Properties prop = new Properties();
		  prop.load(fis);
		String variablename = prop.getProperty(value);
		
		return variablename;
	}
	
	public static void setDriver() throws Throwable {
		System.setProperty("webdriver.edge.driver","D:\\Testing\\msedgedriver.exe"); 
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		String BrowserURL=getdata("BrowserURL");
		
		driver.get(BrowserURL);
		
// 		DesiredCapabilities cap = new DesiredCapabilities();
// 		cap.setBrowserName("chrome");
// 		cap.setPlatform(Platform.LINUX);
		
// 		ChromeOptions chromeOptions = new ChromeOptions();
// 		chromeOptions.merge(cap);
// 		chromeOptions.addArguments("start-maximized"); // open Browser in maximized mode
// 		chromeOptions.addArguments("disable-infobars"); // disabling infobars
// 		chromeOptions.addArguments("--disable-extensions"); // disabling extensions
// 		chromeOptions.addArguments("--disable-gpu"); // applicable to windows os only
// 		chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
// 		chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
// 		String Node = "http://127.0.0.1:4444/wd/hub";

// 		driver = new RemoteWebDriver(new URL(Node), chromeOptions);
		
		}
	
	
	@SuppressWarnings("deprecation")
	public static boolean waittillelementvisible(By by) {
		 try{
			 WebDriverWait wait = new WebDriverWait(driver, 20);
			 wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
		   }
		   catch(TimeoutException exception) {
		        return false;
		    }
		   return true;
	}
	
	
	public static boolean iselementpresent(By by) {
		 try{
			 boolean eleSelected= driver.findElement(by).isDisplayed();
			 return eleSelected;
		   }
		   catch(TimeoutException exception) {
		        return false;
		    }
		   
	}

	public static void sendkey(By by, String value) {
		
		WebElement a = driver.findElement(by);
		a.sendKeys(value);
		
	} 
	
	public static void clicks(By by) {
		
		WebElement a = driver.findElement(by);
		a.click();
		
	}
	
	
	
	
	
	
	

}

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

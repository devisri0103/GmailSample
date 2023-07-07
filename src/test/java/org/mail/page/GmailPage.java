package org.mail.page;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class GmailPage {
	public static WebDriver driver;
public static void screenshot() throws IOException {
	Date d= new Date();
	String FileName = d.toString().replace(":", "").replace(" ", "") + ".png";
	TakesScreenshot ts=(TakesScreenshot)driver;
	File f= ts.getScreenshotAs(OutputType.FILE);
	File path= new File("C:\\Users\\itsme\\Downloads\\Screenshotsample/" +FileName);
	FileHandler.copy(f,path);
}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\itsme\\Downloads\\Selenium\\Drivers\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		String title=driver.getTitle();
		System.out.println(title);
		
	WebElement uname=driver.findElement(By.xpath("//input[@name='username']"));
	uname.sendKeys("devisriveni");
	String unameText=uname.getAttribute("value");
	System.out.println(unameText);
	
	WebElement pwd=driver.findElement(By.xpath("//input[@name='password']"));
	pwd.sendKeys("devi@123");
	String pwdText=pwd.getAttribute("value");
	System.out.println(pwdText);
	
	screenshot();
	WebElement login=driver.findElement(By.xpath("//input[@type='submit']"));
	login.click();	
	
	
	}

}

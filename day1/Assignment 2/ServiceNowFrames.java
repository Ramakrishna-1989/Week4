package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import week5.day1.ProjectSpecificationClass;

public class ServiceNowFrames extends ProjectSpecificationClass {

	@Test
	public void serviceNow() throws IOException {


		        
				//accessing the URL
				driver.get("https://dev111518.service-now.com/");
				System.out.println("URL accessed successfully");
				
				//switch to frame
				driver.switchTo().frame("gsft_main");
				
				//enter username and password and click on login
				
				driver.findElement(By.id("user_name")).sendKeys("admin");
				driver.findElement(By.id("user_password")).sendKeys("Rama@123");
				driver.findElement(By.xpath("//button[text()='Log in']")).click();
				
				System.out.println("Logged in Successfully");
				
				driver.switchTo().defaultContent();
				
				WebElement filter = driver.findElement(By.id("filter"));
				filter.sendKeys("incident");
				
				WebElement wbclk = driver.findElement(By.xpath("//ul[@aria-label='Modules for Application: Self-Service']//div//div[@class='sn-widget-list-title'][normalize-space()='Incidents']"));
				wbclk.click();
				//filter.sendKeys(Keys.RETURN);
				
				System.out.println("Searched the text successfully");
				
				WebElement frame = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
				driver.switchTo().frame(frame);
				
				WebElement alltext=driver.findElement(By.xpath("//a[@class='breadcrumb_link']/b[text()='All']"));
				alltext.click();
				
				System.out.println("Clicked on All options");
				
				
				
				WebElement newbtn = driver.findElement(By.xpath("//button[@id='sysverb_new']"));
				newbtn.click();
				
				System.out.println("Clicked on new button successfully");
				
				//click on search icon to choose the caller
				WebElement callerbtn = driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']"));
				callerbtn.click();
				System.out.println("Clicked on caller button successfully");
				
				//switch to window
				Set <String> allWindowHandlesSet = driver.getWindowHandles();
				List<String> allWindowHandleList = new ArrayList<String>(allWindowHandlesSet);
				String parentwindow = allWindowHandleList.get(0);
				String newwindow = allWindowHandleList.get(1);
				driver.switchTo().window(newwindow);
				
				WebElement caller = driver.findElement(By.xpath("//a[normalize-space()='Software Manager']"));
				caller.click();
				
				Set <String> allWindowHandlesSet2 = driver.getWindowHandles();
				List<String> allWindowHandleList2 = new ArrayList<String>(allWindowHandlesSet2);
				String parentwindow2 = allWindowHandleList2.get(0);
				//caller.sendKeys(Keys.TAB);
				
				//switch to default window
				driver.switchTo().window(parentwindow2);
			
				driver.switchTo().frame("gsft_main");
				
				//switch to default window
				driver.switchTo().window(parentwindow);
			
				driver.switchTo().frame("gsft_main");
				
				//enter description
				WebElement desc = driver.findElement(By.xpath("//input[@id='incident.short_description']"));
				desc.sendKeys("Software Manager oversees the activities in the project for the testing");
				System.out.println("Entered Description successfully");
				
				
				//get the incident number
				WebElement incidentno = driver.findElement(By.xpath("//input[@id='incident.number']"));
				String str = incidentno.getAttribute("value");
				System.out.println("Incident number is: "+str);
				
				//click on submit
				WebElement submitbtn = driver.findElement(By.xpath("//button[@type='submit' and @id='sysverb_insert']"));
				submitbtn.click();
				System.out.println("Created incident successfully");
				
				WebElement searchincidentno=driver.findElement(By.xpath("//input[@placeholder='Search' and @class='form-control']"));
				searchincidentno.sendKeys(str);
				searchincidentno.sendKeys(Keys.ENTER);
				System.out.println("Searched created incident successfully");
				
				File Incidentscrnshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(Incidentscrnshot , new File("C:\\Users\\Suji\\git\\repository\\Classes\\target\\Screenshots\\screenshot.png"));
				
				System.out.println("Screenshot took successfully");
				

				
	}
	

}

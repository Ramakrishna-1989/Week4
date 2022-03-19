package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import week5.day1.ProjectSpecificationClass;

public class AlertsAndWindows extends ProjectSpecificationClass {

@Test
public void alertsAndwindowHandling() {
	driver.get("https://www.irctc.co.in/");
	
	WebElement clkok = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
	clkok.click();
	System.out.println("clicked on OK in dialog window successfully");
	
	driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
	
	Set<String> allWindowHandles = driver.getWindowHandles();
	List<String> handles = new ArrayList<String>();
	handles.addAll(allWindowHandles);
	
	System.out.println("Size of Windo handles are: " +handles);
	
	driver.switchTo().window(handles.get(1));
	
	driver.findElement(By.xpath("//button[text()='Later']")).click();
	
	driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
	
	driver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[3]")).getText();
	
	//driver.switchTo().window(handles.get(0));
	
	
	
}

}

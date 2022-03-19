package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import week5.day1.ProjectSpecificationClass;

public class FramesPractice extends ProjectSpecificationClass {

	@Test
	public void framesCheck() {
		
		//enter URL
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.switchTo().frame("frame1");
		WebElement Topic = driver.findElement(By.xpath("//body//input"));
		Topic.sendKeys("Frames Topic with different frames");
		System.out.println("Text entered successfully");
		
		driver.switchTo().frame("frame3");
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='a']"));
		checkbox.click();
		System.out.println("Clicked on diff frame checkbox");
		
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		Select animal = new Select(driver.findElement(By.id("animals")));
		animal.selectByValue("big baby cat");
		System.out.println("Selected the value from dropdown");
		driver.switchTo().defaultContent();

		

		
	}
	
}

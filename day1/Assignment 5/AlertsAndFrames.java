package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import week5.day1.ProjectSpecificationClass;

public class AlertsAndFrames extends ProjectSpecificationClass {

	@Test
	public void alertsAndframesHandling() {
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		
		//Switching to frame
		driver.switchTo().frame("iframeResult");
		WebElement tryit = driver.findElement(By.xpath("//button[text()='Try it']"));
		tryit.click();
		
		//Handling Alert
		Alert a = driver.switchTo().alert();
		a.accept();
		
		//confirm by getting the text
		
		WebElement verifytext = driver.findElement(By.xpath("//p[@id='demo']"));
		System.out.println(verifytext.getText());
		
		
		
	}
}

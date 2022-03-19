package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import week5.day1.ProjectSpecificationClass;

public class FindNoOfFrames extends ProjectSpecificationClass {

	@Test
	public void totalNoframes() {
		driver.get("http://leafground.com/pages/frame.html");
		
		List <WebElement> ll = driver.findElements(By.tagName("iframe"));
		int Totalframes = ll.size();
		System.out.println("Total number of frames in the main page is: "+Totalframes);
		
	
	}
}

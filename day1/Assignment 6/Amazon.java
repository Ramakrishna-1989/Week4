package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import week5.day1.ProjectSpecificationClass;

public class Amazon extends ProjectSpecificationClass {

	@Test
	public void verifyCartvalue() {
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		//get price of first product
		WebElement pricefp = driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[3]//div[1]//div[1]//div[1]//div[1]//a[1]//span[1]//span[2]//span[2]"));
		System.out.println("Price of the product is: "+pricefp.getText());
		
		
		//number of customer ratings for the first product
		WebElement customerrating = driver.findElement(By.xpath("//div[@data-cel-widget='search_result_2']//a[contains(@href,'customerReviews')]"));
		System.out.println("Total no of Customer Ratings" +customerrating.getText());
		
		//click on customer ratings
		WebElement ratings = driver.findElement(By.xpath("//div[@data-cel-widget='search_result_2']//a[contains(@role,'button')]"));
		ratings.click();
		System.out.println("Clicked on Ratings Successfully");
		
		//WebElement fivestar = driver.findElement(By.xpath("//a[@class='a-link-normal 5star']"));
		//System.out.println("Total number of percentage 5 star have: "+fivestar.getText());
		
		WebElement percentage = driver.findElement(By.xpath("//table[@id='histogramTable']//tbody//tr[1]//td[3]//span[2]//a"));
		System.out.println(percentage.getText());
		
		
	}
	
}

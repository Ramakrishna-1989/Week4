package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesLearning {

	public static void main(String[] args) throws Throwable {

		System.out.println("The Automation Testing Started");

		System.out.println("Setting up the driver for chrome browser");
		        WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();

				
				System.out.println("Chrome browser started");
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//accessing the URL
				driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
				System.out.println("URL accessed successfully");
				
				//Switch To frame
				driver.switchTo().frame("iframeResult");
				
				//Click on Try it button
				WebElement btn = driver.findElement(By.xpath("//button[text()='Try it']"));
				btn.click();
				
				//switch to alert.
				Alert alert = driver.switchTo().alert();
				alert.sendKeys("Ramakrishna DV");
				Thread.sleep(1000);
				alert.accept();
				
				//Verify the text 
				WebElement gText = driver.findElement(By.xpath("//p[@id='demo']"));
				System.out.println(gText.getText());
				
	}

}

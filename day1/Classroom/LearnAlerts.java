package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {

	public static void main(String[] args) {

		System.out.println("The Automation Testing Started");

		System.out.println("Setting up the driver for chrome browser");
		        WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();

				
				System.out.println("Chrome browser started");
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//accessing the URL
				driver.get("http://www.leafground.com/pages/Alert.html");
				System.out.println("URL accessed successfully");
				
				//Simple Alert
				WebElement sAlert = driver.findElement(By.xpath("//button[text()='Alert Box']"));
				sAlert.click();
				
				//Switchto Alert Box and click on ok.
				Alert alert = driver.switchTo().alert();
				String str = alert.getText();
				System.out.println(str);
				alert.accept();
				System.out.println("Clicked OK on the Alert Box successfully");
		
				//Confirm Alert
				WebElement cAlert = driver.findElement(By.xpath("//button[text()='Confirm Box']"));
				cAlert.click();
				
				//Switchto Alert Box and click on ok.
				Alert alert1 = driver.switchTo().alert();
				String str1 = alert1.getText();
				System.out.println(str1);
				alert1.dismiss();
				System.out.println("Clicked cancel on the Alert Box successfully");
		
				//Prompt Alert
				WebElement pAlert = driver.findElement(By.xpath("//button[text()='Prompt Box']"));
				pAlert.click();
				
				//Switchto Alert Box and click on ok.
				Alert alert2 = driver.switchTo().alert();
				String str2 = alert2.getText();
				System.out.println(str2);
				alert2.sendKeys("Ramakrishna DV");
				alert2.accept();
				System.out.println("Entered Text on the Alert Box successfully");
		
	}

}

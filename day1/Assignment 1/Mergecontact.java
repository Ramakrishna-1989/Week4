package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import week5.day1.ProjectSpecificationClass;

public class Mergecontact extends ProjectSpecificationClass {

	@Test
	public void mergeContactfn() {

		
				driver.get("http://leaftaps.com/opentaps/control/main");
				System.out.println("URL accessed successfully");
				
				//entering username and password , then click on login
				WebElement username = driver.findElement(By.id("username"));
				username.sendKeys("Demosalesmanager");
				System.out.println("Entered Username Successfully");
				
				WebElement password = driver.findElement(By.id("password"));
				password.sendKeys("crmsfa");
				System.out.println("Entered Password Successfully");
				
				WebElement loginbtn = driver.findElement(By.xpath("//input[@type='submit' and @value='Login']"));
				loginbtn.click();
				System.out.println("Clicked on login button successfully");
				
				//clicked on link
				WebElement link = driver.findElement(By.linkText("CRM/SFA"));
				link.click();
				System.out.println("Clicked on link successfully");
				
				//cick on contact button
				WebElement contacts = driver.findElement(By.linkText("Contacts"));
				contacts.click();
				System.out.println("Clicked on contacts successfully");
				
				//cick on merge contacts
				WebElement mcontacts = driver.findElement(By.xpath("//a[text()='Merge Contacts']"));
				mcontacts.click();
				System.out.println("Clicked on merge contacts successfully");
				
				//click on widget
				WebElement wid1=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/a[1]/img[1]"));
				wid1.click();
				
				//switch to window
				
				Set <String> allWindowHandlesSet = driver.getWindowHandles();
				List<String> allWindowHandleList = new ArrayList<String>(allWindowHandlesSet);
				
				String newwindow = allWindowHandleList.get(1);
				driver.switchTo().window(newwindow);
				
				//click on first contact
				WebElement findcontact = driver.findElement(By.xpath("(//div/a[@class='linktext'])[1]"));
				String firstcontact = findcontact.getText();
				System.out.println(firstcontact);
				findcontact.click();
				
				driver.switchTo().window(allWindowHandleList.get(0));
				
				//click on Towidget
				WebElement wid2=driver.findElement(By.xpath("//tbody/tr[2]/td[2]/a[1]/img[1]"));
				wid2.click();
				
				Set <String> allWindowHandlesSet1 = driver.getWindowHandles();
				List<String> allWindowHandleList1 = new ArrayList<String>(allWindowHandlesSet1);
				String newwindow1 = allWindowHandleList1.get(1);
				driver.switchTo().window(newwindow1);
				
				WebElement findTocontact = driver.findElement(By.xpath("(//div/a[@class='linktext'])[6]"));
				String secondcontact = findTocontact.getText();
				System.out.println(secondcontact);
				findTocontact.click();
				
				driver.switchTo().window(allWindowHandleList1.get(0));

				//click on merge button
				
				WebElement mergecontact = driver.findElement(By.xpath("//a[@class='buttonDangerous']"));
				mergecontact.click();
				System.out.println("Clicked on Merge button");
				
				Alert alert = driver.switchTo().alert();
				alert.accept();
				
				System.out.println(driver.getTitle());
				
				driver.close();
				
				
	}

}

package com.project.Testngproject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test(priority = 1)
public class RegistrationFormTest {
	//WebDriver driver;
	
	public void ShowRegistration() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\rs\\driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		 driver.navigate().to("http://automationpractice.com/index.php");
		  
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.linkText("Sign in")).click(); 

		 driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("sampleprasad09@gmail.com");
		 Thread.sleep(2000);
		 driver.findElement(By.id("SubmitCreate")).click();		 
		
		 String valueOfGender = "1"; 
		 List<WebElement> RadioButtonList = driver.findElements(By.name("id_gender"));
		  
		  
		 for (int i = 0; i < RadioButtonList.size(); i++){
		   String gend = RadioButtonList.get(i).getAttribute("value");
		   if (gend.equalsIgnoreCase((valueOfGender))){
		    RadioButtonList.get(i).click();
		    break;
		   }
		   
		  }
		 
		 
		 
		 driver.findElement(By.id("customer_firstname")).sendKeys("SampleFirstName");
		 driver.findElement(By.id("customer_lastname")).sendKeys("SampleLastName");
		 driver.findElement(By.id("passwd")).sendKeys("SamplePassword@1999");
		 
		  Select sDate = new Select(driver.findElement(By.id("days")));
		  sDate.selectByVisibleText("1  ");
		  
		  Select sMonth = new Select(driver.findElement(By.id("months")));
		  sMonth.selectByVisibleText("April ");
		  
		  Select sYear = new Select(driver.findElement(By.id("years")));
		  sYear.selectByVisibleText("1999  ");


		  driver.findElement(By.id("newsletter")).click();
		  driver.findElement(By.id("uniform-optin")).click();
		  
		  driver.findElement(By.id("company")).sendKeys("BNP Paribas");
		  driver.findElement(By.id("address1")).sendKeys("sampleaddress1");
		  driver.findElement(By.id("address2")).sendKeys("sampleaddress2");
		  driver.findElement(By.id("city")).sendKeys("Chennai");
		  
		  Select sState = new Select(driver.findElement(By.id("id_state")));
		  sState.selectByVisibleText("New York");
		  driver.findElement(By.id("postcode")).sendKeys("600064");
		  Select sCountry = new Select(driver.findElement(By.id("id_country")));
		  sCountry.selectByVisibleText("United States");
		  
		  
		  driver.findElement(By.id("other")).sendKeys("additional informations....");
		  driver.findElement(By.id("phone")).sendKeys("1234567890");
		  driver.findElement(By.id("phone_mobile")).sendKeys("0987654321");
		  driver.findElement(By.id("alias")).sendKeys("address alias for future reference");
		  System.out.println("Registration successful");
		  Thread.sleep(5000);
		  
		  
		  driver.close();
	}
	

}

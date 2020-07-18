package com.project.Testngproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginForm {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\rs\\driver\\chromedriver.exe");
		 
		 driver= new ChromeDriver();
		 driver.navigate().to("http://automationpractice.com/index.php");

		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.findElement(By.linkText("Sign in")).click(); 
	}
	
	@Test(priority = 2)
	public void LoginPageTest() throws InterruptedException {
		
		
		
		WebElement username=driver.findElement(By.id("email"));
		WebElement password=driver.findElement(By.id("passwd"));
	    WebElement login=driver.findElement(By.id("SubmitLogin"));
	        
	     username.sendKeys("project4@gmail.com");
	     password.sendKeys("project4@gmail.com");
	     Thread.sleep(2000);
	     login.click();
	     Thread.sleep(5000);
		

		    
	     String actualUrl="http://automationpractice.com/index.php?controller=my-account";
	     String expectedUrl= driver.getCurrentUrl();
	        
	     if(actualUrl.equalsIgnoreCase(expectedUrl))
	     {
	    	 System.out.println("Login Successful");
	     }
	     else
	     {
	         System.out.println("Login failed");
	     
	     }
	     
	     
		 driver.findElement(By.linkText("Sign out")).click(); 

	   
	        
	}
	
	@Test(priority = 3)
	public void invalidLoginTest() throws InterruptedException {
		WebElement username=driver.findElement(By.id("email"));
		WebElement password=driver.findElement(By.id("passwd"));
	    WebElement login=driver.findElement(By.id("SubmitLogin"));
	        
	     username.sendKeys("project4@gmail.com");
	     password.sendKeys("errorproject4@gmail.com");
	     Thread.sleep(2000);
	     login.click();
	     Thread.sleep(6000);
		

		    
	     String actualUrl="http://automationpractice.com/index.php?controller=my-account";
	     String expectedUrl= driver.getCurrentUrl();
	        
	     if(actualUrl.equalsIgnoreCase(expectedUrl))
	     {
	    	 System.out.println("Login Successful");
	     }
	     else
	     {
	         System.out.println("Invalid Login Details....Please check username and password");
	         System.out.println("Login failed");
	     
	     }
	     
	     
		 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}

package com.project.Testngproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchCartAutomation {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\rs\\driver\\chromedriver.exe");
		 
		 driver= new ChromeDriver();
		 driver.navigate().to("http://automationpractice.com/index.php");

		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	}
	
	@Test(priority = 4)
	public void SearchbarCheck() throws InterruptedException {
		
		  driver.findElement(By.id("search_query_top")).sendKeys("Summer Dress");
		  Thread.sleep(3000);
		  driver.findElement(By.name("submit_search")).click();
		  Thread.sleep(6000);
		  
		  String actualUrl="http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=Summer+Dress&submit_search=";
		  String expectedUrl= driver.getCurrentUrl();
		  
		        
		     if(actualUrl.equalsIgnoreCase(expectedUrl))
		     {
		    	 System.out.println("Search operation..... Successful");
		     }
		     else
		     {
		         System.out.println("Search operation...... failed");
		     
		     }


	}
	
	@Test(priority = 5)
	public void addCartAutomation() throws InterruptedException {
		
		 driver.findElement(By.id("search_query_top")).sendKeys("Evening Dress");
		 driver.findElement(By.name("submit_search")).click();
		 driver.findElement(By.className("product-container")).click(); 
		 
		 driver.findElement(By.id("add_to_cart")).click(); 
		 System.out.println("1 item is added to the cart");
		 Thread.sleep(5000);
		 
		 driver.findElement(By.className("cross")).click();
		 driver.findElement(By.id("search_query_top")).clear(); 

		 
		 driver.findElement(By.id("search_query_top")).sendKeys("Blouse");
		 driver.findElement(By.name("submit_search")).click();
		 driver.findElement(By.className("product-container")).click(); 
	 
		 driver.findElement(By.id("add_to_cart")).click(); 
		 System.out.println("2 item is added to the cart");
		 Thread.sleep(5000);
		 driver.findElement(By.className("cross")).click();

		 driver.findElement(By.className("shopping_cart")).click();
		 Thread.sleep(6000);


		 System.out.println("Add to Cart operation is executed successfully");

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}



}

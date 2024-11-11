package Maac;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Profile_Update {

	public static void main(String[] args) throws InterruptedException {
		
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.xampro.org/login");
	
	//Login
	driver.findElement(By.name("email")).sendKeys("baust.cse54@gmail.com"); 
	Thread.sleep(2000);
	driver.findElement(By.name("password")).sendKeys("22446688"); 
	Thread.sleep(2000);
	
     WebElement loginButton = driver.findElement(By.className("account-access-submit-button"));                                       
       
     loginButton.click(); 
     Thread.sleep(3000);                                        
 	
     
     driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div[1]/div/p/a/b")).click();
 	Thread.sleep(2000);    
 	
 // Clear any existing text
 	WebElement inputField = driver.findElement(By.id("fullName"));
 	inputField.clear();
 	driver.findElement(By.id("fullName")).sendKeys("Md Saju Islam"); 
	Thread.sleep(1000);
	
	
	// Clear any existing text
	WebElement inputPhone = driver.findElement(By.id("phoneNumber"));
	inputPhone.clear();
	driver.findElement(By.id("phoneNumber")).sendKeys("01745476040"); 
	Thread.sleep(1000);
 	
 	
	WebElement dobField = driver.findElement(By.id("dob"));
	// Clear any existing value
	dobField.clear();
	// Enter the date in the required format (e.g., "MM/dd/yyyy"
	dobField.sendKeys("04/20/1999");
 	
	WebElement radiobutton= driver.findElement(By.id("radio-gender-male"));
	radiobutton.click();
	Thread.sleep(1000);
 	
	WebElement testdropdown=driver.findElement(By.id("education"));
	Select dropdown = new Select(testdropdown);
	dropdown.selectByIndex(5);
	Thread.sleep(2000);


 	
	    
	    WebElement UpdateButton = driver.findElement(By.className("profile-submit-page-btn btn btn-primary")); // update ID as per button
	    UpdateButton.click();
  
	}

}
package Maac;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.InputStream;

public class Login {
    public static void main(String[] args) {
        // Set the path to your WebDriver
    	 WebDriverManager.chromedriver().setup();
 	    WebDriver driver = new ChromeDriver();
 		driver.manage().window().maximize();
        driver.get("https://www.xampro.org/login");

        try {
            // Load JSON data from file
            InputStream is = new FileInputStream("./JsonFile/Login.json");
            JSONTokener tokener = new JSONTokener(is);
            JSONObject jsonObject = new JSONObject(tokener);

            // Retrieve last registered user's data
            JSONObject lastRegistered = jsonObject.getJSONObject("lastRegistered");
            String email = lastRegistered.getString("email");
            String password = lastRegistered.getString("password");

            // Fill in the login form fields
            WebElement emailField = driver.findElement(By.id("email"));  // replace with actual ID if different
            WebElement passwordField = driver.findElement(By.id("password")); // replace with actual ID if different
            
            Thread.sleep(1000);
            emailField.sendKeys(email);
            Thread.sleep(1000);
            passwordField.sendKeys(password);

            // Click on the login button
            WebElement loginButton = driver.findElement(By.className("account-access-submit-button")); // replace with actual ID if different
            
            loginButton.click();
            
       

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Optionally close the driver after a delay to see results
            try {
                Thread.sleep(3000);  // delay to observe result
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           
        }
    }
}

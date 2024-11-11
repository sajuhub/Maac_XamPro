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

public class Registration {
    public static void main(String[] args) {
        // Set the path to your WebDriver
        WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://www.xampro.org/signup");

        try {
            // Load JSON data from file
            InputStream is = new FileInputStream("./JsonFile/Registration.json");
            JSONTokener tokener = new JSONTokener(is);
            JSONObject jsonObject = new JSONObject(tokener);

            // Retrieve data from JSON
            String username = jsonObject.getString("username");
            String email = jsonObject.getString("email");
            String password = jsonObject.getString("password");
            String confirmPassword = jsonObject.getString("confirmPassword");
            String phoneNumber = jsonObject.getString("phoneNumber");

            // Fill the signup form fields
            WebElement usernameField = driver.findElement(By.id("name")); // update ID as per form
            WebElement emailField = driver.findElement(By.id("email"));       // update ID as per form
            WebElement passwordField = driver.findElement(By.id("password")); // update ID as per form
            WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword")); // update ID as per form
            WebElement phoneNumberField = driver.findElement(By.id("phoneNumber")); // update ID as per form

            usernameField.sendKeys(username);
            Thread.sleep(1000);
            emailField.sendKeys(email);
            Thread.sleep(1000);
            phoneNumberField.sendKeys(phoneNumber);
            Thread.sleep(1000);
            passwordField.sendKeys(password);
            Thread.sleep(1000);
            confirmPasswordField.sendKeys(confirmPassword);
            Thread.sleep(1000);
          

            // Click on the signup button
            WebElement signupButton = driver.findElement(By.className("account-access-submit-button")); // update ID as per button
            signupButton.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
   
            try {
                Thread.sleep(3000);  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           
        }
    }
}

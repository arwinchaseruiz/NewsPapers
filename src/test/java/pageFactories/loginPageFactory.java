package pageFactories;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPageFactory {

@FindBy(linkText = "Sign-in")	
WebElement signInLink;	

@FindBy(id ="username")
WebElement usernameField;	

@FindBy(id = "password")
WebElement passwordField;

@FindBy(xpath = "//small[@class='text-uppercase text-white d-block text-smaller']")
WebElement registeredLabel;
	
WebDriver driver;
WebDriverWait wait;

	
	public loginPageFactory(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		driver.get("https://www.newspapers.com");
		driver.manage().window().maximize();
	}
	
	
	public void click_Sign_In_Link()
	{
		signInLink.click();
	}
	
	public void setEmail(String email)
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(usernameField));
		usernameField.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public void click_Sign_In_button()
	{
		/*For the input type submit, I used this method since we technically clicked Email and PW field, 
		hence hitting Enter will also trigger the button */
		passwordField.sendKeys(Keys.ENTER);
	}
	
	public void user_sees_Homepage()
	{
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(registeredLabel));
		Assert.assertTrue(registeredLabel.getText().equalsIgnoreCase("Registered"));
		System.out.println("User was logged in successfully");
	}
}

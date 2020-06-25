package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactories.loginPageFactory;
import utilities.driverFactory;

public class loginStepDefinition {

	
static WebDriver driver;
loginPageFactory login;


	@Before
	public void setUp() throws IOException
	{
		driver = driverFactory.initializeWebDriver("chrome");
		/*For using Maven 
		  String browser;
		  System.getProperty("browser");
		  driver = driverFactory.initializeWebDriver(browser);
		 */
		
	}
	
	@Given("^User is on the Newpapers.com Homepage.$")
	public void user_is_on_homepage()
	{
		login = new loginPageFactory(driver);
	}
	
	
	@When("^User clicks Sign In link.$")
	public void user_clicks_on_Sign_In_link()
	{
		login.click_Sign_In_Link();
	}
	
	@And("^User enters his email. (.*)$")
	public void user_enters_his_email(String email)
	{
		login.setEmail(email);
	}
	
	@And("^User enters his password. (.*)$")
	public void user_enters_his_password(String password)
	{
		login.setPassword(password);
	}
	
	
	@Then("^User clicks Sign In with Newspapers.com button.$")
	public void user_click_Sign_In_button()
	{
		login.click_Sign_In_button();
	}
	
	@And("^User sees the Homepage.$")
	public void user_sees_the_Homepage()
	{
		login.user_sees_Homepage();
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
}

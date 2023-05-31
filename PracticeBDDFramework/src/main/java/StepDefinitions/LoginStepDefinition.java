package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class LoginStepDefinition {
	
	WebDriver driver;
	@Given("^User is already on home page$")
	public void user_is_already_on_home_page() {
		System.setProperty("webdriver.chrome.driver", "E:\\Practice Cucumber\\PracticeBDDFramework\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com");
	   
	}

	@When("^Title of login page is FreeCRM$")
	public void title_of_login_page_is_FreeCRM() throws Exception {
	   String title = driver.getTitle();
	   System.out.println(title);
	   driver.manage().window().maximize();
	   Thread.sleep(3000);
	}

	@Then("^user enters username and password$")
	public void user_enters_username_and_password() {
	   driver.findElement(By.name("email")).sendKeys("soniabatra14@gmail.com");
	   driver.findElement(By.name("password")).sendKeys("abcd@123");
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button()  {
		
		WebElement loginBtn = driver.findElement(By.xpath("//a//span[text()='Log In']"));
		loginBtn.click();
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("argument[0].click();",loginBtn);
	   
	}
	@And("^user again clicks on login button$")
	public void user_again_clicks_on_login_button()  {
		WebElement loginBtn = driver.findElement(By.xpath("//div[text()='Login']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].click();",loginBtn);
	   
	}
	@Then("^user is on homepage$")
	public void user_is_on_homepage() {
	   String title = driver.getTitle();
	   System.out.println("home page title" + title);
	   Assert.assertEquals("CRMPRO", title);
	}

}

package stepDefinition;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ELearningSteps {
	WebDriver driver;
	public ELearningSteps() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Priyanka Sasargoan\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    this.driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

	@Given("the user opens the eLearning site")
	public void the_user_opens_the_eLearning_site()  {
	    driver.get("http://elearningm1.upskills.in/index.php");
	}

	@When("the user clicks on signUp")
	public void the_user_clicks_on_signUp() {
		driver.findElement(By.xpath("//a[text()=' Sign up! ']")).click();
	}

	@Then("the user need to fill up the regestiation form for all mandatory fields")
	public void the_user_need_to_fill_up_the_regestiation_form_for_all_mandatory_fields(io.cucumber.datatable.DataTable dataTable) {
		Map<String,String> data = dataTable.asMap(String.class, String.class);
		driver.findElement(By.name("firstname")).sendKeys(data.get("First Name"));
		driver.findElement(By.name("lastname")).sendKeys(data.get("Last Name"));
		driver.findElement(By.name("email")).sendKeys(data.get("Email"));
		driver.findElement(By.name("username")).sendKeys(data.get("Username"));
		driver.findElement(By.name("pass1")).sendKeys(data.get("Password"));
		driver.findElement(By.name("pass2")).sendKeys(data.get("Password"));
	}

	@When("the user submits the details")
	public void the_user_submits_the_details() {
		driver.findElement(By.name("submit")).click();
	}

	@Then("the user should see the message saying {string}")
	public void the_user_should_see_the_message_saying(String msg) {
		String msg1= driver.findElement(By.xpath("//p[text()='Your personal settings have been registered.']")).getText();
		Assert.assertEquals("The Registered message is not displayed",msg,msg1);
	}

	@When("the user clicks on Next button")
	public void the_user_clicks_on_Next_button() {
		driver.findElement(By.name("next")).click();
	}

	@Then("the user is navigated to HomePage")
	public void the_user_is_navigated_to_HomePage() {
		Boolean bool= driver.findElement(By.xpath("//a[text()='Homepage']")).isDisplayed();
		Assert.assertTrue("The Homepage is not Visible", bool);
	}

	@When("the user clicks the username icon")
	public void the_user_clicks_the_username_icon() {
		driver.findElement(By.xpath("//*[@id='menuone']/ul[2]/li[1]/a/span")).click();
	}

	@And("the user choose profile from Dropdown")
	public void the_user_choose_profile_from_Dropdown() {
		driver.findElement(By.xpath("//a[text()=' Profile']")).click();
	}

	@And("the user clicks on Messages")
	public void the_user_clicks_on_Messages() {
		driver.findElement(By.xpath("//*[@id='sn-sidebar-collapse']/div/ul/li[2]/a")).click();
	}

	@And("the user clicks on Compose message")
	public void the_user_clicks_on_Compose_message() {
		driver.findElement(By.xpath("//*[@id='toolbar']/div/div[1]/a[1]/img")).click();
	}

	@And("the user enters the details shown on the page")
	public void the_user_enters_the_details_shown_on_the_page(io.cucumber.datatable.DataTable dataTable) {
		Map<String,String> data = dataTable.asMap(String.class, String.class);
//		driver.findElement(By.xpath("//*[@id='compose_message']/fieldset/div[1]/div[1]/span/span[1]/span/ul/li/input")).sendKeys(data.get("Send To"),Keys.ENTER);
		driver.findElement(By.name("title")).sendKeys(data.get("Subject"));
//		driver.findElement(By.name("email")).sendKeys(data.get("Message"));
//		driver.findElement(By.id("file-descrtiption")).sendKeys(data.get("Description"));
	}

	@And("the user should click on Send message")
	public void the_user_should_click_on_Send_message() {
		driver.findElement(By.name("compose")).click();
		driver.close();
	}
}

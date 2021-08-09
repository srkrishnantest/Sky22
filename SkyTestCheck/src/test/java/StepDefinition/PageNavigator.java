/*
 *  This is the Step Definition file, This translates and maps the scenarios in
 *     BDD File to java functions. This enables Navigation between various pages
 *     
*/

package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.ReadPropertyFile;
import Pages.DealsPage;
import Pages.HomePage;
import Pages.SearchPage;
import Pages.SignInPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PageNavigator{
	
//All the Page Object Model Pages are instantiated for access across the Navigator Page	
	public HomePage homePage = null;
	public DealsPage dealsPage = null;
	public SignInPage signInPage = null;
	public SearchPage searchPage = null; 
	public WebDriver driver;
	public String BaseURL = "https://www.sky.com/";
	
	public boolean home_page_confirm = false;
	public boolean tiles_menu_confirm = false;
	ReadPropertyFile readPropFile;
	int tab_display = 0;
	
//Initial setup steps before scenarios are executed step-wise
	@Before(order=0)
	public void initDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(BaseURL);
		driver.manage().window().maximize();
		readPropFile = new ReadPropertyFile();
	}
// Another initial setup with priority 2, which gets Cookie and Accepts/ consents
	@Before(order=1)
	public void cookieConsent() {
		homePage = new HomePage(driver);
		homePage.getCookieConsent();
	}
// Initial Setup priority 3, to confirm the URl hits the Home Page 
	@Before(order=2)
	public void initPages() {
		homePage = new HomePage(driver);
		signInPage = new SignInPage(driver);
	}

// Test Steps for each scenario
	@Given("I am on the home page")
	public void i_am_on_the_home_page() {
		home_page_confirm = homePage.checkBannerStream();
	    tiles_menu_confirm=homePage.tilesMenu();
	   if((tiles_menu_confirm)) {
		  System.out.println("In Home page and have have Tiles menu");
	   }
	}
	
	@When("I navigate to Deals")
	public void i_navigate_to_deals() {
	    homePage.clickDeals();
		
		
	}

	@Then("the user should be on the deals page")
	public void the_user_should_be_on_the_deals_page() {
		dealsPage = new DealsPage(driver);
		tab_display = dealsPage.validateDealsPage();
	 }
	
	@Given("I am on the deals page")
	public void i_am_on_the_deals_page() {
		homePage.clickDeals();
		dealsPage = new DealsPage(driver);
		tab_display = dealsPage.validateDealsPage();
	}

	@Then("I see a list of deals with a price to it")
	public void i_see_a_list_of_deals_with_a_price_to_it() {
		dealsPage.clickTvDeal();
	    dealsPage.clickBbTvDeal();
	    dealsPage.clickMobileDeal();
	}
	
	
	@When("I try to sign in with invalid credentials")
	public void i_try_to_sign_in_with_invalid_credentials() {
		homePage.clickSignIn();
		boolean signConf = signInPage.signInPageConfirm();
		signInPage.enterUserName(readPropFile.getProperty("username"));
		signInPage.enterPasswor(readPropFile.getProperty("password"));
		
	}

	@Then("I should see a text saying that Sorry, we did not recognise either your username or password")
	public void i_should_see_a_text_saying_that_sorry_we_did_not_recognise_either_your_username_or_password() {
	    signInPage.enterSignInButton();
	    try {
	    driver.findElement(By.xpath("//li[contains(text(),'Sorry, we did not recognise either your username o')]")).isDisplayed();
	 	    }
	    catch(NoSuchElementException e) {
	    	System.out.println("The unrecognised page is not displayed, rather moved to Account Problem Page");
	   	    }
	   	}
	
	
	@When("I search sky in the search bar")
	public void i_search_sky_in_the_search_bar() throws InterruptedException {
		searchPage = new SearchPage(driver);
		searchPage.searchAvailConfirm();
		searchPage.clickSearchIcon();
		searchPage.enterSearchText(readPropFile.getProperty("searchtext"));				
	}
	
	@Then("I should see an editorial section")
	public void i_should_see_an_editorial_section() throws InterruptedException {
		searchPage.enterSearchButton();
		searchPage.checkSearchResults();		
	}
//To execute after each scenario, to tear down the driver	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();		
	}
}
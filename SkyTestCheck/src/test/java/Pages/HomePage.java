/*
 * This is the Home Page Page Object Model (POM).
 * 
 * This captures all the elements (required) and their associated methods
 * The class is instantiated from the PageNavigator class, and the constructor is created.
 * 
 * The methods available are to
 * 1. Check Home page (checkSignIn() and checkBannerStream(), checkTVMenu()
 * 2. getCookieConsent() to accept cookies
 * 3. clickDeals() to navigate to Deals Page
 * 4. clickSignIn() to navigate to SignIn page
 * 
 */

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private By signin_text = By.xpath("//a[contains(text(),'Sign in')]");
	private By banner_stream = By.xpath("//body/main[@id='root']/div[1]/div[2]/a[1]");
	private By deals_menu = By.linkText("Deals");
	private By tv_menu = By.cssSelector("div.mast-c-header:nth-child(4) div.masthead-header.svelte-1sub3cm:nth-child(2) div.masthead-header-inner-container.svelte-1sub3cm header.svelte-1sub3cm div.nav-group-wrapper.svelte-1sub3cm div.container.svelte-77t67t div.scrollable-wrapper.svelte-77t67t div.nav-wrapper.svelte-77t67t:nth-child(1) ul.primary-nav-list.svelte-gc959a li.nav-item.primary-nav-item.svelte-5aa6bu:nth-child(1) div.nav-item-group.svelte-1f00han div.nav-item-group-ctas.svelte-1f00han > a.nav-item-link.nav-link.tab-focus.primary-nav-link.svelte-vivf6p");
	private By iFrame = By.id("sp_message_iframe_474555");
	private boolean home_page = false;
	private boolean tiles_page=false;
	private boolean tiles_banner=false;
	
	
	public WebDriver driver = null;
	public DealsPage dealsPage = null;
	public SignInPage signInPage = null;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkSignIn() {
		if(driver.findElement(signin_text).isDisplayed()) {
			tiles_page = true;
		}
		else {
			tiles_page = false;
		}
		return(tiles_page);
	}	
	public boolean checkBannerStream() {
		if(driver.findElement(banner_stream).isDisplayed()) {
			home_page = true;
		}
		else {
			home_page = false;
		}
		return(home_page);
	}	
	public boolean checkTvMenu() {
		if(driver.findElement(tv_menu).isDisplayed()) {
			tiles_page = true;
		}
		else {
			tiles_page = false;
		}
		return(tiles_page);
	}
	public void clickDeals() {
		if(driver.findElement(deals_menu).isDisplayed()) {
			driver.findElement(deals_menu).sendKeys(Keys.ENTER);
		}
		dealsPage = new DealsPage(this.driver);
	}
	public boolean tilesMenu() {
		tiles_banner = checkTvMenu() && checkSignIn();
		return(tiles_banner);
	}
	public void getCookieConsent(){
		WebElement element = driver.findElement(iFrame);
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/button[2]")).click();
		driver.switchTo().parentFrame();
	}
	
	public void clickSignIn() {
		driver.findElement(signin_text).sendKeys(Keys.ENTER);
		signInPage = new SignInPage(this.driver); 
	}

}


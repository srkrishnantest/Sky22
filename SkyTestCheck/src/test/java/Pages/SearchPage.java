/*
 * This is the SearchPage  Page Object Model (POM).
 * This captures all the elements (required) and their associated methods
 * 
 * The class is instantiated from the PageNavigator class, and the constructor is created.
 * 
 * The methods available are to
 * 1. searchAvailConfirm() to confirm the page
 * 2. clickSearchIcon(), enterSearchString(), enterSerachButton(), checkSearchResults() are methods for the elements
 * 
 */

package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage{
	
	public WebDriver driver;
	private By searchIcon = By.xpath("//header/div[@id='masthead-navigation']/div[1]/div[1]/div[2]/button[1]/*[1]");
	private By searchTextBox = By.tagName("input");
	private By searchButton = By.xpath("//header/div[@id='masthead-navigation']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/*[1]");
	private By searchResultText = By.xpath("//a[contains(text(),'Sky Shop')]");
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchAvailConfirm() {
		if(driver.findElement(searchIcon).isDisplayed()){
		}
	}
	
	public void clickSearchIcon() {
		driver.findElement(searchIcon).click();
		if(driver.findElement(searchTextBox).isDisplayed()) {
		}		
	}
	public void enterSearchText(String searchTextValue) throws InterruptedException  {
		WebElement searchBox = driver.findElement(searchTextBox);
		searchBox.sendKeys(searchTextValue);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(searchTextBox)).click();
		}
	
	public void enterSearchButton()  {
		driver.findElement(searchButton).click();
			
	}
	public void checkSearchResults() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Sky Shop')]"));
		}
	
}
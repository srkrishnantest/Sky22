/*This is the Deals Page Page Object Model (POM).
 * 
 * This captures all the elements (required) and their associated methods
 * The class is instantiated from the PageNavigator class, and the constructor is created.
 * 
 * The methods available are to
 * 1. validateDelsPage() - this has a counter based on all menu available to confirm the page
 * 2. clickTVDeal(), clickBbTvDeal(), clickMobileDeal() - actions based on web elements to confirm menu
 *  
 */

package Pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DealsPage{

	public WebDriver driver = null;
	
	private By deals_tv_button = By.xpath("//body/main[@id='root']/div[1]/div[1]/div[1]/div[1]/button[1]");
	private By deals_tv_bb_button = By.xpath("//body/main[@id='root']/div[1]/div[1]/div[1]/div[1]/button[2]");
	private By deals_mobile_button = By.xpath("//body/main[@id='root']/div[1]/div[1]/div[1]/div[1]/button[3]");
	
	private By tv_deal1 = By.xpath("//p[contains(text(),'Ultimate TV')]");
	private By tv_deal2 = By.xpath("//p[contains(text(),'Sky TV & Sky Sports')]");
	
	private By bb_deal1 = By.xpath("//p[contains(text(),'Superfast TV Deal')]");
	private By bb_deal2 = By.xpath("//p[contains(text(),'Ultrafast TV Deal')]");
		
	private By mob_deal1 = By.xpath(" //p[contains(text(),'Bold Galaxy S21 5G')]");
	private By mob_deal2 = By.xpath("//p[contains(text(),'Stunning iPhone 11')]");
	
	public int tab_count=0;
	
	public DealsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickTvDeal() {
		driver.findElement(deals_tv_button).click();
		if (driver.findElement(deals_tv_button).isEnabled()) {
			Assert.assertTrue(driver.findElement(tv_deal1).isDisplayed());
			Assert.assertTrue(driver.findElement(tv_deal2).isDisplayed());
		}		
	}
	
	public void clickBbTvDeal() {
		driver.findElement(deals_tv_bb_button).click();
		if (driver.findElement(deals_tv_bb_button).isEnabled()) {
			Assert.assertTrue(driver.findElement(bb_deal1).isDisplayed());
			Assert.assertTrue(driver.findElement(bb_deal2).isDisplayed());
			}		
	}
	public void clickMobileDeal() {
		driver.findElement(deals_mobile_button).click();
		if (driver.findElement(deals_mobile_button).isEnabled()) {
			Assert.assertTrue(driver.findElement(mob_deal1).isDisplayed());
			Assert.assertTrue(driver.findElement(mob_deal2).isDisplayed());
		}		
	}
	
	public int validateDealsPage() {
		if (driver.findElement(deals_tv_button).isDisplayed()){
			tab_count++;
		}
		if (driver.findElement(deals_tv_bb_button).isDisplayed()){
			tab_count++;
		}
		if (driver.findElement(deals_mobile_button).isDisplayed()){
			tab_count++;
		}
		return(tab_count);
	}
}

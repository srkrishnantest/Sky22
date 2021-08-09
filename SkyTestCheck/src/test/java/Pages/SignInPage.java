/*
 * This is the Sign In Page,  Page Object Model (POM).
 * 
 * This captures all the elements (required) and their associated methods
 * The class is instantiated from the PageNavigator class, and the constructor is created.
 * 
 * The methods available are to
 * 1. signInPageConfirm() - confirms the authenticity of the Page
 * 2. enterUserName(), enterPassword(), enterSignInButton() are methods for the elements
 * 
 */

package Pages;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SignInPage{

	private By user_txt = By.id("username");
	private By pwd_txt = By.id("password");
	private By sign_button = By.id("signinButton");
	private By sign_lbl = By.xpath("//*[@id=\"signinform\"]/div/div[1]/label");
	private By sign_up_button = By.xpath("//*[@id=\"signuplink\"]");
	private boolean sign_page_conf = false;
	
	public WebDriver driver = null;
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean signInPageConfirm() {
		if(driver.findElement(sign_lbl).isDisplayed()) {
			if(driver.findElement(sign_up_button).isDisplayed()) {
				sign_page_conf = true;
			}
		}
		return(sign_page_conf);
	}
	public void enterUserName(String username) {
		driver.findElement(user_txt).sendKeys(username);
	}
	
	public void enterPasswor(String password) {
		driver.findElement(pwd_txt).sendKeys(password);
	}
	
	public void enterSignInButton() {
		driver.findElement(sign_button).click();
	}
}
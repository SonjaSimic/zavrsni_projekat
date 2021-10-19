package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage{
	
	public AuthPage(WebDriver driver, WebElement element, WebDriverWait wait, JavascriptExecutor js, Actions action) {
		super(driver, element, wait, js, action);
	}
	
	
	public WebElement getBtn() {
		 return this.driver.findElement(By.xpath("//li[@class = 'filled ']/a"));
	}
	public WebElement getMyAccount() {
		 return this.driver.findElement(By.xpath("//a[text() = 'My Account']"));
	}
	public WebElement getLogout() {
		 return this.driver.findElement(By.xpath("//a[text() = 'Logout']"));
	}
// metodu koja odjavljuje korisnika sa sistema
	
	public void logOut() {
		getBtn().click();
		this.getLogout().click();
		
	}
	
}

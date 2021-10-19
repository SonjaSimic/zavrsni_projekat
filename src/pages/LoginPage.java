package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, WebElement element, WebDriverWait wait, JavascriptExecutor js, Actions action) {
		super(driver, element, wait, js, action);
		// TODO Auto-generated constructor stub
	}

	public WebElement getLoginBtn() {
		return driver.findElement(By.xpath("//a[contains(text(), 'Login')]"));
	}

	public WebElement getUsername() {
		return driver.findElement(By.xpath("//*[@name='username']"));
	}

	public WebElement getPassword() {
		return driver.findElement(By.xpath("//*[@name='password']"));
	}

	public WebElement getRememberMe() {
		return driver.findElement(By.xpath("//*[@name='remember_me']"));
	}

	public WebElement getLogInBtnLoginpage() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

//	metodu koja prijavljuje korisnika na sistem - kao parametri se prosleđuju imejl i lozinka

	public void prijavljivanje(String username, String password) {
		getLoginBtn().click();
		getUsername().clear();
		getUsername().sendKeys(username);
		getPassword().clear();
		getPassword().sendKeys(password);
		getLogInBtnLoginpage().click();
	}

}

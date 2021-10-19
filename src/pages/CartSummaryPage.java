package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage {
	
	

	public CartSummaryPage(WebDriver driver, WebElement element, WebDriverWait wait, JavascriptExecutor js,
			Actions action) {
		super(driver, element, wait, js, action);
		// TODO Auto-generated constructor stub
	}

	public WebElement getClearAllBtn() {
		return driver.findElement(By.xpath("//a[@class = 'btn btn--third  btn--small no-radius']"));
	}
	
	//Metoda koja brise sve
	
	public void clearAllMethod() {
		this.getClearAllBtn().click();
	}

	

}

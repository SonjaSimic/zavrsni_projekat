package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, WebElement element, WebDriverWait wait, JavascriptExecutor js, Actions action) {
		super(driver, element, wait, js, action);
		// TODO Auto-generated constructor stub
	}
	public WebElement getAddToCartBtn() {
		return driver.findElement(By.xpath("//*[@class= 'btn btn--primary btn--large js-proceedtoAddInCart ']"));
	}
	public WebElement getQty() {
		return driver.findElement(By.xpath("//*[@name= 'product_qty']"));
	}
	public WebElement getFavoriteBtn() {
		return driver.findElement(By.xpath("//*[@class= 'svg-icn']"));
	}
	public void addMealToCart(String quantity) throws InterruptedException {
		this.getQty().click();
		this.getQty().clear();
		Thread.sleep(2000);
		this.getQty().sendKeys(quantity);
		this.getAddToCartBtn().click();
	}

}

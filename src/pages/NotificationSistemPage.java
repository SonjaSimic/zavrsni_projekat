package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage {

	public NotificationSistemPage(WebDriver driver, WebElement element, WebDriverWait wait, JavascriptExecutor js,
			Actions action) {
		super(driver, element, wait, js, action);
		// TODO Auto-generated constructor stub
	}

	public WebElement getMessage() {
		return driver.findElement(By.xpath(
				"//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}

//	metodu koja vraća poruku koja se nalazi u obaveštenju

	public String returnMessage() {
		return driver.findElement(By.xpath(
				"//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"))
				.getText();
	}

// Wait to dissapear message
	public void waitMessageToDissapear() {
		wait.until(ExpectedConditions.attributeContains(By.xpath("//*[contains(@class, 'system_message')]"), "style",
				"display: none;"));
	}
}

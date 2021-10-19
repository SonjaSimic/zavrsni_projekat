package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {

	protected WebDriver driver;
	protected WebElement element;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	protected Actions action;

	public BasicPage(WebDriver driver, WebElement element, WebDriverWait wait, JavascriptExecutor js, Actions action) {
		super();
		this.driver = driver;
		this.element = element;
		this.wait = wait;
		this.js = js;
		this.action = action;
	}

}

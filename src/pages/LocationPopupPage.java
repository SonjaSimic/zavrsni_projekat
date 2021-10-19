package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, WebElement element, WebDriverWait wait, JavascriptExecutor js,
			Actions action) {
		super(driver, element, wait, js, action);
	}

	public WebElement getLokacijaUHeaderu() {
		return driver.findElement(By.xpath("//div[@class = 'location-selector']/a"));
	}

	public WebElement getCloseBtn() {
		return driver.findElement(By.xpath("//a[@class = 'close-btn close-btn-white']"));
	}

	public WebElement getKeyword() {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}

	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));

	}

	public WebElement getLocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}

	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

//	metodu koja otvara iskačući dijalog
//	klikom na lokaciju iz hedera

	public void otvaraDijalog() {
		getLokacijaUHeaderu().click();
	}

//	metodu koja postavlja lokaciju - naziv lokacije (locationName) se prosleđuje kao parametar metode

	public void postavljaLokaciju(String locationName) throws InterruptedException {
		this.getKeyword().click();
		Thread.sleep(1000);
		String arg = this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value = arguments[1];", getLocationInput(), arg);
		js.executeScript("arguments[0].click();", getSubmit());
		Thread.sleep(2000);
	}

//	metodu koja zatvara iskačući dijalog, klikom na X dugme

	public void zatvaraDijalog() throws InterruptedException {
		this.getCloseBtn().click();
		Thread.sleep(2000);
	}
}

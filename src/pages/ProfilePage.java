package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	


	public ProfilePage(WebDriver driver, WebElement element, WebDriverWait wait, JavascriptExecutor js,
			Actions action) {
		super(driver, element, wait, js, action);
	}

	public WebElement getFirstName() {
		return driver.findElement(By.name("user_first_name"));
	}
	
	public WebElement getLastName() {
		return driver.findElement(By.name("user_last_name"));
	}

	public WebElement getEmail() {
		return driver.findElement(By.name("user_email"));
	}
	public WebElement getAddress() {
		return driver.findElement(By.name("user_address"));
	}
	public WebElement getPhone() {
		return driver.findElement(By.name("user_phone"));
	}
	
	public WebElement getZipCode() {
		scrollToElement(driver, driver.findElement(By.name("user_zip")));
		return driver.findElement(By.name("user_zip"));
	}
	
	public void selectCountry(String value) {
		Select categorySelect = new Select (driver.findElement(By.id("user_country_id")));
		categorySelect.selectByVisibleText(value);
	}	
	public void selectState(String value) {
		Select categorySelect = new Select (driver.findElement(By.id("user_state_id")));
		categorySelect.selectByVisibleText(value);
	}
	public void selectCity(String value) {
		Select categorySelect = new Select (driver.findElement(By.id("user_city")));
		categorySelect.selectByVisibleText(value);
	}
	
	public WebElement getSave1Btn() {
		return driver.findElement(By.xpath("//div[@class = 'col-lg-12 col-md-12 col-sm-12 col-lg-12 align--right']//input"));
	}
	
	public WebElement getCurrentPassword() {
		return driver.findElement(By.name("current_password"));
	}
	public WebElement getConfirmPassword() {
		return driver.findElement(By.name("conf_new_password"));
	}
	public WebElement getSave2Btn() {
		return driver.findElement(By.xpath("//form[@id = 'frm_fat_id_changePwdFrm']//input[@name = 'btn_submit']"));
	}
	
	public WebElement getImageUploadBtn() {
		return driver.findElement(By.className("upload"));
	}
	
	public WebElement getImgRemoveBtn() {
		return driver.findElement(By.className("remove"));
	}
	public WebElement getProfileImgArea() {
		return driver.findElement(By.xpath("//div[@id = 'profileInfo']//img"));
	}
	public WebElement getImgInput() {
		return driver.findElement(By.xpath("//*[@id = 'form-upload']/input"));
	}
	
//	da bi se na stranici pojavio element input type="file" potrebno je da se prvo izvrši 
//			JavaScript kod koji vrši akciju klik na Upload dugme 
	
//			Skripta: arguments[0].click();
	
//			metodu koja otprema profilnu sliku - kao parametar se prosleđuje putanja do fajla, 
//			tj. u ovom slučaju do slike

	
	public void uploadProfilePicture(String src) throws InterruptedException, AWTException, IOException {
		
		action.moveToElement(this.getProfileImgArea()).build().perform();
		Thread.sleep(5000);
//		
		this.getImageUploadBtn().click();
		Thread.sleep(1000);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		
		String imgPath = new File("img\\20190726_111817.jpg").getCanonicalPath();
		Thread.sleep(1000);

		getImgInput().sendKeys(imgPath);
		Thread.sleep(5000);

	}
	
	public void removePhoto() throws AWTException {
		action.moveToElement(this.getProfileImgArea()).build().perform();
	
//		js.executeScript("arguments[0].click();", getImgRemoveBtn());
		getImgRemoveBtn().click();
	}
	
	
	public void setUserInfo(String firstName,String lastName,String address,String phone, String zipCode, 
								String country, String state, String city) throws InterruptedException {
		getFirstName().clear();
		getFirstName().sendKeys(firstName);
		
		getLastName().clear();
		getLastName().sendKeys(lastName);
		
		getAddress().clear();
		getAddress().sendKeys(address);
		
		getPhone().clear();	
		getPhone().sendKeys(phone);
		
		getZipCode().clear();
		getZipCode().sendKeys(zipCode);
		
		selectCountry(country);
		Thread.sleep(2000);
		selectState(state);
		Thread.sleep(2000);

		selectCity(city);
		Thread.sleep(2000);

		getSave1Btn().click();
		Thread.sleep(2000);

	}
	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
}

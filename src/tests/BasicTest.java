package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;

public abstract class BasicTest {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	protected WebElement element;
	protected Actions action;
	protected SoftAssert sa;

	protected LocationPopupPage locationPopupPage;
	protected MealPage mealPage;
	protected CartSummaryPage cartSummaryPage;
	protected NotificationSistemPage notificationSistemPage;
	protected LoginPage loginPage;
	protected ProfilePage profilePage;
	protected AuthPage authPage;

//	URL's

	protected String baseUrl = "http://demo.yo-meals.com/";
	protected String loginPageUrl = "http://demo.yo-meals.com/guest-user/login-form";
	protected String profilePageUrl = "http://demo.yo-meals.com/member/profile";
	protected String mealPageUrl = "http://demo.yo-meals.com/meals";
	protected String mealChicken = "http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo";

// Credentials 

	protected String email = "customer@dummyid.com";
	protected String password = "12345678a";

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
		js = (JavascriptExecutor) driver;
		sa = new SoftAssert();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		locationPopupPage = new LocationPopupPage(driver, element, wait, js, action);
		mealPage = new MealPage(driver, element, wait, js, action);
		cartSummaryPage = new CartSummaryPage(driver, element, wait, js, action);
		notificationSistemPage = new NotificationSistemPage(driver, element, wait, js, action);
		loginPage = new LoginPage(driver, element, wait, js, action);
		profilePage = new ProfilePage(driver, element, wait, js, action);
		authPage = new AuthPage(driver, element, wait, js, action);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}

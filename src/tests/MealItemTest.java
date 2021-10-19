package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest{

//	@Test
//	public void addMealToCart() throws InterruptedException {
//		driver.get(mealChicken);
//		
//		locationPopupPage.zatvaraDijalog();
//		
//		mealPage.addMealToCart("2");
//		
////		verifikujte da je prikazana poruka sa tekstom
////		"The Following Errors Occurred:
////		Please Select Location"
//		
//		Assert.assertTrue(notificationSistemPage.returnMessage().contains("The Following Errors Occurred:"), "[ERROR]");
//
//		Assert.assertTrue(notificationSistemPage.returnMessage().contains("Please Select Location"), "[ERROR]");
//
////		sačekajte da obaveštenje nestane
//
//		notificationSistemPage.waitMessageToDissapear();
//		
////		postavite lokaciju na "City Center - Albany"
//		Thread.sleep(2000);
//		locationPopupPage.otvaraDijalog();
//		Thread.sleep(2000);
//		locationPopupPage.postavljaLokaciju("City Center - Albany");
//		Thread.sleep(2000);
//		mealPage.addMealToCart("2");
//		Thread.sleep(1000);
//		
////		verifikujte da je prikazana poruka sa tekstom "Meal Added To Cart"
//		
//		Assert.assertTrue(notificationSistemPage.returnMessage().contains("Meal Added To Cart"), "[ERROR] Meal is not Added To Cart");
//
//	}
	
	@Test 
	public void addMealToFavoriteTest() throws InterruptedException{
		
		driver.get(mealChicken);
		locationPopupPage.zatvaraDijalog();
		mealPage.addMealToFavorite();
		Thread.sleep(2000);
//		verifikujte da je prikazana poruka sa tekstom "Please login first!"
		
		Assert.assertTrue(notificationSistemPage.returnMessage().contains("Please login first!"), "[ERROR] Login first");
		
//		učitajte stranicu za prijavu
		
		driver.get(loginPageUrl);
		
		loginPage.prijavljivanje(email, password);
		
		driver.get(mealChicken);
		
		mealPage.addMealToFavorite();
		Thread.sleep(2000);
		
//		verifikujte da je prikazana poruka sa tekstom "Product has been added to your favorites."

		Assert.assertTrue(notificationSistemPage.returnMessage().contains("Product has been added to your favorites."), "[ERROR]");

	}
}

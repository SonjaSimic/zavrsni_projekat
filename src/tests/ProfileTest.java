package tests;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	@Test
	public void editProfileTest() throws InterruptedException {

		driver.get(loginPageUrl);
		locationPopupPage.zatvaraDijalog();
		Thread.sleep(2000);
		loginPage.prijavljivanje(email, password);
		Assert.assertTrue(notificationSistemPage.returnMessage().contains("Login Successfull"),
				"[ERROR] Login is not Successfull");
		Thread.sleep(2000);

		driver.get(profilePageUrl);
		Thread.sleep(3000);
		profilePage.setUserInfo("Soka", "Sokic", "Knicanska", "1234345567788", "034", "United Kingdom", "England",
				"Bath");

//		verifikujte da je prikazana poruka sa tekstom "Setup Successful"

		Assert.assertTrue(notificationSistemPage.returnMessage().contains("Setup Successful"),
				"[ERROR] Login is not Successfull");
		Thread.sleep(1000);

		authPage.logOut();

//		verifikujte da je prikazana poruka sa tekstom "Logout Successfull!"

		Assert.assertTrue(notificationSistemPage.returnMessage().contains("Logout Successfull!"),
				"[ERROR] Login is not Successfull");

	}

	@Test
	public void changeProfileImageTest() throws InterruptedException, IOException, AWTException {
		driver.get(loginPageUrl);
		locationPopupPage.zatvaraDijalog();
		Thread.sleep(1000);

		loginPage.prijavljivanje(email, password);
		Thread.sleep(1000);

		// verifikujte da je prikazana poruka sa tekstom "Login Successfull"

		Assert.assertTrue(notificationSistemPage.returnMessage().contains("Login Successfull"),
				"[ERROR] Login is not Successfull");

		driver.get(profilePageUrl);

//		otpremite profilnu sliku

		profilePage.uploadProfilePicture("img\\20190726_111817.jpg");

//		verifikujte da je prikazana poruka sa tekstom "Profile Image Uploaded Successfully"

		Assert.assertTrue(notificationSistemPage.returnMessage().contains("Profile Image Uploaded Successfully"),
				"[ERROR] Profile Image is not Uploaded  Successfull");

		notificationSistemPage.waitMessageToDissapear();

		profilePage.removePhoto();
		Thread.sleep(2000);

//		verifikujte da je prikazana poruka sa tekstom "Profile Image Deleted Successfully"

		Assert.assertTrue(notificationSistemPage.returnMessage().contains("Profile Image Deleted Successfully"),
				"[ERROR] Profile Image is not Deleted Successfully");

		notificationSistemPage.waitMessageToDissapear();

		authPage.logOut();

//		verifikujte da je prikazana poruka sa tekstom "Logout Successfull!"

		Assert.assertTrue(notificationSistemPage.returnMessage().contains("Logout Successfull!"),
				"[ERROR] Logout is not Successfully");

	}

}

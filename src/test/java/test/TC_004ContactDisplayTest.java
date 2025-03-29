package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.ContactListPage;
import page.ContactPage;
import page.LoginPage;

public class TC_004ContactDisplayTest extends ProjectSpecificationMethod {

	@Test
	public void testContactDetailsDisplayedCorrectly() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail("siva77@guvi.com");
		loginPage.enterPassword("123456789");
		loginPage.clickLoginButton();

		ContactPage contactPage = new ContactPage(driver);
		contactPage.clickAddContact();
		contactPage.enterContactDetails("John", "Doe", "john@example.com", "9876543210", "1990-01-01", "123 Main St",
				"", "Coimbatore", "USA", "539823", "Test Notes");
		contactPage.clickSubmit();

		ContactListPage contactListPage = new ContactListPage(driver);
		Assert.assertTrue(contactListPage.isContactDisplayed("John Doe", "john@example.com", "9876543210"),

				"Contact was not displayed correctly after adding!");
	}

	@Test
	public void testContactsAlphabeticalOrder() {
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterEmail("siva77@guvi.com");
	    loginPage.enterPassword("123456789");
	    loginPage.clickLoginButton();

	    ContactListPage contactListPage = new ContactListPage(driver);

	    // Wait for contacts to be fully loaded (optional)
	 //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='last-name']")));

	    // Get actual last names
	    List<String> actualLastNames = contactListPage.getLastNames();
	    List<String> expectedLastNames = new ArrayList<>(actualLastNames);

	    // Sort expected list in proper case-insensitive order
	    expectedLastNames.sort(String::compareToIgnoreCase);

	    System.out.println("Actual Order: " + actualLastNames);
	    System.out.println("Expected Order: " + expectedLastNames);

	    // Assert that contacts are in the correct alphabetical order
	    Assert.assertEquals(actualLastNames, expectedLastNames, "Contacts are not in alphabetical order!");
	   
	}}
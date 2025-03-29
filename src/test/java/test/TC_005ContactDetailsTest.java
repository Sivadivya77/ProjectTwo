package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.ContactDetailsPage;
import page.ContactPage;
import page.LoginPage;

public class TC_005ContactDetailsTest extends ProjectSpecificationMethod {
	@BeforeTest
	public void setup() {
		sheetname = "EditContact";
	}
	@Test
	public void testContactRedirectsToDetailsPage() {
		// Login first
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail("siva77@guvi.com");
		loginPage.enterPassword("123456789");
		loginPage.clickLoginButton();
		ContactPage contactPage = new ContactPage(driver);
		// Click on the first contact
		contactPage.clickAddContact();

	}

	@Test(dataProvider = "readdata")
	public void testEditContactDetails(String firstName, String lastName, String email, String phone, String birthday,
			String city, String state, String postalCode, String ExpectedResult) throws InterruptedException {
		// Login
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail("siva77@guvi.com");
		loginPage.enterPassword("123456789");
		loginPage.clickLoginButton();

		// Navigate to Contact Page
		ContactPage contactPage = new ContactPage(driver);
		contactPage.ClickContact();

		// Edit Contact Details
		ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
		contactDetailsPage.ClickEdit();
		contactDetailsPage.editContactDetails(firstName, lastName, email, phone, birthday, city, state, postalCode,
				ExpectedResult);
		contactDetailsPage.clickSubmitButton();
		Thread.sleep(2000);
		
		System.out.println("Current URL after signup: " + driver.getCurrentUrl());

		if (ExpectedResult.contains("User should be added successfully")) {
			String expectedUrl = "https://thinking-tester-contact-list.herokuapp.com/contactDetails";

			Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Edit failed!");
		} else {
			Assert.assertTrue(contactDetailsPage.getErrorMessage().contains(ExpectedResult),
					"Error message mismatch");
		}

		// Verify Update Success
		System.out.println("Contact details updated successfully!");
		// contactDetailsPage.ClickReturn();
	}

	@Test
	public void testDeleteContactDetails() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail("siva77@guvi.com");
		loginPage.enterPassword("123456789");
		loginPage.clickLoginButton();

		
		loginPage.getTableRowCount();
		ContactPage contactPage = new ContactPage(driver);
		// Click on the first contact
		contactPage.ClickContact();
		ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
		
		contactDetailsPage.deletecontact();
		
		loginPage.getTableRowCount();
		
		// Click on the first contact
		contactPage.ClickContact();
		
		contactDetailsPage.ClickEdit();
		contactDetailsPage.editContactDetails("John", "Doe", "", "1234567890", "2015-09-03", "Chennai", "UK", "567098",
				"Uk");

		

		System.out.println(" Contact details updated successfully!");
		contactDetailsPage.ClickReturn();

	}
}

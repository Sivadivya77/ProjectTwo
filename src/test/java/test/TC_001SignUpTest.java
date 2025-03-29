package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.HomePage;
import page.SignupPage;

public class TC_001SignUpTest extends ProjectSpecificationMethod {
	@BeforeTest
	public void setup() {
		sheetname = "Addusers";
	}

	@Test
	public void testSignupFunctionality() {
		HomePage homepage = new HomePage(driver);

		// Verify Signup button visibility
		Assert.assertTrue(homepage.isSignupButtonVisible(), "Signup button is not visible!");

		// Click on the Signup button
		homepage.clickSignupButton();

		// Verify redirection to the Add User Page
		Assert.assertTrue(homepage.isAddUserPageDisplayed(), "Redirection to Add User Page failed!");
	}

	@Test(dataProvider = "readdata")
	public void testSignupUsers(String firstname, String lastname, String email, String password, String ExpectedResult)
			throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		homepage.clickSignupButton();
		SignupPage signuppage = new SignupPage(driver);
		signuppage.enterSignupdetails(firstname, lastname, email, password);
		signuppage.Clicksumbit();
		Thread.sleep(2000);
		System.out.println("Current URL after signup: " + driver.getCurrentUrl());

		if (ExpectedResult.contains("User should be added successfully")) {
			String expectedUrl = "https://thinking-tester-contact-list.herokuapp.com/addUser";
			
			Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Signup failed!");
		} else {
			Assert.assertTrue(signuppage.getErrorMessage().contains(ExpectedResult.split(": ")[1]),
					"Error message mismatch!");
		}
	}

}

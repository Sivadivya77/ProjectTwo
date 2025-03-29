package test;

import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.LoginPage;

public class TC_002LoginTest extends ProjectSpecificationMethod  {
	
	@BeforeTest
	public void setup() {
	sheetname="LoginData";}
	@Test(priority = 1)
    public void testLoginButtonVisibility() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginButtonVisible(), "Login button is not visible!");
    }

    @Test(dataProvider ="readdata")
    public void testValidLogin(String email,String password,String ExpectedResult) throws TimeoutException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        if (ExpectedResult.equalsIgnoreCase("valid")) {
            System.out.println("Login Passed: " + loginPage.isContactListDisplayed());
            Assert.assertTrue(loginPage.isContactListDisplayed(), "Login failed! Contact List not displayed.");
        } else {
            String expectedErrorMessage = "Incorrect username or password";
            String actualErrorMessage = loginPage.getErrorMessageText();
            System.out.println("Actual Error Message: " + actualErrorMessage);
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch!");
        }
    }


  @Test(priority = 3)
    public void testInvalidLogin() throws TimeoutException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("invaliduser@example.com");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLoginButton();
        // Expected error message
        String expectedErrorMessage = "Incorrect username or password";

        // Get actual error message
        String actualErrorMessage =loginPage.getErrorMessageText();

        // Print debug information
        System.out.println("Actual Error Message:" + actualErrorMessage);

        // Assert the error message is present
    //  Assert.assertFalse(actualErrorMessage.isEmpty(), "Error message was not displayed!");
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch!");
    }
}


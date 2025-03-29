package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.ContactPage;
import page.LoginPage;
import utils.Utilie;

public class TC_003ContactPageTest extends ProjectSpecificationMethod{
	ContactPage contactPage;
	
	@BeforeTest
public void setup() {
	sheetname="contact";
}
      
	                     // In this page i use both Data driven method and Manual adding the data
	
	 
 /*   @BeforeMethod
    public void setupTest() {
        contactPage = new ContactPage(driver);
    }
	//  Test Adding Contact with All Mandatory Fields
    @Test(priority = 1)
    public void testAddContactWithMandatoryFields() {
    //	public void testValidLogin() {
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.enterEmail("siva77@guvi.com");
	        loginPage.enterPassword("123456789");
	        loginPage.clickLoginButton();
        contactPage.clickAddContact();
        contactPage.enterContactDetails("John", "Doe", "john@example.com", "1234567890", "1990-01-01", "123 Main St", "", "New York", "NY", "10001", "USA");
        contactPage.clickSubmit();
        System.out.println("Message:"+contactPage.isContactAdded());
        Assert.assertTrue(contactPage.isContactAdded(), "Contact was not added successfully!");
    }

   //  Test Adding Contact Without Some Optional Fields
    @Test(priority = 2)
    public void testAddContactWithoutOptionalFields() {
    	LoginPage loginPage = new LoginPage(driver);
    	 loginPage.enterEmail("siva77@guvi.com");
	        loginPage.enterPassword("123456789");
	        loginPage.clickLoginButton();
        contactPage.clickAddContact();
        contactPage.enterContactDetails("Alice", "", "alice@example.com", "9876543210", "02/15/1985", "", "", "Los Angeles", "CA", "90001", "USA");
        contactPage.clickSubmit();
        System.out.println(contactPage.getErrorMessage());
        Assert.assertEquals(contactPage.getErrorMessage(),"Contact validation failed: lastName: Path `lastName` is required., birthdate: Birthdate is invalid");
    }  

    //  Test Adding Contact with Duplicate Details
    @Test(priority = 3)
    public void testAddDuplicateContact() {
    	LoginPage loginPage = new LoginPage(driver);
    	 loginPage.enterEmail("siva77@guvi.com");
	        loginPage.enterPassword("123456789");
	        loginPage.clickLoginButton();
        contactPage.clickAddContact();
        contactPage.enterContactDetails("John", "Doe", "john@example.com", "1234567890", "1990-01-01", "123 Main St", "", "New York", "NY", "10001", "USA");
        contactPage.clickSubmit();
      //  System.out.println(contactPage.getErrorMessage());
       // Assert.assertEquals(contactPage.getErrorMessage(), "Contact validation failed: email: Email is invalid", "Duplicate contact validation failed!");
    } 
    //  Test Restriction on Invalid Birthdate
    @Test(priority = 4)
    public void testInvalidBirthdate() {
    	LoginPage loginPage = new LoginPage(driver);
    	 loginPage.enterEmail("siva77@guvi.com");
	        loginPage.enterPassword("123456789");
	        loginPage.clickLoginButton();
        contactPage.clickAddContact();
        contactPage.enterContactDetails("Bob", "Smith", "bob@example.com", "1112223333", "99/99/9999", "456 Elm St", "", "Chicago", "IL", "60601", "USA");
        contactPage.clickSubmit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOf(contactPage.getErrorMessage()));
        Assert.assertEquals(contactPage.getErrorMessage(), "Contact validation failed: birthdate: Birthdate is invalid", "Invalid birthdate validation failed!");
    }
}
*/
	
    @Test(dataProvider ="readdata")
    public void testAddContact(String firstName, String lastName, String email, String phone, String birthdate, 
                               String address, String city, String state, String pincode, String country) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("siva77@guvi.com");
        loginPage.enterPassword("123456789");
        loginPage.clickLoginButton();
contactPage=new ContactPage(driver);
        contactPage.clickAddContact();
        contactPage.enterContactDetails(firstName, lastName, email, phone, birthdate, address, "", city, state, pincode, country);
        contactPage.clickSubmit();

      //  Assert.assertTrue(contactPage.isContactAdded(), "Contact was not added successfully!");
    }
}


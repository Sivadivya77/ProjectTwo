package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class HomePage extends ProjectSpecificationMethod {

	@FindBy(id = "signup")
	private WebElement signupButton;

	@FindBy(id = "add-user") 
	private WebElement addUserPage;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Check if Sign Up button is visible
	public boolean isSignupButtonVisible() {
		return signupButton.isDisplayed();
	}

	// Check if Sign Up button is clickable
	public void clickSignupButton() {
		signupButton.click();
	}

	// Verify redirection to the Add User Page
	public boolean isAddUserPageDisplayed() {
		return addUserPage.isDisplayed();
	}

}

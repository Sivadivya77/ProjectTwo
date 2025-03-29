package page;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class SignupPage extends ProjectSpecificationMethod {

	@FindBy(id = "firstName")
	private WebElement Firstnamefield;

	@FindBy(id = "lastName")
	private WebElement lastnamefield;

	@FindBy(id = "email")
	private WebElement Emailfield;

	@FindBy(id = "password")
	private WebElement Passwordfield;

	@FindBy(id = "submit")
	private WebElement Sumbit;

	@FindBy(xpath = "//span[@id='error']")
	private WebElement errorElement;

	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterSignupdetails(String firstname, String lastname, String email, String password) {
		Firstnamefield.sendKeys(firstname);
		lastnamefield.sendKeys(lastname);
		Emailfield.sendKeys(email);
		Passwordfield.sendKeys(password);
	}

	public void Clicksumbit() {
		Sumbit.click();
	}

	public String getErrorMessage() {
		try {
			System.out.println("Displayed Error Message: " + errorElement.getText());

			WebElement errorElement = driver.findElement(By.id("error")); // Adjust the selector as needed
			return errorElement.getText();
		} catch (NoSuchElementException e) {
			return ""; // Return empty string if no error message is found
		}
	}

}

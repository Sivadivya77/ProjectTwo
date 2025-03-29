package page;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class ContactDetailsPage extends ProjectSpecificationMethod {

	WebDriverWait wait;

	// Contact Detail Fields
	@FindBy(id = "firstName")
	private WebElement firstNameField;

	@FindBy(id = "lastName")
	private WebElement lastNameField;

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "phone")
	private WebElement phoneField;

	@FindBy(id = "birthdate")
	private WebElement birthdayField;

	@FindBy(id = "city")
	private WebElement cityField;

	@FindBy(id = "stateProvince")
	private WebElement stateProvinceField;

	@FindBy(id = "postalCode")
	private WebElement postalCodeField;

	@FindBy(id = "submit")
	private WebElement saveButton;

	@FindBy(css = ".success-message") 
	private WebElement successMessage;

	@FindBy(id = "edit-contact")
	private WebElement ClickEditButton;

	@FindBy(id = "return")
	private WebElement ClickReturnButton;

	@FindBy(id = "delete")
	private WebElement ClickDeleteButton;
	
	@FindBy(id = "submit")
	private WebElement ClickSubmit;

	@FindBy(id = "error")
	private WebElement errorElement;

	@FindBy(xpath = "(//tbody)[@class='contactTable-Body']") //  actual contact list
	
																
	List<WebElement> contactRows;

	public ContactDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// Edit Contact Details
	public void editContactDetails(String firstName, String lastName, String email, String phone, String birthday,
			String city, String stateProvince, String postalCode, String ExpectedResult) {
		wait.until(ExpectedConditions.visibilityOf(firstNameField)).clear();
		firstNameField.sendKeys(firstName);

		wait.until(ExpectedConditions.visibilityOf(lastNameField)).clear();
		lastNameField.sendKeys(lastName);

		wait.until(ExpectedConditions.visibilityOf(emailField)).clear();
		emailField.sendKeys(email);

		wait.until(ExpectedConditions.visibilityOf(phoneField)).clear();
		phoneField.sendKeys(phone);

		wait.until(ExpectedConditions.visibilityOf(birthdayField)).clear();
		birthdayField.sendKeys(birthday);

		wait.until(ExpectedConditions.visibilityOf(cityField)).clear();
		cityField.sendKeys(city);

		wait.until(ExpectedConditions.visibilityOf(stateProvinceField)).clear();
		stateProvinceField.sendKeys(stateProvince);

		wait.until(ExpectedConditions.visibilityOf(postalCodeField)).clear();
		postalCodeField.sendKeys(postalCode);

		saveButton.click();
	}

	public void ClickEdit() {
		ClickEditButton.click();
	}

	public String getErrorMessage() {
		try {
			System.out.println("Displayed Error Message: "+ errorElement.getText());

			WebElement errorElement = driver.findElement(By.id("error")); 
			return errorElement.getText();
		} catch (NoSuchElementException e) {
			return ""; // Return empty string if no error message is found
		}
	}
public void clickSubmitButton() {
	ClickSubmit.click();
	
}
	public void ClickReturn() {
		ClickReturnButton.click();
	}

	public void deletecontact() {
		ClickDeleteButton.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}

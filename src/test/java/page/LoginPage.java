package page;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class LoginPage extends ProjectSpecificationMethod {

	@FindBy(id = "email") // locator based on actual application
	private WebElement emailInput;

	@FindBy(id = "password") // locator based on actual application
	private WebElement passwordInput;

	@FindBy(id = "submit") // locator based on actual application
	private WebElement loginButton;

	@FindBy(xpath = "//span[@id='error']") // locator if an error message appears on invalid login
	private WebElement errorMessage;

	@FindBy(xpath = "//h1[contains(text(),'Contact List')]") // locator to verify successful login
	private WebElement contactListPage;

	@FindBy(xpath = "//p[text()='Log In:']")
	private WebElement loginText;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Check if login button is visible
	public boolean isLoginButtonVisible() {
		return loginButton.isDisplayed();
	}

	// Enter email
	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	// Enter password
	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	// Click Login button
	public void clickLoginButton() {
		loginButton.click();
	}

	// Verify successful login
	public boolean isContactListDisplayed() {
		return contactListPage.isDisplayed();
	}

	// Verify error message for invalid login
	public String getErrorMessageText() throws TimeoutException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='error']")));
		return errorMessage.getText();
	}

	public void getTableRowCount() {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr")));
		List<WebElement> rows = driver.findElements(By.xpath("//table/tr"));
		System.out.println("Total rows: " + rows.size());
	}

	public String islogintextvisibil() {
		return loginText.getText();

	}

	public void enterValidUnvalidsign(String email, String password) {
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
	}

}

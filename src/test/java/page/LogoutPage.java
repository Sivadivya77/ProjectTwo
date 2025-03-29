package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.ProjectSpecificationMethod;

public class LogoutPage extends ProjectSpecificationMethod {
	WebDriverWait wait;
	@FindBy(xpath = "//button[text()='Logout']")
	private WebElement ClickLogoutButton;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void clickLogout() {
		ClickLogoutButton.click();
		// wait.until(ExpectedConditions.elementToBeClickable(ClickLogoutButton)).click();
	}

}

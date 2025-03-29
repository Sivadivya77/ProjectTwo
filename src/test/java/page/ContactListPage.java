package page;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class ContactListPage extends ProjectSpecificationMethod {

	WebDriver driver;

	@FindBy(css = ".contactTableBodyRow")
	private List<WebElement> contactRows;

	@FindBy(xpath = "//td[2]") // name is in the 2nd column
	private List<WebElement> contactName;

	@FindBy(xpath = "//td[4]") // email is in the 4th column
	private List<WebElement> contactEmails;

	@FindBy(xpath = "//td[5]") // phone is in the 5th column
	private List<WebElement> contactPhones;

	@FindBy(xpath = "//tr[@class='contactTableBodyRow']/td[2]")
	private List<WebElement> contactNames;

	public ContactListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isContactDisplayed(String name, String email, String phone) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".contactTableBodyRow")));
		for (int i = 0; i < contactRows.size(); i++) {
			if (contactName.get(i).getText().equals(name) && contactEmails.get(i).getText().equals(email)
					&& contactPhones.get(i).getText().equals(phone)) {
				return true; // Contact found
			}
		}
		return false; // Contact not found
	}

	public List<String> getLastNames() {
		return contactNames.stream().map(element -> {
			String fullName = element.getText().trim(); // Trim to remove spaces
			return fullName.substring(fullName.lastIndexOf(" ") + 1); // Extract last name
		}).collect(Collectors.toList());
	}
}

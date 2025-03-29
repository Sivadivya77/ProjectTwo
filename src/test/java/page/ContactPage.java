package page;

import java.time.Duration;
import java.util.ArrayList;
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

public class ContactPage extends ProjectSpecificationMethod {
	
	WebDriverWait wait;
	
	 @FindBy(id = "add-contact") private WebElement addContactButton;
	    @FindBy(id = "firstName") private WebElement firstNameField;
	    @FindBy(id = "lastName") private WebElement lastNameField;
	    @FindBy(id = "email") private WebElement emailField;
	    @FindBy(id = "phone") private WebElement phoneField;
	    @FindBy(id = "birthdate") private WebElement birthdateField;
	    @FindBy(id = "street1") private WebElement street1Field;
	    @FindBy(id = "street2") private WebElement street2Field;
	    @FindBy(id = "city") private WebElement cityField;
	    @FindBy(id = "stateProvince") private WebElement stateField;
	    @FindBy(id = "postalCode") private WebElement postalCodeField;
	    @FindBy(id = "country") private WebElement countryField;
	    @FindBy(id = "submit") private WebElement submitButton;
	    @FindBy(id = "error") private WebElement errorMessage;
	    @FindBy(css = ".contactTableBodyRow td:nth-child(2)") private WebElement ClickFristContact;
	    @FindBy(css = ".contact-item") private WebElement contactList;

	    // Constructor
	    public ContactPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }

	    // Click "Add Contact" button
	    public void clickAddContact() {
	        addContactButton.click();
	    }

	    // Fill contact details
	    public void enterContactDetails(String firstName, String lastName, String email, String phone, String birthdate, String street1, String street2, String city, String state, String postalCode, String country) {
			firstNameField.sendKeys(firstName);
	        lastNameField.sendKeys(lastName);
	        emailField.sendKeys(email);
	        phoneField.sendKeys(phone);
	        birthdateField.sendKeys(birthdate);
	        street1Field.sendKeys(street1);
	        street2Field.sendKeys(street2);
	        cityField.sendKeys(city);
	        stateField.sendKeys(state);
	        postalCodeField.sendKeys(postalCode);
	        countryField.sendKeys(country);
	        submitButton.click();
	        
	    
	  //  WebElement error = wait.until(ExpectedConditions.visibilityOf(errorMessage));
		//System.out.println("Error message displayed: " + error.getText());
	}

	    // Click Submit
	    public void clickSubmit() {
	        submitButton.click();
	    }

	    // Get Error Message
	    public String getErrorMessage() {
	        wait.until(ExpectedConditions.visibilityOf(errorMessage));
	        return errorMessage.getText().trim();
	    }
         
	  
	   public boolean isContactAdded() {
	        try {
	            WebElement contactItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("myTable")));
	            return contactItem.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("Timeout: Contact was not added within the expected time");
	            return false;
	        }
	    }
	   public void ClickContact() {
		   ClickFristContact.click();
		  
	   }public List<List<String>> getTableData() {
		    List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr")); 
		    List<List<String>> tableData = new ArrayList<>();

		    for (WebElement row : rows) {
		        List<WebElement> cells = row.findElements(By.tagName("td"));
		        List<String> rowData = cells.stream()
		                .map(cell -> cell.getText().trim())
		                .collect(Collectors.toList());
		        tableData.add(rowData);
		    }
		    return tableData;
		}
}
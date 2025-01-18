package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage{

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id="cancel")
    WebElement btnCancel;
    public void cancelCheckout(){
        btnCancel.click();
    }

    @FindBy(id = "continue")
    WebElement btnContinue;
    public void continueCheckout(){
        waitForElementToVisible(btnContinue);
        btnContinue.click();
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameField;
    @FindBy(id="last-name")
    WebElement lastNameField;
    @FindBy(id = "postal-code")
    WebElement postalCodeField;

    public void checkout(String firstName, String lastName, String postalCode){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
        continueCheckout();
    }
}

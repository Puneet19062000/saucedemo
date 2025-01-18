package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentConfirmationPage extends BasePage{

    WebDriver driver;

    public PaymentConfirmationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="finish")
    WebElement btnFinish;

    public void finishPayment(){
        waitForElementToVisible(btnFinish);
        btnFinish.click();
    }

    public void paymentSubmit(){
        finishPayment();
    }
}

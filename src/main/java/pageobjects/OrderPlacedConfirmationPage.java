package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPlacedConfirmationPage extends BasePage{

    WebDriver driver;

    public OrderPlacedConfirmationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    WebElement confirmationMsg;
    @FindBy(id="back-to-products")
    WebElement btnBackHome;

    public String orderSuccess(){
        waitForElementToVisible(confirmationMsg);
        return  confirmationMsg.getText();
    }



}

package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

    WebDriver driver;

    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="checkout")
    WebElement btnCheckout;

    @FindBy(id="continue-shopping")
    WebElement btnContShopping;

    @FindBy(xpath = "//button[text()='Remove']")
    WebElement btnRemove;

    public void checkout(){
        waitForElementToVisible(btnCheckout);
        btnCheckout.click();
    }

    public void continueShopping(){
        waitForElementToVisible(btnContShopping);
        btnContShopping.click();
    }

    public void removeProduct(){
        waitForElementToVisible(btnRemove);
        btnRemove.click();
    }

    @FindBy(css=".inventory_item_name")
    WebElement productNameHeading;
    public String verifyAddedProduct(){
        goToCartPage();
       String productNameVerify = productNameHeading.getText();
       checkout();
       return productNameVerify;
    }

}

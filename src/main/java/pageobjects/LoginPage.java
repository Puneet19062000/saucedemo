package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void launchApplication(){
        driver.get("https://www.saucedemo.com");
    }

    @FindBy(id="user-name")
    WebElement usernameField;
    @FindBy(id="password")
    WebElement passwordField;
    @FindBy(id="login-button")
    WebElement btnLogin;

    public void loginApplication(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        btnLogin.click();
    }

    @FindBy(css=".error-message-container h3")
    WebElement errorMessage;
    public String getErrorMessage(){
        waitForElementToVisible(errorMessage);
        return errorMessage.getText();
    }
}

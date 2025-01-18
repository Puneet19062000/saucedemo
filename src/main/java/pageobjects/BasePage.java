package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="shopping_cart_container")
    WebElement btnCart;

    public void goToCartPage(){
        btnCart.click();
    }

    public void waitForElementToVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @FindBy(id="react-burger-menu-btn")
    WebElement btnHamburgerMenu;
    public void clickHamburgerMenu(){
        waitForElementToVisible(btnHamburgerMenu);
        btnHamburgerMenu.click();
    }

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement btnLogout;
    public void logout(){
        clickHamburgerMenu();
        waitForElementToVisible(btnLogout);
        btnLogout.click();
    }


}

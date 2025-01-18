package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends BasePage{

    WebDriver driver;
    WebElement matchedProduct;

    public ProductsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inventory_item_description")
    List<WebElement> productsList;

    public void findProduct(String productName){
        for(WebElement product : productsList){
            if(product.findElement(By.cssSelector(".inventory_item_label a div")).getText().equals(productName)){
                matchedProduct = product;
            }
        }
    }


    public String removeBtnVerify(){
       return matchedProduct.findElement(By.cssSelector(".pricebar button")).getText();
    }

    public void addToCart(){

        matchedProduct.findElement(By.cssSelector(".pricebar button")).click();
    }
}

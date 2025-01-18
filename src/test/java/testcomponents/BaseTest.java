package testcomponents;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobjects.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BaseTest {

    WebDriver driver;
    public LoginPage loginPage;
    public ProductsPage productsPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public PaymentConfirmationPage paymentConfirmationPage;
    public OrderPlacedConfirmationPage orderPlacedConfirmationPage;

    @BeforeClass(alwaysRun = true)
    public void initialiseDriver(){
       driver = BrowserFactory.getWebDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentConfirmationPage = new PaymentConfirmationPage(driver);
        orderPlacedConfirmationPage = new OrderPlacedConfirmationPage(driver);

    }

    public String getScreenShot(String testcaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
        FileUtils.copyFile(source, dest);
        return System.getProperty("user.dir")+"//reports//"+ testcaseName +".png";
    }

    public Object[][] getJsonDataToMap(Method method) throws IOException {
        FileReader fileReader = new FileReader(System.getProperty("user.dir")+"//src//test//java//data//data.json");
        JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
        HashMap<String, String> dataset = new HashMap<>();
        JsonObject jsonObject1 = jsonObject.getAsJsonObject(method.getName());
        Iterator<String> keys = jsonObject1.keySet().iterator();
        while (keys.hasNext()){
            String key = keys.next();
            dataset.put(key, jsonObject1.get(key).getAsString());
        }
        Object obj[][] = new Object[1][1];
        obj[0][0] = dataset;
        return obj;

    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}

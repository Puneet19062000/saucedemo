package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcomponents.BaseTest;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class RegressionTest extends BaseTest{
    @Test(priority = 0, dataProvider = "getData")
    public void login(HashMap<String, String> dataset){
        loginPage.launchApplication();
        loginPage.loginApplication(dataset.get("username"),dataset.get("password"));
    }

    @Test(priority = 1,dataProvider = "getData")
    public void addToCart(HashMap<String, String> dataset){
        productsPage.findProduct(dataset.get("productName"));
        productsPage.addToCart();
        Assert.assertEquals("Remove", productsPage.removeBtnVerify());
    }

    @Test(priority = 2, dataProvider = "getData")
    public void verifyProduct(HashMap<String, String> dataset){
       Assert.assertEquals(dataset.get("productName"), cartPage.verifyAddedProduct());
    }

    @Test(priority = 3, dataProvider = "getData")
    public void checkoutProduct(HashMap<String, String> dataset){
        checkoutPage.checkout(dataset.get("firstName"), dataset.get("lastName"), dataset.get("postalCode"));
    }

    @Test(priority = 4)
    public void paymentConfirmation(){
        paymentConfirmationPage.paymentSubmit();
    }

    @Test(priority = 5, dataProvider = "getData")
    public void orderSuccessTest(HashMap<String, String> dataset){
       Assert.assertEquals(dataset.get("message"), orderPlacedConfirmationPage.orderSuccess());
    }



    @DataProvider
    public Object[][] getData(Method method) throws IOException {
        return getJsonDataToMap(method);
    }
}

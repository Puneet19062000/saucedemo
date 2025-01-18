package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcomponents.BaseTest;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ErrorValidationTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void loginErrorValidation(HashMap<String,String> dataset) throws IOException{
        loginPage.launchApplication();
        loginPage.loginApplication(dataset.get("username"),dataset.get("password"));
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMessage());

    }

    @DataProvider
    public Object[][] getData(Method method) throws IOException {
        return getJsonDataToMap(method);
    }
}

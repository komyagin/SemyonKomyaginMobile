package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;
import utils.Properties;

public class nativeMobileTests extends BaseTest {


    @Test(groups = {"native"}, description = "Register new account, log in and check you are logged in")
    public void registerLogInTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPageObject().getWebElement("registerButton").click();
        getPageObject().getWebElement("registrationEmail").sendKeys(Properties.getProperty("email"));
        getPageObject().getWebElement("registrationUserName").sendKeys(Properties.getProperty("user"));
        getPageObject().getWebElement("registrationPassword").sendKeys(Properties.getProperty("password"));
        getPageObject().getWebElement("registrationConfirmPassword").sendKeys(Properties.getProperty("password"));
        getPageObject().getWebElement("registerNewAccountButton").click();
        getPageObject().getWebElement("loginEmail").sendKeys(Properties.getProperty("email"));
        getPageObject().getWebElement("loginPassword").sendKeys(Properties.getProperty("password"));
        getPageObject().getWebElement("signInBtn").click();
        String pageText = getPageObject().getWebElement("pageText").getText();

        Assert.assertEquals(pageText, "BudgetActivity", "Registered, Logged In, and on expected Page");
    }

}

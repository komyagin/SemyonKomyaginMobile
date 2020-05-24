package scenarios;

import org.testng.annotations.Test;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException, InterruptedException {
        getPageObject().getWebElement("registerButton").click();
        getPageObject().getWebElement("registrationEmail").sendKeys("poop@at.com");
        getPageObject().getWebElement("registrationUserName").sendKeys("trwne");
        getPageObject().getWebElement("registrationPassword").sendKeys("MyPassword");
        getPageObject().getWebElement("registrationConfirmPassword").sendKeys("MyPassword");
        getPageObject().getWebElement("registerNewAccountButton").click();
        getPageObject().getWebElement("loginEmail").sendKeys("poop@at.com");
        getPageObject().getWebElement("loginPassword").sendKeys("MyPassword");
        getPageObject().getWebElement("signInBtn").click();
        String pageText = getPageObject().getWebElement("pageText").getText();
        System.out.println(pageText);
        assert (pageText.equals("BudgetActivity"));
        Thread.sleep(10000);
        System.out.println("Simplest Android native test done");

    }

}

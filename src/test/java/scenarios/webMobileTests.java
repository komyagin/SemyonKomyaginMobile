package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;
import utils.Properties;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Open Google search page and search for EPAM")
    public void simpleWebTest() {
        getDriver().get(Properties.getProperty("url")); // open Google homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys("EPAM");
        getDriver().findElement(By.xpath("//button[@class='Tg7LZd']")).click();
        WebElement result = getDriver().findElement(By.xpath("//div[contains(text(),'EPAM | Enterprise Software Development, Design & Consulting')]"));
        Assert.assertEquals(result.getText(), "EPAM | Enterprise Software Development, Design & Consulting", "Appeared in search results");
    }

}

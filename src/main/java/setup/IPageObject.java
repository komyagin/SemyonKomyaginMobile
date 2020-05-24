package setup;

import org.openqa.selenium.WebElement;

public interface IPageObject {

    WebElement getWebElement(String webElementName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

}

package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.fail;

public class PageBase {

    protected static WebDriverWait wait;
    private final long TIMEOUT = 20;
    private final long POLLING = 5000;
    private final JavascriptExecutor js;
    protected static WebDriver driver;


    public PageBase(WebDriver driver) {
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    protected void isElementLocated(WebElement element) {
        try {
            // wait to get the element visible
            wait.until(ExpectedConditions.visibilityOf(element));
            // scroll to the element.
            js.executeScript("arguments[0].scrollIntoView();", element);
            // check the element is displayed.
            // TODO method returns boolean.
            element.isDisplayed();
        } catch (TimeoutException toe) {
            fail(toe.getMessage());
        }
    }


    protected void writeKeys(WebElement element, String text) {
        // check the element is allocated.
        isElementLocated(element);
        try {
            element.sendKeys(text);
            // re type using js in case of the data was not sent correctly.
            if (! element.getAttribute("value").equals(text) ) {
                js.executeScript("arguments[0].setAttribute('value', '" + text + "')", element);
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    protected void clickOnBtn(WebElement element) {
        // make sure that the element allocated successfully.
        isElementLocated(element);
        // wait to get the element clickable.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException toe) {
            fail(toe.getMessage());
        } catch (Exception e) {
            fail(e.getMessage());
        }
        // click using selenium
        try {
            element.click();
        } catch (Exception exception) {
            // we will use javascript click.
            try {
                js.executeScript("arguments[arguments.length - 1].click()", element);
            } catch (Exception root) {
                fail(root.getMessage());
            }
        }
    }

    protected String getText(WebElement element){

        // make sure that the element allocated successfully.
        isElementLocated(element);

        return element.getText();

    }

}

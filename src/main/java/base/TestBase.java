package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class TestBase  implements _DriverManager{


    private static ThreadLocal<EventFiringWebDriver> driver = null;

    @BeforeClass
    @Parameters({"browserName", "type", "isHeadless"})
    public void setUp(@Optional("chrome") String browserName, @Optional("local") String type, @Optional("false") boolean isHeadless) throws MalformedURLException {
        // check on the type of execution
        driver = new ThreadLocal<>();
        if (type.equalsIgnoreCase("local")) {
            // check on the type of the browser
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver.set(new EventFiringWebDriver(_DriverManager.buildChromeDriver(isHeadless)));

            } else {
                throw new IllegalArgumentException(browserName + " is not supported locally");
            }
            driver.get().manage().window().maximize();
        } else {
            throw new IllegalArgumentException(type + " is invalid. choose between remote and local");
        }
    }

    @AfterClass
    public void tearDown() {
        getDriver().quit();
        driver.remove();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }



}


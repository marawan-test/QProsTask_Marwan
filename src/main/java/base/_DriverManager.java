package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public interface _DriverManager {

    static WebDriver buildChromeDriver(boolean isHeadless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (isHeadless == true) {
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("start-maximized");
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--disable-dev-shm-usage");

            return new ChromeDriver(chromeOptions);
        }

        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        return new ChromeDriver(chromeOptions);
    }

    static WebDriver buildFirefoxDriver(boolean isHeadless) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (isHeadless == true) {
            firefoxOptions.addArguments("--headless");
            return new FirefoxDriver(firefoxOptions);
        }
        return new FirefoxDriver(firefoxOptions);
    }



}

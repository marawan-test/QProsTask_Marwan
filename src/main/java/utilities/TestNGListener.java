package utilities;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class TestNGListener extends TestBase implements ITestListener {

    @Override
    @Step("test failed")
    public void onTestFailure(ITestResult result) {
        // screen shoot attached to allure report.
        Allure.addAttachment("Screen shoot for the failure", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        // screen shoot saved in the screenshot folder.
        File screenShoot = new File(System.getProperty("user.dir") + "/screenshots/" + result.getMethod().getMethodName() + ".jpg");
        try {
            FileUtils.copyFile(((TakesScreenshot) getDriver() ).getScreenshotAs(OutputType.FILE), screenShoot);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

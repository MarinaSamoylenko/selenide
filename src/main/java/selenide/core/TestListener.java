package selenide.core;

import com.codeborne.selenide.WebDriverRunner;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;
import selenium.core.WebDriverTestBase;

import static com.google.common.io.Files.toByteArray;
import static selenide.util.PropertiesCache.getInstance;


public class TestListener implements ITestListener {


    private String path = getInstance().getProperty("path");
    private String expansion = getInstance().getProperty("expansion.scrin");

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot(iTestResult.getMethod().getMethodName());
    }
    @Attachment(value = "{0}")
    public byte[] saveScreenshot(String screenshotName) {
        try {
            File scrFile = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
            return toByteArray(scrFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }
    @Override
    public void onStart(ITestContext iTestContext) {
    }
    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}


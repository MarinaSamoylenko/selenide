package selenium.core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static selenide.util.PropertiesCache.getInstance;

@Listeners({TestListener.class})
public class WebDriverTestBase {
    private long implicitWait = Long.parseLong(getInstance().getProperty("wait.implicit"));
    private long pageWait = Long.parseLong(getInstance().getProperty("page.wait"));
    private long scriptWait = Long.parseLong(getInstance().getProperty("script.wait"));

    protected WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(scriptWait, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }

}

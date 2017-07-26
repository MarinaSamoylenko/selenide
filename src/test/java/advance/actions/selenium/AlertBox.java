package advance.actions.selenium;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import selenium.core.WebDriverTestBase;


public class AlertBox extends WebDriverTestBase {
        String webPageForW3 = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm";
        @Test
        public void testToAlert() {
            webDriver.get(webPageForW3);
            webDriver.switchTo().frame("iframeResult");
            WebElement tryItButton = webDriver.findElement(By.xpath("html/body/button"));
            tryItButton.click();
            Alert alert1 = webDriver.switchTo().alert();
            // accept()
            alert1.dismiss();
            WebElement fildResult = webDriver.findElement(By.id("demo"));
            String text = fildResult.getText();
            Assert.assertTrue(text.equals("You pressed Cancel!"));
        }
    }

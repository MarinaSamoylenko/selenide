package advance.actions.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class DropDownsAndIFrame extends WebDriverTestBase {

    @Test
    public void testDropdown() {

        webDriver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        WebElement iFrame = webDriver.findElement(By.xpath(".//iframe[@title='3rd party ad content']"));
        webDriver.switchTo().frame(iFrame);
        webDriver.switchTo().frame(0);
        webDriver.switchTo().frame("iframeResult");

        //Get the Dropdown as a Select using its name attribute
        Select carDropDown = new Select(webDriver.findElement(By.xpath("html/body/select")));
        System.out.printf("%s ", carDropDown.getOptions().size());
        for (WebElement m : carDropDown.getOptions()) {
            System.out.print(m.getText());
        }

        //Verify Dropdown does not support multiple selection
        assertFalse(carDropDown.isMultiple());

        Assert.assertEquals(4, carDropDown.getOptions().size());

        carDropDown.selectByVisibleText("Volvo");

        Assert.assertEquals("Volvo", carDropDown.getFirstSelectedOption().getText());
        carDropDown.selectByValue("opel");
        Assert.assertEquals("Opel", carDropDown.getFirstSelectedOption().getText());

        carDropDown.selectByIndex(2);
        Assert.assertEquals("Opel", carDropDown.getFirstSelectedOption().getText());

        webDriver.switchTo().defaultContent();

        assertTrue(webDriver.getTitle().equals("Frameset Example Title (Replace this section with your own title)"));

    }

    @Test
    public void testDragDrop() throws InterruptedException {
        webDriver.get("https://gojs.net/latest/samples/htmlDragDrop.html?gclid=CLjWnLeG5tQCFUeVGwodCowEcA");
        WebElement from = webDriver.findElement(By.xpath(".//*[@id='sample']/div[1]/span[1]/div/div[1]"));
        WebElement to = webDriver.findElement(By.xpath(".//*[@id='myDiagramDiv']/canvas"));
        Actions builder = new Actions(webDriver);
        builder.dragAndDrop(from, to).build().perform();

        from.getAttribute("src").equals("img_logo.gif");
    }
}
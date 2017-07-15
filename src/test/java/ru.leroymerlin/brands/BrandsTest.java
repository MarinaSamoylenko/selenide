package ru.leroymerlin.brands;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertTrue;

public class BrandsTest {

    private String leroyMerlin = "https://leroymerlin.ru";
    private List<String> brandsList = Arrays.asList("STANDERS", "SPACEO", "LUXENS", "SENSEA", "ARTENS", "AXTON", "DELINIA",
            "DEXTER", "EQUATION", "EVOLOGY", "GEOLIA", "INSPIRE", "LEXMAN", "NATERIAL", "STERWINS", "DEXELL");

    @BeforeClass
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = WebDriverRunner.CHROME;
    }

    @Test
    public void transitionsToBrandsPageTest() {
        open(leroyMerlin);
        By ourBrandsLinkLocator = By.xpath("//a[@class='breadscrumbs__item'][@href='/brands/']");
        By acceptCookies = By.id("btn-accept_cookies");
        By advertPopUp = By.xpath("//a[@title='Закрыть']");
        By brandsLinkLocator = By.xpath("//a[@class='nav-foot__link'][@href='/brands/']");
        By brandsListLocator = By.xpath("//ul[@class='brands']/li");
        By brandIdentificationTextLocator = By.xpath("//span[@class='hl__brand__uppercase']");
        $(acceptCookies).click();
        $(advertPopUp).click();
        $(brandsLinkLocator).click();
        ElementsCollection brands = $$(brandsListLocator);
        brands.forEach(brand -> {
                    brand.click();
                    assertTrue(brandsList.contains($(brandIdentificationTextLocator).getText()));
                    $(ourBrandsLinkLocator).click();
                }
        );
    }
}

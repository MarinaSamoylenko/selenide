package selenide.pages.google;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class GoogleSearchResultPage extends AbstractPage {

    private ElementsCollection linkResults = $$("#ires .g");

    public ElementsCollection getLinkResults() {
        return linkResults;
    }
    private SelenideElement search = $(By.name("q"));

    public GoogleSearchResultPage searchFor(String searchText) {
        search.val(searchText);
        jsClick("btnG","name");
        return this;
    }
}
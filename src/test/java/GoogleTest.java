import org.openqa.selenium.By;
import org.testng.annotations.Test;
import selenide.core.SelenideTestBase;
import selenide.pages.google.GoogleSearchPage;
import selenide.pages.google.GoogleSearchResultPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest extends SelenideTestBase {
    private String google = "http://google.com/ncr";
    private String searchText = "selenide";

    @Test
    public void searchInGoogleTest() {
        open(google);
        $(By.name("q")).val(searchText).pressEnter();
        $$("#ires .g").shouldHave(size(10));
        $("#ires .g").shouldBe(visible).shouldHave(
                text("Selenide: concise UI tests in Java"),
                text("selenide.org"));
    }

    @Test
    public void searchInGoogleWithPageObjectTest() {
        open(google);
        GoogleSearchPage googleSearch = new GoogleSearchPage();
        googleSearch.searchFor(searchText);
        GoogleSearchResultPage googleResult = new GoogleSearchResultPage();
        googleResult.getLinkResults()
                    .shouldHave(size(10))
                    .first()
                    .shouldHave(text("Selenide: concise UI tests in Java"));
    }
}

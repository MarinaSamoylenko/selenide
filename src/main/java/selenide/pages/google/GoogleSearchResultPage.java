package selenide.pages.google;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class GoogleSearchResultPage {
    private ElementsCollection linkResults = $$("#ires .g");
    
    public ElementsCollection getLinkResults() {
        return linkResults;
    }
}

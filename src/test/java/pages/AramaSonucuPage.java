package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AramaSonucuPage extends BasePage{

    //anasayfa>arama sonuclari>urun siralama butonu
    @FindBy(xpath ="//select[@id='sortingType']")
    public WebElement urunSiralamaDropdownElementi;

    //anasayfa>arama sonuclari>ucretsiz kargo secenegi
    @FindBy(xpath ="//input[@id='freeShippingOption']")
    public WebElement ucretsizKargoCheckbox;

    //anasayfa>arama sonuclari>ilk sayfa tum kulakliklar
    @FindBy(xpath = "//section[@class='group listingGroup resultListGroup import-search-view']")
    public WebElement aramaSonucuTumUrunler;

    public List<WebElement> aramaSonucuListesi() {

        List<WebElement> aramaSonucuList= aramaSonucuTumUrunler.findElements(By.tagName("h3"));

        return aramaSonucuList;

    }

    

    }








package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UrunSayfasiPage extends BasePage{

    //anasayfa>arama sonuclari>tiklanan urun>sepete ekle butonu
    @FindBy(xpath ="//button[@title='Sepete Ekle']")
    public WebElement sepeteEkleButonu;

    //anasayfa>arama sonuclari>tiklanan urun>sepete git butonu
    @FindBy(xpath = "//a[@class='btn btnBlack btnGoBasket']")
    public WebElement sepeteGitButonu;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu
    @FindBy(xpath = "//i[@class='icon iconBasket']")
    public WebElement sepetIkonu;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>sepetteki urun adedi
    @FindBy(xpath = "//span[@class='basketTotalNum']")
    public WebElement sepettekiUrunAdedi;
}

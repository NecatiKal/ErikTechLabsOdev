package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SepetimPage extends BasePage{

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>misafir musteri aydinlatma metni tamam butonu
    @FindBy(xpath = "//span[@class='btn btnBlack']")
    public WebElement tamamButonu;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>sepetteki ilk urun fiyat
    @FindBy(xpath = "(//div[@class='priceArea'])[1]")
    public WebElement sepettekiIlkUrunFiyati;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>sepetteki ikinci urun fiyat
    @FindBy(xpath = "(//div[@class='priceArea'])[2]")
    public WebElement sepettekiIkinciUrunFiyati;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>sepetteki ilk urun adet attirma butonu
    @FindBy(xpath = "(//span[@class='spinnerUp spinnerArrow'])[1]")
    public WebElement sepettekiIlkUrunFAdetArttirmaButonu;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>sepetteki ikinci urun adet arttirma butonu
    @FindBy(xpath = "(//span[@class='spinnerUp spinnerArrow'])[2]")
    public WebElement sepettekiIkinciUrunAdetArttirmaButonu;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>satin al butonu
    @FindBy(xpath = "//span[text()='Satın Al']")
    public WebElement satinAlButonu;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>satin al butonu>uye olmadan devam et
    @FindBy(xpath = "//a[text()='Üye Olmadan Devam Et']")
    public WebElement uyeOlmadanDevamEtSecenegi;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>satin al butonu>uye olmadan devam et>misafir e mail kutusu
    @FindBy(xpath = "//input[@name='guestEmail']")
    public WebElement eMailMisafirGirisiKutusu;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>satin al butonu>uye olmadan devam et>ulke arama kodu dropdown
    @FindBy(xpath = "//select[@id='countryDialCode']")
    public WebElement ulkeAramaKoduDropdownElementi;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>satin al butonu>uye olmadan devam et>cep telefonu misafir girisi
    @FindBy(xpath = "//input[@id='gsmNumber']")
    public WebElement cepTelefonuGirisiKutusu;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>satin al butonu>uye olmadan devam et>cep telefonu misafir girisi
    //>girdiğin telefon numarasını doğrulamanı isteyeceğiz yazisi
    @FindBy(xpath = "//p[@class='confirmInfo']")
    public WebElement gsmDogrulamaYaziElementi;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>satin al butonu>uye olmadan devam et>cep telefonu misafir girisi
    //>dogrula ve devam et butonu
    @FindBy(xpath = "//span[@id='js-guestVerification']")
    public WebElement dogrulaVeDevamEtButton;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>satin al butonu>uye olmadan devam et>cep telefonu misafir girisi
    //>dogrula ve devam et butonu>ulke secimi
    @FindBy(xpath = "//select[@id='countryCode']")
    public WebElement ulkeSecimiDropdownElementi;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>satin al butonu>uye olmadan devam et>cep telefonu misafir girisi
    //>dogrula ve devam et butonu>sehir secimi
    @FindBy(xpath = "//select[@id='cityId']")
    public WebElement sehirSecimiDropdownElementi;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>satin al butonu>uye olmadan devam et>cep telefonu misafir girisi
    //>dogrula ve devam et butonu>ilce secimi
    @FindBy(xpath = "//select[@id='districtId']")
    public WebElement ilceSecimiDropdownElementi;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>satin al butonu>uye olmadan devam et>cep telefonu misafir girisi
    //>dogrula ve devam et butonu>mahalle secimi
    @FindBy(xpath = "//select[@name='shippingAddress.neighborhoodId']")
    public WebElement mahalleSecimiDropdownElementi;

    //anasayfa>arama sonuclari>tiklanan urun>sepet ikonu>satin al butonu>uye olmadan devam et>cep telefonu misafir girisi
    //>dogrula ve devam et butonu>odemeye gec butonu
    @FindBy(xpath = "//span[@id='js-goToPaymentBtn']")
    public WebElement odemeyeGecButonu;



}

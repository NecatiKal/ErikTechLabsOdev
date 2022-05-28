package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utilities.Driver;
import utilities.ResuableMethods;

public class US1002_StepDefinitions {
    AnaSayfaPage anaSayfaPage=new AnaSayfaPage();
    AramaSonucuPage aramaSonucuPage=new AramaSonucuPage();
    UrunSayfasiPage urunSayfasiPage=new UrunSayfasiPage();
    SepetimPage sepetimPage=new SepetimPage();
    Actions actions=new Actions(Driver.getDriver());
    TempGsmPage tempGsmPage=new TempGsmPage();
    Faker faker=new Faker();

    @Then("Ana sayfada arama kutusuna kulaklik yazar ve aratir")
    public void ana_sayfada_arama_kutusuna_kulaklik_yazar_ve_aratir() {
        anaSayfaPage.aramaKutusu.click();
        anaSayfaPage.aramaKutusu.sendKeys("kulaklik");
        anaSayfaPage.aramaButonu.click();

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("kulaklik"));
        System.out.println("Kulaklik kelimesi basarili bir sekilde aratildi");
    }
    @Then("Gelen sonuclari yorum sayisina gore siralar")
    public void gelen_sonuclari_yorum_sayisina_gore_siralar() {
        Select select=new Select(aramaSonucuPage.urunSiralamaDropdownElementi);
        select.selectByValue("REVIEWS");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("REVIEWS"));
        System.out.println("Kulaklik aramasi sonucu yorum sayisina gore siralandi");

    }
    @Then("Gelen urunleri ucretsiz kargo secenegine gore filtreler")
    public void gelen_urunleri_ucretsiz_kargo_secenegine_gore_filtreler() {
        aramaSonucuPage.ucretsizKargoCheckbox.click();
        Assert.assertTrue(aramaSonucuPage.ucretsizKargoCheckbox.isSelected());
        System.out.println("Kulaklik aramasi sonucu ucretsiz kargo secenegi secilerek filtrelendi");

    }
    @Then("Gelen urunlerden ilk sayfadaki birinci ve sonuncu urunu sepete ekler")
    public void gelen_urunlerden_ilk_sayfadaki_birinci_ve_sonuncu_urunu_sepete_ekler(){

        ResuableMethods.wait(3);
        WebElement ilkUrun=aramaSonucuPage.aramaSonucuListesi().get(0);
        ResuableMethods.waitAndClick(ilkUrun);
        ResuableMethods.waitAndClick(urunSayfasiPage.sepeteEkleButonu);
        Assert.assertTrue(urunSayfasiPage.sepettekiUrunAdedi.getText().equals("1"));
        System.out.println("Ilk urun sepete eklendi");
        Driver.getDriver().navigate().back();

        int sonUrunIndex=aramaSonucuPage.aramaSonucuListesi().size()-1;
        WebElement sonUrun=aramaSonucuPage.aramaSonucuListesi().get(sonUrunIndex);
        ResuableMethods.waitAndClick(sonUrun);

        ResuableMethods.waitAndClick(urunSayfasiPage.sepeteEkleButonu);
        ResuableMethods.wait(2);
        Assert.assertTrue(urunSayfasiPage.sepettekiUrunAdedi.getText().equals("2"));
        System.out.println("Sonuncu urun sepete eklendi");

    }
    @Then("Sepete gider ve sepetteki ucuz urunun adedini iki yapar")
    public void sepete_gider_ve_sepetteki_ucuz_urunun_adedini_iki_yapar() {
        urunSayfasiPage.sepeteGitButonu.click();
        ResuableMethods.waitAndClick(sepetimPage.tamamButonu);
        String ilkUrunFiyat=sepetimPage.sepettekiIlkUrunFiyati.getText();
        String ilkUrunFiyatRakam=ilkUrunFiyat.replaceAll("\\D","");

        int ilkUF=Integer.parseInt(ilkUrunFiyatRakam);
        String ikinciUrunFiyat=sepetimPage.sepettekiIkinciUrunFiyati.getText();
        String ikinciUrunFiyatRakam=ikinciUrunFiyat.replaceAll("\\D","");

        int ikinciUF= Integer.parseInt(ikinciUrunFiyatRakam);
        System.out.println("Sepetteki ilk urunun fiyati : " +ilkUrunFiyat);
        System.out.println("Sepetteki ikinci urunun fiyati : "+ikinciUrunFiyat);

        if (ilkUF>ikinciUF){sepetimPage.sepettekiIkinciUrunAdetArttirmaButonu.click();
        }else {sepetimPage.sepettekiIlkUrunFAdetArttirmaButonu.click();}

        System.out.println("Sepetteki ucuz urunun adedi arttirildi");

        ResuableMethods.wait(3);

    }

    @Then("Misafir kullanici olarak odeme adimina ilerler")
    public void misafir_kullanici_olarak_odeme_adimina_ilerler() throws InterruptedException {

        //Sepetimizden odeme adimina gecerken bir telefon numarasi girmemiz isteniyor
        //Girdigimiz telefon numarasina sms olarak bir kod gonderiliyor ve bu kodu istenen
        //kutucuklara girmemiz bekleniyor
        //Bu adimi gecebilmek icin otomatik sms dogrulamasi yapan numaralarin oldugu web
        //adresinden numarayi istenen formatta donduren bir method olusturdum
        //Bu adimda ilgili web sayfasina yeni bir sekme acarak gecis yaptim

        String n11WindowHandle=Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        String alanKoduGsm=tempGsmPage.setTempGsmNumarasi().get(0);
        String gsmNumarasi=tempGsmPage.setTempGsmNumarasi().get(1);
        Driver.getDriver().switchTo().window(n11WindowHandle);
        System.out.println("Telefon numarasi basariyla alindi");

        sepetimPage.satinAlButonu.click();
        sepetimPage.uyeOlmadanDevamEtSecenegi.click();
        System.out.println("Gsm alan kodu : "+alanKoduGsm);
        System.out.println("Gsm numarasi : "+gsmNumarasi);
        String email=faker.internet().emailAddress();
        ResuableMethods.waitAndClick(sepetimPage.eMailMisafirGirisiKutusu);
        actions.sendKeys(email).perform();


        Select select=new Select(sepetimPage.ulkeAramaKoduDropdownElementi);
        select.selectByValue(alanKoduGsm);
        actions.click(sepetimPage.cepTelefonuGirisiKutusu).sendKeys(gsmNumarasi).perform();
        Assert.assertTrue(sepetimPage.gsmDogrulamaYaziElementi.isDisplayed());
        System.out.println("Misafir e mail ve gsm bilgileri girildi");
        ResuableMethods.wait(3);

        sepetimPage.dogrulaVeDevamEtButton.click();
        String adSoyad=faker.name().fullName();
        String adres=faker.address().fullAddress();
        actions.sendKeys(adSoyad).perform();
        Select select1=new Select(sepetimPage.ulkeSecimiDropdownElementi);
        Select select2=new Select(sepetimPage.sehirSecimiDropdownElementi);
        Select select3=new Select(sepetimPage.ilceSecimiDropdownElementi);
        Select select4=new Select(sepetimPage.mahalleSecimiDropdownElementi);
        select1.selectByValue("TR");
        ResuableMethods.wait(1);
        select2.selectByVisibleText("Antalya");
        ResuableMethods.wait(1);
        select3.selectByVisibleText("Kemer");
        ResuableMethods.wait(1);
        select4.selectByIndex(1);

        actions .sendKeys(Keys.TAB)
                .sendKeys(adres)
                .sendKeys(Keys.TAB)
                .perform();
        ResuableMethods.wait(1);
        actions .sendKeys(gsmNumarasi)
                .sendKeys(Keys.TAB)
                .sendKeys("27130122716")
                .sendKeys(Keys.TAB)
                .sendKeys("Ev")
                .perform();

        ResuableMethods.waitAndClick(sepetimPage.odemeyeGecButonu);
        ResuableMethods.wait(1);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("odeme"));
        System.out.println("Odeme adimina basariyla gecildi");







    }
}

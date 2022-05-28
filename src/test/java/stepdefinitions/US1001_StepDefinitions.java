package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.AnaSayfaPage;
import pages.MagazalarPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class US1001_StepDefinitions {
    AnaSayfaPage anaSayfaPage=new AnaSayfaPage();
    MagazalarPage magazalarPage = new MagazalarPage();
    Actions actions = new Actions(Driver.getDriver());

    @Given("Kullanici {string} adresine gider")
    public void kullaniciAdresineGider(String n11) {

        Driver.getDriver().get(ConfigReader.getProperty(n11));
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
        String gidilenUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(gidilenUrl, ConfigReader.getProperty(n11));
        System.out.println("Istenen adrese basarili bir sekilde gidildi");

    }

    @Then("Ana sayfada magazalar menusunun uzerine gelir")
    public void ana_sayfada_magazalar_menusunun_uzerine_gelir() {
        actions.moveToElement(anaSayfaPage.magazalarMenusu).perform();

    }

    @Then("Magazalar menusunden magazalari gor secenegine tiklar")
    public void magazalar_menusunden_magazalari_gor_secenegine_tiklar() {
        anaSayfaPage.magazalariGorSecenegi.click();
        String magazalarSayfasi=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(magazalarSayfasi.contains("magazalar"));
        System.out.println("Magazalar sayfasi acildi");

    }

    @Then("Acilan magazalar sayfasinda tum magazalar butonuna tiklar")
    public void acilan_magazalar_sayfasinda_tum_magazalar_butonuna_tiklar() {
        magazalarPage.tumMagazalarButonu.click();
        Assert.assertTrue(magazalarPage.tumMagazalarYaziElementi.isDisplayed());
        System.out.println("Tum magazalar sayfasi acildi");

    }

    @Then("A ile baslayan tum magazalari yazdirir")
    public void aIleBaslayanTumMagazalariYazdirir() throws IOException {

        Assert.assertTrue(magazalarPage.AIceremSonuclarYaziElementi.getText().contains("A"));
        System.out.println("A harfi ile baslayan magazalar basariyla listelendi");

        int toplam = magazalarPage.magazalarListesi().size();
        System.out.println("A ile baslayan toplam magaza : "+toplam);

        String date = new SimpleDateFormat("yyyy-MM-dd-hh-mm").format(new Date());
        File file = new File("src/test/resources/testdata/"+date+" tarihindeki magazalar listesi.txt");

        boolean value = file.createNewFile();
        if (value) {

            System.out.println("Yeni dosya olusturuldu..");

        } else {

            System.out.println("Bu isimli dosya zaten var.");

        }

        String magazalarListesi =magazalarPage.magazalarListesi.getText();

        FileWriter fw = new FileWriter("src/test/resources/testdata/"+date+" tarihindeki magazalar listesi.txt");
        fw.write(magazalarListesi);
        System.out.println("Magaza isimleri target klasoru altinda txt dosyasi içine yazdirildi");

        fw.close();

        /*
        NOT:A ile baslayan magazalar listesini excell dosyasina satir satir yazdirmak magaza sayisinin fazlaligi
        (anlik 5455 adet) nedeniyle cok uzun surdugunden;
        kodun hizli calismasi amaciyla excell dosyasina yazdirma komutlarinin bulundugu kod blogunu
        yorum icerisine aldim.

        DILERSENIZ YORUMU KALDIRIP KODU CALISTIRABILIRSINIZ.
         */

        /*
        String date = new SimpleDateFormat("yyyy-MM-dd-hh-mm").format(new Date());
        String path="src/test/resources/testdata/"+date+" tarihindeki magazalar listesi.xlsx";
        XSSFWorkbook workbook= new XSSFWorkbook();
        XSSFSheet sheet1=workbook.createSheet("Magazalar");
        XSSFRow row1=sheet1.createRow(0);
        row1.createCell(0).setCellValue("A Ile Baslayan Magazalar");
        for (int i=0; i<toplam; i++){
            String magaza=magazalarPage.magazalarListesi().get(i).getText();
            XSSFRow row2=sheet1.createRow(i+1);
            row2.createCell(0).setCellValue(magaza);
            FileOutputStream fos=new FileOutputStream(path);
            workbook.write(fos);
            fos.close();

            System.out.println((i+1)+". magaza excell'e yazdirildi :"+magaza);
         */
        }
    }





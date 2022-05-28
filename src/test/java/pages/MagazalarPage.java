package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MagazalarPage extends BasePage{

    //anasayfa>magazalar menusu>magazalari gor>tum magazalar
    @FindBy(xpath ="//h3[text()='Tüm Mağazalar']")
    public WebElement tumMagazalarButonu;

    //anasayfa>magazalar menusu>magazalari gor>tum magazalar>magazalar listesi
    @FindBy(xpath = "(//div[@class='sellerListHolder'])[4]")
    public WebElement magazalarListesi;

    //anasayfa>magazalar menusu>magazalari gor>tum magazalar>magazalar listesi
    @FindBy(xpath = "//div//div[2]//div//div[2]//div[4]//div[2]//ul")
    public WebElement magazaIsimleri;

    //anasayfa>magazalar menusu>magazalari gor>tum magazalar>tum magazalar yazisi
    @FindBy(xpath = "//h2[text()='Tüm Mağazalar']")
    public WebElement tumMagazalarYaziElementi;

    //anasayfa>magazalar menusu>magazalari gor>tum magazalar>A harfi
    @FindBy(xpath = "//span[@class='infoText']")
    public WebElement AIceremSonuclarYaziElementi;

    public List<WebElement> magazalarListesi() {

        List<WebElement> magazalarList= magazaIsimleri.findElements(By.tagName("li"));

       return magazalarList;
    }




}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnaSayfaPage extends BasePage {

    //anasayfa>magazalar menusu
    @FindBy(xpath = "//span[@title='Mağazalar']")
    public WebElement magazalarMenusu;

    //anasayfa>magazalar menusu>magazalari gor
    @FindBy(xpath = "//a[@title='Mağazaları Gör']")
    public WebElement magazalariGorSecenegi;

    //anasayfa>arama kutusu
    @FindBy(xpath = "//input[@id='searchData']")
    public WebElement aramaKutusu;

    //anasayfa>arama butonu
    @FindBy(xpath = "//a[@class='searchBtn']")
    public WebElement aramaButonu;










}

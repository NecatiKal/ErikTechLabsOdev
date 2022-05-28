package pages;

import org.junit.Before;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class TempGsmPage extends BasePage {

    @FindBy(xpath = "//label[@id='disabledLable1']")
    public WebElement tempGsmNumarasi;

    public ArrayList<String> setTempGsmNumarasi(){
        Driver.getDriver().get(ConfigReader.getProperty("tempgsm"));
        String tempGsm=tempGsmNumarasi.getText();
        String alanKodu=tempGsm.substring(0,tempGsm.length()-11);
        String gsm = tempGsm.substring(tempGsm.length() - 11, tempGsm.length() - 1);
        ArrayList<String> alanKoduGsm=new ArrayList<String>();
        alanKoduGsm.add(alanKodu);
        alanKoduGsm.add(gsm);
        return alanKoduGsm;

    }
}

package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class countries_Page extends PageBase {

    //Constructor
    public countries_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Locators

    @FindBy(id = "country-title")
    private WebElement countryTitle;


    @FindBy(id = "eg")
    private WebElement egCountry;

    @FindBy(id = "ae")
    private WebElement uaeCountry;

    @FindBy(id = "dz")
    private WebElement algeriaCountry;

    @FindBy(id = "dj")
    private WebElement djiboutiCountry;

    @FindBy(id = "td")
    private WebElement chadCountry;

    @FindBy(id = "iq")
    private WebElement iraqCountry;

    @FindBy(id = "jo")
    private WebElement jordanCountry;

    @FindBy(id = "lb")
    private WebElement lebanonCountry;

    @FindBy(id = "ma")
    private WebElement moroccoCountry;

    @FindBy(id = "om")
    private WebElement omanCountry;

    @FindBy(id = "tn")
    private WebElement tunisiaCountry;

    @FindBy(id = "ye")
    private WebElement yemenCountry;

    @FindBy(id = "ps")
    private WebElement palestineCountry;




    // Methods
    public String getCountryTitle(){
        return getText(countryTitle);
    }

    public void selectEgtCountry(){
        clickOnBtn(egCountry);
    }

    public void selectUaeCountry(){
        clickOnBtn(uaeCountry);
    }

    public void selectAlgeriaCountry(){
        clickOnBtn(algeriaCountry);
    }

    public void selectDjiboutiCountry(){
        clickOnBtn(djiboutiCountry);
    }

    public void selectChadCountry(){
        clickOnBtn(chadCountry);
    }

    public void selectIraqCountry(){
        clickOnBtn(iraqCountry);
    }

    public void selectJordanCountry(){
        clickOnBtn(jordanCountry);
    }

    public void selectLebanonCountry(){
        clickOnBtn(lebanonCountry);
    }

    public void selectMoroccoCountry(){
        clickOnBtn(moroccoCountry);
    }

    public void selectOmanCountry(){
        clickOnBtn(omanCountry);
    }

    public void selectTunisiaCountry(){
        clickOnBtn(tunisiaCountry);
    }

    public void selectYemenCountry(){
        clickOnBtn(yemenCountry);
    }

    public void selectPalestineCountry(){
        clickOnBtn(palestineCountry);
    }

}

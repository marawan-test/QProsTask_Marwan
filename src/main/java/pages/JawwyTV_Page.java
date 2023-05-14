package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JawwyTV_Page extends PageBase {

    //Constructor
    public JawwyTV_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Locators

    @FindBy(id = "name-lite")
    private WebElement litePackage;

    @FindBy(id = "name-classic")
    private WebElement classicPackage;

    @FindBy(id = "name-premium")
    private WebElement premiumPackage;

    @FindBy(id = "currency-lite")
    private WebElement priceAndCurrencyForLitePackage;

    @FindBy(id = "currency-classic")
    private WebElement priceAndCurrencyForClassicPackage;

    @FindBy(id = "currency-premium")
    private WebElement priceAndCurrencyForPremiumPackage;

    @FindBy(id = "country-name")
    private WebElement countries;





    // Methods
    public String getLitePackages(){
     return getText(litePackage);
    }
    public String getClassicPackages(){
        return getText(litePackage);
    }
    public String getPremiumPackages(){
        return getText(litePackage);
    }

    public String getPriceAndCurrencyForLitePackage(){
        return getText(priceAndCurrencyForLitePackage);
    }

    public String getPriceAndCurrencyForClassicPackage() {
        return getText(priceAndCurrencyForClassicPackage);
    }

    public String getPriceAndCurrencyForPremiumPackage() {
        return getText(priceAndCurrencyForPremiumPackage);
    }

    public String getCountryName() {
        return getText(countries);
    }

    public countries_Page clickOnCounties() {
        clickOnBtn(countries);
        return new countries_Page(driver);
    }


}

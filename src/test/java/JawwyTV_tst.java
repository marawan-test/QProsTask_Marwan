import base.TestBase;
import com.jayway.jsonpath.JsonPath;
import configuration.Config;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.JawwyTV_Page;
import utilities.Helper;
import utilities.JsonReader;

@Log4j2
public class JawwyTV_tst extends TestBase {

    private static final Config config = new Config();
    JawwyTV_Page jawwyTV_page;


    @BeforeClass
    public void beforeClassMethod() {

        log.info("navigate to Url {}", config.getProperty("Url"));
        getDriver().navigate().to(config.getProperty("Url"));
        jawwyTV_page  = new JawwyTV_Page(getDriver());
    }

    @Test(description = "Verify that the UAE country has been successfully selected")
    public void verifyUaeCountrySelected(){

        log.info("Click on Counties button");
        var counties = jawwyTV_page.clickOnCounties();

        log.info("select The UAE Country");
        counties.selectUaeCountry();

        Assert.assertEquals( jawwyTV_page.getCountryName(),
                JsonPath.read(JsonReader.getTestData(),"UAE.CountryName").toString());
    }

    @Test(description = "Verify that a Price field correctly displays the cost of the Subscription Lite Package in the UAE Country"
            ,dependsOnMethods ={"verifyUaeCountrySelected"})
    public void verifyUaePriceOfSubscriptionLitePackage()  {

        log.info("Assert That Subscription Lite Packages Price of UAE is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"UAE.subscription[0].amount").toString());
        // Assertion
        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForLitePackage(),
                JsonPath.read(JsonReader.getTestData(),"UAE.subscription[0].amount").toString()),
                "UAE Price Of Subscription Lite Package not contains Price "+
                        JsonPath.read(JsonReader.getTestData(),"UAE.subscription[0].amount").toString());

    }

    @Test(description = "Verify that a Currency field correctly displays the cost of the Subscription Lite Package in the UAE Country",
            dependsOnMethods ={"verifyUaeCountrySelected"})
    public void verifyUaeCurrencyOfSubscriptionLitePackage()  {

        log.info("Assert That Subscription Lite Packages Currency of UAE is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"UAE.Currency").toString());

        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForLitePackage(),
                JsonPath.read(JsonReader.getTestData(),"UAE.Currency").toString()),
                "UAE Currency Of Subscription Lite Package not contains "+
                        JsonPath.read(JsonReader.getTestData(),"UAE.Currency").toString());
    }

    @Test(description = "Verify that a Price field correctly displays the cost of the Subscription Classic Package in the UAE Country"
            ,dependsOnMethods ={"verifyUaeCountrySelected"})
    public void verifyUaePriceOfSubscriptionClassicPackage()  {

        log.info("Assert That Subscription Classic Packages Price of UAE is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"UAE.subscription[1].amount").toString());

        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForClassicPackage(),
                JsonPath.read(JsonReader.getTestData(),"UAE.subscription[1].amount").toString()),
                "UAE  Subscription Classic Package Price not contains "+
                        JsonPath.read(JsonReader.getTestData(),"UAE.subscription[1].amount").toString());

    }

    @Test(description = "Verify that a Currency field correctly displays the cost of the Subscription Classic Package in the UAE Country",
            dependsOnMethods ={ "verifyUaeCountrySelected" })
    public void verifyUaeCurrencyOfSubscriptionClassicPackage()  {

        log.info("Assert That Subscription Classic Packages Currency of UAE is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"UAE.Currency").toString());

        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForClassicPackage(),
                JsonPath.read(JsonReader.getTestData(),"UAE.Currency").toString()),
                "UAE Currency Of Subscription Classic Package not contains "+
                        JsonPath.read(JsonReader.getTestData(),"UAE.Currency").toString());
    }

    @Test(description = "Verify that a Price field correctly displays the cost of the Subscription Premium Package in the UAE Country"
            ,dependsOnMethods ={"verifyUaeCountrySelected"})
    public void verifyUaePriceOfSubscriptionPremiumPackage()  {

        log.info("Assert That Subscription Premium Packages Price of UAE is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"UAE.subscription[2].amount").toString());

        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForPremiumPackage(),
                JsonPath.read(JsonReader.getTestData(),"UAE.subscription[2].amount").toString()),
                "UAE Subscription Premium Package Price not contains "+
                        JsonPath.read(JsonReader.getTestData(),"UAE.subscription[2].amount").toString());

    }

    @Test(description = "Verify that a Currency field correctly displays the cost of the Subscription Premium Package in the UAE Country",
            dependsOnMethods ={"verifyUaeCountrySelected" })
    public void verifyUaeCurrencyOfSubscriptionPremiumPackage()  {

        log.info("Assert That Subscription Premium Packages Currency of UAE is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"UAE.Currency").toString());

        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForPremiumPackage(),
                JsonPath.read(JsonReader.getTestData(),"UAE.Currency").toString()),
                "UAE Currency Of Subscription Premium Package not contains Currency "+
                        JsonPath.read(JsonReader.getTestData(),"UAE.Currency").toString());
    }

    @Test(description = "Verify that the Chad country has been successfully selected")
    public void verifyChadCountrySelected(){

        log.info("Click on Counties button");
        var counties = jawwyTV_page.clickOnCounties();

        log.info("select The Chad Country");
        counties.selectChadCountry();

        Assert.assertEquals( jawwyTV_page.getCountryName(),
                JsonPath.read(JsonReader.getTestData(),"Chad.CountryName").toString());
    }


    @Test(description = "Verify that a Price field correctly displays the cost of the Subscription Lite Package in the Chad Country",
            dependsOnMethods ={"verifyChadCountrySelected"})
    public void verifyChadPriceOfSubscriptionLitePackage()  {

        log.info("Assert That Subscription Lite Packages Price of Chad is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"Chad.subscription[0].amount").toString());
        // Assertion
        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForLitePackage(),
                JsonPath.read(JsonReader.getTestData(),"Chad.subscription[0].amount").toString()),
                "Chad Subscription Lite Package Price not contains "+
                        JsonPath.read(JsonReader.getTestData(),"Chad.subscription[0].amount").toString());

    }

    @Test(description = "Verify that a Currency field correctly displays the cost of the Subscription Lite Package in the Chad Country",
            dependsOnMethods ={"verifyChadCountrySelected"})
    public void verifyChadCurrencyOfSubscriptionLitePackage()  {

        log.info("Assert That Subscription Lite Packages Currency of Chad is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"Chad.Currency").toString());

        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForLitePackage(),
                JsonPath.read(JsonReader.getTestData(),"Chad.Currency").toString()),
                "Chad Currency Of Subscription Lite Package not contains "+
                        JsonPath.read(JsonReader.getTestData(),"Chad.Currency").toString());
    }

    @Test(description = "Verify that a Price field correctly displays the cost of the Subscription Classic Package in the Chad Country",
            dependsOnMethods ={"verifyChadCountrySelected"})
    public void verifyChadPriceOfSubscriptionClassicPackage()  {

        log.info("Assert That Subscription Classic Packages Price of Chad is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"Chad.subscription[1].amount").toString());

        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForClassicPackage(),
                JsonPath.read(JsonReader.getTestData(),"Chad.subscription[1].amount").toString()),
                "Chad Subscription Classic Package Price not contains "+
                        JsonPath.read(JsonReader.getTestData(),"Chad.subscription[1].amount").toString());

    }

    @Test(description = "Verify that a Currency field correctly displays the cost of the Subscription Classic Package in the Chad Country",
            dependsOnMethods ={ "verifyChadCountrySelected" })
    public void verifyChadCurrencyOfSubscriptionClassicPackage()  {

        log.info("Assert That Subscription Classic Packages Currency of Chad is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"Chad.Currency").toString());

        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForClassicPackage(),
                JsonPath.read(JsonReader.getTestData(),"Chad.Currency").toString()),
                "Chad Currency Of Subscription Classic Package not contains "+
                        JsonPath.read(JsonReader.getTestData(),"Chad.Currency").toString());
    }

    @Test(description = "Verify that a Price field correctly displays the cost of the Subscription Premium Package in the Chad Country",
            dependsOnMethods ={"verifyChadCountrySelected"})
    public void verifyChadPriceOfSubscriptionPremiumPackage()  {

        log.info("Assert That Subscription Premium Packages Price of Chad is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"Chad.subscription[2].amount").toString());

        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForPremiumPackage(),
                JsonPath.read(JsonReader.getTestData(),"Chad.subscription[2].amount").toString()),
                "Chad Subscription Premium Package Price not contains "+
                        JsonPath.read(JsonReader.getTestData(),"Chad.subscription[2].amount").toString());

    }

    @Test(description = "Verify that a Currency field correctly displays the cost of the Subscription Premium Package in the Chad Country",
            dependsOnMethods ={ "verifyChadCountrySelected" })
    public void verifyChadCurrencyOfSubscriptionPremiumPackage()  {
        log.info("Assert That Subscription Premium Packages Currency of Chad is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"Chad.Currency").toString());

        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForPremiumPackage(),
                JsonPath.read(JsonReader.getTestData(),"Chad.Currency").toString()),
                "Chad Currency Of Subscription Premium Package not contains Currency "+
                        JsonPath.read(JsonReader.getTestData(),"Chad.Currency").toString());
    }

    @Test(description = "Verify that the Morocco country has been successfully selected")
    public void verifyMoroccoCountrySelected(){

        log.info("Click on Counties button");
        var counties = jawwyTV_page.clickOnCounties();

        log.info("select The Morocco Country");
        counties.selectMoroccoCountry();

        Assert.assertEquals( jawwyTV_page.getCountryName(),
                JsonPath.read(JsonReader.getTestData(),"Morocco.CountryName").toString());
    }

    @Test(description = "Verify that a Price field correctly displays the cost of the Subscription Lite Package in the Morocco Country",
            dependsOnMethods ={"verifyMoroccoCountrySelected"})
    public void verifyMoroccoPriceOfSubscriptionLitePackage()  {

        log.info("Assert That Subscription Lite Packages Price of Morocco is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"Morocco.subscription[0].amount").toString());

        // Assertion
        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForLitePackage(),
                JsonPath.read(JsonReader.getTestData(),"Morocco.subscription[0].amount").toString()),
                "Morocco Subscription Lite Package Price not contains "+
                        JsonPath.read(JsonReader.getTestData(),"Morocco.subscription[0].amount").toString());

    }

    @Test(description = "Verify that a Currency field correctly displays the cost of the Subscription Lite Package in the Morocco Country",
            dependsOnMethods ={"verifyMoroccoCountrySelected"})
    public void verifyMoroccoCurrencyOfSubscriptionLitePackage()  {

        log.info("Assert That Subscription Lite Packages Currency of Morocco is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"Morocco.Currency").toString());

        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForLitePackage(),
                JsonPath.read(JsonReader.getTestData(),"Morocco.Currency").toString()),
                "Morocco Currency Of Subscription Lite Package not contains "+
                        JsonPath.read(JsonReader.getTestData(),"Morocco.Currency").toString());
    }

    @Test(description = "Verify that a Price field correctly displays the cost of the Subscription Classic Package in the Morocco Country",
            dependsOnMethods ={"verifyMoroccoCountrySelected"})
    public void verifyMoroccoPriceOfSubscriptionClassicPackage()  {

        log.info("Assert That Subscription Classic Packages Price of Morocco is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"Morocco.subscription[1].amount").toString());

        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForClassicPackage(),
                JsonPath.read(JsonReader.getTestData(),"Morocco.subscription[1].amount").toString()),
                "Morocco Subscription Classic Package Price not contains "+
                        JsonPath.read(JsonReader.getTestData(),"Morocco.subscription[1].amount").toString());

    }

    @Test(description = "Verify that a Currency field correctly displays the cost of the Subscription Classic Package in the Morocco Country",
            dependsOnMethods ={ "verifyMoroccoCountrySelected" })
    public void verifyMoroccoCurrencyOfSubscriptionClassicPackage()  {

        log.info("Assert That Subscription Classic Packages Currency of Morocco is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"Morocco.Currency").toString());

        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForClassicPackage(),
                JsonPath.read(JsonReader.getTestData(),"Morocco.Currency").toString()),
                "Morocco Currency Of Subscription Classic Package not contains "+
                        JsonPath.read(JsonReader.getTestData(),"Morocco.Currency").toString());
    }

    @Test(description = "Verify that a Price field correctly displays the cost of the Subscription Premium Package in the Morocco Country",
            dependsOnMethods ={"verifyMoroccoCountrySelected"})
    public void verifyMoroccoPriceOfSubscriptionPremiumPackage()  {

        log.info("Assert That Subscription Premium Packages Price of Morocco is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"Morocco.subscription[2].amount").toString());

        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForPremiumPackage(),
                JsonPath.read(JsonReader.getTestData(),"Morocco.subscription[2].amount").toString()),
                "Morocco Subscription Premium Package Price not contains "+
                        JsonPath.read(JsonReader.getTestData(),"Morocco.subscription[2].amount").toString());

    }

    @Test(description = "Verify that a Currency field correctly displays the cost of the Subscription Premium Package in the Morocco Country",
            dependsOnMethods ={ "verifyMoroccoCountrySelected" })
    public void verifyMoroccoCurrencyOfSubscriptionPremiumPackage()  {

        log.info("Assert That Subscription Premium Packages Currency of Morocco is equal {} ",
                JsonPath.read(JsonReader.getTestData(),"Morocco.Currency").toString());

        Assert.assertTrue(Helper.compareText(jawwyTV_page.getPriceAndCurrencyForPremiumPackage(),
                JsonPath.read(JsonReader.getTestData(),"Morocco.Currency").toString()),
                "Chad Currency Of Subscription Premium Package not contains Currency "+
                        JsonPath.read(JsonReader.getTestData(),"Morocco.Currency").toString());
    }




}

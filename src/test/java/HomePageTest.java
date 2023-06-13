import BaseTest.BaseTest;
import InterfacePages.HomePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class HomePageTest extends BaseTest {


    @Test(description = "TC0001 PASS- Hover on Account Section and Checks Text")
    public void TC0001(){
        HomePage homePage =new HomePage(driver,new Actions(driver));
        homePage.hoverCheckAccountSection();

    }

    @Test(description = "TC0002 PASS- Click on SignIn Button On Hover And Checks The Text On SignIn Page")
    public void TC0002(){
        HomePage homePage=new HomePage(driver,new Actions(driver));
        homePage.hoverClickOnSign()
                .checkTextSignIn();

    }
    @Test(description = "TC0003 PASS- Click On ReturnAndOrders Section And Checks The Text On SignIn Page")
    public void TC0003(){
        HomePage homePage=new HomePage(driver,new Actions(driver));
        homePage.clickOnReturnAndOrders()
                .checkTextSignIn();

    }
    @Test(description="TC0004 PASS- Click On Location Section, Checks The Text On PopUp And Click On Button 'ClickOnToViewYourAddress', Check Text On SignIn Page")
    public void TC0004(){
        HomePage homePage=new HomePage(driver,new Actions(driver));
        homePage.clickOnLocation()
                .checkLocationInfo()
                .clickOnAddressButton()
                .checkTextSignIn();
    }
    @Test(description ="TC0005 PASS- Click On Categories, Checks the Text In")
    public void TC0005(){
        HomePage homePage=new HomePage(driver,new Actions(driver));
        homePage.clickOnCategories()
                .clickOnBabyCategory()
                .checkTextInCategories();

    }
    @Test(description = "TC0006 PASS- Check Product")
    public void TC0006(){
        HomePage homePage=new HomePage(driver,new Actions(driver));
        homePage.enterASIN()
                .clickOnSearch()
                .clearASIN();

    }
    @Test(description = "TC0007 PASS- Add Product To Cart And Delete Product")
    public void TC0007(){
        HomePage homePage=new HomePage(driver,new Actions(driver));
        homePage.enterASIN()
                .clickOnSearch()
                .acceptCookies()
                .clickOnProductDescription()
                .clickOnAddToCartButton()
                .checkCart()
                .clickOnGoToCart()
                .emptyCart()
                .checkEmptyCart();
    }



}

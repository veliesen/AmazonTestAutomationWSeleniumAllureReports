import BaseTest.BaseTest;
import InterfacePages.HomePage;
import InterfacePages.SignInPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    @Test(description = "TC0008 PASS- Checks the SignIn Condition, Click On The SignIn Button and Check The SignIn Page Text")
    public void TC0008() {
        HomePage homePage = new HomePage(driver, new Actions(driver));
        homePage.hoverCheckAccountSection()
                .hoverClickOnSign()
                .checkTextSignIn();
    }

    @Test(description = "TC0009 PASS- Unsuccessful Email Entry And ClickOn SignIn Button ,Check The Warning Text")
    public void TC0009() {
        HomePage homePage = new HomePage(driver, new Actions(driver));
        SignInPage signInPage = new SignInPage(driver, new Actions(driver));
        homePage.hoverCheckAccountSection()
                .hoverClickOnSign();
        signInPage.clearEmail()
                .clickContinue()
                .checkEmailWarningText();
    }

    @Test(description = "TC0010 PASS- Successful Email Entry And Check the Text On Password Page")
    public void TC0010() {
        HomePage homePage = new HomePage(driver, new Actions(driver));
        SignInPage signInPage = new SignInPage(driver, new Actions(driver));
        homePage.hoverCheckAccountSection()
                .hoverClickOnSign();
        signInPage.clearEmail()
                .fillEmail()
                .clickContinue()
                .checkPasswordPageToHomepage();

    }

    @Test(description = "TC0011 PASS- Unsuccessful Password Entry and Check Warning Text")
    public void TC0011() {
        HomePage homePage = new HomePage(driver, new Actions(driver));
        SignInPage signInPage = new SignInPage(driver, new Actions(driver));
        homePage.hoverCheckAccountSection()
                .hoverClickOnSign();
        signInPage.clearEmail()
                .fillEmail()
                .clickContinue()
                .fillPasswordGeneratedValue()
                .clickOnSignIn()
                .checkWarningAccountToHomePage();
    }

    @Test(description = "TC0012 PASS- Successful SignIn Check the Text On Account Section")
    public void TC0012() {
        HomePage homePage = new HomePage(driver, new Actions(driver));
        SignInPage signInPage = new SignInPage(driver, new Actions(driver));
        homePage.hoverCheckAccountSection()
                .hoverClickOnSign();
        signInPage.clearEmail()
                .fillEmail()
                .clickContinue()
                .fillPasswordValid()
                .clickOnSignIn()
                .checkAccountName();
    }

    @Test(description = "TC0013 PASS-Add Product To Cart, Check the Text")
    public void TC0013() {
        HomePage homePage = new HomePage(driver, new Actions(driver));
        SignInPage signInPage = new SignInPage(driver, new Actions(driver));
        signInPage
                .enterASINSignedIn()
                .clickOnSearchSignedIn()
                .clickOnProductDescriptionSignedIn()
                .clickOnAddToCartBuyBoxBtn()
                .clickProceedToCheckOut()
                .checksOrderSummary()
                .clickOnPaymentReturn(500)
                .clickOnPopUpReturnToCart()
                .emptyCartSignedIn()
                .checkEmptyCartSignedIn();
    }

    @Test(description = "TC0014 PASS- Successful SignedIn Page,Successful SignOut")
    public void TC0014() {
        HomePage homePage = new HomePage(driver, new Actions(driver));
        SignInPage signInPage = new SignInPage(driver, new Actions(driver));
        signInPage.clickOnSignOut()
                  .navigateHomeByClickOnLogo();


    }
}

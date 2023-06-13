package InterfacePages;

import BaseTest.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SignInPage extends BaseTest {
    public WebDriver driver;

    public Actions actions;

    String text;

    public SignInPage(WebDriver driver, Actions actions){
        this.driver=driver;
        this.actions=actions;
    }
    @Step("Clear The Email Tab")
    public SignInPage clearEmail(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("ap_email")).clear();

        return this;
    }
    @Step("Click On Product Description")
    public SignInPage clickOnProductDescriptionSignedIn(){
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div[1]/span/a/div/img")).click();
        return this;
    }
    @Step("Click On Buy Box Btn To Add To Cart")
    public SignInPage clickOnAddToCartBuyBoxBtn(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector("input[id='add-to-cart-button']")).click();
        return this;
    }

    @Step("Clicks on Sign In Button")
    public SignInPage clickContinue(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("continue")).click();

        return this;
    }
    @Step("Checks Warning Text After Empty Mail")
    public SignInPage checkEmailWarningText(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        text=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/form/div/div/div/div[1]/div/div/div")).getText();
        Assert.assertEquals("E-posta adresinizi veya cep telefonu numaranızı girin",text);
        System.out.println(text);
        driver.navigate().to("https://www.amazon.com.tr/");

        return this;
    }
    @Step("Fills The Email With Valid Value")
    public SignInPage fillEmail(){
        driver.findElement(By.id("ap_email")).sendKeys(getDecryptedEmail());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return this;
    }
    @Step("Fills The Email With Valid Value")
    public SignInPage checkPasswordPageToHomepage(){

        text=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div/form/div/div[1]/div[1]/div[1]/label")).getText();
        Assert.assertEquals("Şifre",text);
        driver.findElement(By.cssSelector("i[class='a-icon a-icon-logo']")).click();

        return this;
    }
    @Step("Fill Password With Random Generated String Value")
    public SignInPage fillPasswordGeneratedValue(){
        driver.findElement(By.id("ap_password")).sendKeys(getGeneratedText()+getGeneratedInteger());

        return this;
    }

    @Step("Checks Warning Text On AcoountPage After Wrong Password")
    public SignInPage checkWarningAccountToHomePage(){

        text=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[1]/div/div/div/div/ul/li/span")).getText();
        Assert.assertEquals("Şifreniz yanlış",text);
        driver.findElement(By.cssSelector("i[class='a-icon a-icon-logo']")).click();


        return this;
    }

    @Step("Fills the Password With Valid Value")
    public SignInPage fillPasswordValid(){

        driver.findElement(By.id("ap_password")).sendKeys(getDecryptedPassword());

        return this;
    }
    @Step("Click On SignIn Button")
    public SignInPage clickOnSignIn(){

        driver.findElement(By.id("signInSubmit")).click();

        return this;
    }
    @Step("Checks The Account Name")
    public SignInPage checkAccountName(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        text=driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
        Assert.assertEquals("Veli",text);
        return this;
    }
    @Step("Check Product By ASIN")
    public SignInPage enterASINSignedIn(){
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(ASIN);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    @Step("Click On Search Button")
    public SignInPage clickOnSearchSignedIn(){
        driver.findElement(By.id("nav-search-submit-button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return this;
    }

    @Step("Clicks On Proceed To Check Out")
    public SignInPage clickProceedToCheckOut(){
        driver.findElement(By.cssSelector("input[name='proceedToRetailCheckout']")).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return this;
    }
    @Step("Checks Order Summary")
    public SignInPage checksOrderSummary(){
        text=driver.findElement(By.cssSelector("h3[class='a-spacing-base a-spacing-top-micro']")).getText();
        Assert.assertEquals("Sipariş Özeti",text);
        return this;
    }
    @Step("Navigate Previous Page")
    public SignInPage navigateBack(){
        driver.navigate().back();
        return this;
    }
    @Step("Click On View Pagee")
    public SignInPage clickOnViewCart(){
        driver.findElement(By.id("sw-gtc")).click();
        return this;
    }
    @Step("Click Sign Out On Hover Account")
    public SignInPage clickOnSignOut(){

        WebElement element= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(element).build().perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("nav-item-signout")).click();

        return this;

    }
    @Step("Empty Cart")
    public SignInPage emptyCartSignedIn(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("a-autoid-0-announce")).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("quantity_0")).click();
        return this;
    }
    @Step("Return Cart First Step To View PopUp")
    public SignInPage clickOnPaymentReturn(int time){
        driver.findElement(By.cssSelector("span[class='a-color-link clickable-heading']")).click();
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    @Step("Popup Click Return To Cart")
    public SignInPage clickOnPopUpReturnToCart(){
        driver.findElement(By.id("a-autoid-3-announce")).click();
        return this;
    }

    @Step("Check Whether The Cart Is Deleted  Or Not")
    public SignInPage checkEmptyCartSignedIn(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        text=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/div/div")).getText();
        Assert.assertEquals("Amazon sepetiniz boş.",text);
        System.out.println(text);
        driver.navigate().to("https://www.amazon.com.tr/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    @Step("Navigate To Homepage After SingOut By Clicking Logo")
    public SignInPage navigateHomeByClickOnLogo(){
        driver.findElement(By.cssSelector("i[class='a-icon a-icon-logo']")).click();
        return this;
    }

}

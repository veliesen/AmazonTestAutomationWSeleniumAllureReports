package InterfacePages;


import BaseTest.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BaseTest {
    public WebDriver driver;

    public Actions actions;
    String text;


    public HomePage(WebDriver driver, Actions actions){
        this.driver=driver;
        this.actions=actions;
    }
    @Step("<nav-link-accountList-nav-line-1>li elementin üzerinde hover konumunda bekle")
    public HomePage hoverCheckAccountSection() {

        WebElement element = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(element).build().perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String text = driver.findElement(By.cssSelector("div[id='nav-flyout-ya-newCust']")).getText();
        System.out.println(text);
        Assert.assertEquals("Yeni müşteri misiniz? Üye olun.", text);

        return this;
    }

    @Step("Clicks SignIn Button On Hover")
    public HomePage hoverClickOnSign(){

        WebElement element= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(element).build().perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector("a[class='nav-action-signin-button']")).click();
        return this;}
    @Step("Checks the text on SignIn Page")
    public HomePage checkTextSignIn(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        text=driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/h1")).getText();
        Assert.assertEquals("Giriş yap",text);
        driver.navigate().back();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return this;
    }
    @Step("Clicks on ReturnsAndOrders Section")
    public HomePage clickOnReturnAndOrders(){
        driver.findElement(By.id("nav-orders")).click();

        return this;
    }
    @Step("Clicks on Location Section")
    public HomePage clickOnLocation(){
        driver.findElement(By.id("glow-ingress-block")).click();
        return this;
    }
    @Step("Checks The Text On Location PopUp")
    public HomePage checkLocationInfo(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        text=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[2]/div[1]/div/span")).getText();
        Assert.assertEquals("Teslimat seçenekleri ve hızı, teslimat adresine bağlı olarak değişiklik gösterebilir.",text);
        return this;
    }
    @Step("Click on Button 'Check Your Address'")
    public HomePage clickOnAddressButton(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("GLUXSignInButton")).click();
        return this;
    }
    @Step("Click on Categories")
    public HomePage clickOnCategories(){
        driver.findElement(By.id("searchDropdownBox")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    @Step("Check Text in Categories")
    public HomePage checkTextInCategories(){
        text=driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div/div/select/option[3]")).getText();
        Assert.assertEquals("Bebek",text);
        return this;
    }
    @Step("Click On Baby in Categories")
    public HomePage clickOnBabyCategory(){
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div/div/select/option[3]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return this;
    }
    @Step("Check Product By ASIN")
    public HomePage enterASIN(){
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(ASIN);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

/*    @Step("Check The Product")
    public HomePage checkProduct(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        text=driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div[2]/div[1]/h2/a/span")).getText();
        Assert.assertEquals("Oyun konsolu,mewmewcat RGB10MAX2 El Retro Oyun Konsolu 64GB TF Kartlı Taşınabilir Video Oyun Oyuncular 22000 Oyunlar Dahili WiFi 5 inç IPS Ekran Açık Kaynak Linux Sistemi 3.5mm Ses Çıkışı",text);
        driver.navigate().back();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }*/
    @Step("Clear ASIN")
    public HomePage clearASIN(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("twotabsearchtextbox")).clear();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().back();
        return this;
    }
    @Step("Click On Search Button")
    public HomePage clickOnSearch(){
        driver.findElement(By.id("nav-search-submit-button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return this;
    }
    @Step("Click On Product to Accept Cookies")
    public HomePage acceptCookies(){
        driver.findElement(By.id("sp-cc-accept")).click();
        return this;
    }
    @Step("Click On Product Description")
    public HomePage clickOnProductDescription(){
        driver.navigate().to("https://www.amazon.com.tr/konsolu-mewmewcat-RGB10MAX2-Ta%C5%9F%C4%B1nabilir-Oyuncular/dp/B0C46CZCFX/ref=sr_1_2?__mk_tr_TR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3FIBRULWX0DEF&keywords=Oyun+konsolu%2Cmewmewcat+RGB10MAX2+El+Retro+Oyun+Konsolu+64GB+TF+Kartl%C4%B1+Ta%C5%9F%C4%B1nabilir+Video+Oyun+Oyuncular+22000&qid=1686643675&sprefix=oyun+konsolu+mewmewcat+rgb10max2+el+retro+oyun+konsolu+64gb+tf+kartl%C4%B1+ta%C5%9F%C4%B1nabilir+video+oyun+oyuncular+22000%2Caps%2C114&sr=8-2");
       // driver.findElement(By.cssSelector(".widgetId\\=search-results_1 > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h2:nth-child(1)")).click();
        return this;
    }

    @Step("Click On Add To Cart Button")
    public HomePage clickOnAddToCartButton(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector("input[id='add-to-cart-button']")).click();
        return this;
    }
    @Step("Check Whether The Product Is Added To Cart Or Not")
    public HomePage checkCart(){
        text=driver.findElement(By.xpath("//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span")).getText();
        Assert.assertEquals("Sepete Eklendi",text);
        System.out.println(text);
        return this;

    }

    @Step("Clicks On Forward To Cart To Check The Cart")
    public HomePage clickOnGoToCart(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/span/span/a")).click();
        return this;
    }

    @Step("Empty Cart")
    public HomePage emptyCart(){
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
    @Step("Check Whether The Cart Is Deleted  Or Not")
    public HomePage checkEmptyCart(){
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




}





package Test123;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class TestFunctionality {

    protected static WebDriver driver;

    static String getCurrentDateTime(){

     // create object of simple date format class and decide format
     DateFormat dateformat = new SimpleDateFormat("MMddyyyyHHmmss");
    //get current date time with date()
    Date date=new Date();
    // format for date
    String date1=dateformat.format(date);
    //print the date
     System.out.println("Current date and time is" +date1);
    return date1;}

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src\\test\\java\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        //implicit wait applied to driver instance -which will be applied to driver until driver instance
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //asking driver to get url
        driver.get("https://demo.nopcommerce.com/");
    }
   @Test
    public void UserShouldbeRegisterSuccessfully(){
        //asking for new user
        driver.findElement(By.xpath("//div[2]/div[1]/ul/li[1]/a")).click();
        //firstname
        driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("shivangi");
        //lastname
        driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys("patel");
        //email
        driver.findElement(By.xpath("//*[@id=\'Email\']")).sendKeys("shivangip1"+getCurrentDateTime()+"@test.com");
        //password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("shivangi123");
        //confirmpassword
        driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("shivangi123");
        //click to register button
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
        //get the successfull message
        String actualRegistrationSuccessMessage= driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals("Your registration completed",actualRegistrationSuccessMessage);    }


     @Test
     public void computer() {
        //navigate to computers<<notebooks category page
         driver.findElement(By.linkText("Computers")).click();//navigate to computer

         driver.findElement(By.partialLinkText("Notebooks")).click();//navigate to notebooks

         String message = driver.findElement(By.xpath("//div[@class='page-title']")).getText();

         Assert.assertEquals("Notebooks", message);
         System.out.println(("User should be able to navigate notebook category page"));
     }
     @Test
    public void electronics(){
        //navigate to electronics<<cell phones category page
        driver.findElement(By.linkText("Electronics")).click();//navigate to electronics

        driver.findElement(By.partialLinkText("Cell phones")).click();//navigate to cell phones

        String message = driver.findElement(By.xpath("//div[@class='page-title']")).getText();

        Assert.assertEquals("Cell phones",message);
        System.out.println("User should be able to navigate electronics category page");
     }
     @Test
     public void login(){
        // enter the login detail
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("shivangip@test.com");//enter email

        driver.findElement(By.xpath("//input[@class='password']")).sendKeys("shivangi123");//enter password

        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();

        String message = driver.findElement(By.xpath("//a[@class='ico-logout']")).getText();

        Assert.assertEquals("Log out",message);
        System.out.println("User should be login successfully ");

        
     }
     @Test
    public void shoppingcart(){
        //add product into the basket
        driver.findElement(By.xpath("//input[@value='Add to cart']")).click();//add the product

        String message = driver.findElement(By.xpath("//div[@class='product-name']")).getText();

        Assert.assertEquals("Build your own computer",message);
        System.out.println("User should be able to add products");
        
     }
     @After
    public void closebrowser(){
        driver.quit();
     }
     }  
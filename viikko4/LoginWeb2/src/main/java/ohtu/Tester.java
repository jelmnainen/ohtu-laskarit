package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        
        System.out.println( driver.getPageSource() );
          
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
        driver = initTest("Trying to login with bad password..", driver);
        tryLogin(driver, "pekka", "badPassword");
        
        driver = initTest("Trying to login with bad username...", driver);
        tryLogin(driver, "badUsername", "akkep");

        driver = initTest("Trying to create new user...", driver);
        driver = tryCreatingNewUser(driver, "Johannes", "passw0rd");
        printTestResult(driver.getPageSource());
        
        driver = initTest("Trying to logout after creating user", driver);
        tryLogoutAfterCreatingUser(driver);
        
        
    }
    
    public static void tryLogoutAfterCreatingUser(WebDriver driver){
        driver = tryCreatingNewUser(driver, "eccul4", "hup4isa4");
        
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        printTestResult(driver.getPageSource());
    }
    
    public static WebDriver initTest(String message, WebDriver driver){
        System.out.println(message);
        driver.get("http://localhost:8090");
        return driver;
    }
    
    public static WebDriver tryCreatingNewUser(WebDriver driver, String name, String password){
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys(name);
        
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        
        element = driver.findElement(By.name("add"));
        element.submit();
        
        return driver;
        
    }

    public static void printTestResult(String result){
        System.out.println("The test resulted in page:");
        System.out.println(result);
    }
    
    public static void tryLogin(WebDriver driver, String username, String password){
        System.out.println("Trying to login with proper username but worng password");
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        
        element = driver.findElement(By.name("login"));
        element.submit();
        
        printTestResult(driver.getPageSource());
    }
    
    
}

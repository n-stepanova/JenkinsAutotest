import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JenkinsTest {
    @Test
    public void openJenkins(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.get("http://localhost:8080/");

        WebElement userNameField = driver.findElement(By.xpath("//*[@id=\"j_username\"]"));
        userNameField.sendKeys("admin");

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"j_password\"]"));
        passwordField.sendKeys("123456");


        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/div/form/button"));
        signInButton.click();

        String title = driver.getTitle();
        Assert.assertEquals(title, "ИнфоПанель [Jenkins]");
//        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(d->signInButton.isEnabled());

        driver.quit();
    }
}

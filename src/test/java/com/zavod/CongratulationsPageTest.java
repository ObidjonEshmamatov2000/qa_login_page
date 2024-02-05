package com.zavod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CongratulationsPageTest {

    private ChromeDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void loginTest() {
        // given
        String username = "admin";
        String password = "admin";

        String authURL = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
        driver.get(authURL);

        //when
        String actualHeaderMessage = driver.findElement(By.cssSelector(".example h3")).getText();
        String expectedHeaderMessage = "Basic Auth";

        String actualContentMessage = driver.findElement(By.cssSelector(".example p")).getText();
        String expectedContentMessage = "Congratulations! You must have the proper credentials.";

        //then
        Assert.assertEquals(actualHeaderMessage, expectedHeaderMessage);
        Assert.assertEquals(actualContentMessage, expectedContentMessage);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

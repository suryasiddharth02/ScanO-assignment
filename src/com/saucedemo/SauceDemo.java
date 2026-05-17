package com.saucedemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemo {

    public static void application() throws AWTException, InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        WebElement LoginSec = driver.findElement(By.id("user-name"));
        LoginSec.sendKeys("standard_user");

        WebElement PassSec = driver.findElement(By.id("password"));
        PassSec.sendKeys("secret_sauce");

        WebElement LoginBtn = driver.findElement(By.id("login-button"));
        LoginBtn.click();
        
        Thread.sleep(3000);

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement ProdBtn = driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']"));
        ProdBtn.click();

        WebElement ATCart = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        ATCart.click();

        driver.navigate().back();

        Thread.sleep(2000);

        WebElement ProdBtn1 = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));
        ProdBtn1.click();

        WebElement ATCart1 = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        ATCart1.click();

        driver.navigate().back();

        Thread.sleep(2000);

        WebElement BPack = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        BPack.click();

        WebElement ATCart2 = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        ATCart2.click();

        WebElement CartBtn = driver.findElement(By.className("shopping_cart_link"));
        CartBtn.click();

        WebElement checkBtn = driver.findElement(By.id("checkout"));
        checkBtn.click();

        WebElement FName = driver.findElement(By.id("first-name"));
        FName.sendKeys("Rohit");

        WebElement LName = driver.findElement(By.id("last-name"));
        LName.sendKeys("Sharma");

        WebElement ZCode = driver.findElement(By.id("postal-code"));
        ZCode.sendKeys("600089");

        WebElement ContinueBtn = driver.findElement(By.id("continue"));
        ContinueBtn.click();

        WebElement FinishBtn = driver.findElement(By.id("finish"));
        FinishBtn.click();

        WebElement BTHbtn = driver.findElement(By.id("back-to-products"));
        BTHbtn.click();
    }

    public static void main(String[] args) throws AWTException, InterruptedException {
        application();
    }
}
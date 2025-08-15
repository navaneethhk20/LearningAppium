package org.example;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
    static AppiumDriver driver;
    public static void main(String[] args){
        try {
            openCalculator();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void openCalculator() throws Exception{
        DesiredCapabilities cd = new DesiredCapabilities();
        cd.setCapability("platformName", "Android");
        cd.setCapability("appium:platformVersion", "15");
        cd.setCapability("appium:deviceName", "moto g34 5G");
        cd.setCapability("appium:udid", "192.168.0.148:5555");
        cd.setCapability("appium:automationName", "UiAutomator2");
        cd.setCapability("appium:appPackage", "com.google.android.calculator");
        cd.setCapability("appium:appActivity", "com.android.calculator2.Calculator");

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url, cd);
        System.out.println("Application started");

        WebElement two =driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        WebElement three =driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        WebElement plus =driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        WebElement equals =driver.findElement(By.id("com.google.android.calculator:id/eq"));

        two.click();
        plus.click();
        three.click();
        equals.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calculator:id/result_final")));

        String res = result.getText();
        System.out.println("Result: " + res);
        System.out.println("Completed");


    }
}

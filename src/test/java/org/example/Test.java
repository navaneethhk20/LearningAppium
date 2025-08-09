package org.example;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

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
        cd.setCapability("appium:udid", "ZA222JF6V8");
        cd.setCapability("appium:appPackage", "com.google.android.calculator");
        cd.setCapability("appium:appActivity", "com.android.calculator2.Calculator");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, cd);
        System.out.println("Application started");

    }
}

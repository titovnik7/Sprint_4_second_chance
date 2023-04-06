package model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final By CREATE_ORDER_BUTTON_TOP = By.xpath(".//button[@class = 'Button_Button__ra12g']");
    public static final By CREATE_ORDER_BUTTON_BOTTOM = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(PAGE_URL);
    }


    public void clickCreateOrderButton(boolean isButtonTop) {
        if (isButtonTop) {
            driver.findElement(CREATE_ORDER_BUTTON_TOP).click();
        } else {
            WebElement element = driver.findElement(CREATE_ORDER_BUTTON_BOTTOM);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(CREATE_ORDER_BUTTON_BOTTOM).click();
        }
    }
    public void checkAnswer(String number) {
        WebElement element = driver.findElement(By.xpath(".//div[@class='Home_FourPart__1uthg']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id("accordion__heading-" + number)).click();
        driver.findElement(By.id("accordion__panel-" + number)).isDisplayed();
    }
}
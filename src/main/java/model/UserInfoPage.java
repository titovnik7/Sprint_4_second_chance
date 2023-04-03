package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserInfoPage {
    public static final By NAME_FIELD = By.xpath(".//input[@placeholder = '* Имя']");
    public static final By SURNAME_FIELD = By.xpath(".//input[@placeholder = '* Фамилия']");
    public static final By ADDRESS_FIELD = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    public static final By METRO_STATION_FIELD = By.xpath(".//input[@placeholder = '* Станция метро']");
    public static final By PHONE_NUMBER_FIELD = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    public static final By NEXT_BUTTON = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    private final WebDriver driver;
    public UserInfoPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUserName(String userName) {
        driver.findElement(NAME_FIELD).sendKeys(userName);
    }
    public void enterUserSurname(String userSurname) {
        driver.findElement(SURNAME_FIELD).sendKeys(userSurname);
    }
    public void enterUserAddress(String userAddress) {
        driver.findElement(ADDRESS_FIELD).sendKeys(userAddress);
    }
    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(PHONE_NUMBER_FIELD).sendKeys(phoneNumber);
    }
    public void enterMetroStation() {
        driver.findElement(METRO_STATION_FIELD).click();
        driver.findElement(By.xpath(".//*[text()='Сокольники']")).click();
    }
    public void clickNextButton() {
        driver.findElement(NEXT_BUTTON).click();
    }
}
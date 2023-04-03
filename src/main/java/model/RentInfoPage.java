package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentInfoPage {
    public static final By  DATE_FIELD = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    public static final By  DURATION_DROPDOWN = By.xpath(".//span[@class = 'Dropdown-arrow']");
    public static final By  BLACK_COLOUR_SCOOTER = By.id("black");
    public static final By  GREY_COLOUR_SCOOTER = By.id("grey");
    public static final By  COMMENT_FIELD = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    public static final By  ORDER_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    public static final By CONFIRMATION_BUTTON = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    public static final By ORDER_DONE = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']");
    private final WebDriver driver;
    public RentInfoPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterDate(String rentDate) {
        driver.findElement(DATE_FIELD).sendKeys(rentDate);
    }
    public void enterDuration() {
        driver.findElement(DURATION_DROPDOWN).click();
        driver.findElement(By.xpath(".//*[text() = 'двое суток']")).click();
    }
    public void chooseColour() {
        driver.findElement(BLACK_COLOUR_SCOOTER).click();
    }
    public void addComment(String comment) {
        driver.findElement(COMMENT_FIELD).sendKeys(comment);
    }
    public void makeAnOrder() {
        driver.findElement(ORDER_BUTTON).click();
    }
    public void confirmOrder() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(CONFIRMATION_BUTTON));
        driver.findElement(CONFIRMATION_BUTTON).click();
    }
    public boolean checkSuccessOfTheOrder() {
        return driver.findElement(ORDER_DONE).isDisplayed();
    }
}
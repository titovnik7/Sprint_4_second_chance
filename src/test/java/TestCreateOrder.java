import model.MainPage;
import model.RentInfoPage;
import model.UserInfoPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class TestCreateOrder {
    private WebDriver  driver;
    private final boolean isButtonTop;
    private final String userName;
    private final String userSurname;
    private final String userAddress;
    private final String phoneNumber;
    private final String orderDate;
    private final String comment;

    public TestCreateOrder(boolean isButtonTop, String userName, String userSurname, String userAddress, String phoneNumber, String orderDate, String comment) {
        this.isButtonTop = isButtonTop;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAddress = userAddress;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {

        return new Object[][] {
                {true, "Никита", "Титов", "улица Ленина", "89999999999", "01.04.2023", "позвоните за 30 мин"},
                {false, "Анна", "Петрова", "улица Пушкина", "88888888888", "31.03.2023", " "},
        };
    }
    @Before
    public void setup() {
        driver = new ChromeDriver();
    }
    @Test
    public void checkCreatingNewOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickCreateOrderButton(isButtonTop);
        UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage.enterUserName(userName);
        userInfoPage.enterUserSurname(userSurname);
        userInfoPage.enterUserAddress(userAddress);
        userInfoPage.enterMetroStation();
        userInfoPage.enterPhoneNumber(phoneNumber);
        userInfoPage.clickNextButton();
        RentInfoPage rentInfoPage = new RentInfoPage(driver);
        rentInfoPage.enterDate(orderDate);
        rentInfoPage.enterDuration();
        rentInfoPage.chooseColour();
        rentInfoPage.addComment(comment);
        rentInfoPage.makeAnOrder();
        rentInfoPage.confirmOrder();
        Assert.assertTrue(rentInfoPage.checkSuccessOfTheOrder());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
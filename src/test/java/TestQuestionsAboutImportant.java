import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestQuestionsAboutImportant {
    private WebDriver driver;
    private final String number;
    public TestQuestionsAboutImportant(String number) {
        this.number = number;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {

        return new Object[][] {
                {"0"},
                {"1"},
                {"2"},
                {"3"},
                {"4"},
                {"5"},
                {"6"},
                {"7"},
        };
    }@Before
    public void setup() {
        driver = new ChromeDriver();
    }
    @Test
    public void checkQuestionsAboutImportant() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        //mainPage.checkQuestionAndAnswer(question);
        //driver.findElement(By.xpath(".//p[text()='" + answer + "']")).isDisplayed();
        mainPage.checkAnswer(number);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
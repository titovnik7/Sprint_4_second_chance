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
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestQuestionsAboutImportant {
    private WebDriver driver;
    private final String question;
    private final String answer;
    private final boolean isMatched;
    public TestQuestionsAboutImportant(String question, String answer, boolean isMatched) {
        this.question = question;
        this.answer=answer;
        this.isMatched=isMatched;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {

        return new Object[][] {
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", true},
                {"Хочу сразу несколько самокатов! Так можно?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", false},
        };
    }@Before
    public void setup() {
        driver = new ChromeDriver();
    }
    @Test
    public void checkQuestionsAboutImportant() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.checkQuestionAndAnswer(question);
        WebElement expectedAnswer = driver.findElement(By.xpath(".//p[text()='" + answer + "']"));
        assertEquals(isMatched, expectedAnswer.isDisplayed());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
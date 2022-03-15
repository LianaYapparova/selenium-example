import com.google.common.io.Resources;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import simple.page.LoginPage;
import simple.WebDriverFactory;

public class RamblerTest {

    private static final String LOGIN = "lianayapparova@rambler.ru";
    private static final String PASSWORD = "Tagir2012";
    private ThreadLocal<WebDriver> driver =  new ThreadLocal<>();



    @BeforeEach
    public void createDriver(){
        driver.set(WebDriverFactory.getWebDriver());
        driver.get().manage().window().maximize();
    }

    @AfterEach
    public void disposeDriver(){
        if(driver!=null){
            driver.get().quit();
        }
    }


    @Test
    public void login() throws InterruptedException {
        Assertions.assertTrue(
                new LoginPage(driver.get())
                        .loginAs(LOGIN, PASSWORD)
                        .isLoggedIn(LOGIN)
        );

    }

    @Test
    public void openProfile() throws InterruptedException {
        Assertions.assertTrue(
                new LoginPage(driver.get())
                        .loginAs(LOGIN, PASSWORD)
                        .openProfile()
                        .isProfileOpened()
        );
    }


}

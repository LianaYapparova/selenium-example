package simple.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private By enterButton = By.xpath("//*[@class='rui__1E3a7']");
    private By frame = By.xpath("//div[@data-id-frame]/iframe");
    private By loginField = By.id("login");
    private By passwordField = By.id("password");
    private By enterButtonFrame = By.xpath("//*[@class='rui-Button-content']");
    private By nameField = By.cssSelector("span.rui__1E3a7");

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
        waitAndClick(enterButton);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(frame));
        driver.switchTo().frame(driver.findElement(frame));
        waitVisibility(loginField);
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage typeLogin(String email) {
        driver.findElement(loginField).sendKeys(email);
        return this;
    }

    public SearchPage clickLogin() {
        waitAndClick(enterButtonFrame);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
        return new SearchPage(driver);
    }

    public SearchPage loginAs(String email, String password){
        typeLogin(email);
        typePassword(password);
        return clickLogin();
    }
}

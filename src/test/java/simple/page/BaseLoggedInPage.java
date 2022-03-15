package simple.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class BaseLoggedInPage extends BasePage {

    private By profileLink = By.xpath("//a[text()='Мой профиль']");
    private By nameField = By.cssSelector("span.rui__1E3a7");

    public BaseLoggedInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedIn(String login) {
        try{
            return waitVisibility(nameField).getText().equals(login);
        } catch (NoSuchElementException e){
            e.printStackTrace();
            return false;
        }
    }

    public ProfilePage openProfile(){
        waitAndClick(nameField);
        waitAndClick(profileLink);
        switchToAnotherTab();
        return new ProfilePage(driver);
    }
}

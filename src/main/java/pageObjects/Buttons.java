package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Buttons {

    public Buttons (AndroidDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@text=\"Move to trash\" or @label=\"Move to trash\"]")
                private WebElement moveToTrash;

    public WebElement getMoveToTrash() {
        System.out.println("Searching for button move to trash");
        return moveToTrash;
    }
}

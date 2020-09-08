package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EmptyStates {

    public EmptyStates (AndroidDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.nordpass.android.app.password.manager:id/addItemButton")
    private WebElement addItemButton;

    public WebElement getAddItemButton()
    {
        System.out.println("Searching for addItemButton");
        return addItemButton;
    }



}

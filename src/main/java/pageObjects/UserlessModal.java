package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UserlessModal {

    public UserlessModal(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy (id = "com.nordpass.android.app.password.manager:id/protectButton")
    private WebElement CreateAccountAccountless;
    public WebElement getCreateAccountAccountless()
    {
        System.out.println("Searching for Crate Account button");
        return CreateAccountAccountless;
    }

    @AndroidFindBy (id = "com.nordpass.android.app.password.manager:id/skipButton")
    private WebElement SkipCreateAccountAccountless;
    public WebElement getSkipCreateAccountAccountless()
    {
        System.out.println("Searching for Skip Crate Account button");
        return SkipCreateAccountAccountless;
    }




}

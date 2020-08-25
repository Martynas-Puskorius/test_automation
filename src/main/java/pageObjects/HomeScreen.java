package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen {


    public HomeScreen(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Home")
    private WebElement Home;

    public WebElement getHome()
    {
        System.out.println("Searching for Home button");
        return Home;
    }

    @AndroidFindBy(accessibility = "Browse")
    private WebElement Browse;

    public WebElement getBrowse()
    {
        System.out.println("Searching for Browse button");
        return Browse;
    }

    @AndroidFindBy(accessibility = "Menu")
    private WebElement Menu;

    public WebElement getMenu()
    {
        System.out.println("Searching for Menu button");
        return Menu;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/loginButton")
    private WebElement LoginButton;

    public WebElement getLoginButton()
    {
        System.out.println("Searching for Browse button");
        return LoginButton;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/addItemButton")
    private WebElement AddItemButton;

    public WebElement getAddItemButton()
    {
        System.out.println("Searching for Add Item button");
        return AddItemButton;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/importButton")
    private WebElement ImportButton;

    public WebElement getImportButton()
    {
        System.out.println("Searching for Import button");
        return ImportButton;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/search")
    private WebElement SearchField;

    public WebElement getSearchField()
    {
        System.out.println("Searching for Import button");
        return SearchField;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/clickableLoginView")
    private WebElement AddLogin;

    public WebElement getAddLogin()
    {
        System.out.println("Searching for AddLogin button");
        return AddLogin;
    }


}




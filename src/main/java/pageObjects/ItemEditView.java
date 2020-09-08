package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ItemEditView {

    public ItemEditView(AndroidDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/noteTitle")
    private WebElement noteTitleField;

    public WebElement getNoteTitleField()
    {
        System.out.println("Searching for NoteTitleField");
        return noteTitleField;
    }

    @AndroidFindBy(id="com.nordpass.android.app.password.manager:id/note")
    private WebElement noteField;

    public WebElement getNoteField()
    {
        System.out.println("Searching for Note Field");
        return noteField;
    }
}

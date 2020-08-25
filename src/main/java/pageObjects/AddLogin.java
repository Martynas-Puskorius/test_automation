package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddLogin {

    public AddLogin(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Done")
    private WebElement Done;

    public WebElement getDone() {
        System.out.println("Searching for Done button");
        return Done;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/passwordTitle")
    private WebElement PasswordTitle;

    public WebElement getPasswordTitle() {
        System.out.println("Searching for Password Title");
        return PasswordTitle;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/username")
    private WebElement Username;

    public WebElement getUsername() {
        System.out.println("Searching for Username field");
        return Username;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/password")
    private WebElement Password;

    public WebElement getPassword() {
        System.out.println("Searching for Password field");
        return Password;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/website")
    private WebElement Website;

    public WebElement getWebsite() {
        System.out.println("Searching for Website field");
        return Website;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/dropdownTitle")
    private WebElement FolderDropDown;

    public WebElement getFolderDropDown() {
        System.out.println("Searching for FolderDropDown");
        return FolderDropDown;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/addNew")
    private WebElement AddNewFolderDropDown;

    public WebElement getAddNewFolderDropDown() {
        System.out.println("Searching for Add New Folder DropDown");
        return AddNewFolderDropDown;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/folderName")
    private WebElement AddNewFolderDropDownName;

    public WebElement getAddNewFolderDropDownName() {
        System.out.println("Searching for Add New Folder DropDown Name");
        return AddNewFolderDropDownName;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/saveButton")
    private WebElement AddNewFolderDropDownSave;

    public WebElement getAddNewFolderDropDownSave() {
        System.out.println("Searching for save button");
        return AddNewFolderDropDownSave;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/cancelButton")
    private WebElement AddNewFolderDropDownCancel;

    public WebElement getAddNewFolderDropDownCancel() {
        System.out.println("Searching for Add New Folder DropDown Cancel");
        return AddNewFolderDropDownCancel;
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]")
    private WebElement SelectFolderDropDown;

    public WebElement getSelectFolderDropDown() {
        System.out.println("Searching for Select Folder DropDown 2");
        return SelectFolderDropDown;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/dropDown")
    private WebElement AddNewFolderDropDownClose;

    public WebElement getAddNewFolderDropDownClose() {
        System.out.println("Searching for Add New Folder DropDown Close");
        return AddNewFolderDropDownClose;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/note")
    private WebElement NoteField;

    public WebElement getNoteField() {
        System.out.println("Searching for Note field");
        return NoteField;
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton\n")
    private WebElement Back;

    public WebElement getBack() {
        System.out.println("Searching for Back Button");
        return Back;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/snackbar_text")
    private WebElement Snackbar_text;

    public WebElement getSnackbar_text() {
        System.out.println("Search for Snackbar text");
        return Snackbar_text;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/snackbar_action")
    private WebElement Snackbar_action;

    public WebElement getSnackbar_action()
    {
        System.out.println("Search for Snackbar action");
        return Snackbar_action;
    }

    @AndroidFindBy(xpath= "//android.widget.TextView[contains(@text, 'Testas 1')]")
    private WebElement LocateLoginItem;

    public WebElement getLocateLoginItem()
    {
        System.out.println("Search for Item named Testas 1");
        return LocateLoginItem;
    }

    @AndroidFindBy(id = "com.nordpass.android.app.password.manager:id/more")
    private WebElement ItemSettingsMore;

    public WebElement getItemSettingsMore()
    {
        System.out.println("Searching for item settings");
        return ItemSettingsMore;
    }

    @AndroidFindBy(xpath= "//android.widget.TextView[contains(@text, 'Edit')]")
    private WebElement EnterItemEdit;

    public WebElement getEnterItemEdit()
    {
        System.out.println("Search for Edit button");
        return EnterItemEdit;
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'None')]")
    private WebElement SelectNoneFolder;
    public WebElement getSelectNoneFolder()
    {
        System.out.println("Searching for none folder");
        return SelectNoneFolder;
    }




}

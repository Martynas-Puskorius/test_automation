package practise;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

public class SecureNoteItem_Create_Edit_Delete extends Base {

    @BeforeMethod
    public void killAllNodes() throws IOException, InterruptedException
    {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
    }

    @Test(invocationCount = 1)
            public void SecureNoteTest() throws Exception
    {
        //Setup environment
        service = startServer();
        AndroidDriver<AndroidElement> driver = capabilities("NordPassApp");
        HomeScreen homeScreen = new HomeScreen(driver);
        Browse browse = new Browse(driver);
        EmptyStates emptyStates = new EmptyStates(driver);
        ItemEditView itemEditView = new ItemEditView(driver);
        AddLogin addLogin = new AddLogin(driver);
        Utilities utilities = new Utilities(driver);
        UserlessModal userlessModal = new UserlessModal(driver);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.nordpass.android.app.password.manager:id/addItemButton")));

        homeScreen.getBrowse().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]")));
        doVisualCheck("Start");
        browse.getAllSecureNotes().click();
        emptyStates.getAddItemButton().click();
        itemEditView.getNoteTitleField().click();
        driver.isKeyboardShown();
        itemEditView.getNoteTitleField().sendKeys("This secure note text is 51 characters looooooooong");
        driver.hideKeyboard();
        doVisualCheck("Secure Note title enter");
        itemEditView.getNoteField().click();
        itemEditView.getNoteField().sendKeys("**hey**\n" +
                "_italics_\n" +
                "`code`\n" +
                "```preformatted```\n" +
                ">quote\n"+
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ac libero in metus ullamcorper tincidunt. Aliquam hendrerit, ipsum eget auctor ultrices, nibh massa ultricies lacus, sed sollicitudin sapien dolor et turpis. Integer nec lacus vitae justo gravida gravida. Quisque tempor ex luctus iaculis pretium. Pellentesque lectus mi, pellentesque vel sem vitae, semper tristique tortor. Fusce et convallis magna, rhoncus accumsan enim. Curabitur non egestas orci. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus tincidunt dolor ut convallis efficitur. Praesent hendrerit porttitor turpis. Praesent vel lectus fringilla, imperdiet velit ac, elementum dolor. Sed varius orci et ex imperdiet sodales. Nullam finibus dignissim nisi vel fringilla. Donec nec cursus urna, vitae malesuada purus. Ut vel sapien nec ex condimentum tincidunt a in felis. Pellentesque ac egestas mi.");
        Thread.sleep(1000);
        doVisualCheck("Note field enter");
        driver.hideKeyboard();
        addLogin.getFolderDropDown().click();
        Thread.sleep(1000);
        doVisualCheck("Folder_dropdown");
        addLogin.getAddNewFolderDropDown().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.nordpass.android.app.password.manager:id/cancelButton")));
        doVisualCheck("Add_new_folder");
        addLogin.getAddNewFolderDropDownName().sendKeys("Work Folder");
        addLogin.getAddNewFolderDropDownSave().click();
        String SnackbarText = addLogin.getSnackbar_text().getText();
        Assert.assertEquals(SnackbarText, "Folder created successfully");
        addLogin.getSnackbar_action().click();
        driver.hideKeyboard();
        Thread.sleep(500);
        doVisualCheck("Folder created");
        utilities.scrollToBottom();
        doVisualCheck("Bottom of edit view");

        addLogin.getDone().click();
        doVisualCheck("Accountles password protection");
        userlessModal.getSkipCreateAccountAccountless().click();

        browse.getLocateSecureNoteItem().click();
        doVisualCheck("Item view top");
        utilities.scrollToBottom();
        doVisualCheck("Item view bottom");
        addLogin.getItemSettingsMore().click();
        addLogin.getEnterItemEdit().click();
        doVisualCheck("Edit view");

        itemEditView.getNoteTitleField().click();
        itemEditView.getNoteTitleField().sendKeys("!@#$%^&*()_+{}:\"|?><|`1234567890-=[];'\\,./\\_Secure note title");












    }
}

package practise;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AddLogin;
import pageObjects.HomeScreen;
import pageObjects.UserlessModal;

import java.io.IOException;
public class AppTest extends Base{

/*
    @Test(dataProvider = "Input Data", dataProviderClass = TestData.class)
    public void ClickOnMenu(String input) throws IOException, InterruptedException {

        service=startServer();
        AndroidDriver<AndroidElement> driver=capabilities("NordPassApp");
        HomeScreen homeScreen = new HomeScreen(driver);
        homeScreen.getMenu().click();
        System.out.println(input);
        //service.stop();
    }
 */

    //Create item inside accountless vault
    @Test(invocationCount = 1)
    public void CreateLoginItemAccountless() throws Exception {

        service=startServer();
        AndroidDriver<AndroidElement> driver=capabilities("NordPassApp");
        HomeScreen homeScreen = new HomeScreen(driver);
        AddLogin addLogin = new AddLogin(driver);

        //Enter item creation screen
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.nordpass.android.app.password.manager:id/addItemButton")));
        homeScreen.getAddItemButton().click();
        homeScreen.getAddLogin().click();

        //Filling Title field
        addLogin.getPasswordTitle().click();
        boolean isKeyboardShown = driver.isKeyboardShown();
        addLogin.getPasswordTitle().sendKeys("Testas 1");
        String PasswordTitleText = addLogin.getPasswordTitle().getText();
        Assert.assertEquals(PasswordTitleText, "Testas 1");
        driver.hideKeyboard();
        Thread.sleep(500);
        doVisualCheck("PasswordTitleText");

        //Filling Username field
        addLogin.getUsername().click();
        driver.isKeyboardShown();
        addLogin.getUsername().sendKeys("Vartotojas 1");
        String UsernameText = addLogin.getUsername().getText();
        Assert.assertEquals(UsernameText,"Vartotojas 1");
        driver.hideKeyboard();
        doVisualCheck("Username");

        //Filling Password field
        addLogin.getPassword().click();
        addLogin.getPassword().sendKeys("Slaptazodis1234567890{}|?><zXzxcdf");
        String Password = addLogin.getPassword().getText();
        Assert.assertEquals(Password, "Slaptazodis1234567890{}|?><zXzxcdf");
        driver.hideKeyboard();
        doVisualCheck("Password");

        //Filling Website field
        addLogin.getWebsite().click();
        driver.isKeyboardShown();
        addLogin.getWebsite().sendKeys("example-site.com");
        String WebsiteText = addLogin.getWebsite().getText();
        Assert.assertEquals(WebsiteText,"example-site.com");
        driver.hideKeyboard();
        doVisualCheck("Website");

        //Adding to new folder
        addLogin.getFolderDropDown().click();
        Thread.sleep(1000);
        doVisualCheck("Folder_dropdown");
        addLogin.getAddNewFolderDropDown().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.nordpass.android.app.password.manager:id/cancelButton")));
        doVisualCheck("Add_new_folder");
        addLogin.getAddNewFolderDropDownName().sendKeys("Work Folder");
        addLogin.getAddNewFolderDropDownSave().click();
        String SnackbarText = addLogin.getSnackbar_text().getText();
        Assert.assertEquals(SnackbarText,"Folder created successfully");
        addLogin.getSnackbar_action().click();
        driver.hideKeyboard();
        Thread.sleep(500);
        doVisualCheck("Folder created");

        //Filling note field
        addLogin.getNoteField().click();
        driver.isKeyboardShown();
        addLogin.getNoteField().sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ac libero in metus ullamcorper tincidunt. Aliquam hendrerit, ipsum eget auctor ultrices, nibh massa ultricies lacus, sed sollicitudin sapien dolor et turpis. Integer nec lacus vitae justo gravida gravida. Quisque tempor ex luctus iaculis pretium. Pellentesque lectus mi, pellentesque vel sem vitae, semper tristique tortor. Fusce et convallis magna, rhoncus accumsan enim. Curabitur non egestas orci. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus tincidunt dolor ut convallis efficitur. Praesent hendrerit porttitor turpis. Praesent vel lectus fringilla, imperdiet velit ac, elementum dolor. Sed varius orci et ex imperdiet sodales. Nullam finibus dignissim nisi vel fringilla. Donec nec cursus urna, vitae malesuada purus. Ut vel sapien nec ex condimentum tincidunt a in felis. Pellentesque ac egestas mi.");
        String NoteFieldText = addLogin.getNoteField().getText();
        Assert.assertEquals(NoteFieldText,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ac libero in metus ullamcorper tincidunt. Aliquam hendrerit, ipsum eget auctor ultrices, nibh massa ultricies lacus, sed sollicitudin sapien dolor et turpis. Integer nec lacus vitae justo gravida gravida. Quisque tempor ex luctus iaculis pretium. Pellentesque lectus mi, pellentesque vel sem vitae, semper tristique tortor. Fusce et convallis magna, rhoncus accumsan enim. Curabitur non egestas orci. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus tincidunt dolor ut convallis efficitur. Praesent hendrerit porttitor turpis. Praesent vel lectus fringilla, imperdiet velit ac, elementum dolor. Sed varius orci et ex imperdiet sodales. Nullam finibus dignissim nisi vel fringilla. Donec nec cursus urna, vitae malesuada purus. Ut vel sapien nec ex condimentum tincidunt a in felis. Pellentesque ac egestas mi.");
        driver.hideKeyboard();
        Thread.sleep(500);
        doVisualCheck("Note Field");

        //Save item
        addLogin.getDone().click();

        //Skip account creation
        doVisualCheck("Accountles password protection");
        UserlessModal userlessModal = new UserlessModal(driver);
        userlessModal.getSkipCreateAccountAccountless().click();

        //Edit Item

        //Enter item edit screen
        addLogin.getLocateLoginItem().click();
        addLogin.getItemSettingsMore().click();
        addLogin.getEnterItemEdit().click();
        doVisualCheck("Edit view");

        //Enter long Title length
        addLogin.getPasswordTitle().click();
        addLogin.getPasswordTitle().sendKeys("Test 01234567890123456789012345678901234567890123456789");
        PasswordTitleText = addLogin.getPasswordTitle().getText();
        Assert.assertEquals(PasswordTitleText, "Test 01234567890123456789012345678901234567890123456789");
        driver.hideKeyboard();
        doVisualCheck("Edit PasswordTitleText");

        //Edit username
        addLogin.getUsername().click();
        driver.isKeyboardShown();
        addLogin.getUsername().sendKeys("Vartotojas 01234567890123456789012345678901234567890123456789");
        UsernameText = addLogin.getUsername().getText();
        Assert.assertEquals(UsernameText,"Vartotojas 01234567890123456789012345678901234567890123456789");
        driver.hideKeyboard();
        doVisualCheck("Edit Username");

        //Edit password
        addLogin.getPassword().click();
        addLogin.getPassword().sendKeys("Slaptazodis01234567890123456789012345678901234567890123456789");
        Password = addLogin.getPassword().getText();
        Assert.assertEquals(Password, "Slaptazodis01234567890123456789012345678901234567890123456789");
        driver.hideKeyboard();
        doVisualCheck("Edit Password");

        //Edit website
        addLogin.getWebsite().click();
        driver.isKeyboardShown();
        addLogin.getWebsite().sendKeys("01234567890123456789012345678901234567890123456789example-site.com");
        WebsiteText = addLogin.getWebsite().getText();
        Assert.assertEquals(WebsiteText,"01234567890123456789012345678901234567890123456789example-site.com");
        driver.hideKeyboard();
        doVisualCheck("Edit Website");

        //Select folder None
        addLogin.getFolderDropDown().click();
        Thread.sleep(1000);
        doVisualCheck("Edit Folder_dropdown");
        addLogin.getSelectNoneFolder().click();
        doVisualCheck("Selected None folder");
        driver.hideKeyboard();
        Thread.sleep(500);
        addLogin.getAddNewFolderDropDownClose();
        doVisualCheck("Finish with none folder");

        //Edit note field
        addLogin.getNoteField().click();
        driver.isKeyboardShown();
        addLogin.getNoteField().sendKeys("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur? At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur? At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.Sed ut");
        NoteFieldText = addLogin.getNoteField().getText();
        Assert.assertEquals(NoteFieldText,"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur? At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur? At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.Sed ut");
        driver.hideKeyboard();
        Thread.sleep(500);
        doVisualCheck("Edit Note Field");



        //Save item
        addLogin.getDone().click();

        //Final Visual Check
        doVisualCheck("Edit Final UP");

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"asperiores repellat.Sed ut\"));");

        doVisualCheck("Edit Final DOWN");

        service.stop();
}



    @BeforeMethod
    public void killAllNodes() throws IOException, InterruptedException
    {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
    }

}



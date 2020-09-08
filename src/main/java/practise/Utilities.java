package practise;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Utilities {

    AndroidDriver driver;

    public Utilities (AndroidDriver<AndroidElement> driver)
    {
        this.driver=driver;
    }

    public void scrollToBottom() throws IOException {
        for(int i=0; i<=10; i++)
        {
            int windowSize = (driver.manage().window().getSize().getHeight()) - 200;
            TouchAction ts = new TouchAction(driver);
            ts.press(PointOption.point(10, windowSize));
            ts.moveTo(PointOption.point(10, 0)).release().perform();
            File foto1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            windowSize = (driver.manage().window().getSize().getHeight()) - 200;
            ts.press(PointOption.point(10, windowSize));
            ts.moveTo(PointOption.point(10, 0)).release().perform();
            File foto2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            SimilarityMatchingResult res = driver.getImagesSimilarity(foto1, foto2);
            if (res.getScore() > 0.999)
            {
                break;
            }
        }

    }
/*
    public void scrollToText()
    {
        String country = "asperiores repellat.Sed ut";
        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"" + country + "\"))"));
    }

*/


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


}

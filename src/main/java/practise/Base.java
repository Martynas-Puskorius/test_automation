package practise;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base
{
    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement> driver;

    public static AppiumDriverLocalService startServer ()
    {
        boolean flag = checkIfServerIsRunnning(4723);
        if(!flag)
        {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
            return service;

    }

    public static boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);

            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static void startEmulator() throws IOException, InterruptedException {
        Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
        Thread.sleep(6000);

    }

    public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\global.properties");
        Properties prop = new Properties();
        prop.load(fis);

        File appDir = new File("src");
        File app = new File(appDir, (String) prop.get(appName));
        DesiredCapabilities dc = new DesiredCapabilities();
        //String device = (String) prop.get("device");
        String device  = System.getProperty("deviceName");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        if(device.contains("emulator"))
        {
            startEmulator();
        }
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.nordpass.android.app.password.manager");
        dc.setCapability("appActivity", "com.nordpass.android.ui.splash.SplashActivity");
        dc.setCapability("noReset", "false");
        dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<>(url, dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public static void getScreenshot(String s) throws IOException
    {
        File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrfile,new File("C:\\Users\\T1170\\Desktop\\Fail\\"+s+".png"));
    }
    public static void doVisualCheck(String checkName) throws Exception {
        double MATCH_THRESHOLD = 0.995;
        String baselineFilename = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\VisualCheck\\" + "BASELINE_" + checkName + ".png";
        File baselineImg = new File(baselineFilename);

        // If no baseline image exists for this check, we should create a baseline image
        if (!baselineImg.exists()) {
            System.out.println(String.format("No baseline found for '%s' check; capturing baseline instead of checking", checkName));
            File newBaseline = driver.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(newBaseline, new File(baselineFilename));
            return;
        }

        // Otherwise, if we found a baseline, get the image similarity from Appium. In getting the similarity,
        // we also turn on visualization so we can see what went wrong if something did.
        SimilarityMatchingOptions opts = new SimilarityMatchingOptions();
        opts.withEnabledVisualization();
        SimilarityMatchingResult res = driver.getImagesSimilarity(baselineImg, driver.getScreenshotAs(OutputType.FILE), opts);

        // If the similarity is not high enough, consider the check to have failed
        if (res.getScore() < MATCH_THRESHOLD) {
            File failViz = new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\VisualCheck\\" + "\\FAIL_" + checkName + ".png");
            res.storeVisualization(failViz);
            throw new Exception(
                    String.format("Visual check of '%s' failed; similarity match was only %f, and below the threshold of %f. Visualization written to %s.",
                            checkName, res.getScore(), MATCH_THRESHOLD, failViz.getAbsolutePath()));
        }

        // Otherwise, it passed!
        System.out.println(String.format("Visual check of '%s' passed; similarity match was %f",
                checkName, res.getScore()));
    }






}

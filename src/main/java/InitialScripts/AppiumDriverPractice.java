package InitialScripts;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumDriverPractice {
   public AppiumDriverLocalService service;
    AndroidDriver driver;

@BeforeMethod(alwaysRun = true)
    public AndroidDriver initDriver() throws MalformedURLException, InterruptedException {

        // Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("RNRmobileplay");
        options.setApp(System.getProperty("user.dir") + "/src/resources/ApiDemos-debug.apk");
//        System.out.println(System.getProperty("user.dir")+"/src/resources/ApiDemos-debug.apk");
// appium service initiation
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Raveendra\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(600)).build();
            service.start();

//main.js path C:\Users\Raveendra\AppData\Roaming\npm\node_modules\appium\build\lib\main.js
        // Android driver initialization
         driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
return driver;

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws InterruptedException {

           Thread.sleep(5000);
            driver.quit();
            service.stop();
        }


}

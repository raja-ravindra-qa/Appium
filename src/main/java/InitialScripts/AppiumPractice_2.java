package InitialScripts;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumPractice_2 extends AppiumDriverPractice{

    @Test
    public void Rotate() throws InterruptedException {
        //here the important locators are
        //Xpath, classname,id, accebilityId, androidUIAutomator

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click(); // accessible id --3. Preference dependencies

        // Screen rotation
        DeviceRotation landscape=new DeviceRotation(0,0,90);
        driver.rotate(landscape);

        driver.findElement(By.id("android:id/checkbox")).click();//id -- android:id/checkbox
        driver.findElements(By.xpath("//android.widget.RelativeLayout")).get(1).click();

        String text = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/alertTitle']")).getText();
        Assert.assertEquals(text, "WiFi settings");

        // Screen rotation
//        DeviceRotation landscape2=new DeviceRotation(0,0,0);
//        driver.rotate(landscape2);
        //Copy and paste the String
        String stringValue="Ravindra is set in clipBoard";
        driver.setClipboardText("stringValue");


String clipText=driver.getClipboardText();
Assert.assertEquals(clipText, stringValue);

        driver.findElement(By.id("android:id/edit")).sendKeys(clipText);
        Thread.sleep(3000);
//        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.findElement(By.id("android:id/button1")).click();
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        Thread.sleep(5000);
    }

    @Test
    public void directActivityTesting(){
// to directly launch in the activity
        // to see the live device in system ---> adb devices
        // for windows -->  adb shell dumpsys window | find "mCurrentFocus"
        //for Mac --> adb shell dumpsys window | grep -E 'mCurrentFocus'


    }

    @Test
    public void toastMessageValidation(){
// how to verify the toast message
        //it should contain the tag name---> //android.widget.Toast and it should contains the attribute name



    }
}

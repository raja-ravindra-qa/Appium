package InitialScripts;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AppiumPractice_1 extends AppiumDriverPractice {

    @Test
    public void navigateWithClicks() throws MalformedURLException, InterruptedException {
        //here the important locators are
        //Xpath, classname,id, accebilityId, androidUIAutomator

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click(); // accessible id --3. Preference dependencies
        driver.findElement(By.id("android:id/checkbox")).click();//id -- android:id/checkbox
        driver.findElements(By.xpath("//android.widget.RelativeLayout")).get(1).click();
        String text = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/alertTitle']")).getText();
        Assert.assertEquals(text, "WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("R.RaveendraNath");
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(5000);
    }

    @Test
    public void longPress() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        //long press
        WebElement people = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) people).getId(), "duration", 2000));

    }

    @Test
    public void scrollByUiAutomator() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));

    }

//    @Test
//    public void scrollByappium() throws InterruptedException {
//        boolean canScrollMore;
//        driver.findElement(AppiumBy.accessibilityId("Views")).click();
//
//
//        do {
//            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//                    "left", 750, "top", 350, "width", 1440, "height", 2560,
//                    "direction", "down",
//                    "percent", 3.0
//            ));
//        } while (canScrollMore);
//        Thread.sleep(15000);
//    }

    @Test
    public void swipe() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
        WebElement firstPhoto = driver.findElement(By.xpath("//android.widget.ImageView[1]"));

        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) firstPhoto).getId(),
                "direction", "left",
                "percent", 1 // it should be inbetween 0-1
        ));
    }


    @Test
    public void dragAndDrop() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement initEle = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) initEle).getId(),
                "endX", 850,
                "endY", 750
        ));

    }


}

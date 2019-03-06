package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class ScreenshotListener extends TestListenerAdapter{
@Override
public void onTestFailure(ITestResult tr){
AppiumDriver driver = Screenshot.getDriver();
File location = new File("screenshots1"); //在默认的工作目录下面创建一个名字叫screenshots1的文件夹，用来存放图片的
String screenShotName = location.getAbsolutePath()+File.separator+tr.getMethod().getMethodName()+".png"; // 
File screenShot = driver.getScreenshotAs(OutputType.FILE);
try{
FileUtils.copyFile(screenShot, new File(screenShotName));	
}
catch(IOException e){
e.printStackTrace();
}

}

}

//import com.lib.ctrip.ScreenshotListener;

@Listeners({ScreenshotListener.class})
class Screenshot {
static AppiumDriver driver;
@BeforeClass
public void setUp() throws MalformedURLException{
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("deviceName", "AndroidUI");	
capabilities.setCapability("platformVersion", "1.0");
capabilities.setCapability("appPackage", "com.android.androidui");
capabilities.setCapability("appActivity", "com.android.androidui.MainActivity");
driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}

@Test
public void testExample() throws IOException{
WebElement spinner = driver.findElement(By.id("android:id/text1"));
spinner.click();
//driver.scrollToExact("India");
WebElement optionindia = driver.findElement(By.name("India"));
optionindia.click();	
WebElement result= optionindia;
//Check the calculated value on the edit box
assert result.getText().equals("France"):"Actual value is :"+result.getText()+" did not match with expected value: France";
}

@AfterClass
public void tearDown(){
driver.closeApp();
}

public static AppiumDriver getDriver(){
return driver;
}	

}

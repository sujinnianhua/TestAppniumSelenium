package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class TestBi {
	public AndroidDriver wd ;
	
	@BeforeTest
	public void CreateDriver() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","HTC D816w");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","4.4.2");
        
       //配置测试apk
        capabilities.setCapability("appPackage", "tv.danmaku.bili");
        capabilities.setCapability("appActivity", ".ui.splash.SplashActivity");
        capabilities.setCapability("sessionOverride", true);    //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        capabilities.setCapability("unicodeKeyboard", true);    //设置键盘
        capabilities.setCapability("resetKeyboard", false);     //设置默认键盘为appium的键盘
        
        wd = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@Test(description = "绝对定位")
	public void TestCase1() throws InterruptedException{
/*		WebElement element = wd.findElement(By.xpath("//android.widget.TextView[contains(@text,'跳过')]"));
		element.click();*/
		Thread.sleep(5000);
		WebElement element = wd.findElement(By.xpath("//android.widget.TextView[contains(@text,'综合')]"));
		wd.tap(1, element, 500);
	}

}

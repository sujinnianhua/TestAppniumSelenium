package cn.taofen8.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class startapp {
	public static AndroidDriver dc(){
		AndroidDriver driver = null;
		
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("deviceName","HTC D816w");
	    capabilities.setCapability("automationName","Appium");
	    capabilities.setCapability("platformName","Android");
	    capabilities.setCapability("platformVersion","4.4.2");
	    
	   //配置测试apk
	    capabilities.setCapability("appPackage", "com.leixun.taofen8");
	    capabilities.setCapability("appActivity", ".module.load.LoadActivity");
	    capabilities.setCapability("sessionOverride", true);    //每次启动时覆盖session，否则第二次后运行会报错不能新建session
	    capabilities.setCapability("unicodeKeyboard", true);    //设置键盘支持中文输入
	    capabilities.setCapability("resetKeyboard", false); 
	    
	    //capabilities.setCapability("app", app);
	    
	    capabilities.setCapability("appPackage", "com.leixun.taofen8");
	    capabilities.setCapability("appActivity", ".module.load.LoadActivity");
	    
		//安装并启动app
	    try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("安装失败");
		}

	    return driver;
	}
}

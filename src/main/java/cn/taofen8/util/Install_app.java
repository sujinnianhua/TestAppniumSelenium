package cn.taofen8.util;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Install_app {
	
	public static AndroidDriver dc(){
		AndroidDriver driver = null;
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot,"apps");
		//File app = new File(appDir,"taofen8_taofen8_signed.apk");
		
		//File app = new File(appDir,"V_10.17_5_本周ALL_180930_1058.apk");
		File app = new File(appDir,"V10.22.apk");
		//File tf8 = new File("D:\\chrome_downloads\\taofen8_taofen8_signed.apk");
		
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("deviceName","HTC D816w");
	    capabilities.setCapability("automationName","Appium");
	    capabilities.setCapability("platformName","Android");
	    //capabilities.setCapability("platformVersion","8.1.0");
	    capabilities.setCapability("platformVersion","5.1.1");
	    //开启后，不支持name属性
	    //capabilities.setCapability("automationName", "UiAutomator2");
	    
	   //配置测试apk
	    capabilities.setCapability("appPackage", "com.leixun.taofen8");
	    capabilities.setCapability("appActivity", ".module.load.LoadActivity");
	    capabilities.setCapability("sessionOverride", true);    //每次启动时覆盖session，否则第二次后运行会报错不能新建session
	    capabilities.setCapability("unicodeKeyboard", true);    //使用 Unicode 输入法 ，支持中文输入
	    capabilities.setCapability("noReset", true); //防止重安装app
	    capabilities.setCapability("noSign", true); //设置避免重新签名
	    capabilities.setCapability("resetKeyboard", false);
	    capabilities.setCapability("app", app);
	    
	    //System.out.println("app已经安装"+ driver.isAppInstalled("com.leixun.taofen8"));
	    
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

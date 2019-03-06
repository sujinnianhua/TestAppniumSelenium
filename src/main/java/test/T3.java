package test;

import io.appium.java_client.android.AndroidDriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T3 {
 public void t(AndroidDriver driver){
	 /*    	WebElement e3 = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText[1]"));
 	e3.click();
 	e3.sendKeys("lt6851");*/
		Set<String> contextSet = driver.getContextHandles();
		for(String context : contextSet){
			System.out.println(context);
			
			if(context.toLowerCase().contains("webview")){
				//转换成webview模式
				driver.context(context);
				break;
			}
		}
     
     
     //搜索引导页
     //Tutorial.t(driver);
     /*newU_tc.n(driver);
     User_P.u(driver);*/
 }
 
 /*    @Test
 public void test() throws Exception {
     driver.findElement(By.id("com.leixun.taofen8:id/rtv_skip")).click();
 	WebElement e1 = 
 	driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'跳过')]")).click();
 	driver.tap(1, e1, 500);
 	driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'我的')]")).click();
 	driver.tap(1, e2, 500);
 	driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'马上登录')]")).click();
 	driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'使用淘宝账号快速登录')]")).click();
 	//android.view.View[contains(@content-desc,'账户')]/following-sibling::android.view.View/android.widget.EditText
 	WebElement e3 = driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'登录淘宝账户')]/android.view.View[2]"));
 	
 	e3.sendKeys("lt6851");
 }*/
 
	@Test(enabled=false)
    public void test(AndroidDriver driver) throws Exception {
		driver.findElement(By.id("com.leixun.taofen8:id/rtv_skip")).click();
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'超高返')]")).click();
/*		driver.findElement(By.id("com.leixun.taofen8:id/left")).click();*/
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'查看全部')]")).click();
		Set<String> contextSet = driver.getContextHandles();
		for(String context : contextSet){
			System.out.println(context);
			
			if(context.toLowerCase().contains("webview")){
				//转换成webview模式
				driver.context(context);
				break;
			}
		}
		/*获得页面元素 PageResourceGetter为视频讲解自己的方法，此处未实现
		 * 	driver.getPageSource();
			PageResourceGetter.initialize("/users/prg.html",);*/
	}
}

/*        System.out.println(driver.getPageSource());
//driver.getWindowHandles()   driver.getContextHandles()
Set<String> contextSet = driver.getWindowHandles();
for(String context : contextSet){
	System.out.println(context);
	
	if(context.toLowerCase().contains("webview")){
		//转换成webview模式
		driver.context(context);
		break;
	}
}*/
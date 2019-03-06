package cn.taofen8.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.taofen8.control.F_install;
import cn.taofen8.services.AlipayE;
import cn.taofen8.services.AlipayError;
import cn.taofen8.services.Buy;
import cn.taofen8.services.G_Ad;
import cn.taofen8.services.G_Icon;
import cn.taofen8.services.G_banner;
import cn.taofen8.services.G_fanli;
import cn.taofen8.services.G_space;
import cn.taofen8.services.Login;
import cn.taofen8.services.Logout;
import cn.taofen8.services.Nusers_w;
import cn.taofen8.services.S_start;
import cn.taofen8.services.SearchL_C;
import cn.taofen8.services.To_task;
import cn.taofen8.services.activity_11;
import cn.taofen8.services.foot_b;
import cn.taofen8.ui.Position;
import cn.taofen8.ui.Tutorial;
import cn.taofen8.ui.search;
import cn.taofen8.ui.update;
import cn.taofen8.util.Excel_read;
import cn.taofen8.util.Install_app;
import cn.taofen8.util.Screenshot;
import cn.taofen8.util.getGBannerT;
import cn.taofen8.util.getSms;
import cn.taofen8.util.sleep_t;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
public class tf8_test {
	AndroidDriver driver = null;
	boolean Install = false;
	@BeforeClass
	public void setup(){
		System.out.println("程序启动");
		driver = Install_app.dc();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Install = driver.isAppInstalled("com.leixun.taofen8");
        System.out.println("app已经安装成功:"+driver.isAppInstalled("com.leixun.taofen8"));
	}
	/*(enabled =false)*/
	@Test
	public void test1(){
		System.out.println("测试一：首次安装后启动+登陆测试");
		if(Install){
			//首次安装并打开
			//G_space.get(driver);  //系统版本>6.0需要获取存储空间
			S_start.get(driver);  //启动页
			sleep_t.sleep(5000);
			//G_Ad.close(driver);
			//if(getGBannerT.t("global")>0){
				Position.refresh(driver);
				sleep_t.sleep(5000);
				G_banner.close(driver);
				sleep_t.sleep(5000);
				Position.refresh(driver);
				SearchL_C.close(driver);
			//}

			Login.im(driver);
			Login.ByMobile(driver);
			
			if(!AlipayError.isError("lt6851")){
				System.out.println("支付宝异常弹窗测试");
				AlipayE.g_up(driver);
				foot_b.c_first(driver);
				AlipayE.g_up(driver);
				SearchL_C.close(driver);
				//点击超级券icon
				for(int i=0; i<8;i++){
				AndroidElement s =  (AndroidElement) driver.findElements(By.id("com.leixun.taofen8:id/icon")).get(i);
				s.click();
				sleep_t.sleep(500);
				driver.findElement(By.id("com.leixun.taofen8:id/back")).click();
				sleep_t.sleep(500);
			}
				G_Icon.C_coupon(driver);
			}
			foot_b.c_my(driver);
			Logout.Setup(driver);
			Logout.quit(driver);
			foot_b.c_first(driver);
			//全局banner
			G_banner.close(driver);
			//手机号码登陆测试
			sleep_t.sleep(1000);
			Login.im(driver);
			sleep_t.sleep(1000);
			Login.ByTB(driver);
			//sleep_t.sleep(1000);
			System.out.println("登陆测试已完成");
			Screenshot.t(driver);
			foot_b.c_first(driver);
			
			driver.closeApp();
			//activity_11.hao1(driver);
			
		}else{
			//再次打开
			G_Ad.close(driver);
	        String s02 = Excel_read.test("搜索引导页关闭",0);
	        System.out.println(s02);
	        driver.findElement(By.xpath(s02)).click();
			//F_install.t(driver);
			//S_start.get(driver);
		}
	}
	
	@Test
	public void test2(){
		System.out.println("测试一：二次打开测试");
			driver.launchApp();
			//关闭广告页
			G_Ad.close(driver);
/*			for(int i=0; i<8;i++){
				AndroidElement s =  (AndroidElement) driver.findElements(By.id("com.leixun.taofen8:id/icon")).get(i);
				s.click();
				sleep_t.sleep(500);
				driver.findElement(By.id("com.leixun.taofen8:id/back")).click();
				sleep_t.sleep(500);
			}*/
			//System.out.println();
			search.w(driver);
			sleep_t.sleep(1000);
			Login.ByTB(driver);
			driver.findElement(By.xpath("//android.view.View[@text='立即领券']")).click();
			
			//driver.findElement(By.xpath("//*[@text='输入淘宝/天猫/聚划算商品标题或关键字']/following-sibling::android.widget.ImageView")).click() ;
	}
	
	@Test(enabled =false)
	//1.新用户新设备，首次安装，获取存储权限，
	//弹出新人有礼弹窗，完成新人有礼流程测试
	public void test11() throws MalformedURLException, InterruptedException{
        //Screenshot.t(driver);
        //sleep_t.sleep(500);
        //Screenshot.t(driver);
        //driver.isAppInstalled(bundleId)
		System.out.println("新人有礼测试开始");
        F_install.t(driver);
        
		//G_banner.close(driver);
		//全局banner配置的是商品
		//G_banner.click(driver);
        //只有广告的时候，
        //G_space.get(driver);

        //sleep_t.sleep(500);
/*        G_Ad.close(driver);
        sleep_t.sleep(500);*/
        /*
         * TO DO
         * 碰到首页新人有礼弹窗是否存在的时候，
         * 存在，通过新人有礼弹窗登陆
         * 不存在，通过我的登陆
         * 不存在，首页全局bannner
         * */
/*        Login.NL(driver);
        //新人弹窗淘宝账号登陆
        foot_b.c_my(driver);
        //我的里面的马上登陆
        Login.im(driver);*/

       // Login.ByTB(driver);
        
        //AlipayE.g_up(driver);
        //foot_b.c_first(driver);
        //AlipayE.g_up(driver);
        //购买商品
        Buy.get(driver);
        
        //Start.swipeToUp(driver,200,1);

        //升级弹窗显示后，关闭
       // update.update_t(driver);



       //AlipayE.g_up(driver);
       //Nusers_w.close(driver);
       // AlipayE.g_up(driver);
       // G_fanli.close_w(driver);
        //新设备老用户，跳往任务中心
        //To_task.get01(driver);
	}
	/**/
	@Test(enabled =false)//登陆测试
	public void test21(){
		System.out.println("安装成功！！");
		S_start.get(driver);
		//淘宝账号登陆测试
		Login.im(driver);
		Login.ByTB_sq(driver);
		//Login.ByTB(driver);
		Logout.Setup(driver);
		//Logout.quit(driver);
		
		//手机号码登陆测试
		Login.im(driver);
		Login.ByMobile(driver);
		sleep_t.sleep(1000);
		Screenshot.t(driver);
	}
	
	@Test(enabled =false)
	//6.0以上设备，8.1.0 需要获取存储空间
	public void test3(){
		System.out.println("test3");
		if(Install){
			//首次安装并打开
			G_space.get(driver);
			S_start.get(driver);
			sleep_t.sleep(5000);
			G_banner.close(driver);
			//全局banner配置的是商品
			//G_banner.click(driver);
			Login.im(driver);
			Login.ByTB(driver);
			//Login.ByTB_sq(driver);;
			if(!AlipayError.isError("lt6851")){
				System.out.println("支付宝异常弹窗测试");
				AlipayE.g_up(driver);
				foot_b.c_first(driver);
				AlipayE.g_up(driver);
				SearchL_C.close(driver);
				//点击超级券icon
				G_Icon.C_coupon(driver);
			}
			foot_b.c_first(driver);
			//activity_11.hao1(driver);
			
		}else{
			//再次打开
			G_Ad.close(driver);
	        String s02 = Excel_read.test("搜索引导页关闭",0);
	        System.out.println(s02);
	        driver.findElement(By.xpath(s02)).click();
			//F_install.t(driver);
			//S_start.get(driver);
		}
	}	
}

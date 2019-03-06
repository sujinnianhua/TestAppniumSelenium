package cn.taofen8.services;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import cn.taofen8.util.Excel_read;

public class foot_b {
	
	public static void c_first(AndroidDriver driver){
		try{
	        String s01 = Excel_read.test("首页",0);
	        driver.findElement(By.xpath(s01)).click();
			//driver.findElement(By.id("com.leixun.taofen8:id/label_1")).click();
		}catch(Exception e){
			System.out.println("底部首页，点击不了");
		}
	}
	
	public static void c_cgf(AndroidDriver driver){
		try{
	        String s01 = Excel_read.test("超高返",0);
	        driver.findElement(By.xpath(s01)).click();
			//driver.findElement(By.id("com.leixun.taofen8:id/label_1")).click();
		}catch(Exception e){
			System.out.println("底部超高返，点击不了");
		}
	}
	
	public static void c_baoliao(AndroidDriver driver){
		try{
	        String s01 = Excel_read.test("爆料",0);
	        driver.findElement(By.xpath(s01)).click();
			//driver.findElement(By.id("com.leixun.taofen8:id/label_1")).click();
		}catch(Exception e){
			System.out.println("底部爆料，点击不了");
		}
	}
	
	public static void c_cjq(AndroidDriver driver){
		try{
	        String s01 = Excel_read.test("超级券",0);
	        driver.findElement(By.xpath(s01)).click();
			//driver.findElement(By.id("com.leixun.taofen8:id/label_1")).click();
		}catch(Exception e){
			System.out.println("底部超级券，点击不了");
		}
	}
	
	public static void c_my(AndroidDriver driver){
		try{
	        String s01 = Excel_read.test("我的",0);
	        driver.findElement(By.xpath(s01)).click();
			//driver.findElement(By.id("com.leixun.taofen8:id/label_5")).click();
		}catch(Exception e){
			System.out.println("底部我的，点击不了");
		}
	}
}

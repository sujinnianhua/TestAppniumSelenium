package cn.taofen8.services;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import cn.taofen8.util.Excel_read;

public class G_Ad {
	public static void close(AndroidDriver driver){
		try{
	        String s01 = Excel_read.test("跳过广告页",0);
	        driver.findElement(By.xpath(s01)).click();
		}catch(Exception e){
			System.out.println("广告页没有显示");
		}
	}
	
	public static void click(AndroidDriver driver){
		try{
	        String s01 = Excel_read.test("点击广告页",0);
	        driver.findElement(By.xpath(s01)).click();
		}catch(Exception e){
			System.out.println("广告页没有显示");
		}
	}
}

package cn.taofen8.services;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.taofen8.util.Excel_read;

public class AlipayE {
	public static void g_up(AndroidDriver driver){
		try{
	        String s01 = Excel_read.test("放弃填写支付宝",0);
	        driver.findElement(By.xpath(s01)).click();
			//driver.findElement(By.name("我要放弃")).click();
		}catch(Exception e){
			System.out.println("支付宝异常弹窗，没有显示");
		}
	}
	
	public static void Send_A(AndroidDriver driver,String alipay){
		try{
	        String s01 = Excel_read.test("填写支付宝账号",0);
	        WebElement wb1 = driver.findElement(By.xpath(s01));
	        wb1.sendKeys(alipay);
		}catch(Exception e){
			System.out.println("支付宝异常弹窗，没有显示");
		}
	}

}

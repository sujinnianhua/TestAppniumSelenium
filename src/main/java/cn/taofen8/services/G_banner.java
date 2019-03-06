package cn.taofen8.services;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import cn.taofen8.util.Excel_read;

public class G_banner {
	public static void close(AndroidDriver driver){
		try{
	        String s01 = Excel_read.test("关闭全局banner",0);
	        driver.findElement(By.xpath(s01)).click();
		}catch(Exception e){
			System.out.println("关闭不了全局banner");
		}
	}
	public static void click(AndroidDriver driver){
		try{
	        String s01 = Excel_read.test("点击全局banner图片",0);
	        driver.findElement(By.xpath(s01)).click();
		}catch(Exception e){
			System.out.println("点击不了全局banner");
		}
	}

}

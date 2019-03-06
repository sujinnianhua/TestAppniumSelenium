package cn.taofen8.services;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.taofen8.ui.Position;
import cn.taofen8.util.Excel_read;
import cn.taofen8.util.sleep_t;

public class Logout {
	public static void Setup(AndroidDriver driver){
		try{
	        String se1 = Excel_read.test("点击设置",0);
	        //System.out.println(se1);
	        driver.findElement(By.xpath(se1)).click();
		}catch(Exception e){
			System.out.println("没有设置");
		}
	}
	
	public static void quit(AndroidDriver driver){
		try{
	        String se1 = Excel_read.test("点击设置中的退出",0);
	        System.out.println(se1);
	        driver.findElement(By.xpath(se1)).click();
		}catch(Exception e){
			System.out.println("没有退出按钮");
		}
	}
}

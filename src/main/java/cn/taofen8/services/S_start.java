package cn.taofen8.services;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.taofen8.ui.Position;
import cn.taofen8.util.Excel_read;
import cn.taofen8.util.sleep_t;

public class S_start {
	public static void get(AndroidDriver driver){
		try{
	        String se1 = Excel_read.test("滑动启动页第一页",0);
	        WebElement wb = driver.findElement(By.xpath(se1));
	        sleep_t.sleep(500);
	        if(wb.isDisplayed()){
	        	Position.swipe(driver);
	        }
		}catch(Exception e){
			System.out.println("没有启动页");
		}

	}
}

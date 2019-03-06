package cn.taofen8.services;

import org.openqa.selenium.By;

import cn.taofen8.util.Excel_read;
import io.appium.java_client.android.AndroidDriver;

public class SearchL_C {
	public static void close(AndroidDriver driver){
		try{
	        String s01 = Excel_read.test("搜索引导页关闭",0);
	        driver.findElement(By.xpath(s01)).click();
			
		}catch(Exception e){
			System.out.println("没有显示搜索引导页");
		}
	}
	
}

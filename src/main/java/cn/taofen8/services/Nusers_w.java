package cn.taofen8.services;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.taofen8.util.Excel_read;
import cn.taofen8.util.getSms;

public class Nusers_w {
	
	public static void close(AndroidDriver driver){
		try{
	        String x1 = Excel_read.test("首页领取新人有礼弹窗关闭",0);
	        driver.findElement(By.xpath(x1)).click();
		}catch(Exception e){
			System.out.println("新人弹窗没有显示");
		}

	}
	
	public static void t(AndroidDriver driver){
/*		Login.NL(driver);
		Login.ByMobile(driver);*/
        driver.findElement(By.name("现在领取")).click();
        driver.findElement(By.name("做任务,领取更多返利")).click();
        

	}
}

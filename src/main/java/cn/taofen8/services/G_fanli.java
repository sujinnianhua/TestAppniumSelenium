package cn.taofen8.services;

import org.openqa.selenium.By;

import cn.taofen8.util.Excel_read;
import io.appium.java_client.android.AndroidDriver;

public class G_fanli {
	
	public static void close_w(AndroidDriver driver){
		try{
	        String s01 = Excel_read.test("返利到账弹窗点击我知道了",0);
	        driver.findElement(By.xpath(s01)).click();
		}catch(Exception e){
			System.out.println("返利到账弹窗，没有显示");
		}
	}
}

package cn.taofen8.services;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import cn.taofen8.util.Excel_read;

public class G_Icon {
	public static void C_coupon(AndroidDriver driver){
		try{
	        String s01 = Excel_read.test("超级券",0);
	        //driver.findElement(By.xpath(s01)).click();
			//driver.findElement(By.id("com.leixun.taofen8:id/label_1")).click();
	        /*driver.findElement()*/
		}catch(Exception e){
			System.out.println("icon超级券，点击不了");
		}
	}

}

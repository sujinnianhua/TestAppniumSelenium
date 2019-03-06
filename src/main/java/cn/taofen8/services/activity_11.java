package cn.taofen8.services;

import java.util.List;

import org.openqa.selenium.By;

import cn.taofen8.util.Excel_read;
import io.appium.java_client.android.AndroidDriver;

public class activity_11 {
	public static void hao(AndroidDriver driver){
	    String s02 = Excel_read.test("活动页面抢先好货",0);
	    System.out.println(s02);
	    driver.findElement(By.xpath(s02)).click();
	}
	/*			Position.Click_p(driver, 876, 586, 1072, 2234);*/
	
	public static void hao1(AndroidDriver driver){
		System.out.println("start");
		List list = driver.findElementsByXPath("//android.view.View[contains(@resource-id,'navList')]/following-sibling::android.view.View");
		for(int i=0;i<list.size();i++){
			System.out.println("i: "+list.get(i));
		}
	}
}

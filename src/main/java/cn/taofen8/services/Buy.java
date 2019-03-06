package cn.taofen8.services;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import cn.taofen8.util.Excel_read;
import cn.taofen8.util.sleep_t;

public class Buy {
	public static void get(AndroidDriver driver){
		try{
	        String e1 = Excel_read.test("今日必抢第三个",0);
	        driver.findElement(By.xpath(e1)).click();
	        String e2 = Excel_read.test("领券",0);
	        driver.findElement(By.xpath(e2)).click();
	        sleep_t.sleep(500);
	        driver.findElement(By.xpath("//android.widget.Button[@text='加入购物车']")).click();
	        sleep_t.sleep(500);
	        //driver.tap(fingers, x, y, duration); //坐标点击
	        driver.tap(1, 141, 1090, 200);
	        sleep_t.sleep(500);
	        driver.findElement(By.xpath("//android.widget.Button[@text='确定']")).click();
	        sleep_t.sleep(500);
	        driver.findElement(By.xpath("//android.widget.Button[@text='立即购买']")).click();
	        //sleep_t.sleep(5000);
	        //driver.tap(1, 141, 1090, 200);
	        sleep_t.sleep(500);
	        driver.findElement(By.xpath("//android.widget.Button[@text='确定']")).click();
	        sleep_t.sleep(500);
	        driver.findElement(By.xpath("//android.view.View[@text='提交订单']")).click();
	        //driver.tap(1, 141, 1090, 200);
	        sleep_t.sleep(500);
		}catch(Exception e){
			System.out.println("购买失败");
		}

	}
}

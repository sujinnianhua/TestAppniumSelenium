package cn.taofen8.services;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import cn.taofen8.util.Excel_read;
import cn.taofen8.util.sleep_t;

public class To_task {
	public static void get(AndroidDriver driver){

        
        String s02 = Excel_read.test("首页领取新人有礼",0);
        driver.findElement(By.xpath(s02)).click();
        
        String s03 = Excel_read.test("新人弹窗老用户做任务按钮",0);
        driver.findElement(By.xpath(s03)).click();
        
/*        sleep_t.sleep(500);
        driver.findElement(By.xpath(s01)).click();*/
	}
	
	public static void get01(AndroidDriver driver){
        String s01 = Excel_read.test("放弃填写支付宝",0);
        driver.findElement(By.xpath(s01)).click();
        
        String s02 = Excel_read.test("首页领取新人有礼弹窗关闭",0);
        driver.findElement(By.xpath(s02)).click();
        //放弃填写支付宝
        driver.findElement(By.xpath(s01)).click();
        
        String s03 = Excel_read.test("返利到账弹窗点击我知道了",0);
        driver.findElement(By.xpath(s03)).click();
        
        String s04 = Excel_read.test("搜索引导页点击我知道了",0);
        driver.findElement(By.id(s04)).click();
        
	}
}

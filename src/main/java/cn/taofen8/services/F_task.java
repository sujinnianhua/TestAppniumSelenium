package cn.taofen8.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.taofen8.util.Excel_read;
import io.appium.java_client.android.AndroidDriver;

public class F_task {
	public static void shake(AndroidDriver driver){
        String x2 = Excel_read.test("天天摇奖入口点击",0);
        driver.findElement(By.xpath(x2)).click();
		try{
	        String x3 = Excel_read.test("点击签到摇奖按钮",0);
	        System.out.println(x3);
	        WebElement we = driver.findElement(By.xpath(x3));
	        if(we.isDisplayed()){
	            //摇奖按钮
	            we.click();
	            String x4 = Excel_read.test("关闭摇奖奖励弹窗",0);
	            System.out.println(x4);
	            driver.findElement(By.xpath(x4)).click();
	        }
		}catch(Exception e){
			System.out.println("已经摇过奖了");
		}

	}

}

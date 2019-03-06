package cn.taofen8.services;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.taofen8.util.Excel_read;

public class G_space {
	public static void get(AndroidDriver driver){
        //if(driver.isAppInstalled(bundleId))
		try{
	        String se00 = Excel_read.test("存储权限允许1",0);
	        System.out.println(se00);
	        WebElement wb = driver.findElement(By.xpath(se00));
	        if(wb.isDisplayed()){
	            wb.click();
	            wb.click();
	        }
		}catch(Exception e){
			System.out.println("已安装过，不需要允许存储");
		}

	}
}

package cn.taofen8.ui;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class newU_tc {
	public static void n(AndroidDriver driver){
		  WebElement newU = driver.findElement(By.id("com.leixun.taofen8:id/rl_content"));
		  if(newU.isDisplayed()){
			  driver.findElement(By.id("com.leixun.taofen8:id/iv_action")).click();;
		  }
		  driver.findElement(By.name("使用淘宝账号快速登录")).click();
	}

}

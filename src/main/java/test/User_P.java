package test;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class User_P {
	public static void u(AndroidDriver driver){
		  WebElement wb = driver.findElement(By.xpath(
				  "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"
				  + "/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"
				  + "/android.view.View[1]/android.view.View[1]/android.view.View[1]"
				  + "/android.view.View[1]/android.view.View[1]/android.view.View[2]"
				  + "/android.widget.EditText[1]"));
		  if(wb.isDisplayed()){
			  System.out.println("可以输入账号");
			  wb.click();
			  wb.sendKeys("超级丹的小弟");
		  }
		  
		  WebElement ps = driver.findElement(By.xpath(
					"//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"
					+ "/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"
					+ "/android.view.View[1]/android.view.View[1]/android.view.View[1]"
					+ "/android.view.View[1]/android.view.View[1]/android.view.View[4]"
					+ "/android.widget.EditText[1]"
					  ));
			  if(ps.isDisplayed()){
				  System.out.println("可以输入密码");
				  ps.click();
				  ps.sendKeys("taofen8906");
			  }
	}
	
	/*	  Thread.sleep(300);
	  
	  Set<String> contextSet = driver.getContextHandles();
	  for(String con : contextSet){
		  System.out.println(con);
		  if(con.toLowerCase().contains("webview")){
			  driver.context(con);
			  break;
		  }
	  }*/
}

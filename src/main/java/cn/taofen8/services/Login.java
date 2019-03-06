package cn.taofen8.services;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.taofen8.util.Excel_read;
import cn.taofen8.util.getSms;
import cn.taofen8.util.sleep_t;

public class Login {
	public static String mobile = "15658013690";
	
	public static void im(AndroidDriver driver){
		//点击"我的"
		foot_b.c_my(driver);
		try{
/*			String x1 = Excel_read.test("我的",0);
			WebElement w1 = driver.findElement(By.xpath(x1));
			if(w1.isDisplayed()){
				w1.click();
			}*/
			
			//driver.findElementById("com.leixun.taofen8:id/label_5").click();
			
			String x2 = Excel_read.test("马上登陆",0);
			WebElement w2 = driver.findElement(By.xpath(x2));
			if(w2.isDisplayed()){
				w2.click();
			}
		}catch(Exception e){
			System.out.println("我的里面没有‘马上登陆’按钮");
		}
	}
	
	public static void NL(AndroidDriver driver){
		try{
			String x1 = Excel_read.test("首页新人有礼登陆领取",0);
			WebElement w1 = driver.findElement(By.xpath(x1));
			if(w1.isDisplayed()){
				w1.click();
			}
		}catch(Exception e){
			System.out.println("没有登陆领取按钮");
		}

	}
	
	public static void ByMobile(AndroidDriver driver){

	        //WebElement wb1 = driver.findElement(By.name("请输入手机号码"));
			String wb1 = Excel_read.test("登陆页面",0);
			WebElement w1 = driver.findElement(By.xpath(wb1));
	        if(w1.isDisplayed()){
	        	//w1.click();
	        	w1.sendKeys(mobile);
	        }
	        
/*	        WebElement w2 = driver.findElement(By.name("获取验证码"));
	        if(w2.isDisplayed()){
	        	w2.click();
	        }*/
			String wb2 = Excel_read.test("点击获取验证码",0);
			driver.findElement(By.xpath(wb2)).click();

	        String context = getSms.t(mobile);
	        System.out.println(mobile);
	        System.out.println(context);
			String wb3 = Excel_read.test("短信验证码输入框",0);
			WebElement w3 = driver.findElement(By.xpath(wb3));
	        //WebElement wb2 = driver.findElement(By.name("短信验证码"));
	        if(w3.isDisplayed()){
	            //wb3.click();
	            w3.sendKeys(context);
	        }
            String wb4 = Excel_read.test("点击登陆按钮",0);
            System.out.println(wb4);
            WebElement w4 = driver.findElement(By.xpath(wb4));
            if(w4.isDisplayed()){
            	w4.click();
            }
	}
	
	public static void ByTB(AndroidDriver driver){
		
		try{
			//通过新人有礼弹窗登陆，登陆成功返回首页
			String se2 = Excel_read.test("使用淘宝账号快速登录",0);
			driver.findElement(By.xpath(se2)).click();
	            	
			sleep_t.sleep(500);
			//System.out.println(driver.getPageSource());
			String se3 = Excel_read.test("输入淘宝账号",0);
			System.out.println("se3: "+se3);
	        sleep_t.sleep(500);
	        WebElement e3 = driver.findElement(By.xpath(se3));
			//WebElement e3 = driver.findElement(By.id("username"));
	        if(e3.isDisplayed()){
	             System.out.println("e3显示正常");
	             sleep_t.sleep(500);
	             e3.sendKeys("lt6851");
	             
	        }
	                 	
	        sleep_t.sleep(500);
	        //System.out.println(driver.getPageSource());
	        String se4 = Excel_read.test("输入淘宝密码",0);
	        sleep_t.sleep(500);
	        WebElement e4 = driver.findElement(By.xpath(se4));
	        //WebElement e4 = driver.findElement(By.id("password"));
	        if(e4.isDisplayed()){
	           System.out.println("e4显示正常");
	           sleep_t.sleep(500);
	           e4.sendKeys("shenhe1234");
	        }
	                    	
	        sleep_t.sleep(500);
	        String se5 = Excel_read.test("点击授权并登陆",0);
	        sleep_t.sleep(500);
	        driver.findElement(By.xpath(se5)).click();
	        //driver.findElement(By.id("submit-btn")).click();
	      }catch(Exception e){
	    	  System.out.println("已登陆");
	      }	
        try{
            sleep_t.sleep(500);
            String se6 = Excel_read.test("点击授权",0);
            //System.out.println("se6: "+se6);
            sleep_t.sleep(500);
            driver.findElement(By.xpath(se6)).click();
        }catch(Exception e){
        	System.out.println("不需要授权");
        }
	}
	
	public static void ByTB_sq(AndroidDriver driver){
		
		try{
			//安装淘宝，直接授权
			String se1 = Excel_read.test("使用淘宝账号快速登录",0);
			driver.findElement(By.xpath(se1)).click();
			
			String se2 = Excel_read.test("淘宝直接授权",0);
			driver.findElement(By.xpath(se2)).click();
	            	
			sleep_t.sleep(500);
        }catch(Exception e){
        	System.out.println("不需要授权");
        }
	}
}

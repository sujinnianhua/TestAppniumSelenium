package test;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.taofen8.dao.UCUserDAO;
import cn.taofen8.dao.impl.BillDetailDAOImpl;
import cn.taofen8.dao.impl.MobileBannerBaseDAOImpl;
import cn.taofen8.dao.impl.Tf8DAOImpl;
import cn.taofen8.dao.impl.UCUserDAOImpl;
import cn.taofen8.dao.impl.UserDAOImpl;
import cn.taofen8.model.BillDetail;
import cn.taofen8.model.MobileBannerBase;
import cn.taofen8.model.User;

public class T1 {
	
	private static ApplicationContext applicationContext = null;
	static{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void t1(){
		MobileBannerBaseDAOImpl banner = (MobileBannerBaseDAOImpl) applicationContext.getBean("MobileBannerBaseDAO");
		int times = banner.getGlobalBanner("global");
		//User u = getUserByIdFromCache("lt6851");
		System.out.println(times);
	}
	
	@Test(enabled=false)
	public void t1_e3(){
		UserDAOImpl tf8_u = (UserDAOImpl) applicationContext.getBean("UserDAO");
		User u =tf8_u.getUserByTbNick("lt6851");
		//User u = getUserByIdFromCache("lt6851");
		System.out.println(u.getId());
	}
	@Test(enabled=false)
	public void t1_e2(){
		BillDetailDAOImpl tf8 = (BillDetailDAOImpl) applicationContext.getBean("BillDetailDAO");
		BillDetail b = new BillDetail();
		b.setUserId(2000008223390L);
		
		System.out.println(tf8.getErrorTimes(b));
	}
	
/*	@Autowired
	private UCUserDAO uCUserDAO;
	*/
/*	public User getUserByIdFromCache(String tbNick)
	{
		return this.uCUserDAO.getUserByTBNick(tbNick);
	}*/
	
	@Test(enabled=false)
	public void t1_e1(){
		UCUserDAOImpl tf8 = (UCUserDAOImpl) applicationContext.getBean("uCUserDAO");
		User u =tf8.getUserByTBNick("lt6851");
		//User u = getUserByIdFromCache("lt6851");
		System.out.println(u.getAlipay());
	}
	
/*	private static ApplicationContext context = null;

	public static void init() {
		if (context == null) {
			context = new ClassPathXmlApplicationContext(new String[] {
					 "classpath*:spring/spring-*.xml", "classpath*:spring-*.xml"});
		}
	}

	public static Object getBeanFromFacotry(String beanName) {
		init();
		return context.getBean(beanName);
	}
	*/
/*	public static void main(String[] args) {
		UCAlipayInfoDAO dao = (UCAlipayInfoDAO) getBeanFromFacotry("uCAlipayInfoDAO");
		System.out.println(dao.getAlipayInfoByAlipay("474258300@qq.com"));
	}*/
	
/*	@Test
	public void test(){
		UCAlipayInfoDAO dao = null;
		
		//UCAlipayInfoDAO.getAlipayInfoByAlipay(String alipay);
	}*/
	
/*	private static String Category_Head = "//android.widget.TextView[contains(@text,'%1$s')]";

	public static String StringFormat(String strText){
		return String.format(Category_Head, strText);
	}*/
	

/*	public void t(){
		String myStr = "%1$s";
		String myStr2 = "%2$s";
		System.out.println(String.format(myStr, "My name id Klien"));
		System.out.println(String.format(myStr2, "Appium Class","Hello world"));
		System.out.println(StringFormat("'t1','t2'"));
		
	}*/
	
/*	@BeforeClass
	public void setUp() throws MalformedURLException{
		AndroidDriver driver;
        //启动appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","HTC D816w");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","4.4.2");
        
       //配置测试apk
        capabilities.setCapability("appPackage", "com.leixun.taofen8");
        capabilities.setCapability("appActivity", ".module.load.LoadActivity");
        capabilities.setCapability("sessionOverride", true);    //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        capabilities.setCapability("unicodeKeyboard", true);    //设置键盘
        capabilities.setCapability("resetKeyboard", false);     //设置默认键盘为appium的键盘
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}*/

}

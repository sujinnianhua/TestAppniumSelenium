package cn.taofen8.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.taofen8.dao.impl.MobileBannerBaseDAOImpl;

public class getGBannerT {
	private static ApplicationContext applicationContext = null;
	static{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	public static Integer t(String type){
		MobileBannerBaseDAOImpl banner = (MobileBannerBaseDAOImpl) applicationContext.getBean("MobileBannerBaseDAO");
		int times = banner.getGlobalBanner("global");
		//User u = getUserByIdFromCache("lt6851");
		System.out.println(times);
		return times;
	}
}

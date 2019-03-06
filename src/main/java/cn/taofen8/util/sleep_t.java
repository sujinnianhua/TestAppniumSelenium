package cn.taofen8.util;

public class sleep_t {
	public static void sleep(long s){
		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			System.out.println("睡眠被打断了");
			e.printStackTrace();
		}
	}
}

package cn.taofen8.control;

import io.appium.java_client.android.AndroidDriver;
import cn.taofen8.services.AlipayE;
import cn.taofen8.services.F_task;
import cn.taofen8.services.G_space;
import cn.taofen8.services.Login;
import cn.taofen8.services.Nusers_w;
import cn.taofen8.services.S_start;

public class F_install {
	public static void t(AndroidDriver driver){
		//获得存储空间
		//G_space.get(driver);
	    //滑动启动页
	    S_start.get(driver);
	    //Login.im(driver);
	    //新人有礼弹窗的"登陆领取"
	    Login.NL(driver);
	    //淘粉吧登陆页面，通过淘宝账号登陆
        Login.ByTB(driver);
        //AlipayE.g_up(driver);
        Nusers_w.t(driver);
        //AlipayE.g_up(driver);
        //F_task.shake(driver);
	}

}

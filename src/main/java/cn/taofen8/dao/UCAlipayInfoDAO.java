package cn.taofen8.dao;

import java.util.Date;
import cn.taofen8.model.AlipayInfo;

public interface UCAlipayInfoDAO {
	
	/**
	 * 保存支付宝信息
	 */
	Long saveAlipayInfo(AlipayInfo alipayInfo);
	
	/**
	 * 根据支付宝账号查询
	 * @param alipay
	 * @return
	 */
	AlipayInfo getAlipayInfoByAlipay(String alipay);
	
	/**
	 * 更新有效状态
	 * @param id
	 * @param status
	 */
	void updateValidStatus(long id,int valid);
	
	/**
	 * 更新最后一次打款时间
	 * @param id
	 * @param lastPayTime
	 */
	void updateLastPayTime(long id,Date lastPayTime);
	
	/**
	 * 更新确认已经实名的时间
	 * @param id
	 * @param confirmAuthorizedTime
	 */
	void updateConfirmAuthorizedTime(long id,Date confirmAuthorizedTime);
	
}

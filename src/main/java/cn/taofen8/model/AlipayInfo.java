package cn.taofen8.model;

import java.util.Date;

import com.taofen8.domain.BaseDO;

/**
 * 支付宝信息
 * 
 * @author yest 2017年12月7日 下午1:52:01
 *
 */
public class AlipayInfo extends BaseDO {

	public static int VALID_STATUS_YES = 1;  //有效支付宝
	public static int VALID_STATUS_NO = 0;  //无效支付宝
	public static int VALID_STATUS_UNKNOWN = -1;  //支付宝验证未明确
	
	public static int REAL_NAME_AUTHORIZED_STATUS_UNKNOWN = 0;  //未明确是否实名
	public static int REAL_NAME_AUTHORIZED_STATUS_YES = 1;    //已经实名认证
	public static int REAL_NAME_AUTHORIZED_STATUS_NO = 2;   //未实名认证
	
	private static final long serialVersionUID = 4844811243986951011L;
	private long id;
	private String alipay;
	
	/**
	 * 是否真实有效的支付宝，0无效， 1有效， -1未明确
	 */
	private int valid;

	/**
	 * 支付宝账号实名状态，0未明确，1已经实名认证，2未认证。
	 */
	private int realNameAuthorized;

	/**
	 * 最后一次打款时间
	 */
	private Date lastPayTime;

	/**
	 * 确认已经实名的时间
	 */
	private Date confirmAuthorizedTime;
	private Date createTime;
	private Date updateTime;

	/**
	 * 是否已经实名
	 * @return
	 */
	public boolean isRealNameAuthorized(){
		return realNameAuthorized==REAL_NAME_AUTHORIZED_STATUS_YES;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAlipay() {
		return alipay;
	}

	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}

	public int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

	public int getRealNameAuthorized() {
		return realNameAuthorized;
	}

	public void setRealNameAuthorized(int realNameAuthorized) {
		this.realNameAuthorized = realNameAuthorized;
	}

	public Date getLastPayTime() {
		return lastPayTime;
	}

	public void setLastPayTime(Date lastPayTime) {
		this.lastPayTime = lastPayTime;
	}

	public Date getConfirmAuthorizedTime() {
		return confirmAuthorizedTime;
	}

	public void setConfirmAuthorizedTime(Date confirmAuthorizedTime) {
		this.confirmAuthorizedTime = confirmAuthorizedTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}

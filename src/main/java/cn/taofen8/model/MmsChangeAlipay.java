package cn.taofen8.model;

import java.io.Serializable;
import java.util.Date;
import com.taofen8.domain.BaseDO;

/**
 * 用于更新支付宝帐号
 * 
 * @author yehang
 * 
 */
public class MmsChangeAlipay extends BaseDO implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1860515958872656378L;

    private long userId;
    private String alipayAccount;
    private String mobile;
    private Date updatedTime;
    private String comments;
    private String firstFrom;

    public long getUserId() {
        return userId;
    }
  

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFirstFrom() {
        return firstFrom;
    }

    public void setFirstFrom(String firstFrom) {
        this.firstFrom = firstFrom;
    }
}

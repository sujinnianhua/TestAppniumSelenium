package cn.taofen8.model;

import java.io.Serializable;
import java.util.Date;
import com.taofen8.domain.BaseDO;

public class UserMobile extends BaseDO {

	private static final long serialVersionUID = 1L;
	
	public static final String FROM_WWW = "www";
	public static final String FROM_MOBILE = "mobile";
	
	private Long id;
	private Long userId;
	private String mobile;
	private String firstFrom;
	private Date createTime;
	private Date updateTime;
	
	public UserMobile(Long userId, String mobile, String firstFrom) {
		super();
		this.userId = userId;
		this.mobile = mobile;
		this.firstFrom = firstFrom;
	}
	
    public UserMobile() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getFirstFrom() {
        return firstFrom;
    }

    public void setFirstFrom(String firstFrom) {
        this.firstFrom = firstFrom;
    }
}

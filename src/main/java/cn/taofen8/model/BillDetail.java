package cn.taofen8.model;

import java.util.Date;

public class BillDetail {
	private static final long serialVersionUID = 8484427430039283436L;	

	private Long billId;					// 账单ID
	private String billType;				// 账单类型
	private Long outerId1;					// 业务ID1，通常为业务表的唯一主键
	private Long outerId2;					// 业务ID2，特殊扩展，如摇奖分多个阶段：1/2/3， 或者是返利和商城返利的trade_id
	private Long outerId3;					// 业务ID3，目前没有对应场景
	private Long outerRef;					// 外部引用，如返利表的佣金
	private String outerRef1;				// 外部引用1，如返利表的买家实际支付金额
	private Integer payMethod;				// 支付方式
	private Integer priority;				// 优先级
	private Long userId;
	private String userNick;
	private String alipay;
	private Long mobile;
	private float amount = 0.0f;
	private int point = 0;
	private Date createDate;
	private Date createTime;
	private Integer billStatus;
	private String responseError;
	private Date payDate;
	private Date payTime;
	private Integer pushStatus;
	private String message;
	private Long writeBackStatus;
	public Long getBillId() {
		return billId;
	}
	public void setBillId(Long billId) {
		this.billId = billId;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public Long getOuterId1() {
		return outerId1;
	}
	public void setOuterId1(Long outerId1) {
		this.outerId1 = outerId1;
	}
	public Long getOuterId2() {
		return outerId2;
	}
	public void setOuterId2(Long outerId2) {
		this.outerId2 = outerId2;
	}
	public Long getOuterId3() {
		return outerId3;
	}
	public void setOuterId3(Long outerId3) {
		this.outerId3 = outerId3;
	}
	public Long getOuterRef() {
		return outerRef;
	}
	public void setOuterRef(Long outerRef) {
		this.outerRef = outerRef;
	}
	public String getOuterRef1() {
		return outerRef1;
	}
	public void setOuterRef1(String outerRef1) {
		this.outerRef1 = outerRef1;
	}
	public Integer getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getAlipay() {
		return alipay;
	}
	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(Integer billStatus) {
		this.billStatus = billStatus;
	}
	public String getResponseError() {
		return responseError;
	}
	public void setResponseError(String responseError) {
		this.responseError = responseError;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Integer getPushStatus() {
		return pushStatus;
	}
	public void setPushStatus(Integer pushStatus) {
		this.pushStatus = pushStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getWriteBackStatus() {
		return writeBackStatus;
	}
	public void setWriteBackStatus(Long writeBackStatus) {
		this.writeBackStatus = writeBackStatus;
	}
	
}

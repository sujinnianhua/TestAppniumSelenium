package cn.taofen8.model;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {
    private static final long serialVersionUID = -3062624190229170143L;

    /**
     * ID
     */
    private Long id;
    /**
     * 用户昵称
     */
    private String nick;
    /**
     * 用户淘宝昵称
     */
    private String taobaoNick;
    /**
     * 用户客户端手机号码串号 (现在应该不维护了 2015-8-12 yehang)
     */
    private String imsi;
    /**
     * 用户客户端手机串号 (现在应该不维护了 2015-8-12 yehang)
     */
    private String imei;
    /**
     * 用户手机号码
     */
    private String mobile;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户支付宝帐号
     */
    private String alipay;
    /**
     * 客户端类型 (现在应该不维护了 2015-8-12 yehang)
     */
    private String clientType;
    /**
     * 客户端版本 (现在应该不维护了 2015-8-12 yehang)
     */
    private String clientVersion;
    /**
     * 用户最后一次登录时间
     */
    private Date lastLoginTime;
    /**
     * 用户支付宝实际姓名
     */
    private String alipayRealName;
    /**
     * 用户来源
     */
    private String refer;
    /**
     * 用户淘宝信用等级，新用户默认等级为-1
     */
    private int level = -1;
    /**
     * 首次登录时间
     */
    private Date firstLoginTime;
    /**
     * 登录次数 max 2012-3-12
     */
    private Integer loginTimes;
    /**
     * 表里面字段都没，不知道这是干嘛的
     */
    private String ip;
    /**
     * 表里面字段都没，不知道这是干嘛的
     */
    private String auth;
    /**
     * 性别
     */
    private String sex;
    /**
     * 来源渠道，数据由BI完成录入
     */
    private String channel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getTaobaoNick() {
        return taobaoNick;
    }

    public void setTaobaoNick(String taobaoNick) {
        this.taobaoNick = taobaoNick;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getAlipayRealName() {
        return alipayRealName;
    }

    public void setAlipayRealName(String alipayRealName) {
        this.alipayRealName = alipayRealName;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getFirstLoginTime() {
        return firstLoginTime;
    }

    public void setFirstLoginTime(Date firstLoginTime) {
        this.firstLoginTime = firstLoginTime;
    }

    public Integer getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}

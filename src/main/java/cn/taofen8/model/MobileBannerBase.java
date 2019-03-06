package cn.taofen8.model;

import java.util.Date;
import java.util.List;

public class MobileBannerBase {

	private static final long serialVersionUID = -1810610159022152976L;

	private Long id;

	/**
	 * 类型，例如home表示首页banner
	 */
	private String type;

	/**
	 * 排序号，倒序
	 */
	private Integer position;

	/**
	 * 事件类型
	 */
	private String eventType;

	/**
	 * 事件参数
	 */
	private String eventArg;

	/**
	 * banner是否需要显示按该json字符串，程序中去过滤
	 * json字符串device,channel,version,is_login
	 * device:android,iphone表示在该平台下显示
	 * channel:例如不包含360渠道，则该banner不显示
	 * version:>5.9表示在该版本以上才能显示
	 * isLogin:是否需要登录
	 * {"switchMore":"YES","hour":"8#12","level":"3#8"}
	 */
	private String conditionStr;

	/**
	 * 创建人
	 */
	private String createBy;

	private Date startTime;

	private Date endTime;

	private Date createTime;

	private Date updateTime;

	public static final String TYPE_HOME = "home"; 		//客户端首页BANNER类型，8.0以下版本
	public static final String TYPE_GLOBAL = "global";	 //启动弹出的全局banner
	public static final String TYPE_NEW_GIFT = "newGift"; //新人有礼banner
	public static final String TYPE_SHAKE_RESULT = "shakeResult";	 //摇奖结果_配置图片
	public static final String TYPE_SHAKE_INIT = "shakeInit";	     //摇奖界面初始化_底部配置图片
	public static final String TYPE_SECKILL_LIST = "seckillList";//秒杀列表页banner
	public static final String TYPE_YIYUANGOU_LIST = "yiyuangou";//一元购页面头部banner
	public static final String TYPE_HOME_80 = "home_80"; 		//客户端首页8.0版本及以上版本BANNER类型
	public static final String TYPE_YYG_WXGROUP_IMG = "yygWxgroupImg";//一元购用户群二维码图片
	public static final String TYPE_9_9_INDEX = "9_9_index";//一元购用户群二维码图片
	public static final String TYPE_PIN_PAI = "pinPaiBanner";//品牌上新banner

	
	/**
	 * APP 8.3开始的类目详情页接口
	 */
	public static final String TYPE_CATEGORY = "category";
	public static final String TYPE_TASK_CENTER = "taskCenter";
	
	private List<MobileBannerImage> imageList;

	public List<MobileBannerImage> getImageList() {
		return imageList;
	}

	public void setImageList(List<MobileBannerImage> imageList) {
		this.imageList = imageList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getEventArg() {
		return eventArg;
	}

	public void setEventArg(String eventArg) {
		this.eventArg = eventArg == null ? null : eventArg.trim();
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	public String getConditionStr() {
		return conditionStr;
	}

	public void setConditionStr(String conditionStr) {
		this.conditionStr = conditionStr;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

}
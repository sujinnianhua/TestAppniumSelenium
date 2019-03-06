package cn.taofen8.model;

import java.util.Date;

public class Sms {
	private int id;
	private Long tf8_seq_no;
	private String platform_seq_no;
	private String sms_type;
	private String send_status;
	private String platform_send_code;
	private String response_status;
	private String costomize_type;
	private String content;
	private String error_msg;
	private String mobile;
	private Date send_time;
	private Date request_time;
	private Date submit_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getTf8_seq_no() {
		return tf8_seq_no;
	}
	public void setTf8_seq_no(Long tf8_seq_no) {
		this.tf8_seq_no = tf8_seq_no;
	}
	public String getPlatform_seq_no() {
		return platform_seq_no;
	}
	public void setPlatform_seq_no(String platform_seq_no) {
		this.platform_seq_no = platform_seq_no;
	}
	public String getSms_type() {
		return sms_type;
	}
	public void setSms_type(String sms_type) {
		this.sms_type = sms_type;
	}
	public String getSend_status() {
		return send_status;
	}
	public void setSend_status(String send_status) {
		this.send_status = send_status;
	}
	public String getPlatform_send_code() {
		return platform_send_code;
	}
	public void setPlatform_send_code(String platform_send_code) {
		this.platform_send_code = platform_send_code;
	}
	public String getResponse_status() {
		return response_status;
	}
	public void setResponse_status(String response_status) {
		this.response_status = response_status;
	}
	public String getCostomize_type() {
		return costomize_type;
	}
	public void setCostomize_type(String costomize_type) {
		this.costomize_type = costomize_type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getError_msg() {
		return error_msg;
	}
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public Date getRequest_time() {
		return request_time;
	}
	public void setRequest_time(Date request_time) {
		this.request_time = request_time;
	}
	public Date getSubmit_time() {
		return submit_time;
	}
	public void setSubmit_time(Date submit_time) {
		this.submit_time = submit_time;
	}
	public Date getReceive_time() {
		return receive_time;
	}
	public void setReceive_time(Date receive_time) {
		this.receive_time = receive_time;
	}
	public Date getReport_time() {
		return report_time;
	}
	public void setReport_time(Date report_time) {
		this.report_time = report_time;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public int getBatch_send_flag() {
		return batch_send_flag;
	}
	public void setBatch_send_flag(int batch_send_flag) {
		this.batch_send_flag = batch_send_flag;
	}
	public int getFilter_blacklist() {
		return filter_blacklist;
	}
	public void setFilter_blacklist(int filter_blacklist) {
		this.filter_blacklist = filter_blacklist;
	}
	private Date receive_time;
	private Date report_time;
	private String platform;
	private int batch_send_flag;
	private int filter_blacklist;
}

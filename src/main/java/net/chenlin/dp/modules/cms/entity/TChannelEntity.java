package net.chenlin.dp.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 渠道表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月04日 PM11:36:39
 */
public class TChannelEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标识
	 */
	private Integer id;

	/**
	 * 帐号名
	 */
	private String account;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 渠道名称
	 */
	private String name;

	/**公司名称*/
	private String company;


	/**
	 * 联系人
	 */
	private String contact;

	/**
	 * 联系电话
	 */
	private String phone;

	/**
	 * 职务
	 */
	private String position;

	/**
	 * 收款账号
	 */
	private String payment;

	/**
	 * 0:上架  1：下架
	 */
	private Integer status;

	/**
	 * 渠道类型
	 */
	private Integer channelType;

	/**
	 * 支付方式  1：对公  2：对私
	 */
	private Integer payType;

	/**
	 * 结算方式
	 */
	private Integer settlementType;

	/**
	 * 合作方式
	 */
	private Integer cooperationType;

	/**
	 * 公司地址
	 */
	private String address;

	/**
	 * 渠道商信息
	 */
	private String content;

	/**
	 * 我司对接人
	 */
	private String userName;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 创建人id
	 */
	private String createBy;

	/**
	 * 修改人id
	 */
	private Date gmtModified;

	/**
	 * 修改人id
	 */
	private String updateBy;

	/**
	 * 删除标记   0：正常  1：删除
	 */
	private Integer delFlag;


	public TChannelEntity() {
		super();
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccount() {
		return account;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContact() {
		return contact;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getPayment() {
		return payment;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}

	public Integer getChannelType() {
		return channelType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setSettlementType(Integer settlementType) {
		this.settlementType = settlementType;
	}

	public Integer getSettlementType() {
		return settlementType;
	}

	public void setCooperationType(Integer cooperationType) {
		this.cooperationType = cooperationType;
	}

	public Integer getCooperationType() {
		return cooperationType;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

}

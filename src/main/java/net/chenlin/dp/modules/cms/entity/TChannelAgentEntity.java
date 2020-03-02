package net.chenlin.dp.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 渠道的代理(推广)表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月04日 PM11:37:12
 */
public class TChannelAgentEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标识
	 */
	private Integer id;

	/**
	 * 渠道id
	 */
	private Integer channelId;

	private String channelName;

	/**
	 * 推广码
	 */
	private String code;

	/**
	 * 位置组名称
	 */
	private String name;

	/**
	 * 帐号
	 */
	private String account;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 结算方式  1：对公  2：对私
	 */
	private Integer payType;

	/**
	 * 镜像地址
	 */
	private String mirrorUrl;

	/**
	 * 推广地址
	 */
	private String linkUrl;

	private Integer linkId;

	/**
	 * 详细信息
	 */
	private String content;

	/**扣量系数*/
	private Double discount;

	/**初始数*/
	private int initNumber;

	/**
	 * 单价
	 */
	private Double price;

	/**
	 * 0:上架  1：下架
	 */
	private Integer status;

	/**
	 * 我司对接人员
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
	 * 修改时间
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


	public TChannelAgentEntity() {
		super();
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public int getInitNumber() {
		return initNumber;
	}

	public void setInitNumber(int initNumber) {
		this.initNumber = initNumber;
	}

	public Integer getLinkId() {
		return linkId;
	}

	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
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

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setMirrorUrl(String mirrorUrl) {
		this.mirrorUrl = mirrorUrl;
	}

	public String getMirrorUrl() {
		return mirrorUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
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

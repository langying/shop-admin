package net.chenlin.dp.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * banner表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:09:52
 */
public class TAdvertEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 唯一标识
	 */
	private Integer id;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 封面
	 */
	private String coverUrl;
	
	/**
	 * 产品id
	 */
	private Integer productId;
	
	/**
	 * 类型：1  产品详情
	 */
	private Integer type;
	
	/**
	 * 第三方链接地址
	 */
	private String linkUrl;
	
	/**
	 * 状态 0：正常  1：下架
	 */
	private Integer status=0;
	
	/**
	 * 点击总数
	 */
	private Integer clickTotal;
	
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
	private Integer delFlag=0;

	/**产品名称*/
	private String name;
	

	public TAdvertEntity() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	
	public String getCoverUrl() {
		return coverUrl;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	
	public String getLinkUrl() {
		return linkUrl;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setClickTotal(Integer clickTotal) {
		this.clickTotal = clickTotal;
	}
	
	public Integer getClickTotal() {
		return clickTotal;
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

package net.chenlin.dp.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 产品栏目表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:44:02
 */
public class TColumnEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 栏目id
	 */
	private Integer id;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 栏目名称
	 */
	private String name;
	
	/**
	 * 栏目的封面图
	 */
	private String imgUrl;
	
	/**
	 * 栏目描述
	 */
	private String describe;
	
	/**
	 * 金额范围
	 */
	private String amountScope;
	
	/**
	 * 0:上架  1：下架
	 */
	private Integer status;
	
	/**
	 * 0 不推荐  1：推荐
	 */
	private Integer type;
	
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
	 * 修改时间
	 */
	private String updateBy;
	
	/**
	 * 删除标记   0：正常  1：删除
	 */
	private Integer delFlag;
	

	public TColumnEntity() {
		super();
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
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public String getDescribe() {
		return describe;
	}
	
	public void setAmountScope(String amountScope) {
		this.amountScope = amountScope;
	}
	
	public String getAmountScope() {
		return amountScope;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getType() {
		return type;
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

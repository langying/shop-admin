package net.chenlin.dp.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 首页推荐位表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午4:45:44
 */
public class TPromoteEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 唯一id
	 */
	private Integer id;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 描述
	 */
	private String describe;
	
	/**
	 * 封面
	 */
	private String imgUrl;
	
	/**
	 * 1.分类引导 2.产品类别 3.指定产品
	 */
	private Integer type;
	
	/**
	 * 栏目id
	 */
	private Integer columnId;

	/**产品id*/

	private Integer productId;

	/**栏目名称*/
	private String columnName;

	/**产品名称*/
	private String productName;

	
	/**
	 * 链接地址
	 */
	private String linkUrl;
	
	/**
	 * 越小越前面
	 */
	private Integer orderNum;
	
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
	

	public TPromoteEntity() {
		super();
	}


	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public String getDescribe() {
		return describe;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}
	
	public Integer getColumnId() {
		return columnId;
	}
	
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	
	public String getLinkUrl() {
		return linkUrl;
	}
	
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
	public Integer getOrderNum() {
		return orderNum;
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

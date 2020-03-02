package net.chenlin.dp.modules.cms.entity;

import java.io.Serializable;



/**
 * 产品栏目关联表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月28日 下午7:25:02
 */
public class TProductColumnEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 唯一标识id
	 */
	private Integer id;
	
	/**
	 * 产品id
	 */
	private Integer productId;
	
	/**
	 * 栏目id
	 */
	private Integer columnId;
	
	/**
	 * 越小越前
	 */
	private Integer orderNum;
	

	public TProductColumnEntity() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}
	
	public Integer getColumnId() {
		return columnId;
	}
	
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
	public Integer getOrderNum() {
		return orderNum;
	}
	
}

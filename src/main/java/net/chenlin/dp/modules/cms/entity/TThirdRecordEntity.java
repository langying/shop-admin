package net.chenlin.dp.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 第三方统计表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年10月22日 下午6:55:55
 */
public class TThirdRecordEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 唯一标识id
	 */
	private Integer id;
	
	/**
	 * 第三方链接
	 */
	private Integer thirdId;

	/**第三方名称*/
	private String name;

	
	/**
	 * 日期
	 */
	private String days;
	
	/**
	 * 
	 */
	private Integer uv;
	
	/**
	 * 
	 */
	private Integer pv;
	
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	
	/**
	 * 创建人
	 */
	private String createBy;
	
	/**
	 * 修改时间
	 */
	private Date gmtModified;
	
	/**
	 * 修改人
	 */
	private String updateBy;
	
	/**
	 * 删除标记    0：正常   1：删除
	 */
	private Integer delFlag;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TThirdRecordEntity() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setThirdId(Integer thirdId) {
		this.thirdId = thirdId;
	}
	
	public Integer getThirdId() {
		return thirdId;
	}
	
	public void setDays(String days) {
		this.days = days;
	}
	
	public String getDays() {
		return days;
	}
	
	public void setUv(Integer uv) {
		this.uv = uv;
	}
	
	public Integer getUv() {
		return uv;
	}
	
	public void setPv(Integer pv) {
		this.pv = pv;
	}
	
	public Integer getPv() {
		return pv;
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

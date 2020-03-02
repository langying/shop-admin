package net.chenlin.dp.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 产品表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:10:20
 */
public class TProductEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 唯一标识
	 */
	private Integer id;
	
	/**
	 * 产品名称
	 */
	private String name;

	private String merchantsName;
	
	/**
	 * logo地址
	 */
	private String logoUrl;
	
	/**
	 * 最低贷款金额
	 */
	private Integer loanAmountMin;
	
	/**
	 * 贷款金额最高
	 */
	private Integer loanAmountMax;
	
	/**
	 * 放款时间
	 */
	private String payTime;
	
	/**
	 * 默认为：1 现金贷
	 */
	private Integer type;
	
	/**
	 * 推荐  0：不推荐  1：推荐
	 */
	private Integer recommendFlag;
	
	/**
	 * 申请条件
	 */
	private String applyData="";
	
	/**
	 * 产品特色
	 */
	private String featuresData="";
	
	/**
	 * 贷款利率  %
	 */
	private Double rateScope;
	
	/**
	 * 利率单位
	 */
	private String rateUnit;
	
	/**
	 * 最低借款期限
	 */
	private Integer borrowMin;
	
	/**
	 * 最高借款期限
	 */
	private Integer borrowMax;
	
	/**
	 * 借款单位 1:天  2：月  3：年
	 */
	private Integer borrowUnit;
	
	/**
	 * 标签
	 */
	private String labels;

	private int labelG;

	private int labelK;

	private int labelX;
	
	/**
	 * 评分等级  0-5
	 */
	private Integer score;
	
	/**
	 * 状态  0：正常  1：下架
	 */
	private Integer status=0;
	
	/**
	 * 排序值 越大越前面
	 */
	private Integer orderNum;
	
	/**
	 * 第三方链接地址
	 */
	private String linkUrl;
	
	/**
	 * 申请总人数
	 */
	private Integer applyTotal=60000;


	/**产品后台内容*/
	private String content="";

	/**所有产品的排序*/
	private Integer sortNum;
	
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

	//查询字段
	private String loanAmount;

	private String borrow;

	private String rate;

	//产品介绍
	private String introduce;
	//产品描述
	private String describe;
	//栏目组
	private String columns;

	private Double price;

	private Integer merchantsId;

	private Integer hotFlag;

	private Integer cooperationType;

	private Integer lendNum;


	public Integer getLendNum() {
		return lendNum;
	}

	public void setLendNum(Integer lendNum) {
		this.lendNum = lendNum;
	}

	public Integer getCooperationType() {
		return cooperationType;
	}

	public void setCooperationType(Integer cooperationType) {
		this.cooperationType = cooperationType;
	}

	public Integer getHotFlag() {
		return hotFlag;
	}

	public void setHotFlag(Integer hotFlag) {
		this.hotFlag = hotFlag;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getMerchantsId() {
		return merchantsId;
	}

	public void setMerchantsId(Integer merchantsId) {
		this.merchantsId = merchantsId;
	}

	public String getMerchantsName() {
		return merchantsName;
	}

	public void setMerchantsName(String merchantsName) {
		this.merchantsName = merchantsName;
	}

	/**栏目列表*/
	private String [] colId;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public String[] getColId() {
		return colId;
	}

	public void setColId(String[] colId) {
		this.colId = colId;
	}

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getBorrow() {
		return borrow;
	}

	public void setBorrow(String borrow) {
		this.borrow = borrow;
	}

	public int getLabelG() {
		return labelG;
	}

	public void setLabelG(int labelG) {
		this.labelG = labelG;
	}

	public int getLabelK() {
		return labelK;
	}

	public void setLabelK(int labelK) {
		this.labelK = labelK;
	}

	public int getLabelX() {
		return labelX;
	}

	public void setLabelX(int labelX) {
		this.labelX = labelX;
	}

	public TProductEntity() {
		super();
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
	
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	
	public String getLogoUrl() {
		return logoUrl;
	}
	
	public void setLoanAmountMin(Integer loanAmountMin) {
		this.loanAmountMin = loanAmountMin;
	}
	
	public Integer getLoanAmountMin() {
		return loanAmountMin;
	}
	
	public void setLoanAmountMax(Integer loanAmountMax) {
		this.loanAmountMax = loanAmountMax;
	}
	
	public Integer getLoanAmountMax() {
		return loanAmountMax;
	}
	
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	
	public String getPayTime() {
		return payTime;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setRecommendFlag(Integer recommendFlag) {
		this.recommendFlag = recommendFlag;
	}
	
	public Integer getRecommendFlag() {
		return recommendFlag;
	}
	
	public void setApplyData(String applyData) {
		this.applyData = applyData;
	}
	
	public String getApplyData() {
		return applyData;
	}
	
	public void setFeaturesData(String featuresData) {
		this.featuresData = featuresData;
	}
	
	public String getFeaturesData() {
		return featuresData;
	}
	
	public void setRateScope(Double rateScope) {
		this.rateScope = rateScope;
	}
	
	public Double getRateScope() {
		return rateScope;
	}
	
	public void setRateUnit(String rateUnit) {
		this.rateUnit = rateUnit;
	}
	
	public String getRateUnit() {
		return rateUnit;
	}
	
	public void setBorrowMin(Integer borrowMin) {
		this.borrowMin = borrowMin;
	}
	
	public Integer getBorrowMin() {
		return borrowMin;
	}
	
	public void setBorrowMax(Integer borrowMax) {
		this.borrowMax = borrowMax;
	}
	
	public Integer getBorrowMax() {
		return borrowMax;
	}
	
	public void setBorrowUnit(Integer borrowUnit) {
		this.borrowUnit = borrowUnit;
	}
	
	public Integer getBorrowUnit() {
		return borrowUnit;
	}
	
	public void setLabels(String labels) {
		this.labels = labels;
	}
	
	public String getLabels() {
		return labels;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
	public Integer getOrderNum() {
		return orderNum;
	}
	
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	
	public String getLinkUrl() {
		return linkUrl;
	}
	
	public void setApplyTotal(Integer applyTotal) {
		this.applyTotal = applyTotal;
	}
	
	public Integer getApplyTotal() {
		return applyTotal;
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

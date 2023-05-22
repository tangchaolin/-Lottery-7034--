package cn.itedus.lottery.infrastructure.po;

import java.util.Date;

/*
 * @description: 活动
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/17 0017
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class Activity {
   // 自增ID
   private Long id;

   // 活动ID
   private Long activityId;

   // 活动名称
   private String activityName;

   // 活动描述
   private String activityDesc;

   // 开始时间
   private Date beginDateTime;

   // 结束时间
   private Date endDateTime;

   // 库存
   private Integer stockCount;

   /**
    * 库存剩余
    */
   private Integer stockSurplusCount;

   // 每人可参与次数(日)
   private Integer takeCount;

   /**
    * 策略id
    */
   private Long strategyId;
   // 活动状态：编辑、提审、撤审、通过、运行、拒绝、关闭、开启
   private Integer state;

   // 创建人
   private String creator;

   // 创建时间
   private Date createTime;

   // 修改时间
   private Date updateTime;

   public Activity() {
   }

   public Activity(Long id, Long activityId, String activityName, String activityDesc, Date beginDateTime, Date endDateTime, Integer stockCount, Integer stockSurplusCount, Integer takeCount, Long strategyId, Integer state, String creator, Date createTime, Date updateTime) {
      this.id = id;
      this.activityId = activityId;
      this.activityName = activityName;
      this.activityDesc = activityDesc;
      this.beginDateTime = beginDateTime;
      this.endDateTime = endDateTime;
      this.stockCount = stockCount;
      this.stockSurplusCount = stockSurplusCount;
      this.takeCount = takeCount;
      this.strategyId = strategyId;
      this.state = state;
      this.creator = creator;
      this.createTime = createTime;
      this.updateTime = updateTime;
   }

   /**
    * 获取
    * @return id
    */
   public Long getId() {
      return id;
   }

   /**
    * 设置
    * @param id
    */
   public void setId(Long id) {
      this.id = id;
   }

   /**
    * 获取
    * @return activityId
    */
   public Long getActivityId() {
      return activityId;
   }

   /**
    * 设置
    * @param activityId
    */
   public void setActivityId(Long activityId) {
      this.activityId = activityId;
   }

   /**
    * 获取
    * @return activityName
    */
   public String getActivityName() {
      return activityName;
   }

   /**
    * 设置
    * @param activityName
    */
   public void setActivityName(String activityName) {
      this.activityName = activityName;
   }

   /**
    * 获取
    * @return activityDesc
    */
   public String getActivityDesc() {
      return activityDesc;
   }

   /**
    * 设置
    * @param activityDesc
    */
   public void setActivityDesc(String activityDesc) {
      this.activityDesc = activityDesc;
   }

   /**
    * 获取
    * @return beginDateTime
    */
   public Date getBeginDateTime() {
      return beginDateTime;
   }

   /**
    * 设置
    * @param beginDateTime
    */
   public void setBeginDateTime(Date beginDateTime) {
      this.beginDateTime = beginDateTime;
   }

   /**
    * 获取
    * @return endDateTime
    */
   public Date getEndDateTime() {
      return endDateTime;
   }

   /**
    * 设置
    * @param endDateTime
    */
   public void setEndDateTime(Date endDateTime) {
      this.endDateTime = endDateTime;
   }

   /**
    * 获取
    * @return stockCount
    */
   public Integer getStockCount() {
      return stockCount;
   }

   /**
    * 设置
    * @param stockCount
    */
   public void setStockCount(Integer stockCount) {
      this.stockCount = stockCount;
   }

   /**
    * 获取
    * @return stockSurplusCount
    */
   public Integer getStockSurplusCount() {
      return stockSurplusCount;
   }

   /**
    * 设置
    * @param stockSurplusCount
    */
   public void setStockSurplusCount(Integer stockSurplusCount) {
      this.stockSurplusCount = stockSurplusCount;
   }

   /**
    * 获取
    * @return takeCount
    */
   public Integer getTakeCount() {
      return takeCount;
   }

   /**
    * 设置
    * @param takeCount
    */
   public void setTakeCount(Integer takeCount) {
      this.takeCount = takeCount;
   }

   /**
    * 获取
    * @return strategyId
    */
   public Long getStrategyId() {
      return strategyId;
   }

   /**
    * 设置
    * @param strategyId
    */
   public void setStrategyId(Long strategyId) {
      this.strategyId = strategyId;
   }

   /**
    * 获取
    * @return state
    */
   public Integer getState() {
      return state;
   }

   /**
    * 设置
    * @param state
    */
   public void setState(Integer state) {
      this.state = state;
   }

   /**
    * 获取
    * @return creator
    */
   public String getCreator() {
      return creator;
   }

   /**
    * 设置
    * @param creator
    */
   public void setCreator(String creator) {
      this.creator = creator;
   }

   /**
    * 获取
    * @return createTime
    */
   public Date getCreateTime() {
      return createTime;
   }

   /**
    * 设置
    * @param createTime
    */
   public void setCreateTime(Date createTime) {
      this.createTime = createTime;
   }

   /**
    * 获取
    * @return updateTime
    */
   public Date getUpdateTime() {
      return updateTime;
   }

   /**
    * 设置
    * @param updateTime
    */
   public void setUpdateTime(Date updateTime) {
      this.updateTime = updateTime;
   }

   public String toString() {
      return "Activity{id = " + id + ", activityId = " + activityId + ", activityName = " + activityName + ", activityDesc = " + activityDesc + ", beginDateTime = " + beginDateTime + ", endDateTime = " + endDateTime + ", stockCount = " + stockCount + ", stockSurplusCount = " + stockSurplusCount + ", takeCount = " + takeCount + ", strategyId = " + strategyId + ", state = " + state + ", creator = " + creator + ", createTime = " + createTime + ", updateTime = " + updateTime + "}";
   }
}



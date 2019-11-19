package cn.xs.sh.telcom.bean;

import java.util.Date;

public class ActivityLog {
    private Long id;

    private Long userId;

    private Long buId;

    private String userNo;
    private String buNo;
    private String beginTime;
    private String endTime;
    public String getUserNo() {
        return userNo;
    }
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
    public String getBuNo() {
        return buNo;
    }
    public void setBuNo(String buNo) {
        this.buNo = buNo;
    }
    public String getBeginTime() {
        return beginTime;
    }
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    private String voiceLocation;

    private Integer category;

    private Date createDate;

    private String result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBuId() {
        return buId;
    }

    public void setBuId(Long buId) {
        this.buId = buId;
    }

    public String getVoiceLocation() {
        return voiceLocation;
    }

    public void setVoiceLocation(String voiceLocation) {
        this.voiceLocation = voiceLocation == null ? null : voiceLocation.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}
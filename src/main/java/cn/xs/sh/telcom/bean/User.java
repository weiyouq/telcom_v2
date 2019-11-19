package cn.xs.sh.telcom.bean;

import java.util.Date;

public class User {
    private Long id;

    private String userId;

    private Integer enrolType;

    private String usedUserId;

    private Integer userState;

    private String buNo;

    private String activityCount;
    private String onePreMod;
    private String twoPreMod;
    private String verifyNotice;
    private String deleteCount;

    private Date activityEnrolDate;
    private Date noticeEnrolDate;
    private Date pre1EnrolDate;
    private Date pre2EnrolDate;
    private Date deleteEnrolDate;

    public Date getActivityEnrolDate() {
        return activityEnrolDate;
    }

    public void setActivityEnrolDate(Date activityEnrolDate) {
        this.activityEnrolDate = activityEnrolDate;
    }

    public Date getNoticeEnrolDate() {
        return noticeEnrolDate;
    }

    public void setNoticeEnrolDate(Date noticeEnrolDate) {
        this.noticeEnrolDate = noticeEnrolDate;
    }

    public Date getPre1EnrolDate() {
        return pre1EnrolDate;
    }

    public void setPre1EnrolDate(Date pre1EnrolDate) {
        this.pre1EnrolDate = pre1EnrolDate;
    }

    public Date getPre2EnrolDate() {
        return pre2EnrolDate;
    }

    public void setPre2EnrolDate(Date pre2EnrolDate) {
        this.pre2EnrolDate = pre2EnrolDate;
    }

    public Date getDeleteEnrolDate() {
        return deleteEnrolDate;
    }

    public void setDeleteEnrolDate(Date deleteEnrolDate) {
        this.deleteEnrolDate = deleteEnrolDate;
    }

    public String getDeleteCount() {
        return deleteCount;
    }

    public void setDeleteCount(String deleteCount) {
        this.deleteCount = deleteCount;
    }

    public String getActivityCount() {
        return activityCount;
    }

    public void setActivityCount(String activityCount) {
        this.activityCount = activityCount;
    }

    public String getOnePreMod() {
        return onePreMod;
    }

    public void setOnePreMod(String onePreMod) {
        this.onePreMod = onePreMod;
    }

    public String getTwoPreMod() {
        return twoPreMod;
    }

    public void setTwoPreMod(String twoPreMod) {
        this.twoPreMod = twoPreMod;
    }

    public String getVerifyNotice() {
        return verifyNotice;
    }

    public void setVerifyNotice(String verifyNotice) {
        this.verifyNotice = verifyNotice;
    }

    public String getBuNo() {
        return buNo;
    }

    public void setBuNo(String buNo) {
        this.buNo = buNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getEnrolType() {
        return enrolType;
    }

    public void setEnrolType(Integer enrolType) {
        this.enrolType = enrolType;
    }

    public String getUsedUserId() {
        return usedUserId;
    }

    public void setUsedUserId(String usedUserId) {
        this.usedUserId = usedUserId == null ? null : usedUserId.trim();
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }
}
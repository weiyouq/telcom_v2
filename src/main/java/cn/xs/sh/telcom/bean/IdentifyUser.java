package cn.xs.sh.telcom.bean;

public class IdentifyUser {
    private Long id;

    private Long userId;
    private String userNo;
    private String buNo;
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

    private Integer rollFlag;

    private String buId;

    private String enrolTime;

    private Long createBy;

    private Long updateBy;

    private String updateTime;

    public IdentifyUser(Long id) {
        this.id = id;
    }

    public IdentifyUser() {
    }

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

    public Integer getRollFlag() {
        return rollFlag;
    }

    public void setRollFlag(Integer rollFlag) {
        this.rollFlag = rollFlag;
    }

    public String getBuId() {
        return buId;
    }

    public void setBuId(String buId) {
        this.buId = buId == null ? null : buId.trim();
    }

    public String getEnrolTime() {
        return enrolTime;
    }

    public void setEnrolTime(String enrolTime) {
        this.enrolTime = enrolTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
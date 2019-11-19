package cn.xs.sh.telcom.bean;

import java.util.Date;

public class EnrolTouch {
    private Long id;

    private String audioPath;

    private String createDate;

    private Integer downloadStatus;

    private Date downloadDate;

    private String downloadError;

    private Integer enrolStatus;

    private Date enrolDate;

    private String enrolError;

    private Integer enrolRecord;

    private String userNo;
    private String buNo;
    private String beginTime;
    private String endTime;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        if (downloadStatus == 3){
            this.result = "下载时出错" + downloadError;
            return;
        }
        if (enrolStatus == 1){
            this.result = "注册时出错" + enrolError;
            return;
        }
        if (downloadStatus == 0 && enrolStatus ==0){
            this.result = "该音频还未进行注册";
            return;
        }
        this.result = null;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath == null ? null : audioPath.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public Integer getDownloadStatus() {
        return downloadStatus;
    }

    public void setDownloadStatus(Integer downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }

    public String getDownloadError() {
        return downloadError;
    }

    public void setDownloadError(String downloadError) {
        this.downloadError = downloadError == null ? null : downloadError.trim();
    }

    public Integer getEnrolStatus() {
        return enrolStatus;
    }

    public void setEnrolStatus(Integer enrolStatus) {
        this.enrolStatus = enrolStatus;
    }

    public Date getEnrolDate() {
        return enrolDate;
    }

    public void setEnrolDate(Date enrolDate) {
        this.enrolDate = enrolDate;
    }

    public String getEnrolError() {
        return enrolError;
    }

    public void setEnrolError(String enrolError) {
        this.enrolError = enrolError == null ? null : enrolError.trim();
    }

    public Integer getEnrolRecord() {
        return enrolRecord;
    }

    public void setEnrolRecord(Integer enrolRecord) {
        this.enrolRecord = enrolRecord;
    }
}
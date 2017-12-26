package com.clz.User.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/22.
 */
public class SysOperator implements Serializable{
    private Long staffId;

    private String code;

    private String staffName;

    private Long organizeId;

    private String organizeName;

    private String password;

    private String recentPassword;

    private String billId;

    private String email;

    private Short recentPassTimes;

    private String allowChangePassword;

    private String multiLoginFlag;

    private Long lastLoginLogId;

    private Short tryTimes;

    private String lockFlag;

    private String isLogin;

    private String isSuperUser;

    private String notes;

    private Long passwdValidDays;

    private Date passwordValidDate;

    private Long chgPasswdAlarmDays;

    private Date birthday;

    private Short marryStatus;

    private Short gender;

    private Short religion;

    private Short nationalType;

    private Short educationLevel;

    private Long incomeLevel;

    private Short staffLevel;

    private Long state;

    private Long doneCode;

    private Date createDate;

    private Date doneDate;

    private Date validDate;

    private Date expireDate;

    private Long createStaffId;

    private Short chgPasswdFlag;

    private static final long serialVersionUID = 1L;

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public Long getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(Long organizeId) {
        this.organizeId = organizeId;
    }

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName == null ? null : organizeName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRecentPassword() {
        return recentPassword;
    }

    public void setRecentPassword(String recentPassword) {
        this.recentPassword = recentPassword == null ? null : recentPassword.trim();
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Short getRecentPassTimes() {
        return recentPassTimes;
    }

    public void setRecentPassTimes(Short recentPassTimes) {
        this.recentPassTimes = recentPassTimes;
    }

    public String getAllowChangePassword() {
        return allowChangePassword;
    }

    public void setAllowChangePassword(String allowChangePassword) {
        this.allowChangePassword = allowChangePassword == null ? null : allowChangePassword.trim();
    }

    public String getMultiLoginFlag() {
        return multiLoginFlag;
    }

    public void setMultiLoginFlag(String multiLoginFlag) {
        this.multiLoginFlag = multiLoginFlag == null ? null : multiLoginFlag.trim();
    }

    public Long getLastLoginLogId() {
        return lastLoginLogId;
    }

    public void setLastLoginLogId(Long lastLoginLogId) {
        this.lastLoginLogId = lastLoginLogId;
    }

    public Short getTryTimes() {
        return tryTimes;
    }

    public void setTryTimes(Short tryTimes) {
        this.tryTimes = tryTimes;
    }

    public String getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag == null ? null : lockFlag.trim();
    }

    public String getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin == null ? null : isLogin.trim();
    }

    public String getIsSuperUser() {
        return isSuperUser;
    }

    public void setIsSuperUser(String isSuperUser) {
        this.isSuperUser = isSuperUser == null ? null : isSuperUser.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public Long getPasswdValidDays() {
        return passwdValidDays;
    }

    public void setPasswdValidDays(Long passwdValidDays) {
        this.passwdValidDays = passwdValidDays;
    }

    public Date getPasswordValidDate() {
        return passwordValidDate;
    }

    public void setPasswordValidDate(Date passwordValidDate) {
        this.passwordValidDate = passwordValidDate;
    }

    public Long getChgPasswdAlarmDays() {
        return chgPasswdAlarmDays;
    }

    public void setChgPasswdAlarmDays(Long chgPasswdAlarmDays) {
        this.chgPasswdAlarmDays = chgPasswdAlarmDays;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Short getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(Short marryStatus) {
        this.marryStatus = marryStatus;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Short getReligion() {
        return religion;
    }

    public void setReligion(Short religion) {
        this.religion = religion;
    }

    public Short getNationalType() {
        return nationalType;
    }

    public void setNationalType(Short nationalType) {
        this.nationalType = nationalType;
    }

    public Short getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(Short educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Long getIncomeLevel() {
        return incomeLevel;
    }

    public void setIncomeLevel(Long incomeLevel) {
        this.incomeLevel = incomeLevel;
    }

    public Short getStaffLevel() {
        return staffLevel;
    }

    public void setStaffLevel(Short staffLevel) {
        this.staffLevel = staffLevel;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getDoneCode() {
        return doneCode;
    }

    public void setDoneCode(Long doneCode) {
        this.doneCode = doneCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Long getCreateStaffId() {
        return createStaffId;
    }

    public void setCreateStaffId(Long createStaffId) {
        this.createStaffId = createStaffId;
    }

    public Short getChgPasswdFlag() {
        return chgPasswdFlag;
    }

    public void setChgPasswdFlag(Short chgPasswdFlag) {
        this.chgPasswdFlag = chgPasswdFlag;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysOperator other = (SysOperator) that;
        return (this.getStaffId() == null ? other.getStaffId() == null : this.getStaffId().equals(other.getStaffId()))
                && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
                && (this.getStaffName() == null ? other.getStaffName() == null : this.getStaffName().equals(other.getStaffName()))
                && (this.getOrganizeId() == null ? other.getOrganizeId() == null : this.getOrganizeId().equals(other.getOrganizeId()))
                && (this.getOrganizeName() == null ? other.getOrganizeName() == null : this.getOrganizeName().equals(other.getOrganizeName()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
                && (this.getRecentPassword() == null ? other.getRecentPassword() == null : this.getRecentPassword().equals(other.getRecentPassword()))
                && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
                && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
                && (this.getRecentPassTimes() == null ? other.getRecentPassTimes() == null : this.getRecentPassTimes().equals(other.getRecentPassTimes()))
                && (this.getAllowChangePassword() == null ? other.getAllowChangePassword() == null : this.getAllowChangePassword().equals(other.getAllowChangePassword()))
                && (this.getMultiLoginFlag() == null ? other.getMultiLoginFlag() == null : this.getMultiLoginFlag().equals(other.getMultiLoginFlag()))
                && (this.getLastLoginLogId() == null ? other.getLastLoginLogId() == null : this.getLastLoginLogId().equals(other.getLastLoginLogId()))
                && (this.getTryTimes() == null ? other.getTryTimes() == null : this.getTryTimes().equals(other.getTryTimes()))
                && (this.getLockFlag() == null ? other.getLockFlag() == null : this.getLockFlag().equals(other.getLockFlag()))
                && (this.getIsLogin() == null ? other.getIsLogin() == null : this.getIsLogin().equals(other.getIsLogin()))
                && (this.getIsSuperUser() == null ? other.getIsSuperUser() == null : this.getIsSuperUser().equals(other.getIsSuperUser()))
                && (this.getNotes() == null ? other.getNotes() == null : this.getNotes().equals(other.getNotes()))
                && (this.getPasswdValidDays() == null ? other.getPasswdValidDays() == null : this.getPasswdValidDays().equals(other.getPasswdValidDays()))
                && (this.getPasswordValidDate() == null ? other.getPasswordValidDate() == null : this.getPasswordValidDate().equals(other.getPasswordValidDate()))
                && (this.getChgPasswdAlarmDays() == null ? other.getChgPasswdAlarmDays() == null : this.getChgPasswdAlarmDays().equals(other.getChgPasswdAlarmDays()))
                && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
                && (this.getMarryStatus() == null ? other.getMarryStatus() == null : this.getMarryStatus().equals(other.getMarryStatus()))
                && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
                && (this.getReligion() == null ? other.getReligion() == null : this.getReligion().equals(other.getReligion()))
                && (this.getNationalType() == null ? other.getNationalType() == null : this.getNationalType().equals(other.getNationalType()))
                && (this.getEducationLevel() == null ? other.getEducationLevel() == null : this.getEducationLevel().equals(other.getEducationLevel()))
                && (this.getIncomeLevel() == null ? other.getIncomeLevel() == null : this.getIncomeLevel().equals(other.getIncomeLevel()))
                && (this.getStaffLevel() == null ? other.getStaffLevel() == null : this.getStaffLevel().equals(other.getStaffLevel()))
                && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
                && (this.getDoneCode() == null ? other.getDoneCode() == null : this.getDoneCode().equals(other.getDoneCode()))
                && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
                && (this.getDoneDate() == null ? other.getDoneDate() == null : this.getDoneDate().equals(other.getDoneDate()))
                && (this.getValidDate() == null ? other.getValidDate() == null : this.getValidDate().equals(other.getValidDate()))
                && (this.getExpireDate() == null ? other.getExpireDate() == null : this.getExpireDate().equals(other.getExpireDate()))
                && (this.getCreateStaffId() == null ? other.getCreateStaffId() == null : this.getCreateStaffId().equals(other.getCreateStaffId()))
                && (this.getChgPasswdFlag() == null ? other.getChgPasswdFlag() == null : this.getChgPasswdFlag().equals(other.getChgPasswdFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStaffId() == null) ? 0 : getStaffId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getStaffName() == null) ? 0 : getStaffName().hashCode());
        result = prime * result + ((getOrganizeId() == null) ? 0 : getOrganizeId().hashCode());
        result = prime * result + ((getOrganizeName() == null) ? 0 : getOrganizeName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRecentPassword() == null) ? 0 : getRecentPassword().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getRecentPassTimes() == null) ? 0 : getRecentPassTimes().hashCode());
        result = prime * result + ((getAllowChangePassword() == null) ? 0 : getAllowChangePassword().hashCode());
        result = prime * result + ((getMultiLoginFlag() == null) ? 0 : getMultiLoginFlag().hashCode());
        result = prime * result + ((getLastLoginLogId() == null) ? 0 : getLastLoginLogId().hashCode());
        result = prime * result + ((getTryTimes() == null) ? 0 : getTryTimes().hashCode());
        result = prime * result + ((getLockFlag() == null) ? 0 : getLockFlag().hashCode());
        result = prime * result + ((getIsLogin() == null) ? 0 : getIsLogin().hashCode());
        result = prime * result + ((getIsSuperUser() == null) ? 0 : getIsSuperUser().hashCode());
        result = prime * result + ((getNotes() == null) ? 0 : getNotes().hashCode());
        result = prime * result + ((getPasswdValidDays() == null) ? 0 : getPasswdValidDays().hashCode());
        result = prime * result + ((getPasswordValidDate() == null) ? 0 : getPasswordValidDate().hashCode());
        result = prime * result + ((getChgPasswdAlarmDays() == null) ? 0 : getChgPasswdAlarmDays().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getMarryStatus() == null) ? 0 : getMarryStatus().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getReligion() == null) ? 0 : getReligion().hashCode());
        result = prime * result + ((getNationalType() == null) ? 0 : getNationalType().hashCode());
        result = prime * result + ((getEducationLevel() == null) ? 0 : getEducationLevel().hashCode());
        result = prime * result + ((getIncomeLevel() == null) ? 0 : getIncomeLevel().hashCode());
        result = prime * result + ((getStaffLevel() == null) ? 0 : getStaffLevel().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getDoneCode() == null) ? 0 : getDoneCode().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getDoneDate() == null) ? 0 : getDoneDate().hashCode());
        result = prime * result + ((getValidDate() == null) ? 0 : getValidDate().hashCode());
        result = prime * result + ((getExpireDate() == null) ? 0 : getExpireDate().hashCode());
        result = prime * result + ((getCreateStaffId() == null) ? 0 : getCreateStaffId().hashCode());
        result = prime * result + ((getChgPasswdFlag() == null) ? 0 : getChgPasswdFlag().hashCode());
        return result;
    }
}

package com.clz.User.bean;

import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/12/22.
 */
public class UserInfo {
    public final static String S_SessionId = "SESSION_ID";
    public final static String S_SerialId = "SERIAL_ID";
    public final static String S_IP = "IP";
    public final static String S_LoginInTime = "LOGIN_TIME";
    public final static String S_LogId = "LOG_ID";
    public final static String S_IsLogin = "IS_LOGIN";
    public final static String S_ID = "ID";
    public final static String S_Code = "CODE";
    public final static String S_Name = "NAME";
    public final static String S_DomainId = "DOMAIN_ID";
    public final static String S_OrgName = "ORG_NAME";
    public final static String S_OrgId = "ORG_ID";
    public final static String S_BillId = "BILL_ID";
    public final static String S_Email = "EMAIL";

    public final static String S_MultiLogin = "MULTILOGIN";
    public final static String S_AllowChPassword = "ALLOWCHPASSWORD";

    protected Map attrHashMap = new ConcurrentHashMap();

    public UserInfo() {
    }

    public UserInfo(SysOperator operator) throws Exception {
        this.setID(operator.getStaffId());
        this.setName(operator.getStaffName());
        this.setCode(operator.getCode());
        this.setBillId(operator.getBillId());
        this.setEmail(operator.getEmail());
        this.setOrgId(operator.getOrganizeId());
        this.setOrgName(operator.getOrganizeName());
    }

    public String getSerialID() {
        return (String) this.getPrivateAttr(S_SerialId);
    }

    public void setSerialID(String serialID) {
        try {
            this.setPrivateAttr(S_SerialId, serialID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getIP() {
        return (String) this.getPrivateAttr(S_IP);
    }

    public void setIP(String aIP) {
        try {
            this.setPrivateAttr(S_IP, aIP);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLoginFlag(boolean flag) throws Exception {
        try {
            this.setPrivateAttr(S_IsLogin, new Boolean(flag));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isLogined() {
        Object obj = this.getPrivateAttr(S_IsLogin);
        return (Boolean) obj;
    }

    public String getSessionID() {
        return (String) this.getPrivateAttr(S_SessionId);
    }

    public void setSessionID(String aSessionID) {
        try {
            this.setPrivateAttr(S_SessionId, aSessionID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getLogID() throws Exception {
        Object obj = this.getPrivateAttr(S_LogId);
        return (Long) obj;
    }

    public void setLogID(long pLogId) throws Exception {
        try {
            this.setPrivateAttr(S_LogId, new Long(pLogId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Timestamp getLoginTime() {
        Object obj = this.getPrivateAttr(S_LoginInTime);
        return (Timestamp) obj;
    }

    public void setLoginTime(Timestamp pTime) {
        this.setPrivateAttr(S_LoginInTime, pTime);
    }

    public long getID() {
        Object obj = this.getPrivateAttr(S_ID);
        return (Long) obj;
    }

    public void setID(long Id) throws Exception {
        this.setPrivateAttr(S_ID, new Long(Id));
    }

    public long getDomainId() {
        Object obj = this.getPrivateAttr(S_DomainId);
        return (Long) obj;
    }

    public void setDomainId(long domainID) {
        this.setPrivateAttr(S_DomainId, new Long(domainID));
    }

    public long getOrgId() {
        Object obj = this.getPrivateAttr(S_OrgId);
        return (Long) obj;
    }

    public void setOrgId(long orgId) {
        try {
            this.setPrivateAttr(S_OrgId, new Long(orgId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCode() {
        return (String) this.getPrivateAttr(S_Code);
    }

    public void setCode(String code) throws Exception {
        try {
            this.setPrivateAttr(S_Code, code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return (String) this.getPrivateAttr(S_Name);
    }

    public void setName(String name) {
        try {
            this.setPrivateAttr(S_Name, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getOrgName() throws Exception {
        return (String) this.getPrivateAttr(S_OrgName);
    }

    public void setOrgName(String org_name) throws Exception {
        try {
            if(org_name==null){
                org_name="";
            }
            this.setPrivateAttr(S_OrgName, org_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBillId() throws Exception {
        return (String) this.getPrivateAttr(S_BillId);
    }

    public void setBillId(String billId) throws Exception {
        try {
            this.setPrivateAttr(S_BillId, billId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMultiLogin(boolean flag) {
        try {
            this.setPrivateAttr(S_MultiLogin, new Boolean(flag));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isMultiLogin() {
        Object obj = this.getPrivateAttr(S_MultiLogin);
        return (Boolean) obj;
    }

    public void setEmail(String email) {
        try {
            this.setPrivateAttr(S_Email, email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String isEmail() {
        return (String) this.getPrivateAttr(S_Email);
    }

    public void setAllowChPassword(boolean flag) {
        try {
            this.setPrivateAttr(S_AllowChPassword, new Boolean(flag));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isAllowChPassword() {
        Object obj = this.getPrivateAttr(S_AllowChPassword);
        return (Boolean) obj;
    }

    protected Object getPrivateAttr(String name) {
        return attrHashMap.get(name);
    }

    protected void setPrivateAttr(String pName, Object pObj) {
        if (pName == null) {
            throw new RuntimeException("name is null");
        }
        attrHashMap.put(pName, pObj);
    }

    public void set(String pName, Object pObj) {
        attrHashMap.put(pName, pObj);
    }

    public Object get(String name) {
        return attrHashMap.get(name);
    }

    public Map getAttrs() {
        return this.attrHashMap;
    }
}

package com.liangjiange.cloud.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

public class User extends BaseEntity implements UserDetails{

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    private String username;

    private String password;

    /**
     * 别名
     */
    @Column(name = "alias_name")
    private String aliasName;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 手机号码
     */
    private String cellphone;

    private String remark;

    @Column(name = "creator_id")
    private Long creatorId;

    /**
     * 账户状态：0是正常，1是锁定
     */
    @Column(name = "is_locked")
    private Boolean locked;

    /**
     * 移动端登录验证时的token
     */
    private String token;

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取修改时间
     *
     * @return gmt_modified - 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置修改时间
     *
     * @param gmtModified 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }


    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取别名
     *
     * @return alias_name - 别名
     */
    public String getAliasName() {
        return aliasName;
    }

    /**
     * 设置别名
     *
     * @param aliasName 别名
     */
    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    /**
     * 获取邮箱地址
     *
     * @return email - 邮箱地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱地址
     *
     * @param email 邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号码
     *
     * @return cellphone - 手机号码
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * 设置手机号码
     *
     * @param cellphone 手机号码
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return creator_id
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取账户状态：0是正常，1是锁定
     *
     * @return locked - 账户状态：0是正常，1是锁定
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * 设置账户状态：0是正常，1是锁定
     *
     * @param locked 账户状态：0是正常，1是锁定
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        if(!locked){
            return true;
        }
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

}
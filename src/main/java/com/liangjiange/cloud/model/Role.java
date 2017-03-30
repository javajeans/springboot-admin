package com.liangjiange.cloud.model;

import java.util.Date;
import javax.persistence.*;

public class Role extends BaseEntity{

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

    /**
     * 名称
     */
    private String name;

    /**
     * 角色类型
     */
    @Column(name = "role_type")
    private Byte roleType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 角色状态：0是异常，1是正常
     */
    private Boolean status;

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
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色类型
     *
     * @return role_type - 角色类型
     */
    public Byte getRoleType() {
        return roleType;
    }

    /**
     * 设置角色类型
     *
     * @param roleType 角色类型
     */
    public void setRoleType(Byte roleType) {
        this.roleType = roleType;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取角色状态：0是异常，1是正常
     *
     * @return status - 角色状态：0是异常，1是正常
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置角色状态：0是异常，1是正常
     *
     * @param status 角色状态：0是异常，1是正常
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }
}
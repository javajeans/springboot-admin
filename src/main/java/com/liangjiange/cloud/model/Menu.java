package com.liangjiange.cloud.model;

import java.util.Date;
import javax.persistence.*;

public class Menu extends BaseEntity{

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 图标字体
     */
    private String iconfont;

    private String url;

    /**
     * 显示顺序
     */
    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "has_child_menu")
    private Boolean hasChildMenu;

    /**
     * 菜单状态：0是异常，1是正常
     */
    private Boolean status;

    /**
     * @return gmt_create
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified
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
     * 获取描述信息
     *
     * @return description - 描述信息
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述信息
     *
     * @param description 描述信息
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取图标字体
     *
     * @return iconfont - 图标字体
     */
    public String getIconfont() {
        return iconfont;
    }

    /**
     * 设置图标字体
     *
     * @param iconfont 图标字体
     */
    public void setIconfont(String iconfont) {
        this.iconfont = iconfont;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取显示顺序
     *
     * @return display_order - 显示顺序
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * 设置显示顺序
     *
     * @param displayOrder 显示顺序
     */
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    /**
     * @return parent_id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return has_child_menu
     */
    public Boolean getHasChildMenu() {
        return hasChildMenu;
    }

    /**
     * @param hasChildMenu
     */
    public void setHasChildMenu(Boolean hasChildMenu) {
        this.hasChildMenu = hasChildMenu;
    }

    /**
     * 获取菜单状态：0是异常，1是正常
     *
     * @return status - 菜单状态：0是异常，1是正常
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置菜单状态：0是异常，1是正常
     *
     * @param status 菜单状态：0是异常，1是正常
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }
}
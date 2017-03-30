package com.liangjiange.cloud.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "category_integer")
public class CategoryInteger extends BaseEntity{

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
     * 分类目录
     */
    private String catelog;

    /**
     * 值
     */
    private Byte value;

    /**
     * 标识
     */
    private String label;

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
     * 获取分类目录
     *
     * @return catelog - 分类目录
     */
    public String getCatelog() {
        return catelog;
    }

    /**
     * 设置分类目录
     *
     * @param catelog 分类目录
     */
    public void setCatelog(String catelog) {
        this.catelog = catelog;
    }

    /**
     * 获取值
     *
     * @return value - 值
     */
    public Byte getValue() {
        return value;
    }

    /**
     * 设置值
     *
     * @param value 值
     */
    public void setValue(Byte value) {
        this.value = value;
    }

    /**
     * 获取标识
     *
     * @return label - 标识
     */
    public String getLabel() {
        return label;
    }

    /**
     * 设置标识
     *
     * @param label 标识
     */
    public void setLabel(String label) {
        this.label = label;
    }
}
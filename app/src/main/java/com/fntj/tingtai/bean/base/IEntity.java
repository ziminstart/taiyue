package com.fntj.tingtai.bean.base;

import java.io.Serializable;

public abstract class IEntity implements Serializable {

    /**
     * ID属性
     */
    public Long id;

    /**
     * 状态（0正常,8:冻结,9:删除）
     */
    private Integer status;
    /**
     * 自定义排序规则
     */
    private Integer sort;

    /**
     * 批量操作字段
     */
    private String ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}

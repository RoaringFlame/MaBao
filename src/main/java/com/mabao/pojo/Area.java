package com.mabao.pojo;

import javax.persistence.*;

/**
 * 省市区街道级联
 */
@Entity
@Table(name = "t_prov_city_area_street")
public class Area {
    private Long id;                                //id
    private Long code;                              //编号
    private Long parentId;                          //上级编号
    private String name;                            //名称
    private String level;                           //行政级别。1省 2市 3区 4街道

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}

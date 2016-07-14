package com.mabao.pojo;

import javax.persistence.*;

/**
 * 省市区街道级联
 */
@Entity
@Table(name = "t_area")
public class Area {
    private Long id;                                //id
    private String name;                            //名称
    private String shortName;                       //简称
    private Long parentId;                          //上级编号
    private Integer levelType;                       //行政级别。1省 2市 3区 4街道
    private String mergerName;                      //全称
    private String spell;                           //拼写

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "parent_id")
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
    @Column(name = "short_name")
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    @Column(name = "level_type")
    public Integer getLevelType() {
        return levelType;
    }

    public void setLevelType(Integer levelType) {
        this.levelType = levelType;
    }
    @Column(name = "merger_name")
    public String getMergerName() {
        return mergerName;
    }

    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }
}

package com.mabao.pojo;

import javax.persistence.*;

@Entity
@Table(name = "t_goods_type")
public class GoodsType {
    private Long id;                              //一级分类Id
    private String typeName;                         //一级分类名称
    private String typeList;                         //二级分类列表


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @javax.persistence.Column(name = "type_list")
    public String getTypeList() {
        return typeList;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }

    @Basic
    @javax.persistence.Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}

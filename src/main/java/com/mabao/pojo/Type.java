package com.mabao.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mabao.util.CustomDateSerializer;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_type")
public class Type {
    private Integer id;                              //商品编号，自增
    private String typeName;                         //商品归属者编号，后台用户编号为0
    private String typeList;                         //货号

    @Id
    @javax.persistence.Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

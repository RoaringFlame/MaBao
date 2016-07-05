package com.mabao.pojo;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Entity
@Table(name = "t_order")
public class Order {
    private Integer id;                 //id
    private Integer buyerId;            //买家编号
    private Integer sellerId;           //卖家编号
    private Date createTime;            //订单创建时间
    private Date portTime;              //订单发货时间
    private Date payTime;               //订单支付时间
    private Date dealTime;              //订单完成时间
    private String portNumber;          //运单号
    private String transcationNum;      //支付单号
    private Integer addressId;          //地址默认地址编号
    private String message;             //买家留言
    private Integer state;              //订单状态，0待支付（买家），1待发货（卖家），2待收货（买家），3已完成（卖家），4已取消（买家）

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "buyer_id")
    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    @Column(name = "seller_id")
    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Column(name = "port_time")
    public Date getPortTime() {
        return portTime;
    }

    public void setPortTime(Date portTime) {
        this.portTime = portTime;
    }
    @Column(name = "pay_time")
    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
    @Column(name = "deal_time")
    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }
    @Column(name = "port_number")
    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }
    @Column(name = "transcation_num")
    public String getTranscationNum() {
        return transcationNum;
    }

    public void setTranscationNum(String transcationNum) {
        this.transcationNum = transcationNum;
    }
    @Column(name = "address_id")
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}

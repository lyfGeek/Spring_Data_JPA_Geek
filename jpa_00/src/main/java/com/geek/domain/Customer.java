package com.geek.domain;

import javax.persistence.*;

/**
 * 客户实体类。
 */
@Entity// 声明实体类。
@Table(name = "cst_customer")
public class Customer {

    /*
     * 配置映射关系。
     *      实体类和表的映射关系。
     *          @Entity// 声明实体类。
     *          @Table(name = "cst_customer")
     *          配置实体类和表的映射关系。
     *              name：配置数据库表的名称。
     *      实体类中属性和表中字段的映射关系。
     *          @Id// 主键。
     *          @GeneratedValue。配置主键的生成策略。
     *              strategy = GenerationType.IDENTITY。自增。
     *                  底层数据库必须支持自动增长。（MySQL~AutoIncrement）。
     *              strategy = GenerationType.SEQUENCE。序列。
     *                  底层数据库必须支持序列。（Oracle）。
     *              strategy = GenerationType.TABLE。
     *                  jpa 提供的一种机制，通过一张数据库表的形式帮助我们完成主键自增。
     *              strategy = GenerationType.AUTO。
     *                  由程序自动的帮助我们选择主键生成策略。
     *          @Column。配置属性和字段的映射关系。
     *              (name = "cust_id")。数据库中表字段的名称。
     */

    @Id// 主键。
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_source")
    private String custSource;

    @Column(name = "cust_level")
    private String custLevel;

    @Column(name = "cust_industry")
    private String custIndustry;

    @Column(name = "cust_phone")
    private String custPhone;

    @Column(name = "cust_address")
    private String custAddress;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custAddress='" + custAddress + '\'' +
                '}';
    }
}

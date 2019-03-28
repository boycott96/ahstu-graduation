package com.huaisun.graduation.auto.dao;

import java.math.BigDecimal;
import java.util.Date;

public class TUser extends TUserKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.name
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.email
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.phone
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.integral
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    private BigDecimal integral;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.balance
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    private BigDecimal balance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.cost
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    private BigDecimal cost;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.create_date
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    private Date createDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.name
     *
     * @return the value of t_user.name
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.name
     *
     * @param name the value for t_user.name
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.email
     *
     * @return the value of t_user.email
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.email
     *
     * @param email the value for t_user.email
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.phone
     *
     * @return the value of t_user.phone
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.phone
     *
     * @param phone the value for t_user.phone
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.integral
     *
     * @return the value of t_user.integral
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    public BigDecimal getIntegral() {
        return integral;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.integral
     *
     * @param integral the value for t_user.integral
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.balance
     *
     * @return the value of t_user.balance
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.balance
     *
     * @param balance the value for t_user.balance
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.cost
     *
     * @return the value of t_user.cost
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.cost
     *
     * @param cost the value for t_user.cost
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.create_date
     *
     * @return the value of t_user.create_date
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.create_date
     *
     * @param createDate the value for t_user.create_date
     *
     * @mbg.generated Thu Mar 28 18:16:25 CST 2019
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
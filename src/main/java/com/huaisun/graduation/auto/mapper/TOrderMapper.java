package com.huaisun.graduation.auto.mapper;

import com.huaisun.graduation.auto.dao.TOrder;
import com.huaisun.graduation.auto.dao.TOrderExample;
import com.huaisun.graduation.auto.dao.TOrderKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ORDER
     *
     * @mbg.generated Mon Feb 25 18:10:18 CST 2019
     */
    long countByExample(TOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ORDER
     *
     * @mbg.generated Mon Feb 25 18:10:18 CST 2019
     */
    int deleteByExample(TOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ORDER
     *
     * @mbg.generated Mon Feb 25 18:10:18 CST 2019
     */
    int deleteByPrimaryKey(TOrderKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ORDER
     *
     * @mbg.generated Mon Feb 25 18:10:18 CST 2019
     */
    int insert(TOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ORDER
     *
     * @mbg.generated Mon Feb 25 18:10:18 CST 2019
     */
    int insertSelective(TOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ORDER
     *
     * @mbg.generated Mon Feb 25 18:10:18 CST 2019
     */
    List<TOrder> selectByExample(TOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ORDER
     *
     * @mbg.generated Mon Feb 25 18:10:18 CST 2019
     */
    TOrder selectByPrimaryKey(TOrderKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ORDER
     *
     * @mbg.generated Mon Feb 25 18:10:18 CST 2019
     */
    int updateByExampleSelective(@Param("record") TOrder record, @Param("example") TOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ORDER
     *
     * @mbg.generated Mon Feb 25 18:10:18 CST 2019
     */
    int updateByExample(@Param("record") TOrder record, @Param("example") TOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ORDER
     *
     * @mbg.generated Mon Feb 25 18:10:18 CST 2019
     */
    int updateByPrimaryKeySelective(TOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ORDER
     *
     * @mbg.generated Mon Feb 25 18:10:18 CST 2019
     */
    int updateByPrimaryKey(TOrder record);
}
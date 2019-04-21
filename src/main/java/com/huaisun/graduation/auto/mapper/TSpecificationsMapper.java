package com.huaisun.graduation.auto.mapper;

import com.huaisun.graduation.auto.dao.TSpecifications;
import com.huaisun.graduation.auto.dao.TSpecificationsExample;
import com.huaisun.graduation.auto.dao.TSpecificationsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSpecificationsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_specifications
     *
     * @mbg.generated Mon Apr 15 19:35:07 CST 2019
     */
    long countByExample(TSpecificationsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_specifications
     *
     * @mbg.generated Mon Apr 15 19:35:07 CST 2019
     */
    int deleteByExample(TSpecificationsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_specifications
     *
     * @mbg.generated Mon Apr 15 19:35:07 CST 2019
     */
    int deleteByPrimaryKey(TSpecificationsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_specifications
     *
     * @mbg.generated Mon Apr 15 19:35:07 CST 2019
     */
    int insert(TSpecifications record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_specifications
     *
     * @mbg.generated Mon Apr 15 19:35:07 CST 2019
     */
    int insertSelective(TSpecifications record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_specifications
     *
     * @mbg.generated Mon Apr 15 19:35:07 CST 2019
     */
    List<TSpecifications> selectByExample(TSpecificationsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_specifications
     *
     * @mbg.generated Mon Apr 15 19:35:07 CST 2019
     */
    TSpecifications selectByPrimaryKey(TSpecificationsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_specifications
     *
     * @mbg.generated Mon Apr 15 19:35:07 CST 2019
     */
    int updateByExampleSelective(@Param("record") TSpecifications record, @Param("example") TSpecificationsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_specifications
     *
     * @mbg.generated Mon Apr 15 19:35:07 CST 2019
     */
    int updateByExample(@Param("record") TSpecifications record, @Param("example") TSpecificationsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_specifications
     *
     * @mbg.generated Mon Apr 15 19:35:07 CST 2019
     */
    int updateByPrimaryKeySelective(TSpecifications record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_specifications
     *
     * @mbg.generated Mon Apr 15 19:35:07 CST 2019
     */
    int updateByPrimaryKey(TSpecifications record);
}
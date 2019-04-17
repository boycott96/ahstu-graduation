package com.huaisun.graduation.auto.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TMilkMenuExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    public TMilkMenuExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMilkNameIsNull() {
            addCriterion("milk_name is null");
            return (Criteria) this;
        }

        public Criteria andMilkNameIsNotNull() {
            addCriterion("milk_name is not null");
            return (Criteria) this;
        }

        public Criteria andMilkNameEqualTo(String value) {
            addCriterion("milk_name =", value, "milkName");
            return (Criteria) this;
        }

        public Criteria andMilkNameNotEqualTo(String value) {
            addCriterion("milk_name <>", value, "milkName");
            return (Criteria) this;
        }

        public Criteria andMilkNameGreaterThan(String value) {
            addCriterion("milk_name >", value, "milkName");
            return (Criteria) this;
        }

        public Criteria andMilkNameGreaterThanOrEqualTo(String value) {
            addCriterion("milk_name >=", value, "milkName");
            return (Criteria) this;
        }

        public Criteria andMilkNameLessThan(String value) {
            addCriterion("milk_name <", value, "milkName");
            return (Criteria) this;
        }

        public Criteria andMilkNameLessThanOrEqualTo(String value) {
            addCriterion("milk_name <=", value, "milkName");
            return (Criteria) this;
        }

        public Criteria andMilkNameLike(String value) {
            addCriterion("milk_name like", value, "milkName");
            return (Criteria) this;
        }

        public Criteria andMilkNameNotLike(String value) {
            addCriterion("milk_name not like", value, "milkName");
            return (Criteria) this;
        }

        public Criteria andMilkNameIn(List<String> values) {
            addCriterion("milk_name in", values, "milkName");
            return (Criteria) this;
        }

        public Criteria andMilkNameNotIn(List<String> values) {
            addCriterion("milk_name not in", values, "milkName");
            return (Criteria) this;
        }

        public Criteria andMilkNameBetween(String value1, String value2) {
            addCriterion("milk_name between", value1, value2, "milkName");
            return (Criteria) this;
        }

        public Criteria andMilkNameNotBetween(String value1, String value2) {
            addCriterion("milk_name not between", value1, value2, "milkName");
            return (Criteria) this;
        }

        public Criteria andMilkDetailIsNull() {
            addCriterion("milk_detail is null");
            return (Criteria) this;
        }

        public Criteria andMilkDetailIsNotNull() {
            addCriterion("milk_detail is not null");
            return (Criteria) this;
        }

        public Criteria andMilkDetailEqualTo(String value) {
            addCriterion("milk_detail =", value, "milkDetail");
            return (Criteria) this;
        }

        public Criteria andMilkDetailNotEqualTo(String value) {
            addCriterion("milk_detail <>", value, "milkDetail");
            return (Criteria) this;
        }

        public Criteria andMilkDetailGreaterThan(String value) {
            addCriterion("milk_detail >", value, "milkDetail");
            return (Criteria) this;
        }

        public Criteria andMilkDetailGreaterThanOrEqualTo(String value) {
            addCriterion("milk_detail >=", value, "milkDetail");
            return (Criteria) this;
        }

        public Criteria andMilkDetailLessThan(String value) {
            addCriterion("milk_detail <", value, "milkDetail");
            return (Criteria) this;
        }

        public Criteria andMilkDetailLessThanOrEqualTo(String value) {
            addCriterion("milk_detail <=", value, "milkDetail");
            return (Criteria) this;
        }

        public Criteria andMilkDetailLike(String value) {
            addCriterion("milk_detail like", value, "milkDetail");
            return (Criteria) this;
        }

        public Criteria andMilkDetailNotLike(String value) {
            addCriterion("milk_detail not like", value, "milkDetail");
            return (Criteria) this;
        }

        public Criteria andMilkDetailIn(List<String> values) {
            addCriterion("milk_detail in", values, "milkDetail");
            return (Criteria) this;
        }

        public Criteria andMilkDetailNotIn(List<String> values) {
            addCriterion("milk_detail not in", values, "milkDetail");
            return (Criteria) this;
        }

        public Criteria andMilkDetailBetween(String value1, String value2) {
            addCriterion("milk_detail between", value1, value2, "milkDetail");
            return (Criteria) this;
        }

        public Criteria andMilkDetailNotBetween(String value1, String value2) {
            addCriterion("milk_detail not between", value1, value2, "milkDetail");
            return (Criteria) this;
        }

        public Criteria andMilkGradeIsNull() {
            addCriterion("milk_grade is null");
            return (Criteria) this;
        }

        public Criteria andMilkGradeIsNotNull() {
            addCriterion("milk_grade is not null");
            return (Criteria) this;
        }

        public Criteria andMilkGradeEqualTo(Integer value) {
            addCriterion("milk_grade =", value, "milkGrade");
            return (Criteria) this;
        }

        public Criteria andMilkGradeNotEqualTo(Integer value) {
            addCriterion("milk_grade <>", value, "milkGrade");
            return (Criteria) this;
        }

        public Criteria andMilkGradeGreaterThan(Integer value) {
            addCriterion("milk_grade >", value, "milkGrade");
            return (Criteria) this;
        }

        public Criteria andMilkGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("milk_grade >=", value, "milkGrade");
            return (Criteria) this;
        }

        public Criteria andMilkGradeLessThan(Integer value) {
            addCriterion("milk_grade <", value, "milkGrade");
            return (Criteria) this;
        }

        public Criteria andMilkGradeLessThanOrEqualTo(Integer value) {
            addCriterion("milk_grade <=", value, "milkGrade");
            return (Criteria) this;
        }

        public Criteria andMilkGradeIn(List<Integer> values) {
            addCriterion("milk_grade in", values, "milkGrade");
            return (Criteria) this;
        }

        public Criteria andMilkGradeNotIn(List<Integer> values) {
            addCriterion("milk_grade not in", values, "milkGrade");
            return (Criteria) this;
        }

        public Criteria andMilkGradeBetween(Integer value1, Integer value2) {
            addCriterion("milk_grade between", value1, value2, "milkGrade");
            return (Criteria) this;
        }

        public Criteria andMilkGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("milk_grade not between", value1, value2, "milkGrade");
            return (Criteria) this;
        }

        public Criteria andMilkPriceIsNull() {
            addCriterion("milk_price is null");
            return (Criteria) this;
        }

        public Criteria andMilkPriceIsNotNull() {
            addCriterion("milk_price is not null");
            return (Criteria) this;
        }

        public Criteria andMilkPriceEqualTo(BigDecimal value) {
            addCriterion("milk_price =", value, "milkPrice");
            return (Criteria) this;
        }

        public Criteria andMilkPriceNotEqualTo(BigDecimal value) {
            addCriterion("milk_price <>", value, "milkPrice");
            return (Criteria) this;
        }

        public Criteria andMilkPriceGreaterThan(BigDecimal value) {
            addCriterion("milk_price >", value, "milkPrice");
            return (Criteria) this;
        }

        public Criteria andMilkPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("milk_price >=", value, "milkPrice");
            return (Criteria) this;
        }

        public Criteria andMilkPriceLessThan(BigDecimal value) {
            addCriterion("milk_price <", value, "milkPrice");
            return (Criteria) this;
        }

        public Criteria andMilkPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("milk_price <=", value, "milkPrice");
            return (Criteria) this;
        }

        public Criteria andMilkPriceIn(List<BigDecimal> values) {
            addCriterion("milk_price in", values, "milkPrice");
            return (Criteria) this;
        }

        public Criteria andMilkPriceNotIn(List<BigDecimal> values) {
            addCriterion("milk_price not in", values, "milkPrice");
            return (Criteria) this;
        }

        public Criteria andMilkPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("milk_price between", value1, value2, "milkPrice");
            return (Criteria) this;
        }

        public Criteria andMilkPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("milk_price not between", value1, value2, "milkPrice");
            return (Criteria) this;
        }

        public Criteria andMilkPhotoIsNull() {
            addCriterion("milk_photo is null");
            return (Criteria) this;
        }

        public Criteria andMilkPhotoIsNotNull() {
            addCriterion("milk_photo is not null");
            return (Criteria) this;
        }

        public Criteria andMilkPhotoEqualTo(String value) {
            addCriterion("milk_photo =", value, "milkPhoto");
            return (Criteria) this;
        }

        public Criteria andMilkPhotoNotEqualTo(String value) {
            addCriterion("milk_photo <>", value, "milkPhoto");
            return (Criteria) this;
        }

        public Criteria andMilkPhotoGreaterThan(String value) {
            addCriterion("milk_photo >", value, "milkPhoto");
            return (Criteria) this;
        }

        public Criteria andMilkPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("milk_photo >=", value, "milkPhoto");
            return (Criteria) this;
        }

        public Criteria andMilkPhotoLessThan(String value) {
            addCriterion("milk_photo <", value, "milkPhoto");
            return (Criteria) this;
        }

        public Criteria andMilkPhotoLessThanOrEqualTo(String value) {
            addCriterion("milk_photo <=", value, "milkPhoto");
            return (Criteria) this;
        }

        public Criteria andMilkPhotoLike(String value) {
            addCriterion("milk_photo like", value, "milkPhoto");
            return (Criteria) this;
        }

        public Criteria andMilkPhotoNotLike(String value) {
            addCriterion("milk_photo not like", value, "milkPhoto");
            return (Criteria) this;
        }

        public Criteria andMilkPhotoIn(List<String> values) {
            addCriterion("milk_photo in", values, "milkPhoto");
            return (Criteria) this;
        }

        public Criteria andMilkPhotoNotIn(List<String> values) {
            addCriterion("milk_photo not in", values, "milkPhoto");
            return (Criteria) this;
        }

        public Criteria andMilkPhotoBetween(String value1, String value2) {
            addCriterion("milk_photo between", value1, value2, "milkPhoto");
            return (Criteria) this;
        }

        public Criteria andMilkPhotoNotBetween(String value1, String value2) {
            addCriterion("milk_photo not between", value1, value2, "milkPhoto");
            return (Criteria) this;
        }

        public Criteria andShelfIsNull() {
            addCriterion("shelf is null");
            return (Criteria) this;
        }

        public Criteria andShelfIsNotNull() {
            addCriterion("shelf is not null");
            return (Criteria) this;
        }

        public Criteria andShelfEqualTo(Integer value) {
            addCriterion("shelf =", value, "shelf");
            return (Criteria) this;
        }

        public Criteria andShelfNotEqualTo(Integer value) {
            addCriterion("shelf <>", value, "shelf");
            return (Criteria) this;
        }

        public Criteria andShelfGreaterThan(Integer value) {
            addCriterion("shelf >", value, "shelf");
            return (Criteria) this;
        }

        public Criteria andShelfGreaterThanOrEqualTo(Integer value) {
            addCriterion("shelf >=", value, "shelf");
            return (Criteria) this;
        }

        public Criteria andShelfLessThan(Integer value) {
            addCriterion("shelf <", value, "shelf");
            return (Criteria) this;
        }

        public Criteria andShelfLessThanOrEqualTo(Integer value) {
            addCriterion("shelf <=", value, "shelf");
            return (Criteria) this;
        }

        public Criteria andShelfIn(List<Integer> values) {
            addCriterion("shelf in", values, "shelf");
            return (Criteria) this;
        }

        public Criteria andShelfNotIn(List<Integer> values) {
            addCriterion("shelf not in", values, "shelf");
            return (Criteria) this;
        }

        public Criteria andShelfBetween(Integer value1, Integer value2) {
            addCriterion("shelf between", value1, value2, "shelf");
            return (Criteria) this;
        }

        public Criteria andShelfNotBetween(Integer value1, Integer value2) {
            addCriterion("shelf not between", value1, value2, "shelf");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_milk_menu
     *
     * @mbg.generated do_not_delete_during_merge Mon Apr 15 19:37:27 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_milk_menu
     *
     * @mbg.generated Mon Apr 15 19:37:27 CST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
package com.legend.cloud.campus.model.pojo.entity.campus.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * CampusVerify的example类
 *
 * @author hupeiD
 * @date 2018-04-12 10:38:05
 */
public class CampusVerifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CampusVerifyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class AbstractGeneratedCriteria {
        protected List<Criterion> criteria;

        protected AbstractGeneratedCriteria() {
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
            addCriterion("'id <>", value, "id");
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("'user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andDeptIsNull() {
            addCriterion("dept is null");
            return (Criteria) this;
        }

        public Criteria andDeptIsNotNull() {
            addCriterion("dept is not null");
            return (Criteria) this;
        }

        public Criteria andDeptEqualTo(Integer value) {
            addCriterion("dept =", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotEqualTo(Integer value) {
            addCriterion("'dept <>", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptGreaterThan(Integer value) {
            addCriterion("dept >", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptGreaterThanOrEqualTo(Integer value) {
            addCriterion("dept >=", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLessThan(Integer value) {
            addCriterion("dept <", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLessThanOrEqualTo(Integer value) {
            addCriterion("dept <=", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptIn(List<Integer> values) {
            addCriterion("dept in", values, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotIn(List<Integer> values) {
            addCriterion("dept not in", values, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptBetween(Integer value1, Integer value2) {
            addCriterion("dept between", value1, value2, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotBetween(Integer value1, Integer value2) {
            addCriterion("dept not between", value1, value2, "dept");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(Integer value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(Integer value) {
            addCriterion("'major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(Integer value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(Integer value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(Integer value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(Integer value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<Integer> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<Integer> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(Integer value1, Integer value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(Integer value1, Integer value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("'reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(Integer value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andEvidenceIsNull() {
            addCriterion("evidence is null");
            return (Criteria) this;
        }

        public Criteria andEvidenceIsNotNull() {
            addCriterion("evidence is not null");
            return (Criteria) this;
        }

        public Criteria andEvidenceEqualTo(String value) {
            addCriterion("evidence =", value, "evidence");
            return (Criteria) this;
        }

        public Criteria andEvidenceNotEqualTo(String value) {
            addCriterion("'evidence <>", value, "evidence");
            return (Criteria) this;
        }

        public Criteria andEvidenceGreaterThan(String value) {
            addCriterion("evidence >", value, "evidence");
            return (Criteria) this;
        }

        public Criteria andEvidenceGreaterThanOrEqualTo(String value) {
            addCriterion("evidence >=", value, "evidence");
            return (Criteria) this;
        }

        public Criteria andEvidenceLessThan(String value) {
            addCriterion("evidence <", value, "evidence");
            return (Criteria) this;
        }

        public Criteria andEvidenceLessThanOrEqualTo(Integer value) {
            addCriterion("evidence <=", value, "evidence");
            return (Criteria) this;
        }

        public Criteria andEvidenceIn(List<String> values) {
            addCriterion("evidence in", values, "evidence");
            return (Criteria) this;
        }

        public Criteria andEvidenceNotIn(List<String> values) {
            addCriterion("evidence not in", values, "evidence");
            return (Criteria) this;
        }

        public Criteria andEvidenceBetween(String value1, String value2) {
            addCriterion("evidence between", value1, value2, "evidence");
            return (Criteria) this;
        }

        public Criteria andEvidenceNotBetween(String value1, String value2) {
            addCriterion("evidence not between", value1, value2, "evidence");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("'status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("'create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("'update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("'is_deleted <>", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("is_deleted <=", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "is_deleted");
            return (Criteria) this;
        }
    }

    public static class Criteria extends AbstractGeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

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
    }
}
package com.legend.cloud.entity.base;

        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

/**
 * BaseLogTemplate的example类
 *
 * @author hupeiD
 * @date 2018-03-26 22:19:02
 */
public class BaseLogTemplateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseLogTemplateExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
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
                addCriterion("${column.columnname} in", values, "${column.columnname}");
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
                    public Criteria andTemplateIsNull() {
                addCriterion("template is null");
                return (Criteria) this;
            }

            public Criteria andTemplateIsNotNull() {
                addCriterion("template is not null");
                return (Criteria) this;
            }

            public Criteria andTemplateEqualTo(String value) {
                addCriterion("template =", value, "template");
                return (Criteria) this;
            }

            public Criteria andTemplateNotEqualTo(String value) {
                addCriterion("'template <>", value, "template");
                return (Criteria) this;
            }

            public Criteria andTemplateGreaterThan(String value) {
                addCriterion("template >", value, "template");
                return (Criteria) this;
            }

            public Criteria andTemplateGreaterThanOrEqualTo(String value) {
                addCriterion("template >=", value, "template");
                return (Criteria) this;
            }

            public Criteria andTemplateLessThan(String value) {
                addCriterion("template <", value, "template");
                return (Criteria) this;
            }

            public Criteria andTemplateLessThanOrEqualTo(Integer value) {
                addCriterion("template <=", value, "template");
                return (Criteria) this;
            }

            public Criteria andTemplateIn(List<String> values) {
                addCriterion("${column.columnname} in", values, "${column.columnname}");
                return (Criteria) this;
            }

            public Criteria andTemplateNotIn(List<String> values) {
                addCriterion("template not in", values, "template");
                return (Criteria) this;
            }

            public Criteria andTemplateBetween(String value1, String value2) {
                addCriterion("template between", value1, value2, "template");
                return (Criteria) this;
            }

            public Criteria andTemplateNotBetween(String value1, String value2) {
                addCriterion("template not between", value1, value2, "template");
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
                addCriterion("${column.columnname} in", values, "${column.columnname}");
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
                addCriterion("${column.columnname} in", values, "${column.columnname}");
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
                addCriterion("${column.columnname} in", values, "${column.columnname}");
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
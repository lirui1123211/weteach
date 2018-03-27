package com.legend.cloud.vo.campus;

        import com.legend.cloud.entity.campus.CampusEvaluate;
        import com.legend.module.core.vo.AbstractVO;
        import lombok.Data;
        import lombok.EqualsAndHashCode;

        import java.util.Date;


/**
 * 评价
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CampusEvaluateVO extends AbstractVO<CampusEvaluate> {
    private static final long serialVersionUID = 1L;

            /**
         * 评价记录id
         */
        private Integer id;
            /**
         * 用户id
         */
        private Integer userId;
            /**
         * 课程id
         */
        private Integer courseId;
            /**
         * 评价星级
         */
        private String evaluateStar;
            /**
         * 详细评价
         */
        private String detail;
            /**
         * 追加评价
         */
        private String superaddition;
            /**
         * 状态（0，主动评价；1，被动评价；2，已追评）
         */
        private Integer status;
            /**
         * 创建时间
         */
        private Date createTime;
            /**
         * 更新时间
         */
        private Date updateTime;
            /**
         * 是否删除
         */
        private Boolean isDeleted;
    
    @Override
    public CampusEvaluate parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public CampusEvaluateVO parseFrom(CampusEvaluate campusEvaluate, String... ignoreProperties) {
        return (CampusEvaluateVO) super.parseFrom(campusEvaluate, ignoreProperties);
    }

    @Override
    public String toString() {
        return "CampusEvaluateVO{" +
                                ", id=" + getId() +
                                ", userId=" + getUserId() +
                                ", courseId=" + getCourseId() +
                                ", evaluateStar=" + getEvaluateStar() +
                                ", detail=" + getDetail() +
                                ", superaddition=" + getSuperaddition() +
                                ", status=" + getStatus() +
                                ", createTime=" + getCreateTime() +
                                ", updateTime=" + getUpdateTime() +
                                ", isDeleted=" + getIsDeleted() +
                            '}';
    }
}

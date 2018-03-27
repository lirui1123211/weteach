package com.legend.cloud.vo.campus;

        import com.legend.cloud.entity.campus.CampusVerify;
        import com.legend.module.core.vo.AbstractVO;
        import lombok.Data;
        import lombok.EqualsAndHashCode;

        import java.util.Date;


/**
 * 教师资格认证
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CampusVerifyVO extends AbstractVO<CampusVerify> {
    private static final long serialVersionUID = 1L;

            /**
         * 教师资格id
         */
        private Integer id;
            /**
         * 用户id
         */
        private Integer userId;
            /**
         * 认证系别
         */
        private Integer dept;
            /**
         * 认证专业
         */
        private Integer major;
            /**
         * 认证理由
         */
        private String reason;
            /**
         * 认证证明（证书等）
         */
        private String evidence;
            /**
         * 状态（0，待审核；1，通过；2，未通过）
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
    public CampusVerify parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public CampusVerifyVO parseFrom(CampusVerify campusVerify, String... ignoreProperties) {
        return (CampusVerifyVO) super.parseFrom(campusVerify, ignoreProperties);
    }

    @Override
    public String toString() {
        return "CampusVerifyVO{" +
                                ", id=" + getId() +
                                ", userId=" + getUserId() +
                                ", dept=" + getDept() +
                                ", major=" + getMajor() +
                                ", reason=" + getReason() +
                                ", evidence=" + getEvidence() +
                                ", status=" + getStatus() +
                                ", createTime=" + getCreateTime() +
                                ", updateTime=" + getUpdateTime() +
                                ", isDeleted=" + getIsDeleted() +
                            '}';
    }
}

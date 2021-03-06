package com.legend.cloud.campus.model.pojo.entity.campus;

import com.legend.module.core.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 用户课程关联表
 *
 * @author hupeiD
 * @date 2018-04-18 21:55:59
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Table(name = "campus_user_rel_course")
public class CampusUserRelCourse extends AbstractEntity<CampusUserRelCourse> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户类型（暂时不用）
     */
    @Column(name = "type_user")
    private String typeUser;
    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;
    /**
     * 课程id
     */
    @Column(name = "course_id")
    private Integer courseId;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

}

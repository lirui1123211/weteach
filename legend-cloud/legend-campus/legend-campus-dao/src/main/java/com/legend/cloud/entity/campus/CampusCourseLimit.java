package com.legend.cloud.entity.campus;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;



/**
 * 课程限制
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "campus_course_limit")
public class CampusCourseLimit extends AbstractEntity<CampusCourseLimit> {
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        	private Integer id;
	/**
     * 课程id
     */
        	private Integer courseId;
	/**
     * 系别限制
     */
        	private Integer dept;
	/**
     * 专业限制
     */
        	private Integer major;
	/**
     * 性别限制
     */
        	private Integer sex;
	/**
     * 年级限制
     */
        	private Integer grade;
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

}
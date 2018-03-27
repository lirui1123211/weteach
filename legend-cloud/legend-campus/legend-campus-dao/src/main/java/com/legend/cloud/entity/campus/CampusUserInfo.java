package com.legend.cloud.entity.campus;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;



/**
 * 个人信息表
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "campus_user_info")
public class CampusUserInfo extends AbstractEntity<CampusUserInfo> {
	private static final long serialVersionUID = 1L;

	/**
     * 用户id
     */
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        	private Integer id;
	/**
     * 用户基础id
     */
        	private Integer baseUserId;
	/**
     * 用户实名
     */
        	private String name;
	/**
     * 用户昵称
     */
        	private String nickname;
	/**
     * 性别
     */
        	private String sex;
	/**
     * 籍贯
     */
        	private String nativePlace;
	/**
     * 系别
     */
        	private String dept;
	/**
     * 专业
     */
        	private String major;
	/**
     * 方向
     */
        	private String direction;
	/**
     * 电话
     */
        	private String phone;
	/**
     * QQ号码
     */
        	private String qicq;
	/**
     * 邮箱地址
     */
        	private String email;
	/**
     * 积分量
     */
        	private Integer credits;
	/**
     * 积分信誉等级
     */
        	private String creditsLevel;
	/**
     * 参与课程数
     */
        	private Integer orderJoin;
	/**
     * 课程发布数
     */
        	private Integer orderPublish;
	/**
     * 课程完成数
     */
        	private Integer orderFinish;
	/**
     * 课程完成率
     */
        	private Double percentageComplete;
	/**
     * 创建时间
     */
        	private Date createTime;
	/**
     * 修改时间
     */
        	private Date updateTime;
	/**
     * 是否删除
     */
        	private Boolean isDeleted;

}

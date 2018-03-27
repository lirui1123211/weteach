package com.legend.cloud.entity.base;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;



/**
 * 日志模板表
 *
 * @author hupeiD
 * @date 2018-03-26 22:19:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "base_log_template")
public class BaseLogTemplate extends AbstractEntity<BaseLogTemplate> {
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        	private Integer id;
	/**
     * 模板内容
     */
        	private String template;
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
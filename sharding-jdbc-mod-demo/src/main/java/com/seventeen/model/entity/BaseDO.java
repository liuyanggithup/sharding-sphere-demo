package com.seventeen.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * 数据库表基本字段
 * @author seventeen
 * @date 2018/11/16
 */

@Data
public class BaseDO {

    private Long id;

    /**
     * 数据创建时间
     */
    private Date createdAt;

    /**
     * 数据修改时间
     */
    private Date updatedAt;

    /**
     * 是否删除 0(false):未删除,1(true):已删除
     */
    private Boolean deleted;

}

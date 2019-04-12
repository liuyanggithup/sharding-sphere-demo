package com.seventeen.model.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author: seventeen
 * @Date: 2019/4/8
 * @description:
 */
@Data
public class BaseBO {

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

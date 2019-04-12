package com.seventeen.model.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author seventeen
 * @date 2018/11/14
 */

@Data
public class TestBO {

    private Long id;

    private Date createdAt;

    private String name;
}

package com.seventeen.component.convertor;

import com.seventeen.response.ResponseData;

import java.util.List;

/**
 * Bean对象转化器，可用于DO,BO,VO对象的转换
 * @author seventeen
 * @date 2018/11/26
 */

public interface ConvertorFacade {

    /**
     * 单个对象数据转换
     */
    <T> T convert(Object source, Class<T> destinationClass);

    /**
     * 列表数据转换
     */
    <T> List<T> convertList(List sources, Class<T> destinationClass);

    /**
     * 平台Api数据反序列化
     */
    <T> ResponseData<T> parseResponse(String jsonString, Class<T> clazz);
}

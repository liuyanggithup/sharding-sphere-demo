package com.seventeen.component.convertor.impl;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.seventeen.component.convertor.ConvertorFacade;
import com.seventeen.exception.BizException;
import com.seventeen.response.ResponseData;
import com.seventeen.utils.StringUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Bean对象转化器，可用于DO,BO,VO对象的转换
 * @author seventeen
 * @date 2018/11/26
 */

@Component(value = "beanConvertor")
public class ConvertorFacadeImpl implements ConvertorFacade {

    @Resource
    private DozerBeanMapper mapper;

    @Override
    public <T> T convert(Object source, Class<T> destinationClass) {
        if (source == null) {
            return null;
        }

        return mapper.map(source, destinationClass);
    }

    @Override
    public <T> List<T> convertList(List sources, Class<T> destinationClass) {
        List<T> list = new ArrayList<>();
        if (sources == null || sources.size() == 0) {
            return list;
        }

        for (Object source : sources) {
            list.add(mapper.map(source, destinationClass));
        }

        return list;
    }

    @Override
    public <T> ResponseData<T> parseResponse(String jsonString, Class<T> clazz) {
        if (StringUtils.isBlank(jsonString)) {
            return ResponseData.fail("获取结果失败");
        }

        ResponseData rd = null;
        try {
            rd = JSONObject.parseObject(jsonString, ResponseData.class);
        } catch (JSONException e) {
            throw new BizException("api数据格式不正确");
        }

        if (rd.getData() != null) {
            try {
                rd.setData(JSONObject.parseObject(rd.getData().toString(), clazz));
            } catch (JSONException e) {
                throw new BizException("api数据格式不正确");
            }
            return rd;
        }
        return rd;
    }

}

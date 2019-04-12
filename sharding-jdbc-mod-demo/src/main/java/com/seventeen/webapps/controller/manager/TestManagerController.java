package com.seventeen.webapps.controller.manager;

import com.seventeen.biz.facade.TestFacade;
import com.seventeen.model.vo.TestVO;
import com.seventeen.response.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author seventeen
 * @date 2018/11/26
 */

@Api(description = "测试控制器", tags = "测试运营后台接口")
@RestController
@RequestMapping(value = "/managerApi/test")
public class TestManagerController {

    @Resource
    private TestFacade testFacade;

    @ApiOperation(value = "根据主键查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "long", paramType = "query", required = true)
    })
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    public ResponseData<TestVO> getById(Long id) {
        return ResponseData.success(testFacade.getById(id));
    }

}

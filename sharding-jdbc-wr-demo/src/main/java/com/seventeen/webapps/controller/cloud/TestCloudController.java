package com.seventeen.webapps.controller.cloud;

import com.seventeen.biz.facade.TestFacade;
import com.seventeen.component.redis.RedisFacade;
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

@Api(description = "测试控制器", tags = "测试cloud接口")
@RestController
@RequestMapping(value = "/cloudApi/test")
public class TestCloudController {

    @Resource
    private TestFacade testFacade;
    @Resource
    private RedisFacade redisFacade;

    @ApiOperation(value = "根据主键查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "long", paramType = "query", required = true)
    })
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    public ResponseData<TestVO> getById(Long id) {
        return ResponseData.success(testFacade.getById(id));
    }

    @RequestMapping(value = "getRedisLock")
    public ResponseData<Boolean> getRedisLock() {
        boolean b = redisFacade.lock("seventeen");
        return ResponseData.success(b);
    }
}

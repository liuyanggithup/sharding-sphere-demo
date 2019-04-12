package com.seventeen.webapps.controller.app;

import com.seventeen.biz.facade.TestFacade;
import com.seventeen.enums.CodeEnum;
import com.seventeen.model.param.BasePageParam;
import com.seventeen.model.vo.BaseEnumVO;
import com.seventeen.model.vo.TestVO;
import com.seventeen.response.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author seventeen
 * @date 2018/11/26
 */
@Api(description = "测试控制器", tags = "测试app接口")
@RestController
@RequestMapping(value = "/appApi/test")
public class TestAppController {

    /**
     * log打印统一使用 slf4j
     */
    private static final Logger log = LoggerFactory.getLogger(TestAppController.class);

    @Resource
    private TestFacade testFacade;

    @ApiOperation(value = "hello")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceId", value = "设备号", dataType = "string", paramType = "query", required = true)
    })
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public ResponseData<BaseEnumVO> hello(BasePageParam pageParam) {
        return ResponseData.success(new BaseEnumVO(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getValue()));
    }

    @ApiOperation(value = "根据主键查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "long", paramType = "query", required = true)
    })
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    public ResponseData<TestVO> getById(Long id) {
        return ResponseData.success(testFacade.getById(id));
    }

    @ApiOperation(value = "上传文件")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseData<String> upload(@RequestParam("imageName") MultipartFile file) {
        log.info("文件大小：" + file.getSize());

        return ResponseData.success("成功");
    }

}

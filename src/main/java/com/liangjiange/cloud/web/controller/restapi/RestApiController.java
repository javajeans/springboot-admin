package com.liangjiange.cloud.web.controller.restapi;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liangjiange on 2017/3/12.
 */
@RestController
@RequestMapping("api/v1")
public class RestApiController {

    private static Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @ApiOperation(value="获取用户token", notes="根据应用ID和应用秘钥获取令牌")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "app_id", value = "应用ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "secret_key", value = "应用秘钥", required = true, dataType = "String")
    })
    @RequestMapping(value="token", method= RequestMethod.GET)
    public String token(@RequestParam(name = "app_id") String appId , @RequestParam(name = "secret_key") String secretKey) {
        if(logger.isDebugEnabled()){
            logger.debug("appId="+appId+" , secretKey"+secretKey);
        }
        return "success";
    }

    @RequestMapping(value="test",method = RequestMethod.POST)
    public String testPost(@RequestParam String id, @RequestBody String result){
        return "success";
    }

    @RequestMapping(value="test",method = RequestMethod.GET)
    public String testGet(@RequestParam String id){
        System.out.println(id);
        JSONObject result = new JSONObject();
        result.put("test","yes");
        result.put("name","heheye");
        return result.toJSONString();
    }

}

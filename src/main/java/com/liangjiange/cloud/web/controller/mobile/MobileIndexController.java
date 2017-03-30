package com.liangjiange.cloud.web.controller.mobile;

import com.liangjiange.cloud.common.JwtUtil;
import com.liangjiange.cloud.web.error.OperationStatus;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author liangjiange
 * @since 2017-02-07 20:46
 */
@Controller
@RequestMapping("mobile")
public class MobileIndexController {

    private static Logger logger = LoggerFactory.getLogger(MobileIndexController.class);

    @RequestMapping("index")
    @ResponseBody
    public String index(HttpServletRequest request, @RequestHeader String jwt) {

        JwtUtil jwtUtil = new JwtUtil();
        Claims claims = null;
        try {
            claims = jwtUtil.parseJWT(jwt);
        } catch (Exception e) {
            return OperationStatus.failed().toString();
        }

        String id = claims.getId();
        String subject = claims.getSubject();
        Date expiration = claims.getExpiration();

        //TODO 根据claims信息验证请求是否有效

        return OperationStatus.failed().toString();
    }

}

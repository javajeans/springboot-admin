package com.liangjiange.cloud.web.controller.mobile;

import com.liangjiange.cloud.common.JwtUtil;
import com.liangjiange.cloud.model.User;
import com.liangjiange.cloud.service.UserService;
import com.liangjiange.cloud.web.error.OperationStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liangjiange
 * @since 2017-02-07 20:46
 */
@Controller
@RequestMapping("mobile")
public class MobileLoginController {

    private static Logger logger = LoggerFactory.getLogger(MobileLoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login() {
        return "mobile/login";
    }

    @RequestMapping("jwt")
    @ResponseBody
    public String getJWT(HttpServletRequest request, @RequestParam String uname, @RequestParam String pword) {
        logger.debug("uname=" + uname + ", pword=" + pword);

        User user = userService.getUserByUsername(uname);
        if (user == null) {
            return OperationStatus.failed().toString();
        }


        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if (!bCryptPasswordEncoder.matches(pword, user.getPassword())) {
            return OperationStatus.failed().toString();
        }

        JwtUtil jwtUtil = new JwtUtil();
        String id = user.getId() + "";
        String subject = "";
        long ttlMillis = 600000L;
        try {
            String jwt = jwtUtil.createJWT(id, subject, ttlMillis);
            return OperationStatus.success().message(jwt).toString();
        } catch (Exception e) {
            return OperationStatus.failed().toString();
        }
    }

}

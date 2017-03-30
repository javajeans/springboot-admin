package com.liangjiange.cloud.web.controller;

import com.liangjiange.cloud.service.UserService;
import com.liangjiange.cloud.web.error.OperationStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping("login")
    public String login() {
        return "login/login";
    }

    @RequestMapping("login/validate")
    @ResponseBody
    public String loginValidate(HttpServletRequest request, @RequestParam String uname, @RequestParam String pword) {
        logger.debug("uname=" + uname + ", pword=" + pword);


        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(uname, pword);
        try {
            UserDetails userDetails = userService.loadUserByUsername(uname);
            token.setDetails(userDetails);
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            return OperationStatus.failed().toString();
        }

        try {
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            return OperationStatus.success().toString();
        } catch (BadCredentialsException e2) {
            e2.printStackTrace();
            return OperationStatus.failed().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return OperationStatus.failed().toString();
        }
    }

}

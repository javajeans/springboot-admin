package com.liangjiange.cloud.model;

import com.liangjiange.cloud.common.JwtUtil;
import io.jsonwebtoken.Claims;

/**
 * Created by liangjiange on 2017/3/30.
 */
public class JWTTest {

    public static void main(String[] args) {

        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwiaWF0IjoxNDkwODgxMTU1LCJzdWIiOiIiLCJleHAiOjE0OTA4ODE3NTV9.N_CbF6y9NYeG8gkeftvY-NpuacXp6DM_HYfFS-wts6A";

        JwtUtil jwtUtil = new JwtUtil();
        try {
            Claims claims = jwtUtil.parseJWT(jwt);
            System.out.println(claims.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

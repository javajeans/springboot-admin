package com.liangjiange.cloud.model;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by liangjiange on 2017/3/11.
 */
public class PasswordTest {

    public static void main(String[] args) {


        String username = "platAdmin";
        String rawPass = "123456";


        ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder(512);
        String sha512Str = shaPasswordEncoder.encodePassword(rawPass, username);
        System.out.println("sha512Str= " + sha512Str);


        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        String md5Str = md5PasswordEncoder.encodePassword(sha512Str, username);
        System.out.println("md5Str= " + md5Str);
        //55bb6cbef789a8790bdb35200d58c358
        //true ca683a32f201eb65a882ab4f472a7a6d


        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String bcryptStr = bCryptPasswordEncoder.encode(md5Str);
        System.out.println("bcryptStr= " + bcryptStr);
        System.out.println(bCryptPasswordEncoder.matches(md5Str, bcryptStr));


    }

}

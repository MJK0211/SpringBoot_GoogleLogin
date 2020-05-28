package com.bit.security.controller;

import com.bit.security.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class TestController {

    @Autowired
    UserMapper userMapper;

//    @RequestMapping("/login")
//    public String login(String error, String logout, Model model) {
//        log.info("------------------------로그인------------------------");
//        log.info("error : " + error);
//        log.info("logout : " + logout);
//
//        if(error != null){
//            model.addAttribute("error", "Login Errror");
//        }
//
//        if(logout != null){
//            model.addAttribute("logout", "LogOut!!");
//        }
//        return "login";
//    }

    @RequestMapping("/login")
    public String login() {
        log.info("------------------------로그인------------------------");
        return "login";
    }

    @RequestMapping("/logout")
    public String logout() {
        log.info("------------------------로그아웃------------------------");
        return "login";
    }

    @RequestMapping("/loginSuccess")
    public String loginSuccess(Authentication auth) {
        log.info("------------------------로그인성공------------------------");
        log.info(auth);
        return "loginSuccess";
    }

    @RequestMapping("/seller")
    public String seller() {
        log.info("------------------------업체페이지------------------------");
        return "sellerPage";
    }

    @RequestMapping("/member")
    public String member() {
        log.info("------------------------멤버페이지------------------------");
        return "memberPage";
    }

    @RequestMapping("/admin")
    public String admin() {
        log.info("------------------------관리자페이지------------------------");
        return "adminPage";
    }

    @RequestMapping("/accessError")
    public String accessDenied(Authentication auth, Model model) {
        log.info("------------------------권한이없습니다------------------------");
        log.info("accessDenied : " + auth);

        model.addAttribute("msg", "Access Denied");
        return "accessError";
    }
}

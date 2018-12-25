package com.wpf.jop1.controller;

import java.util.Map;


/**
 * @outhor wpf
 * @date 2018/12/25 - 10:30
 */
//判断密码是否正确

public class PassController{
    public String pd(String pb, String pa){
        if (pb.equals(pa)) {
            //重新定向到，视图映射的地址，防止重复提交表单
            return "redirect:/main.html";
        } else {
            return "login";
        }
    }
}

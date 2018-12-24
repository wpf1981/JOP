package com.wpf.jop1.controller;

import com.wpf.jop1.entity.User;
import com.wpf.jop1.repository.UserRepository;
import org.hibernate.mapping.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.Name;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @outhor wpf
 * @date 2018/12/24 - 9:21
 */
@Controller
public class JopController {
    @GetMapping("/")
    public String page(){
        return "login";
    }
    @GetMapping("/index")
    public String page1(){
        return "index";
    }

    @Resource
    UserRepository userRepository;
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map){

        Optional<User> uu = userRepository.findById(username);
        //User user = userRepository.getOne(username);
//        if (!StringUtils.isEmpty(uu)) {
//
//            if (uu.get().getId().equals(username) && uu.get().getPass().equals(password)) {
//
//                return "index";
//            } else {
//                map.put("msg", "用户名密码错误");
//                return "login";
//            }
//        }else{
//            map.put("msg","用户不存在");
//            return "login";
//        }

        try
        {
            if (uu.get().getId().equals(username) && uu.get().getPass().equals(password)){

            return "index";
            }

//            uu.get().getId().equals(username);
//            uu.get().getPass().equals(password);
//            return "index";
            map.put("msg","密码不正确");
            return "login";
        }
        catch (Exception e)
        {
            map.put("msg","用户不存在");
            return "login";
        }



//
//        if(!StringUtils.isEmpty(username) && "12345".equals(password)){
//        return "index";
//        }else {
//            map.put("msg","用户名密码错误");
//            return "login";
//        }
    }



}

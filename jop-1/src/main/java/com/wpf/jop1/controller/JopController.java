package com.wpf.jop1.controller;

import com.wpf.jop1.entity.User;
import com.wpf.jop1.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;

/**
 * @outhor wpf
 * @date 2018/12/24 - 9:21
 */
@Controller
public class JopController {
    @Resource
    UserRepository userRepository;
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        PassController papd = new PassController();
        Optional<User> uu = userRepository.findById(username);
        //异常处理判断
        try
        {
            uu.get().getId().equals(username);

            session.setAttribute("loginUser",username);
            map.put("msg","密码错误！");
            map.put("name",uu.get().getName());
            return papd.pd(uu.get().getPass(),password);
        }
        catch (Exception e)
        {
            map.put("msg","用户不存在！");
            return "login";
        }

    }
}

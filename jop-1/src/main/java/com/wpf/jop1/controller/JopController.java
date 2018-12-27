package com.wpf.jop1.controller;

import com.wpf.jop1.entity.Ioerror;
import com.wpf.jop1.entity.User;
import com.wpf.jop1.repository.IoerrorRepository;
import com.wpf.jop1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @outhor wpf
 * @date 2018/12/24 - 9:21
 */
@Controller
public class JopController {

    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @Autowired
    UserRepository userRepository;
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @PostMapping(value = "/login")
//    @Cacheable(value = "mm")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        PassController papd = new PassController();
        Optional<User> uu = userRepository.findById(username);
        //异常处理判断
        try
        {
            uu.get().getId().equals(username);
            session.setAttribute("loginUser",uu.get().getName());
            map.put("msg","密码错误！");
            String sss="zjyywpf0";
            System.out.println(DigestUtils.md5DigestAsHex(sss.getBytes()));

            return papd.pd(uu.get().getPass(),password);
        }
        catch (Exception e)
        {
            map.put("msg","用户不存在！");
            return "login";
        }

    }

    @Autowired
    IoerrorRepository ioerrorRepository;
    @GetMapping(value = "/io")
    @Cacheable(value = "io")
    public String page1(Model model){
        List<Ioerror> ioerrors= ioerrorRepository.findAll();
        model.addAttribute("iolist",ioerrors);
        return "ioerror";
    }


}

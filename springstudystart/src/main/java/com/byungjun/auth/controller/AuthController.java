package com.byungjun.auth.controller;

import com.byungjun.auth.service.AuthService;
import com.byungjun.repository.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService service;

//    @RequestMapping(value = "/users.json", method = RequestMethod.GET)
//    @ResponseBody
//    public Map<String, Object> users() throws Exception{
//        Map<String, Object> map = new HashMap<>();
//        map.put("userList", service.users());
//        return map;
//    }
//
//    @RequestMapping(value = "/user.do", method = RequestMethod.GET)
//    public ModelAndView userView() throws Exception{
//        ModelAndView mv = new ModelAndView("auth/user");
//
//        User user = service.users().get(0);
//        mv.addObject("user", user);
//        return mv;
//    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String loginget() throws Exception{
        return "auth/login";
    }

    @RequestMapping(value = "logout.do", method = RequestMethod.GET)
    public String logout(
            HttpSession session
    )throws Exception{
        session.invalidate();
       return "redirect:/";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ModelAndView loginpost(
            String username,
            String password,
            HttpSession session
    ) throws Exception{
        ModelAndView mv = new ModelAndView("auth/login");
        if(!username.equals("") && !password.equals("")) {

            User user = service.getUserByUsername(username);

            if(user == null) {
                mv.addObject("success", false);
                mv.addObject("msg", "존재하지 않는 계정입니다.");
            }else if(user.getPassword().equals(password)) {
                session.setAttribute("user", user);
                mv.setViewName("redirect:/");
            }else {
                mv.addObject("success", false);
                mv.addObject("msg", "존재하지 않는 계정입니다.");
            }

        }else {
            mv.addObject("success", false);
            mv.addObject("msg","모든 항목을 입력하세요.");
        }
        return mv;
    }

    @RequestMapping(value = "/users.do", method = RequestMethod.GET)
    public ModelAndView users() throws  Exception{
        ModelAndView mv = new ModelAndView("auth/users");
        User users = new User();
        service.getUsers();
        mv.addObject("users",users);
        System.out.println(users);
        return mv;
    }
}

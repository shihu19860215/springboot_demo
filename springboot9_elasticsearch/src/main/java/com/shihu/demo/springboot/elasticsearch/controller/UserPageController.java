package com.shihu.demo.springboot.elasticsearch.controller;

import com.shihu.demo.springboot.elasticsearch.service.UserPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/users")
public class UserPageController {
    @Autowired
    UserPageService userPageService;          // 用户服务层


    @RequestMapping(value = "/context/{context}",method = RequestMethod.GET)
    public String findByNameAndBirthday(ModelMap map, @PathVariable String context) {
        map.addAttribute("userList", userPageService.searchCity(null,null,context));
        return "userList";
    }
}

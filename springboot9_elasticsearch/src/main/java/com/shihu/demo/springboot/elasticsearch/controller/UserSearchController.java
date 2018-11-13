package com.shihu.demo.springboot.elasticsearch.controller;


import com.shihu.demo.springboot.elasticsearch.service.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/users")     // 通过这里配置使下面的映射都在 /users
public class UserSearchController{
    @Autowired
    UserSearchService userSearchService;



    @RequestMapping(value = "/name/and/birthday",method = RequestMethod.GET)
    public String findByNameAndBirthday(ModelMap map,String name,String birthday) {
        map.addAttribute("userList", userSearchService.findByNameAndBirthday(name,birthday));
        return "userList";
    }
    @RequestMapping(value = "/name/or/birthday",method = RequestMethod.GET)
    public String findByNameOrBirthday(ModelMap map,String name,String birthday) {
        map.addAttribute("userList", userSearchService.findByNameOrBirthday(name,birthday));
        return "userList";
    }
    @RequestMapping(value = "/name",method = RequestMethod.GET)
    public String findByName(ModelMap map,String name) {
        map.addAttribute("userList", userSearchService.findByName(name));
        return "userList";
    }
    @RequestMapping(value = "/name/not",method = RequestMethod.GET)
    public String findByNameNot(ModelMap map,String name) {
        map.addAttribute("userList", userSearchService.findByNameNot(name));
        return "userList";
    }
    @RequestMapping(value = "/name/like",method = RequestMethod.GET)
    public String findByNameLike(ModelMap map,String name) {
        map.addAttribute("userList", userSearchService.findByNameLike(name));
        return "userList";
    }
}

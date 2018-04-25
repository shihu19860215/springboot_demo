package com.shihu.demo.springboot.errorpage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping("/")
	public String home(Model model) {
		return "index";
	}

	@RequestMapping("/error500")
	public void index() {
		int a = 1 / 0;
		System.out.println(a);
	}

	/**
	 * /error400/+字母出现无法解析
	 * @param id
	 * @return
	 */
	@RequestMapping("/error400/{id}")
	public Object error400(@PathVariable("id") Integer id) {
		System.out.println(id);
		return id;
	}

}

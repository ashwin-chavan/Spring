package com.gsmthn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gsmthn.pojo.UiLoginFormObject;

@Controller
public class LoginSignupFormController {

	@RequestMapping("/login.do")
	public ModelAndView doLogin(@ModelAttribute UiLoginFormObject obj){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}

package com.gsmthn.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gsmthn.global.LoginType;
import com.gsmthn.pojo.UiLoginFormObjectEmail;
import com.gsmthn.pojo.UiLoginFormObjectPhone;
import com.gsmthn.pojo.UiLoginFormObjectUserName;
import com.gsmthn.service.LoginSignupService;

@Controller
public class LoginSignupFormController {

	@Resource
	private LoginSignupService loginSignupService;
	
	@RequestMapping("/login.do")
	public ModelAndView doLogin(@ModelAttribute Object obj){
		ModelAndView mav = new ModelAndView();
		String userName;
		String password;
		String emailId;
		String phoneNo;
		boolean validUser = false;
		LoginType lt = null;
		if(obj instanceof UiLoginFormObjectUserName){
			userName = ((UiLoginFormObjectUserName) obj).getUserName();
			password = ((UiLoginFormObjectUserName) obj).getPassword();
			validUser = loginSignupService.authenticateUser(LoginType.USERNAME,userName,password);
			lt = LoginType.USERNAME;
		} else if(obj instanceof UiLoginFormObjectEmail){
			emailId = ((UiLoginFormObjectEmail) obj).getEmailId();
			password = ((UiLoginFormObjectEmail) obj).getPassword();
			validUser = loginSignupService.authenticateUser(LoginType.EMAIL,emailId,password);
			lt = LoginType.EMAIL;
		} else if(obj instanceof UiLoginFormObjectPhone){
			phoneNo = ((UiLoginFormObjectPhone) obj).getPhoneNo();
			password = ((UiLoginFormObjectPhone) obj).getPassword();
			validUser = loginSignupService.authenticateUser(LoginType.PHONENO,phoneNo,password);
			lt = LoginType.PHONENO;
		} /*else {
			return new ModelAndView("error", "errormsg", "Enter Valid Details");
		}*/
		if(validUser){
			loginSignupService.getUserData(obj, lt);
		}
		return mav;
	}
}

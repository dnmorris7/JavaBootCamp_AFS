package com.accenture.adf.newcodington.module27.sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
	
	@RequestMapping("/userlogin.htm")
	public ModelAndView validateUser(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		ModelAndView mView=new ModelAndView();
		if(userName.equalsIgnoreCase(password))
		{
			mView.addObject("USERNAME", userName);
			mView.setViewName("/usersuccess.jsp");
		}
		else
		{
			mView.addObject("ERROR", "Invalid Credentials");
			mView.setViewName("/sample.jsp");
		}
		return mView;
	}

}

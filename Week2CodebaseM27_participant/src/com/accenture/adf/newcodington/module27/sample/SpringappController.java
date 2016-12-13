package com.accenture.adf.newcodington.module27.sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


// TODO 1 Add @Controller annotation just above the class SpringappController to make it act like a Controller 
@Controller
public class SpringappController{
	 /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

// TODO 2 Add @RequestMapping("/hello.htm") just above handleRequest method for it to handle requests mapped to hello.htm
	@RequestMapping("/hello.htm")
    public ModelAndView handleRequest(HttpServletRequest arg0,HttpServletResponse arg1) throws Exception {
	
		logger.info("SpringappController - returning hello view");
		
// TODO 3 return a new ModelAndView object passing ("/WEB-INF/hello.jsp") as its parameter. 
        return new ModelAndView("/WEB-INF/hello.jsp");
		 
	}
}

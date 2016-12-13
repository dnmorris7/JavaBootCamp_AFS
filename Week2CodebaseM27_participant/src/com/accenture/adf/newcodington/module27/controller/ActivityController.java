package com.accenture.adf.newcodington.module27.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.adf.newcodington.module27.dao.MuseumDao;

//************This code needs to be completed in order to remove all the errors.************//

@Controller
public class ActivityController {

	@RequestMapping("/museuminsert.htm")
	public ModelAndView validateUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String museumid = request.getParameter("museumid");
		String museumname = request.getParameter("museumname");
		String museumtype = request.getParameter("museumtype");
		String buildingid = request.getParameter("buildingid");

		// TODO Create instance of ModelAndView class
		// TODO Create instance of MuseumDao class
		ModelAndView mvc = new ModelAndView();
		MuseumDao dao = new MuseumDao();
		int updRecord = 0;
		try {
			// TODO Access "insertRecord" method from DAO class and store the
			// return value into updRecord variable
			updRecord = dao.insertRecord(museumid, museumname, museumtype, buildingid);

		} catch (ClassNotFoundException ex) {
			// TODO map exception message to "MESSAGE" keyword using
			// ModelAndView object. This is located under WebContent.
			// TODO set viewname of ModelAndView object to "activity.jsp"
			mvc.addObject("MESSAGE", ex);
			mvc.setViewName("/activity.jsp");
		} catch (SQLException ex) {
			// TODO map exception message to "MESSAGE" keyword using
			// ModelAndView object
			// TODO set viewname of ModelAndView object to "activity.jsp"
			mvc.addObject("MESSAGE", ex);
			mvc.setViewName("/activity.jsp");
		}
		if (updRecord > 0) {
			// TODO map String "Successfully Inserted" to "MESSAGE" keyword
			// using ModelAndView object
			// TODO set viewname of ModelAndView object to "activity.jsp"
			mvc.addObject("MESSAGE", "Successfuly Inserted");
			mvc.setViewName("/activity.jsp");
		}
		return mvc; // Replace null value with ModelAndView object
	}
}

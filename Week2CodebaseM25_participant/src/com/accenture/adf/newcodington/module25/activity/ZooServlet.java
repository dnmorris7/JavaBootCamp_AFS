package com.accenture.adf.newcodington.module25.activity;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ZooServlet
 */
public class ZooServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZooServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String zooid=request.getParameter("zooid");
		String zooname=request.getParameter("zooname");
		int animalcount=Integer.parseInt(request.getParameter("animalcount"));
		String placeid=request.getParameter("placeid");
		
		HttpSession session=request.getSession();
		
		ZooDAO dao=new ZooDAO();
		boolean insertStatus=false;
		
		try {
			insertStatus=dao.insertRecord(zooid, zooname, animalcount, placeid);
		} catch (SQLException e) {
			session.setAttribute("STATUS", e.getMessage());
		} catch (ClassNotFoundException e) {
			session.setAttribute("STATUS", e.getMessage());
		}
		System.out.println(insertStatus);
		if(insertStatus==true)
			 session.setAttribute("STATUS","Succesfully inserted... Please check database table!!");
 			
			RequestDispatcher rd=request.getRequestDispatcher("/insert.jsp");
			rd.forward(request, response);


		
	}

}

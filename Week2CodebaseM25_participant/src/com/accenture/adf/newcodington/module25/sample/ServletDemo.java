package com.accenture.adf.newcodington.module25.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Topic : Servlets Instructions : 1. Demo to create a Servlet and execute the
 * same 2. Code as per the TODOs
 */

public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDemo() {
		super();

	}

	// Overriding doGet method to print "Hello World" on the browser screen.
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// TODO 1 Obtain PrintWriter object from HttpServletResponse object
		// using the getWriter() method
		PrintWriter pw = response.getWriter();

		// TODO 2 Using the PrintWriter object print "Hello World" and enclose
		// it in <h1>
		pw.print("<h1>Hello World</h1>");

		// TODO 3 Print hyperlink reference to index.html labeled 'Home' and
		// enclose it in <h1>
		pw.print("<h1><a href='index.html'>Home<a></h1>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		// TODO 4 Call doGet() method with the appropriate parameters

	}

}

package com.mpinfo.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class TestLog extends HttpServlet
{
	//private Logger logger = Logger.getLogger(this.getClass().getName());
	
	private Logger logger = Logger.getLogger("sdmp");
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		logger.info("from log4j=== test log4j log");
		logger.debug("from log4j=== test log4j debug log");
		logger.error("from log4j=== test log4j error log");

		System.out.println("from system.out.println==== test system.out.println log");
		System.err.println("from system.err.println==== test system.error.println log");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
    	out.println("from printwriter=== test printwriter log");
    	
    	try
    	{
    		ArrayList ar = new ArrayList();
    		ar.add(new Integer("1"));
    		ar.add(new String("2"));
    		
    		logger.info("from log4j=== get arraylist index=2" + ar.get(2));
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		e.printStackTrace();
    		logger.error("from log4j=== error===" + e.getMessage());
    		System.err.println("from system.err.println=== error===" + e.getMessage());
    	}

    	out.close();
	}
}

package com.controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class getStatement2 extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try {
		HttpSession session = request.getSession();
		String acc_no=(String) session.getAttribute("acc_no");
	
		model m=new model();
		m.setAcc_no(acc_no);
	ArrayList al = m.getStatement();
	if(al.isEmpty())
	{
		response.sendRedirect("StatementUnsuccessful.html");
	}
	else
	{
	session=request.getSession();
	session.setAttribute("TAMT",al);
	session.setAttribute("ACC_NO", acc_no);
	response.sendRedirect("StatementSuccess.jsp");
	}	
}
		catch(Exception e)
		{
			
		}
	}
}
package com.controller;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class changePwd extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try {
	String password=request.getParameter("pwd");
	HttpSession session = request.getSession();
	String acc_no=(String) session.getAttribute("acc_no");
	
	model m=new model();
	m.setPassword(password);
	m.setAcc_no(acc_no);
	boolean status = m.changepwd();
	if(status==true)
	{
		response.sendRedirect("/bank/changePwdSuccess.html");
	}
	else
	{
		response.sendRedirect("/bank/changePwdUnSuccess.html");
	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
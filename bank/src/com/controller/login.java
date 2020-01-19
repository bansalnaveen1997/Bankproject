package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet
{
	
public void service(HttpServletRequest request , HttpServletResponse response)throws IOException
{
	
	
  String cusid=request.getParameter("cusid");
  String password=request.getParameter("password");
  model m=new model();
  m.setCus_id(cusid);
  m.setPassword(password);
  boolean status=m.login();
  if(status==true)
  {
	  HttpSession session=request.getSession(true);
	  session.setAttribute("acc_no", m.getAcc_no());
	  response.sendRedirect("/bank/loginsuccessful.html");
	  
  }
  else
  {
	 response.sendRedirect("/bank/loginunsuccessful.html");
  }
}
}
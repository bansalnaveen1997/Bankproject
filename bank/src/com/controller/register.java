package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class register extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String name=request.getParameter("name");
	 String acc_no=request.getParameter("acc");
	 String cus_id =request.getParameter("cusid");
	 String password=request.getParameter("pwd");
	 String cnfpw=request.getParameter("cnfpwd");
	 String balance=request.getParameter("bal");
	 model m =new model();
	 m.setName(name);
	 m.setAcc_no(acc_no);
	 m.setCus_id(cus_id);
	 m.setPassword(password);
	 m.setConfirm(cnfpw);
	 m.setBalance(balance);
	 
	  boolean status=m.register();
	  if(status==true)
	  {
		  //HttpSession session=request.getSession(true);
		  //session.setAttribute("acc_no", m.getAcc_no());
		  response.sendRedirect("/bank/registersuccessful.html");
		  
	  }
	  else
	  {
		 response.sendRedirect("/bank/registerunsuccessful.html");
	  }
		
	}

}

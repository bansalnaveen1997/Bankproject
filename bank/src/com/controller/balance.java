package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class balance extends HttpServlet {
	public void service(HttpServletRequest request , HttpServletResponse response)throws IOException
	{
		try {
	HttpSession session =request.getSession();
	String acc_no=(String) session.getAttribute("acc_no");
	System.out.println(acc_no);
		model m =new model();
		m.setAcc_no(acc_no);
		boolean status=m.balance();
		  if(status==true)
		  {
			//  HttpSession session=request.getSession(true);
			  //session.setAttribute("BALANCE", balance);
			  session.setAttribute("BALANCE", m.getBalance());
			  response.sendRedirect("balance.jsp");
			  
			  
		  }
		  else
		  {
			 response.sendRedirect("balanceunsuccessful.html");
		  }
		}
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		
	
	

}
	
	
	}
package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AmtTransfer extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try {
		HttpSession session = request.getSession();
		String acc_no=(String) session.getAttribute("acc_no");
		System.out.println(acc_no);
	int tamt=Integer.parseInt(request.getParameter("tamt"));
	/*String raccno = request.getParameter("tacc1");
	
	String theAmt = tamt;
	String theRaccno = raccno;
	System.out.println("Trans");
	System.out.println(theRaccno);
	*/
	model m=new model();
	//m.setBalance(tamt);
	m.setAcc_no(acc_no);
	m.setTamt(tamt);
	//m.setRacc_no(theRaccno);
   boolean status=m.amtTransfer();
	if(status==true)
	{
		response.sendRedirect("/bank/AmtTransferSuccess.html");
	}
	else
	{
		response.sendRedirect("AmtTransferUnSuccess.html");
	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
}
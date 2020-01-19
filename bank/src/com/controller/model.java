package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class model {
	int tamt;
	String name;
	String acc_no;
	String cus_id;
	String balance;
	String password;
	String confirm;
	 String racc_no;
	public String getRacc_no() {
		return racc_no;
	}
	public void setRacc_no(String racc_no) {
		this.racc_no = racc_no;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	Connection con;
	ResultSet  res;
	
	PreparedStatement pstmt;
	String un="system";
	 String pw="system";
	String url="jbbc:oracle:thin:@//localhost:1521/XE";

	
	public int getTamt() {
		return tamt;
	}
	public void setTamt(int tamt) {
		this.tamt = tamt;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	public String getCus_id() {
		return cus_id;
	}
	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	model()
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url ,un,pw);
			System.out.println("done");
		}
		catch(Exception e)
		{
			System.out.println("not loaded");
			e.printStackTrace();
			
		}
	}


	
	
	
	
	public boolean login()
	{
		try 
		{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//con=DriverManager.getConnection(url ,un,pw);
			pstmt=con.prepareStatement("SELECT * FROM BANKAAP WHERE CUS_ID=? AND PASSWORD=?");
			pstmt.setString(1,cus_id);
			pstmt.setString(2,password);
			res=pstmt.executeQuery();
			if(res.next()==true)
			{
				
			
			acc_no=res.getString("ACC_NO");
			return true;
			}
			else {
				return false;
			}
			
			
		}
	   catch(Exception e)
		{
		   e.printStackTrace();
		}
		return false;
	}
	
	public boolean balance()
	{
		try {
			pstmt =con.prepareStatement("SELECT * FROM BANKAAP WHERE  ACC_NO=?");
			pstmt.setString(1, acc_no);
			res=pstmt.executeQuery();
			if(res.next())
			{
				balance=res.getString("BALANCE");
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean changepwd() 
	{
		try {
	      pstmt=con.prepareStatement("UPDATE BANKAAP SET PASSWORD=? WHERE ACC_NO=?");
	       pstmt.setString(1,password);
	       pstmt.setString(2, acc_no);
	       int rows=pstmt.executeUpdate();
	       if(rows==0)
	       {
	    	   return false;
	       }
	       else
	       {
	    	   return true;
	       }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		}
	
	public boolean amtTransfer()
	{
		try {
	   pstmt=con.prepareStatement("UPDATE BANKAAP SET BALANCE=BALANCE-? WHERE ACC_NO=?");
	   pstmt.setInt(1, tamt);
	   pstmt.setString(2, acc_no);
	 int rows=pstmt.executeUpdate();
		
		if(rows==0)
		{
			return false;
		}
	  else 
		{
			pstmt=con.prepareStatement("INSERT INTO STATEMENTS VALUES(?, ?)");
	        pstmt.setString(1, acc_no);
	        pstmt.setInt(2, tamt);
	        int rowss=   pstmt.executeUpdate();
	        
	      /*  pstmt=con.prepareStatement("UPDATE BANKAAP SET BALANCE=BALANCE+? WHERE ACC_NO=?");
	        pstmt.setString(1, balance);
	        //pstmt.setString(1, acc_no);
	        pstmt.setString(2, racc_no);
	       int qry2= pstmt.executeUpdate();
	       
	       if(qry2==1)
	   	{
	   		pstmt = con.prepareStatement("INSERT INTO STATEMENT VALUES(?,?)");
	   		pstmt.setString(1, acc_no);
	   		pstmt.setInt(2, (tamt*-1));
	   		int qry3 = pstmt.executeUpdate();

	   		if(qry3==1)
	   		{
	   			pstmt = con.prepareStatement("INSERT INTO STATEMENT VALUES(?,?)");
	   			pstmt.setString(1, racc_no);
	   			pstmt.setInt(2, tamt);
	   			int qry4 = pstmt.executeUpdate();

	   			if(qry4 == 1)
	   			*/
	   		    return true;
	   		}
	   	
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList getStatement()
	{
		 ArrayList al=new ArrayList();
		try {
	pstmt=con.prepareStatement("SELECT * FROM STATEMENTS WHERE ACC_NO=?");	
		pstmt.setString(1, acc_no);
		res=pstmt.executeQuery();
		while(res.next())
		{
			al.add(res.getInt("TAMT"));
			
		}
		return al;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
		
	}
	public boolean register() {

		try {
			
			pstmt=con.prepareStatement("INSERT INTO BANKAAP VALUES(?, ?, ?, ?,?,?)");
			pstmt.setString(1,name);
			pstmt.setString(2,acc_no);
			pstmt.setString(3, cus_id);
			pstmt.setString(4,password);
			pstmt.setString(5,balance);
			pstmt.setString(6, confirm);
		int rows=pstmt.executeUpdate();
	       if(rows==0)
	       {
	    	   return false;
	       }
	       else
	       {
	    	   return true;
	       }
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	
		return false;
	}
}
	

	


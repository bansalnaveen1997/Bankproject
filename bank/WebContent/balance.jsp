<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1" content="width=device-width, initial-scale=1">
<link rel="../WebContent/css/bootstrap.min.css">
<title>Insert title here</title>
<style>
body 
{background-color: #E8E8E8; padding-right: 0px;}

.center{
          text-align: center;
       }
 h1
	 {
	  margin-left: auto;
      margin-right: auto;
	 }
 </style>
<title>Insert title here</title>
</head>
<body>
<div class="center" Style="margin_left:50;">
<h1 style="background-color:DodgerBlue;align:center">Welcome to ICICI BANK</h1>

</div>
<center>
<h1>Your Balance is </h1>
<%
out.println(session.getAttribute("BALANCE"));
 %>$</center>
</body>
</html>
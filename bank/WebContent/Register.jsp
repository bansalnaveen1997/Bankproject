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

<form  action="register">
<center>
<table border="1">
<tr>
<td>Name :</td> <td><input type="text"  name="name" required></input></td><br>
</tr>
<tr>
<td>Acc_no: </td> <td> <input type="noumber" name="acc" requried></td><br>
</tr>
<tr>
<td>Cus_Id: </td> <td><input type="text" name="cusid" requried></td><br>
</tr>
<tr>
<td>Password: </td><td><input type="password" name="pwd" requried></td><br>
</tr>
<tr>
<td>Confirm Password:</td> <td><input type="password" name="cnfpwd" requried></td><br>
<tr>
<td>Balance : </td><td><input type="noumber" name="bal" requried></td><br>
</tr>
<tr>
<td  colspan="2">
<input type="submit"></input></td>
</tr>
</table>
</center>
</form>
</body>
</html>
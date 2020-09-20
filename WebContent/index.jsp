<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compare Two Loans</title>
</head>
<body>
	<h1 style="text-align:center">Compare Two Loans</h1>
	<p> This application will calculate the amount of interest paid over the life over 
	    the life of two loans and display the result to see which is the cheaper loan.</p>
	<hr>
	<form action="getLoanTerms1Servlet" method="post">
	Enter principal amount of loan #1:
	<input type="text" name="userPrincipal" size="10">
	<br>
	Enter interest rate for loan #1:    
	<input type="text" name="userRate" size="10">
	%
	<br>
	Enter term of loan #1 in years:          
	<input type="text" name="userTerm" size="10">
	<br>
	Enter number of payments per year for loan #1:
	<input type="text" name="userFreq" size="10">
	<br>
	<input type="submit" value="Enter Terms For Loan #2" />
	</form>
</body>
</html>
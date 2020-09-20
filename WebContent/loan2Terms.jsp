<%@page import="model.Loan"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compare Two Loans</title>
</head>
<body>
	<h1 style="text-align:center">Compare Two Loans</h1>
	<hr>
	<form action="getLoanTerms2Servlet" method="post">
	Enter principal amount of loan #2:
	<input type="text" name="userPrincipal" size="10">
	<br>
	Enter interest rate for loan #2:    
	<input type="text" name="userRate" size="10">
	%
	<br>
	Enter term of loan #2 in years:          
	<input type="text" name="userTerm" size="10">
	<br>
	Enter number of payments per year for loan #2:
	<input type="text" name="userFreq" size="10">
	<br>
	<input type="submit" value="Compare The Loans" />
	<input type="hidden" name="loan1principal" value=${loan1.getPrincipal().toString()}>
	<input type="hidden" name="loan1rate" value=${loan1.getRate().toString()}>
	<input type="hidden" name="loan1term" value=${loan1.getTerm().toString()}>
	<input type="hidden" name="loan1annualfrequency" value=${loan1.getAnnualFrequency().toString()}>
	<input type="hidden" name="loan1paymentamount" value=${loan1.getPaymentAmount().toString()}>
	</form>
</body>
</html>
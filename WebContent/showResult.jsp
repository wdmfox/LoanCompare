<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Total Interest Comparison For Two Loans</title>
</head>
<body>
<p>Loan #1:   <br />
     Principal: ${p1.toString()}           <br />
     Rate:      ${r1.toString()} %         <br />
     Term:      ${t1.toString()} years     <br />
     Frequency: ${f1.toString()} per year  <br />
     Pymt Amt:  ${pymt1.toString()}        <br />
     Total Int: ${tint1.toString()}        <br />
     <br />
Loan #2:   <br />
     Principal: ${p2.toString()}           <br />
     Rate:      ${r2.toString()} %         <br />
     Term:      ${t2.toString()} years     <br />
     Frequency: ${f2.toString()} per year  <br />
     Pymt Amt:  ${pymt2.toString()}        <br />
     Total Int: ${tint2.toString()}        <br />
     <br />     
${result.toString()}
</p>
<a href="index.jsp">Compare more loans</a>
</body>
</html>
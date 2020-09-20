/* *******************************************************
// ** CIS175 - CRN 13941
// ** Week 4 - Assessment
// ** getLoanTerms2Servlet
// ** By Robert Fox, September 20, 2020
// *******************************************************
// **
// ** getLoanTerms2Servlet.java is executed after the user
// ** enters data and clicks the button on the form for
// ** Loan #2.   The Loan object for Loan #1 is brought in 
// ** from the session and a Loan object for Loan #2 is 
// ** instantiated.  The object properties for both loans
// ** are passed to the showResult.jsp for display along
// ** with a string the expresses which loan carries more
// ** interest and by how much.
*/

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.NumberFormat;

import model.Loan;

/**
 * Servlet implementation class getLoanTerms2Servlet
 */
@WebServlet("/getLoanTerms2Servlet")
public class getLoanTerms2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getLoanTerms2Servlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// instantiate NumberFormat object to format $$$ amounts down below
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		
		// we will setup resultStr and pass it to showResult.jsp
		// for display
		String resultStr = "";
	
		// grab the object for Loan #1
		Loan loan1 = (Loan)request.getSession().getAttribute("loan1");
		
		// capture the data the user entered on the form for Loan #2
		String userPrincipal = request.getParameter("userPrincipal");
		String userRate = request.getParameter("userRate");
		String userTerm = request.getParameter("userTerm");
		String userFreq = request.getParameter("userFreq");
		
		// do type casting into the Loan class properties using the 
		// data entered for Loan #2
		double principal = Double.parseDouble(userPrincipal);
		double rate = Double.parseDouble(userRate);
		int term = Integer.parseInt(userTerm);
		int freq = Integer.parseInt(userFreq);
		
		// instantiate Loan object for Loan #2 passing the data entered by the user
		Loan loan = new Loan(principal, rate, term, freq);
	
		// calculate the total interest amounts for Loan #1 and Loan #2
		double totalInterest1 = loan1.totalInterest();

		double totalInterest2 = loan.totalInterest();
		
		// setup the resultStr message based upon comparing the total interest
		// amounts of Loan #1 and Loan #2
		if (totalInterest1 > totalInterest2)
		{
			double difference = totalInterest1 - totalInterest2;
			String displayDiff = currencyFormatter.format(difference);
			resultStr = "You will pay " + displayDiff + " more in interest with Loan #1";
		} else if (totalInterest2 > totalInterest1)
		{
			double difference = totalInterest2 - totalInterest1;
			String displayDiff = currencyFormatter.format(difference);
			resultStr = "You will pay " + displayDiff + " more in interest with Loan #2";
		} else  // both loans charge the same total interest
		{
			resultStr = "The amount of interest between Loan #1 and Loan #2 is the same.";
		}
		
		// use setAttibute to pass the data for Loan #1 and Loan #2 in a formatted manner
		// for display on showResult.jsp
		request.setAttribute("p1", currencyFormatter.format(loan1.getPrincipal()));
		request.setAttribute("r1", loan1.getRate());
		request.setAttribute("t1", loan1.getTerm());
		request.setAttribute("f1", loan1.getAnnualFrequency());
		request.setAttribute("pymt1", currencyFormatter.format(loan1.getPaymentAmount()));
		request.setAttribute("tint1", currencyFormatter.format(totalInterest1));

		request.setAttribute("p2", currencyFormatter.format(loan.getPrincipal()));
		request.setAttribute("r2", loan.getRate());
		request.setAttribute("t2", loan.getTerm());
		request.setAttribute("f2", loan.getAnnualFrequency());
		request.setAttribute("pymt2", currencyFormatter.format(loan.getPaymentAmount()));
		request.setAttribute("tint2", currencyFormatter.format(totalInterest2));
		
		// pass resultStr for display
		request.setAttribute("result", resultStr);
		
		// let's see the results
		getServletContext().getRequestDispatcher("/showResult.jsp").forward(request,  response);
	}

}

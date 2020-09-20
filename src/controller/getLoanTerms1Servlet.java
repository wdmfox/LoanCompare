/* *******************************************************
// ** CIS175 - CRN 13941
// ** Week 4 - Assessment
// ** getLoanTerms1Servlet
// ** By Robert Fox, September 20, 2020
// *******************************************************
// **
// ** getLoanTerms1Servlet.java is executed after the user
// ** enters data and clicks the button on the form for
// ** Loan #1.
*/

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Loan;

/**
 * Servlet implementation class getLoanTerms1Servlet
 */
@WebServlet("/getLoanTerms1Servlet")
public class getLoanTerms1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getLoanTerms1Servlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// capture the data the user entered on the form for Loan #1
		String userPrincipal = request.getParameter("userPrincipal");
		String userRate = request.getParameter("userRate");
		String userTerm = request.getParameter("userTerm");
		String userFreq = request.getParameter("userFreq");
		
		// do type casting into the Loan class properties using the 
		// data entered for Loan #1
		double principal = Double.parseDouble(userPrincipal);
		double rate = Double.parseDouble(userRate);
		int term = Integer.parseInt(userTerm);
		int freq = Integer.parseInt(userFreq);
		
		// instantiate Loan object for Loan #1 passing the data entered by the user
		Loan loan = new Loan(principal, rate, term, freq);
		
		// user setAttribute to make the Loan object for Loan #1
		// availble later in the session
		request.getSession().setAttribute("loan1", loan);
		
		// Let's grab the data for Loan #2
		getServletContext().getRequestDispatcher("/loan2Terms.jsp").forward(request,  response);
		
	
		
	}

}

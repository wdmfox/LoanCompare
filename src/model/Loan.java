/* *******************************************************
// ** CIS175 - CRN 13941
// ** Week 4 - Assessment
// ** Loan Class
// ** By Robert Fox, September 20, 2020
// *******************************************************
// **
// ** Loan.java is the POJO declaration for our loan objects
*/

package model;

public class Loan {
	
	private double principal;      // principal amount
	private double rate;           // interest rate
	private int term;              // loan term in years
	private int annualFrequency;   // payment frequency per year (i.e. monthly = 12)
	private double paymentAmount;  // loan's payment amount
	
	// default constructor
	public Loan() {
		this.principal = 0.00;
		this.rate = 0.00;
		this.term = 0;
		this.annualFrequency = 0;
		this.paymentAmount = 0.00;
	}
	
	// non-default constructor
	// takes in arguments for principal, rate, term and payment frequency.
	// calculatePayment method is executed to get the value for paymentAmount
	public Loan(double p, double r, int t, int f) {
		this.principal = p;
		this.rate = r;
		this.term = t;
		this.annualFrequency = f;
		this.paymentAmount = this.calculatePayment();
	}

	// getters and setters
	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public int getAnnualFrequency() {
		return annualFrequency;
	}

	public void setAnnualFrequency(int annualFrequency) {
		this.annualFrequency = annualFrequency;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	// calculatePayment returns the payment
	// amount of the loan
	public double calculatePayment() {
		
		// we divide pymt frequency into the interest rate
		// to obtain the rate per payment period
		double ratePerPeriod = (this.rate / this.annualFrequency) / 100;
		
		// we need to calculate the total number of payments
		// over the life of the loa
		int totalNumberOfPayments = this.term * this.annualFrequency;
		
		// this calculates and returns the payment amount
		return (this.principal * ratePerPeriod) / 
		            (1-Math.pow(1+ratePerPeriod, -totalNumberOfPayments));
	}
	
	// totalInterest returns the total amount of 
	// interest over the life of the loan.  if the
	// payment amount is zero or less, we call 
	// calculatePayment() to get it in the object.
	public double totalInterest() {
		
		if (this.paymentAmount < 0.01)
		{
			this.paymentAmount = this.calculatePayment();
		}
		
		// return total amount of payments over life of loan minus the original principal
		return (this.paymentAmount * this.term * this.annualFrequency) - this.principal;
	}
}

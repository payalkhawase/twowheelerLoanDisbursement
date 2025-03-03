package in.shriram.dreambiketwowheelerloan.disbursement.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoanDisbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int agreementId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loanno;
	private Date agreementDate;
	private String amountPayType;
	private double totalAmount;
	private String bankName;
	private long accountNumber;
	private String IFSCCode;
	private String accountType;
	private Double transferAmount;
	private String paymentStatus;
	private String amountPaidDate;
	
}

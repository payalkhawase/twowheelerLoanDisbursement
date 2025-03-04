package in.shriram.dreambiketwowheelerloan.disbursement.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
public class LoanDisbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int agreementId;
	
	@Column(unique = true, nullable = false)
	private int loanNo=101;
	public void generateLoanNumbers(int numLoan) {
		
	for (int i = 0; i < (numLoan=10); i++) {
        System.out.println(loanNo);   
        loanNo++;  
    }
	}
	private Date agreementDate;
	private String amountPayType;
	private double totalAmount;
	private String bankName;
	private long accountNumber;
	private String IFSCCode;
	private String accountType;
	private Double transferAmount;
	private String paymentStatus;
	private Date amountPaidDate;
	
	

	
}

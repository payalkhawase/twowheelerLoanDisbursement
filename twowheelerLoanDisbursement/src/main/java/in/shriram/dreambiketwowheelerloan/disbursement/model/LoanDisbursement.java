package in.shriram.dreambiketwowheelerloan.disbursement.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
public class LoanDisbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int agreementId;
	
	@Column(unique = true, nullable = false)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "second_id_seq")
   // @SequenceGenerator(name = "second_id_seq", sequenceName = "second_id_seq", allocationSize = 1)
	private int loanNo;
	
	 /* private static int loanNoCounter = 101;
	  public LoanDisbursement() {
	  this.loanNo=loanNoCounter++;
	  }*/
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

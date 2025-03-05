package in.shriram.dreambiketwowheelerloan.disbursement.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SanctionLetter {

	@Id
	private int sanctionId;
	private Date sanctionDate;
	private String applicantName;
	private String contactDetails;
	private double loanAmtSanctioned;
	private String interestType;
	private float rateOfInterest;
	private int loanTenureInMonth;
	private double monthlyEmiAmount;
	private String modeOfPayment;
	private double onRoadPrice;
	private String status;


	
}

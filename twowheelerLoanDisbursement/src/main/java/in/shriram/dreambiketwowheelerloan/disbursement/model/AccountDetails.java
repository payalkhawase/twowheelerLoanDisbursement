package in.shriram.dreambiketwowheelerloan.disbursement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class AccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	private String accounType;
	private double accountBalance;
	private String accountHolderName;
	private String accountStatus;
	private long accountNumber;
	private String bankName;
	private String IFSCCode;
	

	/*
	 *  "accounType":"saving",
         "bankName":"HDFC bank",
         "IFSCCode":"HD1234",
         "accountBalance":10000.00,
         "accountHolderName":"Priti",
         "accountStatus":"updated",
         "accountNumber":222147854
	 *  */
}

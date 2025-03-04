package in.shriram.dreambiketwowheelerloan.disbursement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AccountDetails {

	@Id
	private int accountId;
	private String accountType;
	private String bankName;
	private String IFSCCode;
	private double accountBalance;
	private String accountHolderName;
	private String accountStatus;
	private long accountNumber;

}

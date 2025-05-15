package in.shriram.dreambiketwowheelerloan.disbursement.servicei;

import java.util.List;

import in.shriram.dreambiketwowheelerloan.disbursement.model.LoanDisbursement;

public interface DisbursementServiceI {

	LoanDisbursement addAlldata(double transferAmount, int customerId);

	//List<LoanDisbursement> getSanctionedCustomers();

}

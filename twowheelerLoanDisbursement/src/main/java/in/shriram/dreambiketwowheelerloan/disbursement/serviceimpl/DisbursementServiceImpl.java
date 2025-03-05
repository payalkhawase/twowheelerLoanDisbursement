package in.shriram.dreambiketwowheelerloan.disbursement.serviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import in.shriram.dreambiketwowheelerloan.disbursement.model.Customer;
import in.shriram.dreambiketwowheelerloan.disbursement.model.LoanDisbursement;
import in.shriram.dreambiketwowheelerloan.disbursement.repository.DisbursementRepository;
import in.shriram.dreambiketwowheelerloan.disbursement.servicei.DisbursementServiceI;


@Service
public class DisbursementServiceImpl implements DisbursementServiceI{

	@Autowired
	DisbursementRepository dr;
	
	@Autowired
	RestTemplate rt;

	@Override
	public LoanDisbursement addAlldata(double transferAmount,int customerId) {
		
		Customer co=rt.getForObject("http://localhost:7777/sanction/getSanctionList",Customer.class);
		
		LoanDisbursement lDetails = new LoanDisbursement();
		
		lDetails.setAgreementDate(new Date());
		lDetails.setAmountPayType(co.getSanctionletter().getModeOfPayment());
		lDetails.setTotalAmount(co.getSanctionletter().getLoanAmtSanctioned());
		lDetails.setBankName(co.getAcdetails().getBankName());
		lDetails.setAccountNumber(co.getAcdetails().getAccountNumber());
		lDetails.setIFSCCode(co.getAcdetails().getIFSCCode());
		lDetails.setAccountType(co.getAcdetails().getAccountType());
		lDetails.setTransferAmount(transferAmount);
		lDetails.setPaymentStatus("not paid");
		lDetails.setAmountPaidDate(new Date());
		
		return dr.save(lDetails);
	}
}

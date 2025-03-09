package in.shriram.dreambiketwowheelerloan.disbursement.serviceimpl;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import in.shriram.dreambiketwowheelerloan.disbursement.model.Customer;
import in.shriram.dreambiketwowheelerloan.disbursement.model.LoanDisbursement;
import in.shriram.dreambiketwowheelerloan.disbursement.model.SanctionLetter;
import in.shriram.dreambiketwowheelerloan.disbursement.repository.CustomerRepo;
import in.shriram.dreambiketwowheelerloan.disbursement.repository.DisbursementRepository;
import in.shriram.dreambiketwowheelerloan.disbursement.servicei.DisbursementServiceI;


@Service
public class DisbursementServiceImpl implements DisbursementServiceI{

	@Autowired
	DisbursementRepository dr;
	
	@Autowired
	RestTemplate rt;
    
	@Autowired
	CustomerRepo cr;
	@Override
	public LoanDisbursement addAlldata(double transferAmount,int customerId) {
		
		
		Customer co=rt.getForObject("http://localhost:7777/apploan/getSanctionList/"+customerId, Customer.class);
		
		LoanDisbursement lDetails = new LoanDisbursement();
		//Integer loanNo = dr.getLastSecondId();
       // lDetails.setLoanNo(loanNo != null ? loanNo + 1 : 1);
		LoanDisbursement loanNo=dr.findAgreementIdByOrderByAgreementIdDesc(Limit.of(1));
		int ln;
		if(loanNo==null) {
			ln=1;
		}else {
			 ln=loanNo.getLoanNo()+1;
		}
		lDetails.setLoanNo(ln);
		
		lDetails.setAgreementDate(new Date());
		lDetails.setAmountPayType(co.getSanctionletter().getModeOfPayment());
		lDetails.setTotalAmount(co.getSanctionletter().getLoanAmtSanctioned());
		lDetails.setBankName(co.getAcdetails().getBankName());
		lDetails.setAccountNumber(co.getAcdetails().getAccountNumber());
		lDetails.setIFSCCode(co.getAcdetails().getIfscCode());
		lDetails.setAccountType(co.getAcdetails().getAccountType() );
		lDetails.setTransferAmount(transferAmount);
		lDetails.setPaymentStatus("not paid");
		lDetails.setAmountPaidDate(new Date());
		LoanDisbursement ld=dr.save(lDetails);
		co.setLoandisburst(ld);
		co.setLoanStatus("Disbursed");
		cr.save(co);
		return ld;
	}
}

package in.shriram.dreambiketwowheelerloan.disbursement.serviceimpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
	
	

//	public LoanDisbursement addAlldata(double transferAmount,int customerId)
//	{
		
		
		
		//Customer co=rt.getForObject("http://localhost:7777/apploan/getSanctionList/"+customerId, Customer.class);
		/*Customer[] co = rt.getForObject("http://localhost:7777/apploan/getSanctionList/" + customerId, Customer[].class);

		
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
	}*/
		@Override
		public LoanDisbursement addAlldata(double transferAmount, int customerId) {
		    // Fetching customer data from the external service
		    Customer[] customers = rt.getForObject("http://localhost:7777/apploan/getSanctionList/" + customerId, Customer[].class);
		    
		    // Check if the response is not empty or null
		    if (customers == null || customers.length == 0) {
		        throw new RuntimeException("No customer data found for customerId: " + customerId);
		    }
		    
		    // Get the first customer (or modify logic as needed)
		    Customer co = customers[0];
		    
		    LoanDisbursement lDetails = new LoanDisbursement();
		    // Setting loan details
		    LoanDisbursement loanNo = dr.findAgreementIdByOrderByAgreementIdDesc(Limit.of(1));
		    int ln;
		    if (loanNo == null) {
		        ln = 1;
		    } else {
		        ln = loanNo.getLoanNo() + 1;
		    }
		    lDetails.setLoanNo(ln);
		    lDetails.setAgreementDate(new Date());
		    lDetails.setAmountPayType(co.getSanctionletter().getModeOfPayment());
		    lDetails.setTotalAmount(co.getSanctionletter().getLoanAmtSanctioned());
		    lDetails.setBankName(co.getAcdetails().getBankName());
		    lDetails.setAccountNumber(co.getAcdetails().getAccountNumber());
		    lDetails.setIFSCCode(co.getAcdetails().getIfscCode());
		    lDetails.setAccountType(co.getAcdetails().getAccountType());
		    lDetails.setTransferAmount(transferAmount);
		    lDetails.setPaymentStatus("not paid");
		    lDetails.setAmountPaidDate(new Date());
		    
		    // Saving the loan disbursement details
		    LoanDisbursement ld = dr.save(lDetails);
		    co.setLoandisburst(ld);
		    co.setLoanStatus("Disbursed");
		    cr.save(co);
		    
		    return ld;
		}

//        @Override
//		public List<LoanDisbursement> getSanctionedCustomers() {
//			
//		     String url = "http://localhost:7777/sanction/sanctioned";
//		     List response = rt.getForObject(url, List.class);
//		        return response;
//		    
//		}

}

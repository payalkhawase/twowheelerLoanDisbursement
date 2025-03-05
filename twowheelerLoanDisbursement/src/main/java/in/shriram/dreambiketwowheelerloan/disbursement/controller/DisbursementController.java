package in.shriram.dreambiketwowheelerloan.disbursement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.shriram.dreambiketwowheelerloan.disbursement.model.LoanDisbursement;
import in.shriram.dreambiketwowheelerloan.disbursement.servicei.DisbursementServiceI;

@RestController
@RequestMapping("/disburse")
public class DisbursementController {

	@Autowired
	DisbursementServiceI dsi;
	
	@PostMapping("adddisbursment/{transferAmount}/{customerId}")
	public LoanDisbursement addAlldata(@PathVariable("transferAmount") double transferAmount,@PathVariable("customerId") int customerId) {
		
		LoanDisbursement ld=dsi.addAlldata(transferAmount,customerId);
		return ld;
		
	}
}

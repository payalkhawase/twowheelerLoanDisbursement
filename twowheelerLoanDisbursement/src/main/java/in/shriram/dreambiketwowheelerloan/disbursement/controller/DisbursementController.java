package in.shriram.dreambiketwowheelerloan.disbursement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.shriram.dreambiketwowheelerloan.disbursement.servicei.DisbursementServiceI;

@RestController
@RequestMapping("/disburse")
public class DisbursementController {

	@Autowired
	DisbursementServiceI dsi;
}

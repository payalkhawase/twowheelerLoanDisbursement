package in.shriram.dreambiketwowheelerloan.disbursement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.shriram.dreambiketwowheelerloan.disbursement.repository.DisbursementRepository;
import in.shriram.dreambiketwowheelerloan.disbursement.servicei.DisbursementServiceI;

@Service
public class DisbursementServiceImpl implements DisbursementServiceI{

	@Autowired
	DisbursementRepository dr;
	
	@Autowired
	RestTemplate rt;
}

package in.shriram.dreambiketwowheelerloan.disbursement.repository;


import java.util.List;

import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.shriram.dreambiketwowheelerloan.disbursement.model.LoanDisbursement;

@Repository
public interface DisbursementRepository extends JpaRepository<LoanDisbursement, Integer>{

	//int findAgreementIdByOrderByAgreementIdDesc(int i);

	//public LoanDisbursement findByOrderByAgreementIdDesc(Limit limit);

	public LoanDisbursement findAgreementIdByOrderByAgreementIdDesc(Limit limit);

	//public List<LoanDisbursement> findByStatus(String string);
	
	// @Query("SELECT MAX(e.secondId) FROM MyEntity e")
	 //   Integer getLastSecondId();
}

package in.shriram.dreambiketwowheelerloan.disbursement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.shriram.dreambiketwowheelerloan.disbursement.model.LoanDisbursement;

@Repository
public interface DisbursementRepository extends JpaRepository<LoanDisbursement, Integer>{

}

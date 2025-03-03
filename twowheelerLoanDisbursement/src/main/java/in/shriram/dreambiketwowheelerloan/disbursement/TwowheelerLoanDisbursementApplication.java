package in.shriram.dreambiketwowheelerloan.disbursement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TwowheelerLoanDisbursementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwowheelerLoanDisbursementApplication.class, args);
	}

	@Bean
	public RestTemplate rt()
	{
		return new RestTemplate();
	}
}

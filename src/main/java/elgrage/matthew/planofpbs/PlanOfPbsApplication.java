package elgrage.matthew.planofpbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PlanOfPbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanOfPbsApplication.class, args);
	}

}

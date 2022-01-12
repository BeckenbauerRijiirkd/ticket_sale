package ticket.sale.ticket_sale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class TicketSaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketSaleApplication.class, args);
	}
	

}

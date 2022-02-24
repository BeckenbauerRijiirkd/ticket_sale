package ticket.sale.ticket_sale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableSwagger2
public class TicketSaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketSaleApplication.class, args);
	}
	//ALTERAÇÃO PARA TESTE NO JIRA TIC-2

}
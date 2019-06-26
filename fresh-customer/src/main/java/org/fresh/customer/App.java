package org.fresh.customer;

import org.fresh.customer.domain.model.Customer;
import org.fresh.customer.domain.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableHypermediaSupport(type=EnableHypermediaSupport.HypermediaType.HAL)
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("Hello World!");
	}
	
	@Bean
	public CommandLineRunner execSampleCode(CustomerRepository customerRepository) {	
		return (args) -> {
			insertCustomers(customerRepository);
					
			//executeExample1(accountRepository);
		};
	}
	
	public void insertCustomers(CustomerRepository customerRepository) {
		
		Customer customer1 = new Customer("홍길동", "010-1234-2345","hong@sk.com");
		customerRepository.save(customer1);
		Customer customer2 = new Customer("임꺽정", "010-2233-1123","im@google.com");
		customerRepository.save(customer2);
		Customer customer3 = new Customer("박지성", "010-5432-5567","park@naver.com");
		customerRepository.save(customer3);
		Customer customer4 = new Customer("전지현", "010-7786-8753","jun@daum.net");
		customerRepository.save(customer4);
		Customer customer5 = new Customer("유재석", "010-4745-4478","yoo@nate.com");
		customerRepository.save(customer5);
		
		
	}

}


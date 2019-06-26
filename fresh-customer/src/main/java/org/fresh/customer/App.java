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
		Customer customer2 = new Customer("임꺽정", "010-1234-2345","im@sk.com");
		customerRepository.save(customer2);
		Customer customer3 = new Customer("이지민", "010-1234-2345","jimin@sk.com");
		customerRepository.save(customer3);
		
		
	}
	
//	public void displayAccounts(AccountRepository accountRepository) {
//		System.out.println("***************************************************************");
//		
//		Iterable<Account> accountList = accountRepository.findAll();
//		for(Account account : accountList) {
//			System.out.println(account.toString());	
//		}
//		
//		System.out.println("***************************************************************");
//	}
//	
	
}


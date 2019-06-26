package org.fresh.point;

import org.fresh.point.domain.model.Point;
import org.fresh.point.domain.repository.PointRepository;
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
	}
	@Bean
	public CommandLineRunner execSampleCode(PointRepository pointRepository) {	
		return (args) -> {
			insertPoint(pointRepository);
					
			//executeExample1(accountRepository);
		};
	}
	
	public void insertPoint(PointRepository pointRepository) {
		
		Point point1 = new Point(1, 10000);
		pointRepository.save(point1);
		Point point2 = new Point(2, 10000);
		pointRepository.save(point2);
		Point point3 = new Point(3, 10000);
		pointRepository.save(point3);
		Point point4 = new Point(4, 10000);
		pointRepository.save(point4);
		Point point5 = new Point(5, 10000);
		pointRepository.save(point5);
		
		
		
	}
}

package org.fresh.video;


import org.fresh.video.domain.model.Video;
import org.fresh.video.domain.repository.VideoRepository;
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
	public CommandLineRunner execSamples(VideoRepository videoRepository) {
		return (args) -> {
			Video video1 = new Video("기생충", "폐 끼치고 싶진 않았어요.");
			Video video2 = new Video("알라딘", "머나먼 사막 속 신비의 아그라바 왕국의 시대");
			Video video3 = new Video("롱 리브 더 킹: 목포 영웅", "거대 조직의 보스로 거침없이 살고 있는 '장세출'");
			
			videoRepository.save(video1);
			videoRepository.save(video2);
			videoRepository.save(video3);
		};
	}
}

package com.example.cms;

import com.example.cms.model.Channel;
import com.example.cms.repository.ChannelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ChannelRepository channelRepository) {
		return args -> {
			channelRepository.save(new Channel(1L, "chat1", null));
			channelRepository.save(new Channel(2L, "chat2", null));
			channelRepository.save(new Channel(3L, "chat3", null));

		};

	}

}

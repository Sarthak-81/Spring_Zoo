package com.sarthak.zoo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sarthak.zoo.mapper.AnimalMapper;
import com.sarthak.zoo.mapper.ZooMapper;

@Configuration
public class MapperConfig {

	
	@Bean
	AnimalMapper animalMapper()
	{
		return AnimalMapper.INSTANCE;
	}
	
	@Bean
	ZooMapper zooMapper()
	{
		return ZooMapper.INSTANCE;
	}
}

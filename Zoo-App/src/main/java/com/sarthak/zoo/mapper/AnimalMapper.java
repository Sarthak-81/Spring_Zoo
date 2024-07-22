package com.sarthak.zoo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.sarthak.zoo.dto.AnimalDTO;
import com.sarthak.zoo.entity.Animal;

@Mapper
public interface AnimalMapper {

	AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);
	
	AnimalDTO animalToAnimalDTO(Animal animal);
	
	@Mapping(target = "arrival_Date", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "zoo_id", ignore = true)
	Animal AnimalDTOToAnimal(AnimalDTO animalDTO);
	
}

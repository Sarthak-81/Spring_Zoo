package com.sarthak.zoo.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.sarthak.zoo.dto.AnimalDTO;
import com.sarthak.zoo.entity.Animal;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

	AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);
	
	@Mapping(source = "zoo.id", target = "zooId")
	AnimalDTO animalToAnimalDTO(Animal animal);
	
	@InheritInverseConfiguration
	@Mapping(target = "zoo_id", ignore = true)
	Animal AnimalDTOToAnimal(AnimalDTO animalDTO);
	
}

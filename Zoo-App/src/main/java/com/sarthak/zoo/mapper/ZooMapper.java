package com.sarthak.zoo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.sarthak.zoo.dto.ZooDTO;
import com.sarthak.zoo.entity.Zoo;

@Mapper(componentModel = "spring")
public interface ZooMapper 
{
	ZooMapper INSTANCE = Mappers.getMapper(ZooMapper.class);	
	
	// Maps a Zoo Entity to ZooDTO
	ZooDTO zooToZooDTO(Zoo zoo);
	
	// Maps a ZooDTO to Zoo entity
	@Mapping(target="id", ignore=true)
	Zoo ZooDTOToZoo(ZooDTO zooDTO);
	
	
	@Mapping(target = "id", ignore = true)
	void updateZoo(ZooDTO zooDTO, @MappingTarget Zoo zoo);
	
}
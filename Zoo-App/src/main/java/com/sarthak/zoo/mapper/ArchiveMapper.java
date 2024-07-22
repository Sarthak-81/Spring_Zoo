package com.sarthak.zoo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.sarthak.zoo.dto.ArchiveDTO;
import com.sarthak.zoo.entity.Archive;

@Mapper(componentModel = "spring")	
public interface ArchiveMapper 
{

	ArchiveMapper INSTANCE = Mappers.getMapper(ArchiveMapper.class);
	
	ArchiveDTO archiveToArchiveDTO(Archive archive);
	@Mapping(target="id", ignore=true)
	@Mapping(target="entity_id", ignore=true)
	Archive ArchiveDTOToArchive(ArchiveDTO archiveDTO);
	
}

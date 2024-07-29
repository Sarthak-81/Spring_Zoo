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
	
	@Mapping(target = "animal_id", source = "animalId")
	@Mapping(target = "zoo_id", source = "zooId")
	@Mapping(target = "archive_Date", ignore = true)
    Archive ArchiveDTOToArchive(ArchiveDTO archiveDTO);
	
    @Mapping(target = "animalId", source = "animal_id")
    @Mapping(target = "zooId", source = "zoo_id")
    ArchiveDTO archiveToArchiveDTO(Archive archive);
    
    }
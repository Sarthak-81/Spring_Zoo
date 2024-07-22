package com.sarthak.zoo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.zoo.dto.ArchiveDTO;
import com.sarthak.zoo.entity.Archive;
import com.sarthak.zoo.mapper.ArchiveMapper;
import com.sarthak.zoo.repository.ArchiveRepository;

@Service
public class ArchiveService 
{

	@Autowired
	private ArchiveRepository archiveRepo;

	@Autowired
	private ArchiveMapper archiveMapper;
	
	public ArchiveDTO saveArchive(ArchiveDTO archiveDTO)
	{
		Archive archive = archiveMapper.ArchiveDTOToArchive(archiveDTO);
		archive.setArchive_Date(LocalDate.now());
		Archive savedArchive = archiveRepo.save(archive);
		
		System.out.println(savedArchive.getName());
        System.out.println(savedArchive.getReason());
        System.out.println(savedArchive.getEntity_type());
        System.out.println(savedArchive.getArchive_Date());
        
		return archiveMapper.archiveToArchiveDTO(savedArchive);
	}
}

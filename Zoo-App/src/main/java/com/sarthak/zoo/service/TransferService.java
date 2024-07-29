package com.sarthak.zoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sarthak.zoo.dto.TransferDTO;
import com.sarthak.zoo.entity.Animal;
import com.sarthak.zoo.entity.Transfer;
import com.sarthak.zoo.entity.Zoo;
import com.sarthak.zoo.mapper.TransferMapper;
import com.sarthak.zoo.repository.AnimalRepository;
import com.sarthak.zoo.repository.TransferRepository;
import com.sarthak.zoo.repository.ZooRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class TransferService 
{

	@Autowired
	private TransferRepository transferRepo;
	
	@Autowired
	private TransferMapper transferMapper;
	
	@Autowired
	private AnimalRepository animalRepo;
	
	@Autowired
	private ZooRepository zooRepo;
	
	@Transactional
	public TransferDTO saveHistory(Long id, TransferDTO transferDTO)
	{
		transferDTO.setAnimalId(id);
		
		Animal animal = animalRepo.findById(id).orElseThrow(() -> new EntityNotFoundException ("Animal Not Found"));
		
		if(animal.getZoo() != null && animal.getZoo().getName().equals(transferDTO.getToZooName()))
		{
			throw new IllegalArgumentException("Animal is present in the same zoo");
		}
		Transfer transfer = transferMapper.TransferDTOToTransfer(transferDTO);
		transfer.setName(animal.getName());
		transfer.setAnimal_id(id);
		transfer.setTransfer_Date(transferDTO.getTransferDate());
		
		if(animal.getZoo()!=null)
		{
			transfer.setFrom_zoo_id(animal.getZoo().getId());
		}
		
		Zoo toZoo = zooRepo.findByName(transferDTO.getToZooName())
				.orElseThrow(() -> new EntityNotFoundException("Destination Zoo " + transferDTO.getToZooName() + " Not found"));
		transfer.setTo_zoo_id(toZoo.getId());
		
		Transfer savedTransfer = transferRepo.save(transfer);
		
		animal.setZoo(toZoo);
		animalRepo.save(animal);
		
		return transferMapper.transferToTransferDTO(savedTransfer);
	}
}

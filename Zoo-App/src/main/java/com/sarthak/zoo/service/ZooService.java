package com.sarthak.zoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sarthak.zoo.dto.ZooDTO;
import com.sarthak.zoo.entity.Zoo;
import com.sarthak.zoo.mapper.ZooMapper;
import com.sarthak.zoo.repository.ZooRepository;

import jakarta.transaction.Transactional;

@Service
public class ZooService {

	@Autowired
	private ZooRepository zooRepo;
	
	@Autowired
	private ZooMapper zooMapper;
	
	public List<Zoo> getAllZoo()
	{
		return zooRepo.findAll();
	}
	
	public ZooDTO saveZoo(ZooDTO zooDTO)
	{
		Zoo zoo = zooMapper.ZooDTOToZoo(zooDTO);
		Zoo savedZoo = zooRepo.save(zoo);
		System.out.println(savedZoo.getName());
        System.out.println(savedZoo.getLocation());
        System.out.println(savedZoo.getPhone_no());
        System.out.println(savedZoo.getDescription());
		return zooMapper.zooToZooDTO(savedZoo);
	}
	
	// @Transactional annotation, it indicates that the particular method should be executed within the context of that transaction. If the transaction becomes 
	// successful then the changes made to the database are committed, if any transaction fails, all the changes made to that particular transaction can be rollback 
	// and it will ensure that the database remains in a consistent state.
	@Transactional
	public ZooDTO updateZoo(Long id, ZooDTO zooDTO)
	{
		Zoo zoo = zooRepo.findById(id).orElseThrow(() -> new RuntimeException("Zoo Not Found"));	
		zooMapper.updateZoo(zooDTO, zoo);
		Zoo updatedZoo = zooRepo.save(zoo);
		return zooMapper.zooToZooDTO(updatedZoo);
	}
// 
	public void deleteZoo(Long id)
	{
		zooRepo.deleteById(id);
		System.out.println("Zoo Deleted" + id);
	}
}
	


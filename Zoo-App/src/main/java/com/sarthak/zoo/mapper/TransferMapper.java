package com.sarthak.zoo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.sarthak.zoo.dto.TransferDTO;
import com.sarthak.zoo.entity.Transfer;

@Mapper
public interface TransferMapper {

	TransferMapper INSTANCE = Mappers.getMapper(TransferMapper.class);
	
	@Mapping(target="from_Zoo", ignore=true)
	@Mapping(target="to_Zoo", ignore=true)
	TransferDTO transferToTransferDTO(Transfer transfer);
	
	Transfer TransferDTOToTransfer(TransferDTO transferDTO);
	
	
}

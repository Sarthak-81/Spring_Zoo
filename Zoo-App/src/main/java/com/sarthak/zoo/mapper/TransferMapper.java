package com.sarthak.zoo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sarthak.zoo.dto.TransferDTO;
import com.sarthak.zoo.entity.Transfer;

@Mapper(componentModel = "spring")
public interface TransferMapper {

	TransferMapper INSTANCE = Mappers.getMapper(TransferMapper.class);
	
	TransferDTO transferToTransferDTO(Transfer transfer);
	
	Transfer TransferDTOToTransfer(TransferDTO transferDTO);
	
	
}

package com.wyn.mapper;

import org.mapstruct.Mapper;

import com.wyn.dto.ChildDTO;
import com.wyn.entity.Child;

@Mapper(config=ParentMappingConfig.class,componentModel = "spring")
public interface ChilderMapper {

	ChildDTO entity2DTO(Child child);
	Child dto2Entity(ChildDTO childDto);
}

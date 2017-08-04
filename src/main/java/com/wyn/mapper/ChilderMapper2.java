package com.wyn.mapper;

import org.mapstruct.Mapper;

import com.wyn.dto.ChildDTO2;
import com.wyn.entity.Child2;

@Mapper(config=ParentMappingConfig.class,componentModel = "spring")
public interface ChilderMapper2 {

	ChildDTO2 entity2DTO(Child2 child);
	Child2 dto2Entity(ChildDTO2 childDto);
}

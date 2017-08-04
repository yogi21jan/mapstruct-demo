package com.wyn.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingInheritanceStrategy;

import com.wyn.dto.ParentDTO;
import com.wyn.entity.Parent;

@MapperConfig(mappingInheritanceStrategy=MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public interface ParentMappingConfig extends BaseConfig{
	
	ParentDTO entity2DTO(Parent parent);
	Parent dto2Entity(ParentDTO parentDTO);

}

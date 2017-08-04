package com.wyn.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingInheritanceStrategy;

import com.wyn.dto.CommonDTO;
import com.wyn.entity.Common;

@MapperConfig(mappingInheritanceStrategy=MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public interface BaseConfig {

	CommonDTO entity2DTO(Common command);
	Common dto2Entity(CommonDTO event);
}

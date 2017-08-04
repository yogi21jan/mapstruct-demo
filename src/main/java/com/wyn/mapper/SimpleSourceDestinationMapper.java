package com.wyn.mapper;

import org.mapstruct.Mapper;

import com.wyn.dto.SimpleSource;
import com.wyn.entity.SimpleDestination;

@Mapper(componentModel = "spring")
public interface SimpleSourceDestinationMapper {

    SimpleDestination sourceToDestination(SimpleSource source);

    SimpleSource destinationToSource(SimpleDestination destination);

}

package com.wyn.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wyn.dto.ChildDTO;
import com.wyn.dto.ChildDTO2;
import com.wyn.dto.CommonDTO;
import com.wyn.entity.Child;
import com.wyn.entity.Child2;
import com.wyn.mapper.ChilderMapper;
import com.wyn.mapper.ChilderMapper2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChilderMapperTest {
	
	ChilderMapper childerMapper = Mappers.getMapper(ChilderMapper.class);
	ChilderMapper2 childerMapper2 = Mappers.getMapper(ChilderMapper2.class);

	@Test
	public void testEntity2DTO() {
		
		CommonDTO commonDTO = new CommonDTO();
		commonDTO.setNotificationTitle("NotificationTitle");
		commonDTO.setCommentForCentralManager("CommentForCentralManager");
		commonDTO.setCommentForEuropeanCommission("CommentForEuropeanCommission");
		
		ChildDTO childDTO = new ChildDTO();
		childDTO.setChildName("ChildName");
		childDTO.setParentName("parentName");
		childDTO.setCommonProperty(commonDTO);
		
		ChildDTO2 childDTO2 = new ChildDTO2();
		childDTO2.setChildName("ChildName2");
		childDTO2.setExtraName("ExtraName");
		childDTO2.setParentName("parentName");
		childDTO2.setCommonProperty(commonDTO);
		
		Child child = childerMapper.dto2Entity(childDTO);
		assertEquals(child.getParentName(), childDTO.getParentName());
		assertEquals(child.getCommonProperty().getNotificationTitle(), childDTO.getCommonProperty().getNotificationTitle());
		log.info("Name: "+child.getParentName());
		log.info("toString: "+child.toString());
		
		Child2 child2 = childerMapper2.dto2Entity(childDTO2);
		assertEquals(child2.getParentName(), childDTO2.getParentName());
		assertEquals(child2.getCommonProperty().getNotificationTitle(), childDTO2.getCommonProperty().getNotificationTitle());
		log.info("Name: "+child2.getParentName());
		log.info("toString: "+child2.toString());
		
	}
}

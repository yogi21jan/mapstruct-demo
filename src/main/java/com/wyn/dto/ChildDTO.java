package com.wyn.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class ChildDTO extends ParentDTO{
	
	private String childName;
	
}

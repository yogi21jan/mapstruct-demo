package com.wyn.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class Parent extends GrandParent{
	
	private String parentName;
	private Common commonProperty;
	
}

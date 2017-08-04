package com.wyn.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class Child2 extends Parent{
	
	private String childName;
	private String extraName;
	
}

package com.wyn.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Employee {

    private int id;
    private String name;
    private Division division;
    private Department department;
    private Address address;
    private Date startDt;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address{
    	private String streetName;
    	private String houseNumber;
    	private String city;
    	private String zipCode;
    }


}

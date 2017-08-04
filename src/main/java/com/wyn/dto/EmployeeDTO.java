package com.wyn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class EmployeeDTO {

    private int employeeId;
    private String employeeName;
    private DivisionDTO division;
    private DepartmentDTO department;
    private AddressDTO address;
    private String employeeStartDt;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddressDTO{
    	private String streetName;
    	private String houseNumber;
    	private String city;
    	private String zipCode;
    }
}

package com.wyn.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.wyn.dto.DepartmentDTO;
import com.wyn.dto.DivisionDTO;
import com.wyn.dto.EmployeeDTO;
import com.wyn.dto.EmployeeDTO.AddressDTO;
import com.wyn.entity.Department;
import com.wyn.entity.Division;
import com.wyn.entity.Employee;
import com.wyn.entity.Employee.Address;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mappings({ @Mapping(target = "employeeId", source = "entity.id"), 
    			@Mapping(target = "employeeName", source = "entity.name"), 
    			@Mapping(target = "employeeStartDt", source = "entity.startDt", dateFormat = "dd-MM-yyyy HH:mm:ss") })
    EmployeeDTO toDTO(Employee entity);

    @Mappings({ @Mapping(target = "id", source = "dto.employeeId"), 
    			@Mapping(target = "name", source = "dto.employeeName"), 
    			@Mapping(target = "startDt", source = "dto.employeeStartDt", dateFormat = "dd-MM-yyyy HH:mm:ss") })
    Employee fromDTO(EmployeeDTO dto);

    DivisionDTO toDTO(Division entity);
    Division fromDTO(DivisionDTO dto);
    
    DepartmentDTO toDTO(Department entity);
    Department fromDTO(DepartmentDTO dto);
    
    AddressDTO toDTO(Address entity);
    Address fromDTO(AddressDTO dto);

    List<Employee> toDTOList(List<EmployeeDTO> list);
    List<EmployeeDTO> fromDTOList(List<Employee> list);

}

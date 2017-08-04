package com.wyn.mapper;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wyn.dto.DepartmentDTO;
import com.wyn.dto.DivisionDTO;
import com.wyn.dto.EmployeeDTO;
import com.wyn.entity.Division;
import com.wyn.entity.Employee;
import com.wyn.entity.Employee.Address;
import com.wyn.mapper.EmployeeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMapperUnitTest {

    EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);

    private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

    @Test
    public void givenEmployeeDTOwithDiffNametoEmployee_whenMaps_thenCorrect() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeId(1);
        dto.setEmployeeName("John");

        Employee entity = mapper.fromDTO(dto);

        assertEquals(dto.getEmployeeId(), entity.getId());
        assertEquals(dto.getEmployeeName(), entity.getName());
    }

    @Test
    public void givenEmployeewithDiffNametoEmployeeDTO_whenMaps_thenCorrect() {
        Employee entity = new Employee();
        entity.setId(1);
        entity.setName("John");

        EmployeeDTO dto = mapper.toDTO(entity);

        assertEquals(dto.getEmployeeId(), entity.getId());
        assertEquals(dto.getEmployeeName(), entity.getName());
    }

    @Test
    public void givenEmployeeDTOwithNestedMappingToEmployee_whenMaps_thenCorrect() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setDivision(new DivisionDTO(1, "Division1"));
        dto.setDepartment(new DepartmentDTO(1,"Sales"));

        Employee entity = mapper.fromDTO(dto);

        assertEquals(dto.getDivision().getId(), entity.getDivision().getId());
        assertEquals(dto.getDivision().getName(), entity.getDivision().getName());
        
        assertEquals(dto.getDepartment().getDepartmentId(), entity.getDepartment().getDepartmentId());
        assertEquals(dto.getDepartment().getDepartmentName(), entity.getDepartment().getDepartmentName());
    }

    @Test
    public void givenEmployeeWithNestedMappingToEmployeeDTO_whenMaps_thenCorrect() {
        Employee entity = new Employee();
        entity.setDivision(new Division(1, "Division1"));

        EmployeeDTO dto = mapper.toDTO(entity);

        assertEquals(dto.getDivision().getId(), entity.getDivision().getId());
        assertEquals(dto.getDivision().getName(), entity.getDivision().getName());
    }
    
    @Test
    public void givenEmployeeWithNestedStaticMappingToEmployeeDTO_whenMaps_thenCorrect() {
        Employee entity = new Employee();
        entity.setDivision(new Division(1, "Division1"));
        entity.setAddress(new Address("Link Road", "25", "Pune", "411014"));

        EmployeeDTO dto = mapper.toDTO(entity);

        assertEquals(dto.getDivision().getId(), entity.getDivision().getId());
        assertEquals(dto.getDivision().getName(), entity.getDivision().getName());
        assertEquals(dto.getAddress().getStreetName(), entity.getAddress().getStreetName());
    }

    @Test
    public void givenEmployeeListToEmployeeDTOList_whenMaps_thenCorrect() {
        List<Employee> employeeList = new ArrayList<>();
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("EmpName");
        emp.setDivision(new Division(1, "Division1"));
        employeeList.add(emp);

        List<EmployeeDTO> employeeDtoList = mapper.fromDTOList(employeeList);
        EmployeeDTO employeeDTO = employeeDtoList.get(0);
        assertEquals(employeeDTO.getEmployeeId(), emp.getId());
        assertEquals(employeeDTO.getEmployeeName(), emp.getName());
        assertEquals(employeeDTO.getDivision().getId(), emp.getDivision().getId());
        assertEquals(employeeDTO.getDivision().getName(), emp.getDivision().getName());
    }

    @Test
    public void givenEmployeeDTOListToEmployeeList_whenMaps_thenCorrect() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        EmployeeDTO empDTO = new EmployeeDTO();
        empDTO.setEmployeeId(1);
        empDTO.setEmployeeName("EmpName");
        empDTO.setDivision(new DivisionDTO(1, "Division1"));
        employeeDTOList.add(empDTO);

        List<Employee> employeeList = mapper.toDTOList(employeeDTOList);
        Employee employee = employeeList.get(0);
        assertEquals(employee.getId(), empDTO.getEmployeeId());
        assertEquals(employee.getName(), empDTO.getEmployeeName());
        assertEquals(employee.getDivision().getId(), empDTO.getDivision().getId());
        assertEquals(employee.getDivision().getName(), empDTO.getDivision().getName());
    }

    @Test
    public void givenEmployeeWithStartDateMappingToEmployeeDTO_whenMaps_thenCorrect() throws ParseException {
        Employee entity = new Employee();
        entity.setStartDt(new Date());

        EmployeeDTO dto = mapper.toDTO(entity);
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        assertEquals(format.parse(dto.getEmployeeStartDt()).toString(), entity.getStartDt().toString());
    }

    @Test
    public void givenEmployeeDTOWithStartDateMappingToEmployee_whenMaps_thenCorrect() throws ParseException {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeStartDt("01-04-2016 01:00:00");

        Employee entity = mapper.fromDTO(dto);
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        assertEquals(format.parse(dto.getEmployeeStartDt()).toString(), entity.getStartDt().toString());
    }
}

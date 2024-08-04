package com.leadsquared.employeemanagement.mapper;

import com.leadsquared.employeemanagement.dto.employee.EmployeeCreateDTO;
import com.leadsquared.employeemanagement.dto.employee.EmployeeDTO;
import com.leadsquared.employeemanagement.dto.employee.EmployeeUpdateDTO;
import com.leadsquared.employeemanagement.jooq.tables.pojos.Employee;
import com.leadsquared.employeemanagement.jooq.tables.pojos.Temp;
import com.leadsquared.employeemanagement.jooq.tables.records.EmployeeRecord;
import com.leadsquared.employeemanagement.jooq.tables.records.TempRecord;
import com.leadsquared.employeemanagement.temp.TempCreateDTO;
import com.leadsquared.employeemanagement.temp.TempDTO;
import com.leadsquared.employeemanagement.temp.TempUpdateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

	Employee employeeCreateDtoToemployeePojo(EmployeeCreateDTO dto);

	Employee employeeUpdateDtoToemployeePojo(EmployeeUpdateDTO dto);

	EmployeeDTO employeePojoToemployeeDTO(Employee employeePojo);

	EmployeeRecord employeePojoToemployeeRecord(Employee employeePojo);
}

package com.leadsquared.employeemanagement.mapper;

import com.leadsquared.employeemanagement.dto.department.DepartmentCreateDTO;
import com.leadsquared.employeemanagement.dto.department.DepartmentDTO;
import com.leadsquared.employeemanagement.dto.department.DepartmentUpdateDTO;
import com.leadsquared.employeemanagement.jooq.tables.pojos.Department;
import com.leadsquared.employeemanagement.jooq.tables.records.DepartmentRecord;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

	Department departmentCreateDtoTodepartmentPojo(DepartmentCreateDTO dto);

	Department departmentUpdateDtoTodepartmentPojo(DepartmentUpdateDTO dto);

	DepartmentDTO departmentPojoTodepartmentDTO(Department departmentPojo);

	DepartmentRecord departmentPojoTodepartmentRecord(Department departmentPojo);
}

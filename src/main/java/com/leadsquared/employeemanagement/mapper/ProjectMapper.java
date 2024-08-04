package com.leadsquared.employeemanagement.mapper;

import com.leadsquared.employeemanagement.dto.project.ProjectCreateDTO;
import com.leadsquared.employeemanagement.dto.project.ProjectDTO;
import com.leadsquared.employeemanagement.dto.project.ProjectUpdateDTO;
import com.leadsquared.employeemanagement.jooq.tables.pojos.Project;
import com.leadsquared.employeemanagement.jooq.tables.pojos.Temp;
import com.leadsquared.employeemanagement.jooq.tables.records.ProjectRecord;
import com.leadsquared.employeemanagement.jooq.tables.records.TempRecord;
import com.leadsquared.employeemanagement.temp.TempCreateDTO;
import com.leadsquared.employeemanagement.temp.TempDTO;
import com.leadsquared.employeemanagement.temp.TempUpdateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

	Project projectCreateDtoToprojectPojo(ProjectCreateDTO dto);

	Project projectUpdateDtoToprojectPojo(ProjectUpdateDTO dto);

	ProjectDTO projectPojoToprojectDTO(Project projectPojo);

	ProjectRecord projectPojoToprojectRecord(Project projectPojo);
}

package com.leadsquared.employeemanagement.temp;

import com.leadsquared.employeemanagement.jooq.tables.pojos.Temp;
import com.leadsquared.employeemanagement.jooq.tables.records.TempRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TempMapper {

	Temp tempCreateDtoToTempPojo(TempCreateDTO dto);

	Temp tempUpdateDtoToTempPojo(TempUpdateDTO dto);

	TempDTO tempPojoToTempDTO(Temp tempPojo);

	TempRecord tempPojoToTempRecord(Temp tempPojo);
}

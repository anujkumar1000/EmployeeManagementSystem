package com.leadsquared.employeemanagement.dto.project;

import java.time.LocalDateTime;

public record ProjectCreateDTO( Long projectId,String projectName, String email, String createdby, LocalDateTime createdOn) {}

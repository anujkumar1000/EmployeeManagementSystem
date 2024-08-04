CREATE TABLE `phone`
(
  `phone_id`   bigint  NOT NULL AUTO_INCREMENT,
  `phone_number` bigint NOT NULL,
  `phone_type` enum('Mobile_Phone',
                    	'Landline',
                    	'Feature_Phone',
                    	'Virtual_Phone',
                    	'Satellite_Phone') NOT NULL,
  `is_primary` boolean NOT NULL,
  `department_id`     bigint,
  `project_id`     	bigint,
  `employee_id`  bigint,
  PRIMARY KEY (`phone_id`),
  UNIQUE KEY (`phone_id`)
--  FOREIGN KEY (`department_id`) REFERENCES department(`department_id`),
--  FOREIGN KEY (`project_id`) REFERENCES project(`project_id`),
--  FOREIGN KEY (`employee_id`) REFERENCES employee(`employee_id`)
)
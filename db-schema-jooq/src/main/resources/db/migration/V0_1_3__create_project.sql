CREATE TABLE `project`
(
  `createdBy`    varchar(10)  DEFAULT NULL,
  `created_on`  datetime DEFAULT CURRENT_TIMESTAMP,
  `modifiedBy`     varchar(10)  DEFAULT NULL,
  `modified_on` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `project_name` varchar(255)  NOT NULL,
  `email`          varchar(255)  NOT NULL,
  `project_id`   bigint  NOT NULL AUTO_INCREMENT,
  `department_id`     bigint,
  `employee_id`     	bigint,
  `phone_id`  bigint,
  PRIMARY KEY (`project_id`),
  UNIQUE KEY (`project_id`)
--  FOREIGN KEY (`department_id`) REFERENCES department(`department_id`),
--  FOREIGN KEY (`employee_id`) REFERENCES employee(`employee_id`),
--  FOREIGN KEY (`phone_id`) REFERENCES phone(`phone_id`)
);
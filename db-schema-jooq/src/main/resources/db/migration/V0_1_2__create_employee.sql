CREATE TABLE `employee`
(
  `createdBy`    varchar(10)  DEFAULT NULL,
  `created_on`  datetime DEFAULT CURRENT_TIMESTAMP,
  `modifiedBy`     varchar(10)  DEFAULT NULL,
  `modified_on` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `first_name` varchar(50)  NOT NULL,
  `middle_name` varchar(50)  NOT NULL,
  `last_name` varchar(50)  NOT NULL,
  `email`          varchar(255)  NOT NULL,
  `employee_id`   bigint  NOT NULL AUTO_INCREMENT,
  `department_id`     bigint,
  `project_id`     	bigint,
  `phone_id`  bigint,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY (`employee_id`)
--  FOREIGN KEY (`department_id`) REFERENCES department(`department_id`),
--  FOREIGN KEY (`project_id`) REFERENCES project(`project_id`),
--  FOREIGN KEY (`phone_id`) REFERENCES phone(`phone_id`)
);
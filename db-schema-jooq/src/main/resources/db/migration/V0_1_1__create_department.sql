CREATE TABLE `department`
(
  `createdBy`    varchar(10)  DEFAULT NULL,
  `created_on`  datetime DEFAULT CURRENT_TIMESTAMP,
  `modifiedBy`     varchar(10)  DEFAULT NULL,
  `modified_on` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `department_name` varchar(255)  NOT NULL,
  `email`          varchar(255)  NOT NULL,
  `department_id`   bigint  NOT NULL AUTO_INCREMENT,
  `employee_id`     bigint,
  `project_id`     	bigint,
  `phone_id`  bigint,
  PRIMARY KEY (`department_id`),
  UNIQUE KEY (`department_id`)
--  FOREIGN KEY (`employee_id`) REFERENCES employee(`employee_id`),
--  FOREIGN KEY (`project_id`) REFERENCES project(`project_id`),
--  FOREIGN KEY (`phone_id`) REFERENCES phone(`phone_id`)
);
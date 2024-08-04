CREATE TABLE `temp`
(
	`id`          bigint  NOT NULL AUTO_INCREMENT,
	`code`        varchar(10) NOT NULL,
	`name`        varchar(50) NOT NULL,
	`description` varchar(255),
	`created_on`  datetime DEFAULT CURRENT_TIMESTAMP,
	`created_by`  varchar(10) DEFAULT NULL,
	`modified_on` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`modified_by` varchar(10) DEFAULT NULL,
	PRIMARY KEY (`id`),
	UNIQUE KEY (`code`)
);

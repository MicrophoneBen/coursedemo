/* IF NOT EXISTS */
 CREATE TABLE IF NOT EXISTS SOP_COURSE
(
	COURSE_ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  COURSE_CODE VARCHAR(20) NOT NULL UNIQUE,
  COURSE_NAME VARCHAR(255) NOT NULL,
	COURSE_INST_CODE VARCHAR(20) NOT NULL UNIQUE,
  COURSE_INST_NAME VARCHAR(200) NOT NULL,
  C_START_DTE DATE NOT NULL,
  C_END_DTE DATE NOT NULL,
  C_RESULT VARCHAR(20) NOT NULL,
  C_TIME INT NOT NULL,
	CONSTRAINT PRIMARY KEY(COURSE_ID)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE IF NOT EXISTS CSS_COURSE_ATTD
(
  COURSE_INST_CODE VARCHAR(20) NOT NULL ,
  EMPL_NBR VARCHAR(10) NOT NULL ,
--   COURSE_INST_NAME VARCHAR(200) NOT NULL,
  C_RESULT VARCHAR(20) NOT NULL
 /* CONSTRAINT PRIMARY KEY ( COURSE_INST_CODE, EMPL_NBR)*/
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
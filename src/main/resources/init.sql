CREATE SCHEMA `visits` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE VISIT_AUDIT (
  VISIT_ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  VISIT_DATE TIMESTAMP
);
CREATE SCHEMA IF NOT EXISTS `jawsmith_program` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci; 

CREATE  TABLE IF NOT EXISTS `jawsmith_program`.`patients` (
  `PATIENT_ID` INT NOT NULL AUTO_INCREMENT ,
  `PATIENT_NO` VARCHAR(255)  ,
  `FIRST_NAME` VARCHAR(255) NOT NULL ,
  `MIDDLE_NAME` VARCHAR(255) NULL ,
  `LAST_NAME` VARCHAR(255) NOT NULL ,
  `BIRTHDAY` DATE NOT NULL ,
  `SEX` CHAR NOT NULL ,
  `REL_STATUS` VARCHAR(255) NOT NULL ,
  `ADDRESS` VARCHAR(255) NOT NULL ,
  `MOBILE_NO` VARCHAR(255) NULL ,
  `TEL_NO` VARCHAR(45) NULL ,
  `EMAIL` VARCHAR(255) NULL ,
  `NATIONALITY` VARCHAR(255) NOT NULL ,
  `OCCUPATION` VARCHAR(255) NULL ,
  `RELIGION` VARCHAR(255) NULL ,
  `REFERRED_BY` VARCHAR(255) NULL ,
  `GUARDIAN` VARCHAR(255) NULL ,
  `LAST_VISIT_DATE` DATE NOT NULL ,
  `STATUS` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`PATIENT_ID`) )
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `jawsmith_program`.`table_maintenance` (
  `REF_ID` INT NOT NULL ,
  `CODE_TBL_VALUE` VARCHAR(45) NOT NULL ,
  `DESCRIPTION` VARCHAR(255) NOT NULL ,
  `STATUS` TINYINT(1) NOT NULL ,
  `TABLE_MAINTENANCE_ID` INT NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`TABLE_MAINTENANCE_ID`) )
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `jawsmith_program`.`anxillaries` (
  `ANXILLARIES_ID` INT NOT NULL AUTO_INCREMENT ,
  `LAST_VISIT_DATE` DATE NOT NULL ,
  `BLEEDING_TIME` VARCHAR(255) NULL ,
  `BLOOD_PRESSURE` VARCHAR(255) NULL ,
  `RADIOGRAPHIC_INTERPRETATION` VARCHAR(255) NULL ,
  `CLOTTING_TIME` VARCHAR(255) NULL ,
  `BLOOD_SUGAR` VARCHAR(255) NULL ,
  `patients_PATIENT_ID` INT NOT NULL ,
  PRIMARY KEY (`ANXILLARIES_ID`, `patients_PATIENT_ID`) ,
  INDEX `fk_anxillaries_patients1_idx` (`patients_PATIENT_ID` ASC) ,
  CONSTRAINT `fk_anxillaries_patients1`
    FOREIGN KEY (`patients_PATIENT_ID` )
    REFERENCES `jawsmith_program`.`patients` (`PATIENT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `jawsmith_program`.`clinical_examination` (
  `CLINIC_EXAM_ID` INT NOT NULL AUTO_INCREMENT ,
  `LAST_VISIT_DATE` VARCHAR(45) NOT NULL ,
  `GINGIVAL_COLOR` VARCHAR(45) NULL ,
  `CONSISTENCY_OF_GINGIVAL` VARCHAR(45) NULL ,
  `TOUNGE` VARCHAR(45) NULL ,
  `ORAL_HYGIENE` VARCHAR(45) NULL ,
  `LYMPH_NODES` VARCHAR(45) NULL ,
  `patients_PATIENT_ID` INT NOT NULL ,
  PRIMARY KEY (`CLINIC_EXAM_ID`, `patients_PATIENT_ID`) ,
  INDEX `fk_clinical_examination_patients1_idx` (`patients_PATIENT_ID` ASC) ,
  CONSTRAINT `fk_clinical_examination_patients1`
    FOREIGN KEY (`patients_PATIENT_ID` )
    REFERENCES `jawsmith_program`.`patients` (`PATIENT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `jawsmith_program`.`dental_history` (
  `DENTAL_HIS_ID` INT NOT NULL AUTO_INCREMENT ,
  `LAST_VISIT_DATE` VARCHAR(45) NOT NULL ,
  `FLUORIDE_TREATMENT` TINYINT(1) NOT NULL DEFAULT FALSE ,
  `ORTHODONTIC_TREATMENT` TINYINT(1) NOT NULL DEFAULT FALSE ,
  `PULP_THERAPY` TINYINT(1) NOT NULL DEFAULT FALSE ,
  `TEMPORO_MANDIBULAR_THERAPY` TINYINT(1) NOT NULL DEFAULT FALSE ,
  `PERIODONTAL_THERAPY` TINYINT(1) NOT NULL DEFAULT FALSE ,
  `DENTAL_SURGERY` TINYINT(1) NOT NULL DEFAULT FALSE ,
  `EXTRACTION` TINYINT(1) NOT NULL DEFAULT FALSE ,
  `patients_PATIENT_ID` INT NOT NULL ,
  PRIMARY KEY (`DENTAL_HIS_ID`, `patients_PATIENT_ID`) ,
  INDEX `fk_dental_history_patients1_idx` (`patients_PATIENT_ID` ASC) ,
  CONSTRAINT `fk_dental_history_patients1`
    FOREIGN KEY (`patients_PATIENT_ID` )
    REFERENCES `jawsmith_program`.`patients` (`PATIENT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `jawsmith_program`.`medical_history` (
  `MED_HIS_ID` INT NOT NULL AUTO_INCREMENT ,
  `LAST_VISIT_DATE` DATE NOT NULL ,
  `QUESTION_ID` VARCHAR(45) NULL ,
  `ANSWER` VARCHAR(255) NULL ,
  `patients_PATIENT_ID` INT NOT NULL ,
  PRIMARY KEY (`MED_HIS_ID`, `patients_PATIENT_ID`) ,
  INDEX `fk_medical_history_patients_idx` (`patients_PATIENT_ID` ASC) ,
  CONSTRAINT `fk_medical_history_patients`
    FOREIGN KEY (`patients_PATIENT_ID` )
    REFERENCES `jawsmith_program`.`patients` (`PATIENT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `jawsmith_program`.`occlusion` (
  `OCCLUSION_ID` INT NOT NULL AUTO_INCREMENT ,
  `LAST_VISIT_DATE` DATE NOT NULL ,
  `CLASS_I` VARCHAR(255) NULL ,
  `CLASS_II` VARCHAR(255) NULL ,
  `CLASS_III` VARCHAR(255) NULL ,
  `patients_PATIENT_ID` INT NOT NULL ,
  PRIMARY KEY (`OCCLUSION_ID`, `patients_PATIENT_ID`) ,
  INDEX `fk_occlusion_patients1_idx` (`patients_PATIENT_ID` ASC) ,
  CONSTRAINT `fk_occlusion_patients1`
    FOREIGN KEY (`patients_PATIENT_ID` )
    REFERENCES `jawsmith_program`.`patients` (`PATIENT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `jawsmith_program`.`other_information` (
  `OTHER_INFO_ID` INT NOT NULL AUTO_INCREMENT ,
  `CHIEF_COMPLAINT` VARCHAR(255) NULL ,
  `DIAGNOSIS` VARCHAR(255) NULL ,
  `LAST_VISIT_DATE` DATE NULL ,
  `patients_PATIENT_ID` INT NOT NULL ,
  PRIMARY KEY (`OTHER_INFO_ID`, `patients_PATIENT_ID`) ,
  INDEX `fk_other_information_patients1_idx` (`patients_PATIENT_ID` ASC) ,
  CONSTRAINT `fk_other_information_patients1`
    FOREIGN KEY (`patients_PATIENT_ID` )
    REFERENCES `jawsmith_program`.`patients` (`PATIENT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `jawsmith_program`.`treatment_plan` (
  `TREATMENT_PLAN_ID` INT NOT NULL ,
  `TREATMENT_DATE` DATE NULL ,
  `TREATMENT` VARCHAR(255) NULL ,
  `TREATMENT_FEE` FLOAT NULL ,
  `ALTERNATIVE_TREATMENT` VARCHAR(255) NULL ,
  `ALTERNATIVE_TREATMENT_FEE` FLOAT NULL ,
  `patients_PATIENT_ID` INT NOT NULL ,
  PRIMARY KEY (`TREATMENT_PLAN_ID`, `patients_PATIENT_ID`) ,
  INDEX `fk_treatment_plan_patients1_idx` (`patients_PATIENT_ID` ASC) ,
  CONSTRAINT `fk_treatment_plan_patients1`
    FOREIGN KEY (`patients_PATIENT_ID` )
    REFERENCES `jawsmith_program`.`patients` (`PATIENT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `jawsmith_program`.`treatment_record` (
  `TREATMENT_RECORD_ID` INT NOT NULL ,
  `LAST_VISIT_DATE` DATE NULL ,
  `TOOTH_NO` VARCHAR(45) NULL ,
  `DESCRIPTION` VARCHAR(255) NULL ,
  `PRESCRIPTION` VARCHAR(255) NULL ,
  `DEBIT` FLOAT NULL ,
  `CREDIT_DATE` DATE NULL ,
  `CREDIT_AMT` FLOAT NULL ,
  `patients_PATIENT_ID` INT NOT NULL ,
  PRIMARY KEY (`TREATMENT_RECORD_ID`, `patients_PATIENT_ID`) ,
  INDEX `fk_treatment_record_patients1_idx` (`patients_PATIENT_ID` ASC) ,
  CONSTRAINT `fk_treatment_record_patients1`
    FOREIGN KEY (`patients_PATIENT_ID` )
    REFERENCES `jawsmith_program`.`patients` (`PATIENT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `jawsmith_program`.`users` (
  `USER_ID` INT NOT NULL AUTO_INCREMENT ,
  `USERNAME` VARCHAR(45) NOT NULL ,
  `PASSWORD` VARCHAR(45) NOT NULL ,
  `FIRST_NAME` VARCHAR(255) NOT NULL ,
  `LAST_NAME` VARCHAR(255) NOT NULL ,
  `ACCESS` INT NOT NULL ,
  PRIMARY KEY (`USER_ID`) ,
  UNIQUE INDEX `USERNAME_UNIQUE` (`USERNAME` ASC) )
ENGINE = InnoDB;



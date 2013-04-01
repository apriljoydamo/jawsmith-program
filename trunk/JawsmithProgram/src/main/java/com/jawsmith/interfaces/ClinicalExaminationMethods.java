package com.jawsmith.interfaces;

import java.util.Date;
import java.util.List;

public interface ClinicalExaminationMethods {
	Object findByPatientId(int patientId);
	Object findByPatientIdAndLastVisitDate(int patientId, Date lastVisitDate);
}

package com.jawsmith.interfaces;

import java.util.Date;
import java.util.List;

public interface MedicalHistoryMethods {
	Object findByPatientId(int patientId);
	List findByPatientIdAndLastVisitDate(int patientId, Date lastVisitDate);
}

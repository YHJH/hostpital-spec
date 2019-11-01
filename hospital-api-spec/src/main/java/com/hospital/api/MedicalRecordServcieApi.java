package com.hospital.api;

import com.hospital.model.PatientDto;
import org.springframework.http.ResponseEntity;

/**
 * @author jianhua.shi on 2019/9/7
 * @project hospital-api-spec
 */
public interface MedicalRecordServcieApi {

    /**
     * Save medical record to DB.
     * @param dto
     * @return
     */
    ResponseEntity<PatientDto>  saveMedicalRecord(final PatientDto dto);

    /**
     *
     * @param patientDto
     * @return
     */
    ResponseEntity<PatientDto> getMedicalRecordByPatient(final PatientDto patientDto);
}

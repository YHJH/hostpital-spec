package com.hospital.api;

import com.hospital.model.PatientInformationDto;
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
    ResponseEntity<PatientInformationDto>  saveMedicalRecord(final PatientInformationDto dto);

    /**
     *
     * @param patientInformationDto
     * @return
     */
    ResponseEntity<PatientInformationDto> getMedicalRecordByPatient(final PatientInformationDto patientInformationDto);
}

package com.hospital.api;

import com.hospital.model.PatientDto;
import com.hospital.model.PatientMedicalRecordXrefDto;

import java.util.List;

/**
 * @author jianhua.shi on 2019/9/7
 * @project hospital-api-spec
 */
public interface PatientServiceApi {

    /**
     * Add
     * @param user
     * @return
     */
    PatientDto addPatient(final PatientDto user);

    /**
     * Return the detailed user profile based on the specific query conditions.
     * @param user
     * @return
     */
    PatientDto getPatientProfile(final PatientDto user);

    /**
     *
     * @param doctorUserId
     * @return
     */
    List<PatientDto> listAllPatiensBelongsToThisDoctor(final String doctorUserId);

    /**
     *
     * @param user
     * @return
     */
    List<PatientMedicalRecordXrefDto> listAllMedicalRecordsByUserInfo(final PatientDto user);
}

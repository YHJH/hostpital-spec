package com.hospital.api;

import com.hospital.model.PatientInformationDto;
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
    PatientInformationDto addPatient(final PatientInformationDto user);

    /**
     * Return the detailed user profile based on the specific query conditions.
     * @param user
     * @return
     */
    PatientInformationDto getPatientProfile(final PatientInformationDto user);

    /**
     *
     * @param doctorUserId
     * @return
     */
    List<PatientInformationDto> listAllPatiensBelongsToThisDoctor(final String doctorUserId);

    /**
     *
     * @param user
     * @return
     */
    List<PatientMedicalRecordXrefDto> listAllMedicalRecordsByUserInfo(final PatientInformationDto user);
}

package com.hospital.model;

import lombok.Data;

/**
 * @author jianhua.shi on 2019/9/7
 * @project hospital-api-spec
 */

@Data
public class PatientMedicalRecordXrefDto {

    private String patientId;
    private String medicalRecordId;
    private String medicalRecordType;
}

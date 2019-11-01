package com.hospital.model;

import lombok.Data;

import java.time.ZonedDateTime;

/**
 * @author jianhua.shi on 2019/9/15
 * @project hospital-api-spec
 */
@Data
public class PatientDay5Dto extends PatientDto {
    private String patientId;
    private String e2;
    private String fsh;
    private String lh;
    private String p;
    private String periodDate;
    private String uterusSize;
    private String endometrialSize;
    private ZonedDateTime examinationDate;
}

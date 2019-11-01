package com.hospital.processor;

import com.hospital.model.PatientDto;

/**
 * @author jianhua.shi on 2019/9/21
 * @project hospital-api-spec
 */
public abstract class AbstractHandler {
    abstract public String handle(PatientDto dto);
}

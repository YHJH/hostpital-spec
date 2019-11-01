package com.hospital.annotations;

import java.lang.annotation.*;

/**
 * @author jianhua.shi on 2019/9/15
 * @project hospital-api-spec
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MedicalRecordType {

    String value() default "day1";
}

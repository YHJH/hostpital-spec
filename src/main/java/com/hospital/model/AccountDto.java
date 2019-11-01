package com.hospital.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author jianhua.shi on 2019/9/15
 * @project hospital-api-spec
 */
@Data
@ToString(exclude = {"password","repeatPassword"})
public class AccountDto {

    private String accountId;
    private String password;
    private String securedQuestion;
    private String securedAnswer;
    private String userName;
    private String cellPhone;
    private String email;
    private String repeatPassword;
    private String job;
}

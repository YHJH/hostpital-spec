package com.hospital.api;

import com.hospital.model.AccountDto;

/**
 * @author jianhua.shi on 2019/9/7
 * @project hospital-api-spec
 */
public interface AuthenticateApi {

    /**
     *
     * @param accountId
     * @param password
     * @return
     */
    AccountDto login(String accountId,String password);

    /**
     *
     * @param dto
     * @return
     */
    AccountDto register(final AccountDto dto);

}

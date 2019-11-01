package com.hospital.dao;

import com.hospital.model.AccountDto;

/**
 * @author jianhua.shi on 2019/9/15
 * @project hospital-api-spec
 */
public interface AccountDao {

    AccountDto login(String userName,String password);

    AccountDto register(final AccountDto accountDto);
}

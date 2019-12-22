package com.hospital.controller;

import com.hospital.api.AuthenticateApi;
import com.hospital.model.AccountDto;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jianhua.shi on 2019/10/1
 * @project hospital-api-spec
 */
@Slf4j
@Controller
public class AuthenticateController {

    @Autowired
    private AuthenticateApi api;

    @RequestMapping(value = "/login",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String login(HttpServletRequest request, ModelMap model) {

        String accountId = request.getParameter("accountId");
        String password = request.getParameter("password");

        val accountDto = api.login(accountId, password);

        if (accountDto == null) {
            model.put("errorMsg", "Account doesn't exists.");
            return "login";
        }

        model.put("account", accountDto);

        val session = request.getSession();
        session.setAttribute("doctor",accountDto);

        return "medical-home";
    }


    @GetMapping("/logining")
    public String goLogin() {

        return "login";
    }


    @GetMapping("/registering")
    public String registering() {

        return "register";
    }

    @RequestMapping(value = "/register",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String register(AccountDto accountDto) {

        log.info("Register Account information : {}",accountDto);

        api.register(accountDto);


        return "login";
    }
}

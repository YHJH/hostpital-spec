package com.hospital.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jianhua.shi on 2019/9/7
 * @project hospital-api-spec
 */
@Controller
@CrossOrigin("*")
@Slf4j
@RequestMapping()
public class MedicalRecordController {


    @GetMapping("/medical-records/add")
    public String goLogin() {

        return "day1_step0";
    }
}

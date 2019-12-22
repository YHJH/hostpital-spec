package com.hospital.controller;

import com.hospital.model.AccountDto;
import com.hospital.model.PatientInformationDto;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class Day1Controller {
    @RequestMapping(value = "/medical-records/day1/step2",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String step2( HttpServletRequest request){


         val session  = request.getSession();

         val doctor = (AccountDto)session.getAttribute("doctor");

         log.info("current login doctor is: {}",doctor);

         session.setAttribute("baseInfo",this.build(request,doctor));

        return "day1_step2";
    }

    @RequestMapping(value = "/medical-records/day1/step3",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String step3( HttpServletRequest request){


        val session  = request.getSession();

        val doctor = (AccountDto)session.getAttribute("doctor");

        log.info("current login doctor is: {}",doctor);

        session.setAttribute("baseInfo",this.build(request,doctor));

        return "day1_step3";
    }

    @RequestMapping(value = "/medical-records/day1/step4",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String step4( HttpServletRequest request){


        val session  = request.getSession();

        val doctor = (AccountDto)session.getAttribute("doctor");

        log.info("current login doctor is: {}",doctor);

        session.setAttribute("baseInfo",this.build(request,doctor));

        return "day1_step4";
    }


    @RequestMapping(value = "/medical-records/day1/step5",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String step5( HttpServletRequest request){


        val session  = request.getSession();

        val doctor = (AccountDto)session.getAttribute("doctor");

        log.info("current login doctor is: {}",doctor);

        session.setAttribute("baseInfo",this.build(request,doctor));

        return "day1_step5";
    }

    private PatientInformationDto build(final HttpServletRequest request, final AccountDto doctor){
        val dto = new PatientInformationDto();
        dto.setAcademicDegree(request.getParameter("academicDegree"));
        dto.setAge(request.getParameter("age"));
        dto.setBelongsToDoctor(doctor.getAccountId());
        dto.setCertificateId(request.getParameter("certificateId"));
        dto.setCertificateType(request.getParameter("certificateType"));
        dto.setCurrentStatus("day1");
        dto.setGender(request.getParameter("gender"));
        dto.setPhoneNo(request.getParameter("phoneNo"));
        dto.setNationality(request.getParameter("nationality"));
        dto.setOccupation(request.getParameter("occupation"));

        log.info("patient base info:{}",dto);

        return dto;
    }
}

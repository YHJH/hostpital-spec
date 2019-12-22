package com.hospital.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class PatientInformationDto {

     private String userId;
     private String accountId;
     private String userName;
     private String phoneNo;
     private String email;
     private String certificateType;
     private String certificateId;
     private String gender;
     private String occupation;
     private String age;
     private String nationality;
     private String academicDegree;
     private String belongsToDoctor;
     private String currentStatus;
     private ZonedDateTime createdTime;

}

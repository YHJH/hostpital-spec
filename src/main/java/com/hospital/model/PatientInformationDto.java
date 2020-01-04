package com.hospital.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class PatientInformationDto {

     private String name;
     private String occupation;
     private String academicDegree;
     private String nationality;
     private String certificateId;
     private String address;
     private String chiefComplaint;
     private String phoneNo;
     private String belongsToDoctor;
     private ZonedDateTime createdTime;

}

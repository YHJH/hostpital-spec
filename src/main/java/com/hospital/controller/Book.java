package com.hospital.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String userName;

    private String phoneNo;

    private String gender;

    private String nextCheckDate;

    private String checkResult;

    private String address;
}

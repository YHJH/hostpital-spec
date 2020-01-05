package com.hospital.util;


import com.hospital.model.PatientDay1Step1Information;
import com.hospital.model.PatientDay1Step2Information;
import com.hospital.model.PatientDay1Step3Information;
import com.hospital.model.PatientInformationDto;

import java.lang.reflect.Field;

public class SQLGenerator {

    private static final  String CREATE_TABLE_SQL = " create table ";

    public static String generateCreateTableDDL(String tableName, Class[] classes,int sizeOfColumn){

        if(sizeOfColumn <=0)
            sizeOfColumn = 50;

        String  sql = CREATE_TABLE_SQL + tableName + "(user_id int(11) NOT NULL AUTO_INCREMENT,";

        for(Class clazz: classes){
            for(Field field : clazz.getDeclaredFields()){
                sql += field.getName().toLowerCase()+ " varchar("+sizeOfColumn+") " + "  DEFAULT NULL ,";
            }
        }

        sql = sql.substring(0,sql.length()-1);
        sql+=sql+ ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";


        return  sql;
    }


    public static void main(String[] args) {
        System.out.println(SQLGenerator.generateCreateTableDDL("patients_day1",new Class[]{PatientInformationDto.class, PatientDay1Step1Information.class, PatientDay1Step2Information.class, PatientDay1Step3Information.class},100));
    }

}

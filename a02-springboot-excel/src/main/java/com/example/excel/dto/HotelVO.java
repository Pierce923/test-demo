package com.example.excel.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 2000w数据
 */
@Data
public class HotelVO {

    @ExcelProperty(value = "Name")
    private String name;
    @ExcelProperty(value = "CardNo")
    private String cardNo;
    @ExcelProperty(value = "Descriot")
    private String descriot;
    @ExcelProperty(value = "CtfTp")
    private String ctfTp;
    @ExcelProperty(value = "CtfId")
    private String ctfId;
    @ExcelProperty(value = "Gender")
    private String gender;
    @ExcelProperty(value = "Birthday")
    private String birthday;
    @ExcelProperty(value = "Address")
    private String address;
    @ExcelProperty(value = "Zip")
    private String zip;
    @ExcelProperty(value = "Dirty")
    private String dirty;
    @ExcelProperty(value = "District1")
    private String district1;
    @ExcelProperty(value = "District2")
    private String district2;
    @ExcelProperty(value = "District3")
    private String district3;
    @ExcelProperty(value = "District4")
    private String district4;
    @ExcelProperty(value = "District5")
    private String district5;
    @ExcelProperty(value = "District6")
    private String district6;
    @ExcelProperty(value = "FirstNm")
    private String firstNm;
    @ExcelProperty(value = "LastNm")
    private String lastNm;
    @ExcelProperty(value = "Duty")
    private String duty;
    @ExcelProperty(value = "Mobile")
    private String mobile;
    @ExcelProperty(value = "Tel")
    private String tel;
    @ExcelProperty(value = "Fax")
    private String fax;
    @ExcelProperty(value = "EMail")
    private String email;
    @ExcelProperty(value = "Nation")
    private String nation;
    @ExcelProperty(value = "Taste")
    private String taste;
    @ExcelProperty(value = "Education")
    private String education;
    @ExcelProperty(value = "Company")
    private String company;
    @ExcelProperty(value = "CTel")
    private String ctel;
    @ExcelProperty(value = "CAddress")
    private String caddress;
    @ExcelProperty(value = "CZip")
    private String czip;
    @ExcelProperty(value = "Family")
    private String family;
    @ExcelProperty(value = "Version")
    private  String version;
    @ExcelProperty(value = "id")
    private String id;


}

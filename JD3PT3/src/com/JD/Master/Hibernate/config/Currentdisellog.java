package com.JD.Master.Hibernate.config;
// Generated Jan 2, 2015 12:41:03 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Currentdisellog generated by hbm2java
 */
public class Currentdisellog  implements java.io.Serializable {


     private Integer id;
     private Double openingQuantity;
     private Double currentQuantity;
     private Date currentDateOfStatus;
     private String location;
     private String rawField1;
     private String rawField2;
     private String rawField3;
     private String rawField4;
     private String rawField5;
     private String rawField6;

    public Currentdisellog() {
    }

    public Currentdisellog(Double openingQuantity, Double currentQuantity, Date currentDateOfStatus, String location, String rawField1, String rawField2, String rawField3, String rawField4, String rawField5, String rawField6) {
       this.openingQuantity = openingQuantity;
       this.currentQuantity = currentQuantity;
       this.currentDateOfStatus = currentDateOfStatus;
       this.location = location;
       this.rawField1 = rawField1;
       this.rawField2 = rawField2;
       this.rawField3 = rawField3;
       this.rawField4 = rawField4;
       this.rawField5 = rawField5;
       this.rawField6 = rawField6;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getOpeningQuantity() {
        return this.openingQuantity;
    }
    
    public void setOpeningQuantity(Double openingQuantity) {
        this.openingQuantity = openingQuantity;
    }
    public Double getCurrentQuantity() {
        return this.currentQuantity;
    }
    
    public void setCurrentQuantity(Double currentQuantity) {
        this.currentQuantity = currentQuantity;
    }
    public Date getCurrentDateOfStatus() {
        return this.currentDateOfStatus;
    }
    
    public void setCurrentDateOfStatus(Date currentDateOfStatus) {
        this.currentDateOfStatus = currentDateOfStatus;
    }
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    public String getRawField1() {
        return this.rawField1;
    }
    
    public void setRawField1(String rawField1) {
        this.rawField1 = rawField1;
    }
    public String getRawField2() {
        return this.rawField2;
    }
    
    public void setRawField2(String rawField2) {
        this.rawField2 = rawField2;
    }
    public String getRawField3() {
        return this.rawField3;
    }
    
    public void setRawField3(String rawField3) {
        this.rawField3 = rawField3;
    }
    public String getRawField4() {
        return this.rawField4;
    }
    
    public void setRawField4(String rawField4) {
        this.rawField4 = rawField4;
    }
    public String getRawField5() {
        return this.rawField5;
    }
    
    public void setRawField5(String rawField5) {
        this.rawField5 = rawField5;
    }
    public String getRawField6() {
        return this.rawField6;
    }
    
    public void setRawField6(String rawField6) {
        this.rawField6 = rawField6;
    }




}



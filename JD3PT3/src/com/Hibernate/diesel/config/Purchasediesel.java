package com.Hibernate.diesel.config;
// Generated Jan 6, 2015 1:38:47 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Purchasediesel generated by hbm2java
 */
public class Purchasediesel  implements java.io.Serializable {


     private Integer id;
     private Double lastQuentity;
     private Double addedQuantity;
     private Double presentQuantity;
     private String personPresentName;
     private String oilCompanyName;
     private String orderSlipNumber;
     private Date dateOfAddition;
     private Date timeOfAddition;
     private String location;
     private String addedByPersonName;
     private String addedWithRight;
     private String rawField1;
     private String rawField2;
     private String rawField3;
     private String rawField4;
     private String rawField5;
     private String rawField6;

    public Purchasediesel() {
    }

    public Purchasediesel(Double lastQuentity, Double addedQuantity, Double presentQuantity, String personPresentName, String oilCompanyName, String orderSlipNumber, Date dateOfAddition, Date timeOfAddition, String location, String addedByPersonName, String addedWithRight, String rawField1, String rawField2, String rawField3, String rawField4, String rawField5, String rawField6) {
       this.lastQuentity = lastQuentity;
       this.addedQuantity = addedQuantity;
       this.presentQuantity = presentQuantity;
       this.personPresentName = personPresentName;
       this.oilCompanyName = oilCompanyName;
       this.orderSlipNumber = orderSlipNumber;
       this.dateOfAddition = dateOfAddition;
       this.timeOfAddition = timeOfAddition;
       this.location = location;
       this.addedByPersonName = addedByPersonName;
       this.addedWithRight = addedWithRight;
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
    public Double getLastQuentity() {
        return this.lastQuentity;
    }
    
    public void setLastQuentity(Double lastQuentity) {
        this.lastQuentity = lastQuentity;
    }
    public Double getAddedQuantity() {
        return this.addedQuantity;
    }
    
    public void setAddedQuantity(Double addedQuantity) {
        this.addedQuantity = addedQuantity;
    }
    public Double getPresentQuantity() {
        return this.presentQuantity;
    }
    
    public void setPresentQuantity(Double presentQuantity) {
        this.presentQuantity = presentQuantity;
    }
    public String getPersonPresentName() {
        return this.personPresentName;
    }
    
    public void setPersonPresentName(String personPresentName) {
        this.personPresentName = personPresentName;
    }
    public String getOilCompanyName() {
        return this.oilCompanyName;
    }
    
    public void setOilCompanyName(String oilCompanyName) {
        this.oilCompanyName = oilCompanyName;
    }
    public String getOrderSlipNumber() {
        return this.orderSlipNumber;
    }
    
    public void setOrderSlipNumber(String orderSlipNumber) {
        this.orderSlipNumber = orderSlipNumber;
    }
    public Date getDateOfAddition() {
        return this.dateOfAddition;
    }
    
    public void setDateOfAddition(Date dateOfAddition) {
        this.dateOfAddition = dateOfAddition;
    }
    public Date getTimeOfAddition() {
        return this.timeOfAddition;
    }
    
    public void setTimeOfAddition(Date timeOfAddition) {
        this.timeOfAddition = timeOfAddition;
    }
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    public String getAddedByPersonName() {
        return this.addedByPersonName;
    }
    
    public void setAddedByPersonName(String addedByPersonName) {
        this.addedByPersonName = addedByPersonName;
    }
    public String getAddedWithRight() {
        return this.addedWithRight;
    }
    
    public void setAddedWithRight(String addedWithRight) {
        this.addedWithRight = addedWithRight;
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



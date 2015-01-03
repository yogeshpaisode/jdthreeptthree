package com.JD.PrintReceiptDM.Hibernate.config;
// Generated Jan 3, 2015 12:54:59 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Printreceiptdm generated by hbm2java
 */
public class Printreceiptdm  implements java.io.Serializable {


     private Integer id;
     private String partyLink;
     private String productName;
     private Integer productSize;
     private String productMeasurement;
     private Integer productValue;
     private Integer totalAmount;
     private String paymentType;
     private Integer payableAmount;
     private Integer twoPayAmount;
     private String driverName;
     private String vehicleName;
     private String vehicleNumber;
     private String royaltyNumber;
     private String printProxy;
     private Double netWeight;
     private Double grossWeight;
     private String pendingStatus;
     private String preSrno;
     private Integer srno;
     private String qrcode;
     private String printingStatus;
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

    public Printreceiptdm() {
    }

    public Printreceiptdm(String partyLink, String productName, Integer productSize, String productMeasurement, Integer productValue, Integer totalAmount, String paymentType, Integer payableAmount, Integer twoPayAmount, String driverName, String vehicleName, String vehicleNumber, String royaltyNumber, String printProxy, Double netWeight, Double grossWeight, String pendingStatus, String preSrno, Integer srno, String qrcode, String printingStatus, Date dateOfAddition, Date timeOfAddition, String location, String addedByPersonName, String addedWithRight, String rawField1, String rawField2, String rawField3, String rawField4, String rawField5, String rawField6) {
       this.partyLink = partyLink;
       this.productName = productName;
       this.productSize = productSize;
       this.productMeasurement = productMeasurement;
       this.productValue = productValue;
       this.totalAmount = totalAmount;
       this.paymentType = paymentType;
       this.payableAmount = payableAmount;
       this.twoPayAmount = twoPayAmount;
       this.driverName = driverName;
       this.vehicleName = vehicleName;
       this.vehicleNumber = vehicleNumber;
       this.royaltyNumber = royaltyNumber;
       this.printProxy = printProxy;
       this.netWeight = netWeight;
       this.grossWeight = grossWeight;
       this.pendingStatus = pendingStatus;
       this.preSrno = preSrno;
       this.srno = srno;
       this.qrcode = qrcode;
       this.printingStatus = printingStatus;
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
    public String getPartyLink() {
        return this.partyLink;
    }
    
    public void setPartyLink(String partyLink) {
        this.partyLink = partyLink;
    }
    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getProductSize() {
        return this.productSize;
    }
    
    public void setProductSize(Integer productSize) {
        this.productSize = productSize;
    }
    public String getProductMeasurement() {
        return this.productMeasurement;
    }
    
    public void setProductMeasurement(String productMeasurement) {
        this.productMeasurement = productMeasurement;
    }
    public Integer getProductValue() {
        return this.productValue;
    }
    
    public void setProductValue(Integer productValue) {
        this.productValue = productValue;
    }
    public Integer getTotalAmount() {
        return this.totalAmount;
    }
    
    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String getPaymentType() {
        return this.paymentType;
    }
    
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    public Integer getPayableAmount() {
        return this.payableAmount;
    }
    
    public void setPayableAmount(Integer payableAmount) {
        this.payableAmount = payableAmount;
    }
    public Integer getTwoPayAmount() {
        return this.twoPayAmount;
    }
    
    public void setTwoPayAmount(Integer twoPayAmount) {
        this.twoPayAmount = twoPayAmount;
    }
    public String getDriverName() {
        return this.driverName;
    }
    
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public String getVehicleName() {
        return this.vehicleName;
    }
    
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
    public String getVehicleNumber() {
        return this.vehicleNumber;
    }
    
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public String getRoyaltyNumber() {
        return this.royaltyNumber;
    }
    
    public void setRoyaltyNumber(String royaltyNumber) {
        this.royaltyNumber = royaltyNumber;
    }
    public String getPrintProxy() {
        return this.printProxy;
    }
    
    public void setPrintProxy(String printProxy) {
        this.printProxy = printProxy;
    }
    public Double getNetWeight() {
        return this.netWeight;
    }
    
    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }
    public Double getGrossWeight() {
        return this.grossWeight;
    }
    
    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }
    public String getPendingStatus() {
        return this.pendingStatus;
    }
    
    public void setPendingStatus(String pendingStatus) {
        this.pendingStatus = pendingStatus;
    }
    public String getPreSrno() {
        return this.preSrno;
    }
    
    public void setPreSrno(String preSrno) {
        this.preSrno = preSrno;
    }
    public Integer getSrno() {
        return this.srno;
    }
    
    public void setSrno(Integer srno) {
        this.srno = srno;
    }
    public String getQrcode() {
        return this.qrcode;
    }
    
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }
    public String getPrintingStatus() {
        return this.printingStatus;
    }
    
    public void setPrintingStatus(String printingStatus) {
        this.printingStatus = printingStatus;
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



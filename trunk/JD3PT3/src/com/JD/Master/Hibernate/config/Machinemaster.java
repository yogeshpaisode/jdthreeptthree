package com.JD.Master.Hibernate.config;
// Generated Jan 2, 2015 12:41:03 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Machinemaster generated by hbm2java
 */
public class Machinemaster  implements java.io.Serializable {


     private Integer id;
     private String machinePartyLink;
     private String machineIdentification;
     private String machineType;
     private String machineName;
     private String machineNumber;
     private String machineServicingLogIn;
     private Integer machineServicingLog;
     private Double machineExpectedAvg;
     private String machineStatus;
     private Integer machineCurrentReading;
     private Integer machineServicingNumber;
     private Integer machineServicingReadingPointer;
     private Double machineFuel;
     private Date machineDateOfAddition;
     private Date machineTimeOfAddition;
     private String machineLocation;
     private String machineAddedByPersonName;
     private String machineAddedWithRight;
     private String rawField1;
     private String rawField2;
     private String rawField3;
     private String rawField4;
     private String rawField5;
     private String rawField6;

    public Machinemaster() {
    }

    public Machinemaster(String machinePartyLink, String machineIdentification, String machineType, String machineName, String machineNumber, String machineServicingLogIn, Integer machineServicingLog, Double machineExpectedAvg, String machineStatus, Integer machineCurrentReading, Integer machineServicingNumber, Integer machineServicingReadingPointer, Double machineFuel, Date machineDateOfAddition, Date machineTimeOfAddition, String machineLocation, String machineAddedByPersonName, String machineAddedWithRight, String rawField1, String rawField2, String rawField3, String rawField4, String rawField5, String rawField6) {
       this.machinePartyLink = machinePartyLink;
       this.machineIdentification = machineIdentification;
       this.machineType = machineType;
       this.machineName = machineName;
       this.machineNumber = machineNumber;
       this.machineServicingLogIn = machineServicingLogIn;
       this.machineServicingLog = machineServicingLog;
       this.machineExpectedAvg = machineExpectedAvg;
       this.machineStatus = machineStatus;
       this.machineCurrentReading = machineCurrentReading;
       this.machineServicingNumber = machineServicingNumber;
       this.machineServicingReadingPointer = machineServicingReadingPointer;
       this.machineFuel = machineFuel;
       this.machineDateOfAddition = machineDateOfAddition;
       this.machineTimeOfAddition = machineTimeOfAddition;
       this.machineLocation = machineLocation;
       this.machineAddedByPersonName = machineAddedByPersonName;
       this.machineAddedWithRight = machineAddedWithRight;
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
    public String getMachinePartyLink() {
        return this.machinePartyLink;
    }
    
    public void setMachinePartyLink(String machinePartyLink) {
        this.machinePartyLink = machinePartyLink;
    }
    public String getMachineIdentification() {
        return this.machineIdentification;
    }
    
    public void setMachineIdentification(String machineIdentification) {
        this.machineIdentification = machineIdentification;
    }
    public String getMachineType() {
        return this.machineType;
    }
    
    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }
    public String getMachineName() {
        return this.machineName;
    }
    
    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }
    public String getMachineNumber() {
        return this.machineNumber;
    }
    
    public void setMachineNumber(String machineNumber) {
        this.machineNumber = machineNumber;
    }
    public String getMachineServicingLogIn() {
        return this.machineServicingLogIn;
    }
    
    public void setMachineServicingLogIn(String machineServicingLogIn) {
        this.machineServicingLogIn = machineServicingLogIn;
    }
    public Integer getMachineServicingLog() {
        return this.machineServicingLog;
    }
    
    public void setMachineServicingLog(Integer machineServicingLog) {
        this.machineServicingLog = machineServicingLog;
    }
    public Double getMachineExpectedAvg() {
        return this.machineExpectedAvg;
    }
    
    public void setMachineExpectedAvg(Double machineExpectedAvg) {
        this.machineExpectedAvg = machineExpectedAvg;
    }
    public String getMachineStatus() {
        return this.machineStatus;
    }
    
    public void setMachineStatus(String machineStatus) {
        this.machineStatus = machineStatus;
    }
    public Integer getMachineCurrentReading() {
        return this.machineCurrentReading;
    }
    
    public void setMachineCurrentReading(Integer machineCurrentReading) {
        this.machineCurrentReading = machineCurrentReading;
    }
    public Integer getMachineServicingNumber() {
        return this.machineServicingNumber;
    }
    
    public void setMachineServicingNumber(Integer machineServicingNumber) {
        this.machineServicingNumber = machineServicingNumber;
    }
    public Integer getMachineServicingReadingPointer() {
        return this.machineServicingReadingPointer;
    }
    
    public void setMachineServicingReadingPointer(Integer machineServicingReadingPointer) {
        this.machineServicingReadingPointer = machineServicingReadingPointer;
    }
    public Double getMachineFuel() {
        return this.machineFuel;
    }
    
    public void setMachineFuel(Double machineFuel) {
        this.machineFuel = machineFuel;
    }
    public Date getMachineDateOfAddition() {
        return this.machineDateOfAddition;
    }
    
    public void setMachineDateOfAddition(Date machineDateOfAddition) {
        this.machineDateOfAddition = machineDateOfAddition;
    }
    public Date getMachineTimeOfAddition() {
        return this.machineTimeOfAddition;
    }
    
    public void setMachineTimeOfAddition(Date machineTimeOfAddition) {
        this.machineTimeOfAddition = machineTimeOfAddition;
    }
    public String getMachineLocation() {
        return this.machineLocation;
    }
    
    public void setMachineLocation(String machineLocation) {
        this.machineLocation = machineLocation;
    }
    public String getMachineAddedByPersonName() {
        return this.machineAddedByPersonName;
    }
    
    public void setMachineAddedByPersonName(String machineAddedByPersonName) {
        this.machineAddedByPersonName = machineAddedByPersonName;
    }
    public String getMachineAddedWithRight() {
        return this.machineAddedWithRight;
    }
    
    public void setMachineAddedWithRight(String machineAddedWithRight) {
        this.machineAddedWithRight = machineAddedWithRight;
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



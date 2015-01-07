/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.JD.Diesel.Forms;

/**
 *
 * @author Yogesh
 */
public class DataBean {

    String partName="";

    public String getAuthorisedPersoneName() {
        return authorisedPersoneName;
    }

    public void setAuthorisedPersoneName(String authorisedPersoneName) {
        this.authorisedPersoneName = authorisedPersoneName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getMachinneNumber() {
        return machinneNumber;
    }

    public void setMachinneNumber(String machinneNumber) {
        this.machinneNumber = machinneNumber;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getSellFuelQuantity() {
        return sellFuelQuantity;
    }

    public void setSellFuelQuantity(String sellFuelQuantity) {
        this.sellFuelQuantity = sellFuelQuantity;
    }
    String machinneNumber="";
    String machineName="";
    String sellFuelQuantity="";
    String authorisedPersoneName="";
    String driverName="";
    


}

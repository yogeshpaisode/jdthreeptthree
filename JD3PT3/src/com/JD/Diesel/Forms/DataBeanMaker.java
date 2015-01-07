/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.JD.Diesel.Forms;

/**
 *
 * @author Yogesh
 */
import java.util.ArrayList;


public class DataBeanMaker {
public ArrayList<DataBean> getDataBeanList(String  partyName,String machinneName,String machineNumber,String sellQuantity,String personName,String drivername) {
ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();

//dataBeanList.add(produce("Babji, Chetty", "Engineer", "Nuremberg", "Germany"));
dataBeanList.add(produce(partyName,machinneName,machineNumber,sellQuantity,personName,drivername));


return dataBeanList;
}

private DataBean produce(String  partyName,String machinneName,String machineNumber,String sellQuantity,String personName,String drivername) {
DataBean d = new DataBean();
d.setPartName(partyName);
d.setMachineName(machinneName);
d.setMachinneNumber(machineNumber);
d.setSellFuelQuantity(sellQuantity);
d.setAuthorisedPersoneName(personName);
d.setDriverName(drivername);
return d;
}
}
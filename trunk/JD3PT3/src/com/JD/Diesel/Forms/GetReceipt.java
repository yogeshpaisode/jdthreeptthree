/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.Diesel.Forms;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Yogesh
 */
public class GetReceipt implements Runnable {

    String partyName, machinneName, machineNumber, sellQuantity, personName, drivername;

    public GetReceipt(String partyName, String machinneName, String machineNumber, String sellQuantity, String personName, String drivername) {

        this.partyName = partyName;
        this.machinneName = machinneName;
        this.machineNumber = machineNumber;
        this.sellQuantity = sellQuantity;
        this.personName = personName;
        this.drivername = drivername;

        Thread t = new Thread(this, "");
        t.start();

    }

    public void run() {
        try {

            InputStream inputStream = getClass().getResourceAsStream("fuelReceipr.jrxml");

            DataBeanMaker dataBeanMaker = new DataBeanMaker();
            ArrayList<DataBean> dataBeanList = dataBeanMaker.getDataBeanList(partyName, machinneName, machineNumber, sellQuantity, personName, drivername);

            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);

            Map parameters = new HashMap();

            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
            JasperPrintManager.printReport(jasperPrint, false);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Printer Error : Please Cheack Your Printer...");
        }


    }
}

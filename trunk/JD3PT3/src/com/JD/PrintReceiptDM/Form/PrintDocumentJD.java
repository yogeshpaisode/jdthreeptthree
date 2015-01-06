/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.PrintReceiptDM.Form;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.aspose.barcode.BarCodeBuilder;
import com.aspose.barcode.CodeLocation;
import com.aspose.barcode.Symbology;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yogesh
 */
public class PrintDocumentJD implements Runnable {

    ArrayList<DataBean> dataBeanList;
    String rawField3;
    String srNo;

    PrintDocumentJD(ArrayList<DataBean> dataBeanList, String rawField3, String srNo) {

        this.dataBeanList = dataBeanList;
        this.rawField3 = rawField3;
        this.srNo = srNo;
        Thread t = new Thread(this, "");
        t.start();
    }

    public void run() {
        InputStream inputStream = null;
        boolean flag = true;
        try {
            BarCodeBuilder bb = new BarCodeBuilder();
            bb.setCodeText(rawField3);
            bb.setCodeTextColor(Color.white);
            bb.setCodeLocation(CodeLocation.Above);
            bb.setCodeTextSpace(1.0f);
            bb.setSymbologyType(Symbology.QR);
            bb.save("TEMP.jpg");
            new ImageCropper();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error In Printing : Please UnLock Your C Driver.. ");
        }
        try {

            inputStream = getClass().getResourceAsStream("JdCrusher.jrxml");
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
            Map parameters = new HashMap();
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
            JasperPrintManager.printPages(jasperPrint, 0, 1, false);
            JOptionPane.showMessageDialog(null, "Success..! Please Collect Your Receipt");
            com.JD.StaticData.Static_DATA.dm_Form.reset();    
           
           } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Printer Error : Please Cheack Your Printer...");
            int srNo = com.JD.StaticData.Static_DATA.srNo_TEMP;
            Session session = com.JD.StaticData.Static_DATA.dm_SessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Criteria cr = session.createCriteria(com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm.class);
            cr.add(Restrictions.eq("SRNO", srNo));
            List results = cr.list();

            for (Object object : results) {
                com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm printreceiptdm = (com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm) object;
                printreceiptdm.setPrintingStatus("Decline");
                printreceiptdm.setPendingStatus("TRUE");
                session.save(printreceiptdm);
                transaction.commit();
            }
            com.JD.StaticData.Static_DATA.flag3 = false;
            com.JD.StaticData.Static_DATA.dm_Form.updatePendingStatus();
            session.close();
            flag = false;
            com.JD.StaticData.Static_DATA.flag3 = true;
        }



    }
}

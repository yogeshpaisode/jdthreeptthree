/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.ExportToExcel;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author admin
 */
public class ExportToExcel extends javax.swing.JFrame {

    public void saveToExcel(JTable table) {
        int flag = 1;

        String fileName = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setBounds(1, 1, 100, 100);

        switch (fileChooser.showSaveDialog(this)) {
            case JFileChooser.APPROVE_OPTION:
                fileName = fileChooser.getSelectedFile() + "";
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(this, "Cancelled",
                        "Cancel",
                        JOptionPane.OK_OPTION);
                flag = 0;
                break;
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(this, "Error",
                        "Error",
                        JOptionPane.OK_OPTION);
        }
        if (flag == 1) {

            javax.swing.table.DefaultTableModel defaultTableModel = (javax.swing.table.DefaultTableModel) table.getModel();
            int cellCount = defaultTableModel.getColumnCount();
            int rowCount = defaultTableModel.getRowCount();
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Test Sheet");
            Row header = sheet.createRow(0);
            for (int i = 0; i < cellCount; i++) {
                sheet.setColumnWidth(i, 6000);
                header.createCell(i).setCellValue(defaultTableModel.getColumnName(i));
            }
            for (int i = 0; i < rowCount; i++) {
                header = sheet.createRow(i + 1);
                for (int j = 0; j < cellCount; j++) {
                    sheet.setColumnWidth(j, 6000);
                    header.createCell(j).setCellValue(defaultTableModel.getValueAt(i, j) + "");
                }
            }
            try {
                FileOutputStream out =
                        new FileOutputStream(new File(fileName + ".xls"));
                workbook.write(out);
                out.close();

                JOptionPane.showMessageDialog(null, "File Save To " + fileName + ".xlsx");


            } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Access Restricted,Please Select Another Location");
            }
        }
    }

    public void forDispatch(JTable table) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("cellstyle");
        XSSFCellStyle style7 = workbook.createCellStyle();
        style7.setFillForegroundColor(HSSFColor.RED.index);
        style7.setFillPattern(XSSFCellStyle.LESS_DOTS);
        int flag = 1;
        String fileName = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setBounds(1, 1, 100, 100);
        switch (fileChooser.showSaveDialog(this)) {
            case JFileChooser.APPROVE_OPTION:
                fileName = fileChooser.getSelectedFile() + "";
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(this, "Cancelled",
                        "Cancel",
                        JOptionPane.OK_OPTION);
                flag = 0;
                break;
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(this, "Error",
                        "Error",
                        JOptionPane.OK_OPTION);
        }
        if (flag == 1) {
            XSSFRow row;
            XSSFCell cell;
            javax.swing.table.DefaultTableModel defaultTableModel = (javax.swing.table.DefaultTableModel) table.getModel();
            int cellCount = defaultTableModel.getColumnCount();
            int rowCount = defaultTableModel.getRowCount();
            for (int k = 0; k < cellCount; k++) {
                sheet.setColumnWidth(k, 6000);
            }
            row = sheet.createRow(0);
            row.setHeight((short) 350);
            for (int u = 0; u < cellCount; u++) {               
                cell = (XSSFCell) row.createCell(u);
                cell.setCellValue(defaultTableModel.getColumnName(u) + "");
            }
            for (int i = 1; i <= rowCount; i++) {
                row = sheet.createRow(i);
                row.setHeight((short) 350);
                if (defaultTableModel.getValueAt(i-1, (cellCount - 1)).equals("Decline")) {
                    for (int j = 0; j < cellCount; j++) {// 

                        cell = (XSSFCell) row.createCell(j);
                        cell.setCellStyle(style7);
                        cell.setCellValue(defaultTableModel.getValueAt(i-1, j) + "");
                    }
                } else {
                    for (int j = 0; j < cellCount; j++) {//
                        cell = (XSSFCell) row.createCell(j);
                        cell.setCellValue(defaultTableModel.getValueAt(i-1, j) + "");
                    }
                }
            }
            try {
                FileOutputStream out =
                        new FileOutputStream(new File(fileName + ".xls"));
                workbook.write(out);
                out.close();

                JOptionPane.showMessageDialog(null, "File Save To " + fileName + ".xlsx");
                out.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Access Restricted,Please Select Another Location");
            }

        }
    }
}

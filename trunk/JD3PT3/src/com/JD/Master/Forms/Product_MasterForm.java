/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.Master.Forms;

import com.JD.Master.Hibernate.config.Productmaster;
import com.JD.Validator.Validator;
import java.lang.InstantiationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yogesh
 */
public class Product_MasterForm extends javax.swing.JFrame {

    /**
     * Creates new form Party_MasterForm
     */
    //----- DataBase Data -----//
    String productName = "";
    int productSize = 00;
    String productMeasurement = "";
    Date productDateOfAddition = null;
    Date productTimeOfAddition = null;
    String productLocation = com.JD.StaticData.Static_DATA.location;
    String productAddedByPersonName = com.JD.StaticData.Static_DATA.logIn_UserName;
    String productAddedWithRight = com.JD.StaticData.Static_DATA.logIn_Right;
    String rawField1 = "";
    String rawField2 = "";
    String rawField3 = "";
    String rawField4 = "";
    String rawField5 = "";
    String rawField6 = "";
    //--- Call Validator ---//
    com.JD.Validator.Validator valid = new Validator();
    //--- Call Validator ---//
    //----- DataBase Data -----//
    //--- Table Model Object And Index---//
    javax.swing.table.DefaultTableModel defaultTableModel;
    int indexJTable = -1;
    //--- Table Model Object And Index---//
    //--- INIT SESSION FACTORY ---//
    //SessionFactory masterSessionFactory = com.JD.StaticData.Static_DATA.master_SessionFactory;
    SessionFactory masterSessionFactory = com.JD.Master.Hibernate.config.Master_HibernateUtil.getSessionFactory();
    //----- Data Collection -----//
    String productNameList = "Raw,Aggrigate,Crush Sand,Bricks";
    String productMeasurementList = "CFT,BRASS,NUMBER,TON,CUM";
    //----- Data Collection -----//

    public Product_MasterForm() {
        initComponents();
        
        defaultTableModel = (DefaultTableModel) prductTable_JTable.getModel();
        Session session = masterSessionFactory.openSession();
        
        Query q = session.createQuery("from com.JD.Master.Hibernate.config.Productmaster");
        
        for (Object object : q.list()) {
            com.JD.Master.Hibernate.config.Productmaster p = (com.JD.Master.Hibernate.config.Productmaster) object;
            indexJTable = indexJTable + 1;
            defaultTableModel.insertRow(indexJTable, new Object[]{p.getProductName(), p.getProductSize(), p.getProductMeasurement(), p.getProductDateOfAddition(), p.getProductTimeOfAddition(), p.getProductAddedByPersonName(), p.getProductAddedWithRight(), p.getProductLocation()});
            
            
            if (productNameList.contains(p.getProductName())) {
            } else {
                productNameList = productNameList + "," + p.getProductName();
            }
            
            if (productMeasurementList.contains(p.getProductMeasurement())) {
            } else {
                productMeasurementList = productMeasurementList + "," + p.getProductMeasurement();
            }
            
        }
        session.close();
        
        String productNameTemp[] = productNameList.split(",");
        
        for (String string : productNameTemp) {
            
            productName_ComboBox.addItem(string);
            
        }
        
        String productMeasurementTemp[] = productMeasurementList.split(",");
        for (String string : productMeasurementTemp) {
            measurement_ComboBox.addItem(string);
        }
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productMaster_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        prductTable_JTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        productName_ComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        measurement_ComboBox = new javax.swing.JComboBox();
        size_TextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addDataToDatabase_Button = new javax.swing.JButton();
        reset_Button = new javax.swing.JButton();
        search_Button = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        productMaster_Panel.setBackground(new java.awt.Color(255, 255, 51));

        prductTable_JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Size", "Measurement", "DOA", "TOA", "AddedBy", "UserRight", "Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(prductTable_JTable);

        jLabel1.setText("* Product Name :");

        productName_ComboBox.setEditable(true);
        productName_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Product Name" }));

        jLabel2.setText("* Measurement:");

        jLabel4.setText("* Size:");

        measurement_ComboBox.setEditable(true);
        measurement_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Measurement" }));

        size_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                size_TextFieldKeyReleased(evt);
            }
        });

        jLabel3.setText("IN MM");

        addDataToDatabase_Button.setText("Add Product");
        addDataToDatabase_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDataToDatabase_ButtonActionPerformed(evt);
            }
        });

        reset_Button.setText("Reset");
        reset_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_ButtonActionPerformed(evt);
            }
        });

        search_Button.setText("Search.........");
        search_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        search_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                search_ButtonMouseEntered(evt);
            }
        });
        search_Button.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_ButtonKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout productMaster_PanelLayout = new javax.swing.GroupLayout(productMaster_Panel);
        productMaster_Panel.setLayout(productMaster_PanelLayout);
        productMaster_PanelLayout.setHorizontalGroup(
            productMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
            .addGroup(productMaster_PanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(productMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(productMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(productMaster_PanelLayout.createSequentialGroup()
                        .addComponent(addDataToDatabase_Button)
                        .addGap(18, 18, 18)
                        .addComponent(reset_Button, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                    .addComponent(productName_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(measurement_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(size_TextField))
                .addGroup(productMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productMaster_PanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(productMaster_PanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(search_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        productMaster_PanelLayout.setVerticalGroup(
            productMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productMaster_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(productName_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(productMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(measurement_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(productMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(size_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(productMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDataToDatabase_Button)
                    .addComponent(reset_Button)
                    .addComponent(search_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productMaster_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productMaster_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reset_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reset_ButtonActionPerformed
    
    private void size_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_size_TextFieldKeyReleased
        // TODO add your handling code here:
        size_TextField.setText(valid.intTypeNumberValidator(size_TextField.getText()));
    }//GEN-LAST:event_size_TextFieldKeyReleased
    
    private void addDataToDatabase_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDataToDatabase_ButtonActionPerformed
        // TODO add your handling code here:

        try {
            
            productSize = Integer.parseInt(size_TextField.getText());
            productMeasurement = measurement_ComboBox.getSelectedItem().toString();
            productName = productName_ComboBox.getSelectedItem().toString();
            productTimeOfAddition = new Date();
            productDateOfAddition = new Date();
            
            
            if (productName.equals("Select Product Name")) {
                JOptionPane.showMessageDialog(null, "Please Select Product Name");
            } else {
                if (productMeasurement.equals("Select Measurement")) {
                    JOptionPane.showMessageDialog(null, "Please Select Product Measurement");
                } else {
                    if (size_TextField.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Please Select Product Size");
                    } else {
                        addData();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Select Product Size" + e);
        }
    }//GEN-LAST:event_addDataToDatabase_ButtonActionPerformed
    
    private void search_ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_ButtonMouseEntered
        // TODO add your handling code here:

        search_Button.setText("");
        
    }//GEN-LAST:event_search_ButtonMouseEntered
    
    private void search_ButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_ButtonKeyReleased
        // TODO add your handling code here:

        String productNameTemp = search_Button.getText();
        Session session = masterSessionFactory.openSession();
        Criteria cr = session.createCriteria(com.JD.Master.Hibernate.config.Productmaster.class);
        cr.add(Restrictions.like("productName", productNameTemp + "%"));
        
        List results = cr.list();
        for (int i = defaultTableModel.getRowCount() - 1; i >= 0; i--) {
            defaultTableModel.removeRow(i);
        }
        indexJTable = -1;
        for (Object object : results) {
            com.JD.Master.Hibernate.config.Productmaster p = (com.JD.Master.Hibernate.config.Productmaster) object;
            indexJTable = indexJTable + 1;
            defaultTableModel.insertRow(indexJTable, new Object[]{p.getProductName(), p.getProductSize(), p.getProductMeasurement(), p.getProductDateOfAddition(), p.getProductTimeOfAddition(), p.getProductAddedByPersonName(), p.getProductAddedWithRight(), p.getProductLocation()});
            
        }
        session.close();
        
    }//GEN-LAST:event_search_ButtonKeyReleased
    
    void addData() {
        Session session = masterSessionFactory.openSession();
        Criteria cr = session.createCriteria(com.JD.Master.Hibernate.config.Productmaster.class);
        cr.add(Restrictions.eq("productName", productName));
        cr.add(Restrictions.eq("productSize", productSize));
        cr.add(Restrictions.eq("productMeasurement", productMeasurement));
        List results = cr.list();
        
        if (results.isEmpty()) {
            Transaction transaction = session.beginTransaction();
            indexJTable = indexJTable + 1;
            com.JD.Master.Hibernate.config.Productmaster p = new Productmaster(productName, productSize, productMeasurement, productDateOfAddition, productTimeOfAddition, productLocation, productAddedByPersonName, productAddedWithRight, rawField1, rawField2, rawField3, rawField4, rawField5, rawField6);
            session.save(p);
            transaction.commit();
            JOptionPane.showMessageDialog(null, "Product Name " + productName + " Added Successfully");
            reset();
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Data Product Name : " + productName + " , Measurement : " + productMeasurement + " , And Size : " + productSize + " Already Exist ");
        }
        session.close();
        
        if (productNameList.contains(productName)) {
        } else {
            productName_ComboBox.addItem(productName);
        }        
        if (productMeasurementList.contains(productMeasurement)) {            
        } else {
            measurement_ComboBox.addItem(productMeasurement);
        }      
        
        
    }
    
    void reset() {
        productName_ComboBox.setSelectedItem("Select Product Name");
        size_TextField.setText("");
        measurement_ComboBox.setSelectedItem("Select Measurement");
        search_Button.setText("Search.........");
        indexJTable = -1;
        for (int i = defaultTableModel.getRowCount() - 1; i >= 0; i--) {
            defaultTableModel.removeRow(i);
        }
        Session session = masterSessionFactory.openSession();
        Query q = session.createQuery("from com.JD.Master.Hibernate.config.Productmaster");
        for (Object object : q.list()) {
            com.JD.Master.Hibernate.config.Productmaster p = (com.JD.Master.Hibernate.config.Productmaster) object;
            indexJTable = indexJTable + 1;
            defaultTableModel.insertRow(indexJTable, new Object[]{p.getProductName(), p.getProductSize(), p.getProductMeasurement(), p.getProductDateOfAddition(), p.getProductTimeOfAddition(), p.getProductAddedByPersonName(), p.getProductAddedWithRight(), p.getProductLocation()});
        }
        session.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Product_MasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product_MasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product_MasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product_MasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new Product_MasterForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDataToDatabase_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox measurement_ComboBox;
    private javax.swing.JTable prductTable_JTable;
    public javax.swing.JPanel productMaster_Panel;
    private javax.swing.JComboBox productName_ComboBox;
    private javax.swing.JButton reset_Button;
    private javax.swing.JTextField search_Button;
    private javax.swing.JTextField size_TextField;
    // End of variables declaration//GEN-END:variables
}

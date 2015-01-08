/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.Diesel.Forms;

import com.Hibernate.diesel.config.Purchasediesel;
import com.JD.Test.*;
import com.JD.Master.Forms.*;
import com.JD.Validator.Validator;
import java.lang.InstantiationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yogesh
 */
public class PurchaseDiesel_Form extends javax.swing.JFrame {

    javax.swing.table.DefaultTableModel defaultTableModel;
    int indexJTable = -1;   
    String oilCompanyNameIN = "";
    List oilCompanyList = new ArrayList();
    List personNameList=new ArrayList();
    //-----------Call Validator--------//
    com.JD.Validator.Validator valid = new Validator();
    //-----------Call Validator--------//
    //-----------DiselLog--------------//
    double currentQuantity = 0.0;
    //-----------DiselLog--------------//
    //-----------Load DataFor Database--//   
    double lastQuentity = 0.0;
    double addedQuantity = 0.0;
    double presentQuantity = 0.0;
    String personPresentName = "";
    String oilCompanyName = "";
    String orderSlipNumber = "";
    Date dateOfAddition = null;
    Date timeOfAddition = null;
    String location = com.JD.StaticData.Static_DATA.location;
    String addedByPersonName = com.JD.StaticData.Static_DATA.logIn_UserName;
    String addedWithRight = com.JD.StaticData.Static_DATA.logIn_Right;
    String rawField1 = "";
    String rawField2 = "";
    String rawField3 = "";
    String rawField4 = "";
    String rawField5 = "";
    String rawField6 = "";
    //-----------Load DataFor Database--//
    //-----------Load SessionFactory----//
    SessionFactory diesel_SessionFactory = com.JD.StaticData.Static_DATA.init_SessionFactory;
    //-----------Load SessionFactory----//

    public PurchaseDiesel_Form() {
        initComponents();
        com.JD.StaticData.Static_DATA.fuelQuantity_Purchse_Lable = fuelQuantity_Purchse_Lable;
        com.JD.StaticData.Static_DATA.purchaseDiesel_Form = this;
        currentQuantity = setCurrentDieselLog(0.0);
        defaultTableModel = (DefaultTableModel) diesel_Table.getModel();
        oilCompanyList.add("Oil Company Name");
        oilCompanyList.add("Indian Oil Corporation");
        oilCompanyList.add("Bharat Petroleum");
        oilCompanyList.add("Hindustan Petroleum");
        oilCompanyList.add("Indraprastha Gas");
        oilCompanyList.add("Reliance Petroleum");
        oilCompanyList.add("Petronet LNG");
        oilCompanyList.add("IBP (merged subsidiary of Indian Oil)");
        oilCompanyList.add("Gujarat State Petroleum Corporation");
        oilCompanyList.add("Oil and Natural Gas Corporation");
        oilCompanyList.add("Castrol India");
        oilCompanyList.add("Mahanagar Gas");
        oilCompanyList.add("Mangalore Refinery and Petrochemicals Limited");
        oilCompanyList.add("Aban Offshore");
        
        personNameList.add("Select Person Name");

        Session session = diesel_SessionFactory.openSession();
        Query q = session.createQuery("from com.Hibernate.diesel.config.Purchasediesel");
        for (Object object : q.list()) {
            com.Hibernate.diesel.config.Purchasediesel p = (com.Hibernate.diesel.config.Purchasediesel) object;
            if (oilCompanyList.contains(p.getOilCompanyName()+"")) {                
            } else {
                oilCompanyList.add(p.getOilCompanyName());
            }
            
            if (personNameList.contains(p.getPersonPresentName())) {                
            } else {
                personNameList.add(p.getPersonPresentName());
            }        
            }
        session.close();        
        for (Object object : oilCompanyList) {
            companyName_comboBox.addItem(object.toString());
        }   
        for (Object object : personNameList) {
            personName_comboBox.addItem(object.toString());
        }
        resetJTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
//    double getCurrentDieselLog() {
//        double currentQuantityTemp=00;
//        Session session = diesel_SessionFactory.openSession();
//        Criteria cr = session.createCriteria(com.JD.Master.Hibernate.config.Currentdisellog.class);
//        cr.add(Restrictions.eq("id", 1));
//        List results = cr.list();
//        for (Object object : results) {
//            com.JD.Master.Hibernate.config.Currentdisellog c=(com.JD.Master.Hibernate.config.Currentdisellog)object;
//            currentQuantityTemp=c.getCurrentQuantity();
//        }
//        session.close();
//        return currentQuantityTemp;
//    }
    public double setCurrentDieselLog(double addedQuantity) {
        double log = 0.0;
        Session session = diesel_SessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria cr = session.createCriteria(com.JD.Master.Hibernate.config.Currentdisellog.class);
        cr.add(Restrictions.eq("id", 1));
        List results = cr.list();
        for (Object object : results) {
            com.JD.Master.Hibernate.config.Currentdisellog c = (com.JD.Master.Hibernate.config.Currentdisellog) object;
            log = c.getCurrentQuantity() + addedQuantity;
            c.setCurrentQuantity(log);
            session.save(c);
            transaction.commit();
        }
        if (com.JD.StaticData.Static_DATA.fuelQuantity_Lable != null) {
            String status = "";
            if (log >= 1) {
                status = "+" + log + "   LTR  ";
            } else if (log < 0) {
                status = "-" + log + "   LTR  ";
            } else if (log == 0) {
                status = "  " + log + "   LTR  ";
            }
            com.JD.StaticData.Static_DATA.fuelQuantity_Lable.setText(status);
            com.JD.StaticData.Static_DATA.fuelQuantity_Sell_Lable.setText(status);
            fuelQuantity_Purchse_Lable.setText(status);
        }
        session.close();
        return log;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dieselMaster_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        diesel_Table = new javax.swing.JTable();
        fuelQuantity_Purchse_Lable = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        received_TextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        slipNo_TextField = new javax.swing.JTextField();
        addDataToDatabase_Button = new javax.swing.JButton();
        reset_Button = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        companyName_comboBox = new javax.swing.JComboBox();
        personName_comboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dieselMaster_Panel.setBackground(new java.awt.Color(255, 255, 51));

        diesel_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Last", "Received", "Present", "Person Name", "Oil Company", "Slip No", "DOA", "TOA", "Added By", "Right", "Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(diesel_Table);

        fuelQuantity_Purchse_Lable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/Home/purched.png"))); // NOI18N
        fuelQuantity_Purchse_Lable.setText(" +134.99 LTR ");
        fuelQuantity_Purchse_Lable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel1.setText("* Current Quantity Of Diesel :");

        jLabel2.setText("* Received  Quantity Of Disel:");

        received_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                received_TextFieldKeyReleased(evt);
            }
        });

        jLabel3.setText("* Added By Person Name:");

        jLabel4.setText("* Added From Oil Company Name:");

        jLabel5.setText("Oil Slip Number:");

        slipNo_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                slipNo_TextFieldKeyReleased(evt);
            }
        });

        addDataToDatabase_Button.setText("Update Diesel Log");
        addDataToDatabase_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDataToDatabase_ButtonActionPerformed(evt);
            }
        });

        reset_Button.setText("Reset");

        jButton3.setText("Export To Excel");

        jButton4.setText("Print");

        jLabel6.setText(" In LTR ");

        companyName_comboBox.setEditable(true);

        personName_comboBox.setEditable(true);

        javax.swing.GroupLayout dieselMaster_PanelLayout = new javax.swing.GroupLayout(dieselMaster_Panel);
        dieselMaster_Panel.setLayout(dieselMaster_PanelLayout);
        dieselMaster_PanelLayout.setHorizontalGroup(
            dieselMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
            .addGroup(dieselMaster_PanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(dieselMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(dieselMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dieselMaster_PanelLayout.createSequentialGroup()
                        .addGroup(dieselMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fuelQuantity_Purchse_Lable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(received_TextField))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dieselMaster_PanelLayout.createSequentialGroup()
                        .addComponent(addDataToDatabase_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reset_Button))
                    .addComponent(companyName_comboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(personName_comboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dieselMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(slipNo_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dieselMaster_PanelLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dieselMaster_PanelLayout.setVerticalGroup(
            dieselMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dieselMaster_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dieselMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(fuelQuantity_Purchse_Lable))
                .addGroup(dieselMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dieselMaster_PanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2))
                    .addGroup(dieselMaster_PanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dieselMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(received_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addGroup(dieselMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(personName_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dieselMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(slipNo_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyName_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dieselMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDataToDatabase_Button)
                    .addComponent(reset_Button)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dieselMaster_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dieselMaster_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void received_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_received_TextFieldKeyReleased
        // TODO add your handling code here:
        received_TextField.setText(valid.numberValidator(received_TextField.getText()));
    }//GEN-LAST:event_received_TextFieldKeyReleased

    private void slipNo_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_slipNo_TextFieldKeyReleased
        // TODO add your handling code here:
        slipNo_TextField.setText(slipNo_TextField.getText().toUpperCase());
    }//GEN-LAST:event_slipNo_TextFieldKeyReleased

    private void addDataToDatabase_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDataToDatabase_ButtonActionPerformed
        // TODO add your handling code here:
        String receivedQuantityTemp = received_TextField.getText();
        dateOfAddition = new Date();
        timeOfAddition = new Date();
        oilCompanyName = companyName_comboBox.getSelectedItem().toString();
        orderSlipNumber = slipNo_TextField.getText();
        personPresentName = personName_comboBox.getSelectedItem().toString();
        if (receivedQuantityTemp.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Provide Received Quntity");
        } else {
            if (personPresentName.equals("Select Person Name")) {
                JOptionPane.showMessageDialog(null, "Please Provide Person Name");
            } else {
                if (oilCompanyName.equals("Oil Company Name")) {
                    JOptionPane.showMessageDialog(null, "Please Provide Oil Company Name");
                } else {
                    addedQuantity = Double.parseDouble(receivedQuantityTemp);
                    lastQuentity = setCurrentDieselLog(0.0);
                    presentQuantity = addedQuantity + lastQuentity;
                    addData();
                }
            }
        }
    }//GEN-LAST:event_addDataToDatabase_ButtonActionPerformed
    void addData() {
        addDataToDatabase_Button.setText("Processing..");
        Session session = diesel_SessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        com.Hibernate.diesel.config.Purchasediesel p = new Purchasediesel(lastQuentity, addedQuantity, presentQuantity, personPresentName, oilCompanyName, orderSlipNumber, dateOfAddition, timeOfAddition, location, addedByPersonName, addedWithRight, rawField1, rawField2, rawField3, rawField4, rawField5, rawField6);
        session.save(p);
        transaction.commit();
        session.close();
        setCurrentDieselLog(presentQuantity);
        JOptionPane.showMessageDialog(null, "Diesel Updated Successfully");
        if (oilCompanyList.contains(oilCompanyName)) {            
        } else {
            companyName_comboBox.addItem(oilCompanyName);
            oilCompanyList.add(oilCompanyName);
        }        
        if (personNameList.contains(personPresentName)) {            
        } else {
            personName_comboBox.addItem(personPresentName);
            personNameList.add(personPresentName);
        }            
        reset();
        resetPurchaseComboBox();
    }

    void resetPurchaseComboBox() {
        String oilCompanyNameTemp = "";
        String personNameTemp = "";
        com.JD.StaticData.Static_DATA.purchaseSearch_company_ComboBox.removeAllItems();
        com.JD.StaticData.Static_DATA.purchase_Perseon_Search_ComboBox.removeAllItems();
        com.JD.StaticData.Static_DATA.purchaseSearch_company_ComboBox.addItem("Oil Company Name");
        com.JD.StaticData.Static_DATA.purchase_Perseon_Search_ComboBox.addItem("Person Persent");
        Session session = diesel_SessionFactory.openSession();
        Query q = session.createQuery("from com.Hibernate.diesel.config.Purchasediesel");
        for (Object object : q.list()) {
            com.Hibernate.diesel.config.Purchasediesel p = (com.Hibernate.diesel.config.Purchasediesel) object;
            if (oilCompanyNameTemp.contains(p.getOilCompanyName())) {
            } else {
                oilCompanyNameTemp += "##" + p.getOilCompanyName();
                com.JD.StaticData.Static_DATA.purchaseSearch_company_ComboBox.addItem(p.getOilCompanyName());
            }
            if (personNameTemp.contains(p.getPersonPresentName())) {
            } else {
                personNameTemp += "##" + p.getPersonPresentName();
                com.JD.StaticData.Static_DATA.purchase_Perseon_Search_ComboBox.addItem(p.getPersonPresentName());
            }
        }
        session.close();
    }

    void reset() {
        received_TextField.setText("");
        personName_comboBox.setSelectedItem("Select Person Name");
        companyName_comboBox.setSelectedItem("Oil Company Name");
        slipNo_TextField.setText("");
        addDataToDatabase_Button.setText("Update Diesel Log");
        resetJTable();
    }

    void resetJTable() {
        indexJTable = -1;
        Session session = diesel_SessionFactory.openSession();
        for (int i = defaultTableModel.getRowCount() - 1; i >= 0; i--) {
            defaultTableModel.removeRow(i);
        }
        Query q = session.createQuery("from com.Hibernate.diesel.config.Purchasediesel");

        for (Object object : q.list()) {
            com.Hibernate.diesel.config.Purchasediesel p = (com.Hibernate.diesel.config.Purchasediesel) object;
            indexJTable += 1;
            defaultTableModel.insertRow(indexJTable, new Object[]{p.getLastQuentity(), p.getAddedQuantity(), p.getPresentQuantity(), p.getPersonPresentName(), p.getOilCompanyName(), p.getOrderSlipNumber(), p.getDateOfAddition(), p.getTimeOfAddition(), p.getAddedByPersonName(), p.getAddedWithRight(), p.getLocation()});
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
            java.util.logging.Logger.getLogger(PurchaseDiesel_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseDiesel_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseDiesel_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseDiesel_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PurchaseDiesel_Form().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDataToDatabase_Button;
    private javax.swing.JComboBox companyName_comboBox;
    public javax.swing.JPanel dieselMaster_Panel;
    private javax.swing.JTable diesel_Table;
    private javax.swing.JLabel fuelQuantity_Purchse_Lable;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox personName_comboBox;
    private javax.swing.JTextField received_TextField;
    private javax.swing.JButton reset_Button;
    private javax.swing.JTextField slipNo_TextField;
    // End of variables declaration//GEN-END:variables
}

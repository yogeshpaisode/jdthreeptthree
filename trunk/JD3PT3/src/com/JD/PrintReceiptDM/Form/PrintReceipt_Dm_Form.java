/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.PrintReceiptDM.Form;

import com.JD.Test.*;
import com.JD.Master.Forms.*;
import com.JD.Validator.Validator;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yogesh
 */
public class PrintReceipt_Dm_Form extends javax.swing.JFrame {

    boolean flag = false;
    //--------------INIT Data for Database----------//
    String partyLink = "";
    String productName = "";
    int productSize = 0;
    String productMeasurement = "";
    int productValue = 0;
    int totalAmount = 0;
    String paymentType = "";
    int payableAmount = 0;
    int twoPayAmount = 0;
    String driverName = "";
    String vehicleName = "";
    String vehicleNumber = "";
    String royaltyNumber = "";
    String printProxy = "";
    double netWeight = 0.0;
    double grossWeight = 0.0;
    String pendingStatus = "";
    String preSRNO = com.JD.StaticData.Static_DATA.prSrNo;
    int SRNO = com.JD.StaticData.Static_DATA.srNo;
    String QRCode = "";
    String printingStatus = "";
    Date dateOfAddition = null;
    Date timeOfAddition = null;
    String location = "";
    String addedByPersonName = com.JD.StaticData.Static_DATA.logIn_UserName;
    String addedWithRight = com.JD.StaticData.Static_DATA.logIn_Right;
    String rawField1 = "";
    String rawField2 = "";
    String rawField3 = "";
    String rawField4 = "";
    String rawField5 = "";
    String rawField6 = "";
//--------------INIT Data for Database----------//    
//------ Load Session Factory ------//        
    SessionFactory masterSessionFactory = com.JD.StaticData.Static_DATA.master_SessionFactory;
    SessionFactory initSessionFactory = com.JD.StaticData.Static_DATA.init_SessionFactory;
    SessionFactory dm_SessionFactory = com.JD.StaticData.Static_DATA.dm_SessionFactory;
//------ Load Session Factory ------//    
//----------Call Validator----------------------//
    com.JD.Validator.Validator valid = new Validator();
//----------Call Validator----------------------//   
//----------Table Mode--------------------------//
    javax.swing.table.DefaultTableModel defaultTableModel;
    int indexJTable = -1;
//----------Table Mode--------------------------//
//----------Temp Data--------------------------//
    String productNameTemp = "";
    String sizeTemp = "";
    String measurementTemp = "";
//----------Temp Data--------------------------//

    public PrintReceipt_Dm_Form() {
        initComponents();
        payAble_TextField.setBackground(Color.lightGray);
        twoPayAmount_TextField.setBackground(Color.lightGray);
        neightWeight_TextField.setBackground(Color.lightGray);
        grossWeight_TextField.setBackground(Color.lightGray);
        presrNo_Lable.setText(preSRNO);
        srNo_Lable.setText(preSRNO + "-" + SRNO);
        com.JD.StaticData.Static_DATA.dm_PartyName = party_ComboBox;
        com.JD.StaticData.Static_DATA.dm_ProductName = product_ComboBox;
        com.JD.StaticData.Static_DATA.dm_Size = size_ComboBox;
        com.JD.StaticData.Static_DATA.dm_Measurement = measurement_ComboBox;
        defaultTableModel = (DefaultTableModel) dm_Table.getModel();
        //------ Load WebPanel From com.JD.StaticData.Static_DATA-----//        
        webCan_Panel.add(com.JD.StaticData.Static_DATA.webPanel);
        //------ Load WebPanel From com.JD.StaticData.Static_DATA-----//   
        //------Load Data From Master---------------------------------//

        Session session = masterSessionFactory.openSession();

        Query q = session.createQuery("from com.JD.Master.Hibernate.config.Partymaster");
        for (Object object : q.list()) {
            com.JD.Master.Hibernate.config.Partymaster p = (com.JD.Master.Hibernate.config.Partymaster) object;
            party_ComboBox.addItem(p.getPartyName());
        }
        q = session.createQuery("from com.JD.Master.Hibernate.config.Productmaster");
        for (Object object : q.list()) {
            com.JD.Master.Hibernate.config.Productmaster p = (com.JD.Master.Hibernate.config.Productmaster) object;
            if (productNameTemp.contains(p.getProductName())) {
            } else {
                productNameTemp = productNameTemp + "##" + p.getProductName();
                product_ComboBox.addItem(p.getProductName());
            }

            if (sizeTemp.contains(p.getProductSize() + "")) {
            } else {
                sizeTemp = sizeTemp + "##" + p.getProductSize() + "";
                size_ComboBox.addItem(p.getProductSize() + "");
            }

            if (measurementTemp.contains(p.getProductMeasurement())) {
            } else {
                measurementTemp = measurementTemp + "##" + p.getProductMeasurement();
                measurement_ComboBox.addItem(p.getProductMeasurement());
            }

        }

        Criteria cr = session.createCriteria(com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm.class);
        cr.add(Restrictions.eq("pendingStatus", "TRUE"));
        List results = cr.list();

        for (Object object : results) {
            com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm p = (com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm) object;
            pending_ComboBox.addItem(p.getSrno());
        }

        session.close();


        //------Load Data From Master---------------------------------//
        flag = true;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        operation_ButtonGroup = new javax.swing.ButtonGroup();
        cashMode_ButtonGroup = new javax.swing.ButtonGroup();
        DM_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dm_Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        party_ComboBox = new javax.swing.JComboBox();
        webCan_Panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        product_ComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        size_ComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        measurement_ComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        value_TextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        totalAmount_TextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cash_CheackBox = new javax.swing.JCheckBox();
        twoPay_CheackBox = new javax.swing.JCheckBox();
        cashAndTwoPay_CheackBox = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        payAble_TextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        twoPayAmount_TextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        driverName_ComboBox = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        vehicleNumber_ComboBox = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        vehiclenumber_TextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        srNo_Lable = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        update_CheackBox = new javax.swing.JCheckBox();
        cancel_CheackBox = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        pending_CheackBox = new javax.swing.JCheckBox();
        pending_ComboBox = new javax.swing.JComboBox();
        export_Button = new javax.swing.JButton();
        print_Button = new javax.swing.JButton();
        proxy_CheackBox = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        neightWeight_TextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        grossWeight_TextField = new javax.swing.JTextField();
        presrNo_Lable = new javax.swing.JLabel();
        search_TextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        reset_Cheackbox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DM_Panel.setBackground(new java.awt.Color(255, 255, 51));

        dm_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(dm_Table);

        jLabel1.setText("* Party Name:");

        party_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Party Name" }));
        party_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                party_ComboBoxActionPerformed(evt);
            }
        });

        webCan_Panel.setBackground(new java.awt.Color(255, 255, 51));
        webCan_Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));

        javax.swing.GroupLayout webCan_PanelLayout = new javax.swing.GroupLayout(webCan_Panel);
        webCan_Panel.setLayout(webCan_PanelLayout);
        webCan_PanelLayout.setHorizontalGroup(
            webCan_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );
        webCan_PanelLayout.setVerticalGroup(
            webCan_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setText("* Product Name:");

        product_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Product Name" }));

        jLabel3.setText("* Size In MM:");

        size_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Size" }));

        jLabel4.setText("* Mesurement:");

        measurement_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Measurement" }));
        measurement_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                measurement_ComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setText("* Value:");

        value_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_TextFieldKeyReleased(evt);
            }
        });

        jLabel6.setText("* Total Amount:");

        totalAmount_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                totalAmount_TextFieldKeyReleased(evt);
            }
        });

        jLabel7.setText("* Payment Type:");

        cashMode_ButtonGroup.add(cash_CheackBox);
        cash_CheackBox.setText("Cash");
        cash_CheackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cash_CheackBoxActionPerformed(evt);
            }
        });

        cashMode_ButtonGroup.add(twoPay_CheackBox);
        twoPay_CheackBox.setText("Two Pay");
        twoPay_CheackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoPay_CheackBoxActionPerformed(evt);
            }
        });

        cashMode_ButtonGroup.add(cashAndTwoPay_CheackBox);
        cashAndTwoPay_CheackBox.setText("Cash And Two Pay");
        cashAndTwoPay_CheackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashAndTwoPay_CheackBoxActionPerformed(evt);
            }
        });

        jLabel8.setText("* PayAble Amount:");

        payAble_TextField.setBackground(new java.awt.Color(255, 204, 255));
        payAble_TextField.setEditable(false);
        payAble_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                payAble_TextFieldKeyReleased(evt);
            }
        });

        jLabel9.setText("* TwoPay Amount:");

        twoPayAmount_TextField.setBackground(new java.awt.Color(255, 204, 255));
        twoPayAmount_TextField.setEditable(false);
        twoPayAmount_TextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                twoPayAmount_TextFieldMouseEntered(evt);
            }
        });

        jLabel10.setText("* Driver Name:");

        driverName_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Driver Name" }));

        jLabel11.setText("* Vehicle Number:");

        vehicleNumber_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Vehicle Number" }));

        jLabel12.setText("* Vehicle Name:");

        vehiclenumber_TextField.setBackground(new java.awt.Color(255, 204, 255));
        vehiclenumber_TextField.setEditable(false);

        jLabel13.setText("Date:");

        jLabel14.setText("jLabel14");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel15.setText("Time:");

        jLabel16.setText("jLabel16");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel17.setText("Sr.No : ");

        srNo_Lable.setText("jLabel18");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/PrintReceiptDM/Form/UP.jpg"))); // NOI18N
        jLabel19.setText(" Scan QR Code From Receipt To UPDATE/CANCEL Order");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        operation_ButtonGroup.add(update_CheackBox);
        update_CheackBox.setText("Update");
        update_CheackBox.setEnabled(false);

        operation_ButtonGroup.add(cancel_CheackBox);
        cancel_CheackBox.setText("Cancel");
        cancel_CheackBox.setEnabled(false);

        jButton1.setText("Place Order");

        operation_ButtonGroup.add(pending_CheackBox);
        pending_CheackBox.setText("Pending");

        pending_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Load Pending Order" }));

        export_Button.setText("Exportl");

        print_Button.setText("Print");

        proxy_CheackBox.setText("Print Quantity In Ton ?");
        proxy_CheackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proxy_CheackBoxActionPerformed(evt);
            }
        });

        jLabel18.setText("NT WT:");

        neightWeight_TextField.setBackground(new java.awt.Color(255, 204, 255));
        neightWeight_TextField.setEnabled(false);
        neightWeight_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                neightWeight_TextFieldKeyReleased(evt);
            }
        });

        jLabel20.setText("GR WT:");

        grossWeight_TextField.setBackground(new java.awt.Color(255, 204, 255));
        grossWeight_TextField.setEnabled(false);
        grossWeight_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                grossWeight_TextFieldKeyReleased(evt);
            }
        });

        presrNo_Lable.setText("NA- ");

        search_TextField.setText("Search..........");
        search_TextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        search_TextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                search_TextFieldMouseEntered(evt);
            }
        });
        search_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_TextFieldKeyReleased(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/Home/Hide.jpg"))); // NOI18N
        jLabel21.setText("Type Order Number To Search");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        reset_Cheackbox.setText("Reset");
        reset_Cheackbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_CheackboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DM_PanelLayout = new javax.swing.GroupLayout(DM_Panel);
        DM_Panel.setLayout(DM_PanelLayout);
        DM_PanelLayout.setHorizontalGroup(
            DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
            .addGroup(DM_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DM_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(srNo_Lable, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(update_CheackBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancel_CheackBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pending_CheackBox, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                    .addGroup(DM_PanelLayout.createSequentialGroup()
                        .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addGap(32, 32, 32)
                        .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(party_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(product_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(measurement_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalAmount_TextField)
                            .addComponent(payAble_TextField)
                            .addComponent(driverName_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vehicleNumber_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(proxy_CheackBox, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18)
                    .addComponent(reset_Cheackbox))
                .addGap(23, 23, 23)
                .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DM_PanelLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(export_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(print_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(size_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(value_TextField)
                    .addGroup(DM_PanelLayout.createSequentialGroup()
                        .addComponent(cash_CheackBox)
                        .addGap(10, 10, 10)
                        .addComponent(twoPay_CheackBox)
                        .addGap(10, 10, 10)
                        .addComponent(cashAndTwoPay_CheackBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(twoPayAmount_TextField)
                    .addComponent(vehiclenumber_TextField)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pending_ComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DM_PanelLayout.createSequentialGroup()
                        .addComponent(neightWeight_TextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addGap(12, 12, 12)
                        .addComponent(grossWeight_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(webCan_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DM_PanelLayout.createSequentialGroup()
                        .addComponent(presrNo_Lable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        DM_PanelLayout.setVerticalGroup(
            DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DM_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DM_PanelLayout.createSequentialGroup()
                        .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(party_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pending_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DM_PanelLayout.createSequentialGroup()
                                .addComponent(size_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(value_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DM_PanelLayout.createSequentialGroup()
                                .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(product_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(measurement_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(totalAmount_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(cash_CheackBox)
                                        .addComponent(twoPay_CheackBox)
                                        .addComponent(cashAndTwoPay_CheackBox)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(payAble_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(twoPayAmount_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(driverName_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(vehicleNumber_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(vehiclenumber_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)))
                    .addComponent(webCan_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(grossWeight_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20))
                    .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(proxy_CheackBox)
                        .addComponent(jLabel18))
                    .addComponent(neightWeight_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(srNo_Lable)
                    .addComponent(update_CheackBox)
                    .addComponent(cancel_CheackBox)
                    .addComponent(pending_CheackBox)
                    .addComponent(jButton1)
                    .addComponent(export_Button)
                    .addComponent(print_Button)
                    .addComponent(presrNo_Lable)
                    .addComponent(search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(reset_Cheackbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DM_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DM_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void measurement_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_measurement_ComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_measurement_ComboBoxActionPerformed

    private void search_TextFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_TextFieldMouseEntered
        // TODO add your handling code here:
        search_TextField.setText("Search.......");
    }//GEN-LAST:event_search_TextFieldMouseEntered

    private void reset_CheackboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_CheackboxActionPerformed
        // TODO add your handling code here:
        if (reset_Cheackbox.isSelected()) {
            reset();
        }
    }//GEN-LAST:event_reset_CheackboxActionPerformed

    private void cash_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cash_CheackBoxActionPerformed
        // TODO add your handling code here:
        if (cash_CheackBox.isSelected()) {
            twoPayAmount_TextField.setText("");
            twoPayAmount_TextField.setEditable(false);
            twoPayAmount_TextField.setBackground(Color.lightGray);
            payAble_TextField.setText(totalAmount_TextField.getText());
            payAble_TextField.setBackground(Color.white);
            paymentType = "CASH";
        }
    }//GEN-LAST:event_cash_CheackBoxActionPerformed

    private void totalAmount_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalAmount_TextFieldKeyReleased
        // TODO add your handling code here:        
        totalAmount_TextField.setText(valid.intTypeNumberValidator(totalAmount_TextField.getText()));
        if (cash_CheackBox.isSelected()) {
            payAble_TextField.setText(totalAmount_TextField.getText());
        } else if (twoPay_CheackBox.isSelected()) {
            twoPayAmount_TextField.setText(totalAmount_TextField.getText());
        }

    }//GEN-LAST:event_totalAmount_TextFieldKeyReleased

    private void twoPay_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoPay_CheackBoxActionPerformed
        // TODO add your handling code here:
        if (twoPay_CheackBox.isSelected()) {

            twoPayAmount_TextField.setText(totalAmount_TextField.getText());
            twoPayAmount_TextField.setEditable(false);
            twoPayAmount_TextField.setBackground(Color.white);

            payAble_TextField.setText("");
            payAble_TextField.setBackground(Color.lightGray);
            payAble_TextField.setEditable(false);

            paymentType = "TWOPAY";
        }
    }//GEN-LAST:event_twoPay_CheackBoxActionPerformed

    private void cashAndTwoPay_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashAndTwoPay_CheackBoxActionPerformed
        // TODO add your handling code here:

        if (cashAndTwoPay_CheackBox.isSelected()) {
            twoPayAmount_TextField.setText("");
            twoPayAmount_TextField.setEditable(false);
            twoPayAmount_TextField.setBackground(Color.white);

            payAble_TextField.setText("");
            payAble_TextField.setBackground(Color.white);
            payAble_TextField.setEditable(true);

        }

    }//GEN-LAST:event_cashAndTwoPay_CheackBoxActionPerformed

    private void twoPayAmount_TextFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twoPayAmount_TextFieldMouseEntered
        // TODO add your handling code here:

        int totalAmountTemp = Integer.parseInt(totalAmount_TextField.getText());
        int payAbleAmountTemp = Integer.parseInt(payAble_TextField.getText());

        if (totalAmountTemp <= payAbleAmountTemp) {
            cash_CheackBox.setSelected(true);
            twoPayAmount_TextField.setText("");
            twoPayAmount_TextField.setEditable(false);
            twoPayAmount_TextField.setBackground(Color.lightGray);
            payAble_TextField.setText(totalAmount_TextField.getText());
            payAble_TextField.setBackground(Color.white);
            paymentType = "CASH";
        } else {
            twoPayAmount = totalAmountTemp - payAbleAmountTemp;
            twoPayAmount_TextField.setText(twoPayAmount + "");
        }

    }//GEN-LAST:event_twoPayAmount_TextFieldMouseEntered

    private void value_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_TextFieldKeyReleased
        // TODO add your handling code here:
        value_TextField.setText(valid.intTypeNumberValidator(value_TextField.getText()));
    }//GEN-LAST:event_value_TextFieldKeyReleased

    private void payAble_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_payAble_TextFieldKeyReleased
        // TODO add your handling code here:
        payAble_TextField.setText(valid.intTypeNumberValidator(payAble_TextField.getText()));
    }//GEN-LAST:event_payAble_TextFieldKeyReleased

    private void neightWeight_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_neightWeight_TextFieldKeyReleased
        // TODO add your handling code here:
        neightWeight_TextField.setText(valid.numberValidator(neightWeight_TextField.getText()));
    }//GEN-LAST:event_neightWeight_TextFieldKeyReleased

    private void grossWeight_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_grossWeight_TextFieldKeyReleased
        // TODO add your handling code here:
        grossWeight_TextField.setText(valid.numberValidator(grossWeight_TextField.getText()));
    }//GEN-LAST:event_grossWeight_TextFieldKeyReleased

    private void search_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_TextFieldKeyReleased
        // TODO add your handling code here:
        search_TextField.setText(valid.intTypeNumberValidator(search_TextField.getText()));
    }//GEN-LAST:event_search_TextFieldKeyReleased

    private void proxy_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proxy_CheackBoxActionPerformed
        // TODO add your handling code here:
        if (proxy_CheackBox.isSelected()) {
            neightWeight_TextField.setEditable(true);
            neightWeight_TextField.setBackground(Color.white);
            grossWeight_TextField.setEditable(true);
            grossWeight_TextField.setBackground(Color.white);
        } else {
            neightWeight_TextField.setEditable(false);
            neightWeight_TextField.setBackground(Color.lightGray);
            grossWeight_TextField.setEditable(false);
            grossWeight_TextField.setBackground(Color.lightGray);
        }
    }//GEN-LAST:event_proxy_CheackBoxActionPerformed

    private void party_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_party_ComboBoxActionPerformed
        // TODO add your handling code here:

        if (flag) {
            String partyNameTemp = party_ComboBox.getSelectedItem().toString();
            driverName_ComboBox.removeAllItems();
            vehicleNumber_ComboBox.removeAllItems();
            driverName_ComboBox.addItem("Select Driver Name");
            vehicleNumber_ComboBox.addItem("Select Vehicle Number");
            Session session = masterSessionFactory.openSession();
            Criteria cr = session.createCriteria(com.JD.Master.Hibernate.config.Drivermaster.class);
            cr.add(Restrictions.eq("driverPartyLink", partyNameTemp));
            List results = cr.list();

            for (Object object : results) {
                com.JD.Master.Hibernate.config.Drivermaster d = (com.JD.Master.Hibernate.config.Drivermaster) object;
                driverName_ComboBox.addItem(d.getDriverName());
            }

            cr = session.createCriteria(com.JD.Master.Hibernate.config.Machinemaster.class);
            cr.add(Restrictions.eq("machinePartyLink", partyNameTemp));
            cr.add(Restrictions.eq("machineType", "VEHICLE"));
            results = cr.list();
            for (Object object : results) {
                com.JD.Master.Hibernate.config.Machinemaster m = (com.JD.Master.Hibernate.config.Machinemaster) object;
                vehicleNumber_ComboBox.addItem(m.getMachineNumber());
            }
            session.close();
        }

    }//GEN-LAST:event_party_ComboBoxActionPerformed

    void calculateAmount() {
        int totalAmountTemp = Integer.parseInt(totalAmount_TextField.getText());
        int payAbleAmountTemp = Integer.parseInt(payAble_TextField.getText());
        if (totalAmountTemp <= payAbleAmountTemp) {
            twoPayAmount = 0;
            payableAmount = totalAmountTemp;
        } else {
            twoPayAmount = totalAmountTemp - payAbleAmountTemp;
            payableAmount = payAbleAmountTemp;
        }

    }

    void updateSRNO() {

        com.JD.StaticData.Static_DATA.srNo += 1;
    }

    void reset() {
        party_ComboBox.setSelectedItem("Select Party Name");
        pending_ComboBox.setSelectedItem("Load Pending Order");
        product_ComboBox.setSelectedItem("Select Product Name");
        size_ComboBox.setSelectedItem("Select Size");
        measurement_ComboBox.setSelectedItem("Select Measurement");
        driverName_ComboBox.setSelectedItem("Select Driver Name");
        vehicleNumber_ComboBox.setSelectedItem("Select Vehicle Number");
        value_TextField.setText("");
        totalAmount_TextField.setText("");
        payAble_TextField.setText("");
        twoPayAmount_TextField.setText("");
        vehiclenumber_TextField.setText("");
        neightWeight_TextField.setText("");
        grossWeight_TextField.setText("");
        cashMode_ButtonGroup.clearSelection();
        operation_ButtonGroup.clearSelection();

        neightWeight_TextField.setEnabled(false);
        grossWeight_TextField.setEnabled(false);
        payAble_TextField.setEnabled(false);
        twoPayAmount_TextField.setEnabled(false);
        update_CheackBox.setEnabled(false);
        cancel_CheackBox.setEnabled(false);

        search_TextField.setText("Search.......");
        reset_Cheackbox.setSelected(false);
        proxy_CheackBox.setSelected(false);

        payAble_TextField.setBackground(Color.lightGray);
        twoPayAmount_TextField.setBackground(Color.lightGray);
        neightWeight_TextField.setBackground(Color.lightGray);
        grossWeight_TextField.setBackground(Color.lightGray);
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
            java.util.logging.Logger.getLogger(PrintReceipt_Dm_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintReceipt_Dm_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintReceipt_Dm_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintReceipt_Dm_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PrintReceipt_Dm_Form().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel DM_Panel;
    private javax.swing.JCheckBox cancel_CheackBox;
    private javax.swing.JCheckBox cashAndTwoPay_CheackBox;
    private javax.swing.ButtonGroup cashMode_ButtonGroup;
    private javax.swing.JCheckBox cash_CheackBox;
    private javax.swing.JTable dm_Table;
    private javax.swing.JComboBox driverName_ComboBox;
    private javax.swing.JButton export_Button;
    private javax.swing.JTextField grossWeight_TextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox measurement_ComboBox;
    private javax.swing.JTextField neightWeight_TextField;
    private javax.swing.ButtonGroup operation_ButtonGroup;
    private javax.swing.JComboBox party_ComboBox;
    private javax.swing.JTextField payAble_TextField;
    private javax.swing.JCheckBox pending_CheackBox;
    private javax.swing.JComboBox pending_ComboBox;
    private javax.swing.JLabel presrNo_Lable;
    private javax.swing.JButton print_Button;
    private javax.swing.JComboBox product_ComboBox;
    private javax.swing.JCheckBox proxy_CheackBox;
    private javax.swing.JCheckBox reset_Cheackbox;
    private javax.swing.JTextField search_TextField;
    private javax.swing.JComboBox size_ComboBox;
    private javax.swing.JLabel srNo_Lable;
    private javax.swing.JTextField totalAmount_TextField;
    private javax.swing.JTextField twoPayAmount_TextField;
    private javax.swing.JCheckBox twoPay_CheackBox;
    private javax.swing.JCheckBox update_CheackBox;
    private javax.swing.JTextField value_TextField;
    private javax.swing.JComboBox vehicleNumber_ComboBox;
    private javax.swing.JTextField vehiclenumber_TextField;
    private javax.swing.JPanel webCan_Panel;
    // End of variables declaration//GEN-END:variables

    public JPanel getDM_Panel() {
        return DM_Panel;
    }
}

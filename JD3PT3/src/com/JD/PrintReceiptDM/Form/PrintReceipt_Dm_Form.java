/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.PrintReceiptDM.Form;

import com.JD.ExportToExcel.ExportToExcel;
import com.JD.Test.*;
import com.JD.Master.Forms.*;
import com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm;
import com.JD.Validator.Validator;
import java.awt.Color;
import java.lang.InstantiationException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yogesh
 */
public class PrintReceipt_Dm_Form extends javax.swing.JFrame {

    boolean flag = false;
    boolean flag2 = false;
    boolean flag3 = false;
    public boolean flag4 = false;
    Calendar now = Calendar.getInstance();
    int srNOtemp = 0;
    String qrCodeTemp = "";
    Date currenTDate = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String datestring = dateFormat.format(currenTDate);
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
    String printProxy = "FALSE";
    double netWeight = 0.0;
    double grossWeight = 0.0;
    String pendingStatus = "FALSE";
    String preSRNO = com.JD.StaticData.Static_DATA.prSrNo;
    int SRNO = com.JD.StaticData.Static_DATA.srNo;
    String QRCode = "";
    String printingStatus = "Accept";
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
    SessionFactory masterSessionFactory = com.JD.StaticData.Static_DATA.init_SessionFactory;
    SessionFactory initSessionFactory = com.JD.StaticData.Static_DATA.init_SessionFactory;
    SessionFactory dm_SessionFactory = com.JD.StaticData.Static_DATA.init_SessionFactory;
//------ Load Session Factory ------//    
//----------Call Validator----------------------//
    com.JD.Validator.Validator valid = new Validator();
//----------Call Validator----------------------//   
//----------Table Mode--------------------------//
    javax.swing.table.DefaultTableModel defaultTableModel;
    int indexJTable = -1;
//----------Table Mode--------------------------//
//----------Temp Data--------------------------//
    List productNameTempList = new ArrayList();
    List sizeTemp = new ArrayList();
    List measurementTempList = new ArrayList();
//----------Temp Data--------------------------//

    public PrintReceipt_Dm_Form() {
        initComponents();
        com.JD.StaticData.Static_DATA.productNameTempList = productNameTempList;
        com.JD.StaticData.Static_DATA.sizeTemp = sizeTemp;
        com.JD.StaticData.Static_DATA.measurementTempList = measurementTempList;
        com.JD.StaticData.Static_DATA.dm_time_Lable = dm_time_Lable;
        com.JD.StaticData.Static_DATA.dm_date_Lable = dm_date_Lable;
        //------------Fill Product Name-----------//
        productNameTempList.add("RAW");
        productNameTempList.add("AGGRIGATE");
        productNameTempList.add("CRUSH SAND");
        productNameTempList.add("BRICKS");

        measurementTempList.add("CFT");
        measurementTempList.add("BRASS");
        measurementTempList.add("NUMBER");
        measurementTempList.add("TON");
        measurementTempList.add("CUM");
        
        sizeTemp.add("00");
        sizeTemp.add("10");
        sizeTemp.add("20");
        sizeTemp.add("30");
        sizeTemp.add("40");
        sizeTemp.add("50");
        sizeTemp.add("60");
        sizeTemp.add("70");
        sizeTemp.add("80");
        sizeTemp.add("90");
        sizeTemp.add("100");      
              
        payAble_TextField.setBackground(Color.lightGray);
        twoPayAmount_TextField.setBackground(Color.lightGray);
        neightWeight_TextField.setBackground(Color.lightGray);
        grossWeight_TextField.setBackground(Color.lightGray);

        presrNo_Lable.setText(" " + preSRNO + "-");
        srNo_Lable.setText(preSRNO + "-" + SRNO);
        defaultTableModel = (DefaultTableModel) dm_Table.getModel();
        //------ Load WebPanel From com.JD.StaticData.Static_DATA-----//        
        webCan_Panel.add(com.JD.StaticData.Static_DATA.webPanel);
        com.JD.StaticData.Static_DATA.webCam_Panel_Dm = webCan_Panel;
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
            if (!sizeTemp.contains(p.getProductSize() + "")) {
                sizeTemp.add(p.getProductSize());
                size_ComboBox.addItem(p.getProductSize());
            }
            if (!productNameTempList.contains(p.getProductName())) {
                productNameTempList.add(p.getProductName());
            }
            if (!measurementTempList.contains(p.getProductMeasurement())) {
                measurementTempList.add(p.getProductMeasurement());
            }
        }
        for (Object object : productNameTempList) {
            product_ComboBox.addItem(object.toString());
        }
        for (Object object : measurementTempList) {
            measurement_ComboBox.addItem(object.toString());
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
        flag3 = true;

        //------Load All Component To sattic Class----//
        com.JD.StaticData.Static_DATA.addDataToDataBase_Button = addDataToDataBase_Button;
        com.JD.StaticData.Static_DATA.dm_PartyName = party_ComboBox;
        com.JD.StaticData.Static_DATA.dm_ProductName = product_ComboBox;
        com.JD.StaticData.Static_DATA.dm_Size = size_ComboBox;
        com.JD.StaticData.Static_DATA.dm_Measurement = measurement_ComboBox;
        com.JD.StaticData.Static_DATA.dm_value_TextField = value_TextField;
        com.JD.StaticData.Static_DATA.totalAmount_TextField = totalAmount_TextField;
        com.JD.StaticData.Static_DATA.cash_CheackBox = cash_CheackBox;
        com.JD.StaticData.Static_DATA.twoPay_CheackBox = twoPay_CheackBox;
        com.JD.StaticData.Static_DATA.cashAndTwoPay_CheackBox = cashAndTwoPay_CheackBox;
        com.JD.StaticData.Static_DATA.payAble_TextField = payAble_TextField;
        com.JD.StaticData.Static_DATA.twoPayAmount_TextField = twoPayAmount_TextField;
        com.JD.StaticData.Static_DATA.driverName_ComboBox = driverName_ComboBox;
        com.JD.StaticData.Static_DATA.vehicleNumber_ComboBox = vehicleNumber_ComboBox;
        com.JD.StaticData.Static_DATA.vehicleName_TextField = vehicleName_TextField;
        com.JD.StaticData.Static_DATA.date_Lable = dm_date_Lable;
        com.JD.StaticData.Static_DATA.time_Lable = dm_time_Lable;
        com.JD.StaticData.Static_DATA.proxy_CheackBox = proxy_CheackBox;
        com.JD.StaticData.Static_DATA.neightWeight_TextField = neightWeight_TextField;
        com.JD.StaticData.Static_DATA.grossWeight_TextField = grossWeight_TextField;
        com.JD.StaticData.Static_DATA.update_CheackBox = update_CheackBox;
        com.JD.StaticData.Static_DATA.cancel_CheackBox = cancel_CheackBox;
        com.JD.StaticData.Static_DATA.clear_CheackBox = clear_CheackBox;
        com.JD.StaticData.Static_DATA.srNo_Lable = srNo_Lable;
        com.JD.StaticData.Static_DATA.pending_CheackBox = pending_CheackBox;
        com.JD.StaticData.Static_DATA.pending_ComboBox = pending_ComboBox;
        //------Load All Component To sattic Class----//
        resetJTable();

        dm_date_Lable.setText(now.get(Calendar.DATE) + "-" + (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.YEAR));
        dm_time_Lable.setText(now.get(Calendar.HOUR) + ":" + now.get(Calendar.MINUTE));
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
        vehicleName_TextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        dm_date_Lable = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        dm_time_Lable = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        srNo_Lable = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        update_CheackBox = new javax.swing.JCheckBox();
        cancel_CheackBox = new javax.swing.JCheckBox();
        addDataToDataBase_Button = new javax.swing.JButton();
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
        clear_CheackBox = new javax.swing.JCheckBox();
        reset_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DM_Panel.setBackground(new java.awt.Color(255, 255, 51));

        dm_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr.No", "Party Name", "Product Name", "Product Size", "Measurement", "Value", "Total Amount", "Payment Type", "PayAble", "TwoPay", "Driver Name", "Vehicle Number", "Vehicle Name", "DOO/U", "TOO/U", "Added By", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        payAble_TextField.setDragEnabled(true);
        payAble_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                payAble_TextFieldKeyReleased(evt);
            }
        });

        jLabel9.setText("* TwoPay Amount:");

        twoPayAmount_TextField.setBackground(new java.awt.Color(255, 204, 255));
        twoPayAmount_TextField.setEditable(false);
        twoPayAmount_TextField.setDragEnabled(true);
        twoPayAmount_TextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                twoPayAmount_TextFieldMouseEntered(evt);
            }
        });

        jLabel10.setText("* Driver Name:");

        driverName_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Driver Name" }));

        jLabel11.setText("* Vehicle Number:");

        vehicleNumber_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Vehicle Number" }));
        vehicleNumber_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleNumber_ComboBoxActionPerformed(evt);
            }
        });

        jLabel12.setText("* Vehicle Name:");

        vehicleName_TextField.setBackground(new java.awt.Color(255, 204, 255));
        vehicleName_TextField.setEditable(false);

        jLabel13.setText("Date:");

        dm_date_Lable.setText("jLabel14");
        dm_date_Lable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel15.setText("Time:");

        dm_time_Lable.setText("jLabel16");
        dm_time_Lable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel17.setText("Sr.No : ");

        srNo_Lable.setText("jLabel18");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/PrintReceiptDM/Form/UP.jpg"))); // NOI18N
        jLabel19.setText(" Scan QR Code To UPDATE/CANCEL Order");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        operation_ButtonGroup.add(update_CheackBox);
        update_CheackBox.setText("Update");
        update_CheackBox.setEnabled(false);
        update_CheackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_CheackBoxActionPerformed(evt);
            }
        });

        operation_ButtonGroup.add(cancel_CheackBox);
        cancel_CheackBox.setText("Cancel");
        cancel_CheackBox.setEnabled(false);
        cancel_CheackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_CheackBoxActionPerformed(evt);
            }
        });

        addDataToDataBase_Button.setText("Place Order");
        addDataToDataBase_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDataToDataBase_ButtonActionPerformed(evt);
            }
        });

        pending_CheackBox.setText("Pending");
        pending_CheackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pending_CheackBoxActionPerformed(evt);
            }
        });

        pending_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Load Pending Order" }));
        pending_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pending_ComboBoxActionPerformed(evt);
            }
        });

        export_Button.setText("Export");
        export_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                export_ButtonActionPerformed(evt);
            }
        });

        print_Button.setText("Print");
        print_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_ButtonActionPerformed(evt);
            }
        });

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
        jLabel21.setText("Order Number To Search");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        operation_ButtonGroup.add(clear_CheackBox);
        clear_CheackBox.setText("Clear");
        clear_CheackBox.setEnabled(false);
        clear_CheackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_CheackBoxActionPerformed(evt);
            }
        });

        reset_Button.setText("Reset");
        reset_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_ButtonActionPerformed(evt);
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
                        .addComponent(clear_CheackBox, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
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
                            .addComponent(dm_date_Lable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(proxy_CheackBox, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DM_PanelLayout.createSequentialGroup()
                        .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18))
                        .addGap(23, 23, 23))
                    .addGroup(DM_PanelLayout.createSequentialGroup()
                        .addComponent(pending_CheackBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reset_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(size_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(value_TextField)
                    .addGroup(DM_PanelLayout.createSequentialGroup()
                        .addComponent(cash_CheackBox)
                        .addGap(10, 10, 10)
                        .addComponent(twoPay_CheackBox)
                        .addGap(10, 10, 10)
                        .addComponent(cashAndTwoPay_CheackBox, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                    .addComponent(twoPayAmount_TextField)
                    .addComponent(vehicleName_TextField)
                    .addComponent(dm_time_Lable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pending_ComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DM_PanelLayout.createSequentialGroup()
                        .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addDataToDataBase_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(neightWeight_TextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DM_PanelLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(12, 12, 12)
                                .addComponent(grossWeight_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DM_PanelLayout.createSequentialGroup()
                                .addComponent(export_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(print_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(webCan_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(DM_PanelLayout.createSequentialGroup()
                            .addComponent(presrNo_Lable)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(166, Short.MAX_VALUE))
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
                            .addComponent(vehicleName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DM_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(dm_date_Lable)
                            .addComponent(jLabel15)
                            .addComponent(dm_time_Lable)))
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
                    .addComponent(addDataToDataBase_Button)
                    .addComponent(export_Button)
                    .addComponent(print_Button)
                    .addComponent(presrNo_Lable)
                    .addComponent(search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(clear_CheackBox)
                    .addComponent(reset_Button))
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
        search_TextField.setText("");
    }//GEN-LAST:event_search_TextFieldMouseEntered

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
            payAble_TextField.setEnabled(true);
            paymentType = "CASHANDTWOPAY";

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
        String searchTemp = search_TextField.getText();
        if (searchTemp.equals("")) {
            resetJTable();
        } else {
            String srNumberTemp = search_TextField.getText();
            for (int i = defaultTableModel.getRowCount() - 1; i >= 0; i--) {
                defaultTableModel.removeRow(i);
            }
            Session session = dm_SessionFactory.openSession();
            Criteria cr = session.createCriteria(com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm.class);
            cr.add(Restrictions.like("rawField1", srNumberTemp + "%"));
            List results = cr.list();
            indexJTable = -1;
            for (Object object : results) {
                com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm d = (com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm) object;
                indexJTable += 1;
                defaultTableModel.insertRow(indexJTable, new Object[]{d.getSrno(), d.getPartyLink(), d.getProductName(), d.getProductSize(), d.getProductMeasurement(), d.getProductValue(), d.getTotalAmount(), d.getPaymentType(), d.getDriverName(), d.getVehicleNumber(), d.getVehicleName(), d.getDateOfAddition(), d.getTimeOfAddition(), d.getAddedByPersonName(), d.getPrintingStatus()});
            }
            session.close();
        }
    }//GEN-LAST:event_search_TextFieldKeyReleased

    private void proxy_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proxy_CheackBoxActionPerformed
        // TODO add your handling code here:
        if (proxy_CheackBox.isSelected()) {
            neightWeight_TextField.setEditable(true);
            neightWeight_TextField.setEnabled(true);
            neightWeight_TextField.setBackground(Color.white);
            grossWeight_TextField.setEditable(true);
            grossWeight_TextField.setEnabled(true);
            grossWeight_TextField.setBackground(Color.white);
            printProxy = "TRUE";
        } else {
            neightWeight_TextField.setEditable(false);
            neightWeight_TextField.setEnabled(false);
            neightWeight_TextField.setBackground(Color.lightGray);
            grossWeight_TextField.setEditable(false);
            grossWeight_TextField.setEditable(false);
            grossWeight_TextField.setBackground(Color.lightGray);
            printProxy = "FALSE";
        }
    }//GEN-LAST:event_proxy_CheackBoxActionPerformed

    private void party_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_party_ComboBoxActionPerformed
        // TODO add your handling code here:

        if (flag) {
            flag2 = false;
            vehicleName_TextField.setText("");
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
            flag2 = true;
        }

    }//GEN-LAST:event_party_ComboBoxActionPerformed

    private void vehicleNumber_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleNumber_ComboBoxActionPerformed
        // TODO add your handling code here:
        if (flag2) {
            String vehicleNumberTemp = vehicleNumber_ComboBox.getSelectedItem().toString();
            Session session = masterSessionFactory.openSession();

            Criteria cr = session.createCriteria(com.JD.Master.Hibernate.config.Machinemaster.class);
            cr.add(Restrictions.eq("machineNumber", vehicleNumberTemp));
            List results = cr.list();

            for (Object object : results) {
                com.JD.Master.Hibernate.config.Machinemaster m = (com.JD.Master.Hibernate.config.Machinemaster) object;
                vehicleName_TextField.setText(m.getMachineName());
            }
            session.close();
        }

    }//GEN-LAST:event_vehicleNumber_ComboBoxActionPerformed

    private void addDataToDataBase_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDataToDataBase_ButtonActionPerformed
        // TODO add your handling code here:
        SRNO = com.JD.StaticData.Static_DATA.srNo;
        rawField1 = SRNO + "";
        partyLink = party_ComboBox.getSelectedItem().toString();
        productName = product_ComboBox.getSelectedItem().toString();
        String productSizeTemp = size_ComboBox.getSelectedItem().toString();
        String productValueTemp = value_TextField.getText();
        String totalAmountTemp = totalAmount_TextField.getText();
        driverName = driverName_ComboBox.getSelectedItem().toString();
        vehicleNumber = vehicleNumber_ComboBox.getSelectedItem().toString();
        vehicleName = vehicleName_TextField.getText();
        productMeasurement = measurement_ComboBox.getSelectedItem().toString();
        dateOfAddition = new Date();
        timeOfAddition = new Date();
        boolean proxy = proxyTest();
        boolean payment = paymentOptionTest();
        if (pending_CheackBox.isSelected()) {
            pendingStatus = "TRUE";
        }

        if (partyLink.equals("Select Party Name")) {
            JOptionPane.showMessageDialog(null, "Please Select Party Name");
        } else {
            if (productName.equals("Select Product Name")) {
                JOptionPane.showMessageDialog(null, "Please Select Product Name");
            } else {
                if (productSizeTemp.equals("Select Size")) {
                    JOptionPane.showMessageDialog(null, "Please Provide Product Size");
                } else {
                    if (productMeasurement.equals("Select Measurement")) {
                        JOptionPane.showMessageDialog(null, "Please Select Product Measurement");
                    } else {
                        if (productValueTemp.equals("") || productValueTemp.equals("0") || productValueTemp.equals("0.")) {
                            JOptionPane.showMessageDialog(null, "Please Provide Valid Value");
                        } else {
                            if (totalAmountTemp.equals("") || totalAmountTemp.equals("0") || totalAmountTemp.equals("0.")) {
                                JOptionPane.showMessageDialog(null, "Please Provide Valid Total Amount");
                            } else {
                                if (payment) {
                                    if (driverName.equals("Select Driver Name")) {
                                        JOptionPane.showMessageDialog(null, "Please Select Driver Name");

                                    } else {
                                        if (vehicleNumber.equals("Select Vehicle Number")) {
                                            JOptionPane.showMessageDialog(null, "Please Select Vehicle Number");
                                        } else {
                                            if (proxy_CheackBox.isSelected()) {
                                                if (proxy) {
                                                    stage1();
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Either NET Weight or GROSS Weight Is not Provided");
                                                }
                                            } else {
                                                stage1();
                                            }
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Please Select Payment Type");
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_addDataToDataBase_ButtonActionPerformed

    void stage1() {
        String totalAmountTEMP = totalAmount_TextField.getText();
        String payableTEMP = payAble_TextField.getText();
        String twoPayTEMP = twoPayAmount_TextField.getText();
        if (cashAndTwoPay_CheackBox.isSelected()) {
            if (payableTEMP.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Provide Payable Amount");
            } else {
                if (twoPayTEMP.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Provide TwoPay Amount");
                } else {
                    int totalAmountINT = Integer.parseInt(totalAmountTEMP);
                    int payableINT = Integer.parseInt(payableTEMP);
                    int twopayINT = Integer.parseInt(twoPayTEMP);
                    twoPayAmount = totalAmountINT;
                    payableAmount = payableINT;
                    twoPayAmount = twopayINT;
                    if ((payableINT != totalAmountINT) && payableINT < totalAmountINT && payableINT != 0) {
                        paymentType = "CASHANDTWOPAY";
                        businessLogic();
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Provide Valid Payable Amount And TwoPay Amount");
                    }
                }
            }
        } else if (cash_CheackBox.isSelected()) {
            if (totalAmountTEMP.equals(payableTEMP)) {
                int totalAmountINT = Integer.parseInt(totalAmountTEMP);
                int payableINT = Integer.parseInt(payableTEMP);
                twoPayAmount = totalAmountINT;
                payableAmount = payableINT;
                paymentType = "CASH";
                businessLogic();
            } else {
                JOptionPane.showMessageDialog(null, "Please Provide Valid Payable Amount");
            }
        } else if (twoPay_CheackBox.isSelected()) {
            if (totalAmountTEMP.equals(twoPayTEMP)) {
                int totalAmountINT = Integer.parseInt(totalAmountTEMP);
                paymentType = "TWOPAY";
                int twopayINT = Integer.parseInt(twoPayTEMP);
                twoPayAmount = totalAmountINT;
                twoPayAmount = twopayINT;
                businessLogic();
            } else {
                JOptionPane.showMessageDialog(null, "Please Provide Valid Two Pay Amount");
            }
        }
    }

    void businessLogic() {
//----------------------------------------------------Bussiness Logic--------------------------------------------------------------------------//
        calculateAmount();
        cheackOperationType();
//----------------------------------------------------Bussiness Logic--------------------------------------------------------------------------//

    }

    private void update_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_CheackBoxActionPerformed
        // TODO add your handling code here:

        if (update_CheackBox.isSelected()) {
            addDataToDataBase_Button.setText("Update Order");
        }

    }//GEN-LAST:event_update_CheackBoxActionPerformed

    private void cancel_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_CheackBoxActionPerformed
        // TODO add your handling code here:
        if (cancel_CheackBox.isSelected()) {
            addDataToDataBase_Button.setText("Cancel Order");
        }
    }//GEN-LAST:event_cancel_CheackBoxActionPerformed

    private void clear_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_CheackBoxActionPerformed
        // TODO add your handling code here:
        if (clear_CheackBox.isSelected()) {
            addDataToDataBase_Button.setText("Place Order");
        }
    }//GEN-LAST:event_clear_CheackBoxActionPerformed

    private void pending_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pending_ComboBoxActionPerformed
        // TODO add your handling code here: pendingStatus
        if (flag3) {
            if (pending_ComboBox.getItemCount() >= 1) {
                String srNOTemp = pending_ComboBox.getSelectedItem().toString();
                if (srNOTemp.equals("Load Pending Order")) {
                } else {
                    Session session = dm_SessionFactory.openSession();
                    Criteria cr = session.createCriteria(com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm.class);
                    cr.add(Restrictions.eq("srno", Integer.parseInt(srNOTemp)));
                    List results = cr.list();
                    for (Object object : results) {
                        try {
                            com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm dm = (com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm) object;
                            com.JD.StaticData.Static_DATA.dm_PartyName.setSelectedItem(dm.getPartyLink());
                            com.JD.StaticData.Static_DATA.dm_ProductName.setSelectedItem(dm.getProductName());
                            com.JD.StaticData.Static_DATA.dm_Size.setSelectedItem(dm.getProductSize() + "");
                            com.JD.StaticData.Static_DATA.dm_Measurement.setSelectedItem(dm.getProductMeasurement() + "");
                            com.JD.StaticData.Static_DATA.dm_value_TextField.setText(dm.getProductValue() + "");
                            com.JD.StaticData.Static_DATA.totalAmount_TextField.setText(dm.getTotalAmount() + "");
                            size_ComboBox.setSelectedItem(dm.getProductSize());
                            if (dm.getPaymentType().equals("CASH")) {
                                com.JD.StaticData.Static_DATA.cash_CheackBox.setSelected(true);
                                com.JD.StaticData.Static_DATA.twoPayAmount_TextField.setText("");
                                com.JD.StaticData.Static_DATA.twoPayAmount_TextField.setEditable(false);
                                com.JD.StaticData.Static_DATA.payAble_TextField.setText(dm.getPayableAmount() + "");
                                com.JD.StaticData.Static_DATA.payAble_TextField.setEditable(true);
                            }
                            if (dm.getPaymentType().equals("CASHANDTWOPAY")) {
                                com.JD.StaticData.Static_DATA.cashAndTwoPay_CheackBox.setSelected(true);
                                com.JD.StaticData.Static_DATA.twoPayAmount_TextField.setText(dm.getTwoPayAmount() + "");
                                com.JD.StaticData.Static_DATA.twoPayAmount_TextField.setEditable(false);
                                com.JD.StaticData.Static_DATA.payAble_TextField.setText(dm.getPayableAmount() + "");
                                com.JD.StaticData.Static_DATA.payAble_TextField.setEditable(true);
                            }
                            if (dm.getPaymentType().equals("TWOPAY")) {
                                com.JD.StaticData.Static_DATA.twoPay_CheackBox.setSelected(true);
                                com.JD.StaticData.Static_DATA.twoPayAmount_TextField.setText(dm.getTwoPayAmount() + "");
                                com.JD.StaticData.Static_DATA.twoPayAmount_TextField.setEditable(false);
                                com.JD.StaticData.Static_DATA.payAble_TextField.setText("");
                                com.JD.StaticData.Static_DATA.payAble_TextField.setEditable(false);
                            }

                            com.JD.StaticData.Static_DATA.driverName_ComboBox.setSelectedItem(dm.getDriverName());
                            com.JD.StaticData.Static_DATA.vehicleNumber_ComboBox.setSelectedItem(dm.getVehicleNumber());
                            com.JD.StaticData.Static_DATA.vehicleName_TextField.setText(dm.getVehicleName());
                            flag4 = true;
                            if (dm.getPrintProxy().equals("TRUE")) {
                                com.JD.StaticData.Static_DATA.proxy_CheackBox.setSelected(true);
                                com.JD.StaticData.Static_DATA.neightWeight_TextField.setText(dm.getNetWeight() + "");
                                com.JD.StaticData.Static_DATA.grossWeight_TextField.setText(dm.getGrossWeight() + "");
                                com.JD.StaticData.Static_DATA.grossWeight_TextField.setEditable(true);
                                com.JD.StaticData.Static_DATA.neightWeight_TextField.setEditable(true);
                            } else {
                                com.JD.StaticData.Static_DATA.proxy_CheackBox.setSelected(false);
                                com.JD.StaticData.Static_DATA.neightWeight_TextField.setText("");
                                com.JD.StaticData.Static_DATA.grossWeight_TextField.setText("");
                                com.JD.StaticData.Static_DATA.grossWeight_TextField.setEditable(false);
                                com.JD.StaticData.Static_DATA.neightWeight_TextField.setEditable(false);
                            }
                            com.JD.StaticData.Static_DATA.SRNO = dm.getSrno();
                            com.JD.StaticData.Static_DATA.QRCode = dm.getQrcode();
                            srNOtemp = dm.getSrno();
                            qrCodeTemp = dm.getQrcode();
                            //JOptionPane.showMessageDialog(null, "From Loading :" + SRNO + "");

                            srNo_Lable.setText(com.JD.StaticData.Static_DATA.prSrNo + "-" + dm.getSrno() + "");
                            com.JD.StaticData.Static_DATA.update_CheackBox.setEnabled(true);
                            com.JD.StaticData.Static_DATA.cancel_CheackBox.setEnabled(true);
                            com.JD.StaticData.Static_DATA.clear_CheackBox.setEnabled(true);
                            if (dm.getPendingStatus().equals("TRUE")) {
                                com.JD.StaticData.Static_DATA.pending_CheackBox.setSelected(true);
                            }

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                    session.close();
                }
            }
        }
    }//GEN-LAST:event_pending_ComboBoxActionPerformed

    private void pending_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pending_CheackBoxActionPerformed
        // TODO add your handling code here:
        if (pending_CheackBox.isSelected()) {
            pendingStatus = "TRUE";
            printingStatus = "Decline";
        } else {
            pendingStatus = "FALSE";
            printingStatus = "Accept";
        }
    }//GEN-LAST:event_pending_CheackBoxActionPerformed

    private void reset_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_ButtonActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_reset_ButtonActionPerformed

    private void export_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_export_ButtonActionPerformed
        // TODO add your handling code here:
        if (dm_Table.getModel().getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Cant Export ! No Data In The Table");
        } else {
            new ExportToExcel().saveToExcel_forDispatch(dm_Table);
        }

    }//GEN-LAST:event_export_ButtonActionPerformed

    private void print_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_ButtonActionPerformed
        // TODO add your handling code here:
        if (dm_Table.getModel().getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Cant Print ! No Data In The Table");
        } else {
            try {
                dm_Table.print();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Something Went Wrong ! Please Cheack your Printer");
            }
        }

    }//GEN-LAST:event_print_ButtonActionPerformed

    void cheackOperationType() {
        if (pending_CheackBox.isSelected()) {
            pendingStatus = "TRUE";
            printingStatus = "Decline";
        } else {
            pendingStatus = "FALSE";
            printingStatus = "Accept";
        }
        if (update_CheackBox.isSelected()) {
            update();

        } else if (cancel_CheackBox.isSelected()) {
            cancel();

        } else {
            insert();
        }
    }

    void insert() {
        addDataToDataBase_Button.setText("Processing..");
        addDataToDataBase_Button.setEnabled(false);
        if (flag4) {
            QRCode = qrCodeTemp;
            SRNO = srNOtemp;
            rawField1 = SRNO + "";
        }
        Session session = dm_SessionFactory.openSession();
        Criteria cr = session.createCriteria(com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm.class);
        cr.add(Restrictions.eq("srno", SRNO));
        List results = cr.list();
        if (results.isEmpty()) {
            String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuffer sb = new StringBuffer(10);
            for (int i = 0; i < 10; i++) {
                int ndx = (int) (Math.random() * str.length());
                sb.append(str.charAt(ndx));
            }
            QRCode = sb + "";
            Transaction transaction = session.beginTransaction();
            com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm printreceiptdm = new Printreceiptdm(partyLink, productName, productSize, productMeasurement, productValue, totalAmount, paymentType, payableAmount, twoPayAmount, driverName, vehicleName, vehicleNumber, royaltyNumber, printProxy, netWeight, grossWeight, pendingStatus, preSRNO, SRNO, QRCode, printingStatus, dateOfAddition, timeOfAddition, location, addedByPersonName, addedWithRight, rawField1, rawField2, rawField3, rawField4, rawField5, rawField6);
            session.save(printreceiptdm);
            if (!com.JD.StaticData.Static_DATA.productNameList.contains(productName)) {
                com.JD.StaticData.Static_DATA.dmsearch_ProductName_ComboBox.addItem(productName);
                com.JD.StaticData.Static_DATA.productNameList.add(productName);
            }
            if (!com.JD.StaticData.Static_DATA.measurementList.contains(productMeasurement)) {
                com.JD.StaticData.Static_DATA.measurementList.add(productMeasurement);
                com.JD.StaticData.Static_DATA.dmSearch_measurement_ComboBox.addItem(productMeasurement);
            }
            if (!com.JD.StaticData.Static_DATA.sizeList.contains(productSize)) {
                com.JD.StaticData.Static_DATA.sizeList.add(productSize);
                com.JD.StaticData.Static_DATA.dmsearch_size_ComboBox.addItem(productSize);
            }
            transaction.commit();
            printReceipt();
            updateSRNO();
        } else {
            update();
        }
        session.close();
    }

    void printReceipt() {
        if (pending_CheackBox.isSelected()) {
            pending_ComboBox.addItem(SRNO + "");
            reset();
        } else {
            ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();
            DataBean d = new DataBean();
            d.setPartyName(" : " + partyLink);
            d.setParticular(" : " + productName);
            d.setRoyaltyNumber(" : " + royaltyNumber);
            d.setSrNo(preSRNO + "-" + SRNO);
            d.setMeasurement(" : " + productSize);
            d.setTotalAmount(" : " + totalAmount);
            d.setPayableAmount(" : " + payableAmount);
            d.setCft(": " + productValue);
            d.setPendingAmount(" : " + twoPayAmount);

            d.setPath(System.getProperty("user.dir") + "\\TEMP1.jpg");
            if (proxy_CheackBox.isSelected()) {
                d.setQuantity("TON");
                d.setNetWeight(" : " + neightWeight_TextField.getText());
                d.setGrossWeight(" : " + grossWeight_TextField.getText());
            } else {
                d.setQuantity(productMeasurement);
                d.setNetWeight(" : " + "Not Applied");
                d.setGrossWeight(" : " + "Not Applied");
            }
            if (twoPay_CheackBox.isSelected()) {
                d.setInvoiceType(" : TwoPay");
                d.setPendingAmount(" : " + totalAmount);
            }
            if (cashAndTwoPay_CheackBox.isSelected()) {
                d.setInvoiceType(" : Cash and TwoPay");
                d.setPendingAmount(" : " + twoPayAmount);
            }
            if (cash_CheackBox.isSelected()) {
                d.setInvoiceType(" : Cash");
                d.setPendingAmount(" : " + "NO");
            }
            d.setDriverName(" : " + driverName);
            d.setVehicleNumber(" : " + vehicleNumber);
            dataBeanList.add(d);
            new PrintDocumentJD(dataBeanList, QRCode, SRNO + "");
            com.JD.StaticData.Static_DATA.srNo_TEMP = SRNO;
        }
    }

    void update() {
        addDataToDataBase_Button.setText("Processing..");
        addDataToDataBase_Button.setEnabled(false);
        Session session = dm_SessionFactory.openSession();
        Criteria cr = session.createCriteria(com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm.class);

        cr.add(Restrictions.eq("srno", SRNO));
        cr.add(Restrictions.eq("qrcode", QRCode));
        List results = cr.list();

        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cant Update ! No Data Found For Sr No " + preSRNO + "-" + SRNO);
            reset();
        } else {
            Transaction transaction = session.beginTransaction();
            for (Object object : results) {
                com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm dm = (com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm) object;
                dm.setPartyLink(partyLink);
                dm.setProductName(productName);
                dm.setProductSize(productSize);
                dm.setProductValue(productValue);
                dm.setProductMeasurement(productMeasurement);
                dm.setTotalAmount(totalAmount);
                dm.setPayableAmount(payableAmount);
                dm.setPaymentType(paymentType);
                dm.setTwoPayAmount(twoPayAmount);
                dm.setDriverName(driverName);
                dm.setVehicleNumber(vehicleNumber);
                dm.setVehicleName(vehicleName);
                dm.setDateOfAddition(dateOfAddition);
                dm.setTimeOfAddition(timeOfAddition);
                dm.setRawField1(rawField1);
                if (pending_CheackBox.isSelected()) {
                    dm.setPendingStatus("TRUE");
                } else {
                    dm.setPendingStatus("FALSE");
                }
                session.save(dm);
                transaction.commit();
            }
            printReceipt();
        }
        session.close();
    }

    void cancel() {
    }

    void updatePendingStatus() {
        Session session = com.JD.StaticData.Static_DATA.init_SessionFactory.openSession();
        com.JD.StaticData.Static_DATA.flag3 = false;
        Criteria cr = session.createCriteria(com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm.class);
        cr.add(Restrictions.eq("pendingStatus", "TRUE"));
        List results = cr.list();
        pending_ComboBox.removeAllItems();
        pending_ComboBox.addItem("Load Pending Order");
        for (Object object : results) {
            com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm printreceiptdm = (com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm) object;
            pending_ComboBox.addItem(printreceiptdm.getSrno());
        }
        com.JD.StaticData.Static_DATA.flag3 = true;
        session.close();
    }

    boolean proxyTest() {
        String ntWtTemp = "";
        String grWtTemp = "";
        ntWtTemp = neightWeight_TextField.getText();
        grWtTemp = grossWeight_TextField.getText();
        if (ntWtTemp.equals("") || grWtTemp.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    boolean paymentOptionTest() {
        boolean internalFlag = false;
        if (cash_CheackBox.isSelected() || cashAndTwoPay_CheackBox.isSelected() || twoPay_CheackBox.isSelected()) {
            internalFlag = true;
        }
        return internalFlag;
    }

    void calculateAmount() {
        productSize = Integer.parseInt(size_ComboBox.getSelectedItem().toString());
        productValue = Integer.parseInt(value_TextField.getText());
        totalAmount = Integer.parseInt(totalAmount_TextField.getText());
        if (payAble_TextField.getText().equals("")) {
            twoPayAmount = Integer.parseInt(twoPayAmount_TextField.getText());
            payableAmount = 0;
        } else {
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
    }

    void updateSRNO() {
        Session session = initSessionFactory.openSession();
        Criteria cr = session.createCriteria(com.JD.InitData.Hibernate.config.Initdata.class);
        cr.add(Restrictions.eq("id", 1));
        List results = cr.list();
        Transaction transaction = session.beginTransaction();
        for (Object object : results) {
            com.JD.InitData.Hibernate.config.Initdata i = (com.JD.InitData.Hibernate.config.Initdata) object;
            com.JD.StaticData.Static_DATA.srNo = com.JD.StaticData.Static_DATA.srNo + 1;
            i.setSrNo(com.JD.StaticData.Static_DATA.srNo);
            srNo_Lable.setText(com.JD.StaticData.Static_DATA.prSrNo + "-" + com.JD.StaticData.Static_DATA.srNo + "");
            com.JD.StaticData.Static_DATA.dmSearch_srNo_ComboBox.addItem(com.JD.StaticData.Static_DATA.srNo + "");
            session.save(i);
        }
        transaction.commit();
        session.close();
    }

    public void reset() {
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
        vehicleName_TextField.setText("");
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
        clear_CheackBox.setEnabled(false);
        dm_date_Lable.setText(now.get(Calendar.DATE) + "-" + (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.YEAR));
        dm_time_Lable.setText(now.get(Calendar.HOUR) + ":" + now.get(Calendar.MINUTE));
        search_TextField.setText("Search.......");
        proxy_CheackBox.setSelected(false);
        flag4 = false;
        qrCodeTemp = "";
        payAble_TextField.setBackground(Color.lightGray);
        twoPayAmount_TextField.setBackground(Color.lightGray);
        neightWeight_TextField.setBackground(Color.lightGray);
        grossWeight_TextField.setBackground(Color.lightGray);
        addDataToDataBase_Button.setText("Place Order");
        pending_CheackBox.setSelected(false);
        addDataToDataBase_Button.setEnabled(true);
        srNo_Lable.setText(com.JD.StaticData.Static_DATA.prSrNo + "-" + com.JD.StaticData.Static_DATA.srNo + "");
        updatePendingStatus();
        resetJTable();
        currenTDate = new Date();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        datestring = dateFormat.format(currenTDate);
        com.JD.StaticData.Static_DATA.dM_Report.report("from com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm where dateOfAddition='" + datestring + "'");

    }

    public void resetJTable() {
        for (int i = defaultTableModel.getRowCount() - 1; i >= 0; i--) {
            defaultTableModel.removeRow(i);
        }
        Session session = dm_SessionFactory.openSession();
        Query q = session.createQuery("from com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm");
        indexJTable = -1;
        for (Object object : q.list()) {
            com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm d = (com.JD.PrintReceiptDM.Hibernate.config.Printreceiptdm) object;
            indexJTable += 1;
            defaultTableModel.insertRow(indexJTable, new Object[]{d.getSrno(), d.getPartyLink(), d.getProductName(), d.getProductSize(), d.getProductMeasurement(), d.getProductValue(), d.getTotalAmount(), d.getPaymentType(), d.getPayableAmount(), d.getTwoPayAmount(), d.getDriverName(), d.getVehicleNumber(), d.getVehicleName(), d.getDateOfAddition(), d.getTimeOfAddition(), d.getAddedByPersonName(), d.getPrintingStatus()});
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
    private javax.swing.JButton addDataToDataBase_Button;
    private javax.swing.JCheckBox cancel_CheackBox;
    private javax.swing.JCheckBox cashAndTwoPay_CheackBox;
    private javax.swing.ButtonGroup cashMode_ButtonGroup;
    private javax.swing.JCheckBox cash_CheackBox;
    private javax.swing.JCheckBox clear_CheackBox;
    private javax.swing.JTable dm_Table;
    private javax.swing.JLabel dm_date_Lable;
    private javax.swing.JLabel dm_time_Lable;
    private javax.swing.JComboBox driverName_ComboBox;
    private javax.swing.JButton export_Button;
    private javax.swing.JTextField grossWeight_TextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
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
    public javax.swing.JComboBox pending_ComboBox;
    private javax.swing.JLabel presrNo_Lable;
    private javax.swing.JButton print_Button;
    private javax.swing.JComboBox product_ComboBox;
    private javax.swing.JCheckBox proxy_CheackBox;
    private javax.swing.JButton reset_Button;
    private javax.swing.JTextField search_TextField;
    private javax.swing.JComboBox size_ComboBox;
    private javax.swing.JLabel srNo_Lable;
    private javax.swing.JTextField totalAmount_TextField;
    private javax.swing.JTextField twoPayAmount_TextField;
    private javax.swing.JCheckBox twoPay_CheackBox;
    private javax.swing.JCheckBox update_CheackBox;
    private javax.swing.JTextField value_TextField;
    private javax.swing.JTextField vehicleName_TextField;
    private javax.swing.JComboBox vehicleNumber_ComboBox;
    private javax.swing.JPanel webCan_Panel;
    // End of variables declaration//GEN-END:variables

    public JPanel getDM_Panel() {
        return DM_Panel;
    }
}

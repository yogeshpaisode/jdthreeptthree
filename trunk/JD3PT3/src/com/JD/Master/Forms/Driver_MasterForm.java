/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.Master.Forms;

import com.JD.Test.*;
import com.JD.Master.Forms.*;
import com.JD.Master.Hibernate.config.Drivermaster;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.InstantiationException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import org.apache.commons.codec.binary.Base64;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yogesh
 */
public class Driver_MasterForm extends javax.swing.JFrame {
    //--- File To Be Save ---//

    int i = 0;
    String prefix = "INPUT_";
    String outputPathTemp = "";
    URL defaultImageNameURL = getClass().getResource("default.jpg");
    Toolkit defaultImageNametk = Toolkit.getDefaultToolkit();
    Image defaultImage = defaultImageNametk.getImage(defaultImageNameURL);
    //--- File To Be Save ---//
    //---Call ImageCropper--//
    ImageCropper icroper = new ImageCropper();
    ImageIcon ico;
    BufferedImage bimg;
    //---Call ImageCropper--//
    //---- Add Data To Database----//
    String driverPartyLink = "";
    String driverName = "";
    String driverAddress = "";
    String driverMobile = "";
    String driverBloodGroup = "";
    Date driverDateOfJoining = null;
    String driverPic = "";
    Date driverDateOfAddition = null;
    Date driverTimeOfAddition = null;
    String driverLocation = com.JD.StaticData.Static_DATA.location;
    String driverAddedByPersonName = com.JD.StaticData.Static_DATA.logIn_UserName;
    String driverAddedWithRight = com.JD.StaticData.Static_DATA.logIn_Right;
    String rawField1 = "";
    String rawField2 = "";
    String rawField3 = "";
    String rawField4 = "";
    String rawField5 = "";
    String rawField6 = "";
    //---Add Data To Database--//
    //--- Add Date Panel---//
    JDatePickerImpl date1 = new com.JD.DatePicker.DatePicker().getDateObjectUp();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    //-- Add Date Panel---//
    //------ Load Session Factory ------//        
    SessionFactory driverSessionFactory = com.JD.StaticData.Static_DATA.master_SessionFactory;
    //------ Load Session Factory ------//    
    //----------javax.swing.DefaultComboBoxModel----//    
    javax.swing.table.DefaultTableModel defaultTableModel;
    int indexJTable = -1;
    //----------javax.swing.DefaultComboBoxModel----//

    /**
     * Creates new form Party_MasterForm
     */
    public Driver_MasterForm() {
        initComponents();
        defaultTableModel = (DefaultTableModel) driverTable.getModel();
        //------ Load PartyName and WebPanel From com.JD.StaticData.Static_DATA-----//
        com.JD.StaticData.Static_DATA.driverPartyName_ComboBox = driverPartyName_ComboBox;
        webCan_Panel.add(com.JD.StaticData.Static_DATA.webPanel);
        //------ Load PartyName and WebPanel From com.JD.StaticData.Static_DATA-----//

        //--- Add Calender To DatePanel_Panel----//
        datePanel_Panel.add(date1);
        //--- Add Calender To DatePanel_Panel----//

        //--- Load All Party Name ---//

        Session session = driverSessionFactory.openSession();
        Query q = session.createQuery("from com.JD.Master.Hibernate.config.Partymaster");
        for (Object object : q.list()) {
            com.JD.Master.Hibernate.config.Partymaster p = (com.JD.Master.Hibernate.config.Partymaster) object;
            driverPartyName_ComboBox.addItem(p.getPartyName());
        }
        session = driverSessionFactory.openSession();
        q = session.createQuery("from com.JD.Master.Hibernate.config.Drivermaster");

        for (Object object : q.list()) {
            com.JD.Master.Hibernate.config.Drivermaster d = (com.JD.Master.Hibernate.config.Drivermaster) object;
            loadDate_ComboBox.addItem(d.getDriverName());
            indexJTable += 1;
            defaultTableModel.insertRow(indexJTable, new Object[]{d.getDriverPartyLink(), d.getDriverName(), d.getDriverAddress(), d.getDriverMobile(), d.getDriverBloodGroup(), d.getDriverDateOfJoining(), d.getRawField1(), d.getDriverDateOfAddition(), d.getDriverTimeOfAddition(), d.getDriverAddedByPersonName(), d.getDriverAddedWithRight(), d.getDriverLocation()});
        }
        session.close();
        //--- Load All Party Name ---//
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
        driverMaster_Panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        driverPartyName_ComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        name_TextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        address_TextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        mobile_TextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bloodGroup_ComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        datePanel_Panel = new javax.swing.JPanel();
        webCan_Panel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        photo_Lable = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        licence_TextField = new javax.swing.JTextField();
        tack_Button = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        upload_Button = new javax.swing.JButton();
        loadDate_ComboBox = new javax.swing.JComboBox();
        update_CheackBox = new javax.swing.JCheckBox();
        delete_CheackBox = new javax.swing.JCheckBox();
        clear_CheackBox = new javax.swing.JCheckBox();
        addDataToDatbase_Button = new javax.swing.JButton();
        reset_Button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        driverTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        driverMaster_Panel.setBackground(new java.awt.Color(255, 255, 51));

        jLabel1.setText("* Party Name:");

        driverPartyName_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Party Name" }));

        jLabel2.setText("* Driver Name:");

        jLabel3.setText("* Address:");

        address_TextArea.setColumns(20);
        address_TextArea.setLineWrap(true);
        address_TextArea.setRows(5);
        jScrollPane2.setViewportView(address_TextArea);

        jLabel4.setText("* Mobile Number:");

        jLabel5.setText("* Blood Group:");

        bloodGroup_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Blood Group", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));

        jLabel6.setText("* Date Of Joining:");

        javax.swing.GroupLayout datePanel_PanelLayout = new javax.swing.GroupLayout(datePanel_Panel);
        datePanel_Panel.setLayout(datePanel_PanelLayout);
        datePanel_PanelLayout.setHorizontalGroup(
            datePanel_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        datePanel_PanelLayout.setVerticalGroup(
            datePanel_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        webCan_Panel.setBackground(new java.awt.Color(255, 255, 51));
        webCan_Panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 2, true));

        javax.swing.GroupLayout webCan_PanelLayout = new javax.swing.GroupLayout(webCan_Panel);
        webCan_Panel.setLayout(webCan_PanelLayout);
        webCan_PanelLayout.setHorizontalGroup(
            webCan_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        webCan_PanelLayout.setVerticalGroup(
            webCan_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        jLabel7.setText("* Photo:");

        photo_Lable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/Master/Forms/default.jpg"))); // NOI18N
        photo_Lable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));

        jLabel8.setText("* Driving Licence No:");

        tack_Button.setText("Tack Image");
        tack_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tack_ButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("OR");

        upload_Button.setText("Upload Image");
        upload_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upload_ButtonActionPerformed(evt);
            }
        });

        loadDate_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Load Data To Update" }));

        operation_ButtonGroup.add(update_CheackBox);
        update_CheackBox.setText("Update Driver");
        update_CheackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_CheackBoxActionPerformed(evt);
            }
        });

        operation_ButtonGroup.add(delete_CheackBox);
        delete_CheackBox.setText("Delete Driver");
        delete_CheackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_CheackBoxActionPerformed(evt);
            }
        });

        operation_ButtonGroup.add(clear_CheackBox);
        clear_CheackBox.setText("Clear");
        clear_CheackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_CheackBoxActionPerformed(evt);
            }
        });

        addDataToDatbase_Button.setText("Add Driver");
        addDataToDatbase_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDataToDatbase_ButtonActionPerformed(evt);
            }
        });

        reset_Button.setText("Reset");
        reset_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_ButtonActionPerformed(evt);
            }
        });

        driverTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Party Name", "Driver Name", "Address", "Mobile", "Blood Group", "DOJ", "Licence No", "DOA/U", "TOA/U", "Added By", "Added With Right", "Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(driverTable);

        javax.swing.GroupLayout driverMaster_PanelLayout = new javax.swing.GroupLayout(driverMaster_Panel);
        driverMaster_Panel.setLayout(driverMaster_PanelLayout);
        driverMaster_PanelLayout.setHorizontalGroup(
            driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(driverMaster_PanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(59, 59, 59)
                .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(name_TextField)
                    .addComponent(driverPartyName_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datePanel_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(photo_Lable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(driverMaster_PanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(308, 308, 308))
                    .addGroup(driverMaster_PanelLayout.createSequentialGroup()
                        .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(driverMaster_PanelLayout.createSequentialGroup()
                                .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(update_CheackBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addDataToDatbase_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(delete_CheackBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(reset_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(clear_CheackBox)
                                .addGap(2, 2, Short.MAX_VALUE))
                            .addGroup(driverMaster_PanelLayout.createSequentialGroup()
                                .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addGap(11, 11, 11)
                                .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(driverMaster_PanelLayout.createSequentialGroup()
                                        .addComponent(bloodGroup_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(8, 8, 8))
                                    .addGroup(driverMaster_PanelLayout.createSequentialGroup()
                                        .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(mobile_TextField)
                                            .addComponent(licence_TextField)
                                            .addComponent(loadDate_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                        .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(webCan_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tack_Button, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                            .addComponent(upload_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(162, 162, 162))))
            .addComponent(jScrollPane1)
        );
        driverMaster_PanelLayout.setVerticalGroup(
            driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, driverMaster_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(driverMaster_PanelLayout.createSequentialGroup()
                        .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(driverPartyName_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loadDate_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(driverMaster_PanelLayout.createSequentialGroup()
                                .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datePanel_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(driverMaster_PanelLayout.createSequentialGroup()
                                .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(mobile_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bloodGroup_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, driverMaster_PanelLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(6, 6, 6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(licence_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(photo_Lable, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, driverMaster_PanelLayout.createSequentialGroup()
                                .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(update_CheackBox)
                                    .addComponent(delete_CheackBox)
                                    .addComponent(clear_CheackBox)
                                    .addComponent(upload_Button))
                                .addGap(26, 26, 26)
                                .addGroup(driverMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addDataToDatbase_Button)
                                    .addComponent(reset_Button)))))
                    .addGroup(driverMaster_PanelLayout.createSequentialGroup()
                        .addComponent(webCan_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tack_Button)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(driverMaster_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(driverMaster_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tack_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tack_ButtonActionPerformed
        // TODO add your handling code here:
        i++;
        try {
            String inputPathTemp = "temp/" + prefix + i + ".jpg";
            ImageIO.write(com.JD.StaticData.Static_DATA.webcam.getImage(), "JPG", new File(inputPathTemp));
            outputPathTemp = icroper.processImage(inputPathTemp);
            ico = new ImageIcon(outputPathTemp);
            photo_Lable.setIcon(ico);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tack_ButtonActionPerformed

    private void upload_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upload_ButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        String path = "";

        switch (fc.showOpenDialog(this)) {
            case JFileChooser.APPROVE_OPTION:
                path = fc.getSelectedFile() + "";
                ico = new ImageIcon(path);
                try {
                    bimg = ImageIO.read(new File(path));
                    int width = bimg.getWidth();
                    int height = bimg.getHeight();
//---------------------------------Decide Image Width Height--------------------------------------------------------------------------------                    
                    if (width >= 200 && height >= 200) {
                        JOptionPane.showMessageDialog(null, "Image is too big");
                    } else {
                        photo_Lable.setIcon(ico);
                        outputPathTemp = path;
                    }
//---------------------------------Decide Image Width Height--------------------------------------------------------------------------------                    

                } catch (Exception e) {
                }



                break;

            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(this, "Cancelled",
                        "Cancel",
                        JOptionPane.OK_OPTION);
                break;

            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(this, "Error",
                        "Error",
                        JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_upload_ButtonActionPerformed

    private void reset_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_ButtonActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_reset_ButtonActionPerformed

    private void update_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_CheackBoxActionPerformed
        // TODO add your handling code here:
        if (update_CheackBox.isSelected()) {
            addDataToDatbase_Button.setText("Update Driver");
        }
    }//GEN-LAST:event_update_CheackBoxActionPerformed

    private void delete_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_CheackBoxActionPerformed
        // TODO add your handling code here:
        if (delete_CheackBox.isSelected()) {
            addDataToDatbase_Button.setText("Delete Driver");
        }
    }//GEN-LAST:event_delete_CheackBoxActionPerformed

    private void addDataToDatbase_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDataToDatbase_ButtonActionPerformed
        // TODO add your handling code here:
        try {
            driverPartyLink = driverPartyName_ComboBox.getSelectedItem().toString();
            driverName = name_TextField.getText();
            driverAddress = address_TextArea.getText();
            driverMobile = mobile_TextField.getText();
            driverBloodGroup = bloodGroup_ComboBox.getSelectedItem().toString();
            rawField1 = licence_TextField.getText();
            int month1 = 0;
            if (date1.getModel().getMonth() == 12) {
                month1 = 1;
            } else {
                month1 = date1.getModel().getMonth() + 1;
            }
            String dateOfAdditionTemp = date1.getModel().getDay() + "-" + month1 + "-" + date1.getModel().getYear();
            driverDateOfJoining = formatter.parse(dateOfAdditionTemp);
            driverDateOfAddition = new Date();
            driverTimeOfAddition = new Date();

            if (driverPartyLink.equals("Select Party Name")) {
                JOptionPane.showMessageDialog(null, "Please Provide Party Name");
            } else {
                if (driverName.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Provide Driver Name");
                } else {
                    if (driverMobile.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please Provide Driver Mobile Number");
                    } else {
                        if (driverAddress.equals("")) {
                            JOptionPane.showMessageDialog(null, "Please Provide Driver Address");
                        } else {
                            if (driverBloodGroup.equals("Select Blood Group")) {
                                JOptionPane.showMessageDialog(null, "Please Provide Driver Blood Group");
                            } else {
                                if (rawField1.equals("")) {
                                    JOptionPane.showMessageDialog(null, "Please Provide Driving Licence Number");
                                } else {
                                    if (outputPathTemp.equals("")) {
                                        JOptionPane.showMessageDialog(null, "Please Provide Driving Image");
                                    } else {
                                        driverPic = convertImageToString(outputPathTemp);
                                        if (update_CheackBox.isSelected()) {
                                            update();
                                        } else if (delete_CheackBox.isSelected()) {
                                            delete();
                                        } else {
                                            insert();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Internal Error : Please Contact Your Vender..");
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_addDataToDatbase_ButtonActionPerformed

    private void clear_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_CheackBoxActionPerformed
        // TODO add your handling code here:
        if (clear_CheackBox.isSelected()) {
            addDataToDatbase_Button.setText("Add Driver");
        }

    }//GEN-LAST:event_clear_CheackBoxActionPerformed

    void insert() {
        Session session = driverSessionFactory.openSession();
        Criteria cr = session.createCriteria(com.JD.Master.Hibernate.config.Drivermaster.class);
        cr.add(Restrictions.eq("driverName", driverName));
        List results = cr.list();
        if (results.isEmpty()) {
            Transaction transaction = session.beginTransaction();
            com.JD.Master.Hibernate.config.Drivermaster d = new Drivermaster(driverPartyLink, driverName, driverAddress, driverMobile, driverBloodGroup, driverDateOfJoining, driverPic, driverDateOfAddition, driverTimeOfAddition, driverLocation, driverAddedByPersonName, driverAddedWithRight, rawField1, rawField2, rawField3, rawField4, rawField5, rawField6);
            session.save(d);
            transaction.commit();
            reset();
            resetJTable();
            loadDate_ComboBox.addItem(driverName);
            JOptionPane.showMessageDialog(null, "Driver Name " + driverName + " Added Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Driver Name " + driverName + " Already Exist");
        }
        session.close();
    }

    void update() {
        Session session = driverSessionFactory.openSession();
        Criteria cr = session.createCriteria(com.JD.Master.Hibernate.config.Drivermaster.class);
        cr.add(Restrictions.eq("driverName", driverName));
        List results = cr.list();
        for (Object object : results) {
            com.JD.Master.Hibernate.config.Drivermaster d = (com.JD.Master.Hibernate.config.Drivermaster) object;
        }
        Transaction transaction = session.beginTransaction();
        session.close();
        reset();
    }

    void delete() {
    }

    private String convertImageToString(String path) {

        InputStream inputStream = null;

        String imageString = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {

            inputStream = new FileInputStream(path);

            byte[] buffer = new byte[1024];
            baos = new ByteArrayOutputStream();

            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            imageString = Base64.encodeBase64String(imageBytes);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return imageString;
    }

    void resetJTable() {
        for (int i = defaultTableModel.getRowCount() - 1; i >= 0; i--) {
            defaultTableModel.removeRow(i);
        }
        indexJTable = -1;
        Session session = driverSessionFactory.openSession();
        Query q = session.createQuery("from com.JD.Master.Hibernate.config.Drivermaster");
        for (Object object : q.list()) {
            com.JD.Master.Hibernate.config.Drivermaster d = (com.JD.Master.Hibernate.config.Drivermaster) object;
            loadDate_ComboBox.addItem(d.getDriverName());
            indexJTable += 1;
            defaultTableModel.insertRow(indexJTable, new Object[]{d.getDriverPartyLink(), d.getDriverName(), d.getDriverAddress(), d.getDriverMobile(), d.getDriverBloodGroup(), d.getDriverDateOfJoining(), d.getRawField1(), d.getDriverDateOfAddition(), d.getDriverTimeOfAddition(), d.getDriverAddedByPersonName(), d.getDriverAddedWithRight(), d.getDriverLocation()});
        }
        session.close();
    }

    void reset() {
        ico = new ImageIcon(defaultImage);
        photo_Lable.setIcon(ico);
        outputPathTemp = "";
        driverPartyName_ComboBox.setSelectedItem("Select Party Name");
        name_TextField.setText("");
        mobile_TextField.setText("");
        address_TextArea.setText("");
        bloodGroup_ComboBox.setSelectedItem("Select Blood Group");
        licence_TextField.setText("");
        operation_ButtonGroup.clearSelection();
        addDataToDatbase_Button.setText("Add Driver");
        loadDate_ComboBox.setSelectedItem("Load Data To Update");

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
            java.util.logging.Logger.getLogger(Driver_MasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Driver_MasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Driver_MasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Driver_MasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Driver_MasterForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDataToDatbase_Button;
    private javax.swing.JTextArea address_TextArea;
    private javax.swing.JComboBox bloodGroup_ComboBox;
    private javax.swing.JCheckBox clear_CheackBox;
    private javax.swing.JPanel datePanel_Panel;
    private javax.swing.JCheckBox delete_CheackBox;
    public javax.swing.JPanel driverMaster_Panel;
    private javax.swing.JComboBox driverPartyName_ComboBox;
    private javax.swing.JTable driverTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField licence_TextField;
    private javax.swing.JComboBox loadDate_ComboBox;
    private javax.swing.JTextField mobile_TextField;
    private javax.swing.JTextField name_TextField;
    private javax.swing.ButtonGroup operation_ButtonGroup;
    private javax.swing.JLabel photo_Lable;
    private javax.swing.JButton reset_Button;
    private javax.swing.JButton tack_Button;
    private javax.swing.JCheckBox update_CheackBox;
    private javax.swing.JButton upload_Button;
    private javax.swing.JPanel webCan_Panel;
    // End of variables declaration//GEN-END:variables
}

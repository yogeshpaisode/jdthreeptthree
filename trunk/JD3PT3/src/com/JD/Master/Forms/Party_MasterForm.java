/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.Master.Forms;

import com.JD.Master.Hibernate.config.Partymaster;
import com.JD.Validator.Validator;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yogesh
 */
public class Party_MasterForm extends javax.swing.JFrame {

    int indexJTable = -1;
    javax.swing.table.DefaultTableModel defaultTableModel;
    //---- Data For Database ----//    
    String partyName = "";
    String partyAddress = "";
    String partyCity = "";
    String partyPhone = "";
    String partyMobile = "";
    String partyEmail = "";
    String partyLocation = com.JD.StaticData.Static_DATA.location;
    String partyAddedByPersonName = com.JD.StaticData.Static_DATA.logIn_UserName;
    String partyAddedWithRight = com.JD.StaticData.Static_DATA.logIn_Right;
    String rawField1 = "OTHER";
    String rawField2 = "";
    String rawField3 = "";
    String rawField4 = "";
    String rawField5 = "";
    String rawField6 = "";
    Date partyDateOfAddition = null;
    Date partyTimeOfAddition = null;
    //---- Data For Database ----//
    //---- Flag---//
    boolean flag = false;
    //---- Flag---//
    //---- Validator ----//
    com.JD.Validator.Validator valid = new Validator();
    //---- Validator ----//

    /**
     * Creates new form Party_MasterForm
     */
    public Party_MasterForm() {
        initComponents();
        defaultTableModel = (DefaultTableModel) party_Table.getModel();
        //--- Load Data To JTable And party_ComboBox---//
        // Replace :  com.JD.StaticData.Static_DATA.init_SessionFactory.openSession();

        Session session =  com.JD.StaticData.Static_DATA.init_SessionFactory.openSession();

        Query q = session.createQuery("from com.JD.Master.Hibernate.config.Partymaster");
        List list = q.list();

        for (Object object : list) {
            com.JD.Master.Hibernate.config.Partymaster p = (com.JD.Master.Hibernate.config.Partymaster) object;
            name_ComboBox.addItem(p.getPartyName());
            indexJTable = indexJTable + 1;
            defaultTableModel.insertRow(indexJTable, new Object[]{p.getPartyName(), p.getPartyAddress(), p.getPartyCity(), p.getPartyCity(), p.getPartyPhone(), p.getPartyEmail(), p.getPartyAddedByPersonName(), p.getPartyAddedWithRight(), p.getPartyDateOfAddition(), p.getPartyTimeOfAddition(), p.getPartyLocation()});
        }

        session.close();
        flag = true;


        //--- Load Data To JTable And party_ComboBox---//

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modification_ButtonGroup = new javax.swing.ButtonGroup();
        partyMaster_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        party_Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        name_TextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        address_TextField = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        phone_TextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mobile_TextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        city_TextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        emailID_TextField = new javax.swing.JTextField();
        name_ComboBox = new javax.swing.JComboBox();
        updateData_CheacBox = new javax.swing.JCheckBox();
        deleteData_CheacBox = new javax.swing.JCheckBox();
        addDataToDatabas_Button = new javax.swing.JButton();
        clear_CheackBox = new javax.swing.JCheckBox();
        reset_Button = new javax.swing.JButton();
        exportToExcel_Button = new javax.swing.JButton();
        print_Button = new javax.swing.JButton();
        search_TextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        partyMaster_Panel.setBackground(new java.awt.Color(255, 255, 51));

        party_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Party Name", "Address", "City", "Mobile", "Phone", "Email ID", "Added By", "User Right", "DOA/U", "TOA/U", "Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(party_Table);

        jLabel1.setText("* Party Name : ");

        name_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_TextFieldActionPerformed(evt);
            }
        });
        name_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                name_TextFieldKeyReleased(evt);
            }
        });

        jLabel2.setText("* Address :");

        address_TextField.setColumns(20);
        address_TextField.setLineWrap(true);
        address_TextField.setRows(5);
        address_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                address_TextFieldKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(address_TextField);

        jLabel3.setText("* Phone : ");

        phone_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phone_TextFieldKeyReleased(evt);
            }
        });

        jLabel4.setText("Mobile Number :");

        mobile_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mobile_TextFieldKeyReleased(evt);
            }
        });

        jLabel6.setText("* City :");

        city_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                city_TextFieldKeyReleased(evt);
            }
        });

        jLabel7.setText("Email ID :");

        name_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Party Name" }));
        name_ComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                name_ComboBoxItemStateChanged(evt);
            }
        });
        name_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_ComboBoxActionPerformed(evt);
            }
        });

        modification_ButtonGroup.add(updateData_CheacBox);
        updateData_CheacBox.setText("Update Data");
        updateData_CheacBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateData_CheacBoxActionPerformed(evt);
            }
        });

        modification_ButtonGroup.add(deleteData_CheacBox);
        deleteData_CheacBox.setText("Delete Data");
        deleteData_CheacBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteData_CheacBoxActionPerformed(evt);
            }
        });

        addDataToDatabas_Button.setText("Add Data");
        addDataToDatabas_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDataToDatabas_ButtonActionPerformed(evt);
            }
        });

        modification_ButtonGroup.add(clear_CheackBox);
        clear_CheackBox.setText("Clear");
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

        exportToExcel_Button.setText("Export To Excel");
        exportToExcel_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportToExcel_ButtonActionPerformed(evt);
            }
        });

        print_Button.setText("Print");
        print_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_ButtonActionPerformed(evt);
            }
        });

        search_TextField.setText("Search..................");
        search_TextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 1, true));
        search_TextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_TextFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                search_TextFieldMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                search_TextFieldMousePressed(evt);
            }
        });
        search_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_TextFieldKeyReleased(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/Home/down.jpg"))); // NOI18N
        jLabel5.setText(" Enter Party Name To Search");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        javax.swing.GroupLayout partyMaster_PanelLayout = new javax.swing.GroupLayout(partyMaster_Panel);
        partyMaster_Panel.setLayout(partyMaster_PanelLayout);
        partyMaster_PanelLayout.setHorizontalGroup(
            partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
            .addGroup(partyMaster_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(partyMaster_PanelLayout.createSequentialGroup()
                        .addComponent(updateData_CheacBox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(deleteData_CheacBox, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(clear_CheackBox, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                    .addComponent(name_TextField)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phone_TextField)
                    .addComponent(city_TextField)
                    .addComponent(name_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, partyMaster_PanelLayout.createSequentialGroup()
                        .addComponent(addDataToDatabas_Button, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(reset_Button)))
                .addGap(18, 18, 18)
                .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mobile_TextField)
                    .addComponent(emailID_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addGroup(partyMaster_PanelLayout.createSequentialGroup()
                        .addComponent(exportToExcel_Button)
                        .addGap(18, 18, 18)
                        .addComponent(print_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(search_TextField))
                .addContainerGap())
        );
        partyMaster_PanelLayout.setVerticalGroup(
            partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, partyMaster_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(name_ComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(partyMaster_PanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(partyMaster_PanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(partyMaster_PanelLayout.createSequentialGroup()
                                .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(phone_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(mobile_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(city_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(emailID_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(updateData_CheacBox)
                        .addComponent(deleteData_CheacBox)
                        .addComponent(clear_CheackBox))
                    .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addDataToDatabas_Button)
                        .addComponent(reset_Button))
                    .addGroup(partyMaster_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(exportToExcel_Button)
                        .addComponent(print_Button)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(partyMaster_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(partyMaster_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateData_CheacBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateData_CheacBoxActionPerformed
        // TODO add your handling code here:

        if (updateData_CheacBox.isSelected()) {
            addDataToDatabas_Button.setText("Update Data");
        }
    }//GEN-LAST:event_updateData_CheacBoxActionPerformed

    private void deleteData_CheacBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteData_CheacBoxActionPerformed
        // TODO add your handling code here:
        if (deleteData_CheacBox.isSelected()) {
            addDataToDatabas_Button.setText("Delete Data");
        }
    }//GEN-LAST:event_deleteData_CheacBoxActionPerformed

    private void clear_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_CheackBoxActionPerformed
        // TODO add your handling code here: Add Data

        if (clear_CheackBox.isSelected()) {
            addDataToDatabas_Button.setText("Add Data");
        }
    }//GEN-LAST:event_clear_CheackBoxActionPerformed

    private void addDataToDatabas_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDataToDatabas_ButtonActionPerformed
        // TODO add your handling code here:
        partyName = name_TextField.getText();
        partyAddress = address_TextField.getText();
        partyCity = city_TextField.getText();
        partyPhone = phone_TextField.getText();
        partyMobile = mobile_TextField.getText();
        partyEmail = emailID_TextField.getText();
        rawField1 = "Not Inserted";
        rawField2 = "Not Inserted";
        rawField3 = "Not Inserted";
        rawField4 = "Not Inserted";
        rawField5 = "Not Inserted";
        rawField6 = "Not Inserted";
        partyDateOfAddition = new Date();
        partyTimeOfAddition = new Date();



        if (partyName.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Provide Party Name");
        } else {
            if (partyAddress.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Provide Address");
            } else {
                if (partyCity.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Provide City");
                } else {
                    if (partyPhone.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please Provide Phone");
                    } else {
                        //---- Business Logic ----//

                        if (updateData_CheacBox.isSelected()) {
                            update();
                        } else if (deleteData_CheacBox.isSelected()) {
                            delete();
                        } else {
                            insert();
                        }

                        //---- Business Logic ----//
                    }
                }
            }
        }



    }//GEN-LAST:event_addDataToDatabas_ButtonActionPerformed

    private void name_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_ComboBoxActionPerformed
        // TODO add your handling code here:

        if (flag == true) {
            String partName = name_ComboBox.getSelectedItem().toString();

            // Replace :  com.JD.StaticData.Static_DATA.init_SessionFactory.openSession();
            Session session =  com.JD.StaticData.Static_DATA.init_SessionFactory.openSession();

            Criteria cr = session.createCriteria(com.JD.Master.Hibernate.config.Partymaster.class);
            cr.add(Restrictions.eq("partyName", partName));
            List results = cr.list();

            for (Object object : results) {
                com.JD.Master.Hibernate.config.Partymaster p = (com.JD.Master.Hibernate.config.Partymaster) object;

                name_TextField.setText(p.getPartyName());
                address_TextField.setText(p.getPartyAddress());
                phone_TextField.setText(p.getPartyPhone());
                mobile_TextField.setText(p.getPartyMobile());
                emailID_TextField.setText(p.getPartyEmail());
                city_TextField.setText(p.getPartyCity());

            }
            session.close();
        }



    }//GEN-LAST:event_name_ComboBoxActionPerformed

    private void name_ComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_name_ComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_name_ComboBoxItemStateChanged

    private void name_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_TextFieldActionPerformed

    private void name_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name_TextFieldKeyReleased
        // TODO add your handling code here:
        name_TextField.setText(valid.stringValidator(name_TextField.getText().toUpperCase()));
    }//GEN-LAST:event_name_TextFieldKeyReleased

    private void address_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_address_TextFieldKeyReleased
        // TODO add your handling code here:
        address_TextField.setText(address_TextField.getText().toUpperCase());
    }//GEN-LAST:event_address_TextFieldKeyReleased

    private void phone_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phone_TextFieldKeyReleased
        // TODO add your handling code here:
        phone_TextField.setText(valid.intTypeNumberValidator(phone_TextField.getText()));
    }//GEN-LAST:event_phone_TextFieldKeyReleased

    private void city_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_city_TextFieldKeyReleased
        // TODO add your handling code here:
        city_TextField.setText(valid.stringValidator(city_TextField.getText().toUpperCase()));
    }//GEN-LAST:event_city_TextFieldKeyReleased

    private void mobile_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobile_TextFieldKeyReleased
        // TODO add your handling code here:
        mobile_TextField.setText(valid.intTypeNumberValidator(mobile_TextField.getText()));
    }//GEN-LAST:event_mobile_TextFieldKeyReleased

    private void reset_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_ButtonActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_reset_ButtonActionPerformed

    private void print_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_ButtonActionPerformed
        // TODO add your handling code here:
        try {
            party_Table.print();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Printer Error,Can't Print.");
        }
    }//GEN-LAST:event_print_ButtonActionPerformed

    private void exportToExcel_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportToExcel_ButtonActionPerformed
        // TODO add your handling code here:  party_Table

        new com.JD.ExportToExcel.ExportToExcel().saveToExcel(party_Table);

    }//GEN-LAST:event_exportToExcel_ButtonActionPerformed

    private void search_TextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_TextFieldMouseClicked
        // TODO add your handling code here:
        search_TextField.setText("");
    }//GEN-LAST:event_search_TextFieldMouseClicked

    private void search_TextFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_TextFieldMouseEntered
        // TODO add your handling code here:
        search_TextField.setText("");
    }//GEN-LAST:event_search_TextFieldMouseEntered

    private void search_TextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_TextFieldMousePressed
        // TODO add your handling code here:
        search_TextField.setText("");
    }//GEN-LAST:event_search_TextFieldMousePressed

    private void search_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_TextFieldKeyReleased
        // TODO add your handling code here:

        String pName = search_TextField.getText().toUpperCase() + "%";
        search_TextField.setText(search_TextField.getText().toUpperCase());
        resetJtableOnSEARCH();
        indexJTable = -1;
        String partName = name_ComboBox.getSelectedItem().toString();

        // Replace :  com.JD.StaticData.Static_DATA.init_SessionFactory.openSession();
        Session session =  com.JD.StaticData.Static_DATA.init_SessionFactory.openSession();

        Criteria cr = session.createCriteria(com.JD.Master.Hibernate.config.Partymaster.class);
        cr.add(Restrictions.like("partyName", pName));
        List results = cr.list();
        //JOptionPane.showMessageDialog(null,results.size());
        for (Object object : results) {
            com.JD.Master.Hibernate.config.Partymaster p = (com.JD.Master.Hibernate.config.Partymaster) object;
            indexJTable = indexJTable + 1;
            defaultTableModel.insertRow(indexJTable, new Object[]{p.getPartyName(), p.getPartyAddress(), p.getPartyCity(), p.getPartyCity(), p.getPartyPhone(), p.getPartyEmail(), p.getPartyAddedByPersonName(), p.getPartyAddedWithRight(), p.getPartyDateOfAddition(), p.getPartyTimeOfAddition(), p.getPartyLocation()});
        }
        session.close();


    }//GEN-LAST:event_search_TextFieldKeyReleased

    void resetJtableOnSEARCH() {

        for (int i = defaultTableModel.getRowCount() - 1; i >= 0; i--) {
            defaultTableModel.removeRow(i);
        }

    }

    void reset() {
        name_TextField.setText("");
        address_TextField.setText("");
        city_TextField.setText("");
        phone_TextField.setText("");
        mobile_TextField.setText("");
        emailID_TextField.setText("");
        modification_ButtonGroup.clearSelection();
        name_ComboBox.setSelectedIndex(0);
        search_TextField.setText("Search..................");
        

    }

    void insert() {

        // Replace :  com.JD.StaticData.Static_DATA.init_SessionFactory.openSession();
        Session session =  com.JD.StaticData.Static_DATA.init_SessionFactory.openSession();


        Criteria cr = session.createCriteria(com.JD.Master.Hibernate.config.Partymaster.class);
        cr.add(Restrictions.eq("partyName", partyName));
        List results = cr.list();

        if (results.isEmpty()) {
            Transaction transaction = session.beginTransaction();
            com.JD.Master.Hibernate.config.Partymaster p = new Partymaster(partyName, partyAddress, partyCity, partyPhone, partyMobile, partyEmail, partyDateOfAddition, partyTimeOfAddition, partyLocation, partyAddedByPersonName, partyAddedWithRight, rawField1, rawField2, rawField3, rawField4, rawField5, rawField6);
            session.save(p);
            transaction.commit();

            indexJTable = indexJTable + 1;
            defaultTableModel.insertRow(indexJTable, new Object[]{partyName, partyAddress, partyCity, partyMobile, partyPhone, partyEmail, partyAddedByPersonName, partyAddedWithRight, partyDateOfAddition, partyTimeOfAddition, partyLocation});
            JOptionPane.showMessageDialog(null, "Party " + partyName + " Added Successfully..");
            //--- Update Party Name Combobox ---//
            name_ComboBox.addItem(partyName);
            //--- Update Party Name Combobox ---//
            
            //---Fill JComboboxes from com.JD.StaticData.Static_DATA Class ---//
            com.JD.StaticData.Static_DATA.machinePartyName_ComboBox.addItem(partyName);
            com.JD.StaticData.Static_DATA.driverPartyName_ComboBox.addItem(partyName);
            com.JD.StaticData.Static_DATA.dm_PartyName.addItem(partyName);
            com.JD.StaticData.Static_DATA.partyName_Sell_ComboBox.addItem(partyName);
            com.JD.StaticData.Static_DATA.dmSearch_party_ComboBox.addItem(partyName);
            //---Fill JComboboxes from com.JD.StaticData.Static_DATA Class ---//     
                        
            reset();
            resetJTable();
        } else {
            JOptionPane.showMessageDialog(null, "Entry " + partyName + " Already Exist..");
        }
        session.close();

    }

    void update() {

        // Replace :  com.JD.StaticData.Static_DATA.init_SessionFactory.openSession();
        Session session =  com.JD.StaticData.Static_DATA.init_SessionFactory.openSession();
        Criteria cr = session.createCriteria(com.JD.Master.Hibernate.config.Partymaster.class);
        cr.add(Restrictions.eq("partyName", partyName));

        if (partyName.equals(com.JD.StaticData.Static_DATA.selfPartyname)) {
            rawField1 = "SELF";
        }
        partyDateOfAddition = new Date();
        partyTimeOfAddition = new Date();
        List results = cr.list();

        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Data Present For Party Name " + partyName + " Already Exist..");
        } else {
            Transaction transaction = session.beginTransaction();

            for (Object object : results) {
                com.JD.Master.Hibernate.config.Partymaster p = (com.JD.Master.Hibernate.config.Partymaster) object;

                p.setPartyName(partyName);
                p.setPartyAddress(partyAddress);
                p.setPartyPhone(partyPhone);
                p.setPartyMobile(partyMobile);
                p.setPartyCity(partyCity);
                p.setPartyEmail(partyEmail);
                p.setPartyDateOfAddition(partyDateOfAddition);
                p.setPartyTimeOfAddition(partyTimeOfAddition);

                session.save(p);
            }

            transaction.commit();

            JOptionPane.showMessageDialog(null, "Entry " + partyName + " Updated Successfully..");

            reset();
            resetJTable();

        }
        session.close();
    }

    void resetJTable() {

        flag = false;
        indexJTable = -1;
        for (int i = defaultTableModel.getRowCount() - 1; i >= 0; i--) {
            defaultTableModel.removeRow(i);
        }
        //--- Load Data To JTable And party_ComboBox---//
        // Replace :  com.JD.StaticData.Static_DATA.init_SessionFactory.openSession();

        Session session =  com.JD.StaticData.Static_DATA.init_SessionFactory.openSession();
        name_ComboBox.removeAllItems();
        name_ComboBox.addItem("Select Party Name");
        Query q = session.createQuery("from com.JD.Master.Hibernate.config.Partymaster");
        List list = q.list();

        for (Object object : list) {
            com.JD.Master.Hibernate.config.Partymaster p = (com.JD.Master.Hibernate.config.Partymaster) object;
            name_ComboBox.addItem(p.getPartyName());
            indexJTable = indexJTable + 1;
            defaultTableModel.insertRow(indexJTable, new Object[]{p.getPartyName(), p.getPartyAddress(), p.getPartyCity(), p.getPartyCity(), p.getPartyPhone(), p.getPartyEmail(), p.getPartyAddedByPersonName(), p.getPartyAddedWithRight(), p.getPartyDateOfAddition(), p.getPartyTimeOfAddition(), p.getPartyLocation()});
        }
        session.close();
        flag = true;
    }

    void delete() {
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
            java.util.logging.Logger.getLogger(Party_MasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Party_MasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Party_MasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Party_MasterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Party_MasterForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDataToDatabas_Button;
    private javax.swing.JTextArea address_TextField;
    private javax.swing.JTextField city_TextField;
    private javax.swing.JCheckBox clear_CheackBox;
    private javax.swing.JCheckBox deleteData_CheacBox;
    private javax.swing.JTextField emailID_TextField;
    private javax.swing.JButton exportToExcel_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mobile_TextField;
    private javax.swing.ButtonGroup modification_ButtonGroup;
    private javax.swing.JComboBox name_ComboBox;
    private javax.swing.JTextField name_TextField;
    public javax.swing.JPanel partyMaster_Panel;
    private javax.swing.JTable party_Table;
    private javax.swing.JTextField phone_TextField;
    private javax.swing.JButton print_Button;
    private javax.swing.JButton reset_Button;
    private javax.swing.JTextField search_TextField;
    private javax.swing.JCheckBox updateData_CheacBox;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.Setting;

import com.JD.Validator.Validator;
import java.lang.InstantiationException;
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
public class UpdateUserInformation extends javax.swing.JFrame {

    boolean flag1 = true;
    boolean flag2 = true;
    //----------Call Validator---------------//
    com.JD.Validator.Validator validator = new Validator();
    //----------Call Validator---------------//
    //---------Init Session Factory----------//
    SessionFactory init_SessionFactory = com.JD.StaticData.Static_DATA.init_SessionFactory;
    //---------Init Session Factory----------//
    int priority = 0;
    //---------------Load Data For Database------------------//
    String userName = "";
    String userId = "";
    String userPassword = "";
    int userPriority = 0;
    String userEmail = "";
    String userMob = "";
    String userAddress = "";
    String passwordTemp = "";
    String passwordSymbolTemp = "";
    Date userDateOfAddition = null;
    Date userTimeOfAddition = null;
    String userLocation = com.JD.StaticData.Static_DATA.location;
    String userAddedByPersonName = com.JD.StaticData.Static_DATA.logIn_UserName;
    String userAddedWithRight = com.JD.StaticData.Static_DATA.logIn_Right;
    //--------Bacup--------------------//
    String userIDBackup = "";
    String passwordBackup = "";
    //--------Bacup--------------------//
    javax.swing.table.DefaultTableModel defaultTableModel;

    //---------------Load Data For Database------------------//
    /**
     * Creates new form Party_MasterForm
     */
    public UpdateUserInformation() {
        initComponents();
        defaultTableModel = (DefaultTableModel) user_Table.getModel();
        resetJTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user_ButtonGroup = new javax.swing.ButtonGroup();
        jTextField6 = new javax.swing.JTextField();
        user_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_Table = new javax.swing.JTable();
        admin_CheacBox = new javax.swing.JCheckBox();
        supervisor_CheacBox = new javax.swing.JCheckBox();
        operator_CheacBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        userName_TextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mobile_TextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        email_TextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        address_TextField = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        updateUserId_CheacBox = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        userID_TextField = new javax.swing.JTextField();
        confirmation_CheacBox = new javax.swing.JCheckBox();
        update_Button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        confirmPassword_TextField = new javax.swing.JPasswordField();
        newPassword_TextField = new javax.swing.JPasswordField();
        currentPassword_TextField = new javax.swing.JTextField();
        showPassword_CheacBox = new javax.swing.JCheckBox();
        updatePassword_CheacBox = new javax.swing.JCheckBox();
        reset_Button = new javax.swing.JButton();
        clear_CheacBox = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        user_Panel.setBackground(new java.awt.Color(255, 255, 51));

        user_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "User ID", "Password", "Mobile", "Address", "Email ID", "DOA/U", "TOA/U", "Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(user_Table);

        admin_CheacBox.setBackground(new java.awt.Color(255, 255, 51));
        user_ButtonGroup.add(admin_CheacBox);
        admin_CheacBox.setText("Admin");
        admin_CheacBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_CheacBoxActionPerformed(evt);
            }
        });

        supervisor_CheacBox.setBackground(new java.awt.Color(255, 255, 51));
        user_ButtonGroup.add(supervisor_CheacBox);
        supervisor_CheacBox.setText("Supervisor");
        supervisor_CheacBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supervisor_CheacBoxActionPerformed(evt);
            }
        });

        operator_CheacBox.setBackground(new java.awt.Color(255, 255, 51));
        user_ButtonGroup.add(operator_CheacBox);
        operator_CheacBox.setText("Operator");
        operator_CheacBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operator_CheacBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("* UserName:");

        userName_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userName_TextFieldKeyReleased(evt);
            }
        });

        jLabel2.setText("* Mobile Number:");

        mobile_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mobile_TextFieldKeyReleased(evt);
            }
        });

        jLabel3.setText("* Email ID:");

        jLabel4.setText("*Address:");

        address_TextField.setColumns(20);
        address_TextField.setRows(5);
        address_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                address_TextFieldKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(address_TextField);

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));

        updateUserId_CheacBox.setBackground(new java.awt.Color(255, 255, 51));
        updateUserId_CheacBox.setText("Update User ID");
        updateUserId_CheacBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserId_CheacBoxActionPerformed(evt);
            }
        });

        jLabel5.setText("    * Current User ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateUserId_CheacBox)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(37, 37, 37)
                        .addComponent(userID_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateUserId_CheacBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(userID_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        confirmation_CheacBox.setText("Yes I Confirm That I Want To Update Data");

        update_Button.setText("Update User Information");
        update_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_ButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));

        jLabel6.setText("    * Current Password:");

        jLabel7.setText("* New Password: ");

        jLabel8.setText("*Confirm Password:");

        showPassword_CheacBox.setBackground(new java.awt.Color(255, 255, 51));
        showPassword_CheacBox.setText("Show Password");
        showPassword_CheacBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassword_CheacBoxActionPerformed(evt);
            }
        });

        updatePassword_CheacBox.setBackground(new java.awt.Color(255, 255, 51));
        updatePassword_CheacBox.setText("Update Password");
        updatePassword_CheacBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePassword_CheacBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(32, 32, 32))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(currentPassword_TextField)
                            .addComponent(newPassword_TextField)
                            .addComponent(confirmPassword_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showPassword_CheacBox))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(updatePassword_CheacBox)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updatePassword_CheacBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(currentPassword_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(showPassword_CheacBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPassword_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPassword_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        reset_Button.setText("Reset");
        reset_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_ButtonActionPerformed(evt);
            }
        });

        clear_CheacBox.setBackground(new java.awt.Color(255, 255, 51));
        user_ButtonGroup.add(clear_CheacBox);
        clear_CheacBox.setText("Clear");
        clear_CheacBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_CheacBoxActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setText(" * Note: All User Added And Updated Only By Adminstartor ");
        jLabel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));

        javax.swing.GroupLayout user_PanelLayout = new javax.swing.GroupLayout(user_Panel);
        user_Panel.setLayout(user_PanelLayout);
        user_PanelLayout.setHorizontalGroup(
            user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
            .addGroup(user_PanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(user_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39)
                        .addGroup(user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(user_PanelLayout.createSequentialGroup()
                                .addComponent(admin_CheacBox)
                                .addGap(18, 18, 18)
                                .addComponent(supervisor_CheacBox)
                                .addGap(18, 18, 18)
                                .addComponent(operator_CheacBox))
                            .addComponent(userName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(user_PanelLayout.createSequentialGroup()
                        .addGroup(user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mobile_TextField)
                            .addComponent(email_TextField)
                            .addComponent(jScrollPane2)
                            .addGroup(user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(update_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(confirmation_CheacBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(user_PanelLayout.createSequentialGroup()
                        .addComponent(reset_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel9))
                    .addComponent(clear_CheacBox))
                .addContainerGap())
        );
        user_PanelLayout.setVerticalGroup(
            user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, user_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_CheacBox)
                    .addComponent(supervisor_CheacBox)
                    .addComponent(operator_CheacBox)
                    .addComponent(clear_CheacBox))
                .addGap(17, 17, 17)
                .addGroup(user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(user_PanelLayout.createSequentialGroup()
                        .addGroup(user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(userName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(mobile_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(email_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(user_PanelLayout.createSequentialGroup()
                        .addGroup(user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(confirmation_CheacBox))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(user_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(update_Button)
                        .addComponent(reset_Button))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reset_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_ButtonActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_reset_ButtonActionPerformed

    private void update_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_ButtonActionPerformed
        // TODO add your handling code here:
        userName = userName_TextField.getText();
        userMob = mobile_TextField.getText();
        userEmail = email_TextField.getText();
        userAddress = address_TextField.getText();
        userDateOfAddition=new Date();
        userTimeOfAddition=new Date();

        if (userName.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Provide User Name");
        } else {
            if (userMob.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Provide Mobile Number");
            } else {
                if (userEmail.equals("") || userEmail.contains("@")) {
                    JOptionPane.showMessageDialog(null, "Please Provide Valid Email ID");
                } else {
                    if (userAddress.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please Provide Address");
                    } else {
                        if (updateUserId_CheacBox.isSelected()) {
                            userId = userID_TextField.getText();
                            if (userId.equals("")) {
                                JOptionPane.showMessageDialog(null, "Please Provide User ID");
                                flag1 = false;
                            } else {
                                flag1 = true;
                            }
                        } else {
                            flag1 = true;
                        }
                        if (flag1) {
                            if (updatePassword_CheacBox.isSelected()) {
                                String userPassTemp = newPassword_TextField.getText();
                                userPassword = confirmPassword_TextField.getText();
                                if (userPassTemp.equals("")) {
                                    JOptionPane.showMessageDialog(null, "Please Provide New Password");
                                    flag2 = false;
                                } else {
                                    if (userPassword.equals("")) {
                                        JOptionPane.showMessageDialog(null, "Please Provide Confirm Password");
                                        flag2 = false;
                                    } else {
                                        if (userPassTemp.equals(userPassword)) {
                                            flag2 = true;
                                        } else {
                                            JOptionPane.showMessageDialog(null, "New Password And Confirm Password Do Not Match");
                                            flag2 = false;
                                        }
                                    }
                                }
                            } else {
                                flag2 = true;
                            }
                            perfromUpdation();
                        }
                    }
                }
            }
        }


    }//GEN-LAST:event_update_ButtonActionPerformed
    void loadData() {
        Session session = init_SessionFactory.openSession();
        Criteria cr = session.createCriteria(com.JD.Login.Hibernate.config.Login.class);
        cr.add(Restrictions.eq("userPriority", priority));
        List results = cr.list();
        for (Object object : results) {
            com.JD.Login.Hibernate.config.Login l = (com.JD.Login.Hibernate.config.Login) object;
            userName_TextField.setText(l.getUserName());
            mobile_TextField.setText(l.getUserMob());
            email_TextField.setText(l.getUserEmail());
            address_TextField.setText(l.getUserAddress());
            userID_TextField.setText(l.getUserId());
            passwordTemp = l.getUserPassword();
            currentPassword_TextField.setText("*************");
            userId = l.getUserId();
            userPassword = l.getUserPassword();
            userIDBackup = userId;
            passwordBackup = userPassword;
        }
        session.close();
    }
    private void admin_CheacBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_CheacBoxActionPerformed
        // TODO add your handling code here:
        if (admin_CheacBox.isSelected()) {
            priority = 1;
            loadData();
        }
    }//GEN-LAST:event_admin_CheacBoxActionPerformed

    private void supervisor_CheacBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supervisor_CheacBoxActionPerformed
        // TODO add your handling code here:
        if (supervisor_CheacBox.isSelected()) {
            priority = 2;
            loadData();
        }
    }//GEN-LAST:event_supervisor_CheacBoxActionPerformed

    private void clear_CheacBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_CheacBoxActionPerformed
        // TODO add your handling code here:
        if (clear_CheacBox.isSelected()) {
            reset();
        }

    }//GEN-LAST:event_clear_CheacBoxActionPerformed

    private void updateUserId_CheacBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserId_CheacBoxActionPerformed
        // TODO add your handling code here:
        if (!updateUserId_CheacBox.isSelected()) {
            userId = userIDBackup;
        }
    }//GEN-LAST:event_updateUserId_CheacBoxActionPerformed

    private void updatePassword_CheacBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePassword_CheacBoxActionPerformed
        // TODO add your handling code here:
        if (!updatePassword_CheacBox.isSelected()) {
            userPassword = passwordBackup;
        }
    }//GEN-LAST:event_updatePassword_CheacBoxActionPerformed

    private void userName_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userName_TextFieldKeyReleased
        // TODO add your handling code here:
        userName_TextField.setText(validator.stringValidator(userName_TextField.getText().toUpperCase()));
    }//GEN-LAST:event_userName_TextFieldKeyReleased

    private void mobile_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobile_TextFieldKeyReleased
        // TODO add your handling code here:
        mobile_TextField.setText(validator.intTypeNumberValidator(mobile_TextField.getText()));
    }//GEN-LAST:event_mobile_TextFieldKeyReleased

    private void address_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_address_TextFieldKeyReleased
        // TODO add your handling code here:
        address_TextField.setText(address_TextField.getText().toUpperCase());
    }//GEN-LAST:event_address_TextFieldKeyReleased

    private void operator_CheacBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operator_CheacBoxActionPerformed
        // TODO add your handling code here:
        if (operator_CheacBox.isSelected()) {
            priority = 3;
            loadData();
        }
    }//GEN-LAST:event_operator_CheacBoxActionPerformed

    private void showPassword_CheacBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassword_CheacBoxActionPerformed
        // TODO add your handling code here:
        if (showPassword_CheacBox.isSelected()) {
            currentPassword_TextField.setText(userId);
        } else {
            currentPassword_TextField.setText("*************");
        }

    }//GEN-LAST:event_showPassword_CheacBoxActionPerformed
    void perfromUpdation() {
        if (flag2 && confirmation_CheacBox.isSelected()) {
            Session session = init_SessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(com.JD.Login.Hibernate.config.Login.class);
            cr.add(Restrictions.eq("userPriority", priority));
            List results = cr.list();
            for (Object object : results) {
                com.JD.Login.Hibernate.config.Login l = (com.JD.Login.Hibernate.config.Login) object;
                l.setUserName(userName);
                l.setUserMob(userMob);
                l.setUserAddress(userAddress);
                l.setUserEmail(userEmail);
                l.setUserId(userId);
                l.setUserPassword(userPassword);
                l.setUserDateOfAddition(new Date());
                l.setUserTimeOfAddition(new Date());
                l.setUserLocation(userLocation);
                l.setUserAddedByPersonName(userAddedByPersonName);
                l.setUserAddedWithRight(userAddedWithRight);
                l.setUserDateOfAddition(userDateOfAddition);
                l.setUserTimeOfAddition(userTimeOfAddition);
                session.save(l);
            }
            transaction.commit();
            session.close();
            JOptionPane.showMessageDialog(null, "User Name " + userName + " Updated Successfully..");
            reset();
        } else {
            JOptionPane.showMessageDialog(null, "Please Agrre To Update Data");
        }
    }

    void resetJTable() {
        for (int i = defaultTableModel.getRowCount() - 1; i >= 0; i--) {
            defaultTableModel.removeRow(i);
        }
        int indexJTable = -1;
        Session session = init_SessionFactory.openSession();
        Query q = session.createQuery("from com.JD.Login.Hibernate.config.Login");
        List results = q.list();
        for (Object object : results) {
            com.JD.Login.Hibernate.config.Login l = (com.JD.Login.Hibernate.config.Login) object;
            ++indexJTable;
            defaultTableModel.insertRow(indexJTable, new Object[]{l.getUserName(), l.getUserId(), l.getUserPassword(), l.getUserMob(), l.getUserAddress(), l.getUserEmail(), l.getUserDateOfAddition(), l.getUserTimeOfAddition(), l.getUserLocation()});
        }
        session.close();
    }

    void reset() {

        userName_TextField.setText("");
        mobile_TextField.setText("");
        userID_TextField.setText("");
        email_TextField.setText("");
        address_TextField.setText("");
        currentPassword_TextField.setText("");
        newPassword_TextField.setText("");
        confirmPassword_TextField.setText("");
        user_ButtonGroup.clearSelection();
        updateUserId_CheacBox.setSelected(false);
        updatePassword_CheacBox.setSelected(false);
        showPassword_CheacBox.setSelected(false);
        confirmation_CheacBox.setSelected(false);
        resetJTable();
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
            java.util.logging.Logger.getLogger(UpdateUserInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateUserInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateUserInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateUserInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new UpdateUserInformation().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address_TextField;
    private javax.swing.JCheckBox admin_CheacBox;
    private javax.swing.JCheckBox clear_CheacBox;
    private javax.swing.JPasswordField confirmPassword_TextField;
    private javax.swing.JCheckBox confirmation_CheacBox;
    private javax.swing.JTextField currentPassword_TextField;
    private javax.swing.JTextField email_TextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField mobile_TextField;
    private javax.swing.JPasswordField newPassword_TextField;
    private javax.swing.JCheckBox operator_CheacBox;
    private javax.swing.JButton reset_Button;
    private javax.swing.JCheckBox showPassword_CheacBox;
    private javax.swing.JCheckBox supervisor_CheacBox;
    private javax.swing.JCheckBox updatePassword_CheacBox;
    private javax.swing.JCheckBox updateUserId_CheacBox;
    private javax.swing.JButton update_Button;
    private javax.swing.JTextField userID_TextField;
    private javax.swing.JTextField userName_TextField;
    private javax.swing.ButtonGroup user_ButtonGroup;
    public javax.swing.JPanel user_Panel;
    private javax.swing.JTable user_Table;
    // End of variables declaration//GEN-END:variables
}

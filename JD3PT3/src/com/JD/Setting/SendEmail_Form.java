/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.Setting;

import com.JD.Test.*;
import com.JD.Master.Forms.*;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Yogesh
 */
public class SendEmail_Form extends javax.swing.JFrame {

    //------------------Data---------------//
    String filePath = "";
    String sender = "";
    String receiver = "";
    String password = "";
    String body = "";
    String subject = "";
    //------------------Data--------------//

    /**
     * Creates new form Party_MasterForm
     */
    public SendEmail_Form() {
        initComponents();
        com.JD.StaticData.Static_DATA.error_TextPanel = error_TextPanel;
        com.JD.StaticData.Static_DATA.error_TextPanel.setVisible(false);
        com.JD.StaticData.Static_DATA.sendEmail_Form = this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        email_Panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sender_TextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        receiver_TextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password_TextField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        subject_TextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        body_TextField = new javax.swing.JTextArea();
        attach_Button = new javax.swing.JButton();
        send_Button = new javax.swing.JButton();
        reset_Button = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        error_TextPanel = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        attachedFileName_Lable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        email_Panel.setBackground(new java.awt.Color(255, 255, 51));

        jLabel1.setText("* Sender Gmail Address:");

        jLabel2.setText("* Receiver Email Address ( Any ):");

        jLabel3.setText("* Sender Password:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/Home/Hide.jpg"))); // NOI18N
        jLabel4.setText(" We Promis You That We Are Not Going To Share Your Password With Any Other System ");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel5.setText("  Subject:");

        jLabel6.setText("  Body:");

        body_TextField.setColumns(20);
        body_TextField.setRows(5);
        jScrollPane1.setViewportView(body_TextField);

        attach_Button.setText("Attach Backup File");
        attach_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attach_ButtonActionPerformed(evt);
            }
        });

        send_Button.setText("Send File");
        send_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_ButtonActionPerformed(evt);
            }
        });

        reset_Button.setText("Reset");
        reset_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_ButtonActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/Setting/alert.png"))); // NOI18N

        error_TextPanel.setForeground(new java.awt.Color(255, 0, 0));
        error_TextPanel.setText("Error: Email Sending Fail ( Please Cheack Following Suggation )\n        \n         1: Cheack Weather Send Gmail Address Is Correct Or Not.\n         2: Cheack Weather Receiver Email Address Is Correct Or Not.\n         3: Cheack Weather You Have Attached File Or Not.\n         4: Cheack Weather Your Internet Is Connected Or Not.         ");
        jScrollPane2.setViewportView(error_TextPanel);

        jLabel8.setText("File Name:");

        attachedFileName_Lable.setText(" No File Attached Yet......");
        attachedFileName_Lable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 0)));

        javax.swing.GroupLayout email_PanelLayout = new javax.swing.GroupLayout(email_Panel);
        email_Panel.setLayout(email_PanelLayout);
        email_PanelLayout.setHorizontalGroup(
            email_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(email_PanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(email_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(email_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(email_PanelLayout.createSequentialGroup()
                        .addGroup(email_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(email_PanelLayout.createSequentialGroup()
                                .addComponent(attach_Button)
                                .addGap(18, 18, 18)
                                .addComponent(send_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(reset_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(email_PanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(attachedFileName_Lable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
                    .addGroup(email_PanelLayout.createSequentialGroup()
                        .addGroup(email_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sender_TextField)
                            .addComponent(password_TextField)
                            .addComponent(subject_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(email_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(email_PanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(receiver_TextField))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(310, Short.MAX_VALUE))
        );
        email_PanelLayout.setVerticalGroup(
            email_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(email_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(email_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sender_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(receiver_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(email_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(email_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(subject_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(email_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(email_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(email_PanelLayout.createSequentialGroup()
                        .addGroup(email_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(attach_Button)
                            .addComponent(send_Button)
                            .addComponent(reset_Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(email_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(attachedFileName_Lable))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, email_PanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(email_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(email_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void attach_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attach_ButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        switch (fc.showOpenDialog(this)) {
            case JFileChooser.APPROVE_OPTION:
                filePath = fc.getSelectedFile() + "";
                attachedFileName_Lable.setText(" " + filePath);
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(this, "Cancelled",
                        "FCDemo",
                        JOptionPane.OK_OPTION);
                break;
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(this, "Error",
                        "FCDemo",
                        JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_attach_ButtonActionPerformed

    private void send_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_ButtonActionPerformed
        // TODO add your handling code here:
        sender = sender_TextField.getText();
        receiver = receiver_TextField.getText();
        subject = subject_TextField.getText();
        body = body_TextField.getText();
        password = password_TextField.getText();
        if (subject.equals("")) {
            subject = "Crusher Management From " + com.JD.StaticData.Static_DATA.location;
        }
        if (body.equals("")) {
            body = "Hello,Please Find Attach";
        }
        if (sender.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Provide Sender Gmail Address");
        } else {
            if (sender.contains("@gmail.com")) {
                if (receiver.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Provide Receiver Email Address ( Any )");
                } else {
                    if (receiver.contains("@")) {
                        if (password.equals("")) {
                            JOptionPane.showMessageDialog(null, "Please Provide Sender Password");
                        } else {
                            if (filePath.equals("")) {
                                JOptionPane.showMessageDialog(null, "Please Attach File Path");
                            } else {
                                JOptionPane.showMessageDialog(null, "Relax We Are Sending Your Email In Backgroung,You Will Get Notify When We Are Done Sending");
                                new SendAttachmentInEmail(sender, password, subject, body, filePath, receiver);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Provide Valid Receiver Email Address ( Any )");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Provide Only Gmail Address In Sender Field");
            }
        }
    }//GEN-LAST:event_send_ButtonActionPerformed

    private void reset_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_ButtonActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_reset_ButtonActionPerformed

    public void reset() {
        sender_TextField.setText("");
        receiver_TextField.setText("");
        password_TextField.setText("");
        filePath = "";
        subject_TextField.setText("");
        body_TextField.setText("");
        com.JD.StaticData.Static_DATA.error_TextPanel.setVisible(false);
        attachedFileName_Lable.setText(" No File Attached Yet......");
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
            java.util.logging.Logger.getLogger(SendEmail_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendEmail_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendEmail_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendEmail_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SendEmail_Form().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attach_Button;
    private javax.swing.JLabel attachedFileName_Lable;
    private javax.swing.JTextArea body_TextField;
    public javax.swing.JPanel email_Panel;
    private javax.swing.JTextPane error_TextPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPasswordField password_TextField;
    private javax.swing.JTextField receiver_TextField;
    private javax.swing.JButton reset_Button;
    private javax.swing.JButton send_Button;
    private javax.swing.JTextField sender_TextField;
    private javax.swing.JTextField subject_TextField;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.Home;

import com.JD.PrintReceiptDM.Form.DM_Home;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Yogesh
 */
public class JD_Home extends javax.swing.JFrame {

    /**
     * Creates new form JD_Home
     */
    String hideImageName = "Hide.jpg";
    URL hideImageNameURL = getClass().getResource(hideImageName);
    Toolkit hideImageNametk = Toolkit.getDefaultToolkit();
    Image hideImage = hideImageNametk.getImage(hideImageNameURL);
    ImageIcon hideICO = new ImageIcon(hideImage);
    String unHideImageName = "Show.jpg";
    URL unHideImageNameURL = getClass().getResource(unHideImageName);
    Toolkit unHideImageNametk = Toolkit.getDefaultToolkit();
    Image unHideImage = unHideImageNametk.getImage(unHideImageNameURL);
    ImageIcon unHideICO = new ImageIcon(unHideImage);
    //-- User Name--//
    String userNameTemp=com.JD.StaticData.Static_DATA.logIn_UserName;
    String dataTemp[]=userNameTemp.split(" ");
    
    //-- User Name--//
    //------ Default Width and Height of parentComponentHolder_Panel------//
    int width = 00;
    int height = 00;
    //------ Default Width and Height of parentComponentHolder_Panel------//
    //---- All Menu Entry ------//
    com.JD.Master.Forms.MasterHome masterHome = new com.JD.Master.Forms.MasterHome();
    com.JD.PrintReceiptDM.Form.DM_Home dM_Home=new DM_Home();
    //---- All Menu Entry ------//
   
    public JD_Home() {
        initComponents();

        //------ Default Width and Height of parentComponentHolder_Panel------//
        width = parentComponentHolder_Panel.getWidth();
        height = parentComponentHolder_Panel.getHeight();
        //------ Default Width and Height of parentComponentHolder_Panel------//
        user_Lable.setText("Welcome "+dataTemp[0]+" ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        hideUnhide_Lable = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        currentWindow_Labe = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        user_Lable = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        logout_Lable = new javax.swing.JLabel();
        menuItem_Panel = new javax.swing.JPanel();
        master_Button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        dm_Button = new javax.swing.JButton();
        parentComponentHolder_Panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        notification_Lable = new javax.swing.JLabel();
        fuelQuantity_Lable = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jToolBar1.setBackground(new java.awt.Color(255, 51, 255));
        jToolBar1.setRollover(true);

        hideUnhide_Lable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/Home/Hide.jpg"))); // NOI18N
        hideUnhide_Lable.setText(" Hide Menu                            ");
        hideUnhide_Lable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        hideUnhide_Lable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hideUnhide_Lable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideUnhide_LableMouseClicked(evt);
            }
        });
        jToolBar1.add(hideUnhide_Lable);

        jLabel2.setText("      ");
        jToolBar1.add(jLabel2);

        currentWindow_Labe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/Home/down.jpg"))); // NOI18N
        currentWindow_Labe.setText("Current Page You Are Viewing is ");
        currentWindow_Labe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jToolBar1.add(currentWindow_Labe);

        jLabel3.setText("                                                                                                                                                                                                                   ");
        jToolBar1.add(jLabel3);

        user_Lable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/Home/user.png"))); // NOI18N
        user_Lable.setText(" Welcome Yogesh Paisode ");
        user_Lable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jToolBar1.add(user_Lable);

        jLabel4.setText("             ");
        jToolBar1.add(jLabel4);

        logout_Lable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/Home/logout.jpg"))); // NOI18N
        logout_Lable.setText(" Logout ");
        logout_Lable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        logout_Lable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToolBar1.add(logout_Lable);

        menuItem_Panel.setBackground(new java.awt.Color(51, 102, 255));
        menuItem_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        master_Button.setText("Master");
        master_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                master_ButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/Login/Form/statonary2.gif"))); // NOI18N

        dm_Button.setText("Print Receipt/DM");
        dm_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dm_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuItem_PanelLayout = new javax.swing.GroupLayout(menuItem_Panel);
        menuItem_Panel.setLayout(menuItem_PanelLayout);
        menuItem_PanelLayout.setHorizontalGroup(
            menuItem_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(menuItem_PanelLayout.createSequentialGroup()
                .addGroup(menuItem_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(master_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dm_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuItem_PanelLayout.setVerticalGroup(
            menuItem_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuItem_PanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(master_Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dm_Button)
                .addContainerGap(382, Short.MAX_VALUE))
        );

        parentComponentHolder_Panel.setBackground(new java.awt.Color(255, 102, 51));
        parentComponentHolder_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        parentComponentHolder_Panel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                parentComponentHolder_PanelComponentResized(evt);
            }
        });

        javax.swing.GroupLayout parentComponentHolder_PanelLayout = new javax.swing.GroupLayout(parentComponentHolder_Panel);
        parentComponentHolder_Panel.setLayout(parentComponentHolder_PanelLayout);
        parentComponentHolder_PanelLayout.setHorizontalGroup(
            parentComponentHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1079, Short.MAX_VALUE)
        );
        parentComponentHolder_PanelLayout.setVerticalGroup(
            parentComponentHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/Login/Form/statonary2.gif"))); // NOI18N

        notification_Lable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/Home/notification.png"))); // NOI18N
        notification_Lable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));

        fuelQuantity_Lable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/Home/purched.png"))); // NOI18N
        fuelQuantity_Lable.setText(" +134.99 LTR ");
        fuelQuantity_Lable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(notification_Lable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fuelQuantity_Lable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fuelQuantity_Lable)
                        .addComponent(notification_Lable))))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuItem_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parentComponentHolder_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuItem_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(parentComponentHolder_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void master_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_master_ButtonActionPerformed
        // TODO add your handling code here:   

        masterHome.masterHome_TabbedPane.setBounds(0, 0, width, height);
        parentComponentHolder_Panel.removeAll();
        parentComponentHolder_Panel.add(masterHome.getMasterHome_TabbedPane());
        parentComponentHolder_Panel.repaint();
        parentComponentHolder_Panel.revalidate();
        currentWindow_Labe.setText(" Master Window ");
        

    }//GEN-LAST:event_master_ButtonActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    private void hideUnhide_LableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideUnhide_LableMouseClicked
        // TODO add your handling code here:

        if (hideUnhide_Lable.getText().equals(" Hide Menu                            ")) {
            menuItem_Panel.setVisible(false);
            hideUnhide_Lable.setText(" UnHide Menu                            ");
            hideUnhide_Lable.setIcon(unHideICO);
        } else {
            menuItem_Panel.setVisible(true);
            hideUnhide_Lable.setText(" Hide Menu                            ");
            hideUnhide_Lable.setIcon(hideICO);
        }


    }//GEN-LAST:event_hideUnhide_LableMouseClicked

    private void parentComponentHolder_PanelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_parentComponentHolder_PanelComponentResized
        // TODO add your handling code here:

        //------ Default Width and Height of parentComponentHolder_Panel------//
        width = parentComponentHolder_Panel.getWidth();
        height = parentComponentHolder_Panel.getHeight();
        //------ Default Width and Height of parentComponentHolder_Panel------//
        masterHome.masterHome_TabbedPane.setBounds(0, 0, width, height);
        dM_Home.DM_Home_TabbedPane.setBounds(0, 0, width, height);

    }//GEN-LAST:event_parentComponentHolder_PanelComponentResized

    private void dm_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dm_ButtonActionPerformed
        // TODO add your handling code here:

        parentComponentHolder_Panel.removeAll();
        parentComponentHolder_Panel.add(dM_Home.DM_Home_TabbedPane);
        parentComponentHolder_Panel.repaint();
        parentComponentHolder_Panel.revalidate();
        currentWindow_Labe.setText(" Print Receipt/DM Window ");

    }//GEN-LAST:event_dm_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(JD_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JD_Home().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentWindow_Labe;
    private javax.swing.JButton dm_Button;
    private javax.swing.JLabel fuelQuantity_Lable;
    private javax.swing.JLabel hideUnhide_Lable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel logout_Lable;
    private javax.swing.JButton master_Button;
    private javax.swing.JPanel menuItem_Panel;
    private javax.swing.JLabel notification_Lable;
    private javax.swing.JPanel parentComponentHolder_Panel;
    private javax.swing.JLabel user_Lable;
    // End of variables declaration//GEN-END:variables
}

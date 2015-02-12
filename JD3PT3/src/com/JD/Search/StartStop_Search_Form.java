/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.Search;

import com.JD.DatePicker.DatePicker;
import com.JD.Test.*;
import com.JD.Master.Forms.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yogesh
 */
public class StartStop_Search_Form extends javax.swing.JFrame {

    //---Load Date Panel---//
    com.JD.DatePicker.DatePicker datePicker = new DatePicker();
    JDatePickerImpl date1 = datePicker.getDateObjectUp();
    JDatePickerImpl date2 = datePicker.getDateObjectDown();
    List queryList = new ArrayList();
    javax.swing.table.DefaultTableModel defaultTableModel;
    SessionFactory search_SessionFactory = com.JD.StaticData.Static_DATA.init_SessionFactory;
    //---Load Date Panel---//
    List machineList = new ArrayList();

    /**
     * Creates new form Party_MasterForm
     */
    public StartStop_Search_Form() {
        initComponents();
        //----Load Calender----//
        date1.setBounds(17, 51, 200, 50);
        date1.setBackground(Color.yellow);
        date2.setBackground(Color.yellow);
        date_panel.add(date1);
        date_panel.add(date2);
        date2.setBounds(17, 102, 200, 40);
        //----Load Calender----//
        defaultTableModel = (DefaultTableModel) detailList_Table.getModel();
        Session session = search_SessionFactory.openSession();

        Query q = session.createQuery("from com.JD.Machine.StartStop.Hibernate.config.Machinestartstop");
        List results = q.list();
        for (Object object : results) {
            com.JD.Machine.StartStop.Hibernate.config.Machinestartstop m = (com.JD.Machine.StartStop.Hibernate.config.Machinestartstop) object;
            if (!machineList.contains(m.getMachineNumber())) {
                number_ComboBox.addItem(m.getMachineNumber());
                machineList.add(m.getMachineNumber());
            }
        }
        session.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateGroup = new javax.swing.ButtonGroup();
        startStop_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailList_Table = new javax.swing.JTable();
        date_panel = new javax.swing.JPanel();
        betwee_CheackBox = new javax.swing.JCheckBox();
        equal_CheackBox = new javax.swing.JCheckBox();
        early_CheackBox = new javax.swing.JCheckBox();
        late_CheackBox = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clear_CheackBox = new javax.swing.JCheckBox();
        number_ComboBox = new javax.swing.JComboBox();
        name_Lable = new javax.swing.JLabel();
        search_Button = new javax.swing.JButton();
        reset_Button = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startStop_Panel.setBackground(new java.awt.Color(255, 255, 51));

        detailList_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Machine No", "Machine Name", "Operator Name", "Start Date", "Start Time", "Stop Date", "Stop Time", "Total Time", "Start Reading", "Stop Reading", "Total Reading", "Last Fuel", "Present Fuel", "Consume Fuel", "Average"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(detailList_Table);

        date_panel.setBackground(new java.awt.Color(255, 255, 51));
        date_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 0), 1, true));

        betwee_CheackBox.setBackground(new java.awt.Color(255, 255, 51));
        dateGroup.add(betwee_CheackBox);
        betwee_CheackBox.setText("Between");
        betwee_CheackBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        betwee_CheackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betwee_CheackBoxActionPerformed(evt);
            }
        });

        equal_CheackBox.setBackground(new java.awt.Color(255, 255, 51));
        dateGroup.add(equal_CheackBox);
        equal_CheackBox.setText("Equal");
        equal_CheackBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        equal_CheackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equal_CheackBoxActionPerformed(evt);
            }
        });

        early_CheackBox.setBackground(new java.awt.Color(255, 255, 51));
        dateGroup.add(early_CheackBox);
        early_CheackBox.setText("Early");
        early_CheackBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        early_CheackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                early_CheackBoxActionPerformed(evt);
            }
        });

        late_CheackBox.setBackground(new java.awt.Color(255, 255, 51));
        dateGroup.add(late_CheackBox);
        late_CheackBox.setText("Late");
        late_CheackBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        late_CheackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                late_CheackBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("From:");

        jLabel3.setText("To:");

        clear_CheackBox.setBackground(new java.awt.Color(255, 255, 51));
        dateGroup.add(clear_CheackBox);
        clear_CheackBox.setText("Clear");

        javax.swing.GroupLayout date_panelLayout = new javax.swing.GroupLayout(date_panel);
        date_panel.setLayout(date_panelLayout);
        date_panelLayout.setHorizontalGroup(
            date_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(date_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(date_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(date_panelLayout.createSequentialGroup()
                        .addComponent(betwee_CheackBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(equal_CheackBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(early_CheackBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(late_CheackBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clear_CheackBox))
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        date_panelLayout.setVerticalGroup(
            date_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(date_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(date_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(betwee_CheackBox)
                    .addComponent(equal_CheackBox)
                    .addComponent(early_CheackBox)
                    .addComponent(late_CheackBox)
                    .addComponent(clear_CheackBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        number_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Machine number" }));
        number_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                number_ComboBoxActionPerformed(evt);
            }
        });

        name_Lable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/JD/Home/Hide.jpg"))); // NOI18N
        name_Lable.setText("Select Machine Number");
        name_Lable.setToolTipText("Select Machine Number");
        name_Lable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        search_Button.setText("Search");
        search_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_ButtonActionPerformed(evt);
            }
        });

        reset_Button.setText("Reset");
        reset_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_ButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Export To Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout startStop_PanelLayout = new javax.swing.GroupLayout(startStop_Panel);
        startStop_Panel.setLayout(startStop_PanelLayout);
        startStop_PanelLayout.setHorizontalGroup(
            startStop_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
            .addGroup(startStop_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(date_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(startStop_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(startStop_PanelLayout.createSequentialGroup()
                        .addComponent(search_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reset_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(startStop_PanelLayout.createSequentialGroup()
                        .addComponent(number_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(name_Lable, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        startStop_PanelLayout.setVerticalGroup(
            startStop_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startStop_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(startStop_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startStop_PanelLayout.createSequentialGroup()
                        .addGroup(startStop_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(number_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_Lable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(startStop_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search_Button)
                            .addComponent(reset_Button)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(startStop_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(startStop_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void betwee_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betwee_CheackBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_betwee_CheackBoxActionPerformed

    private void equal_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equal_CheackBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_equal_CheackBoxActionPerformed

    private void early_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_early_CheackBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_early_CheackBoxActionPerformed

    private void late_CheackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_late_CheackBoxActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_late_CheackBoxActionPerformed

    private void number_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_number_ComboBoxActionPerformed
        // TODO add your handling code here:       
        if (number_ComboBox.getSelectedIndex() != 0) {
            Session session = search_SessionFactory.openSession();
            Criteria cr = session.createCriteria(com.JD.Master.Hibernate.config.Machinemaster.class);
            cr.add(Restrictions.eq("machineNumber", number_ComboBox.getSelectedItem().toString()));
            List results = cr.list();
            for (Object object : results) {
                com.JD.Master.Hibernate.config.Machinemaster m = (com.JD.Master.Hibernate.config.Machinemaster) object;
                name_Lable.setText("  " + m.getMachineName() + "  ");
            }
            session.close();
        }
    }//GEN-LAST:event_number_ComboBoxActionPerformed

    private void search_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_ButtonActionPerformed
        // TODO add your handling code here:
        int month1 = 0;
        int month2 = 0;
        if (date1.getModel().getMonth() == 12) {
            month1 = 1;
        } else {
            month1 = date1.getModel().getMonth() + 1;
        }
        if (date2.getModel().getMonth() == 12) {
            month2 = 1;
        } else {
            month2 = date2.getModel().getMonth() + 1;
        }
        String date11 = date1.getModel().getYear() + "-" + month1 + "-" + date1.getModel().getDay();
        String date22 = date2.getModel().getYear() + "-" + month2 + "-" + date2.getModel().getDay();
        queryList.clear();
        int indexJTable = -1;
        for (int i = defaultTableModel.getRowCount() - 1; i >= 0; i--) {
            defaultTableModel.removeRow(i);
        }
        String queryMaker = "from com.JD.Machine.StartStop.Hibernate.config.Machinestartstop ";
        String queryConnector = "where ";
        String dateQuery = null;
        String machineNumberTemp = null;
        if (betwee_CheackBox.isSelected()) {
            dateQuery = "startDate BETWEEN '" + date11 + "' and '" + date22 + "' ";
        } else if (early_CheackBox.isSelected()) {
            dateQuery = "startDate<='" + date11 + "' ";
        } else if (late_CheackBox.isSelected()) {
            dateQuery = "startDate>='" + date11 + "' ";
        } else if (equal_CheackBox.isSelected()) {
            dateQuery = "startDate='" + date11 + "' ";
        }
        if (dateQuery != null) {
            queryList.add(dateQuery);
        }
        if (number_ComboBox.getSelectedIndex() > 0) {
            machineNumberTemp = "machineNumber='" + number_ComboBox.getSelectedItem().toString() + "' ";
        }
        if (machineNumberTemp != null) {
            queryList.add(machineNumberTemp);
        }
        int listSize = queryList.size();
        if (listSize > 0) {
            int counter = 0;
            queryMaker += queryConnector;
            for (Object object : queryList) {
                ++counter;
                if (counter != listSize) {
                    queryMaker += object.toString() + "and ";
                } else {
                    queryMaker += object.toString();
                }
            }
        }
        Session session = search_SessionFactory.openSession();
        Query q = session.createQuery(queryMaker);
        int k=0;
        for (Object object : q.list()) {
            com.JD.Machine.StartStop.Hibernate.config.Machinestartstop m = (com.JD.Machine.StartStop.Hibernate.config.Machinestartstop) object;
            ++indexJTable;
            ++k;
            defaultTableModel.insertRow(indexJTable, new Object[]{k,m.getMachineNumber(), m.getMachineName(), m.getOperatorName(), m.getStartDate(), m.getStartTime(), m.getStopDate(), m.getStopTime(), m.getTotalTime(), m.getStartReading(), m.getStopReading(), m.getTotalReading(), m.getLastFuel(), m.getPresentFuel(), m.getConsumeFuel(), m.getAverage()});
            if (!machineList.contains(m.getMachineNumber())) {
                number_ComboBox.addItem(m.getMachineNumber());
                machineList.add(m.getMachineNumber());
            }
        }
        session.close();
        reset();
    }//GEN-LAST:event_search_ButtonActionPerformed

    private void reset_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_ButtonActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_reset_ButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (detailList_Table.getModel().getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Cant Export ! No Data In The Table");
        } else {
            new com.JD.ExportToExcel.ExportToExcel().saveToExcel(detailList_Table);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (detailList_Table.getModel().getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Cant Print ! No Data In The Table");
        } else {
            try {
                detailList_Table.print();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Something Went Wrong ! Please Cheack your Printer");
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed
    void reset() {
        number_ComboBox.setSelectedIndex(0);
        name_Lable.setText("  Select Machine Number  ");
        dateGroup.clearSelection();
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
            java.util.logging.Logger.getLogger(StartStop_Search_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartStop_Search_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartStop_Search_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartStop_Search_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new StartStop_Search_Form().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox betwee_CheackBox;
    private javax.swing.JCheckBox clear_CheackBox;
    private javax.swing.ButtonGroup dateGroup;
    private javax.swing.JPanel date_panel;
    private javax.swing.JTable detailList_Table;
    private javax.swing.JCheckBox early_CheackBox;
    private javax.swing.JCheckBox equal_CheackBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox late_CheackBox;
    private javax.swing.JLabel name_Lable;
    private javax.swing.JComboBox number_ComboBox;
    private javax.swing.JButton reset_Button;
    private javax.swing.JButton search_Button;
    public javax.swing.JPanel startStop_Panel;
    // End of variables declaration//GEN-END:variables
}

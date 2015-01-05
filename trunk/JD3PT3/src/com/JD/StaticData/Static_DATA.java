/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.StaticData;

import com.JD.INIT_Data.WebcamPanel;
import com.github.sarxos.webcam.Webcam;
import org.hibernate.SessionFactory;

/**
 *
 * @author Yogesh
 */
public class Static_DATA {
    //------TEMP DATA--------//

    public static int srNo_TEMP = 0;
    //------TEMP DATA--------//
    //------ INIT DATA ------//
    // PKG: com.JD.INIT_Data , com.JD.InitData.Hibernate.config//
    public static SessionFactory init_SessionFactory = null;
    public static String location = null;
    public static String prSrNo = null;
    public static int srNo = 00;
    public static String registrationNumber = null;
    public static String selfPartyname = null;
    //------ INIT DATA ------//
    //------------------------------------------------------------------------//
    //------ Master Hibernate Config ------//
    // PKG: com.JD.Master.Hibernate.config //    
    public static SessionFactory master_SessionFactory = null;
    //------ Master Hibernate Config ------//
    //------------------------------------------------------------------------//
    //------ Master Hibernate Config ------//
    // PKG: com.JD.Master.Hibernate.config //    
    public static SessionFactory login_SessionFactory = null;
    //------ Master Hibernate Config ------//
    //------------------------------------------------------------------------//
    // ------ QR Code Scanner ------//
    // Class : com.JD.INIT_Data.Init_QRCodeScanner //
    public static WebcamPanel webPanel = null;
    public static Webcam webcam = null;
    // ------ QR Code Scanner ------//
    //------------------------------------------------------------------------//
    // ------ Login Form ------//
    // ------ com.JD.Login.Form ------ //
    public static int logIn_Priority = 0;
    public static String logIn_UserName = null;
    public static String logIn_Right = null;
    //------ Login Form ------//
    //------------------------------------------------------------------------//
    //-----Master ComboBoxFill-----//
    public static javax.swing.JComboBox machinePartyName_ComboBox = null;
    public static javax.swing.JComboBox driverPartyName_ComboBox = null;
    //-----Master ComboBoxFill-----//
    //-----DM Data----------------------------------//
    //-----DM SessionFactory------------------------//
    public static SessionFactory dm_SessionFactory = null;
    //-----DM SessionFactory------------------------//
    public static com.JD.PrintReceiptDM.Form.PrintReceipt_Dm_Form dm_Form = null;
    public static javax.swing.JComboBox dm_PartyName = null;
    public static javax.swing.JComboBox dm_ProductName = null;
    public static javax.swing.JComboBox dm_Size = null;
    public static javax.swing.JComboBox dm_Measurement = null;
    public static javax.swing.JTextField dm_value_TextField = null;
    public static javax.swing.JTextField payAble_TextField = null;
    public static javax.swing.JTextField twoPayAmount_TextField = null;
    public static javax.swing.JTextField totalAmount_TextField = null;
    public static javax.swing.JComboBox driverName_ComboBox = null;
    public static javax.swing.JComboBox vehicleNumber_ComboBox = null;
    public static javax.swing.JTextField vehicleName_TextField = null;
    public static javax.swing.JComboBox pending_ComboBox = null;
    public static javax.swing.JButton addDataToDataBase_Button = null;
    public static javax.swing.JLabel date_Lable = null;
    public static javax.swing.JLabel time_Lable = null;
    public static javax.swing.JLabel srNo_Lable = null;
    
    public static javax.swing.JCheckBox proxy_CheackBox = null;
    public static javax.swing.JTextField neightWeight_TextField = null;
    public static javax.swing.JTextField grossWeight_TextField = null;
    public static boolean flag3 = false;
    public static javax.swing.JCheckBox cash_CheackBox = null;
    public static javax.swing.JCheckBox twoPay_CheackBox = null;
    public static javax.swing.JCheckBox cashAndTwoPay_CheackBox = null;
    public static javax.swing.JCheckBox update_CheackBox = null;
    public static javax.swing.JCheckBox cancel_CheackBox = null;
    public static javax.swing.JCheckBox clear_CheackBox = null;
    
    
    //-----DM Data----------------------------------//
}

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
    //------Master Home------//
    public static javax.swing.JLabel fuelQuantity_Lable=null;
    public static javax.swing.JLabel fuelQuantity_Sell_Lable=null;
    public static javax.swing.JLabel fuelQuantity_Purchse_Lable=null;
    
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
   
    //------ Master Hibernate Config ------//
    //------------------------------------------------------------------------//
    //------ Master Hibernate Config ------//
    // PKG: com.JD.Master.Hibernate.config //    
  
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
    public static javax.swing.JCheckBox pending_CheackBox=null;
    public static int SRNO=0;
    public static String QRCode="";
     public static javax.swing.JPanel webCam_Panel_Dm=null;
    
    //-----DM Data----------------------------------//
    //-----Driver Master----------------------------//
    public static javax.swing.JPanel webCam_Panel=null;
    //-----Driver Master----------------------------//
    
    //-----Diesel Data-----------------------------//
    public static com.JD.Diesel.Forms.PurchaseDiesel_Form purchaseDiesel_Form=null;
    public static javax.swing.JComboBox partyName_Sell_ComboBox=null;
    //-----Diesel Data-----------------------------//
    
    //-------From Search--------------------------//
    //-----From DM Search-------------------------//
    public static javax.swing.JComboBox dmSearch_party_ComboBox=null;
    public static javax.swing.JComboBox dmSearch_srNo_ComboBox=null;
    public static javax.swing.JComboBox dmsearch_ProductName_ComboBox=null;
    public static javax.swing.JComboBox dmsearch_size_ComboBox=null;
    public static javax.swing.JComboBox dmSearch_measurement_ComboBox=null;   
    
    //-----From DM Search-------------------------//
    //-------From Search--------------------------//
    
    
    
    
    
}

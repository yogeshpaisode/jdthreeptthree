/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.StaticData;

import com.JD.INIT_Data.WebcamPanel;
import org.hibernate.SessionFactory;

/**
 *
 * @author Yogesh
 */
public class Static_DATA {

    //------ INIT DATA ------//
    // PKG: com.JD.INIT_Data , com.JD.InitData.Hibernate.config//
    public static SessionFactory init_SessionFactory = null;
    public static String location = null;
    public static String prSrNo = null;
    public static int srNo = 00;
    public static String registrationNumber = null;
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
    public static WebcamPanel panel = null;
    // ------ QR Code Scanner ------//
    //------------------------------------------------------------------------//
    // ------ Login Form ------//
    // ------ com.JD.Login.Form ------ //
    
    public static int logIn_Priority=0;
    public static String logIn_UserName=null;
    public static String logIn_Right=null;
    
    
    
    //------ Login Form ------//
    //------------------------------------------------------------------------//
}

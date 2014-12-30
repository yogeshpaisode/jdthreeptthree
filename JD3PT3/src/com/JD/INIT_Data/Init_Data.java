/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.INIT_Data;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Yogesh
 */
public class Init_Data implements Runnable{

    public Init_Data() {    
        new Thread(this, "INIT DATA").start();    
    }  
        
    @Override
    public void run() {
        
        Session session=com.JD.StaticData.Static_DATA.init_SessionFactory.openSession();
        
        Query q=session.createQuery("from com.JD.InitData.Hibernate.config.Initdata");
        
        List list=q.list();
        
        for (Object object : list) {
            
            com.JD.InitData.Hibernate.config.Initdata id=(com.JD.InitData.Hibernate.config.Initdata)object;
            com.JD.StaticData.Static_DATA.location=id.getLocation();
            com.JD.StaticData.Static_DATA.prSrNo=id.getPrSrNo();
            com.JD.StaticData.Static_DATA.srNo=id.getSrNo();
            com.JD.StaticData.Static_DATA.registrationNumber=id.getRegistrationNumber();           
            
        }
        
        
    }
    
}

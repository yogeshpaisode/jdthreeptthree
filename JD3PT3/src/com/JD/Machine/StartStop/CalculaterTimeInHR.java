/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.Machine.StartStop;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class CalculaterTimeInHR {
    String monthAry[]={" ","January","February","March","April","May","June","July","August","September","October","November","December"};
    int bk=0;

    int no(String month){

        for (int i = 0; i < monthAry.length; i++) {

                if (month.equals(monthAry[i])) {
                bk=i;
                    break;
            }
            

        }

        return bk;

    }


    String ConvertDifferenceToHrs(String start, String stop) {

        String dateStart = start;
        String dateStop = stop;

        String totalTimeUsed="";

        //HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);


            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            System.out.print(diffDays + " days, ");
            System.out.print(diffHours + " hours, ");
            System.out.print(diffMinutes + " minutes, ");
            System.out.print(diffSeconds + " seconds.");

           // JOptionPane.showMessageDialog(null, "okzz  "+diffDays * 24 + diffHours + " : " + diffMinutes + " : " + diffSeconds);
            totalTimeUsed=diffDays * 24 + diffHours + " : " + diffMinutes + " : " + diffSeconds;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalTimeUsed;

    }

    

}

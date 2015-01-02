/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.DatePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author admin
 */
public class DatePicker {

    DateFormat dateFormat = new SimpleDateFormat("MM");
    Date date = new Date();
    int month = Integer.parseInt(dateFormat.format(date));

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    DateFormat dateFormat1 = new SimpleDateFormat("yyyy");
    Date date1 = new Date();
    int year = Integer.parseInt(dateFormat1.format(date1));

    DateFormat dateFormat2 = new SimpleDateFormat("MMM");
    Date date2 = new Date();
    int day = Integer.parseInt(dateFormat.format(date2));

  public  JDatePickerImpl getDateObjectUp() {



        if (month == 12) {
            month = 1;

        } else {
            month = month - 1;
        }


        JDatePickerImpl datePickerALL;
        UtilDateModel model = new UtilDateModel();
        model.setDate(year, month, day);
        model.setSelected(true);
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        datePickerALL = new JDatePickerImpl(datePanel);
        datePickerALL.setBounds(15, 3, 200, 40);
        return datePickerALL;

    }

    JDatePickerImpl getDateObjectDown() {


        if (month == 12) {
            month = 1;

        } else {
            month = month - 1;
        }

        JDatePickerImpl datePickerALL;
        UtilDateModel model = new UtilDateModel();
        model.setDate(year, month, day);
        model.setSelected(true);
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        datePickerALL = new JDatePickerImpl(datePanel);
        datePickerALL.setBounds(15, 47, 200, 40);
        return datePickerALL;


    }
}

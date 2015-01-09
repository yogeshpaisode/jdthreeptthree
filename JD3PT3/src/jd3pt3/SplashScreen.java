/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jd3pt3;

/**
 *
 * @author Yogesh
 */
import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class SplashScreen extends JWindow {

    private int duration;
    public javax.swing.JProgressBar progressBar=new JProgressBar();

    public SplashScreen(int d) {
        com.JD.StaticData.Static_DATA.progressBar=progressBar;
        progressBar.setBounds(0, 280, 549, 5);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.GREEN);
        add(progressBar);
        duration = d;
    }

    // A simple little method to show a title screen in the center
    // of the screen for the amount of time given in the constructor
    public void showSplash() {
        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.black);
        progressBar.setValue(5);
        // Set the window's bounds, centering the window
        int width = 550;
        int height = 315;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        // Build the splash screen
        String imgName = "1.gif";
        URL imgURL = getClass().getResource(imgName);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage(imgURL);
        JLabel label = new JLabel(new ImageIcon(img));
        JLabel copyrt = new JLabel("Copyright 2014 © FiberTech InfraCon™ PVT.LTD.", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 11));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color oraRed = new Color(0, 0, 0, 16);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 10));
        // Display it
        progressBar.setValue(10);
        setVisible(true);
        try {    
            com.JD.StaticData.Static_DATA.init_SessionFactory = com.JD.InitData.Hibernate.config.InitData_HibernateUtil.getSessionFactory();
            new com.JD.INIT_Data.Init_Data();
            new com.JD.INIT_Data.Init_QRCodeScanner();
            Thread.sleep(2000);
            com.JD.StaticData.Static_DATA.progressBar.setValue(100);
            new com.JD.Login.Form.Login().setVisible(true);
            setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong,Software Will Close,If Problem Persist then Please Restart Your Computer..");
            System.exit(0);

        }

    }


    public static void main(String[] args) {
        SplashScreen splash = new SplashScreen(5000);
        splash.showSplash();
    }
}

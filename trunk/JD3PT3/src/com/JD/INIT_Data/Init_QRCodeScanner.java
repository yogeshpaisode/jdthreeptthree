/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.INIT_Data;

/**
 *
 * @author Yogesh
 */
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.ReaderException;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.util.List;
import javax.swing.JOptionPane;

public class Init_QRCodeScanner extends JFrame implements Runnable, ThreadFactory {

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    private Webcam webcam = null;
    private WebcamPanel panel = null;

    public WebcamPanel getPanel() {
        return panel;
    }
    private JTextArea textarea = null;

    public Init_QRCodeScanner() {
        super();
        try {

            setLayout(new FlowLayout());
            setTitle("Read QR / Bar Code With Webcam");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Dimension size = WebcamResolution.QVGA.getSize();

            webcam = Webcam.getDefault();

            if (webcam == null) {
                JOptionPane.showMessageDialog(this, "Camera Error : Either Camera Is Not Connected Or Connection To Camera Is Loss..");
                System.exit(0);
            } else {
                webcam.setViewSize(size);
                panel = new WebcamPanel(webcam);
                panel.setPreferredSize(size);
                textarea = new JTextArea();
                textarea.setEditable(false);
                textarea.setPreferredSize(size);
                webcam.open();
                add(panel);
                add(textarea);
                com.JD.StaticData.Static_DATA.panel = panel;
                pack();
                setVisible(false);
                executor.execute(this);
            }

        } catch (Exception e) {

            if (webcam.getLock().isLocked()) {
                JOptionPane.showMessageDialog(this, "Software Is Already Running...( If Problem Is Persist Then Restart Your System.. )");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(this, "Camera Error : Either Camera Is Not Connected Or Connection To Camera Is Loss..");
            }
        }
    }

    @Override
    public void run() {

        if (webcam != null) {
            do {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Result result = null;
                BufferedImage image = null;
                if (webcam.isOpen()) {

                    if ((image = webcam.getImage()) == null) {
                        continue;
                    }
                    LuminanceSource source = new BufferedImageLuminanceSource(image);
                    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                    try {
                        try {
                            result = new MultiFormatReader().decode(bitmap);
                        } catch (ReaderException ex) {
                            Logger.getLogger(Init_QRCodeScanner.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (Exception e) {
                    }
                }

                if (result != null) {
                    //--- Business Logic ---//
                    //--- Business Logic ---//
                }
            } while (true);
        }
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "example-runner");
        t.setDaemon(true);
        return t;
    }

//    public static void main(String[] args) {
//        new Init_QRCodeScanner();
//    }
}

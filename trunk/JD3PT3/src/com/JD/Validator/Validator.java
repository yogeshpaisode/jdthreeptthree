package com.JD.Validator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yogesh
 */
public class Validator {

    public String stringValidator(String data) {

        String temp = "";

        char arrayChar[] = data.toCharArray();

        for (char c : arrayChar) {

            int ascii = c;

            if (ascii >= 65 && ascii <= 122 || ascii >= 97 && ascii <= 122||ascii==32) {
                temp = temp + c;
            }

        }
        return temp;
    }

   public  String numberValidator(String data) {
        String temp = "";

        char arrayChar[] = data.toCharArray();

        for (char c : arrayChar) {

            if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'||c=='.') {

                temp = temp + c;
            }

        }

        return temp;
    }


    public  String intTypeNumberValidator(String data) {
        String temp = "";

        char arrayChar[] = data.toCharArray();

        for (char c : arrayChar) {

            if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {

                temp = temp + c;
            }

        }

        return temp;
    }
}

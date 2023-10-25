/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikoembe.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 
 */
public class Reader {

    public static String readString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();      
        } catch (IOException ex) {
            return "";
        }
    }

    public static int readInt() {
        try {
            return Integer.parseInt(readString());
        } catch (NumberFormatException ex) {
            return -1;
        }
    }
    
    public static double readDouble() {
        try {
            return Double.parseDouble(readString());
        } catch (NumberFormatException ex) {
            return 0.0;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.curs3.ssatr.ia.colectii.retea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
/**
 *
 * @author mihai.hulea
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Ma conectez la server.");
        Socket s = new Socket("127.0.0.1", 4050);
        System.out.println("Conexiune realizata!");
         //...... 
        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
        
        fluxOut.println("34+35");
        String response = fluxIn.readLine();
        System.out.println(response);
//        
//        fluxOut.println("Hello from client 2");
//        response = fluxIn.readLine();
//        System.out.println(response);
//        
//        fluxOut.println("Hello from client 3");
//        response = fluxIn.readLine();
//        System.out.println(response);
//        
        fluxOut.println("close connection");
        response = fluxIn.readLine();
        System.out.println(response);
        
        
        s.close();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.curs3.ssatr.ia.colectii.retea;


import java.net.*;
import java.io.*;
import java.time.Instant;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss =new ServerSocket(4050);
        
        while(true){
            System.out.println("Astept conexiune de la client...");
            Socket s = ss.accept(); //metoda blocanta
            System.out.println("Clientul s-a conectat!");
            //...... 
            BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
            //......
            String line = "";
            while(!line.equals("close connection")){
                line = fluxIn.readLine();
                System.out.println("Am primti de la client: "+line);
                if(line.contains("+")) {
                    line = "Rezultatul este " + String.valueOf(Integer.parseInt(line.split("\\+")[0]) + Integer.parseInt(line.split("\\+")[1]));
                }

                fluxOut.println(line);
            }

            s.close();
        }
    }
}
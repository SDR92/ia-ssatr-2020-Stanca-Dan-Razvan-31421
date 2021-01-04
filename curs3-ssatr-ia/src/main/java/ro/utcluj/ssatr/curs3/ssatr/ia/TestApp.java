/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.curs3.ssatr.ia;

import java.util.ResourceBundle;
import ro.utcluj.ssatr.curs3.ssatr.ia.colectii.Controler;
import ro.utcluj.ssatr.curs3.ssatr.ia.colectii.Sensor;

/**
 * Java collections - colectii de obiecte 
 * Comunicarea in retea utilizand Java 
 */
public class TestApp {
    public static void main(String[] args) {
        Controler c = new Controler();
        
        c.addSensor(new Sensor("Loc1",10));
        c.addSensor(new Sensor("Loc2",70));
        c.addSensor(new Sensor("Loc3",75));
        
        c.control();
        
        ///////////////////////
        
        Sensor x1 = new Sensor("Loc 1", 80);
        Sensor x2 = new Sensor("Loc 1", 80);
        
        if(x1.equals(x2)){
            System.out.println("Obiecte egale!"); //1
        }else{
            System.out.println("Obiecte diferite!"); //2
        }
    
    }
}

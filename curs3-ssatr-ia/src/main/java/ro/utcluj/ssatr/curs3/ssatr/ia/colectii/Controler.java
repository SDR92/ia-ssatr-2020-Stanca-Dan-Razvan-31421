/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.curs3.ssatr.ia.colectii;

import java.util.ArrayList;

/**
 *
 * @author mihai.hulea
 */
public class Controler {
    public static final int MAX_VALUE = 60;
    ArrayList<Sensor> list = new ArrayList<Sensor>();
    
    public void addSensor(Sensor s){
        list.add(s);
    }
    
    public void control(){
        for(int i=0;i<list.size();i++){
            Sensor x = list.get(i);
            if(x.getValue()> MAX_VALUE)
                System.out.println("Sensor located at "+x.getLocation()+" value = "+x.getValue()+" is to high!"); 
       }
    }
    
    public boolean search(String location, int value){
        return list.contains(new Sensor(location, value));
    }
    
}

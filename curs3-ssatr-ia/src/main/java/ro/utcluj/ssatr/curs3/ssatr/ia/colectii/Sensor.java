/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.curs3.ssatr.ia.colectii;

import java.util.Objects;

/**
 *
 * @author mihai.hulea
 */
public class Sensor{
    private String location;
    private int value;

    public Sensor(String location, int value) {
        this.location = location;
        this.value = value;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.location);
        hash = 53 * hash + this.value;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Sensor))
            return false;
        
        Sensor x = (Sensor)obj; //conversie de tip (eng. cast)
        
        return x.getValue()==value && x.getLocation().equals(location);
            
    }
    
    
    
}

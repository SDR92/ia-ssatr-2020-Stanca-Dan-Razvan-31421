/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.curs2.ssatr.ia;

/**
 *
 * @author mihai.hulea
 */
public class TestCar {
    public static void main(String[] args) {
       
        
//        Car c1 = new Car("BMW", 10);
//        
//        c1.accelerate();
//        
//        // -> Vehicle speed is 11
//        
//        //instantiere obiecte
//        Car c2 = new Car("BMW", 10);
//        
//        c2.accelerate();c2.accelerate();
//        
//        // -> Vehicle speed is 12
//        
//        
//        Car c3;        
//        c3 = new Car("Opel",0);
//        
//        // -> Vehicle speed is 0
//        
//        c3.accelerate();
//        
//        c3 = c1;
//        c3.accelerate();
//        c1.accelerate();
//        
        // -> Vehicle speed is 3
        
        DieselCar d1 = new DieselCar("Audi", 5);
        d1.accelerate();
        
        ElectricCar e1 = new ElectricCar("Nissan", 0);
        e1.accelerate();
        
        Car x1 = new DieselCar("Dacia",1);
        x1.accelerate();
        
        
    }
}

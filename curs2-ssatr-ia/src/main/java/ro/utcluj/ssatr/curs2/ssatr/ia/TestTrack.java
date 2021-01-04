/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.curs2.ssatr.ia;

import java.util.ArrayList;
/**
 *
 * @author mihai.hulea
 */
public class TestTrack {
    ArrayList<Car> cars = new ArrayList<>();
   //Car[] cars = new Car[10]; // [null null null null ....]
   
   void addCar(Car c){
       cars.add(c);
   //    for(int i=0;i<cars.length;i++){
       //    if(cars[i]==null){
         //      cars[i] = c;
          //     System.out.println("New car added on test track.");
          //     return;
                    
       }
    //   System.out.println("No empty position found on test track.");
  // }
   
   //polimorfism - mecanimsul prin care in mod dinamic la rulare se determina tipul concert al obiectului
   // si se apeleaza metoda coreszpunzatoare
   void testAccelerate(int k){
       for(int i=0;i<k;i++)
        for(Car c: cars){ //foreach
            if(c!=null)
                 c.accelerate();
        }
   }
   
   String getAllCarsDetails(){
       String all = "";
       for(Car c: cars){ 
           if(c!=null){
            String line = "Car name="+c.getName()+" speed="+c.speed+" and \nplate number="+c.getPlateNumber()+"\n";
            all=all+line;
           }
       }
       return all;
   }
   
    public static void main(String[] args) {
        TestTrack track1 = new TestTrack();
        
        track1.addCar(new ElectricCar("Tesla 1", 0, "CJ99ABC"));
        track1.addCar(new ElectricCar("Tesla 2", 0, "CJ99BCD"));
        track1.addCar(new DieselCar("Tesla 2", 0, "CJ99DEF"));
        track1.addCar(new DieselCar("Tesla 2", 0, "CJ99EFG"));
        track1.addCar(new OttoCar("Opel 1", 0, "CJ99FGH"));
        track1.addCar(new OttoCar("Opel 2", 0, "CJ99GHI"));
        
        track1.testAccelerate(4);
        
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.cur5.ssatr.ia.parking;

import java.sql.SQLException;

/**
 *
 * @author mihai.hulea
 */
public class ParckingService {
    
    private DBAccess db;
    public static final int UNIT_PRICE = 2; 

    public ParckingService() throws ClassNotFoundException, SQLException {
        db = new DBAccess();
    }
  
    public synchronized String handlePlateNumber(String plateNumber) throws SQLException{
        CarAccessEntity c = db.findByPlateNumber(plateNumber);
        if(c==null){
            CarAccessEntity x = new CarAccessEntity(plateNumber, System.currentTimeMillis());
            db.insertCar(x);
            return "Car entry: "+x.getPlateNumber()+ " tariff: "+UNIT_PRICE+" RON";
        }else{
            int p = computeParkingStayPrice(c.getEntryTime());
            db.deleteByPlateNumber(plateNumber);
            return "Car exit: "+c.getPlateNumber()+" price = "+p+" RON";
        } 
    }
    
    private int computeParkingStayPrice(long entryTime){
        //1 LEU / secunda 
        
        long crt = System.currentTimeMillis();
        return (int)(((crt - entryTime)/1000)* UNIT_PRICE);
        
    }
    
    public static void main(String[] args) throws Exception {
        ParckingService p = new ParckingService();
        System.out.println(p.handlePlateNumber("CJ 99 ABC"));
        Thread.sleep(2000);
        System.out.println(p.handlePlateNumber("CJ 99 ABC"));
    }
    
}

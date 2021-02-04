/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.cur5.ssatr.ia.parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccess {

    private Connection conn;
    
    public DBAccess() throws ClassNotFoundException, SQLException {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         conn = DriverManager.getConnection("jdbc:derby://localhost:1527/test1;create=false","app","app");
    }
   
    public void insertCar(CarAccessEntity e) throws SQLException{
        Statement s = conn.createStatement();
        s.executeUpdate("INSERT INTO CARACCESS VALUES ('"+e.getPlateNumber()+"',"+e.getEntryTime()+")");        
        s.close();
    }
    
    public CarAccessEntity findByPlateNumber(String plateNumber) throws SQLException{
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM CARACCESS WHERE PLATENUMBER='"+plateNumber+"'");
        if(rs.next()){
            return new CarAccessEntity(rs.getString("platenumber"), rs.getLong("entrytime"));
        }else{
            return null;
        }           
    }
    
    public void deleteByPlateNumber(String plateNumber) throws SQLException{
        Statement s = conn.createStatement();
        s.executeUpdate("DELETE FROM CARACCESS WHERE PLATENUMBER='"+plateNumber+"'");        
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBAccess db = new DBAccess();
        //db.insertCar(new CarAccessEntity("CJ 89 TTT", System.currentTimeMillis()));
        //db.insertCar(new CarAccessEntity("CJ 22 ABC", System.currentTimeMillis()));
        CarAccessEntity result = db.findByPlateNumber("CJ 89 TTT");
        System.out.println(result);
        if(result!=null){
            db.deleteByPlateNumber(result.getPlateNumber());
            System.out.println("Entry deleted!");
        }else{
            System.out.println("Entry not found!");
        }
        
    }
    
}

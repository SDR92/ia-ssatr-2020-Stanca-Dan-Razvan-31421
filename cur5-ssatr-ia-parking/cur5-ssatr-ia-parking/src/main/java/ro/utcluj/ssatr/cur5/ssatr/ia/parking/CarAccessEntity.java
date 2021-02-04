/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.cur5.ssatr.ia.parking;

/**
 *
 * @author mihai.hulea
 */
public class CarAccessEntity {
    private String plateNumber;
    private long entryTime;

    public CarAccessEntity(String plateNumber, long entryTime) {
        this.plateNumber = plateNumber;
        this.entryTime = entryTime;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return "CarAccessEntity{" + "plateNumber=" + plateNumber + ", entryTime=" + entryTime + '}';
    }
    
    
}

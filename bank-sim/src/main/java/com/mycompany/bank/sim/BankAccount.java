/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank.sim;


public class BankAccount {
    public String owner;
    public int balance;
    
     BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }
    public String getOwner() {
        return owner;
    }   
    public int getBalance() {
        return balance;
    }
    public int getBalance(int b) {
        return getBalance(0);
    }
}
    
   

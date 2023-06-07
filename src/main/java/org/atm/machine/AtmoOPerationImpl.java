package org.atm.machine;

import java.util.HashMap;
import java.util.Map;

public class AtmoOPerationImpl implements AtmOperation  {
    ATM atm = new ATM();
   Map<Double,String>ministmt=new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("Available Balance is:"+atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
       if(withdrawAmount<= atm.getBalance()){
           ministmt.put(withdrawAmount,"Amount withdraw");
           System.out.println(withdrawAmount+"collect the Cash "+withdrawAmount);
           atm.setBalance(atm.getBalance()-withdrawAmount);
           viewBalance();

       }else{
           System.out.println("Insufficient Balance!!");
       }


    }

    @Override
    public void depositAmount(double depositAmount) {
        ministmt.put(depositAmount,"Amount deposited");
        System.out.println(depositAmount+"Deposited Successfully!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();
    }

    @Override
    public void viewMiniStatment() {
      for(Map.Entry<Double,String>m:ministmt.entrySet()){

          System.out.println(m.getKey()+""+ m.getValue());
        }

    }
}

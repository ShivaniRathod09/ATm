package org.atm.machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AtmOperation op =new AtmoOPerationImpl();
            int atmnumber=12345;//hardcode
            int atmpin=123;
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to ATM Machine!!!");
        System.out.println("Enter Atm Number:");
        int atmNumber=in.nextInt();
        System.out.println("Enter pin:");
        int pin=in.nextInt();
        if((atmNumber==atmnumber)&&(atmpin==pin)){
            while (true){
                System.out.println("1.View Available Balance\n2. Withdraw Amount\n 3. Deposit  Amount\n 4. View MinStatement\n5. Exit");

                System.out.println(" Enter Choice:");
                int ch = in.nextInt();
                if(ch==1){
                    op.viewBalance();
                } else if (ch==2) {
                    System.out.println("Enter a Amount to withdraw");
                     double withdrawAmount=in.nextDouble();
                     op.withdrawAmount(withdrawAmount);

                }else if (ch==3) {
                    System.out.println("Enter ammount to Deposit:");
                   double depositAmount=in.nextDouble();
                   op.depositAmount(depositAmount);
                }  else if (ch==4) {
                    op.viewMiniStatment();

                }else if (ch==5) {
                    System.out.println("Collect your ATM Card");
                    System.out.println("Thank you for using ATM machine!!");
                    System.exit(0);
                }else{
                    System.out.println("Please enter correct choice:");
                }




            }

        }else{
            System.out.println("Incorrect Atm Number or pin");
            System.exit(0);

        }
    }
}
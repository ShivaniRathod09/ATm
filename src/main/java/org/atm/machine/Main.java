package org.atm.machine;

import org.atm.machine.AtmOperation;
import org.atm.machine.AtmoOPerationImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AtmOperation op =new AtmoOPerationImpl();

        // Create a Map to store user ATM numbers and PINs
        Map<Integer, Integer> atmUsers = new HashMap<>();

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to ATM Machine!!!");

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Exit");
            System.out.println("Enter Choice:");

            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    login(atmUsers, op);
                    break;
                case 2:
                    createAccount(atmUsers, in);
                    break;
                case 3:
                    System.out.println("Thank you for using ATM machine!");
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid choice.");
                    break;
            }
        }
    }

    private static void login(Map<Integer, Integer> atmUsers, AtmOperation op) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter ATM Number:");
        int atmNumber = in.nextInt();

        System.out.println("Enter PIN:");
        int pin = in.nextInt();

        if (authenticate(atmUsers, atmNumber, pin)) {
            while (true) {
                System.out.println("1. View Available Balance");
                System.out.println("2. Withdraw Amount");
                System.out.println("3. Deposit Amount");
                System.out.println("4. View Mini Statement");
                System.out.println("5. Exit");
                System.out.println("Enter Choice:");

                int choice = in.nextInt();

                switch (choice) {
                    case 1:
                        op.viewBalance();
                        break;
                    case 2:
                        System.out.println("Enter Amount to Withdraw:");
                        double withdrawAmount = in.nextDouble();
                        op.withdrawAmount(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Enter Amount to Deposit:");
                        double depositAmount = in.nextDouble();
                        op.depositAmount(depositAmount);
                        break;
                    case 4:
                        op.viewMiniStatment();

                        break;
                    case 5:
                        System.out.println("Collect your ATM Card");
                        System.out.println("Thank you for using ATM machine!!");
                        System.exit(0);
                    default:
                        System.out.println("Please enter a correct choice.");
                        break;
                }
            }
        } else {
            System.out.println("Incorrect ATM Number or PIN");
        }
    }

    private static void createAccount(Map<Integer, Integer> atmUsers, Scanner in) {
        System.out.println("Enter a new ATM Number:");
        int atmNumber = in.nextInt();

        System.out.println("Enter a new PIN:");
        int pin = in.nextInt();

        atmUsers.put(atmNumber, pin);
        System.out.println("Account created successfully!");
    }

    private static boolean authenticate(Map<Integer, Integer> atmUsers, int atmNumber, int pin) {
        return atmUsers.containsKey(atmNumber) && atmUsers.get(atmNumber) == pin;
    }
}

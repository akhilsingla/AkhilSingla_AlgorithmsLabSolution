package com.gl.labSession.problem_2.computeNotes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputeNumberofNotes {
    int[] currencyDenominationArray;
    Scanner scanner;

    public void numberOfNotesNeeded() {
        try {
            System.out.println("Enter the size of currency denominations : ");
            scanner = new Scanner(System.in);

            int size = scanner.nextInt();
            currencyDenominationArray = new int[size];

            System.out.println("Enter the currency denominations value : ");

            for (int i = 0; i < size; i++) {
                currencyDenominationArray[i] = scanner.nextInt();
            }
            //sort array in descending order
            currencyDenominationArray = new MergeSort(currencyDenominationArray).sort();

            System.out.println("Enter the amount you want to pay :");
            printNumberOfNotes(scanner.nextInt());

            //in case user entered non-numeric value
        } catch (InputMismatchException e) {
            System.out.println("Expected integer values, seems invalid values entered, exiting. Bye!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }//close scanner
        finally {
            scanner.close();
        }
    }

    private void printNumberOfNotes(int amountToPay) {
        System.out.println("Your payment approach in order to give min no of notes will be : ");
        for (int i = 0; i < currencyDenominationArray.length; i++) {
            if (amountToPay == 0)
                break;

            if (amountToPay / currencyDenominationArray[i] != 0) {
                System.out.println(currencyDenominationArray[i] + ":" + (amountToPay / currencyDenominationArray[i]));
                amountToPay = amountToPay % currencyDenominationArray[i];
            }
        }
    }
}

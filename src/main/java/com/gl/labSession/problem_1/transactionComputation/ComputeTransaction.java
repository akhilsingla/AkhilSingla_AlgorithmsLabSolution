package com.gl.labSession.problem_1.transactionComputation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputeTransaction {
    int numberOfTransactions;
    int numberOfTargets;
    int[] transactionsArray;
    Scanner scanner;

    public void printNumberOfTransactions() {
        try {
            System.out.println("Enter the size of transaction array : ");

            scanner = new Scanner(System.in);
            numberOfTransactions = scanner.nextInt();

            transactionsArray = new int[numberOfTransactions];

            System.out.println("Enter the values of Array : ");

            for (int i = 0; i < numberOfTransactions; i++)
                transactionsArray[i] = scanner.nextInt();

            System.out.println("Enter the total no targets that needs to be achieved : ");
            numberOfTargets = scanner.nextInt();

            boolean flag = true;
            long totalTransactionValue = 0;
            int targetValue;
            while (numberOfTargets != 0) {
                System.out.println("\nEnter the value of target : ");
                targetValue = scanner.nextInt();

                for (int count = 0; count < transactionsArray.length; count++) {
                    totalTransactionValue = totalTransactionValue + transactionsArray[count];
                    if (totalTransactionValue >= targetValue) {
                        System.out.println("Target achieved after " + (count + 1) + " transactions");
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    System.out.println("Given target is not achieved");
                }

                totalTransactionValue = 0;
                flag = true;
                --numberOfTargets;
            }
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
}

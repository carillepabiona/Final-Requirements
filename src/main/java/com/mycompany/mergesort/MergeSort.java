/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mergesort;

import java.util.ArrayList;
import java.util.Scanner;
public class MergeSort {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        System.out.println("Enter 10 Alphabetic string with 4 characters");

        ArrayList<String> inputList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            System.out.print("Input " + (i + 1) + ": ");
            String userInput = sc.nextLine();

            if (!isValidInput(userInput)) {
                System.out.println("Invalid input! Please enter an Alphabetic String with 4 characters.");
                i--; 
            } else {
                inputList.add(userInput);
            }
        }
        mergeSort(inputList, 0, inputList.size() - 1);

        System.out.print("\nSorted Alphabetic Strings in ascending order:" + inputList);
        
        System.out.print("\nDo you want to run again? (yes/no): ");
        String choice = sc.nextLine().toLowerCase();
        if (choice.equals("yes")) {
            main(args); 
        } else {
            System.out.println("Exit program");
        }
        sc.close();
    }
        
    private static boolean isValidInput(String input) {
        return input.length() <= 4 && input.matches("^[a-zA-Z]+$");
    }

    // Merge Sort Algorithm (Recursive) for ArrayList
    private static void mergeSort(ArrayList<String> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);

            merge(list, left, mid, right);
        }
    }

    // Merge Function for Merge Sort for ArrayList
    private static void merge(ArrayList<String> list, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        ArrayList<String> leftList = new ArrayList<>(list.subList(left, left + n1));
        ArrayList<String> rightList = new ArrayList<>(list.subList(mid + 1, mid + 1 + n2));

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftList.get(i).compareTo(rightList.get(j)) <= 0) {
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j++;
            }
            k++;
        }
        while (i < n1) {
            list.set(k, leftList.get(i));
            i++;
            k++;
        }
        while (j < n2) {
            list.set(k, rightList.get(j));
            j++;
            k++;
        }
    }
    private static void displayList(ArrayList<String> list) {
        for (String element : list) {
            System.out.println(element);
        }
    }
}



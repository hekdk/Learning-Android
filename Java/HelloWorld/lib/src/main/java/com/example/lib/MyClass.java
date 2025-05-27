package com.example.lib;

import java.util.Arrays;
import java.util.Scanner;

public  class MyClass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the array:");
        String str = in.nextLine();
        String[] parts = str.trim().split(",");
        int[] array = new int[parts.length];
        for(int i = 0; i<parts.length; i++){
            array[i] = Integer.parseInt(parts[i]);
        };
        MyClass.Average(array);
    }


    public static void Average(int[] array) {
        int n = array.length;
        int sum = 0;
        for (int i = 0; i< array.length; i++){
            sum+= array[i];
        }
        System.out.println("The average of elements in the array is:" + (double)sum/n);
    }
}







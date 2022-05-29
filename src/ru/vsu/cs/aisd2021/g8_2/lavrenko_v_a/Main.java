package ru.vsu.cs.aisd2021.g8_2.lavrenko_v_a;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 2, 3, 1, 1, 1, 7, 4, 5, 3, 2, 1};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Answer: " + Solution.maxFrequency(arr));
    }
}

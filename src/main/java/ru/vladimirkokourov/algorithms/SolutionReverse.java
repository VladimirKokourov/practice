package ru.vladimirkokourov.algorithms;

public class SolutionReverse {

    public void reverse(String[] arr) {
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            swap(arr, i, arr.length - 1 - i);
        }
    }

    private void swap(String[] arr, int first, int second) {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

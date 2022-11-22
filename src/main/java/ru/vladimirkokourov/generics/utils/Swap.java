package ru.vladimirkokourov.generics.utils;

public class Swap {
    public static <T> void process(T[] arr, int firstIndex, int secondIndex) {
        T c = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = c;
    }
}

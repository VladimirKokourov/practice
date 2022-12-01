package ru.vladimirkokourov.algorithms;

public class SolutionCountChangesOfSign {

    public int countChangesOfSign(int[] arr) {
        int result = 0;
        int n = arr.length - 1;

        for (int i = 0; i < n; i++) {
            if ((arr[i] >= 0 && arr[i + 1] < 0) || (arr[i] < 0 && arr[i + 1] >= 0)) {
                result++;
            }
        }

        return result;
    }
}

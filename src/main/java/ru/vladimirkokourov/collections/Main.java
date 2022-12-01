package ru.vladimirkokourov.collections;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//         1. ������� ������ � ������� ���� (10-20 ����, ������ ����������� �������������).
//         ����� � ������� ������ ���������� ����, �� ������� ������� ������ (��������� �� �������).
//         ��������� ������� ��� ����������� ������ �����.

        String[] words = {"cat", "dog", "red", "bad", "cat", "dog", "cat", "sad", "mad", "daddy", "pit", "set", "red"};

//        Map<String, Integer> map = Arrays.stream(words)
//                .collect(Collectors.toMap(
//                        Function.identity(),
//                        x -> 1,
//                        Integer::sum
//                ));
//        System.out.println(map);


//         2. �������� ������� ����� ��������������������, ������� ������ � ���� ������ ������� � ���������� �������.
//         � ���� ���������� ���������� � ������� ������ add() ����� ��������� ������. � ������� ������ get() ������
//         ����� �������� �� �������. ������� ������, ��� ��� ����� �������� ����� ���� ��������� ��������� (� ������
//         �������������), ����� ��� ������� ����� ������� ������ ���������� ��� ��������.

        findFrequencies(words);

        Phone phBook = new Phone();
        phBook.add("2", "89456523132");
        phBook.add("1", "89459842153");
        phBook.add("3", "89455122132");
        phBook.add("1", "89135558889");
        phBook.add("4", "89235689781");
//        phBook.add("5", "89159882221");
//        phBook.add("6", "89416548877");
//        phBook.add("7", "89894561133");

        phBook.get("1").clear();

    }

    //n - words.length
    //O(n) time
    //O(n) space
    public static Map<String, Integer> findFrequencies(String[] words) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String x : words) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }

        System.out.println(hashMap);

        return hashMap;
    }
}

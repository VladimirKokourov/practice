package ru.vladimirkokourov.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//         1. ������� ������ � ������� ���� (10-20 ����, ������ ����������� �������������).
//         ����� � ������� ������ ���������� ����, �� ������� ������� ������ (��������� �� �������).
//         ��������� ������� ��� ����������� ������ �����.

        String[] words = {"cat", "dog", "red", "bad", "cat", "dog", "cat", "sad", "mad", "daddy", "pit", "set", "red"};
        Map<String, Integer> map = Arrays.stream(words)
                .collect(Collectors.toMap(
                        Function.identity(),
                        x -> 1,
                        Integer::sum
                ));
        System.out.println(map);

//         2. �������� ������� ����� ��������������������, ������� ������ � ���� ������ ������� � ���������� �������.
//         � ���� ���������� ���������� � ������� ������ add() ����� ��������� ������. � ������� ������ get() ������
//         ����� �������� �� �������. ������� ������, ��� ��� ����� �������� ����� ���� ��������� ��������� (� ������
//         �������������), ����� ��� ������� ����� ������� ������ ���������� ��� ��������.

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String x : words) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        System.out.println(hashMap);

        Phone phBook = new Phone();
        phBook.add("��������", "89456523132");
        phBook.add("������", "89459842153");
        phBook.add("�������", "89455122132");
        phBook.add("������", "89135558889");
        phBook.add("���������", "89235689781");
        phBook.add("��������", "89159882221");
        phBook.add("������", "89416548877");
        phBook.add("��������", "89894561133");

        System.out.println("���: " + phBook.get("��������"));
        System.out.println("���: " + phBook.get("������"));
    }
}

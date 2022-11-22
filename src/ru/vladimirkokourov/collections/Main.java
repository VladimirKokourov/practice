package ru.vladimirkokourov.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//         1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//         Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//         Посчитать сколько раз встречается каждое слово.

        String[] words = {"cat", "dog", "red", "bad", "cat", "dog", "cat", "sad", "mad", "daddy", "pit", "set", "red"};
        Map<String, Integer> map = Arrays.stream(words)
                .collect(Collectors.toMap(
                        Function.identity(),
                        x -> 1,
                        Integer::sum
                ));
        System.out.println(map);

//         2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
//         В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать
//         номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае
//         однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String x : words) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        System.out.println(hashMap);

        Phone phBook = new Phone();
        phBook.add("Кузнецов", "89456523132");
        phBook.add("Якушев", "89459842153");
        phBook.add("Морозов", "89455122132");
        phBook.add("Петров", "89135558889");
        phBook.add("Прокофьев", "89235689781");
        phBook.add("Воробьев", "89159882221");
        phBook.add("Дидков", "89416548877");
        phBook.add("Кузнецов", "89894561133");

        System.out.println("Тел: " + phBook.get("Кузнецов"));
        System.out.println("Тел: " + phBook.get("Петров"));
    }
}

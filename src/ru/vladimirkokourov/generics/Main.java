package ru.vladimirkokourov.generics;

import ru.vladimirkokourov.generics.task2.Apple;
import ru.vladimirkokourov.generics.task2.Box;
import ru.vladimirkokourov.generics.task2.Orange;
import ru.vladimirkokourov.generics.utils.Swap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);

        System.out.println("Swap:");
        String[] arr = new String[]{"str1", "str2", "str3"};
        System.out.println(Arrays.toString(arr));
        Swap.process(arr, 0, 2);
        System.out.println(Arrays.toString(arr));

//        a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//        b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну
//        коробку нельзя сложить и яблоки, и апельсины;
//        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//        d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
//        (вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//        e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую
//        подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с
//        яблоками мы можем сравнивать с коробками с апельсинами);
//        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про
//        сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке
//        фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
//        g. Не забываем про метод добавления фрукта в коробку.

        System.out.println("Big task");
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();
        Orange o1 = new Orange();
        Orange o2 = new Orange();
        Orange o3 = new Orange();
        Box<Apple> appleBox = new Box<>();
        appleBox.put(a1, a2, a3);
        Box<Orange> orangeBox = new Box<>();
        orangeBox.put(o1, o2);
        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.put(o1, o2, o3);
        System.out.println("Apple box weight: " + appleBox.getWeight());
        System.out.println("Orange box weight: " + orangeBox.getWeight());
        System.out.println("Orange box 2 weight: " + orangeBox2.getWeight());
        System.out.println("Apple box compare Orange box: " + appleBox.compare(orangeBox));
        System.out.println("Orange box compare Orange box 2: " + orangeBox.compare(orangeBox2));
        System.out.println("Orange box 2 -> Orange box");
        orangeBox.putAll(orangeBox2);
        System.out.println("Orange box weight: " + orangeBox.getWeight());
        System.out.println("Orange box 2 weight: " + orangeBox2.getWeight());
        System.out.println("Apple box: " + appleBox);
        System.out.println("Orange box: " + orangeBox);
        System.out.println("Orange box 2: " + orangeBox2);
    }
}

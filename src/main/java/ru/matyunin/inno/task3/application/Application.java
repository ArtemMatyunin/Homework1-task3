package ru.matyunin.inno.task3.application;

import ru.matyunin.inno.task3.model.People;
import ru.matyunin.inno.task3.service.*;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    private static void userCommand(People[] peoples, int command) {
        switch (command) {
            case 1: {
                Sortable sortable = new QuickSortWay();
                System.out.println();
                long start = System.nanoTime();
                System.out.println(Arrays.toString(sortable.sortPeoplesArray(peoples)));
                System.out.println(System.nanoTime() - start);
                break;
            }
            case 2: {
                Sortable sortable1 = new MergeSortWay();
                System.out.println();
                long start = System.nanoTime();
                System.out.println(Arrays.toString(sortable1.sortPeoplesArray(peoples)));
                System.out.println(System.nanoTime() - start);
                break;

            }
            default:
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GeneratedPeoplesArray generated = new GeneratedPeoplesArrayImpl();
        System.out.println("Введите количество элементов массива");
        int arraySize = scanner.nextInt();
        scanner.nextLine();
        People[] peoples = generated.generatePeoplesArray(arraySize);
        int command = 0;
        while (command != 3) {
            System.out.println("Введите 1 для сортировки 'пузырьком', 2 для сортировки 'слиянием' или 3 для выхода");
            command = scanner.nextInt();
            scanner.nextLine();
            userCommand(peoples, command);
        }
    }


}

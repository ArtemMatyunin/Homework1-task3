package ru.matyunin.inno.task3.service;

import ru.matyunin.inno.task3.model.People;

public class QuickSortWay implements Sortable {
    @Override
    public People[] sortPeoplesArray(People[] peoples) {
        quickSort(peoples, 0, peoples.length - 1);

        return peoples;
    }

    private int partition(People[] peoples, int begin, int end) {
        int pivot = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (peoples[i].comparePeoples(peoples[pivot]) < 0) {
                People temp = peoples[counter];
                peoples[counter] = peoples[i];
                peoples[i] = temp;
                counter++;
            }
        }
        People temp = peoples[pivot];
        peoples[pivot] = peoples[counter];
        peoples[counter] = temp;

        return counter;
    }

    private void quickSort(People[] array, int begin, int end) {
        if (end <= begin){
            return;
        }
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
}

package ru.matyunin.inno.task3.service;

import ru.matyunin.inno.task3.model.People;

public class MergeSortWay implements Sortable {
    @Override
    public People[] sortPeoplesArray(People[] peoples) {
            mergeSort(peoples, 0, peoples.length - 1);
        return peoples;
    }

    private void mergeSort(People[] peoples, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(peoples, left, mid);
        mergeSort(peoples, mid + 1, right);
        merge(peoples, left, mid, right);
    }

    private void merge(People[] array, int left, int mid, int right) {
        int lengthLeftPeoples = mid - left + 1;
        int lengthRightPeoples = right - mid;

        People[] leftPeoples = new People[lengthLeftPeoples];
        People[] rightPeoples = new People[lengthRightPeoples];

        for (int i = 0; i < lengthLeftPeoples; i++)
            leftPeoples[i] = array[left + i];
        for (int i = 0; i < lengthRightPeoples; i++)
            rightPeoples[i] = array[mid + i + 1];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = left; i < right + 1; i++) {
            if (leftIndex < lengthLeftPeoples && rightIndex < lengthRightPeoples) {
                if (leftPeoples[leftIndex].comparePeoples(rightPeoples[rightIndex]) < 0) {
                    array[i] = leftPeoples[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightPeoples[rightIndex];
                    rightIndex++;
                }
            }
            else if (leftIndex < lengthLeftPeoples) {
                array[i] = leftPeoples[leftIndex];
                leftIndex++;
            }
            else if (rightIndex < lengthRightPeoples) {
                array[i] = rightPeoples[rightIndex];
                rightIndex++;
            }
        }
    }
}

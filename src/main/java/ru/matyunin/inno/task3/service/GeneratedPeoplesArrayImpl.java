package ru.matyunin.inno.task3.service;

import ru.matyunin.inno.task3.model.Names;
import ru.matyunin.inno.task3.model.People;

import java.util.Arrays;
import java.util.Random;

public class GeneratedPeoplesArrayImpl implements GeneratedPeoplesArray {
    @Override
    public People[] generatePeoplesArray(int countPeople) {
        People[] peoples = new People[countPeople];
        for (int i = 0; i < countPeople; i++) {
            peoples[i] = generatePeople();
        }

        return peoples;
    }

    private People generatePeople() {
        Random random = new Random();

        int checkName = random.nextInt(198);
        String sex;
        if (checkName < 100) {
            sex = People.Sex.MAN.getSexTitle();
        } else {
            sex = People.Sex.WOMAN.getSexTitle();
        }
        String name = Names.values()[checkName].getTitle();
        int age = random.nextInt(100);

        return new People(name, sex, age);
    }


}

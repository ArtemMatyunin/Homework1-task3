package ru.matyunin.inno.task3.model;

import java.util.Comparator;
import java.util.Objects;

public class People {
    private final String peopleName;
    private final String peopleSex;
    private final int peopleAge;

    public People(String peopleName, String peopleSex, int peopleAge) {
        this.peopleName = peopleName;
        this.peopleSex = peopleSex;
        this.peopleAge = peopleAge;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public String getPeopleSex() {
        return peopleSex;
    }

    public int getPeopleAge() {
        return peopleAge;
    }

    public int comparePeoples(People o1) {
        Comparator<People> comp = new People.PeoplesSexComparator()
                .thenComparing(new People.PeoplesAgeComparator())
                .thenComparing(new People.PeoplesNameComparator());
        int result = 0;
        try {
            result = comp.compare(this, o1);
            if (result == 0) {
                throw new IllegalStateException("есть совпадения { " + "Name: "
                        + this.getPeopleName() + " | " + "Age: "
                        + this.getPeopleAge() + " }");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public enum Sex {
        WOMAN("WOMAN"),
        MAN("MAN");

        private final String sexTitle;

        Sex(String sexTitle) {
            this.sexTitle = sexTitle;
        }

        public String getSexTitle() {
            return sexTitle;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return peopleAge == people.peopleAge && Objects.equals(peopleName, people.peopleName) && Objects.equals(peopleSex, people.peopleSex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peopleName, peopleSex, peopleAge);
    }

    @Override
    public String toString() {
        return '\n'
                + "{ " + peopleName + " | " + peopleSex + " | " + peopleAge + " }";
    }

    public static class PeoplesAgeComparator implements Comparator<People> {

        @Override
        public int compare(People o1, People o2) {

            return Integer.compare(o2.getPeopleAge(), o1.getPeopleAge());

        }
    }

    public static class PeoplesSexComparator implements Comparator<People> {

        @Override
        public int compare(People o1, People o2) {

            return o1.getPeopleSex().compareTo(o2.getPeopleSex());

        }

    }

    public static class PeoplesNameComparator implements Comparator<People> {

        @Override
        public int compare(People o1, People o2) {

            return o1.getPeopleName().compareTo(o2.getPeopleName());

        }

    }
}
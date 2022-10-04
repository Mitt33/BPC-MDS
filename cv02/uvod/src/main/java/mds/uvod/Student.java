package mds.uvod;

public class Student {

    private String surname;
    private String name;
    private int id;
    private int year;

    public Student(String surname, String name, int id, int year){
        this.surname = surname;
        this.name = name;
        this.id = id;
        this.year = year;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString(){
        return String.format("Student: <b>%s %s</b> ID: %d YEAR: %d", name, surname, id, year);
    }

}

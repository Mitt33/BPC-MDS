package cz.vutbr.mds.cv01;

import java.awt.desktop.SystemEventListener;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;

public class MyClass implements ISum{
    private static int count = 0;
    private ArrayList<Integer> list = new ArrayList<>();

    public MyClass(){
        count++;
    }
    public MyClass(int...numbers) throws IllegalArgumentException {
        this();

        for (int i: numbers) {
            addInteger(i);
        }
    }


    public static int getCount(){
        return count;
    }
    public static MyClass createUnited(MyClass prvni, MyClass druhy){
        MyClass newObject = new MyClass();
        newObject.list.addAll(prvni.list);
        newObject.list.addAll(druhy.list);

        return newObject;
    }

    public void addInteger(int i) throws IllegalArgumentException {
        if (i > 0){
            list.add(i);
        }
        else {
            throw new IllegalArgumentException("Nelze vlozit zaporna cisla");
        }
    }

    public boolean integerExist (int i){
        return list.contains(i);
    }

    @Override
    public String toString(){
        return "Pole o velikosti " + list.size() + " se souctem " + sum();
    }

    @Override
    public int sum(){
        int sum = 0;
        for (int i: list){
            sum += i;
        }
        return sum;

    }

    public void print(){
        System.out.print("Seznam (" + list.size() + "): ");
        for (int i: list){
            System.out.print(i + ", ");
        }
        System.out.println();
    }

}

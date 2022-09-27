import cz.vutbr.mds.cv01.MyClass;

public class Main {
    public static void main(String[] args) {
        MyClass prvni = new MyClass();
        MyClass druhy = new MyClass();
        MyClass treti = null;

        try{
            treti = new MyClass(1,4,5,6);
            prvni.addInteger(20);
            prvni.addInteger(25);
            prvni.addInteger(30);
            druhy.addInteger(5);
            druhy.addInteger(20);
        }
        catch (IllegalArgumentException e){
            System.err.println("Chyba " + e.getMessage());
        }

        System.out.println("pocet vytvorenych trid: " + MyClass.getCount());
        System.out.println("Existuje v obj 3 cislo 4?" + treti.integerExist(4));
        MyClass united = MyClass.createUnited(prvni, druhy);
        united.print();
        System.out.println(united);

    }

}

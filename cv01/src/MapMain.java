import cz.vutbr.mds.cv01.MapClass;
public class MapMain {
    public static void main(String[] args) {
        MapClass mapa = new MapClass();

        mapa.store(100, "stovecka");
        mapa.store(50, "pade");
        mapa.store(10, "deset");

        System.out.println("velikost je:" + mapa.getSize());

        mapa.deleteKey(10);
        System.out.println("velikost je:" + mapa.getSize());
        mapa.store(16, "sestnact");
        mapa.print();

    }
}

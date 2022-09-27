package cz.vutbr.mds.cv01;

import java.util.HashMap;

public class MapClass {
    private HashMap<Integer,String> mapa = null;

    public MapClass(){
        mapa = new HashMap<>();
    }

    public void store(Integer id, String value) throws ArrayStoreException {
        try {
            mapa.put(id, value);
        } catch (ArrayStoreException e) {
            System.out.println("prvek je jiz namapovan");
        }
    }
    public String getValue(Integer id)throws NoSuchFieldError{
        try{
            return mapa.get(id);
        }
        catch (NoSuchFieldError e){
            System.out.println("neni namapovan");
            return null;
        }
    }
    public void deleteKey(Integer id)throws NoSuchFieldError{
        try{
            mapa.remove(id);
        }
        catch(NoSuchFieldError e){
            System.out.println("neni namapovan");
        }
    }
    public int getSize(){
        return mapa.size();
    }
    public void print(){
        for (int id: mapa.keySet()
             ) {
            System.out.println(id+"->"+getValue(id));
        }
    }


}

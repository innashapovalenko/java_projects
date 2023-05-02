import java.util.ArrayList;

public class StringStringDictionary implements StringStringDictionaryADT{

    // ArrayList <String> arrKey = new ArrayList <String>();
    // ArrayList <String> arrVal = new ArrayList <String>();
    private ArrayList<Entry> entries = new ArrayList<>();;

    public String key;
    public String value;

    class Entry{
        private String key;
        private String value;

        private Entry(String key, String value){
            this.key = key;
            this.value = value;
        }
        
    }


    public void put(String key, String value){
        
        if (containsKey(key)){
            for (int i=0; i < entries.size(); i++){
                if (entries.get(i).key.equals(key)){
                    entries.get(i).value = value;
                }
            }
        }
        else{
            this.entries.add(new Entry(key, value));
        }
    }

    public String get(String key){
        for (int i=0; i < entries.size(); i++){
            if (entries.get(i).key.equals(key)){
                return entries.get(i).value;
            }
        }
        

        return null;
       
    }

    public String remove(String key){
        for (int i=0; i < entries.size(); i++){
            if (entries.get(i).key.equals(key)){
                String returnVal = entries.get(i).value;
                entries.remove(entries.get(i));
                return returnVal;
                
            }
        }
        
        return null;
        
    }

    public boolean containsKey(String key){
        for (int i=0; i < entries.size(); i++){
            if (entries.get(i).key.equals(key)){
                return true;
                
            }
        }
        return false;
    }
}

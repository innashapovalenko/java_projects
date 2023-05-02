import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Translator {
    
    public String key;
    public String value;
    public StringStringDictionary dictionary;

    public Translator(){
        dictionary = new StringStringDictionary();
    }

    public Translator(String NameDictionaryFile){
        try{
            dictionary = new StringStringDictionary();
            File myObj = new File(NameDictionaryFile);
            Scanner read = new Scanner(myObj);
            while (read.hasNextLine()) {
                String data = read.nextLine();
                String[] dataArray = data.split(" ");
                key = dataArray[0];
                if (dataArray.length > 2){
                    for (int i =1; i<dataArray.length; i++){
                        value += dataArray[i];
                    }
                }
                
                dictionary.put(key, value);
        }
        }
        catch(FileNotFoundException e){
            System.out.println("file is not found");
        }
        
        // System.out.println("dictionary has these keys");
    }


    public void addTranslation(String from, String to){
        dictionary.put(from, to);
    }

    public String translate(String input){
        String[] dataArray = input.split(" ");
        String result = "";
        String [] finRes = new String[dataArray.length];

        for (int i =0; i<dataArray.length; i++){
            if (dictionary.containsKey(dataArray[i])){
                finRes[i] = dictionary.get(dataArray[i]);
            }
        }
        result = String.join(" ", finRes);
        return result;
    }


}

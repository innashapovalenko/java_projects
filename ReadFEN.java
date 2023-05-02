import java.io.File;
import java.util.Scanner;

public class ReadFEN {

    public static void main(String[] args) throws Exception {
        String input = args[0];
        // File myFile = new File("valid3.txt");
        File myFile = new File(input);
        Scanner scan = new Scanner(myFile);
        try{
            String info = "";
        
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                info += line;
                
            }
            String [] board = info.split("/");
            //checking the number of rows
            if (board.length > 8){
                throw new IllegalArgumentException();
            }
            else if (board.length < 8){
                throw new IllegalArgumentException();
            }
            String [] finalarray = new String[8];
            //for each row  
            for (int k =0; k <8; k++){
                String row = "";
                String element = board[k]; //the whole line
                //line in array to have access for each element
                char[] arr = element.toCharArray();
                int numElement = 0;
                // element is the whole line 
                for (int j = 0; j < element.length(); j++){

                    int a = Character.getNumericValue(arr[j]);
                    
                    if (j > 0){
                    
                        char elementf = arr[j];
                        char elementpf = arr[j-1];
                        int f = Character.getNumericValue(elementf);
                        int pf = Character.getNumericValue(elementpf);

                        if ((f == 1 || f==2 || f==3|| f==4 || f==5|| f==6 || f==7 || f==8) && (pf == 1 || pf==2 || pf==3|| pf==4 || pf==5|| pf==6 || pf==7 || pf==8)){
                            throw new IllegalArgumentException();
                        }              
                    }

                    if (a == 1 || a==2 || a==3|| a==4 || a==5|| a==6 || a==7 || a==8){
                        row += ".".repeat(a);
                        numElement += a;
                    }          
                    else if (arr[j] == 'p' || arr[j] == 'P' || arr[j] == 'n' || arr[j] =='N' || arr[j] =='b'|| arr[j] =='B' || arr[j] == 'r'|| arr[j] =='R'|| arr[j] =='q'|| arr[j] =='Q' || arr[j] == 'k'|| arr[j] =='K'){
                        row += arr[j];
                        numElement += 1;
                    }

                    else{
                        throw new IllegalArgumentException();
                    }
                }
                if (numElement != 8){
                    throw new IllegalArgumentException();
                }
                finalarray[k] = row;
               

        }
        for (int l = 0; l < 8; l++){
            System.out.println(finalarray[l]);
        }
        
        }
        
        catch (IllegalArgumentException e){
            System.out.println("invalid input");
        }
        
    }
    
    
}

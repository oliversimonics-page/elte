package java7.text.to.numbers;
import java.io.*;


public class SingleLineFile{
    public static int addNumbers(String source) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(source));){
            String line;
            if((line=br.readLine()) == null){
                throw new IllegalArgumentException("Empty file.");
            }
            String[] nums = line.split(" ");
            int sum = 0;
            for(int i=0; i<nums.length; i++){
                try{
                    sum += Integer.parseInt(nums[i]);
                }
                catch(NumberFormatException e){
                    System.err.println(nums[i]);
                }
            }
            return sum;
        }
        
    }
}
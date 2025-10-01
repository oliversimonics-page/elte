package java07.demo;

import java.io.*;

public class ReadWrite{
    public static String readFromStandardInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static void readFromFile(String source) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(source));
        String line;
        while((line=br.readLine()) != null){
            //process
            System.out.println(line);
        }
        System.out.println();
        br.close(); 
    }

    public static void writeToFile(String[] data, String dastF) throws IOException {
        PrintWriter wr = new PrintWriter(new BufferedWriter( new FileWriter(dastF, true)));
        for(String s : data){
            wr.print(s);
        }
        wr.close();
    }

    public static void main(String[] args){
        String[] str = new String[3];
        String sourceF = "java7/demo/source.txt";
        String destF = "java7/demo/result.txt";
        try{
            readFromFile(sourceF);
        }
        catch(IOException e){
            System.out.println("IT was an exception" + e.getMessage());
        }

        try{
            for(int i = 0;i <str.length; i++){
                System.out.print((i+1)+".:");
                str[i] = readFromStandardInput();
                System.out.println("You wrote this: " + str[i]);
            }
            writeToFile(str, destF);
        }
        catch(IOException e){
            System.out.println("IT was an exception" + e.getMessage());
        }
    }
}
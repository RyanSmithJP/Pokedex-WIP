package com.company;
import java.io.*; //input/output
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) throws IOException {
        // create file
        File file1 = new File("pokedex.txt");
        //file writer
        FileWriter fw = new FileWriter(file1);
        //print writer
        PrintWriter pw = new PrintWriter(fw);

        Scanner sc = new Scanner(System.in);

        dexEntry[] myEntries = new dexEntry[9];

        int input = JOptionPane.showConfirmDialog(null,"Create new poxedex?\n" +
                "This will overwrite existing data!");
        if(input == 0){
            for(int i = 0; i < myEntries.length; i++){
                myEntries[i] = new dexEntry();
            }
            updateDex(pw, myEntries, sc);
        }
        //read dex
        //read csv file
        readDex(pw,file1,fw);
//        updateDex(pw, myEntries, sc);
//        readDex(pw,file1,fw);
    }

    private static void readDex(PrintWriter pw, File file1, FileWriter fw) throws IOException {
        String file = "pokedex.txt";
        BufferedReader reader = null;
        String line = "";
        try{
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String [] row = line.split(",");
                for(String index : row ){
                    System.out.printf("%20s", index);
                }
                System.out.println();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            reader.close();
        }
    }

    private static void updateDex(PrintWriter pw, dexEntry myEntries[], Scanner sc) {
        System.out.println("Choose a pokemon you caught");
        String starter = sc.next();
        for(int i = 0; i < myEntries.length; i++){
            if(starter.equalsIgnoreCase(myEntries[i].getName(starter))){
                myEntries[i].updateDex(starter);
            }
        }
        System.out.println("Overwriting. . .");
        pw.printf("%20s","Pokemon Name");
        pw.printf("%20s","Caught");
        pw.printf("%20s","Encountered\n");
        for(int i = 0; i < 9; i++) {
            myEntries[i].getInfo(pw);
        }
        pw.close();
    }
}

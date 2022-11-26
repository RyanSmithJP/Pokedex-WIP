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
        //print writer

        Scanner sc = new Scanner(System.in);

        dexEntry[] myEntries = new dexEntry[57];

        int input = JOptionPane.showConfirmDialog(null,"Create new poxedex?\n" +
                "This will overwrite existing data!");
        if(input == 0){
            for(int i = 0; i < myEntries.length; i++){
                myEntries[i] = new dexEntry();
            }
            updateDex(myEntries, sc, file1);
        }
        input = JOptionPane.showConfirmDialog(null, "Read latest pokedex?");
        if(input == 0){
            readDex(file1);
        }
    }
        //read dex
        //read csv file
        //updateDex(myEntries, sc, file1);
        //readDex(file1);


    private static void readDex(File file1) throws IOException {
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

    private static void updateDex(dexEntry myEntries[], Scanner sc, File file1) throws IOException {
        //Make new instances each time
        FileWriter fw = new FileWriter(file1);
        PrintWriter pw = new PrintWriter(fw);
        String newPokemon;
        do{
            System.out.println("Choose a pokemon you caught.\nType 'Stop' once you're finished.");
            newPokemon = sc.next();
            if(newPokemon.equalsIgnoreCase("Nidoran")){
                String tmp = "";
                do{
                    System.out.println("Enter your Nidoran's gender (M/F)");
                    tmp = sc.next();
                }while(!tmp.equalsIgnoreCase("m") && !tmp.equalsIgnoreCase("f"));
                if(tmp.equalsIgnoreCase("m")){
                    newPokemon = "Nidoran(M)";
                }
                else{
                    newPokemon = "Nidoran(F)";
                }
            }
            for(int i = 0; i < myEntries.length; i++){
                if(newPokemon.equalsIgnoreCase(myEntries[i].getName(newPokemon))){
                    myEntries[i].updateDex(newPokemon);
                }
            }
        }while (!newPokemon.equalsIgnoreCase("Stop"));
        System.out.println("Overwriting. . .");
        pw.printf("%20s","Pokemon Name");
        pw.printf("%20s","Caught");
        pw.printf("%20s","Encountered\n");
        for(int i = 0; i < myEntries.length; i++) {
            myEntries[i].getInfo(pw);
        }
        pw.close();
    }
}

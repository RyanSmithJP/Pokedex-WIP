package com.company;

import java.io.PrintWriter;

public class dexEntry {
    private String pokemonName = "";
    private String displayName = "???";
    private int caught = 0;
    private boolean encountered = false;
    private static int No = 1;
    dexEntry(){
        this.pokemonName = getName(No);
        this.No++;
    }
    public void getInfo(PrintWriter pw){
        pw.println(this.displayName+","+this.caught+","+this.encountered);
    }
    public String getName(int id){
        switch(id){
            case 1: return "Bulbasaur";
            case 2: return "Ivysaur";
            case 3: return "Venusaur";
            case 4: return "Charmander";
            case 5: return "Charmeleon";
            case 6: return "Charizard";
            case 7: return "Squirtle";
            case 8: return "Wartortle";
            case 9: return "Blastoise";
        }
        return "ERROR";
    }
    public String getName(String name){
        if(name.equalsIgnoreCase(this.pokemonName)) {
            return this.pokemonName;
        }
        return "ERROR";
    }
    public void updateDex(String pokemon){
        this.displayName = this.pokemonName;
        System.out.println("NEW NAME: "+this.displayName);
        this.caught++;
        this.encountered=true;
    }
}

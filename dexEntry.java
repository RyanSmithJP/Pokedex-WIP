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
        //System.out.println("Writing "+this.displayName);
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
            case 10: return "Caterpie";
            case 11: return "Metapod";
            case 12: return "Butterfree";
            case 13: return "Weedle";
            case 14: return "Kakuna";
            case 15: return "Beedrill";
            case 16: return "Pidgey";
            case 17: return "Pidgeotto";
            case 18: return "Pidgeot";
            case 19: return "Rattata";
            case 20: return "Raticate";
            case 21: return "Spearow";
            case 22: return "Fearow";
            case 23: return "Ekans";
            case 24: return "Arbok";
            case 25: return "Pikachu";
            case 26: return "Raichu";
            case 27: return "Sandshrew";
            case 28: return "Sandslash";
            case 29: return "Nidoran(F)";
            case 30: return "Nidorina";
            case 31: return "Nidoqueen";
            case 32: return "Nidoran(M)";
            case 33: return "Nidorino";
            case 34: return "Nidoking";
            case 35: return "Clefairy";
            case 36: return "Clefable";
            case 37: return "Vulpix";
            case 38: return "Ninetales";
            case 39: return "Jigglypuff";
            case 40: return "Wigglytuff";
            case 41: return "Zubat";
            case 42: return "Golbat";
            case 43: return "Oddish";
            case 44: return "Gloom";
            case 45: return "Vileplume";
            case 46: return "Paras";
            case 47: return "Parasect";
            case 48: return "Venonat";
            case 49: return "Venomoth";
            case 50: return "Diglett";
            case 51: return "Dugtrio";
            case 52: return "Meowth";
            case 53: return "Persian";
            case 54: return "Psyduck";
            case 55: return "Golduck";
            case 56: return "Manky";
            case 57: return "Primeape";
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
        //System.out.println("NEW NAME: "+this.displayName);
        this.caught++;
        this.encountered=true;
    }
}

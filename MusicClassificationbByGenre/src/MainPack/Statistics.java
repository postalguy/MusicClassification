/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPack;

/**
 *
 * @author iamsmile
 */
public class Statistics {
 
     private   int nb_rock;
     private int nb_jazz;
     private int nb_classic;
     private int nb_folk;
     
     
    public Statistics(int nb_rock, int nb_jazz, int nb_classic, int nb_folk) {
        this.nb_rock = nb_rock;
        this.nb_jazz = nb_jazz;
        this.nb_classic = nb_classic;
        this.nb_folk = nb_folk;
    }

    public int getNb_rock() {
        return nb_rock;
    }

    public void setNb_rock(int nb_rock) {
        this.nb_rock = nb_rock;
    }

    public int getNb_jazz() {
        return nb_jazz;
    }

    public void setNb_jazz(int nb_jazz) {
        this.nb_jazz = nb_jazz;
    }

    public int getNb_classic() {
        return nb_classic;
    }

    public void setNb_classic(int nb_classic) {
        this.nb_classic = nb_classic;
    }

    public int getNb_folk() {
        return nb_folk;
    }

    public void setNb_folk(int nb_folk) {
        this.nb_folk = nb_folk;
    }
     
     @Override
    public String toString(){
    return "Statistiques : \n\tClassique ="+getNb_classic()+"\n\tFolk ="+getNb_folk()+"\n\tRock ="+getNb_rock()+"\n\tJazz ="+getNb_jazz()+"\n";
    }
     
    
    public void IncRock(){
        nb_rock++;
    }
     public void IncClassic(){
        nb_classic++;
    }
      public void IncFolk(){
        nb_folk++;
    }
       public void IncJazz(){
        nb_jazz++;
    }
    
}

package Utilities;

import MainPack.Statistics;

/**
 *
 * @author AKRIM ISMAIL
 */
public class ArrayTools {
    
    
    
    public static double GetMax(double[] array){
        if(array == null){
        return 0.0; 
        }else{
    double max= array[0];
    for (int j=0;j<array.length;j++){
        if(array[j]>max) max = array[j];}
        return max;
        }
    }
    
    public static int getRank(double[] array){
    double max = GetMax(array);
    int rank = 0;
        for(int i=0; i<array.length;i++){
                                        if (array[i]== max) {
                                        rank = i;
                                        }
                                        }
        return rank;
    }
    
    public static String getGenre(double[] array,Statistics st){
    switch (getRank(array)){
        case 0 : st.IncRock(); return "Rock";      
        case 1 :  st.IncClassic(); return "Classique";
        case 2 : st.IncJazz();return "Jazz";
        case 3 : st.IncFolk();return "Folk";
        default : return "non identifié";
    }
    }
   
    /*public static int Mismatches(String[] st1, String[] st2){
        int mismatches=0;
        for (int i = 0; i < st1.length; i++) {
            
           if(!st1[i].equals(st2[i])) mismatches++;
            
        }
    return mismatches;}
    
    public static double ErrorRate(int mis){
        return mis/100;
    }*/
    
    
}

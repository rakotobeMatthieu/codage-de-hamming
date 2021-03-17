/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fonction;

import java.util.ArrayList;

/**
 *
 * @author Tsiry
 */
public class Hamming {
    
    public static void main(String[] args) throws Exception {
        String[] lbc = new String[7];
        lbc[0]="001";
        lbc[1]="010";
        lbc[2]="011";
        lbc[3]="100";
        lbc[4]="101";
        lbc[5]="110";
        lbc[6]="111";
//        Affiche.affTabString(lbc); 

        String[][] tab = Traitement.getTabChar(lbc);
        Affiche.affMatrice(tab);
        
        String[][] result = Traitement.transpose(tab);
        Affiche.affMatrice(result);
        
        
        
    }
    
    
}

















/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fonction;

import com.mysql.jdbc.StringUtils;
import java.io.File;

/**
 *
 * @author Tsiry
 */
public class Traitement {
    
    public static String[]  addMot( String[] mot , int p , String[][] m ){
        String[] r = new String[ mot.length ];
        
        return r ;
    }
    
    public static int valu(String[] ls , String[] mot){
        int a = 0 ;
        String chaine="";
        for( int i = 0 ; i < ls.length ; i++ ){
            if( ls[i] == "1" ){
                chaine = chaine + mot[i]; 
            }
        }
//        a = chaine.
        a = chaine.length() - chaine.replace("1", "").length();
        return a ;
    }
    
    
    public static String[][] getTabChar(String[] ls) {
        String[][] tab = new String[ ls.length ][ ls[0].length() ] ;
        for(int i = 0 ; i < ls.length ;i++){
            char[] tmp=  ls[i].toCharArray();
            for( int j = 0 ; j < tmp.length ; j++ ){
                tab[i][j] =  tmp[j] + "" ;
            }
        }
        return tab;
    }
    
    public static String[][] transpose( String[][] ls ){
        String[][] tab = new String[ ls[0].length ][ ls.length  ] ;
            for( int i = 0 ; i < ls[0].length ; i++){
                for( int j = 0 ; j < ls.length ; j++ ){
                    tab[i][j] = ls[j][i];
                }
            }
        return tab ;
    }
    
    public static String[] getListObjet( String path , String sp ) {
        File f = new File(path);
        String[] ls = f.list();
        for(int i = 0 ; i < ls.length ; i++){
            String[] tmp = ls[i].split(sp);
            ls[i] = tmp[0];
        } 
        return ls;
    }
    
    public static String chaineatr( String[] ls ){
        String chaine  = "";
        for( int i = 0 , t = ls.length - 1 ; i < t ; i++ ){
            chaine += ls[i] + " , " ;
        }
        chaine = chaine + ls[ ls.length - 1] ;
        return chaine ;
    }

    public static String chaineval( String[] ls ){
        String chaine  = "";
        for( int i = 0 , t = ls.length - 1 ; i < t ; i++ ){
            chaine += ls[i] + " , " ;
        }
        chaine = chaine + ls[ ls.length - 1] ;
        return chaine ;
    }
}

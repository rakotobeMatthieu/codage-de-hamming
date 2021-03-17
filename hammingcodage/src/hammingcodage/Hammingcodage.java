/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hammingcodage;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OzAstnaim
 */
public class Hammingcodage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
           // Fonction.getPosControle(null);
      //         String[] lbc = new String[7];
                   /* lbc[0]="001";
                    lbc[1]="010";
                    lbc[2]="011";
                    lbc[3]="100";
                    lbc[4]="101";
                    lbc[5]="110";
                    lbc[6]="111";*/
          //  Fonction.getCode("wawa", 3);
       /*   String[][] tab = Fonction.getTabChar(lbc);
           Fonction.affMatrice(tab);
            String[][] result = Fonction.transpose(tab);
          Fonction.affMatrice(result);
            System.out.println(result[2][0]);
        // Fonction.getIndexNumber("1110101",'1');
       // Fonction.getPosControle(result);
         //   System.out.println("binary of int : "+Integer.toBinaryString(6));
       /*  Fonction.getBinaryNumber(5, 3);
         Fonction.getBinaryNumber(6, 3);
         Fonction.getBinaryNumber(7, 3);*/
       //Fonction.matriceControle(3);
         /* Vector<String> r =  new Vector<String>();
                    r.add("1010");
                    r.add("1000");
       Fonction.transformHamming(r,Fonction.getPosition(3),Fonction.getPartition(3));*/
          Fonction f = new Fonction("kenny a","3","1");
     String[][] codes =  f.getHammingCode();
     f.getCode("kenny",3);
      
      // String[] hamming = {"0","0","1","0","1","1","0","1"};
       //f.hammingtocode(hamming);
            System.out.println(f.getCorrection(f.getHammingCode())[0][0]);
       //  f.erreurhasard(f.getHammingCode());
      // f.getBytes("=4");

            f.getBytes("20");
            //System.out.println("tena izy : "+ f.getMessage("1110111110000100"));
      //f.getCode("waw", 5);
       
        
           /* Fonction.getBytes("wa");*/
           /* byte[] b = new byte[3]; 
            b[0] = Byte.parseByte("1110111", 2);*/
          /* b[1] = Byte.parseByte("1101001",2);
            b[2] = Byte.parseByte("0000000",2);*/
            
          /*  b[0] = Byte.parseByte("1110", 2);
            b[1] = Byte.parseByte("1111",2);
             b[2] = Byte.parseByte("1000",2);
              b[3] = Byte.parseByte("0100",2);*/
           //   System.out.println(new String(b));
           // System.out.println(Byte.parseByte("1110", 2));
            
            /*int charCode = Integer.parseInt(Fonction.getBytes("0").toString(), 2);
            System.out.println(new Character((char)charCode).toString());*/
      //     System.out.println(Integer.parseInt(Fonction.getBytes("wa"),2));
           // System.out.println(new String();
        /*    System.out.println(Integer.parseInt("11000100",2));;
            byte[] b = "wa".getBytes();
            for(int i = 0;i<b.length;i++){
                System.out.println("talou : "+b[i]+"de aveo "+Integer.toBinaryString(b[i])+" sy "+Integer.parseInt(Integer.toBinaryString(b[i]),2));
            }
            System.out.println(new String(b));*/
       //Fonction.getPosition(3);
        /*int[] vector = { 1,1,1,0,0,0,0 };
        int[][] matrix = { {1,0,1,0,1,0,1}, {0,1,1,0,0,1,1}, {0,0,0,1,1,1,1} };*/
       // Fonction.multiplication( vector , matrix );
       /* int[] vect = { 1,0,1,0,0,1,0 };
        Fonction.multiplication( vect , matrix );*/
        //ArrayList<Integer> ls = Fonction.getPosition(3);
      /*  lbc[0]="1";
          lbc[1]="1";
         lbc[2]="1";
         lbc[3]="1";
          lbc[4]="0";
           lbc[5]="0";
           lbc[6]="0";
            System.out.println(Fonction.verification(lbc, 3));*/
       // Fonction.corriger(lbc, 3);
    //    Fonction.matriceControle(3);
      /*   int[] vector = { 1,1,1,1,0,0,0 };
        int[][] matrix = { {1,0,1,0,1,0,1}, {0,1,1,0,0,1,1}, {0,0,0,1,1,1,1} };
        Fonction.multiplication( vector , matrix );*/
        } catch (Exception ex) {
            System.out.println("erreur : "+ex);
        }
    }
    
}

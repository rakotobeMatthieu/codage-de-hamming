/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hammingcodage;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;
/**
 *
 * @author OzAstnaim
 */
public class Fonction {
    private Vector<String> code;
     private String message;
      private int n;
      private Partition partition;
      private Vector<Integer> position;
      private int nberreur;
      
    
    public Fonction(){

    }
    public Fonction(String message,String n,String nberreur)throws Exception {
        this.setN(n);
        this.setMessage(message);
           this.partition = this.getPartition(this.n);
         this.position = this.getPosition(this.n);
        this.code = this.getCode(message, this.n);
        this.setNberreur(nberreur)  ;
    }
    public void setNberreur(String n)throws Exception{
        if(n==null || n.isEmpty()){
            throw new Exception("le champs nombre d'erreur est vide");
        }
        else if(Integer.parseInt(n)<0 ||Integer.parseInt(n)>this.partition.longhamming )
            {
            throw new Exception("la valeur de n est invalide");
        }
        else{
            this.nberreur =Integer.parseInt(n);
        }
    }
    public void setN(String n)throws Exception{
        if(n==null || n.isEmpty()){
            throw new Exception("le champs n est vide");
        }
        else if(Integer.parseInt(n)<=0)
            {
            throw new Exception("la valeur de n est invalide");
        }
        else{
            this.n =Integer.parseInt(n);
        }
    }
    
        public void setMessage(String m)throws Exception{
        if(m==null || m.isEmpty()){
            throw new Exception("le champs message est vide");
        }      
        else{
            this.message = m;
        }
    }

    
   public  String getBytes(String message)throws Exception{
       String reponse = "";
       String temp = "";
         byte[] bytes = message.getBytes("UTF-8");
          for (byte b : bytes) {
              temp=Integer.toBinaryString(b);
                 while(temp.length()<7){
                     temp="0"+temp;
              }
                 reponse+=temp;
          }
          System.out.println("reponse : "+reponse);
          return reponse;
          
   }
   
    public String[][] erreurhasard(String[][] hamming)throws Exception{
        String[][] reponse = hamming;
        int tailleh = hamming.length;
        int taillefirst = hamming[0].length;
        int index;
        int indiceer = 0;
        if(this.nberreur ==0){
            return hamming;
        }
        else{
            for(int i = 0;i<tailleh;i++){
                index = (int)(Math.random() * this.nberreur+1);
                while(index>0){
                    //indiceer = (int)(Math.random() * taillefirst);
                    indiceer = new Random().nextInt(taillefirst);
                    if(reponse[i][indiceer].equals("0") || reponse[i][indiceer].compareTo("0")==0){
                        System.out.println("INDICE : "+ indiceer + " => " +reponse[i][indiceer]);
                        reponse[i][indiceer] = "1";
                        System.out.println("ERREUR : "+ reponse[i][indiceer]);
                    }
                    else{
                        System.out.println("INDICE : "+ indiceer + " => " +reponse[i][indiceer]);
                        reponse[i][indiceer] = "0";
                        System.out.println("ERREUR : "+ reponse[i][indiceer]);                       
                    }
                    index--;
                }
            }
        }
        return reponse;
    }
    public  Partition getPartition(int n)throws Exception{
        Partition rep = null;
        try{
           rep= new Partition(((int)(Math.pow(2, n)-1)-n),((int)(Math.pow(2, n)-1)),n);
        }
        catch(Exception ex){
            ex.printStackTrace();
            throw ex;
        }
        return rep;
    }
    public  Vector<String> getCode(String message,int n)throws Exception{
        Vector<String> reponse = new Vector<String>();
        try{
        String binaire =getBytes(message);
      // String binaire = "11101110";
        int taillebinaire = binaire.length();
        for(int i=0;i<taillebinaire;i+=partition.getLongcode()){
            if((partition.getLongcode()+i)>taillebinaire){
               String temp = binaire.substring(i, taillebinaire);
                int taillereste = (partition.getLongcode()+i)-taillebinaire;
                int index=0;
               while(index<taillereste){
                    temp+="0";
                    index++;
                }
                reponse.add(temp);
            }
            else{
                 reponse.add(binaire.substring(i, partition.getLongcode()+i));
            }
         }
        }
        catch(Exception ex){
            ex.printStackTrace();
            throw ex;
        }
      
        return reponse;
    }
    public  Vector<Integer> getPosition(int n){
        Vector<Integer> ls= new Vector<Integer>();
        for(int i = 0 ; i < n ;i++ ){
            ls.add( (int) Math.pow( 2 , i) );
        }
      /*  for(Integer i : ls){
            System.out.println(i);
        }*/
        return ls;
    }
    public  String getBinaryNumber(int nb,int taille)throws Exception{
        String rep = "";
       String temp = Integer.toBinaryString(nb);
       StringBuilder input = new StringBuilder(); 
        input.append(temp); 
  
        rep = input.reverse().toString(); 
        int taillerep = rep.length();
        while(taillerep<taille){
                    rep+="0";
                    taillerep++;
                }
       return rep;
        
    } 
  
    public  String[][] matriceControle(int n)throws Exception{
         String[][] reponse = null;
         int limit =(int) Math.pow(2, n)-1;
         String[] nombre = new String[limit];
         int taille = Integer.toBinaryString(limit).length();
         for(int i = 1;i<=limit;i++){
             nombre[i-1] =getBinaryNumber(i, taille);
         }
          String[][] tab =getTabChar(nombre);
            reponse =transpose(tab);
           affMatrice(reponse);
         return reponse;

    }
     public  String[][] getTabChar(String[] ls) {
        String[][] tab = new String[ ls.length ][ ls[0].length() ] ;
        for(int i = 0 ; i < ls.length ;i++){
            char[] tmp=  ls[i].toCharArray();
            for( int j =0; j<tmp.length  ; j++){
                tab[i][j] =  tmp[j] + "" ;
            }
        }
        return tab;
    }
    
    public  String[][] transpose( String[][] ls ){
        String[][] tab = new String[ ls[0].length ][ ls.length  ] ;
            for( int i = 0 ; i < ls[0].length ; i++){
                for( int j = 0 ; j < ls.length ; j++ ){
                    tab[i][j] = ls[j][i];
                }
            }
        return tab ;
    }
    
      public  void affMatrice(String[][] tab){
         
        for(int i = 0 ; i < tab.length ;i++){
             for( int j = 0 ; j < tab[0].length ; j++ ){
                System.out.print( tab[i][j] );
             }
             System.out.print("\n");
        }
        System.out.print("-------------\n");
    }
      public  Vector<Integer> getIndexNumber(String message,char valeur)throws Exception{
           Vector<Integer> reponse = new Vector<Integer>();
           int taille = message.length();
           
           for(int i = 1,index=-1;i<taille;i++)
           {
               index = message.indexOf(valeur, index+1);
               if(index==-1)break;
               reponse.add(index);
           }
           return reponse;
    
      }
      public  void afficherPosition(Vector<Vector<Integer>> reponse )throws Exception{
           for(int i = 0 ; i < reponse.size() ;i++){
             for( int j = 0 ; j < reponse.get(0).size() ; j++ ){
                System.out.print( reponse.get(i).get(j) );
             }
             System.out.print("\n\n\n");
        }
        System.out.print("-------------\n");
      }
    public  Vector<Vector<Integer>> getPosControle(String[][] matriceControle)throws Exception{
       Vector<Vector<Integer>> reponse = new Vector<Vector<Integer>>(); 
       Vector<Integer> singlerep = new Vector<Integer>();
       String binaire = "";
        int tailleligne = matriceControle.length;
        int taillecolonne = 0;
          for(int i = 0 ; i <  tailleligne;i++){
              taillecolonne = matriceControle[0].length;
              binaire="";
             for( int j = 0 ; j < taillecolonne ; j++ ){
                 binaire+=matriceControle[i][j];
             }
             // System.out.println("binaire : "+binaire);
              singlerep =getIndexNumber(binaire,'1');
             reponse.add(singlerep);
             
        }
         afficherPosition(reponse);
          return reponse;
    }    
    /*public   Vector<String> getValuePos(String[][] controle,)throws Exception{
        
    }*/
    public  int sum(int b1, int b2) {
        if(b1!=b2)return 1;
        else return 0;
  }
    public  String[][] transformHamming(Vector<String> code,Vector<Integer> position,Partition partition)throws Exception{
        int taillecode = code.size();
        int taillepartition = partition.getLonghamming();
      //  System.out.println(" taillecode : "+taillecode+" taille partition : "+taillepartition);
        String[][] rep = new String[taillecode][taillepartition];
        
       try{
        int tailleposition=position.size();
        Vector<Vector<Integer>> poscontrole =getPosControle(matriceControle(partition.getN()));
        int taillepcligne = poscontrole.size(),taillepccolonne = 0;
        
        for(int index = 0;index<taillecode;index++){
        for(int i = 0;i<tailleposition;i++){
                rep[index][position.get(i)-1] = "0";
        }
        int sout = 0;
        for(int i = 0,index1=0;i<taillepartition;i++){
            if(rep[index][i]==null){
               
                rep[index][i] = ""+code.get(index).charAt(index1);
               
                index1++;
            }
           
     //       System.out.println("repondse : "+rep[index][sout]);
            sout++;
        }
        
        for(int i = 0;i<taillepcligne;i++){
            int valeurpos=0;
            taillepccolonne = poscontrole.get(i).size();
            for(int j = 0;j<taillepccolonne;j++){
                //System.out.println("\nnull pointer : "+rep[index].length+"\n");
              valeurpos=sum(valeurpos,Integer.valueOf(rep[index][poscontrole.get(i).get(j)]));
            }
           rep[index][position.get(i)-1] = ""+valeurpos;
        }
        // for(int i = 0;i<rep[index].length;i++)System.out.println(rep[index][i]);
       }
          // System.out.println("\n-------------fin---------------\n");
       }
      
       catch(Exception ex){
           ex.printStackTrace();
          throw ex;
       }
        return rep;
    }
    
    public  String[][] getHammingCode()throws Exception{
        String[][] reponse = null;
        try{
           // System.out.println("partition : "+this.partition.getLonghamming());
            reponse =  transformHamming(this.code,this.position,this.partition);
        }
        catch(Exception ex){
            throw new Exception("erreur hamming code : "+ex);
        }
        return reponse;
    }
    
    
    public  boolean verification(String[] code,int n)throws Exception{
        boolean rep = false;
        try{
           String[] result =multiplication(code,matriceControle(n));
           int tailleresult = result.length;
           for(int i = 0;i<tailleresult;i++){
               if(result[i].equals("1")){
                   return rep;
               }
           }
        }
        catch(Exception ex ){
            throw new Exception("erreur verification :"+ex);
        }
        return true;
    }
    
    public Vector<Integer> getPositionErreur(String[] code,int n)throws Exception{
        Vector<Integer> rep = new Vector<>();
        try{
           String[] result =multiplication(code,matriceControle(n));
           int tailleresult = result.length;
           for(int i = 0;i<tailleresult;i++){
               if(result[i].equals("1")){
                   /*int repp = 0;
                   String temp = i+"";
                   char[] ray = temp.toCharArray();
                   for(int k=0;k<ray.length;k++){
                       repp+=Integer.parseInt(ray[k]+"");
                   }*/
                   rep.add(i);
               }
           }
        }
        catch(Exception ex ){
            throw new Exception("erreur position erreur :"+ex);
        }
        return rep;
    }
    
    public  String[] hammingtocode(String[] hamming)throws Exception{
       int taille = position.size();
       int tailleh= hamming.length;
       String[] reponse = new String[this.partition.longcode];
       for(int index = 0,indice=0;index<tailleh;index++,indice++){
           
            for(int i = 0;i<taille;i++){
               if(index ==position.get(i)-1){
                   System.out.println("tafiditra ao am : "+(position.get(i)-1));
                   index++;
               }
            }
            if(index == tailleh){
                break;
            }
            else{
                  reponse[indice] = hamming[index];
            }
          
            System.out.println(reponse[indice]);
       }
        return reponse;
    }
   
    public String getMessage(String code)throws Exception{
        String rep = "";
        int taille = code.length();
        int longueur = 7;
        byte[] bytes =new byte[(int)taille];
        
        System.out.println("taille : "+taille);
        try{
            for(int i=0,indice=0;i<taille;i+=longueur){
            if((longueur+i)>taille){
               String temp = code.substring(i, taille);
                int taillereste = (longueur+i)-taille;
                int index=0;
               while(index<taillereste){
                    temp+="0";
                    index++;
                }
                bytes[indice] =(byte) Integer.parseInt(temp,2);
                indice++;
            }
            else{
                   bytes[indice] =(byte) Integer.parseInt(code.substring(i, longueur+i),2);
                   indice++;
            }
         }
            
           
           
            
            
            rep = new String(bytes);
            System.out.println("rep : "+rep);
        }
        catch(Exception ex){
            ex.printStackTrace();
            throw ex;
        }
        return rep;
    }
    public  String[][][] getCorrection(String[][] codes)throws Exception{
          int taillecode = codes.length;
          boolean verifier;
            String[][][] reponse = new String[2][taillecode][this.partition.longcode];
      try{
      
          
        String[]  codetemph,codetemp;
        for(int i =0;i<taillecode;i++){
            verifier=verification(codes[i], n);
          
            if(!verifier){
                codetemp = corriger(codes[i],this.n);
                  codetemph =hammingtocode(codetemp);
            }
            else{
                codetemp = codes[i];
                codetemph =hammingtocode(codes[i]);
            }
            reponse[0][i] = codetemp;
             reponse[1][i] = codetemph;
        }
      
      }
      catch(Exception ex){
          ex.printStackTrace();
          throw ex;
      }
        return reponse;
    }
    
     
    public  String[] corriger(String[] code,int n)throws Exception{
        int position;
        String[] multi =multiplication(code,matriceControle(n));
        String result = "";
        int taillecode=code.length;
        System.out.println("");
        String[] reponse = code;
        int taillemulti = multi.length;
        
        for(int i = taillemulti-1;i>=0;i--){
           
            result+=multi[i];
        }
     //   System.out.println("\nresult : "+result+" en decimal : "+Integer.parseInt(result,2));
     //int index = (int)(Math.random() * this.nberreur+1);
     //while(index>0){
       position=Integer.parseInt(result,2)-1; 
        System.out.println("decimal : "+position+" et taille : "+taillecode+" reponse : "+reponse[position]);
        if(reponse[position].equals("0"))reponse[position]="1";
        else reponse[position]="0";
        //index--;
     //}
        return reponse;
    }
     public  String[] multiplication(String[] vector , String[][]matrix ){
        String[] res = new String[ matrix.length ];
        for( int i = 0 , l = matrix.length  ; i  < l ; i++ ){
            for( int j = 0 , m = vector.length ; j < m ;j++ ){
                int t = 0 ;
                for( int k = 0 ; k < m  ; k++  ){
                   t += Integer.valueOf(vector[k]) * Integer.valueOf(matrix[i][k]);
                }
                res[i] =""+ t%2 ; 
            }
        }
     /*   for(int i = 0 ; i < res.length ; i++){
            System.out.println(res[i]);
        }        
        System.out.println("\n");*/
        return res;
    }
     public  void multiplication(int[] vector , int[][]matrix ){
        int[] res = new int[ matrix.length ];
        for( int i = 0 , l = matrix.length  ; i  < l ; i++ ){
            for( int j = 0 , m = vector.length ; j < m ;j++ ){
                int t = 0 ;
                for( int k = 0 ; k < m  ; k++  ){
                   t += vector[k] * matrix[i][k]   ;
                }
                res[i] = t%2 ; 
            }
        }
       /* for(int i = 0 ; i < res.length ; i++){
            System.out.println(res[i]);
        }        
        System.out.println("\n");*/
    }
     public  byte[] binarytodecimal(byte[] b)throws Exception{
      byte[] reponse = new byte[(int)b.length/3];
      String temp = "";
         for(int i = 0; i<b.length;i+=3){
            temp =b[i]+""+b[i+1]+""+b[i+2]+""+b[i+3];
            reponse[i] =(byte) Integer.parseInt(temp,2);
        }
     //    System.out.println("message : "+new String(reponse));
       return null;
     }
     
     public  Vector<String> affhamming(String[][] hamming)throws Exception{
         Vector<String> rep = new Vector<String>();
         String temp = "";
         int tailleh = hamming.length;
         int taillefirst = hamming[0].length;
        for(int i = 0 ; i < tailleh ;i++){
            temp = "";
             for( int j = 0 ; j < taillefirst ; j++ ){
                temp+=hamming[i][j] ;
             }
             rep.add(temp);
        }
        return rep;
     }
      
     public String tostring(String[][] valeur)throws Exception{
           int tailleh = valeur.length;
         int taillefirst = valeur[0].length;
         String reponse = "";
        for(int i = 0 ; i < tailleh ;i++){
             for( int j = 0 ; j < taillefirst ; j++ ){
                reponse+=valeur[i][j] ;
             }
        }
         System.out.println("to string : "+reponse);
        return reponse;
     }
    public Vector<String> getCode() {
        return code;
    }

    public void setCode(Vector<String> code) {
        this.code = code;
    }
}

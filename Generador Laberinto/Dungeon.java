/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneradorLaberinto;

import java.util.Random;
/**
 *
 * @author diego
 */


//DUNGEON 1
public class Dungeon {

   
     static Random r = new Random();
    
    public static void main(String[] args) {
     
        
        
        //Tamaño grid
        int x = 15;
         int y = 15;
    
        gen(x,y);
       
        
        
    }
    
    
    
    
    
    
    static int i, j = 0;
    
  
    
    static String suelo = " - ";
    static String vacio = " * ";
    static String pared = " # ";
    



    
    
    static boolean bordes,paredes,laberinto,entradaBool,salidaBool = true;
    
    public static void gen(int x, int y){
            
        //Cord entrada salida
        int[] entradaCord = new int[2];
        int[] salidaCord = new int[2];
        
        
        //generar cordenada y
        entradaCord[1] = r.nextInt(y);
        
        
        //checar si la cordenada se encuentra en 0 o en su valor maximo 
        if(entradaCord[1] == 0 || entradaCord[1] == y-1 ){
            
            entradaCord[0] = r.nextInt(x-2)+1;
            
            
        }  
        else{
            
            //generar si la cordenada x estara en el lado derecho o izquierdo 
           if(r.nextInt(2) == 0 ){
               
               entradaCord[0] = 0;
               
           }else{
               
               entradaCord[0] = x-1;
           }
            
        }
   
        salidaCord[0] = entradaCord[1];
        salidaCord[1] = entradaCord[0];
        
        
        System.out.println("Entrada Y "+(entradaCord[1]+1));
        System.out.println("Entrada X " +(entradaCord[0]+1));
        
        System.out.println("Salida Y " +(salidaCord[1]+1));
        System.out.println("Salida X "+(salidaCord[0]+1));
                
        
        
        
        int[][] tiles = new int[x][y];
        int xSalida = salidaCord[0];
        int ySalida = salidaCord[1];
        
        
        
        for(int i = 0 ;i < y ; i++){
            
           
            
            for(int j = 0 ; j < x ; j++){
                
                
                
                //condiciones 
                bordes = (  ( (i == 0 || i == y-1 ) || (j == 0 || j == y-1 ) )  ) ;
                entradaBool = (  entradaCord[0] == j && entradaCord[1] == i );
                salidaBool = ( salidaCord[0] == j && salidaCord[1] == i );
                
                
                laberinto = (bordes && !entradaBool && !salidaBool);
                
                
                
                if(laberinto){
                    System.out.print(pared);
                    
                    tiles[i][j] = 1;
                }
                else{   
                   
                    boolean colindaEntrada = (i-1 == entradaCord[1] || i+1 == entradaCord[1] || j-1 == entradaCord[0] || j+1 == entradaCord[0]);
                    boolean colindaSalida = (i-1 == salidaCord[1] || i+1 == salidaCord[1] || j-1 == salidaCord[0] || j+1 != salidaCord[0]);
                    
                    
                    if(  !bordes && !entradaBool && !salidaBool && ( !colindaEntrada || !colindaSalida )){
                    
                        if( evalucaion(tiles,i,j)   ){
                            
                        System.out.print(pared);
                        tiles[i][j] = 1;
                        
                        
                        
                        }
                        else{
                            System.out.print(suelo);
                            tiles[i][j] = 0;
                        }
                      
                    }
                    else{
                    
                  
                    System.out.print(suelo);
                    
                    tiles[i][j] = 0;
                    
                    }
                    
                }
                
                
              
                   
              
     
            }
            
         
             System.out.println();
        }
        
        
     
        
          
    }
    
    
    //evalucaion de tiles colindantes
    public static boolean evalucaion(int[][] grid, int i, int j){
        
        
        
        
        boolean ev = false;
            //  0 0 0
            //  0 ? 
        if(  (grid[i-1][j] + grid[i-1][j+1]+ grid[i-1][j-1] + grid[i][j-1]) <  r.nextInt(8)/2   ){
            
            return ev = true;
        }
        else{
            
            return ev;
        }
        
        
        
    }
    
}


package reconocedor2019;

import java.util.Scanner;


public class Reconocedor2019 {

  
    public static void main(String[] args) {
        String cadena=obtenerCadena();
        procesarCadena(cadena);
        
        
    }
    
    
    static String obtenerCadena(){
        
        Scanner entrada =new Scanner (System.in);
        String cadena;
        System.out.println("Ingrese la cadena que desea analizar");
        cadena=entrada.nextLine();
        return cadena;
    }
    
    static String limpiarCadena(String texto){
        String cadena=texto;
        
        cadena=cadena.trim();
        cadena=cadena.replace(" ","");
        cadena=cadena.replace(",","");
        cadena=cadena.replace(".","");
        cadena=cadena.replace("á","a").replace("é","e").replace("í","i").replace("ó","o").replace("ú","u");
        cadena=cadena.toLowerCase();
        //cadena=cadena.replace("Á","A").replace("É","E").replace("Í","I").replace("Ó","O").replace("Ú","U");
        
        
        
        return cadena;
    }
    
    static double[] arregloCast(){
        double[] arregloCastellano={11.05, 0.87, 6.82, 4.77, 11.93, 1.18, 0.93, 0.37, 8.91, 0.24, 0.01, 5.65, 2.7, 7.41, 9.51, 2.29, 0.78, 5.46, 8.14, 5.09, 4.21, 0.76,
                    0.01, 0.11, 0.7, 0.1};
        
        return arregloCastellano ;
    }
    
    static double[] arregloIngles(){
        double[] arregloIng={7.81, 1.28, 2.93, 4.11, 13.05, 2.88, 1.39, 5.85, 6.77, 0.23, 0.42, 3.6, 2.62, 7.28, 8.21, 2.15, 0.14, 6.64, 6.46, 9.02, 2.77, 1, 1.49,
                    0.3, 1.51, 0.09};
        
        return arregloIng ;
    }
    
    static double[] arregloAleman(){
        double[] arregloAle={6.11, 1.87, 2.67, 5.56, 16.51, 1.48, 2.89, 4.15, 8.26, 0.26, 1.67, 3.4, 2.72, 10.28, 3.03, 1.01, 0.02, 7.83, 6.27, 6.09, 4.48, 1.08,
                    1.2, 0.05, 0.08, 1.03};
        
        return arregloAle ;
    }
    
    static void procesarCadena (String texto){
        
        String cadena =texto;
        cadena=limpiarCadena(cadena);
        System.out.println(cadena);
        
        double[] frecCast= arregloCast();
        double[] frecIngles=arregloIngles();
        double[] frecAle=arregloAleman();
        
        char[] arregloCadena;
        double[] letras=new double[26];
        char [] arregloLetras ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
            
        
        
        arregloCadena= cadena.toCharArray();
        for (int i = 0; i < arregloCadena.length; i++) {
            if (arregloCadena[i]>=97 && arregloCadena[i]<=122){
              letras[arregloCadena[i]-97]++;  
            }
        }
        
        /*for (int i = 0; i < letras.length; i++) {
            System.out.print(letras[i]);
            System.out.print(" ");
            
            
            
            
        }
        System.out.println("");
        for (int i = 0; i < arregloLetras.length; i++) {
            
            System.out.print(" ");
            System.out.print(arregloLetras[i]);
            System.out.print("  ");
        }*/
        
        double ecmCast=0;
        double ecmIngles=0;
        double ecmAle=0;
        
        for (int i = 0; i < letras.length; i++) {
            letras[i]*=100;
            letras[i]/=arregloCadena.length;
            
            ecmCast+=(frecCast[i]-letras[i])*(frecCast[i]-letras[i]);
            ecmIngles+=(frecIngles[i]-letras[i])*(frecIngles[i]-letras[i]);
            ecmAle+=(frecAle[i]-letras[i])*(frecAle[i]-letras[i]);
        }
        
        
        System.out.println(ecmCast/letras.length);
        System.out.println(ecmIngles/letras.length);
        System.out.println(ecmAle/letras.length);
        
        if(ecmCast/letras.length<(ecmIngles/letras.length)){
            if(ecmCast/letras.length<(ecmAle/letras.length)){
                System.out.println("El texto probablemente está escrito en castellano");
            }else System.out.println("El texto probablemente está escrito en Alemán");
        }else if(ecmIngles/letras.length<(ecmAle/letras.length)){
            System.out.println("El texto probablemente está escrito en Inglés");
        }else System.out.println("El texto probablemente está escrito en Alemán");
    }
    
}

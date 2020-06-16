/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras_de_datos;

/**
 *
 * @author FABIa
 */
public class main {
    
    public static void main(String[] args) {
        AvlNodeTree <Integer> arbolavl=new AvlNodeTree<>();
       int n=10_000;
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i=0; i<n ;i++){
            arbolavl.insert(i);  
        } 
        time_end = System.nanoTime();   
        //arbolavl.levels();
        
        System.out.println("Tiempo de llenado "+ ( time_end - time_start ) +" milliseconds");
        
        time_start = System.nanoTime();
        arbolavl.remove(0);
        time_end = System.nanoTime();
        System.out.println("Tiempo de eliminar"+ ( time_end - time_start ) +" milliseconds");
        
        time_start = System.nanoTime();
        int min =arbolavl.findMin();
       
        time_end = System.nanoTime();
        System.out.println("Tiempo de encontrar minimo "+ ( time_end - time_start ) +" milliseconds EL minimo es"+min);
        
        time_start = System.nanoTime();
        int max=arbolavl.findMax();
        time_end = System.nanoTime();
        System.out.println("Tiempo de encontrar maximo"+ ( time_end - time_start ) +" milliseconds. EL max es "+max);
        time_start = System.nanoTime();
        arbolavl.find(n-10);
        time_end = System.nanoTime();
        System.out.println("Tiempo de encontrar maximo"+ ( time_end - time_start ) +" milliseconds. ");
        
        int k=n;
        n=100000;
        System.out.println("n=100_000"+n);
        time_start = System.nanoTime();
        for(int i=k; i<n ;i++){
            arbolavl.insert(i);  
        } 
        time_end = System.nanoTime();   
        //arbolavl.levels();
        
        System.out.println("Tiempo de llenado "+ ( time_end - time_start ) +" milliseconds");
        
        time_start = System.nanoTime();
        arbolavl.remove(2);
        time_end = System.nanoTime();
        System.out.println("Tiempo de eliminar"+ ( time_end - time_start ) +" milliseconds");
        
        time_start = System.nanoTime();
        min =arbolavl.findMin();
       
        time_end = System.nanoTime();
        System.out.println("Tiempo de encontrar minimo "+ ( time_end - time_start ) +" milliseconds EL minimo es"+min);
        
        time_start = System.nanoTime();
        max=arbolavl.findMax();
        time_end = System.nanoTime();
        System.out.println("Tiempo de encontrar maximo"+ ( time_end - time_start ) +" milliseconds. EL max es "+max);
        time_start = System.nanoTime();
        arbolavl.find(n-10);
        time_end = System.nanoTime();
        System.out.println("Tiempo de encontrar maximo"+ ( time_end - time_start ) +" milliseconds. ");
        
        
        k=n;
        n=250000;
        System.out.println("n=250_000"+n);
        time_start = System.nanoTime();
        for(int i=k; i<n ;i++){
            arbolavl.insert(i);  
        } 
        time_end = System.nanoTime();   
        //arbolavl.levels();
        
        System.out.println("Tiempo de llenado "+ ( time_end - time_start ) +" milliseconds");
        
        time_start = System.nanoTime();
        arbolavl.remove(3);
        time_end = System.nanoTime();
        System.out.println("Tiempo de eliminar"+ ( time_end - time_start ) +" milliseconds");
        
        time_start = System.nanoTime();
        min =arbolavl.findMin();
       
        time_end = System.nanoTime();
        System.out.println("Tiempo de encontrar minimo "+ ( time_end - time_start ) +" milliseconds EL minimo es"+min);
        
        time_start = System.nanoTime();
        max=arbolavl.findMax();
        time_end = System.nanoTime();
        System.out.println("Tiempo de encontrar maximo"+ ( time_end - time_start ) +" milliseconds. EL max es "+max);
        time_start = System.nanoTime();
        arbolavl.find(n-10);
        time_end = System.nanoTime();
        System.out.println("Tiempo de encontrar n-10"+ ( time_end - time_start ) +" milliseconds. ");
        
        
        k=n;
        n=500000;
        System.out.println("n=500_000"+n);
        time_start = System.nanoTime();
        for(int i=k; i<n ;i++){
            arbolavl.insert(i);  
        } 
        time_end = System.nanoTime();   
        //arbolavl.levels();
        
        System.out.println("Tiempo de llenado "+ ( time_end - time_start ) +" milliseconds");
        
        time_start = System.nanoTime();
        arbolavl.remove(5);
        time_end = System.nanoTime();
        System.out.println("Tiempo de eliminar"+ ( time_end - time_start ) +" milliseconds");
        
        time_start = System.nanoTime();
        min =arbolavl.findMin();
       
        time_end = System.nanoTime();
        System.out.println("Tiempo de encontrar minimo "+ ( time_end - time_start ) +" milliseconds EL minimo es"+min);
        
        time_start = System.nanoTime();
        max=arbolavl.findMax();
        time_end = System.nanoTime();
        System.out.println("Tiempo de encontrar maximo"+ ( time_end - time_start ) +" milliseconds. EL max es "+max);
        time_start = System.nanoTime();
        arbolavl.find(n-10);
        time_end = System.nanoTime();
        System.out.println("Tiempo de encontrar n-10"+ ( time_end - time_start ) +" milliseconds. ");
    
        k=n;
        n=1000000;
        System.out.println("n=1_000_000"+n);
        time_start = System.nanoTime();
        for(int i=k; i<n ;i++){
            arbolavl.insert(i);  
        } 
        time_end = System.nanoTime();   
        //arbolavl.levels();
        
        System.out.println("Tiempo de llenado "+ ( time_end - time_start ) +" milliseconds");
        
        time_start = System.nanoTime();
        arbolavl.remove(6);
        time_end = System.nanoTime();
        System.out.println("Tiempo de eliminar"+ ( time_end - time_start ) +" milliseconds");
        
        time_start = System.nanoTime();
        min =arbolavl.findMin();
       
        time_end = System.nanoTime();
        System.out.println("Tiempo de encontrar minimo "+ ( time_end - time_start ) +" milliseconds EL minimo es"+min);
        
        time_start = System.nanoTime();
        max=arbolavl.findMax();
        time_end = System.nanoTime();
        System.out.println("Tiempo de encontrar maximo"+ ( time_end - time_start ) +" milliseconds. EL max es "+max);
        time_start = System.nanoTime();
        arbolavl.find(n-10);
        time_end = System.nanoTime();
        System.out.println("Tiempo de encontrar n-10"+ ( time_end - time_start ) +" milliseconds. ");
    } 
}

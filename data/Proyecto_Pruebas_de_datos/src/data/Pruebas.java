/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Estructuras_de_datos.ArrayQueue;
import Estructuras_de_datos.MyArrayList;
import Estructuras_de_datos.SinglyLinkedList;
import businessLogic.Logic;
import static data.DataBase.singlyLinkedListUser;
import java.util.ArrayList;

/**
 *
 * @author FABIa
 */
public class Pruebas {
    public static ArrayQueue<Stage> pruebaEncolar(){
        int n=10000000;
        
        ArrayQueue<Stage> colaEtapas = new ArrayQueue<>();
        for (int i =0; i <n;i++){
            Stage etapanueva = new Stage ("aaa","12", "startDate", "description");
            colaEtapas.enqueue(etapanueva);
        }
        return colaEtapas;
    }
    public static void pruebaDesencolar(ArrayQueue<Stage> cola){
        int m=10000000;
        for (int i=0;i<m;i++){
        cola.dequeue();
        }
    
    }
    
    public static MyArrayList pruebaInsertarMyArrayList(){
        MyArrayList<User> arregloUsuarios = new MyArrayList<>();
        int n=10;
        for (int i =0; i <n-1 ;i++){
            User nuevouser = new User ("name",12, "", "password",true);
            arregloUsuarios.pushBack(nuevouser);
        }
        User item = new User ("name1", 1, "user", "password", true);
        arregloUsuarios.pushBack(item);
        System.out.println(n);
        return (arregloUsuarios);
    }
    public static void pruebaEliminarMyArrayList(MyArrayList lista){
            
        int n=10_000_000;
         for (int i =0; i <n ;i++){
            lista.popBack();
            
        }
    }
    public static void pruebaInsertarSinglyLinkedList(){
        SinglyLinkedList<User> listaUsuarios = new SinglyLinkedList<>();
        int n=10;
        for (int i =0; i <n-1 ;i++){
            User nuevouser = new User ("name",12, "", "password",true);
            listaUsuarios.pushBack(nuevouser);
        }
        User item =new User("name1",11, "2", "1password",true);
        
    }
    
    public static MyArrayList pruebaInsertarMyArrayList2(User item){
        MyArrayList<User> arregloUsuarios = new MyArrayList<>();
        int n=10000000;
        for (int i =0; i <(n-1)/2 ;i++){
            User nuevouser = new User ("name",12, "", "password",true);
            arregloUsuarios.pushBack(nuevouser);
        }
        arregloUsuarios.pushBack(item);
        System.out.println(n);
        for (int i =0; i <(n-1)/2 ;i++){
            User nuevouser = new User ("name",12, "", "password",true);
            arregloUsuarios.pushBack(nuevouser);
        }System.out.println(n);
        return (arregloUsuarios);
    } 
   public static User buscarLinkedList(User user, SinglyLinkedList<User> listaUsuarios){
       boolean resp=false;User item= new User();
               
       for(int i = 0; i<listaUsuarios.getSize();i++){
           if (user.getName()==listaUsuarios.getItem(i).getName()){
               
                       item=listaUsuarios.getItem(i);
               resp=true;
           }
       }
       if(resp){
           System.out.println(" se encontro");   
       return item;}
       else{
           System.out.println("no se encontro");   
       return null;
       } 
   }
 
    public static SinglyLinkedList pruebaInsertarSinglyLinkedList2(){
        SinglyLinkedList<User> listaUsuarios = new SinglyLinkedList<>();
        int n=1000000;
        for (int i =0; i <n-1 ;i++){
            User nuevouser = new User ("name",12, "", "password",true);
            listaUsuarios.pushBack(nuevouser);
        }
        User item =new User("name11",11, "2", "1password",true);
        System.out.println(item);
        listaUsuarios.pushBack(item);
        return listaUsuarios;
    }
    public static MyArrayList pruebaBuscarArrayList1(){
        MyArrayList<User> listaUsuarios = new MyArrayList<>();
        int n=5000000;
        for (int i =0; i <n-1 ;i++){
            User nuevouser = new User ("name",12+i, "1", "password",true);
            listaUsuarios.pushBack(nuevouser);
        } User item =new User("name11",11, "2", "1password",true);
        listaUsuarios.pushBack(item);
        for (int i =0; i <n-1 ;i++){
            User nuevouser = new User ("name",12, "1", "password",true);
            listaUsuarios.pushBack(nuevouser);
        }
       
        //listaUsuarios.printList();
        return listaUsuarios;
    }
    public static User pruebaBuscarArrayList(User user, MyArrayList<User> listaUsuarios){
        boolean resp=false;
        User item= new User();
               
       for(int i = 0; i<listaUsuarios.getSize();i++){
           if (listaUsuarios.getItem(i).getName()== user.getName()){
               item=listaUsuarios.getItem(i);
               System.out.println(item.getName());
               resp=true;
           }
       }
       if(resp){
           System.out.println(" se encontro");   
       return item;}
       else{
           System.out.println("no se encontro");   
       return null;
       }
    }
   public static void main(String[] args) {
        
        User item =new User("name11",11, "2", "1password",true);
        
        //pruebaBuscarArrayList(item, pruebaBuscarArrayList1());
       System.out.println(buscarLinkedList(item, pruebaInsertarSinglyLinkedList2()));
        //pruebaEncolar();
        //pruebaDesencolar(pruebaEncolar());
        //pruebaEliminarMyArrayList(pruebaInsertarMyArrayList());
        //singlyLinkedListUser.;
        //pruebaInsertarSinglyLinkedList();

    }
}


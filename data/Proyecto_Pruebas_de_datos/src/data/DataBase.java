/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;


import Estructuras_de_datos.*;
import java.io.*;


/**
 *
 * @author Sebastian
 */
public class DataBase implements Serializable{
    
      public static SinglyLinkedList<RawMaterial> singlyLinkedRawMaterial = new SinglyLinkedList<RawMaterial>(); 
      public static SinglyLinkedList<User> singlyLinkedListUser = new SinglyLinkedList<User>(); 
    
      public static void WriteArchive  () {
        
        FileOutputStream fileStrem=null;  
        try {
          
        fileStrem = new FileOutputStream("Basededatos.txt");    
         
        ObjectOutputStream ose =new ObjectOutputStream(fileStrem);
        
               
        ose.writeObject(singlyLinkedRawMaterial);
        ose.close();
        
        }catch(Exception e){
            System.out.println("Error al guardar datos");
      }     
    } 
      
      
      public static void LoadArchive () {
            FileInputStream fileStremx=null;
            
        try {
        
        fileStremx = new FileInputStream("Basededatos.txt");          
        ObjectInputStream os =new ObjectInputStream(fileStremx);
      
        Object loadData = os.readObject();        
        singlyLinkedRawMaterial = (SinglyLinkedList<RawMaterial>) loadData;
        
            
//        for(int i=0; i<singlyLinkedListUser.size(); i++){
//        System.out.println("Usuario: " +memberList.get(i).getUser());
//        System.out.println("Contraseña: "+memberList.get(i).getPassword());
//        }
//        
        os.close();
       
        }catch(Exception e){
            System.out.println("Error al cargar archivo");
      } 
         
    }
}

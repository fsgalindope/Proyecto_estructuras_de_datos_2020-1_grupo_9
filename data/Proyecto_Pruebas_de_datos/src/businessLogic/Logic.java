package businessLogic;

import Estructuras_de_datos.*;
import data.*;
import static data.DataBase.*;
import static graphicInterface.Proyecto_2020.scanner;
import java.io.*;


public class Logic implements Serializable {
    
        
    private static User user = new User(); 
    
   
    private Boolean create;
    private int id;
    private String userr;
    private String adm;
    
    public void SignUp(){
        System.out.println("\n                            ***2.Registrarse    ***");
        try{
            create=false;
            System.out.print("Escriba por favor, su nombre: ");
            String name=scanner.nextLine();            
            id=-1;
              
            while(!create){
             try{
             System.out.print("Escriba por favor, su documento: ");             
             id=scanner.nextInt();
             create=checkSingUp(id,"-1");
             scanner.nextLine();        
             }catch(Exception e){
                  System.out.print("Valor no valido. Intente de nuevo.");
                  scanner.nextLine();                                     
             }
             
            }
            
            userr="";
            create=false;
            while(!create){
            System.out.print("Escriba por favor, nombre de usuario: ");
            userr=scanner.nextLine();            
            create=checkSingUp(0,userr);
            }
            
            System.out.print("Escriba por favor, contraseña: ");
            String password=scanner.nextLine();            
            create=false;
            while(!create){
            System.out.print("¿Es usted administrador? Si/No: ");
            adm=scanner.nextLine();            
            if(adm.equalsIgnoreCase("Si")){
                System.out.print("Digite el codigo de seguridad: ");                
                if(scanner.nextLine().equals("soyadm")){
                     user= new User(name,id,userr,password,true);
                     System.out.println("¡Usuario administrador creado con exito!");
                     create=true;
                }else{
                    System.out.print("Valor no valido.");
                }
            }else if(adm.equalsIgnoreCase("No")){
                user= new User(name,id,userr,password,false);
                 System.out.println("¡Usuario creado con exito!");
                create=true;
            }else{
                System.out.print("Valor no valido.");
                
             }           
            }
            singlyLinkedListUser.pushBack(user);
            
        }catch(Exception e){
            System.out.println("Error al crear usuario: "+e);
        }
    }
    
    public Boolean checkSingUp(int id, String user){
       
        if(user.equals("")){
            System.out.print("El usuario no es valido. Intente de nuevo. ");
            return false;
        }  
        for(int i=0; i< singlyLinkedListUser.getSize() && !user.equals("-1"); i++){
            if(singlyLinkedListUser.getItem(i).getUser().equals(user)){
                 System.out.print("El usuario ya existe. Intente de nuevo. ");
                 return false;
            }            
        }
         
        if(id<0){
            System.out.print("El documento no es valido. Intente de nuevo. ");
            return false;
        }        
        for(int i=0; i< singlyLinkedListUser.getSize(); i++){
            if(singlyLinkedListUser.getItem(i).getId()==id){
                 System.out.print("El documento ya existe. Intente de nuevo. ");
                 return false;
            }
        }
        return true;
     }
    
     public Boolean CheckSignIn(){
         System.out.println("\n                            ***1.Iniciar Sesion ***");
         userr="";
         while(userr.equals("")){
         System.out.print("Nombre de usuario: ");
         userr=scanner.nextLine(); 
         if(userr.equals("")){
             System.out.print("Usuario no valido. Intente de nuevo. ");
         }
         }
         adm="";
         while(adm.equals("")){
         System.out.print("Contraseña: ");
         adm=scanner.nextLine();
         if(adm.equals("")){
             System.out.print("Contraseña no valida. Intente de nuevo. ");
         }
         }
         
         create=false;
         for(int i=0; i< singlyLinkedListUser.getSize(); i++){
            if(singlyLinkedListUser.getItem(i).getUser().equals(userr)){
               if(singlyLinkedListUser.getItem(i).getPassword().equals(adm)){
                create=true;
                break;                                  
               }else{
                   break;
               }
            }            
        }
         
         if(!create){
             System.out.println("Error al iniciar sesion. Usuario y/o contraseña incorrectos o no validos");
             return false;
         }else{
             System.out.println("¡Ha iniciado sesion!");
         }
        return true;
     }
}

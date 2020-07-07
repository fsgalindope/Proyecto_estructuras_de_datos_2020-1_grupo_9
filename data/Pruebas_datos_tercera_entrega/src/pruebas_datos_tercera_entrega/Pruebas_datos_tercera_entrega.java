/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas_datos_tercera_entrega;

import java.util.ArrayList;

/**
 *
 * @author FABIa
 */
public class Pruebas_datos_tercera_entrega {
private static MyHashTable<User> hashTableUser=new  MyHashTable<>();
    /**
     * @param args the command line arguments
     */
    long time_start, time_end;
    public static void main(String[] args) {
        boolean encontrado=false;
        long time_start, time_end;
        int n=1000;
        int m=10000_000;
        n=m;
        String a[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        ArrayList<String> b = new ArrayList<>();
        
///////////Comienzo de la prueba n =10000//////////////
        int cont=0;
        while (cont<n){
            for (int h=0;h<26;h++){
                for (int j=0;j<26;j++){
                    for (int i=0;i<26;i++){
                        for (int k=0;k<26;k++){
                            for (int l=0;l<26;l++){
                                b.add(a[h]+a[j]+a[i]+a[k]+a[l]);
                                cont++;
                                if (cont==n)
                                break;
                            }if (cont==n)
                                break;
                        }if (cont==n)
                                break;
                    }if (cont==n)    break;
                }if (cont==n) break;  
            }if (cont==n)break;
            
        }
//        for(int i=0;i<b.size();i++){
//        System.out.println((b.get(i)));
//        }

       
        
        
        time_start = System.nanoTime();
        for(int i =0; i<b.size();i++){

            User usuario = new User("name", i,b.get(i), b.get(i), true);
            
            hashTableUser.Add(usuario);
        }
        time_end = System.nanoTime();
        long timePrueba1 = time_end-time_start;
        System.out.println("Tiempo de llenar m datos el hash "+ ( timePrueba1 ) +" nanosegundos "+" datos "+m);
        
            
            User singIn =new User();
            int j= b.size()-1;
            time_start = System.nanoTime();
            singIn.setUser(b.get(j));
            //System.out.println(b.get(j));
            singIn=hashTableUser.Get(singIn);
            time_end = System.nanoTime();
            if(singIn!=null){
                
            }
            
            long timePrueba2=time_end-time_start;
            System.out.println();
            System.out.println("Tiempo en encontrar un elemento en el hash "+ ( timePrueba2 ) +" nanosegundos "+" datos "+m+hashTableUser.Find(singIn));
            
            time_start = System.nanoTime();
            hashTableUser.Remove(singIn);
            time_end = System.nanoTime();
            long timePrueba3=time_end-time_start;
            System.out.println();
            System.out.println("Tiempo en eliminar "+ ( timePrueba3 ) +" nanosegundos "+" datos "+m);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void prueba1(){
        int n=10000;
        int m=n;
        long time_start, time_end;
        boolean encontrado=false;
        SinglyLinkedList<User> listaUsuarios = new SinglyLinkedList<>();
        
        //// Prueba  n=10000 perimitri inicio de sesion en el peor caso
        for(int i =0; i<m;i++){
            User usuario = new User("Fabian", i+1, "Fab", "h", Boolean.TRUE);
            listaUsuarios.pushBack(usuario);
        }
        
        User usuario = new User("Fabian", m, "Steven", "h", Boolean.TRUE);
        listaUsuarios.pushBack(usuario);
        
        
        time_start = System.nanoTime();
        for(int i=0; i<listaUsuarios.getSize(); i++){
                if (listaUsuarios.getItem(i).getUser().equals("Steven")){
                   if (listaUsuarios.getItem(i).getPassword().equals("h")){  
                       encontrado=true;
                   break;
                     }
                }
           }
        time_end = System.nanoTime();
        long timePrueba1 =(time_end - time_start);
        System.out.println(encontrado);   
        System.out.println("Tiempo de iniciar sesion "+ ( timePrueba1 ) +" nanosegundos "+" datos "+m);
        //////FIN DE LA PRUEBA ////////////
        encontrado=false;
        int k=listaUsuarios.getSize();
        
        //// Prueba  n=100000 perimitri inicio de sesion en el peor caso
        m=100_000;
        for(int i =listaUsuarios.getSize(); i<m;i++){
            User usuario1 = new User("Fabian", i+1, "Fab", "h", Boolean.TRUE);
            listaUsuarios.pushBack(usuario1);
        }
        
        User usuario1 = new User("Fabian", m, "Galindo", "h", Boolean.TRUE);
        listaUsuarios.pushBack(usuario1);
        
        time_start = System.nanoTime();
        for(int i=k; i<listaUsuarios.getSize(); i++){
                if (listaUsuarios.getItem(i).getUser().equals("Galindo")){
                   if (listaUsuarios.getItem(i).getPassword().equals("h")){  
                       encontrado=true;
                       System.out.println(i);
                   break;
                     }
                }
           }
        time_end = System.nanoTime();
        long timePrueba2 =(time_end - time_start)+timePrueba1;
        System.out.println(encontrado);   
        System.out.println("Tiempo de iniciar sesion "+ ( timePrueba2 ) +" nanosegundos "+" datos "+m);
        //////FIN DE LA PRUEBA ////////////
         encontrado=false;
        k=listaUsuarios.getSize();
        
        //// Prueba  n=250000 perimitri inicio de sesion en el peor caso
        m=250000;
        for(int i =listaUsuarios.getSize(); i<m;i++){
            User usuario2 = new User("Fabian", i+1, "Fab", "h", Boolean.TRUE);
            listaUsuarios.pushBack(usuario2);
        }
        
        User usuario2 = new User("Fabian", m, "Peña", "h", Boolean.TRUE);
        listaUsuarios.pushBack(usuario2);
        
        time_start = System.nanoTime();
        for(int i=k; i<listaUsuarios.getSize(); i++){
                if (listaUsuarios.getItem(i).getUser().equals("Peña")){
                   if (listaUsuarios.getItem(i).getPassword().equals("h")){  
                       encontrado=true;
                       System.out.println(i);
                   break;
                     }
                }
           }
        time_end = System.nanoTime();
        long timePrueba3 =(time_end - time_start)+timePrueba2;
        System.out.println(encontrado);   
        System.out.println("Tiempo de iniciar sesion "+ ( timePrueba3 ) +" nanosegundos "+" datos "+m);
        //////FIN DE LA PRUEBA ////////////
        
         encontrado=false;
        k=listaUsuarios.getSize();
        
        //// Prueba  n=500_000 perimitri inicio de sesion en el peor caso
        m=500000;
        for(int i =listaUsuarios.getSize(); i<m;i++){
            User usuario3 = new User("Fabian", i+1, "Fab", "h", Boolean.TRUE);
            listaUsuarios.pushBack(usuario3);
        }
        
        User usuario3 = new User("Fabian", m, "Pepito", "h", Boolean.TRUE);
        listaUsuarios.pushBack(usuario3);
        
        time_start = System.nanoTime();
        for(int i=k; i<listaUsuarios.getSize(); i++){
                if (listaUsuarios.getItem(i).getUser().equals("Pepito")){
                   if (listaUsuarios.getItem(i).getPassword().equals("h")){  
                       encontrado=true;
                       System.out.println(i);
                   break;
                     }
                }
           }
        time_end = System.nanoTime();
        long timePrueba4 =(time_end - time_start)+timePrueba3;
        System.out.println(encontrado);   
        System.out.println("Tiempo de iniciar sesion "+ ( timePrueba4 ) +" nanosegundos "+" datos "+m);
        //////FIN DE LA PRUEBA ////////////
        
        encontrado=false;
        k=listaUsuarios.getSize();
        
        //// Prueba  n=1_000_000 perimitri inicio de sesion en el peor caso
        m=1_000_000;
        for(int i =listaUsuarios.getSize(); i<m;i++){
            User usuario4 = new User("Fabian", i+1, "Fab", "h", Boolean.TRUE);
            listaUsuarios.pushBack(usuario4);
        }
        
        User usuario4 = new User("Fabian", m, "Pepitosr", "h", Boolean.TRUE);
        listaUsuarios.pushBack(usuario4);
        
        time_start = System.nanoTime();
        for(int i=k; i<listaUsuarios.getSize(); i++){
                if (listaUsuarios.getItem(i).getUser().equals("Pepitosr")){
                   if (listaUsuarios.getItem(i).getPassword().equals("h")){  
                       encontrado=true;
                       System.out.println(i);
                   break;
                     }
                }
           }
        time_end = System.nanoTime();
        long timePrueba5 =(time_end - time_start)+timePrueba4;
        System.out.println(encontrado);   
        System.out.println("Tiempo de iniciar sesion "+ ( timePrueba5 ) +" nanosegundos "+" datos "+m);
        //////FIN DE LA PRUEBA ////////////
        encontrado=false;
        k=listaUsuarios.getSize();
        
        //// Prueba  n=1_000_000 perimitri inicio de sesion en el peor caso
        m=10_000_000;
        for(int i =listaUsuarios.getSize(); i<m;i++){
            User usuario5 = new User("Fabian", i+1, "Fab", "h", Boolean.TRUE);
            listaUsuarios.pushBack(usuario5);
        }
        
        User usuario5 = new User("Fabian", m, "Pepitosrr", "h", Boolean.TRUE);
        listaUsuarios.pushBack(usuario5);
        
        time_start = System.nanoTime();
        for(int i=k; i<listaUsuarios.getSize(); i++){
                if (listaUsuarios.getItem(i).getUser().equals("Pepitosrr")){
                   if (listaUsuarios.getItem(i).getPassword().equals("h")){  
                       encontrado=true;
                       System.out.println(i);
                   break;
                     }
                }
           }
        time_end = System.nanoTime();
        long timePrueba6 =(time_end - time_start)+timePrueba5;
        System.out.println(encontrado);   
        System.out.println("Tiempo de iniciar sesion "+ ( timePrueba6 ) +" nanosegundos "+" datos "+m);
        //////FIN DE LA PRUEBA ////////////
        // TODO code application logic here
    }
}

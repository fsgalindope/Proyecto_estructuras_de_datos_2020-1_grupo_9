package data;

import Estructuras_de_datos.*;

import java.util.Scanner;

public class Stage extends Event {

    private MyArrayList<Parameter> parameterList;

    public Stage(String name, String id, String startDate,
                 String description) {//, MyArrayList<Parameter> parameterList
        super(name, description);
        //this.parameterList = parameterList;
    }

    public Stage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre de etapa:");
        String name = sc.next();
        System.out.println("nombre: " + name);
        System.out.println("Ingrese descripción de etapa:");
        String description = sc.next();
        System.out.println("nombre: " + description);
        System.out.println("Ahora creamos etapas");
        super.setName(name);
        super.setDescription(description);
    }

    public void finish() {
        boolean testPassed = true;
        int auxIndex = 0;
        for (int i = 0; i < parameterList.getSize() && testPassed; i++) {
            //Checks all the parameters in the list.
            //test passed = parameterList.getItem(i).complies();
            auxIndex = i;
        }
        //If a parameter does not comply with the given quality standart,
        //it is listed in badParametersList
        if (!testPassed){
            MyArrayList<Parameter> badParameterList = new MyArrayList<>();
            for (int i = auxIndex; i < parameterList.getSize() ; i++) {
                //testPassed = parameterList.getItem(i).complies();
                //if (!testPassed){
                //    badParameterList.pushBack(parameterList.getItem(i));
                //}
            }
            System.out.println("The process can't continue due to a compliance issue with the parameter(s):");
            //Print the listed parameter's names;
        } else {
            super.setIsActive(false);
            this.setIsFinished(true);
        }
    }

   
    

}
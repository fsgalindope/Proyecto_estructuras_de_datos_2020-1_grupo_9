package data;

import Estructuras_de_datos.*;



import java.time.LocalDateTime;
import java.util.Scanner;

public class Stage extends Event {

    private int stageNumber;
    private MyArrayList<Parameter> parameterList;
    public Stage (){}
    public Stage(int stageNumber, MyArrayList<Parameter> parameterList, String name, String startDate, String endDate, String id, String description) {
        super(name, startDate, endDate, id, description);
        this.stageNumber = stageNumber;
        this.parameterList = parameterList;
    }


    public Stage(int stageNumber) {
//        this.stageNumber = stageNumber;
//        System.out.println("Ingrese el nombre de la etapa " + stageNumber + ":");
//        String name = scanner.nextLine();
//        super.setName(name);
//        System.out.println("Nombre de la etapa: " + name);
//        System.out.println("Ingrese la descripción de la etapa " + stageNumber + ":");
//        String description = scanner.nextLine();
//        super.setDescription(description);
//        System.out.println("Descripción de la etapa: " + description);
//        System.out.println("Cree parámetros de calidad a evaluar en esta etapa:");
//        MyArrayList<Parameter> parameterList = new MyArrayList<>();
//        Parameter parameter = new Parameter();
//        parameterList.pushBack(parameter);
//        boolean createParameter = true;
//        while (createParameter) {
//            System.out.println("¿Desea agregar más parámetros a la etapa?");
//            String answer = scanner.nextLine();
//            if (answer.equalsIgnoreCase("Si")) {
//                parameter = new Parameter();
//                parameterList.pushBack(parameter);
//            } else if (answer.equalsIgnoreCase("No")) {
//                System.out.println("Creación de etapas finalizadas.");
//                createParameter = false;
//            } else {
//                System.out.println("Entrada no válida. Intente de nuevo.");
//            }
//        }
//        System.out.println("Se creó la etapa " + stageNumber + " con "
//                + parameterList.getSize() + " parámetros de calidad.");
//        this.parameterList = parameterList;
//        super.setStartDate("No iniciado");
//        super.setEndDate("No finalizado");
//        super.setIsActive(false);
//        super.setIsFinished(false);
//        super.setId("?");
    }

//    public void start() {
//        super.setIsActive(true);
//        super.setIsFinished(false);
//        System.out.println("Se inició la etapa " + stageNumber + " de producción '" + super.getName() + "'");
//
//        super.setStartDate(super.getTimeFormat().format(LocalDateTime.now()));
//        System.out.println("Fecha de inicio: " + super.getStartDate());
//    }
        public void start() {
        super.setIsActive(true);
        super.setIsFinished(false);
        //System.out.println("Se inició la etapa " + stageNumber + " de producción '" + super.getName() + "'");
        super.setStartDate(super.getTimeFormat().format(LocalDateTime.now()));
        //System.out.println("Fecha de inicio: " + super.getStartDate());
    }

//    public void setParameters() {
//        System.out.println("A continuación, ingrese los valores de los parámetros obtenidos en la etapa:");
//        for (int i = 0; i < parameterList.getSize(); i++) {
//            System.out.println("Ingrese el valor obtenido para "
//                    + parameterList.getItem(i).getName() + ":");
//            parameterList.getItem(i).setValue(scanner.nextDouble());
//        }
//        System.out.println("Se han asignado los valores de los parámetros de la etapa " + stageNumber + ".");
//    }
        public void setParameters(double valueP,int i ) {
            parameterList.getItem(i).setValue(valueP);
    }

//    public void finish() {
//        boolean testPassed = true;
//        int auxIndex = 0;
//        for (int i = 0; i < parameterList.getSize() && testPassed; i++) {
//            testPassed = parameterList.getItem(i).satisfyQuality();
//            auxIndex = i;
//        }
//        if (!testPassed) {
//            MyArrayList<Parameter> badParameterList = new MyArrayList<>();
//            for (int i = auxIndex; i < parameterList.getSize(); i++) {
//                if (!parameterList.getItem(i).satisfyQuality()) {
//                    badParameterList.pushBack(parameterList.getItem(i));
//                }
//            }
//            System.out.println("El proceso no puede continuar ya que no se cumplen los "
//                    + "estándares de calidad en los siguientes parámetros:");
//            for (int i = 0; i < badParameterList.getSize(); i++) {
//                System.out.println(badParameterList.getItem(i).getName());
//            }
//        } else {
//            super.setEndDate(super.getTimeFormat().format(LocalDateTime.now()));
//            super.setIsActive(false);
//            this.setIsFinished(true);
//            System.out.println("¡Finalizó la etapa " + stageNumber + " cumpliendo con los estándares de calidad!");
//            System.out.println("Fecha y hora de finalización: " + super.getEndDate());
//        }
//    }
    public void finish() {
        boolean testPassed = true;
        int auxIndex = 0;
        for (int i = 0; i < parameterList.getSize() && testPassed; i++) {
            testPassed = parameterList.getItem(i).satisfyQuality();
            auxIndex = i;
        }
        if (!testPassed) {
            MyArrayList<Parameter> badParameterList = new MyArrayList<>();
            for (int i = auxIndex; i < parameterList.getSize(); i++) {
                if (!parameterList.getItem(i).satisfyQuality()) {
                    badParameterList.pushBack(parameterList.getItem(i));
                }
            }
            System.out.println("El proceso no puede continuar ya que no se cumplen los "
                    + "estándares de calidad en los siguientes parámetros:");
            for (int i = 0; i < badParameterList.getSize(); i++) {
                System.out.println(badParameterList.getItem(i).getName());
            }
        } else {
            super.setEndDate(super.getTimeFormat().format(LocalDateTime.now()));
            super.setIsActive(false);
            this.setIsFinished(true);
            System.out.println("¡Finalizó la etapa " + stageNumber + " cumpliendo con los estándares de calidad!");
            System.out.println("Fecha y hora de finalización: " + super.getEndDate());
        }
    }

    public void printSummary() {
        System.out.println("Nombre: " + super.getName());
        if (super.isActive()) {
            System.out.println("Estado: Activa");
            System.out.println("Fecha y hora de inicio: " + super.getStartDate());
        } else if (super.isFinished()) {
            System.out.println("Estado: Finalizada");
            System.out.println("Fecha y hora de inicio: " + super.getStartDate());
            System.out.println("Fecha y hora de finalización: " + super.getEndDate());
            System.out.println("Parámetros de calidad obtenidos:");
            for (int i = 0; i < parameterList.getSize(); i++) {
                System.out.println(parameterList.getItem(i).getName() + ": " + parameterList.getItem(i).getValue());
            }
        } else {
            System.out.println("Estado: Sin iniciar");
        }
        System.out.println("Descripción: " + super.getDescription());
    }

    public int getStageNumber() {
        return stageNumber;
    }

    public MyArrayList<Parameter> getParameterList() {
        return parameterList;
    }

    @Override
    public String getDescription() {
        return super.getDescription(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getStartDate() {
        return super.getStartDate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        String A = "0";
        if (super.isActive()) {
            A = "1";
        }
        String B = "0";
        if (super.isFinished()) {
            B = "1";
        }

        return (getName() + ";" + getId() + ";" + getStartDate() + ";" + super.getEndDate() + ";" + getDescription() + ";" + getStageNumber() + ";" + A + ";" + B);
    }

    public void setStageNumber(int stageNumber) {
        this.stageNumber = stageNumber;
    }

    public void setParameterList(MyArrayList<Parameter> parameterList) {
        this.parameterList = parameterList;
    }

}

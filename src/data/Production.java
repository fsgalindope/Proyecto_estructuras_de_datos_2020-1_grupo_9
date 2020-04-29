package data;

import Estructuras_de_datos.*;

import static data.DataBase.myArrayListProduction;
import static graphicInterface.Proyecto_2020.scanner;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Production extends Event {

    private MyArrayList<RawMaterial> rawMaterials;
    private MyArrayList<Stage> stages;
    private int currentStage = 0;

    public Production(String name, String description, MyArrayList<RawMaterial> rawMaterials,
                      MyArrayList<Stage> stages) {
        super(name, description);
        this.rawMaterials = rawMaterials;
        this.stages = stages;
    }


    public int getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(int currentStage) {
        this.currentStage = currentStage;
    }

    public Production() {
        System.out.println("**********************  ASISTENTE DE CREACIÓN DE PRODUCCIÓN  ***********************");
        System.out.println("Bienvenido, aquí podrá crear su producción. Para ello puede seleccionar las materias " +
                "primas que desee usar y puede dividir su producción en etapas con sus respectivos parámetros de " +
                "calidad. A continuación, siga las instrucciones dadas");
        System.out.println("Ingrese el nombre de la producción:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Nombre: " + name);
        System.out.println("Ingrese una descripción para la producción:");
        String description = scanner.nextLine();
        System.out.println("Descripción: " + description);
        System.out.println("Cree las materias primas que va a emplear.");
        MyArrayList<RawMaterial> rawMaterials = new MyArrayList<>();
        RawMaterial rawMaterial = new RawMaterial();
        rawMaterials.pushBack(rawMaterial);
        boolean createMaterial = true;
        while (createMaterial) {
            System.out.println("¿Desea agregar más materiales al proceso?");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Si")) {
                rawMaterial = new RawMaterial();
                rawMaterials.pushBack(rawMaterial);
            } else if (answer.equalsIgnoreCase("No")) {
                System.out.println("Creación de materiales finalizada.");
                createMaterial = false;
            } else {
                System.out.println("Entrada no válida. Intente de nuevo.");
            }
        }
        System.out.println("Cree etapas de producción:");
        MyArrayList<Stage> processStages = new MyArrayList<>();
        Stage stage = new Stage(1);
        processStages.pushBack(stage);
        boolean createStage = true;
        while (createStage) {
            System.out.println("¿Desea agregar más etapas al proceso?");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Si")) {
                stage = new Stage(processStages.getSize() + 1);
                processStages.pushBack(stage);
            } else if (answer.equalsIgnoreCase("No")) {
                System.out.println("Creación de etapas finalizadas.");
                createStage = false;
            } else {
                System.out.println("Entrada no válida. Intente de nuevo.");
            }
        }
        super.setName(name);
        super.setDescription(description);
        this.stages = processStages;
        this.rawMaterials = rawMaterials;
//        //Opcional mientras se pide los materiales - Falta menu de materiales
//        ArrayQueue<RawMaterial> materiales=new ArrayQueue<RawMaterial>();// Para poder guardar el elemento completo
//        RawMaterial rawMaterial= new RawMaterial("Sin información","Sin información","Sin información","Sin información","Sin información",processStages.getItem(0).getParameterList());
//        materiales.enqueue(rawMaterial);
//        this.rawMaterials = materiales; 
//        //        
        System.out.println("Se creó la producción '" + name + "' con " + processStages.getSize() + " etapas.");
        super.setStartDate("Noiniciado");
        super.setEndDate("Nofinalizado");
        super.setIsActive(false);
        super.setIsFinished(false);

    }

    public void start() {
        if (!isFinished()) {
            super.setIsActive(true);
            super.setIsFinished(false);
            currentStage = 1;
            System.out.println("Se inició la producción '" + super.getName() + "'");
            super.setStartDate(super.getTimeFormat().format(LocalDateTime.now()));
            System.out.println("Fecha de inicio: " + super.getStartDate());
            stages.getItem(0).start();
        } else {
            System.out.println("La producción no se puede empezar pues ya ha finalizado");
        }
    }

    public void nextStage() {
        int auxCurrentStage = currentStage;
        endCurrentStage();
        if (currentStage > stages.getSize()) {
            finish();
        } else {
            if (auxCurrentStage != currentStage) {
                startCurrentStage();
            }
        }
    }

    public void endCurrentStage() {
        stages.getItem(currentStage - 1).setParameters();
        stages.getItem(currentStage - 1).finish();
        if (stages.getItem(currentStage - 1).isFinished()) {
            currentStage++;
        } else {
            System.out.println("Por favor, revise y emprenda acciones en su producción " +
                    "para cumplir con los estándares de calidad, tome nuevos datos e intente de nuevo.");
        }
    }

    public void startCurrentStage() {
        stages.getItem(currentStage - 1).start();
    }

    public void finish() {
        boolean allStagesFinished = true;
        for (int i = 0; i < stages.getSize() && allStagesFinished; i++) {
            allStagesFinished = stages.getItem(i).isFinished();
        }
        if (allStagesFinished) {
            super.setIsActive(false);
            super.setIsFinished(true);
            System.out.println("¡Felicitaciones! Se ha finalizado" +
                    " el proceso cumpliendo todos los parámetros de calidad.");
            System.out.println("¡Los clientes estarán muy satisfechos con su producto!");
        } else {
            System.out.println("Hay etapas que no se han finalizado, " +
                    "por favor revíselas antes de intentar finalizar la producción nuevamente.");
        }
    }


    public void printBasicSummary() {
        System.out.println(super.getName());
        if (super.isActive()) {
            System.out.println("Estado actual: Etapa " + currentStage + " de " + stages.getSize());
        } else if (super.isFinished()) {
            System.out.println("Estado: Finalizada");
        } else {
            System.out.println("Estado: Sin iniciar");
        }
    }

    public void printSummary() {
        System.out.println("########## RESUMEN DE LA PRODUCCIÓN ##########");
        System.out.println("Nombre: " + super.getName());
        if (super.isActive()) {
            System.out.println("Estado: Activa");
            System.out.println("Fecha y hora de inicio: " + super.getStartDate());
            System.out.println("Avance: Etapa " + currentStage + " de " + stages.getSize());
        } else if (super.isFinished()) {
            System.out.println("Estado: Finalizada");
            System.out.println("Fecha y hora de inicio: " + super.getStartDate());
            System.out.println("Fecha y hora de finalización: " + super.getEndDate());
        } else {
            System.out.println("Estado: Sin iniciar");
        }
        System.out.println("Descripción: " + super.getDescription());
        for (int i = 0; i < stages.getSize(); i++) {
            System.out.println("----------- ETAPA " + (i + 1) + " -----------");
            stages.getItem(i).printSummary();
        }
        System.out.println("##############################################");
    }

    public void print(int index) {
        System.out.println("############################ REGISTRO DE LA PRODUCCIÓN ############################\n");
        System.out.print("NOMBRE: " + super.getName() + "     ");
        System.out.print("FECHA DE INICIO: " + super.getStartDate() + "     ");
        Boolean f = myArrayListProduction.getItem(index).isIsFinished();
        if (f) {
            System.out.print("ESTADO: Finalizado" + "\n");
        } else if (myArrayListProduction.getItem(index).isActive()) {
            System.out.print("ESTADO: Activo" + "\n");
        } else {
            System.out.print("ESTADO: No iniciado" + "\n");
        }
        System.out.print("DESCRIPCIÓN: " + super.getDescription() + "\n\n");

        System.out.print("------------------------------------ MATERIALES ------------------------------------\n\n");
        int i = 0;
        while (i < rawMaterials.getSize()) { //arreglar es cabeza no cola

            System.out.print((i + 1) + " NOMBRE DEL MATERIAL: " + rawMaterials.getItem(i).getName() + "     ");
            System.out.print("FECHA DE COMPRA: " + rawMaterials.getItem(i).getAdmissionDate() + "     ");
            System.out.print("FECHA DE VENCIMIENTO: " + rawMaterials.getItem(i).getExpirationDate() + " \n  ");
            System.out.print("DESCRIPCIÓN: " + rawMaterials.getItem(i).getDescription() + "\n ");
            //bfwriter.write("Batch: "+myArrayListProduction.getItem(index).getRawMaterials().getHead().getBatch()+"\n ");

            System.out.print("                       ---------- PARÁMETROS ----------\n");
            for (int j = 0; j < rawMaterials.getItem(i).getParametrosCalidad().getSize(); j++) {
                System.out.print(String.valueOf(j + 1) + " NOMBRE DEL PARÁMETRO: " + rawMaterials.getItem(i).getParametrosCalidad().getItem(j).getName() + "\n  ");

                //bfwriter.write("Valor del paramtero: "+myArrayListProduction.getItem(index).getRawMaterials().getHead().getAdmissionDate()+"  ");
                System.out.print("LÍMITE INFERIOR DEL PARÁMETRO: " + rawMaterials.getItem(i).getParametrosCalidad().getItem(j).getLowerLimit() + "\n  ");

                System.out.print("LÍMITE SUPERIOR DEL PARÁMETRO: " + rawMaterials.getItem(i).getParametrosCalidad().getItem(j).getUpperLimit() + "\n\n");

                //bfwriter.write("Batch: "+myArrayListProduction.getItem(index).getRawMaterials().getHead().getBatch()+"\n ");                                  
            }

            i++;
        }

        System.out.print("-------------------------------------- ETAPAS -------------------------------------\n");
        i = 0;
        while (i < stages.getSize()) {

            System.out.print(stages.getItem(i).getStageNumber() + " NOMBRE DE LA ETAPA: " + stages.getItem(i).getName() + "          ");
            System.out.print("FECHA DE INICIO: " + stages.getItem(i).getStartDate() + "\n");
            System.out.print("FECHA DE FINAL: " + stages.getItem(i).getEndDate() + " \n  ");
            System.out.print("DESCRIPCIÓN: " + stages.getItem(i).getDescription() + "\n ");
            //bfwriter.write("Batch: "+myArrayListProduction.getItem(index).getRawMaterials().getHead().getBatch()+"\n ");

            System.out.print("                       ---------- PARÁMETROS ----------\n");
            for (int j = 0; j < stages.getItem(i).getParameterList().getSize(); j++) {
                System.out.print(String.valueOf(j + 1) + " NOMBRE DEL PARÁMETRO: " + stages.getItem(i).getParameterList().getItem(j).getName() + "\n  ");
                System.out.print("VALOR OBTENIDO: " + stages.getItem(i).getParameterList().getItem(j).getValue() + "  ");
                System.out.print("LÍMITE INFERIOR DEL PARÁMETRO: " + stages.getItem(i).getParameterList().getItem(j).getLowerLimit() + "\n  ");
                System.out.print("LÍMITE SUPERIOR DEL PARÁMETRO: " + stages.getItem(i).getParameterList().getItem(j).getUpperLimit() + "\n\n");
                //bfwriter.write("Batch: "+myArrayListProduction.getItem(index).getRawMaterials().getHead().getBatch()+"\n ");

            }
            System.out.print("-----------------------------------------------------------------------------------\n");
            i++;
        }
        System.out.println("###################################################################################");
    }

    public MyArrayList<RawMaterial> getRawMaterials() {
        return rawMaterials;
    }

    public MyArrayList<Stage> getStages() {
        return stages;
    }

    public void setRawMaterials(MyArrayList<RawMaterial> rawMaterials) {
        this.rawMaterials = rawMaterials;
    }

    public void setStages(MyArrayList<Stage> stages) {
        this.stages = stages;
    }


    @Override
    public String toString() {
        return (getName() + ";" + getDescription());
    }

}